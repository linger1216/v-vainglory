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

 Date: 28/01/2025 15:22:03
*/


-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_dept";
CREATE TABLE "public"."t_dept" (
                                   "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
                                   "avatar" varchar(255) COLLATE "pg_catalog"."default",
                                   "nickname" varchar(255) COLLATE "pg_catalog"."default",
                                   "username" varchar(255) COLLATE "pg_catalog"."default",
                                   "password" varchar(255) COLLATE "pg_catalog"."default",
                                   "salt" varchar(255) COLLATE "pg_catalog"."default",
                                   "email" varchar(255) COLLATE "pg_catalog"."default",
                                   "phone" varchar(255) COLLATE "pg_catalog"."default",
                                   "address" varchar(255) COLLATE "pg_catalog"."default",
                                   "dept_id" varchar(255) COLLATE "pg_catalog"."default",
                                   "role_id" varchar(255) COLLATE "pg_catalog"."default",
                                   "post_id" varchar(255) COLLATE "pg_catalog"."default",
                                   "status" int2,
                                   "created_by" varchar(255) COLLATE "pg_catalog"."default",
                                   "updated_by" varchar(255) COLLATE "pg_catalog"."default",
                                   "version" int4,
                                   "created_at" timestamptz(6),
                                   "updated_at" timestamptz(6),
                                   "deleted_at" timestamptz(6)
)
;
ALTER TABLE "public"."t_dept" OWNER TO "postgres";
COMMENT ON COLUMN "public"."t_dept"."id" IS 'id';
COMMENT ON COLUMN "public"."t_dept"."avatar" IS '头像';
COMMENT ON COLUMN "public"."t_dept"."nickname" IS '昵称';
COMMENT ON COLUMN "public"."t_dept"."username" IS '用户名';
COMMENT ON COLUMN "public"."t_dept"."password" IS '密码';
COMMENT ON COLUMN "public"."t_dept"."salt" IS '盐';
COMMENT ON COLUMN "public"."t_dept"."email" IS '电子邮件';
COMMENT ON COLUMN "public"."t_dept"."phone" IS '手机号';
COMMENT ON COLUMN "public"."t_dept"."address" IS '地址';
COMMENT ON COLUMN "public"."t_dept"."dept_id" IS '部门id';
COMMENT ON COLUMN "public"."t_dept"."role_id" IS '角色id';
COMMENT ON COLUMN "public"."t_dept"."post_id" IS '岗位id';
COMMENT ON COLUMN "public"."t_dept"."status" IS '状态: 1正常 2禁用';
COMMENT ON COLUMN "public"."t_dept"."created_by" IS '创建者';
COMMENT ON COLUMN "public"."t_dept"."updated_by" IS '更新者';
COMMENT ON COLUMN "public"."t_dept"."version" IS '版本';
COMMENT ON COLUMN "public"."t_dept"."created_at" IS '创建时间';
COMMENT ON COLUMN "public"."t_dept"."updated_at" IS '更新时间';
COMMENT ON COLUMN "public"."t_dept"."deleted_at" IS '删除时间';

-- ----------------------------
-- Primary Key structure for table t_dept
-- ----------------------------
ALTER TABLE "public"."t_dept" ADD CONSTRAINT "t_dept_pkey" PRIMARY KEY ("id");
