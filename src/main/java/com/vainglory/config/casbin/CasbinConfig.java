package com.vainglory.config.casbin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vainglory.constant.Constants;
import com.vainglory.domain.Api;
import com.vainglory.domain.Role;
import com.vainglory.mapper.ApiMapper;
import com.vainglory.mapper.RoleMapper;
import com.vainglory.service.IRoleService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import java.util.Map;
import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class CasbinConfig {

  private final Enforcer enforcer;
  private final RequestMappingHandlerMapping handlerMapping;
  private final IRoleService roleService;
  private final RoleMapper roleMapper;
  private final ApiMapper apiMapper;

  @PostConstruct
  public void initCasbinPolicy() {

    // 1. 扫描所有Controller的API并保存到数据库
    Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();
    for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethods.entrySet()) {
      RequestMappingInfo mappingInfo = entry.getKey();
      HandlerMethod handlerMethod = entry.getValue();

      // 获取API路径
      Set<String> patterns = mappingInfo.getPatternValues();
      for (String pattern : patterns) {
        // 创建API对象
        Api api = new Api();
        // 获取接口方法名
        String methodName = handlerMethod.getMethod().getName();
        // 获取所属 Controller 类名
        String controllerName = handlerMethod.getBeanType().getSimpleName();
        // 检查是否以 "Controller" 结尾
        if (controllerName != null && controllerName.endsWith("Controller")) {
          // 去掉 "Controller" 后缀
          controllerName = controllerName.substring(0, controllerName.length() - "Controller".length());
        }

        // 处理成驼峰命名
        if (controllerName != null && !controllerName.isEmpty()) {
          // 将首字母转换为小写
          controllerName = controllerName.substring(0, 1).toLowerCase() + controllerName.substring(1);
        }

        // 切换 /xxx/{id} 为 /xxx/:id
        String path = pattern.replaceAll("\\{([^\\}]+)\\}", ":$1");

        // 获取接口描述（通过注解解析）
        String description = methodName;

        // 获取HTTP方法
        Set<RequestMethod> httpMethods = mappingInfo.getMethodsCondition().getMethods();
        String httpMethod = httpMethods.isEmpty() ? "GET" : httpMethods.iterator().next().name();

        api.setName(methodName);
        api.setMethod(httpMethod);
        api.setDescription(description);
        api.setAccess(Constants.API_ACCESS_PUBLIC);
        api.setEntity(controllerName);
        api.setPath(path);
        api.setStatus(Constants.STATUS_ENABLE);

        QueryWrapper<Api> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("method", httpMethod).eq("path", path);
        List<Api> apis = apiMapper.selectList(queryWrapper);
        if (apis.isEmpty()) {
          apiMapper.insert(api);
        } else if (apis.size() == 1){
          api.setId(apis.get(0).getId());
          apiMapper.updateById(api);
        }
      }
    }


    // 2. 获取所有角色
    List<Role> roles = roleService.list();

    // 3. 为每个角色注册其对应的API权限
//        for (Role role : roles) {
//            // 获取角色对应的API列表
//            List<String> apiPaths = roleMapper.getApiPathsByRoleId(role.getId());
//            String tenantId = role.getTenantId(); // 获取租户ID作为domain
//
//            // 遍历API路径，添加policy
//            for (String apiPath : apiPaths) {
//                // 添加RBAC policy: role, tenant(domain), api_path, method
//                enforcer.addPolicy(role.getKey(), tenantId, apiPath, "*");
//            }
//        }
  }
}
