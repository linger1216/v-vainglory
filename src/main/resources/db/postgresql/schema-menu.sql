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
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_menu";
CREATE TABLE "public"."t_menu" (
  "id" text COLLATE "pg_catalog"."default" NOT NULL,
  "name" text COLLATE "pg_catalog"."default",
  "icon" text COLLATE "pg_catalog"."default",
  "component" text COLLATE "pg_catalog"."default",
  "path" text COLLATE "pg_catalog"."default",
  "parent_id" text COLLATE "pg_catalog"."default",
  "keep_alive" int2,
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
ALTER TABLE "public"."t_menu" OWNER TO "postgres";
COMMENT ON COLUMN "public"."t_menu"."id" IS 'id';
COMMENT ON COLUMN "public"."t_menu"."name" IS '名称';
COMMENT ON COLUMN "public"."t_menu"."icon" IS '图标';
COMMENT ON COLUMN "public"."t_menu"."component" IS '对应前端组件';
COMMENT ON COLUMN "public"."t_menu"."path" IS 'url路径';
COMMENT ON COLUMN "public"."t_menu"."parent_id" IS '父ID,如果为空,则代表一级菜单';
COMMENT ON COLUMN "public"."t_menu"."keep_alive" IS '在前端是否保活 1正常 0禁用';
COMMENT ON COLUMN "public"."t_menu"."sort" IS '排序规则';
COMMENT ON COLUMN "public"."t_menu"."status" IS '状态: 1正常 0禁用';
COMMENT ON COLUMN "public"."t_menu"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."t_menu"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."t_menu"."version" IS '版本';
COMMENT ON COLUMN "public"."t_menu"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_menu"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."t_menu"."delete_time" IS '删除时间';

-- ----------------------------
-- Primary Key structure for table t_menu
-- ----------------------------
ALTER TABLE "public"."t_menu" ADD CONSTRAINT "t_menu_pkey" PRIMARY KEY ("id");
