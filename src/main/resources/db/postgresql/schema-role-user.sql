/*
 Navicat Premium Dump SQL

 Source Server         : local-pg
 Source Server Type    : role_usergreSQL
 Source Server Version : 160004 (160004)
 Source Host           : localhost:5432
 Source Catalog        : lid
 Source Schema         : public

 Target Server Type    : role_usergreSQL
 Target Server Version : 160004 (160004)
 File Encoding         : 65001

 Date: 03/02/2025 23:44:54
*/


-- ----------------------------
-- Table structure for t_role_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_role_user";
CREATE TABLE "public"."t_role_user" (
  "id" text COLLATE "pg_catalog"."default" NOT NULL,
  "role_id" text COLLATE "pg_catalog"."default",
  "user_id" text COLLATE "pg_catalog"."default",
  "status" int2,
  "create_by" text COLLATE "pg_catalog"."default",
  "update_by" text COLLATE "pg_catalog"."default",
  "version" int4,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "delete_time" timestamp(6)
)
;
ALTER TABLE "public"."t_role_user" OWNER TO "postgres";
COMMENT ON COLUMN "public"."t_role_user"."id" IS 'id';
COMMENT ON COLUMN "public"."t_role_user"."role_id" IS '角色id';
COMMENT ON COLUMN "public"."t_role_user"."user_id" IS '用户id';
COMMENT ON COLUMN "public"."t_role_user"."status" IS '状态: 1正常 0禁用';
COMMENT ON COLUMN "public"."t_role_user"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."t_role_user"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."t_role_user"."version" IS '版本';
COMMENT ON COLUMN "public"."t_role_user"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_role_user"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."t_role_user"."delete_time" IS '删除时间';

-- ----------------------------
-- Primary Key structure for table t_role_user
-- ----------------------------
ALTER TABLE "public"."t_role_user" ADD CONSTRAINT "t_role_user_pkey" PRIMARY KEY ("id");
