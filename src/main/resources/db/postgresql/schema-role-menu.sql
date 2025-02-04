/*
 Navicat Premium Dump SQL

 Source Server         : local-pg
 Source Server Type    : role_menugreSQL
 Source Server Version : 160004 (160004)
 Source Host           : localhost:5432
 Source Catalog        : lid
 Source Schema         : public

 Target Server Type    : role_menugreSQL
 Target Server Version : 160004 (160004)
 File Encoding         : 65001

 Date: 03/02/2025 23:44:54
*/


-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_role_menu";
CREATE TABLE "public"."t_role_menu" (
  "id" text COLLATE "pg_catalog"."default" NOT NULL,
  "role_id" text COLLATE "pg_catalog"."default",
  "menu_id" text COLLATE "pg_catalog"."default",
  "status" int2,
  "create_by" text COLLATE "pg_catalog"."default",
  "update_by" text COLLATE "pg_catalog"."default",
  "version" int4,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "delete_time" timestamp(6)
)
;
ALTER TABLE "public"."t_role_menu" OWNER TO "postgres";
COMMENT ON COLUMN "public"."t_role_menu"."id" IS 'id';
COMMENT ON COLUMN "public"."t_role_menu"."role_id" IS '角色id';
COMMENT ON COLUMN "public"."t_role_menu"."menu_id" IS '用户id';
COMMENT ON COLUMN "public"."t_role_menu"."status" IS '状态: 1正常 0禁用';
COMMENT ON COLUMN "public"."t_role_menu"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."t_role_menu"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."t_role_menu"."version" IS '版本';
COMMENT ON COLUMN "public"."t_role_menu"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_role_menu"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."t_role_menu"."delete_time" IS '删除时间';

-- ----------------------------
-- Primary Key structure for table t_role_menu
-- ----------------------------
ALTER TABLE "public"."t_role_menu" ADD CONSTRAINT "t_role_menu_pkey" PRIMARY KEY ("id");
