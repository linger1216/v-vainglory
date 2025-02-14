drop table if exists t_api;
create table t_api
(
  id          text not null primary key,
  name        text,
  description text,
  method      text,
  path        text,
  access      smallint,
  entity      text,
  status      smallint,
  tenant_id   text,
  create_dept text,
  create_by   text,
  update_by   text,
  version     integer,
  create_time timestamp(6),
  update_time timestamp(6),
  delete_time timestamp(6),
  CONSTRAINT "idx_t_api_path_method_unique" UNIQUE ("method", "path")
);
comment on column t_api.id is 'id';
comment on column t_api.name is '名称';
comment on column t_api.description is '描述';
comment on column t_api.method is '方法';
comment on column t_api.path is '路径';
comment on column t_api.access is '是否鉴权: 1公开 0私有';
comment on column t_api.entity is '对应实体进行分组,不是那么严格';
comment on column t_api.status is '状态: 1正常 0禁用';
comment on column t_api.tenant_id is '租户id';
comment on column t_api.create_dept is '创建部门';
comment on column t_api.create_by is '创建者';
comment on column t_api.update_by is '更新者';
comment on column t_api.version is '版本';
comment on column t_api.create_time is '创建时间';
comment on column t_api.update_time is '更新时间';
comment on column t_api.delete_time is '删除时间';
alter table t_api owner to postgres;

drop table if exists t_dept;
create table t_dept
(
  id          text not null primary key,
  name        text,
  description text,
  parent_id   text,
  ancestors   text,
  leader_id   text,
  email       text,
  phone       text,
  sort        smallint,
  status      smallint,
  tenant_id   text,
  create_dept text,
  create_by   text,
  update_by   text,
  version     integer,
  create_time timestamp(6),
  update_time timestamp(6),
  delete_time timestamp(6)
);
comment on column t_dept.id is 'id';
comment on column t_dept.name is '名称';
comment on column t_dept.description is '描述';
comment on column t_dept.parent_id is '父id,如果为0根部门';
comment on column t_dept.ancestors is '祖级列表';
comment on column t_dept.leader_id is '负责人id';
comment on column t_dept.email is '电子邮件';
comment on column t_dept.phone is '手机号';
comment on column t_dept.sort is '排序规则';
comment on column t_dept.status is '状态: 1正常 0禁用';
comment on column t_dept.tenant_id is '租户id';
comment on column t_dept.create_dept is '创建部门';
comment on column t_dept.create_by is '创建者';
comment on column t_dept.update_by is '更新者';
comment on column t_dept.version is '版本';
comment on column t_dept.create_time is '创建时间';
comment on column t_dept.update_time is '更新时间';
comment on column t_dept.delete_time is '删除时间';
alter table t_dept owner to postgres;

drop table if exists t_menu;
create table t_menu
(
  id          text not null primary key,
  name        text,
  icon        text,
  component   text,
  path        text,
  query_param text,
  parent_id   text,
  keep_alive  smallint,
  is_external smallint,
  type        smallint,
  perms       text,
  sort        smallint,
  status      smallint,
  tenant_id   text,
  create_dept text,
  create_by   text,
  update_by   text,
  version     integer,
  create_time timestamp(6),
  update_time timestamp(6),
  delete_time timestamp(6),
  CONSTRAINT "idx_t_menu_component_unique" UNIQUE ("component"),
  CONSTRAINT "idx_t_menu_path_unique" UNIQUE ("component")
);
comment on column t_menu.id is 'id';
comment on column t_menu.name is '名称';
comment on column t_menu.icon is '图标';
comment on column t_menu.component is '对应前端组件';
comment on column t_menu.path is '路由地址';
comment on column t_menu.query_param is '路由参数';
comment on column t_menu.parent_id is '父id';
comment on column t_menu.keep_alive is '在前端是否缓存 1缓存 0不缓存';
comment on column t_menu.is_external is '是否为外链（1是 0否）';
comment on column t_menu.type is '菜单类型,0目录 1菜单 2按钮';
comment on column t_menu.perms is '权限标识';
comment on column t_menu.sort is '显示顺序';
alter table t_menu owner to postgres;

drop table if exists t_post;
create table t_post
(
  id          text not null primary key,
  name        text,
  description text,
  dept_id     text,
  sort        smallint,
  status      smallint,
  tenant_id   text,
  create_dept text,
  create_by   text,
  update_by   text,
  version     integer,
  create_time timestamp(6),
  update_time timestamp(6),
  delete_time timestamp(6)
);
comment on column t_post.id is 'id';
comment on column t_post.name is '名称';
comment on column t_post.description is '描述';
comment on column t_post.dept_id is '部门id';
comment on column t_post.sort is '显示顺序';
comment on column t_post.status is '状态: 1正常 0禁用';
comment on column t_post.tenant_id is '租户id';
comment on column t_post.create_dept is '创建部门';
comment on column t_post.create_by is '创建者';
comment on column t_post.update_by is '更新者';
comment on column t_post.version is '版本';
comment on column t_post.create_time is '创建时间';
comment on column t_post.update_time is '更新时间';
comment on column t_post.delete_time is '删除时间';
alter table t_post owner to postgres;

drop table if exists t_post_field;
create table t_post_field
(
  id            text not null
    primary key,
  post_id       text,
  entity        text,
  entity_fields text[],
  status        smallint,
  tenant_id     text,
  create_dept   text,
  create_by     text,
  update_by     text,
  version       integer,
  create_time   timestamp(6),
  update_time   timestamp(6),
  delete_time   timestamp(6),
  CONSTRAINT "idx_t_post_field_entity_unique" UNIQUE ("entity")
);
comment on column t_post_field.id is 'id';
comment on column t_post_field.post_id is '岗位id';
comment on column t_post_field.entity is '实体表名称,无前缀';
comment on column t_post_field.entity_fields is '对应实体表可见的字段';
comment on column t_post_field.status is '状态: 1正常 0禁用';
comment on column t_post_field.tenant_id is '租户id';
comment on column t_post_field.create_dept is '创建部门';
comment on column t_post_field.create_by is '创建者';
comment on column t_post_field.update_by is '更新者';
comment on column t_post_field.version is '版本';
comment on column t_post_field.create_time is '创建时间';
comment on column t_post_field.update_time is '更新时间';
comment on column t_post_field.delete_time is '删除时间';
alter table t_post_field owner to postgres;

drop table if exists t_role;
create table t_role
(
  id          text not null primary key,
  name        text,
  description text,
  key         text,
  sort        smallint,
  data_scope  smallint,
  tenant_id   text,
  status      smallint,
  create_dept text,
  create_by   text,
  update_by   text,
  version     integer,
  create_time timestamp(6),
  update_time timestamp(6),
  delete_time timestamp(6)
);
comment on column t_role.id is 'id';
comment on column t_role.name is '名称';
comment on column t_role.description is '名称';
comment on column t_role.key is '角色权限字符串';
comment on column t_role.sort is '显示顺序';
comment on column t_role.data_scope is '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限, 5: 本人权限）';
comment on column t_role.status is '状态: 1正常 0禁用';
comment on column t_role.tenant_id is '租户id';
comment on column t_role.create_by is '创建者';
comment on column t_role.update_by is '更新者';
comment on column t_role.version is '版本';
comment on column t_role.create_time is '创建时间';
comment on column t_role.update_time is '更新时间';
comment on column t_role.delete_time is '删除时间';
alter table t_role owner to postgres;

drop table if exists t_role_api;
create table t_role_api
(
  id          text not null primary key,
  role_id     text,
  api_id      text,
  status      smallint,
  tenant_id   text,
  create_dept text,
  create_by   text,
  update_by   text,
  version     integer,
  create_time timestamp(6),
  update_time timestamp(6),
  delete_time timestamp(6)
);
comment on column t_role_api.id is 'id';
comment on column t_role_api.role_id is '角色id';
comment on column t_role_api.api_id is 'APIid';
comment on column t_role_api.status is '状态: 1正常 0禁用';
comment on column t_role_api.tenant_id is '租户id';
comment on column t_role_api.create_dept is '创建部门';
comment on column t_role_api.create_by is '创建者';
comment on column t_role_api.update_by is '更新者';
comment on column t_role_api.version is '版本';
comment on column t_role_api.create_time is '创建时间';
comment on column t_role_api.update_time is '更新时间';
comment on column t_role_api.delete_time is '删除时间';
alter table t_role_api owner to postgres;

drop table if exists t_role_menu;
create table t_role_menu
(
  id          text not null primary key,
  role_id     text,
  menu_id     text,
  status      smallint,
  tenant_id   text,
  create_dept text,
  create_by   text,
  update_by   text,
  version     integer,
  create_time timestamp(6),
  update_time timestamp(6),
  delete_time timestamp(6)
);
comment on column t_role_menu.id is 'id';
comment on column t_role_menu.role_id is '角色id';
comment on column t_role_menu.menu_id is '菜单id';
comment on column t_role_menu.status is '状态: 1正常 0禁用';
comment on column t_role_menu.tenant_id is '租户id';
comment on column t_role_menu.create_dept is '创建部门';
comment on column t_role_menu.create_by is '创建者';
comment on column t_role_menu.update_by is '更新者';
comment on column t_role_menu.version is '版本';
comment on column t_role_menu.create_time is '创建时间';
comment on column t_role_menu.update_time is '更新时间';
comment on column t_role_menu.delete_time is '删除时间';
alter table t_role_menu owner to postgres;

drop table if exists t_role_user;
create table t_role_user
(
  id          text not null primary key,
  role_id     text,
  user_id     text,
  status      smallint,
  tenant_id   text,
  create_dept text,
  create_by   text,
  update_by   text,
  version     integer,
  create_time timestamp(6),
  update_time timestamp(6),
  delete_time timestamp(6)
);
comment on column t_role_user.id is 'id';
comment on column t_role_user.role_id is '角色id';
comment on column t_role_user.user_id is '用户id';
comment on column t_role_user.status is '状态: 1正常 0禁用';
comment on column t_role_user.tenant_id is '租户id';
comment on column t_role_user.create_dept is '创建部门';
comment on column t_role_user.create_by is '创建者';
comment on column t_role_user.update_by is '更新者';
comment on column t_role_user.version is '版本';
comment on column t_role_user.create_time is '创建时间';
comment on column t_role_user.update_time is '更新时间';
comment on column t_role_user.delete_time is '删除时间';
alter table t_role_user owner to postgres;
drop table if exists t_user;
create table t_user
(
  id          text not null primary key,
  avatar      text,
  nickname    text,
  username    text,
  description text,
  password    text,
  salt        text,
  email       text,
  phone       text,
  address     text,
  status      smallint,
  tenant_id   text,
  create_dept text,
  create_by   text,
  update_by   text,
  version     integer,
  create_time timestamp(6),
  update_time timestamp(6),
  delete_time timestamp(6),
  CONSTRAINT "idx_t_user_username_unique" UNIQUE ("username")
);
comment on column t_user.id is 'id';
comment on column t_user.avatar is '头像';
comment on column t_user.nickname is '昵称';
comment on column t_user.username is '用户名';
comment on column t_user.description is '用户描述';
comment on column t_user.password is '密码';
comment on column t_user.salt is '盐';
comment on column t_user.email is '电子邮件';
comment on column t_user.phone is '手机号';
comment on column t_user.address is '地址';
comment on column t_user.status is '状态: 1正常 0禁用';
comment on column t_user.tenant_id is '租户id';
comment on column t_user.create_dept is '创建部门';
comment on column t_user.create_by is '创建者';
comment on column t_user.update_by is '更新者';
comment on column t_user.version is '版本';
comment on column t_user.create_time is '创建时间';
comment on column t_user.update_time is '更新时间';
comment on column t_user.delete_time is '删除时间';
alter table t_user owner to postgres;



drop table if exists t_user_dept;
create table t_user_dept
(
  id          text not null primary key,
  user_id     text,
  dept_id     text,
  status      smallint,
  tenant_id   text,
  create_dept text,
  create_by   text,
  update_by   text,
  version     integer,
  create_time timestamp(6),
  update_time timestamp(6),
  delete_time timestamp(6)
);
comment on column t_user_dept.id is 'id';
comment on column t_user_dept.user_id is '用户id';
comment on column t_user_dept.dept_id is '部门id';
comment on column t_user_dept.status is '状态: 1正常 0禁用';
comment on column t_user_dept.tenant_id is '租户id';
comment on column t_user_dept.create_dept is '创建部门';
comment on column t_user_dept.create_by is '创建者';
comment on column t_user_dept.update_by is '更新者';
comment on column t_user_dept.version is '版本';
comment on column t_user_dept.create_time is '创建时间';
comment on column t_user_dept.update_time is '更新时间';
comment on column t_user_dept.delete_time is '删除时间';
alter table t_user_dept owner to postgres;

drop table if exists t_user_post;
create table t_user_post
(
  id          text not null primary key,
  user_id     text,
  post_id     text,
  status      smallint,
  tenant_id   text,
  create_post text,
  create_by   text,
  update_by   text,
  version     integer,
  create_time timestamp(6),
  update_time timestamp(6),
  delete_time timestamp(6)
);
comment on column t_user_post.id is 'id';
comment on column t_user_post.user_id is '用户id';
comment on column t_user_post.post_id is '岗位id';
comment on column t_user_post.status is '状态: 1正常 0禁用';
comment on column t_user_post.tenant_id is '租户id';
comment on column t_user_post.create_post is '创建部门';
comment on column t_user_post.create_by is '创建者';
comment on column t_user_post.update_by is '更新者';
comment on column t_user_post.version is '版本';
comment on column t_user_post.create_time is '创建时间';
comment on column t_user_post.update_time is '更新时间';
comment on column t_user_post.delete_time is '删除时间';
alter table t_user_post owner to postgres;



-- 租户
drop table if exists t_tenant;
create table t_tenant
(
  id             text not null primary key,
  name           text,
  description    text,
  contact_name   text,
  contact_phone  text,
  license_number text,
  address        text,
  domain         text,
  plan_id        text,
  expire_time    timestamp,
  account_count  integer,
  tenant_id      text,
  status         smallint,
  create_dept    text,
  create_by      text,
  update_by      text,
  version        integer,
  create_time    timestamp(6),
  update_time    timestamp(6),
  delete_time    timestamp(6),
  CONSTRAINT "idx_t_tenant_name_unique" UNIQUE ("name")
);
comment on column t_tenant.id is 'id';
comment on column t_tenant.name is '名称';
comment on column t_tenant.description is '名称';
comment on column t_tenant.contact_name is '联系人姓名';
comment on column t_tenant.contact_phone is '联系人手机';
comment on column t_tenant.license_number is '企业税号之类的,唯一标识码';
comment on column t_tenant.address is '租户地址';
comment on column t_tenant.domain is '域名';
comment on column t_tenant.plan_id is '租户套餐id';
comment on column t_tenant.expire_time is '租户过期时间';
comment on column t_tenant.account_count is '用户数量（-1不限制）';
comment on column t_tenant.status is '状态: 1正常 0禁用';
comment on column t_tenant.create_by is '创建者';
comment on column t_tenant.update_by is '更新者';
comment on column t_tenant.version is '版本';
comment on column t_tenant.create_time is '创建时间';
comment on column t_tenant.update_time is '更新时间';
comment on column t_tenant.delete_time is '删除时间';
alter table t_tenant owner to postgres;

-- 客户端
drop table if exists t_client;
create table t_client
(
    id             text not null primary key,
    key            text,
    secret         text,
    grant_type     text,
    device_type    text,
    timeout        integer,
    active_timeout integer,

    tenant_id      text,
    status         smallint,
    create_dept    text,
    create_by      text,
    update_by      text,
    version        integer,
    create_time    timestamp(6),
    update_time    timestamp(6),
    delete_time    timestamp(6),
    CONSTRAINT "idx_t_client_key_unique" UNIQUE ("key"),
    CONSTRAINT "idx_t_client_secret_unique" UNIQUE ("secret")
);
comment on column t_client.id is 'id';
comment on column t_client.key is '客户端key';
comment on column t_client.secret is '客户端密钥';
comment on column t_client.grant_type is '授权类型 password|sms|social|xcx|email';
comment on column t_client.device_type is '设备类型 pc, android, ios, device';
comment on column t_client.timeout is 'token 有效期（单位：秒） 默认30天，-1 代表永久有效';
comment on column t_client.active_timeout is 'token 最低活跃频率（单位：秒），如果 token 超过此时间没有访问系统就会被冻结，默认-1 代表不限制，永不冻结';

comment on column t_client.status is '状态: 1正常 0禁用';
comment on column t_client.create_by is '创建者';
comment on column t_client.update_by is '更新者';
comment on column t_client.version is '版本';
comment on column t_client.create_time is '创建时间';
comment on column t_client.update_time is '更新时间';
comment on column t_client.delete_time is '删除时间';
alter table t_client owner to postgres;



------------------------------------ 数据
-- 租户
truncate table t_tenant;
insert into t_tenant(id, name, description, contact_name, contact_phone, license_number, address, domain, plan_id, expire_time, account_count, tenant_id, status, create_dept, create_by, update_by, version, create_time, update_time, delete_time)
values
  ('tenant:pd', '浦东新区租户', '浦东新区全部委办', '沈老师', '13800138000', null,
   '浦东新区', null, 'plan:0', '2049-12-12 00:00:00',-1, null, 1, null, null, null, 1,
   '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('tenant:mh', '闵行租户', '闵行区全部委办', '朱老师', '13800138000', null,
   '闵行区', null, 'plan:0', '2049-12-12 00:00:00', -1, null, 1, null, null, null, 1,
   '2024-12-12 00:00:00', '2024-12-12 00:00:00', null);


truncate table t_user;
insert into t_user(id, avatar, nickname, username, description, password, salt, email, phone, address, status, tenant_id, create_dept,
                   create_by, update_by, version, create_time, update_time, delete_time)
values
  ('user:super:admin', null, '超管', 'lid_guan', '作者',
   '$2a$10$g37yq/A5Oms3/lqHMxp.TOF/hmeHBz3t4LkybcipXtjUMOFL1xfWu', '$2a$10$g37yq/A5Oms3/lqHMxp.TO',
   'lid.guan@mail.com', '13816532331', '上海静安区', 1, null, null, null, null, 1,
   '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),

  ('user:pd', null, '浦老师', '浦老师', '浦东新区委书记',
   '$2a$10$g37yq/A5Oms3/lqHMxp.TOF/hmeHBz3t4LkybcipXtjUMOFL1xfWu', '$2a$10$g37yq/A5Oms3/lqHMxp.TO', null, '',
   '', 1, 'tenant:pd', null, 'user:super:admin', 'user:super:admin', 1,
   '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),

  ('user:pd:zj', null, '张江镇镇长', '张江镇镇长', '浦东新区张江镇镇长',
   '$2a$10$g37yq/A5Oms3/lqHMxp.TOF/hmeHBz3t4LkybcipXtjUMOFL1xfWu', '$2a$10$g37yq/A5Oms3/lqHMxp.TO', null, '', '', 1, 'tenant:pd',
   'dept:pd', 'user:pd', 'user:pd', 1, '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('user:pd:zj:ty', null, '田园路居委书记', '田园路居委书记', '浦东新区张江镇田园路居委书记',
   '$2a$10$g37yq/A5Oms3/lqHMxp.TOF/hmeHBz3t4LkybcipXtjUMOFL1xfWu', '$2a$10$g37yq/A5Oms3/lqHMxp.TO', null, '', '', 1, 'tenant:pd',
   'dept:pd', 'user:pd', 'user:pd', 1,'2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('user:pd:zj:sq', null, '孙桥路居委书记', '孙桥路居委书记', '浦东新区张江镇孙桥路居委书记',
   '$2a$10$g37yq/A5Oms3/lqHMxp.TOF/hmeHBz3t4LkybcipXtjUMOFL1xfWu', '$2a$10$g37yq/A5Oms3/lqHMxp.TO', null, '', '', 1, 'tenant:pd',
   'dept:pd', 'user:pd', 'user:pd', 1,'2024-12-12 00:00:00', '2024-12-12 00:00:00', null),


  ('user:pd:bc', null, '北蔡镇镇长', '北蔡镇镇长', '浦东新区北蔡镇镇长',
   '$2a$10$g37yq/A5Oms3/lqHMxp.TOF/hmeHBz3t4LkybcipXtjUMOFL1xfWu', '$2a$10$g37yq/A5Oms3/lqHMxp.TO', null, '', '', 1, 'tenant:pd',
   'dept:pd', 'user:pd', 'user:pd', 1, '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('user:100102001', null, '钱虹南', '钱虹南', '浦东新区北蔡虹南居委会',
   '$2a$10$g37yq/A5Oms3/lqHMxp.TOF/hmeHBz3t4LkybcipXtjUMOFL1xfWu', '$2a$10$g37yq/A5Oms3/lqHMxp.TO', null, '', '', 1, 'tenant:pd',
   'dept:pd', 'user:pd', 'user:pd', 1, '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('user:100102002', null, '周香花', '周香花', '浦东新区北蔡香花居委会',
   '$2a$10$g37yq/A5Oms3/lqHMxp.TOF/hmeHBz3t4LkybcipXtjUMOFL1xfWu', '$2a$10$g37yq/A5Oms3/lqHMxp.TO', null, '', '', 1, 'tenant:pd',
   'dept:pd', 'user:pd', 'user:pd', 1,'2024-12-12 00:00:00', '2024-12-12 00:00:00', null),

  ('user:mh', null, '闵老师', '闵老师', '闵行区委书记',
   '$2a$10$g37yq/A5Oms3/lqHMxp.TOF/hmeHBz3t4LkybcipXtjUMOFL1xfWu', '$2a$10$g37yq/A5Oms3/lqHMxp.TO', null, '',
   '', 1, 'tenant:mh', null, 'user:super:admin', 'user:super:admin', 1,
   '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),

  ('user:mh:cg', null, '闵行区城市执法局局长', '闵行区城市执法局局长', '闵行区城市执法局局长',
   '$2a$10$g37yq/A5Oms3/lqHMxp.TOF/hmeHBz3t4LkybcipXtjUMOFL1xfWu', '$2a$10$g37yq/A5Oms3/lqHMxp.TO', null, '', '', 1, 'tenant:mh',
   'dept:mh', 'user:mh', 'user:mh', 1, '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('user:mh:cg:xt', null, '闵行区城市执法局协调科科长', '闵行区城市执法局协调科科长', '闵行区城市执法局协调科科长',
   '$2a$10$g37yq/A5Oms3/lqHMxp.TOF/hmeHBz3t4LkybcipXtjUMOFL1xfWu', '$2a$10$g37yq/A5Oms3/lqHMxp.TO', null, '', '', 1, 'tenant:mh',
   'dept:mh', 'user:mh', 'user:mh', 1,'2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('user:mh:cg:zf', null, '闵行区城市执法局执法科科长', '闵行区城市执法局执法科科长', '闵行区城市执法局执法科科长',
   '$2a$10$g37yq/A5Oms3/lqHMxp.TOF/hmeHBz3t4LkybcipXtjUMOFL1xfWu', '$2a$10$g37yq/A5Oms3/lqHMxp.TO', null, '', '', 1, 'tenant:mh',
   'dept:mh', 'user:mh', 'user:mh', 1,'2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('user:mh:cg:jd', null, '闵行区城市执法局监督科科长', '闵行区城市执法局监督科科长', '闵行区城市执法局监督科科长',
   '$2a$10$g37yq/A5Oms3/lqHMxp.TOF/hmeHBz3t4LkybcipXtjUMOFL1xfWu', '$2a$10$g37yq/A5Oms3/lqHMxp.TO', null, '', '', 1, 'tenant:mh',
   'dept:mh', 'user:mh', 'user:mh', 1,'2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('user:mh:cg:ts', null, '闵行区城市执法局投诉科科长', '闵行区城市执法局投诉科科长', '闵行区城市执法局投诉科科长',
   '$2a$10$g37yq/A5Oms3/lqHMxp.TOF/hmeHBz3t4LkybcipXtjUMOFL1xfWu', '$2a$10$g37yq/A5Oms3/lqHMxp.TO', null, '', '', 1, 'tenant:mh',
   'dept:mh', 'user:mh', 'user:mh', 1,'2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('user:mh:cg:dq', null, '闵行区城市执法局党群科科长', '闵行区城市执法局党群科科长', '闵行区城市执法局党群科科长',
   '$2a$10$g37yq/A5Oms3/lqHMxp.TOF/hmeHBz3t4LkybcipXtjUMOFL1xfWu', '$2a$10$g37yq/A5Oms3/lqHMxp.TO', null, '', '', 1, 'tenant:mh',
   'dept:mh', 'user:mh', 'user:mh', 1,'2024-12-12 00:00:00', '2024-12-12 00:00:00', null);



-- 部门
truncate table t_dept;
insert into t_dept(id, name, description, parent_id, ancestors, leader_id, email, phone, sort, status, tenant_id, create_dept, create_by, update_by, version, create_time, update_time, delete_time)
values
  ('dept:pd', '浦东新区', '浦东新区', null, null, 'user:pd', 'pd@email.com', '', 1, 1,
   'tenant:pd', 'dept:pd', 'user:pd', 'user:pd', 1,
   '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('dept:pd:zj', '浦东新区张江镇', '浦东新区张江镇', null, null, 'user:pd:zj', 'pd@email.com', '', 1, 1,
   'tenant:pd', 'dept:pd', 'user:pd', 'user:pd', 1,
   '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('dept:pd:zj:ty', '浦东新区张江镇田园路居委', '浦东新区张江镇田园路居委', null, null, 'user:pd:zj:ty', 'pd@email.com', '', 1, 1,
   'tenant:pd', 'dept:pd', 'user:pd', 'user:pd', 1,
   '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('dept:pd:zj:sq', '浦东新区张江镇孙桥路居委', '浦东新区张江镇孙桥路居委', null, null, 'user:pd:zj:sq', 'pd@email.com', '', 1, 1,
   'tenant:pd', 'dept:pd', 'user:pd', 'user:pd', 1,
   '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),


  ('dept:mh', '闵行区', '闵行区', null, null, 'user:mh', 'pd@email.com', '', 1, 1,
   'tenant:mh', 'dept:mh', 'user:mh', 'user:mh', 1,
   '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('dept:mh:cg', '闵行区城市执法局', '闵行区城市执法局', 'dept:mh', null, 'user:mh:cg', 'pd@email.com', '', 1, 1,
   'tenant:mh', 'dept:mh', 'user:mh', 'user:mh', 1,
   '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('dept:mh:cg:xt', '闵行区城市执法局协调科', '闵行区城市执法局协调科', 'dept:mh', null, 'user:mh:cg:xt', 'pd@email.com', '', 1, 1,
   'tenant:mh', 'dept:mh', 'user:mh', 'user:mh', 1,
   '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('dept:mh:cg:zf', '闵行区城市执法局执法科', '闵行区城市执法局执法科', 'dept:mh', null, 'user:mh:cg:zf', 'pd@email.com', '', 1, 1,
   'tenant:mh', 'dept:mh', 'user:mh', 'user:mh', 1,
   '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('dept:mh:cg:jd', '闵行区城市执法局监督科', '闵行区城市执法局监督科', 'dept:mh', null, 'user:mh:cg:jd', 'pd@email.com', '', 1, 1,
   'tenant:mh', 'dept:mh', 'user:mh', 'user:mh', 1,
   '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('dept:mh:cg:ts', '闵行区城市执法局投诉科', '闵行区城市执法局投诉科', 'dept:mh', null, 'user:mh:cg:ts', 'pd@email.com', '', 1, 1,
   'tenant:mh', 'dept:mh', 'user:mh', 'user:mh', 1,
   '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('dept:mh:cg:dq', '闵行区城市执法局党群科', '闵行区城市执法局党群科', 'dept:mh', null, 'user:mh:cg:dq', 'pd@email.com', '', 1, 1,
   'tenant:mh', 'dept:mh', 'user:mh', 'user:mh', 1,
   '2024-12-12 00:00:00', '2024-12-12 00:00:00', null);


-- 角色
truncate table t_role;
insert into t_role(id, name, description, key, sort, data_scope, status, tenant_id, create_dept, create_by, update_by, version, create_time, update_time, delete_time)
values ('role:super:admin', '超级管理员', '超级管理员', 'admin', 1, '1', 1,
        null, null, null, null, 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('role:pd:admin', '浦东管理员', '浦东管理员', 'pd:admin', 1, '1', 1,
        'tenant:pd', null, 'user:super:admin', 'user:super:admin', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('role:mh:admin', '闵行管理员', '闵行管理员', 'mh:admin', 1, '1', 1,
        'tenant:mh', null, 'user:super:admin', 'user:super:admin', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null);

truncate table t_role_user;
insert into t_role_user(id, role_id, user_id, status, tenant_id, create_dept, create_by, update_by, version, create_time, update_time, delete_time)
values('role_user:0', 'role:super:admin', 'user:super:admin', 1, null, null,
       'user:super:admin', 'user:super:admin', 1,
       '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('role_user:1', 'role:pd:admin', 'user:pd', 1, 'tenant:pd', null,
        'user:super:admin', 'user:super:admin', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('role_user:2', 'role:mh:admin', 'user:mh', 1, 'tenant:mh', null,
        'user:super:admin', 'user:super:admin', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null);

-- 岗位
truncate table t_post;
insert into t_post(id, name, description, dept_id, sort, status, tenant_id, create_dept, create_by, update_by, version, create_time, update_time, delete_time)
values ('post:pd:dev', '研发', '研发', 'dept:pd', 1, 1,
        'tenant:pd', 'dept:pd', 'user:pd', 'user:pd', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('post:pd:sale', '销售', '销售', 'dept:pd', 1, 1,
        'tenant:pd', 'dept:pd', 'user:pd', 'user:pd', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('post:pd:manager', '经理', '经理', 'dept:pd', 1, 1,
        'tenant:pd', 'dept:pd', 'user:pd', 'user:pd', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),

       ('post:mh:dev', '研发', '研发', 'dept:mh', 1, 1,
        'tenant:mh', 'dept:mh', 'user:mh', 'user:mh', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('post:mh:sale', '销售', '销售', 'dept:mh', 1, 1,
        'tenant:mh', 'dept:mh', 'user:mh', 'user:mh', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('post:mh:manager', '经理', '经理', 'dept:mh', 1, 1,
        'tenant:mh', 'dept:mh', 'user:mh', 'user:mh', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null);

-- 应用
truncate table t_client;
insert into t_client(id, key, secret, grant_type, device_type, timeout, active_timeout, tenant_id, status, create_dept, create_by, update_by, version, create_time, update_time, delete_time)
values('client:super:admin', 'client:super:key', 'client:super:secret', 'password,sms,social', 'pc', 2592000, -1,
       null, 1, null, 'user:super:admin', 'user:super:admin', 1,
       '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
  ('client:pd:pc', 'client:pd:key', 'client:pd:secret', 'password,sms,social', 'pc', 2592000, -1,
        'tenant:pd', 1, null, 'user:super:admin', 'user:super:admin', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('client:mh:pc', 'client:mh:key', 'client:mh:secret', 'password,sms,social', 'pc', 2592000, -1,
        'tenant:mh', 1, null, 'user:super:admin', 'user:super:admin', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null);


-- 菜单
truncate table t_menu;
insert into t_menu(id, name, icon, component, path, query_param, parent_id, keep_alive, is_external, type, perms, sort, status,
                   tenant_id, create_dept, create_by, update_by, version, create_time, update_time, delete_time)
values ('menu:1', '系统管理', 'el-icon-setting', null, 'system', null, null, 1, 0, 0, null, 1,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
      '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),

       ('menu:1:1', '用户管理', 'el-icon-setting', null, 'system/user', null, 'menu:1', 1, 0, 1, null, 1,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('menu:1:2', '角色管理', 'el-icon-setting', null, 'system/role', null, 'menu:1', 1, 0, 1, null, 2,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('menu:1:3', '部门管理', 'el-icon-setting', null, 'system/dept', null, 'menu:1', 1, 0, 1, null, 3,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('menu:1:4', '字典管理', 'el-icon-setting', null, 'system/dict', null, 'menu:1', 1, 0, 1, null, 4,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('menu:1:5', '菜单管理', 'el-icon-setting', null, 'system/menu', null, 'menu:1', 1, 0, 1, null, 4,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('menu:1:6', '岗位管理', 'el-icon-setting', null, 'system/post', null, 'menu:1', 1, 0, 1, null, 4,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('menu:1:7', '参数管理', 'el-icon-setting', null, 'system/para', null, 'menu:1', 1, 0, 1, null, 4,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('menu:1:8', '日志管理', 'el-icon-setting', null, 'system/log', null, 'menu:1', 1, 0, 0, null, 4,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('menu:1:8:1', '登录日志', 'el-icon-setting', null, 'system/log/login', null, 'menu:1', 1, 0, 1, null, 4,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('menu:1:8:2', '操作日志', 'el-icon-setting', null, 'system/log/oper', null, 'menu:1', 1, 0, 1, null, 4,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('menu:1:9', '文件管理', 'el-icon-setting', null, 'system/file', null, 'menu:1', 1, 0, 1, null, 4,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('menu:1:10', '客户端管理', 'el-icon-setting', null, 'system/client', null, 'menu:1', 1, 0, 1, null, 4,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),

       ('menu:2', '租户管理', 'el-icon-setting', null, 'system/tenant', null, null, 1, 0, 0, null, 4,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('menu:2:1', '租户管理', 'el-icon-setting', null, 'system/tenant/tenant', null, 'menu:2', 1, 0, 1, null, 4,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('menu:2:2', '套餐管理', 'el-icon-setting', null, 'system/tenant/package', null, 'menu:2', 1, 0, 1, null, 4,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),

       ('menu:3', '系统监控', 'el-icon-setting', null, 'system/monitor', null, null, 1, 0, 0, null, 4,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('menu:3:1', '在线用户', 'el-icon-setting', null, 'system/monitor/online', null, 'menu:3', 1, 0, 1, null, 4,
        1, null, null, 'user:super:admin', 'user:super:admin',0,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null);


truncate table t_role_menu;
insert into t_role_menu values
('role_menu:1', 'role:super:admin', 'menu:1', 1, null, null, 'user:super:admin', 'user:super:admin',0, '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
('role_menu:2', 'role:super:admin', 'menu:1:1', 1, null, null, 'user:super:admin', 'user:super:admin',0,'2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
('role_menu:3', 'role:super:admin', 'menu:1:2', 1, null, null, 'user:super:admin', 'user:super:admin',0,'2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
('role_menu:4', 'role:super:admin', 'menu:1:3', 1, null, null, 'user:super:admin', 'user:super:admin',0,'2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
('role_menu:5', 'role:super:admin', 'menu:1:4', 1, null, null, 'user:super:admin', 'user:super:admin',0,'2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
('role_menu:6', 'role:super:admin', 'menu:1:5', 1, null, null, 'user:super:admin', 'user:super:admin',0,'2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
('role_menu:7', 'role:super:admin', 'menu:1:6', 1, null, null, 'user:super:admin', 'user:super:admin',0,'2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
('role_menu:8', 'role:super:admin', 'menu:1:7', 1, null, null, 'user:super:admin', 'user:super:admin',0,'2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
('role_menu:9', 'role:super:admin', 'menu:1:8', 1, null, null, 'user:super:admin', 'user:super:admin',0,'2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
('role_menu:10', 'role:super:admin', 'menu:1:8:1', 1, null, null, 'user:super:admin', 'user:super:admin',0,'2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
('role_menu:11', 'role:super:admin', 'menu:1:8:2', 1, null, null, 'user:super:admin', 'user:super:admin',0, '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
('role_menu:12', 'role:super:admin', 'menu:1:9', 1, null, null, 'user:super:admin', 'user:super:admin',0, '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
('role_menu:13', 'role:super:admin', 'menu:1:10', 1, null, null, 'user:super:admin', 'user:super:admin',0, '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
('role_menu:14', 'role:super:admin', 'menu:2', 1, null, null, 'user:super:admin', 'user:super:admin',0, '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
('role_menu:15', 'role:super:admin', 'menu:2:1', 1, null, null, 'user:super:admin', 'user:super:admin',0, '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
('role_menu:16', 'role:super:admin', 'menu:2:2', 1, null, null, 'user:super:admin', 'user:super:admin',0, '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
('role_menu:17', 'role:super:admin', 'menu:3', 1, null, null, 'user:super:admin', 'user:super:admin',0, '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
('role_menu:18', 'role:super:admin', 'menu:3:1', 1, null, null, 'user:super:admin', 'user:super:admin',0, '2024-12-12 00:00:00', '2024-12-12 00:00:00', null);


