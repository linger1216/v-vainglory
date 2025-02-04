/*
 Navicat Premium Dump SQL

 Source Server         : local-pg
 Source Server Type    : PostgreSQL
 Source Server Version : 160004 (160004)
 Source Host           : localhost:5432
 Source Catalog        : lid
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 160004 (160004)
 File Encoding         : 65001

 Date: 03/02/2025 22:36:31
*/


-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_user";
CREATE TABLE "public"."t_user" (
   "id" text COLLATE "pg_catalog"."default" NOT NULL,
   "avatar" text COLLATE "pg_catalog"."default",
   "nickname" text COLLATE "pg_catalog"."default",
   "username" text COLLATE "pg_catalog"."default",
   "password" text COLLATE "pg_catalog"."default",
   "salt" text COLLATE "pg_catalog"."default",
   "email" text COLLATE "pg_catalog"."default",
   "phone" text COLLATE "pg_catalog"."default",
   "address" text COLLATE "pg_catalog"."default",
   "dept_ids" text[] COLLATE "pg_catalog"."default",
   "role_ids" text[] COLLATE "pg_catalog"."default",
   "post_ids" text[] COLLATE "pg_catalog"."default",
   "status" int2,
   "create_by" text COLLATE "pg_catalog"."default",
   "update_by" text COLLATE "pg_catalog"."default",
   "version" int4,
   "create_time" timestamp(6),
   "update_time" timestamp(6),
   "delete_time" timestamp(6)
)
;
ALTER TABLE "public"."t_user" OWNER TO "postgres";
COMMENT ON COLUMN "public"."t_user"."id" IS 'id';
COMMENT ON COLUMN "public"."t_user"."avatar" IS '头像';
COMMENT ON COLUMN "public"."t_user"."nickname" IS '昵称';
COMMENT ON COLUMN "public"."t_user"."username" IS '用户名';
COMMENT ON COLUMN "public"."t_user"."password" IS '密码';
COMMENT ON COLUMN "public"."t_user"."salt" IS '盐';
COMMENT ON COLUMN "public"."t_user"."email" IS '电子邮件';
COMMENT ON COLUMN "public"."t_user"."phone" IS '手机号';
COMMENT ON COLUMN "public"."t_user"."address" IS '地址';
COMMENT ON COLUMN "public"."t_user"."dept_ids" IS '所属部门id';
COMMENT ON COLUMN "public"."t_user"."role_ids" IS '所属角色id';
COMMENT ON COLUMN "public"."t_user"."post_ids" IS '所属岗位id';
COMMENT ON COLUMN "public"."t_user"."status" IS '状态: 1正常 0禁用';
COMMENT ON COLUMN "public"."t_user"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."t_user"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."t_user"."version" IS '版本';
COMMENT ON COLUMN "public"."t_user"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_user"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."t_user"."delete_time" IS '删除时间';

-- ----------------------------
-- Primary Key structure for table t_user
-- ----------------------------
ALTER TABLE "public"."t_user" ADD CONSTRAINT "t_user_pkey" PRIMARY KEY ("id");
