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
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_dept";
CREATE TABLE "public"."t_dept" (
  "id" text COLLATE "pg_catalog"."default" NOT NULL,
  "name" text COLLATE "pg_catalog"."default",
  "description" text COLLATE "pg_catalog"."default",
  "parent_id" text COLLATE "pg_catalog"."default",
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
ALTER TABLE "public"."t_dept" OWNER TO "postgres";
COMMENT ON COLUMN "public"."t_dept"."id" IS 'id';
COMMENT ON COLUMN "public"."t_dept"."name" IS '名称';
COMMENT ON COLUMN "public"."t_dept"."description" IS '描述';
COMMENT ON COLUMN "public"."t_dept"."parent_id" IS '父ID,如果为空,则代表一级部门';
COMMENT ON COLUMN "public"."t_dept"."sort" IS '排序规则';
COMMENT ON COLUMN "public"."t_dept"."status" IS '状态: 1正常 0禁用';
COMMENT ON COLUMN "public"."t_dept"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."t_dept"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."t_dept"."version" IS '版本';
COMMENT ON COLUMN "public"."t_dept"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_dept"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."t_dept"."delete_time" IS '删除时间';

-- ----------------------------
-- Primary Key structure for table t_dept
-- ----------------------------
ALTER TABLE "public"."t_dept" ADD CONSTRAINT "t_dept_pkey" PRIMARY KEY ("id");
