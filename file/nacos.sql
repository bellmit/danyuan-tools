/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.105-4002
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : 192.168.0.105:4002
 Source Schema         : nacos

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 06/08/2021 18:10:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_info
-- ----------------------------
DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_use` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `effect` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_schema` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfo_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 206 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of config_info
-- ----------------------------
INSERT INTO `config_info` VALUES (182, 'danyuan-gateway.yml', 'DEFAULT_GROUP', 'spring:\n  cloud:\n    gateway:\n      discovery:\n      # 跨域\n      globalcors:\n        corsConfigurations:\n          \'[/**]\':\n            allowedHeaders: \"*\"\n            allowedOrigins: \"*\"\n            allowedMethods:\n            - GET\n              POST\n              DELETE\n              PUT\n              OPTION', '3670bdadf48a7a7658e1c822d8a41b9e', '2021-08-06 03:09:02', '2021-08-06 03:21:29', NULL, '10.0.0.3', '', 'danyuan', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (186, 'danyuan-nacos.yml', 'DEFAULT_GROUP', 'spring:\n  cloud:  \n    nacos:  \n      # nacos的信息\n      server-addr: 192.168.0.103:8848\n      discovery:  # 容器化后nacos不能找到，需要配置宿主机的ip 和服务的端口，\n        namespace: danyuan\n         # 宿主机的ip\n        ip: ${LOCAL_IP}\n        port: ${server.port}  \n    #inetutils:\n    #  preferred-networks: 10.0.3\n\nribbon:  \n  ReadTimeout: 900000\n  ConnectTimeout: 900000\n   #对当前实例的重试次数\n  MaxAutoRetries: 0\n   #切换实例的重试次数 1\n  MaxAutoRetriesNextServer: 1\nfeign:\n  hystrix:\n    enabled: false\n  client:\n    config:\n      default:\n        connectTimeout: 300000\n        readTimeout: 300000\n    \nhystrix:\n  command:\n    default:\n      execution:\n        isolation:\n          thread:\n            #熔断超时时间\n            timeoutInMilliseconds: 1000000\n\n', 'db590da9a1d7c6627bcb5678e757a88d', '2021-08-06 03:18:22', '2021-08-06 05:35:28', NULL, '10.0.0.3', '', 'danyuan', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (198, 'danyuan-h2.yml', 'DEFAULT_GROUP', 'spring:\n  jpa:\n    database: H2\n    show-sql: true\n    hibernate:\n      ddl-auto: update\n    properties:\n      hibernate:\n        dialect: org.hibernate.dialect.H2Dialect\n  datasource:\n    driver-class-name: org.h2.Driver\n    #url = jdbc:h2:mem:dbc2m\n    #url: jdbc:h2:file:./dbh2/dbc2m;AUTO_SERVER=TRUE\n    url: jdbc:h2:tcp://localhost:9091,localhost:9092/data\n    username: sa\n    password: \n', '4ac092a1ee5d66a5bb57f6b26dbc4f9f', '2021-08-06 08:46:06', '2021-08-06 09:03:13', NULL, '10.0.0.2', '', 'danyuan', 'h2database datasources', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (201, 'danyuan-hikari.yml', 'DEFAULT_GROUP', 'spring:\r\n  datasource:\r\n    hikari:\r\n      minimum-idle: 5\r\n      maximum-pool-size: 10\r\n      auto-commit: true\r\n      idle-timeout: 600000\r\n      pool-name: DatebookHikariCP\r\n      max-lifetime: 1800000\r\n      connection-timeout: 18000000\r\n      connection-test-query: SELECT 1', 'a54cb88d1897eb19addf063f8ae1db8c', '2021-08-06 08:47:27', '2021-08-06 08:47:27', NULL, '10.0.0.3', '', 'danyuan', '连接池', NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info` VALUES (204, 'danyuan-app.yml', 'DEFAULT_GROUP', 'app:\r\n  name: ${spring.application.name}\r\n  version: @project.version@ ', 'a0bfd2ffc50de89dbb34bd2157087d93', '2021-08-06 08:49:46', '2021-08-06 08:49:46', NULL, '10.0.0.2', '', 'danyuan', NULL, NULL, NULL, 'yaml', NULL);

-- ----------------------------
-- Table structure for config_info_aggr
-- ----------------------------
DROP TABLE IF EXISTS `config_info_aggr`;
CREATE TABLE `config_info_aggr`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'datum_id',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfoaggr_datagrouptenantdatum`(`data_id`, `group_id`, `tenant_id`, `datum_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '增加租户字段' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of config_info_aggr
-- ----------------------------

-- ----------------------------
-- Table structure for config_info_beta
-- ----------------------------
DROP TABLE IF EXISTS `config_info_beta`;
CREATE TABLE `config_info_beta`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfobeta_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_beta' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of config_info_beta
-- ----------------------------

-- ----------------------------
-- Table structure for config_info_tag
-- ----------------------------
DROP TABLE IF EXISTS `config_info_tag`;
CREATE TABLE `config_info_tag`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfotag_datagrouptenanttag`(`data_id`, `group_id`, `tenant_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_tag' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of config_info_tag
-- ----------------------------

-- ----------------------------
-- Table structure for config_tags_relation
-- ----------------------------
DROP TABLE IF EXISTS `config_tags_relation`;
CREATE TABLE `config_tags_relation`  (
  `id` bigint NOT NULL COMMENT 'id',
  `tag_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`) USING BTREE,
  UNIQUE INDEX `uk_configtagrelation_configidtag`(`id`, `tag_name`, `tag_type`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_tag_relation' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of config_tags_relation
-- ----------------------------

-- ----------------------------
-- Table structure for group_capacity
-- ----------------------------
DROP TABLE IF EXISTS `group_capacity`;
CREATE TABLE `group_capacity`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_group_id`(`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '集群、各Group容量信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of group_capacity
-- ----------------------------

-- ----------------------------
-- Table structure for his_config_info
-- ----------------------------
DROP TABLE IF EXISTS `his_config_info`;
CREATE TABLE `his_config_info`  (
  `id` bigint UNSIGNED NOT NULL,
  `nid` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gmt_create` datetime NOT NULL DEFAULT '2010-05-05 00:00:00',
  `gmt_modified` datetime NOT NULL DEFAULT '2010-05-05 00:00:00',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `op_type` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`nid`) USING BTREE,
  INDEX `idx_gmt_create`(`gmt_create`) USING BTREE,
  INDEX `idx_gmt_modified`(`gmt_modified`) USING BTREE,
  INDEX `idx_did`(`data_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 311 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '多租户改造' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of his_config_info
-- ----------------------------
INSERT INTO `his_config_info` VALUES (0, 276, 'danyuan-gateway', 'DEFAULT_GROUP', '', 'q', '7694f4a66316e53c8cdd9d9954bd611d', '2010-05-05 00:00:00', '2021-08-06 03:07:27', NULL, '10.0.0.2', 'I', 'danyuan');
INSERT INTO `his_config_info` VALUES (0, 278, 'danyuan-gateway.yml', 'DEFAULT_GROUP', '', 'q', '7694f4a66316e53c8cdd9d9954bd611d', '2010-05-05 00:00:00', '2021-08-06 03:09:02', NULL, '10.0.0.3', 'I', 'danyuan');
INSERT INTO `his_config_info` VALUES (174, 282, 'danyuan-gateway', 'DEFAULT_GROUP', '', 'q', '7694f4a66316e53c8cdd9d9954bd611d', '2010-05-05 00:00:00', '2021-08-06 03:18:05', NULL, '10.0.0.3', 'D', 'danyuan');
INSERT INTO `his_config_info` VALUES (0, 285, 'danyuan-nacos.yml', 'DEFAULT_GROUP', '', 'spring:\n  cloud:  \n    nacos:  \n      server-addr: 192.168.0.103:8848  # nacos的信息\n      discovery:  # 容器化后nacos不能找到，需要配置宿主机的ip 和服务的端口，\n        ip: ${LOCAL_IP} # 宿主机的ip\n        port: ${server.port}  \n    #inetutils:\n    #  preferred-networks: 10.0.3\n\nribbon:  \n  ReadTimeout: 900000\n  ConnectTimeout: 900000\n  MaxAutoRetries: 0 #对当前实例的重试次数\n  MaxAutoRetriesNextServer: 1 #切换实例的重试次数 1\nfeign:\n  hystrix:\n    enabled: false\n  client:\n    config:\n      default:\n        connectTimeout: 300000\n        readTimeout: 300000\n    \nhystrix:\n  command:\n    default:\n      execution:\n        isolation:\n          thread:\n            timeoutInMilliseconds: 1000000  #熔断超时时间\n\n', '17011366383359fb3ac137fc1ca2ab50', '2010-05-05 00:00:00', '2021-08-06 03:18:22', NULL, '10.0.0.3', 'I', 'danyuan');
INSERT INTO `his_config_info` VALUES (183, 288, 'application-nacos.yml', 'DEFAULT_GROUP', '', 'spring:\n  cloud:  \n    nacos:  \n      server-addr: 192.168.0.103:8848  # nacos的信息\n      discovery:  # 容器化后nacos不能找到，需要配置宿主机的ip 和服务的端口，\n        ip: ${LOCAL_IP} # 宿主机的ip\n        port: ${server.port}  \n    #inetutils:\n    #  preferred-networks: 10.0.3\n\nribbon:  \n  ReadTimeout: 900000\n  ConnectTimeout: 900000\n  MaxAutoRetries: 0 #对当前实例的重试次数\n  MaxAutoRetriesNextServer: 1 #切换实例的重试次数 1\nfeign:\n  hystrix:\n    enabled: false\n  client:\n    config:\n      default:\n        connectTimeout: 300000\n        readTimeout: 300000\n    \nhystrix:\n  command:\n    default:\n      execution:\n        isolation:\n          thread:\n            timeoutInMilliseconds: 1000000  #熔断超时时间\n\n', '17011366383359fb3ac137fc1ca2ab50', '2010-05-05 00:00:00', '2021-08-06 03:18:26', NULL, '10.0.0.3', 'D', 'danyuan');
INSERT INTO `his_config_info` VALUES (182, 291, 'danyuan-gateway.yml', 'DEFAULT_GROUP', '', 'q', '7694f4a66316e53c8cdd9d9954bd611d', '2010-05-05 00:00:00', '2021-08-06 03:21:29', NULL, '10.0.0.3', 'U', 'danyuan');
INSERT INTO `his_config_info` VALUES (186, 294, 'danyuan-nacos.yml', 'DEFAULT_GROUP', '', 'spring:\n  cloud:  \n    nacos:  \n      server-addr: 192.168.0.103:8848  # nacos的信息\n      discovery:  # 容器化后nacos不能找到，需要配置宿主机的ip 和服务的端口，\n        ip: ${LOCAL_IP} # 宿主机的ip\n        port: ${server.port}  \n    #inetutils:\n    #  preferred-networks: 10.0.3\n\nribbon:  \n  ReadTimeout: 900000\n  ConnectTimeout: 900000\n  MaxAutoRetries: 0 #对当前实例的重试次数\n  MaxAutoRetriesNextServer: 1 #切换实例的重试次数 1\nfeign:\n  hystrix:\n    enabled: false\n  client:\n    config:\n      default:\n        connectTimeout: 300000\n        readTimeout: 300000\n    \nhystrix:\n  command:\n    default:\n      execution:\n        isolation:\n          thread:\n            timeoutInMilliseconds: 1000000  #熔断超时时间\n\n', '17011366383359fb3ac137fc1ca2ab50', '2010-05-05 00:00:00', '2021-08-06 05:21:19', NULL, '10.0.0.2', 'U', 'danyuan');
INSERT INTO `his_config_info` VALUES (186, 297, 'danyuan-nacos.yml', 'DEFAULT_GROUP', '', 'spring:\n  cloud:  \n    nacos:  \n      namespace: danyuan\n      server-addr: 192.168.0.103:8848  # nacos的信息\n      discovery:  # 容器化后nacos不能找到，需要配置宿主机的ip 和服务的端口，\n        ip: ${LOCAL_IP} # 宿主机的ip\n        port: ${server.port}  \n    #inetutils:\n    #  preferred-networks: 10.0.3\n\nribbon:  \n  ReadTimeout: 900000\n  ConnectTimeout: 900000\n  MaxAutoRetries: 0 #对当前实例的重试次数\n  MaxAutoRetriesNextServer: 1 #切换实例的重试次数 1\nfeign:\n  hystrix:\n    enabled: false\n  client:\n    config:\n      default:\n        connectTimeout: 300000\n        readTimeout: 300000\n    \nhystrix:\n  command:\n    default:\n      execution:\n        isolation:\n          thread:\n            timeoutInMilliseconds: 1000000  #熔断超时时间\n\n', 'fc347ad753ed93ad7abfa02474ff040e', '2010-05-05 00:00:00', '2021-08-06 05:22:18', NULL, '10.0.0.2', 'U', 'danyuan');
INSERT INTO `his_config_info` VALUES (186, 299, 'danyuan-nacos.yml', 'DEFAULT_GROUP', '', 'spring:\n  cloud:  \n    nacos:  \n      namespace: danyuan\n      server-addr: 192.168.0.103:8848  # nacos的信息\n      discovery:  # 容器化后nacos不能找到，需要配置宿主机的ip 和服务的端口，\n        ip: ${LOCAL_IP} # 宿主机的ip\n        port: ${server.port}  \n    #inetutils:\n    #  preferred-networks: 10.0.3\n\nribbon:  \n  ReadTimeout: 900000\n  ConnectTimeout: 900000\n  MaxAutoRetries: 0 #对当前实例的重试次数\n  MaxAutoRetriesNextServer: 1 #切换实例的重试次数 1\nfeign:\n  hystrix:\n    enabled: false\n  client:\n    config:\n      default:\n        connectTimeout: 300000\n        readTimeout: 300000\n    \nhystrix:\n  command:\n    default:\n      execution:\n        isolation:\n          thread:\n            timeoutInMilliseconds: 1000000  #熔断超时时间\n\n', 'fc347ad753ed93ad7abfa02474ff040e', '2010-05-05 00:00:00', '2021-08-06 05:35:28', NULL, '10.0.0.3', 'U', 'danyuan');
INSERT INTO `his_config_info` VALUES (0, 300, 'danyuan-h2.yml', 'DEFAULT_GROUP', '', 'spring:\r\n  jpa:\r\n    database: H2\r\n    properties:\r\n      hibernate:\r\n        dialect: org.hibernate.dialect.H2Dialect\r\n  datasource:\r\n    driver-class-name: org.h2.Driver\r\n    #url = jdbc:h2:mem:dbc2m\r\n    #url: jdbc:h2:file:./dbh2/dbc2m;AUTO_SERVER=TRUE\r\n    url: jdbc:h2:tcp://localhost:9091,localhost:9092/data\r\n    username: sa\r\n    password: ', '022f8c8f793679739ad89957b038a232', '2010-05-05 00:00:00', '2021-08-06 08:46:06', NULL, '10.0.0.3', 'I', 'danyuan');
INSERT INTO `his_config_info` VALUES (0, 303, 'danyuan-hikari.yml', 'DEFAULT_GROUP', '', 'spring:\r\n  datasource:\r\n    hikari:\r\n      minimum-idle: 5\r\n      maximum-pool-size: 10\r\n      auto-commit: true\r\n      idle-timeout: 600000\r\n      pool-name: DatebookHikariCP\r\n      max-lifetime: 1800000\r\n      connection-timeout: 18000000\r\n      connection-test-query: SELECT 1', 'a54cb88d1897eb19addf063f8ae1db8c', '2010-05-05 00:00:00', '2021-08-06 08:47:27', NULL, '10.0.0.3', 'I', 'danyuan');
INSERT INTO `his_config_info` VALUES (0, 306, 'danyuan-app.yml', 'DEFAULT_GROUP', '', 'app:\r\n  name: ${spring.application.name}\r\n  version: @project.version@ ', 'a0bfd2ffc50de89dbb34bd2157087d93', '2010-05-05 00:00:00', '2021-08-06 08:49:46', NULL, '10.0.0.2', 'I', 'danyuan');
INSERT INTO `his_config_info` VALUES (198, 309, 'danyuan-h2.yml', 'DEFAULT_GROUP', '', 'spring:\r\n  jpa:\r\n    database: H2\r\n    properties:\r\n      hibernate:\r\n        dialect: org.hibernate.dialect.H2Dialect\r\n  datasource:\r\n    driver-class-name: org.h2.Driver\r\n    #url = jdbc:h2:mem:dbc2m\r\n    #url: jdbc:h2:file:./dbh2/dbc2m;AUTO_SERVER=TRUE\r\n    url: jdbc:h2:tcp://localhost:9091,localhost:9092/data\r\n    username: sa\r\n    password: ', '022f8c8f793679739ad89957b038a232', '2010-05-05 00:00:00', '2021-08-06 09:03:13', NULL, '10.0.0.2', 'U', 'danyuan');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `resource` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `action` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  UNIQUE INDEX `uk_role_permission`(`role`, `resource`, `action`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of permissions
-- ----------------------------

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  UNIQUE INDEX `uk_username_role`(`username`, `role`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('nacos', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for tenant_capacity
-- ----------------------------
DROP TABLE IF EXISTS `tenant_capacity`;
CREATE TABLE `tenant_capacity`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数',
  `max_aggr_size` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '租户容量信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tenant_capacity
-- ----------------------------

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_info_kptenantid`(`kp`, `tenant_id`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'tenant_info' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tenant_info
-- ----------------------------
INSERT INTO `tenant_info` VALUES (11, '1', 'danyuan', 'danyuan', 'danyuan', 'nacos', 1628219180771, 1628219180771);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `PASSWORD` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);

SET FOREIGN_KEY_CHECKS = 1;
