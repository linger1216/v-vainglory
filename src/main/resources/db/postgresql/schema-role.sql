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
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_role";
CREATE TABLE "public"."t_role" (
  "id" text COLLATE "pg_catalog"."default" NOT NULL,
  "name" text COLLATE "pg_catalog"."default",
  "description" text COLLATE "pg_catalog"."default",
  "data_scope" int2,
  "status" int2,
  "create_by" text COLLATE "pg_catalog"."default",
  "update_by" text COLLATE "pg_catalog"."default",
  "version" int4,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "delete_time" timestamp(6)
)
;
ALTER TABLE "public"."t_role" OWNER TO "postgres";
COMMENT ON COLUMN "public"."t_role"."id" IS 'id';
COMMENT ON COLUMN "public"."t_role"."name" IS '名称';
COMMENT ON COLUMN "public"."t_role"."description" IS '名称';
COMMENT ON COLUMN "public"."t_role"."data_scope" IS '数据范围';
COMMENT ON COLUMN "public"."t_role"."status" IS '状态: 1正常 0禁用';
COMMENT ON COLUMN "public"."t_role"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."t_role"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."t_role"."version" IS '版本';
COMMENT ON COLUMN "public"."t_role"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_role"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."t_role"."delete_time" IS '删除时间';

-- ----------------------------
-- Primary Key structure for table t_role
-- ----------------------------
ALTER TABLE "public"."t_role" ADD CONSTRAINT "t_role_pkey" PRIMARY KEY ("id");
