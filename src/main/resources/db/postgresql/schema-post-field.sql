/*
 Navicat Premium Dump SQL

 Source Server         : local-pg
 Source Server Type    : post_fieldgreSQL
 Source Server Version : 160004 (160004)
 Source Host           : localhost:5432
 Source Catalog        : lid
 Source Schema         : public

 Target Server Type    : post_fieldgreSQL
 Target Server Version : 160004 (160004)
 File Encoding         : 65001

 Date: 03/02/2025 23:44:54
*/


-- ----------------------------
-- Table structure for t_post_field
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_post_field";
CREATE TABLE "public"."t_post_field" (
  "id" text COLLATE "pg_catalog"."default" NOT NULL,
  "post_id" text COLLATE "pg_catalog"."default",
  "entity" text COLLATE "pg_catalog"."default",
  "entity_fields" text[] COLLATE "pg_catalog"."default",
  "status" int2,
  "create_by" text COLLATE "pg_catalog"."default",
  "update_by" text COLLATE "pg_catalog"."default",
  "version" int4,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "delete_time" timestamp(6)
)
;
ALTER TABLE "public"."t_post_field" OWNER TO "postgres";
COMMENT ON COLUMN "public"."t_post_field"."id" IS 'id';
COMMENT ON COLUMN "public"."t_post_field"."post_id" IS '岗位ID';
COMMENT ON COLUMN "public"."t_post_field"."entity" IS '对应实体表,无前缀';
COMMENT ON COLUMN "public"."t_post_field"."entity_fields" IS '对应实体表可见的字段';
COMMENT ON COLUMN "public"."t_post_field"."status" IS '状态: 1正常 0禁用';
COMMENT ON COLUMN "public"."t_post_field"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."t_post_field"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."t_post_field"."version" IS '版本';
COMMENT ON COLUMN "public"."t_post_field"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_post_field"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."t_post_field"."delete_time" IS '删除时间';

-- ----------------------------
-- Primary Key structure for table t_post_field
-- ----------------------------
ALTER TABLE "public"."t_post_field" ADD CONSTRAINT "t_post_field_pkey" PRIMARY KEY ("id");
