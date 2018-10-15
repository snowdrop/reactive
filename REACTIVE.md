# Reactive strategy

## Starters available for `2.0.x`

List of Spring Boot `Reactive` starters:

| Id | Starter's name | 
|----|---------------|
| Reactive Web | webflux |
| Reactive Cloud streams | reactive-cloud-stream |
| Reactive MongoDB | data-mongodb-reactive |
| Reactive Cassandra | data-cassandra-reactive |
| Reactive Redis | data-redis-reactive |
| Reactive Couchbase | data-couchbase-reactive |

[starters](images/reactive_starters.png)

A Spring Boot `reactive` project can be generated from the `start.spring.io` site using a `curl` request

```bash
curl 'http://start.spring.io/starter.tgz' \
     -o 'reactive-web.zip'                \
     -d 'dependencies=webflux'            \
     -d 'packaging=jar'                   \
     -d 'groupId=me.snowdrop'             \
     -d 'artifactId=reactive-web'         \ 
     -d 'version=1.0-SNAPSHOT'            \ 
     -d 'type=maven-project'              \
     -d 'javaVersion=1.8'                 \
     -d 'bootVersion=2.0.4.RELEASE'
```

or using `httpie`'s tool

```
http https://start.spring.io/starter.tgz \
  dependencies==webflux \
  packaging==jar \
  groupId=='me.snowdrop' \
  artifactId=='reactive-web' \
  version=='1.0-SNAPSHOT' \
  bootVersion=='2.0.4.RELEASE' \
  -d
```

A reactive pom's file contains such additional GAVs

```xml
<dependencies>
    <!-- Non blocking/async runtime, ... -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-reactor-netty</artifactId>
      <version>2.0.2.BUILD-SNAPSHOT</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>io.projectreactor.ipc</groupId>
      <artifactId>reactor-netty</artifactId>
      <version>0.7.7.RELEASE</version>
      <scope>compile</scope>
    </dependency>    
    
    <!-- Reactive FluentAPI,... -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webflux</artifactId>
      <version>5.0.6.BUILD-SNAPSHOT</version>
      <scope>compile</scope>
    </dependency>
    <!-- Reactor is mandatory -->
    <!-- ?? -->
    <dependency>
      <groupId>io.projectreactor</groupId>
      <artifactId>reactor-core</artifactId>
      <scope>compile</scope>
    </dependency>
    
    <!-- ?? -->
    <dependency>
      <groupId>io.projectreactor.ipc</groupId>
      <artifactId>reactor-netty</artifactId>
      <scope>compile</scope>
      <optional>true</optional>
    </dependency>
    
    <!-- ?? -->
    <dependency>
      <groupId>io.reactivex</groupId>
      <artifactId>rxjava</artifactId>
      <version>1.3.8</version>
      <scope>compile</scope>
      <optional>true</optional>
    </dependency>
    
    <!-- ?? -->
    <dependency>
      <groupId>io.reactivex</groupId>
      <artifactId>rxjava-reactive-streams</artifactId>
      <version>1.2.1</version>
      <scope>compile</scope>
      <optional>true</optional>
    </dependency>    
    
    <!-- ?? -->
    <dependency>
      <groupId>org.synchronoss.cloud</groupId>
      <artifactId>nio-multipart-parser</artifactId>
      <version>1.1.0</version>
      <scope>compile</scope>
    </dependency>
    
    <!-- NON REACTIVE -->
    <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter</artifactId>
       <version>2.0.2.BUILD-SNAPSHOT</version>
       <scope>compile</scope>
     </dependency>
     <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-json</artifactId>
       <version>2.0.2.BUILD-SNAPSHOT</version>
       <scope>compile</scope>
     </dependency>
     <dependency>
       <groupId>org.hibernate.validator</groupId>
       <artifactId>hibernate-validator</artifactId>
       <version>6.0.9.Final</version>
       <scope>compile</scope>
     </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>5.0.6.BUILD-SNAPSHOT</version>
      <scope>compile</scope>
    </dependency>
```

## Interesting guides & Doc

- Introduction to [Reactive's programming](https://gist.github.com/staltz/868e7e9bc2a7b8c1f754)
- https://www.infoq.com/articles/reactor-by-example
- https://spring.io/guides/gs/reactive-rest-service/

## Technology

Spring Boot and Spring 5 rely on `Reactor` [project](https://projectreactor.io/docs) which implements the `Reactive`'s [spec]() 

## Dependencies's tree

```
[INFO] me.snowdrop:reactive-web:jar:1.0-SNAPSHOT
[INFO] +- org.springframework.boot:spring-boot-starter-webflux:jar:2.0.4.RELEASE:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter:jar:2.0.4.RELEASE:compile
[INFO] |  |  +- org.springframework.boot:spring-boot:jar:2.0.4.RELEASE:compile
[INFO] |  |  |  \- org.springframework:spring-context:jar:5.0.8.RELEASE:compile
[INFO] |  |  |     +- org.springframework:spring-aop:jar:5.0.8.RELEASE:compile
[INFO] |  |  |     \- org.springframework:spring-expression:jar:5.0.8.RELEASE:compile
[INFO] |  |  +- org.springframework.boot:spring-boot-autoconfigure:jar:2.0.4.RELEASE:compile
[INFO] |  |  +- org.springframework.boot:spring-boot-starter-logging:jar:2.0.4.RELEASE:compile
[INFO] |  |  |  +- ch.qos.logback:logback-classic:jar:1.2.3:compile
[INFO] |  |  |  |  \- ch.qos.logback:logback-core:jar:1.2.3:compile
[INFO] |  |  |  +- org.apache.logging.log4j:log4j-to-slf4j:jar:2.10.0:compile
[INFO] |  |  |  |  \- org.apache.logging.log4j:log4j-api:jar:2.10.0:compile
[INFO] |  |  |  \- org.slf4j:jul-to-slf4j:jar:1.7.25:compile
[INFO] |  |  +- javax.annotation:javax.annotation-api:jar:1.3.2:compile
[INFO] |  |  \- org.yaml:snakeyaml:jar:1.19:runtime
[INFO] |  +- org.springframework.boot:spring-boot-starter-json:jar:2.0.4.RELEASE:compile
[INFO] |  |  +- com.fasterxml.jackson.core:jackson-databind:jar:2.9.6:compile
[INFO] |  |  |  +- com.fasterxml.jackson.core:jackson-annotations:jar:2.9.0:compile
[INFO] |  |  |  \- com.fasterxml.jackson.core:jackson-core:jar:2.9.6:compile
[INFO] |  |  +- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:jar:2.9.6:compile
[INFO] |  |  +- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.9.6:compile
[INFO] |  |  \- com.fasterxml.jackson.module:jackson-module-parameter-names:jar:2.9.6:compile
**[INFO] |  +- org.springframework.boot:spring-boot-starter-reactor-netty:jar:2.0.4.RELEASE:compile
[INFO] |  |  \- io.projectreactor.ipc:reactor-netty:jar:0.7.8.RELEASE:compile
[INFO] |  |     +- io.netty:netty-codec-http:jar:4.1.27.Final:compile
[INFO] |  |     |  \- io.netty:netty-codec:jar:4.1.27.Final:compile
[INFO] |  |     +- io.netty:netty-handler:jar:4.1.27.Final:compile
[INFO] |  |     |  +- io.netty:netty-buffer:jar:4.1.27.Final:compile
[INFO] |  |     |  \- io.netty:netty-transport:jar:4.1.27.Final:compile
[INFO] |  |     |     \- io.netty:netty-resolver:jar:4.1.27.Final:compile
[INFO] |  |     +- io.netty:netty-handler-proxy:jar:4.1.27.Final:compile
[INFO] |  |     |  \- io.netty:netty-codec-socks:jar:4.1.27.Final:compile
[INFO] |  |     \- io.netty:netty-transport-native-epoll:jar:linux-x86_64:4.1.27.Final:compile
[INFO] |  |        +- io.netty:netty-common:jar:4.1.27.Final:compile
[INFO] |  |        \- io.netty:netty-transport-native-unix-common:jar:4.1.27.Final:compile**
[INFO] |  +- org.hibernate.validator:hibernate-validator:jar:6.0.11.Final:compile
[INFO] |  |  +- javax.validation:validation-api:jar:2.0.1.Final:compile
[INFO] |  |  +- org.jboss.logging:jboss-logging:jar:3.3.2.Final:compile
[INFO] |  |  \- com.fasterxml:classmate:jar:1.3.4:compile
[INFO] |  +- org.springframework:spring-web:jar:5.0.8.RELEASE:compile
[INFO] |  |  \- org.springframework:spring-beans:jar:5.0.8.RELEASE:compile
**[INFO] |  +- org.springframework:spring-webflux:jar:5.0.8.RELEASE:compile**
[INFO] |  \- org.synchronoss.cloud:nio-multipart-parser:jar:1.1.0:compile
[INFO] |     +- org.slf4j:slf4j-api:jar:1.7.25:compile
[INFO] |     \- org.synchronoss.cloud:nio-stream-storage:jar:1.1.3:compile
[INFO] +- org.springframework.boot:spring-boot-starter-test:jar:2.0.4.RELEASE:test
[INFO] |  +- org.springframework.boot:spring-boot-test:jar:2.0.4.RELEASE:test
[INFO] |  +- org.springframework.boot:spring-boot-test-autoconfigure:jar:2.0.4.RELEASE:test
[INFO] |  +- com.jayway.jsonpath:json-path:jar:2.4.0:test
[INFO] |  |  \- net.minidev:json-smart:jar:2.3:test
[INFO] |  |     \- net.minidev:accessors-smart:jar:1.2:test
[INFO] |  |        \- org.ow2.asm:asm:jar:5.0.4:test
[INFO] |  +- junit:junit:jar:4.12:test
[INFO] |  +- org.assertj:assertj-core:jar:3.9.1:test
[INFO] |  +- org.mockito:mockito-core:jar:2.15.0:test
[INFO] |  |  +- net.bytebuddy:byte-buddy:jar:1.7.11:test
[INFO] |  |  +- net.bytebuddy:byte-buddy-agent:jar:1.7.11:test
[INFO] |  |  \- org.objenesis:objenesis:jar:2.6:test
[INFO] |  +- org.hamcrest:hamcrest-core:jar:1.3:test
[INFO] |  +- org.hamcrest:hamcrest-library:jar:1.3:test
[INFO] |  +- org.skyscreamer:jsonassert:jar:1.5.0:test
[INFO] |  |  \- com.vaadin.external.google:android-json:jar:0.0.20131108.vaadin1:test
[INFO] |  +- org.springframework:spring-core:jar:5.0.8.RELEASE:compile
[INFO] |  |  \- org.springframework:spring-jcl:jar:5.0.8.RELEASE:compile
[INFO] |  +- org.springframework:spring-test:jar:5.0.8.RELEASE:test
[INFO] |  \- org.xmlunit:xmlunit-core:jar:2.5.1:test
**[INFO] \- io.projectreactor:reactor-test:jar:3.1.8.RELEASE:test
[INFO]    \- io.projectreactor:reactor-core:jar:3.1.8.RELEASE:compile
[INFO]       \- org.reactivestreams:reactive-streams:jar:1.0.2:compile**
[INFO] ------------------------------------------------------------------
```