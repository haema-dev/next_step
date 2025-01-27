# Next Step 따라하기
![](http://image.yes24.com/momo/TopCate935/MidCate008/93474058.jpg)  
http://www.yes24.com/Product/Goods/31869154

프로젝트 시작일 : 2022. 07. 26<br>
프로젝트 일시중지 : 2022. 08. 24<br>
프로젝트 재시작 : 2025. 02. 01<br>


## 1. 프로젝트 목적
회원가입, 로그인, 게시글 작성 등 게시판 기능을 전체적으로 한 번 진행함에 따라 기초를 쌓도록 한다.


## 2. 프로젝트 설정
책은 2016년도에 출판 되었기 때문에 2022년 기준으로 새로운 기술을 도입하여 진행하였다. 그러나 프로젝트를 잠시 일시중시 하는 사이에 3년이 지나버렸기 때문에 일부 버전을 변경해주었다.
```
Java 11  →  Java 17
Spring Boot 2.7.2  →  Spring Boot 3.4.2 (Spring Boot 3.x 버전은 Java 17 이상 호환)
Dependency Management 1.0.12.RELEASE  →  Dependency Management 1.1.7
Gradle 7.4  →  Gradle 8.11.1 (Spring Boot 3.4.2 버전은 7.6.4 이상)
Thymeleaf
Junit 5
Jpa
MySQL
```
Spring Boot 에는 Tomcat 이 내장 되어있고 이 Tomcat 에는 Web Server 를 생성해주도록 설정이 되어있기 때문에 책에 있는 `WebServer.java`를 만들지 않아도 된다.

또한, Spring Boot 가 자동으로 프로젝트를 실행할 때에 resources 아래에 있는 `index.html`를 시작 페이지로 잡아주기 때문에 `RequestHandler.java` 파일을 만들지 않아도 된다.

데이터베이스를 이용한 실습은 7장부터 시작되기 때문데 6장까지는 Web Server 흐름을 이해하는 정도로만 숙지하면 되겠다. 사실상 dto, model, util package 에 있는 java 파일 역시 만들지 않아도 된다.

포트 번호를 설정하고 싶을 경우, resource 폴더 아래에 있는 `application.yml`에 설정해주면 된다. `application.properties` 파일로 생성되어있을 경우, 확장자를 변경하여 주도록 하자.

Tomcat 에는 Java Web Application 을 실행하는 Servlet Container 가 내장되어있다. 앞서 Spring boot 에는 Tomcat 이 내장되어 있다고 했다. 즉, Spring Boot 에도 Servlet Container 가 내장되어 있는 것이다. 단순히 Java Web Application 만을 구현한다면, Web Server 의 구현이 필요하지만 Spring Boot 에서는 그럴 필요가 없다.

또한, Spring Framework 에서는 RequestHandler 를 따로 구현해서 index.html 을 매핑해주는 작업이 필요하다. 그러나 Spring Boot 에서는 resources 아래의 index.html 를 자동으로 인식하도록 내부적으로 구현이 되어있다.

```java
// Spring Boot 내부적으로 이런 과정이 자동화되어 있음
ServletWebServerFactory factory = new TomcatServletWebServerFactory();
WebServer webServer = factory.getWebServer(servletContext -> {
    // 정적 리소스 매핑 (index.html 등)
    servletContext.addResourceMapping("/", "classpath:/static/");

    // DispatcherServlet 등록
    servletContext.addServlet("dispatcherServlet", new DispatcherServlet(applicationContext));
});
```

동작 과정을 한 번 살펴보자.

1) Tomcat 시작
2) ServletContext 생성
3) DispatcherServlet 에 정적 리소스 경로 설정 (classpath:/static/, classpath:/public/ 등)
4) ServletContext 를 DispatcherServlet 에 등록
5) 정적 리소스 매핑 완료
6) Web Server 시작

이러한 자동화 된 설정으로 인해 Spring Boot 에서는 별도의 WebServer 구현이나 RequestHandler 구현 없이도 Web Application 구동이 가능하다.


## 3. 실습 방법 가이드
### 3.1. 개발환경 세팅
test 폴더 아래에 `next_step.zip` 파일이 있다. Spring Boot 와 기본적인 라이브러리들만 Gradle 에 추가하여 프로젝트를 Run 시켰을 때에 `index.html` 화면이 정상적으로 뜨고, 오류가 나지 않을 정도로만 세팅해두었다.

프로젝트를 통째로 내려받은 후, zip 폴더만 따로 압축을 풀어서 IntelliJ 에서 `build.gradle`을 실행시키자. 그리고 `build.gradle`에 아래의 설정을 추가해주자.

```thymeleafexpressions
// Thymeleaf
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
implementation 'nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect'

// Lombok
compileOnly 'org.projectlombok:lombok'
annotationProcessor 'org.projectlombok:lombok'

// Database
runtimeOnly 'com.mysql:mysql-connector-j'

// JPA
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
```

### 3.2. Git 세팅
`.gitignore`에 민감 정보가 담길 우려가 있는 `application.yml`을 등록한다. 반드시 src 경로부터 적어줘야한다.

GitHub 의 Repository 에 프로젝트를 업로드 하기 위해 Git 을 사용해보자. 방법은 3가지가 있다. 설치 방법은 알아서 검색해보기 바란다.
1. SourceTree GUI 사용
2. IntelliJ Terminal/GUI 사용
3. Git Bash 사용

### 3.3. Database 세팅
h2 는 db 를 제대로 못 잡는 에러가 빈번히 발생하여 MySQL 를 사용하기로 했다. 설치는 [여기](https://dev.mysql.com/downloads/installer/) 로. `MySQL Server Only`를 선택해주면 된다.
#### 3.3.1. application.yml
```yaml
# Database
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: #본인 꺼 입력
    username: #본인 꺼 입력
    password: #본인 꺼 입력
  jpa:
    database-platform: org.hibernate.dialect.MySQL8Dialect
    open-in-view: false
    # hibernate 설정
    hibernate:
      ddl-auto: create
    properties:
      hibernate:
        show_sql: true
        format_sql: true
```
#### 3.3.2. build.gradle
```thymeleafexpressions
implementation 'mysql:mysql-connector-java'
runtimeOnly 'mysql:mysql-connector-java'
```

### 3.4. Thymeleaf Path 세팅
`application.yml` 파일의 classpath 를 수정해주면 된다.
```yaml
thymeleaf:
  prefix: classpath:/templates/
  suffix: .html
```


## 4. 마무리
여기까지 성공적으로 마쳤다면 이제 시작할 준비가 끝난 거다. 책을 보면서 개발을 진행해보자.

개발 과정에 대해서는 [Basic Board](https://haema-dev.tistory.com/category/Project/Basic%20Board) 에 기록할 것이니, 혼자서 하기 버거우신 분들은 따라서 해보시길 권장합니다.