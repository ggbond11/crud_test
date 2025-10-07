# Spring Boot CRUD 示例项目

这是一个基于Spring Boot的用户管理CRUD（创建、读取、更新、删除）示例项目。该项目展示了如何使用Spring Boot、Spring Data JPA和MySQL数据库创建一个简单但功能完整的RESTful API。

## 技术栈

- **Spring Boot 3.5.6**: 简化Spring应用开发的框架
- **Spring Data JPA**: 简化数据库操作的JPA实现
- **MySQL**: 关系型数据库
- **Maven**: 项目构建和依赖管理工具

## 项目结构

``` text
src/main/java/com/kehanzhu/crud_test/ 
    ├── CrudTestApplication.java # 应用程序入口 
    ├── controller # 控制器层 │ 
        └── UserController.java # 用户相关API接口 
    ├── exception # 异常处理 │ 
        └── GlobalExceptionHandlerAdvice.java # 全局异常处理器 
    ├── pojo # 实体类 │ 
        ├── ResponseMessage.java # 统一响应消息格式 │ 
        ├── User.java # 用户实体类 │ 
        └── dto # 数据传输对象 │ 
            └── UserDto.java # 用户DTO 
    ├── repository # 数据访问层 │ 
        └── UserRepository.java # 用户数据库操作接口 
    └── service # 业务逻辑层 
        ├── IUserService.java # 用户服务接口 
        └── UserService.java # 用户服务实现
```
## 功能

该项目实现了以下功能：

1. **用户管理**:
   - 创建新用户
   - 获取用户信息
   - 更新用户信息
   - 删除用户

2. **错误处理**:
   - 全局异常处理
   - 统一响应格式

## API接口

### 用户管理

| 方法   | URL                      | 描述         | 请求体示例                                                 | 响应示例                                                |
|------|--------------------------|------------|-------------------------------------------------------|-----------------------------------------------------|
| POST | /user                    | 创建新用户      | `{"userName":"xiaoming","password":"123456","email":"test@qq.com"}` | `{"code":200,"message":"success","data":{"userid":1,"userName":"xiaoming","password":"123456","email":"test@qq.com"}}` |
| GET  | /user/{userId}           | 获取用户信息     | -                                                     | `{"code":200,"message":"success","data":{"userid":1,"userName":"xiaoming","password":"123456","email":"test@qq.com"}}` |
| PUT  | /user                    | 更新用户信息     | `{"userId":1,"userName":"xiaoming","password":"123456","email":"test@qq.com"}` | `{"code":200,"message":"success","data":{"userid":1,"userName":"xiaoming","password":"123456","email":"test@qq.com"}}` |
| DELETE | /user/{userId}           | 删除用户       | -                                                     | `{"code":200,"message":"success","data":null}`       |

## 配置说明

项目的主要配置在`application.properties`文件中：

```properties
# 服务器端口
server.port=8090

# 数据库连接配置
spring.datasource.url=jdbc:mysql://localhost:3306/springboot_zhu?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA配置
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=update

运行项目
前提条件
JDK 17+
Maven 3.6+
MySQL 5.7+
步骤
克隆项目

git clone https://github.com/yourusername/crud_test.git
cd crud_test
配置数据库

创建名为springboot_zhu的数据库
更新application.properties中的数据库用户名和密码
构建并运行项目

# 使用Maven包装器
./mvnw spring-boot:run

# 或使用已安装的Maven
mvn spring-boot:run
访问API

项目启动后，API将在http://localhost:8090上可用
开发说明
数据模型
用户实体(User)包含以下字段：

userid: 用户ID (主键，自动生成)
userName: 用户名
password: 密码
email: 电子邮箱

业务逻辑
用户服务(UserService)实现了基本的CRUD操作
更新操作会先检查用户是否存在，然后再进行更新
全局异常处理器会捕获并处理所有异常，返回统一的错误响应

注意事项
本项目仅作为示例，生产环境中应添加适当的安全措施
密码在实际应用中应该进行加密处理
建议添加数据验证和更完善的错误处理