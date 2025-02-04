/*
 Navicat Premium Dump SQL

 Source Server         : local-pg
 Source Server Type    : user_postgreSQL
 Source Server Version : 160004 (160004)
 Source Host           : localhost:5432
 Source Catalog        : lid
 Source Schema         : public

 Target Server Type    : user_postgreSQL
 Target Server Version : 160004 (160004)
 File Encoding         : 65001

 Date: 03/02/2025 23:44:54
*/


-- ----------------------------
-- Table structure for t_user_post
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_user_post";
CREATE TABLE "public"."t_user_post" (
  "id" text COLLATE "pg_catalog"."default" NOT NULL,
  "user_id" text COLLATE "pg_catalog"."default",
  "post_id" text COLLATE "pg_catalog"."default",
  "status" int2,
  "create_by" text COLLATE "pg_catalog"."default",
  "update_by" text COLLATE "pg_catalog"."default",
  "version" int4,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "delete_time" timestamp(6)
)
;
ALTER TABLE "public"."t_user_post" OWNER TO "postgres";
COMMENT ON COLUMN "public"."t_user_post"."id" IS 'id';
COMMENT ON COLUMN "public"."t_user_post"."user_id" IS '用户id';
COMMENT ON COLUMN "public"."t_user_post"."post_id" IS '岗位id';
COMMENT ON COLUMN "public"."t_user_post"."status" IS '状态: 1正常 0禁用';
COMMENT ON COLUMN "public"."t_user_post"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."t_user_post"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."t_user_post"."version" IS '版本';
COMMENT ON COLUMN "public"."t_user_post"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_user_post"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."t_user_post"."delete_time" IS '删除时间';

-- ----------------------------
-- Primary Key structure for table t_user_post
-- ----------------------------
ALTER TABLE "public"."t_user_post" ADD CONSTRAINT "t_user_post_pkey" PRIMARY KEY ("id");
