# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## 项目概述

基于 Spring Cloud 2021、Spring Boot 2.7、OAuth2 的 RBAC 权限管理系统。使用 Nacos 作为注册/配置中心，Sentinel 作为熔断器。

## 技术栈

- Java 1.8
- Spring Boot 2.7.18
- Spring Cloud 2021.0.8
- Spring Cloud Alibaba 2021.0.5.0
- Mybatis Plus 3.3.2
- MySQL Connector 8.0.33
- JWT 3.8.3

## 模块架构

```
cjlgb-cloud-platform (父项目)
├── cjlgb-design-common (公共模块)
│   ├── cjlgb-design-common-core      -- 公共工具类、Spring Web/Actuator/Validation 依赖
│   ├── cjlgb-design-common-mybatis    -- Mybatis Plus 集成
│   ├── cjlgb-design-common-oauth      -- OAuth 认证模块接口、Feign 客户端
│   ├── cjlgb-design-common-security   -- 分布式权限框架、JWT 解析、AOP、Redis
│   ├── cjlgb-design-common-system     -- 系统服务模块接口
│   └── cjlgb-design-common-upms       -- UPMS 模块接口
├── cjlgb-design-gateway [10001]        -- Spring Cloud Gateway API 网关
├── cjlgb-design-oauth [0]             -- OAuth 认证服务
├── cjlgb-design-system [0]             -- 系统服务（SMS 等）
├── cjlgb-design-developer [0]          -- 开发者服务
└── cjlgb-design-upms [0]              -- 用户权限管理服务
```

## 常用命令

```bash
# 构建整个项目
mvn clean package

# 构建单个模块
mvn clean package -pl cjlgb-design-oauth -am

# 跳过测试打包
mvn clean package -DskipTests

# 运行单个模块（需先确保依赖模块已 install）
mvn spring-boot:run -pl cjlgb-design-oauth
```

## 本地开发环境配置

### Hosts 配置
```
127.0.0.1  cjlgb-design-gateway
127.0.0.1  cjlgb-design-nacos
127.0.0.1  cjlgb-design-redis
127.0.0.1  cjlgb-design-mysql
```

### 依赖服务 (Docker Compose)
项目依赖 Nacos (注册/配置中心)、Redis、MySQL 和 Nginx。README 中提供了 docker-compose 脚本示例。

## 数据库初始化

各模块根目录下的 `*.sql` 文件用于初始化数据库，例如：
- `cjlgb-design-oauth/cjlgb-design-oauth.sql`
- `cjlgb-design-system/cjlgb-design-system.sql`

## 重要提示

- 默认跳过测试打包 (`maven-surefire-plugin` 配置 `skipTests=true`)
- 子模块依赖通过 `dependencyManagement` 统一版本管理
- Gateway 依赖 Nacos 进行服务发现和配置管理