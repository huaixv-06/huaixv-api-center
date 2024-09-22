# huaixv-api-center
 在线接口开放平台

## 项目介绍

本项目是基于 React + Spring Boot + Dubbo + Gateway 的 API 接口开放调用平台，管理员可以接入并发布接口，可视化的观察各个接口调用情况；用户可以开通接口调用权限，浏览接口及在线调试，并通过客户端SDK调用接口

### 技术栈

SSM + Spring Boot ，Spring Cloud Gateway ，Dubbo ，Nacos ，MySQL ，Redis ，MyBatis-Plus ，Hutool工具库

Spring Boot ： 快速构建后端项目，通过配置文件整合依赖

Dubbo ：分布式 RPC 框架， 实现项目中不同模块的高性能相互调用，比如网关服务集中统计接口调用次数时通过 Dubbo 调用接口服务完成次数扣减。

GateWay：作为API网关，集中接受客户端的请求，并执行统一的安全认证，请求转发，流量控制，请求日志，公共业务等操作。

### 项目框架

 API 开放平台分为五个子项目，分别为：

 * api-center-backend：核心业务后端，负责用户管理和接口管理等核心业务功能
 * api-center-gateway：API网关服务，负责集中的路由转发，统一鉴权，统一业务处理，访问控制等
 * api-center-commmon：公共模块，包括其他模块中需要复用的方法，工具类，实体类，全局异常等
 * api-center-client-sdk：客户端SDK，封装了对各API接口的调用方法，降低开发这的使用成本
 * api-center-interface：提供模拟API接口

交互流程：首先管理员创建接口后通过核心业务后端 (api-center-backend) 保存到数据库中，用户在需要调用某个接口时，可以先通过客户端的在线调试功能体验，然后在自己的项目中引入客户端 SDK (api-center-client-sdk) 并通过一行代码发起调用，请求会先发送到 API 网关 (api-center-gateway) 进行用户的鉴权和接口调用统计，然后将请求转发到实际的 API 接口 (api-center-interface) 。
