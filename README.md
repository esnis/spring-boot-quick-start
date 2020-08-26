# 项目介绍

一个使用Spring Boot来构建Web API的实例项目， 相似项目可以直接clone当前项目并适当剪裁后直接进行开发。

# 跑起来

```
mvn clean package
java -jar target/*.jar
```

# 快速浏览

com.wacai.spring.boot.prototype.controllers包下的相应Controller实现对应某种功能的Web API实现， 参考HelloController。

Controller实现过程中相应的依赖配置到xml或者通过Annotation配置即可。


# 需要关注的点

## Main 

注意这个入口类，任何基于当前项目进行开发的项目不需要变更这个类！

## src/main/resources/logback.xml

根据情况变更log文件的名称，但相对路径的前缀需要保持。

## src/main/resources/spring/*.xml

我们鼓励使用xml形式的配置来外部化，明确化spring应用的配置和行为，~~所以Main入口类通过`@ImportResource("classpath*:/spring/*.xml")`的Annotation配置来建立从当前位置和文件通配符来加载spring配置。~~

xml形式的配置和Javaconfig可以共存, 一起加载并构建到一个ApplicationContext.


## ~~conf/application.properties~~

~~所有需要外部话的配置以及环境变量配置在这个路径下的指定文件名的配置文件中， 这在`@PropertySource("file:conf/application.properties")`中建立了明确的配置，并且遵循挖财整体的配置-发布-部署规范。~~

application.properties直接放在classspath根路径下即可, 即src/main/resources下.

obelisk一键发布平台会自动管理配置.

# 关于基于Swagger的API Documentation

maven依赖中添加如下以来,即可自动享受基于Swagger的Web API文档服务:

~~~~~~~ {.xml}
        <dependency>
            <groupId>com.wacai</groupId>
            <artifactId>spring-boot-starter-webapi</artifactId>
            <version>1.0.4</version>
        </dependency>
~~~~~~~

使用springfox之后,访问<http://localhost:8080/swagger-ui.html>直接获取API信息页面.