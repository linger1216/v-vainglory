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

 Date: 03/02/2025 23:44:54
*/


-- ----------------------------
-- Table structure for t_post
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_post";
CREATE TABLE "public"."t_post" (
  "id" text COLLATE "pg_catalog"."default" NOT NULL,
  "name" text COLLATE "pg_catalog"."default",
  "description" text COLLATE "pg_catalog"."default",
  "dept_id" text COLLATE "pg_catalog"."default",
  "sort" int2,
  "status" int2,
  "create_by" text COLLATE "pg_catalog"."default",
  "update_by" text COLLATE "pg_catalog"."default",
  "version" int4,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "delete_time" timestamp(6)
)
;
ALTER TABLE "public"."t_post" OWNER TO "postgres";
COMMENT ON COLUMN "public"."t_post"."id" IS 'id';
COMMENT ON COLUMN "public"."t_post"."name" IS '名称';
COMMENT ON COLUMN "public"."t_post"."description" IS '描述';
COMMENT ON COLUMN "public"."t_post"."dept_id" IS '所属部门';
COMMENT ON COLUMN "public"."t_post"."sort" IS '排序规则';
COMMENT ON COLUMN "public"."t_post"."status" IS '状态: 1正常 0禁用';
COMMENT ON COLUMN "public"."t_post"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."t_post"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."t_post"."version" IS '版本';
COMMENT ON COLUMN "public"."t_post"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_post"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."t_post"."delete_time" IS '删除时间';

-- ----------------------------
-- Primary Key structure for table t_post
-- ----------------------------
ALTER TABLE "public"."t_post" ADD CONSTRAINT "t_post_pkey" PRIMARY KEY ("id");
