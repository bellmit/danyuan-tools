org.danyuan.application.common.base# danyuan-tools

# 应用集
## 1. danyuan-tools-web
### 1.1 client
	主要以宣传展示为主，展示设计和作用，
	
### 1.2 manager
	包含主要大分类（权限管理，数据清洗，图形设计，信息查询，物料进销存储，等）
	包含菜单和主要操作展示的内容
	
### 1.3 doc
    项目介绍,教程,学习文档
	
## 2. danyuan-tools
### 2.1 danyuan-security 
	手机登录，第三方登录（QQ，微信，支付宝，微博，github）
	cloud登录
### 2.2 danyuan-toolset 
	桌面系统
### 2.3 danyuan-data 
	数据清洗工具
### 2.4 danyuan-serve
	信息提供的后端
### 2.5 danyuan-commons
	工具类，通用方法，实体类
### 2.6 danyuan-getway
	路由 
	2.6.1 getway/ 性能优于zuul 比Linkerd性能还好 
	2.6.2 zuul/  是一个基于阻塞io的API Gateway
	2.6.3 Linkerd(Service Mesh)/ 目前市面上仅有的生产级别的Service Mesh（其他诸如Istio、Conduit暂时还不能用于生产）
	2.6.4 Zuul 2.x 基于Netty，也是非阻塞的，支持长连接，但Spring Cloud暂时还没有整合计划
### 2.7 danyuan-sidecare 
	连接其他语言的通道 
	2.7.1 spring-cloud-alibaba-sidecar
	2.7.2 spring-cloud-netflix-sidecar
	2.7.3 Nginx反向代理实现
	2.7.4 其他语言编写代码注册到注册中心
	
## 3. 采集工具
### 3.1 crawler
	通用采集器
	
## 4. 工具
### 4.1 nacos/Eureka
	注册中心
### 4.2 MQ
	MQ/kafka
### 4.3 redis
	redis
### 4.4 



# 常用命令
mvn clean install
mvn install docker:build -DpushImage
mvn install -Dmaven.test.skip=true
mvn clean
