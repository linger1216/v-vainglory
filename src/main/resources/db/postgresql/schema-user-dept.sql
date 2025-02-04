/*
 Navicat Premium Dump SQL

 Source Server         : local-pg
 Source Server Type    : user_deptgreSQL
 Source Server Version : 160004 (160004)
 Source Host           : localhost:5432
 Source Catalog        : lid
 Source Schema         : public

 Target Server Type    : user_deptgreSQL
 Target Server Version : 160004 (160004)
 File Encoding         : 65001

 Date: 03/02/2025 23:44:54
*/


-- ----------------------------
-- Table structure for t_user_dept
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_user_dept";
CREATE TABLE "public"."t_user_dept" (
  "id" text COLLATE "pg_catalog"."default" NOT NULL,
  "user_id" text COLLATE "pg_catalog"."default",
  "dept_id" text COLLATE "pg_catalog"."default",
  "status" int2,
  "create_by" text COLLATE "pg_catalog"."default",
  "update_by" text COLLATE "pg_catalog"."default",
  "version" int4,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "delete_time" timestamp(6)
)
;
ALTER TABLE "public"."t_user_dept" OWNER TO "postgres";
COMMENT ON COLUMN "public"."t_user_dept"."id" IS 'id';
COMMENT ON COLUMN "public"."t_user_dept"."user_id" IS '用户id';
COMMENT ON COLUMN "public"."t_user_dept"."dept_id" IS '部门id';
COMMENT ON COLUMN "public"."t_user_dept"."status" IS '状态: 1正常 0禁用';
COMMENT ON COLUMN "public"."t_user_dept"."create_by" IS '创建者';
COMMENT ON COLUMN "public"."t_user_dept"."update_by" IS '更新者';
COMMENT ON COLUMN "public"."t_user_dept"."version" IS '版本';
COMMENT ON COLUMN "public"."t_user_dept"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."t_user_dept"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."t_user_dept"."delete_time" IS '删除时间';

-- ----------------------------
-- Primary Key structure for table t_user_dept
-- ----------------------------
ALTER TABLE "public"."t_user_dept" ADD CONSTRAINT "t_user_dept_pkey" PRIMARY KEY ("id");
