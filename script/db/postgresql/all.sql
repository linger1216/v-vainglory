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
  delete_time timestamp(6)
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
  delete_time timestamp(6)
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
  delete_time   timestamp(6)
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
  delete_time timestamp(6)
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
  delete_time    timestamp(6)
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


-- 内置
-- 用户超管
truncate table t_user;
insert into t_user(id, avatar, nickname, username, description, password, salt, email, phone, address, status, tenant_id, create_dept,
                   create_by, update_by, version, create_time, update_time, delete_time)
values ('user:0', 'http://avatar.png', 'lid', 'admin', '系统的内置管理用户',
        '123456', '12345', 'eg@mail.com', '', '上海静安区', 1, 'tenant:0', 'dept:0', 'user:0', 'user:0', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null);

-- 根部门
truncate table t_dept;
insert into t_dept(id, name, description, parent_id, ancestors, leader_id, email, phone, sort, status, tenant_id, create_dept, create_by, update_by, version, create_time, update_time, delete_time)
values ('dept:0', '根部门', '虚拟的部门', null, null, 'user:0', 'eg@mail.com', '', 1, 1, 'tenant:0', 'dept:0', 'user:0', 'user:0', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null);

-- 根租户
truncate table t_tenant;
insert into t_tenant(id, name, description, contact_name, contact_phone, license_number, address, domain, plan_id, expire_time, account_count, tenant_id, status, create_dept, create_by, update_by, version, create_time, update_time, delete_time)
values ('tenant:0', '根公司', '虚拟的根公司', 'lid', '', null, '上海静安区', null, 'plan:0', '9999-12-12 00:00:00', -1, 'tenant:0', 1, 'dept:0', 'user:0', 'user:0', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null);

-- 角色
truncate table t_role;
insert into t_role(id, name, description, key, sort, data_scope, status, tenant_id, create_dept, create_by, update_by, version, create_time, update_time, delete_time)
values ('role:0', '超级管理员', '超级管理员', 'admin', 1, '1', 1, 'tenant:0', 'dept:0', 'user:0', 'user:0', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null);

-- 岗位
truncate table t_post;
insert into t_post(id, name, description, dept_id, sort, status, tenant_id, create_dept, create_by, update_by, version, create_time, update_time, delete_time)
values ('post:0', '超管', '超级管理员', 'dept:0', 1, 1, 'tenant:0', 'dept:0', 'user:0', 'user:0', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null);


-- 应用测试
-- 浦东新区 dept:100 tenant:100  陈近南:user:100
-- 张江 dept:100101 张三江:user:100101
-- 田园路居委会 dept:100101001 赵田园:user:100101001
-- 孙桥路居委会 dept:100101002 孙桥:user:100101002
-- 北蔡 dept:100102 李北蔡:user:100102
-- 虹南居委会  dept:100102001  钱虹南:user:100102001
-- 香花居委会  dept:100102002  周香花:user:100102002
-- 陆家嘴 dept:100103 王家嘴:user:100103
-- 梅园一村居委会 dept:100103001 吴梅园:user:100103001
-- 福山居委会    dept:100103002 郑福山:user:100103002

-- 租户
insert into t_tenant(id, name, description, contact_name, contact_phone, license_number, address, domain, plan_id, expire_time, account_count, tenant_id, status, create_dept, create_by, update_by, version, create_time, update_time, delete_time)
values ('tenant:100', '浦东新区', '浦东新区全部委办', '陈近南', '', null, '浦东新区', null, 'plan:0', '2049-12-12 00:00:00', -1, 'tenant:0', 1, 'dept:0', 'user:0', 'user:0', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null);

-- 部门
insert into t_dept(id, name, description, parent_id, ancestors, leader_id, email, phone, sort, status, tenant_id, create_dept, create_by, update_by, version, create_time, update_time, delete_time)
values ('dept:100', '浦东新区', '浦东新区', null, null, 'user:100', 'eg@mail.com', '', 1, 1, 'tenant:100', 'dept:100', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('dept:100101', '浦东新区张江', '浦东新区张江', 'dept:100', 'dept:100', 'user:100101', 'eg@mail.com', '', 1, 1, 'tenant:100', 'dept:100101', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('dept:100101001', '浦东新区张江田园路居委会', '浦东新区张江田园路居委会', 'dept:100101', 'dept:100,dept:100101', 'user:100101001', 'eg@mail.com', '', 1, 1, 'tenant:100', 'dept:100101001', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('dept:100101002', '浦东新区张江孙桥路居委会', '浦东新区张江孙桥路居委会', 'dept:100101', 'dept:100,dept:100101', 'user:100101002', 'eg@mail.com', '', 1, 1, 'tenant:100', 'dept:100101002', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),

       ('dept:100102', '浦东新区北蔡', '浦东新区北蔡', 'dept:100', 'dept:100', 'user:100102', 'eg@mail.com', '', 1, 1, 'tenant:100', 'dept:100102', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('dept:100102001', '浦东新区北蔡虹南居委会', '浦东新区北蔡虹南居委会', 'dept:100102', 'dept:100,dept:100102', 'user:100102001', 'eg@mail.com', '', 1, 1, 'tenant:100', 'dept:100102001', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('dept:100102002', '浦东新区北蔡香花居委会', '浦东新区北蔡香花居委会', 'dept:100102', 'dept:100,dept:100102', 'user:100102002', 'eg@mail.com', '', 1, 1, 'tenant:100', 'dept:100102002', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),


       ('dept:100103', '浦东新区陆家嘴', '浦东新区陆家嘴', 'dept:100', 'dept:100', 'user:100103', 'eg@mail.com', '', 1, 1, 'tenant:100', 'dept:100103', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('dept:100103001', '浦东新区田陆家嘴梅园一村居委会', '浦东新区田陆家嘴梅园一村居委会', 'dept:100103', 'dept:100,dept:100103', 'user:100103001', 'eg@mail.com', '', 1, 1, 'tenant:100', 'dept:100103001', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('dept:100103002', '浦东新区田陆家嘴福山居委会', '浦东新区田陆家嘴福山居委会', 'dept:100103', 'dept:100,dept:100103', 'user:100103002', 'eg@mail.com', '', 1, 1, 'tenant:100', 'dept:100103002', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null);


-- 用户
insert into t_user(id, avatar, nickname, username, description, password, salt, email, phone, address, status, tenant_id, create_dept,
                   create_by, update_by, version, create_time, update_time, delete_time)
values ('user:100', 'http://avatar.png', '陈近南', '陈近南', '浦东新区',
        '123456', '12345', 'eg@mail.com', '', '', 1, 'tenant:100', 'dept:100', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),

       ('user:100101', 'http://avatar.png', '张三江', '张三江', '浦东新区张江',
        '123456', '12345', 'eg@mail.com', '', '', 1, 'tenant:100', 'dept:100101', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('user:100101001', 'http://avatar.png', '赵田园', '赵田园', '浦东新区张江田园路居委会',
        '123456', '12345', 'eg@mail.com', '', '', 1, 'tenant:100', 'dept:100101001', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('user:100101002', 'http://avatar.png', '孙桥', '孙桥', '浦东新区张江孙桥',
        '123456', '12345', 'eg@mail.com', '', '', 1, 'tenant:100', 'dept:100101002', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),


       ('user:100102', 'http://avatar.png', '李北蔡', '李北蔡', '浦东新区北蔡',
        '123456', '12345', 'eg@mail.com', '', '', 1, 'tenant:100', 'dept:100102', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('user:100102001', 'http://avatar.png', '钱虹南', '钱虹南', '浦东新区北蔡虹南居委会',
        '123456', '12345', 'eg@mail.com', '', '', 1, 'tenant:100', 'dept:100102001', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('user:100102002', 'http://avatar.png', '周香花', '周香花', '浦东新区北蔡香花居委会',
        '123456', '12345', 'eg@mail.com', '', '', 1, 'tenant:100', 'dept:100102002', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),


       ('user:100103', 'http://avatar.png', '王家嘴', '王家嘴', '浦东新区陆家嘴',
        '123456', '12345', 'eg@mail.com', '', '', 1, 'tenant:100', 'dept:100103', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('user:100103001', 'http://avatar.png', '吴梅园', '吴梅园', '浦东新区陆家嘴梅园一村居委会',
        '123456', '12345', 'eg@mail.com', '', '', 1, 'tenant:100', 'dept:100103001', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null),
       ('user:100103002', 'http://avatar.png', '郑福山', '郑福山', '浦东新区陆家嘴福山居委会',
        '123456', '12345', 'eg@mail.com', '', '', 1, 'tenant:100', 'dept:100103002', 'user:100', 'user:100', 1,
        '2024-12-12 00:00:00', '2024-12-12 00:00:00', null);


