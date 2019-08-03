# choerodonStudyService

1. 增加api-gateway路由配置
2. 修改数据库配置信息：src/main/resources/application.yml
````
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/todo_service?useUnicode=true&characterEncoding=utf-8&useSSL=false
    username: pengyuhua
    password: root
````
3. 执行init-local-database.sh脚本文件初始化数据库
4. 启动服务
