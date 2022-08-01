# Next Step 따라하기
![](http://image.yes24.com/momo/TopCate935/MidCate008/93474058.jpg)  
http://www.yes24.com/Product/Goods/31869154

프로젝트 시작일 : 2022. 07. 26

## 1. 프로젝트 목적
회원가입, 로그인, 게시글 작성 등 게시판 기능을 전체적으로 한 번 진행함에 따라 기초를 쌓도록 한다.

## 2. 프로젝트 설정
책은 2016년도에 출판 되었기 때문에 2022년 기준으로 새로운 기술을 도입하여 진행하였다.
```
Spring Boot 2.x
Gradle
Thymeleaf
Jpa
Junit 5
h2
```
Spring Boot 에는 Tomcat 이 내장 되어있고 이 Tomcat 에는 Web Server 를 생성해주도록 설정이 되어있기 때문에 책에 있는 `WebServer.java`를 만들지 않아도 된다.

또한, Spring Boot 가 자동으로 프로젝트를 실행할 때에 resources 아래에 있는 `index.html`를 시작 페이지로 잡아주기 때문에 `RequestHandler.java` 파일을 만들지 않아도 된다.

데이터베이스를 이용한 실습은 7장부터 시작되기 때문데 6장까지는 Web Server 흐름을 이해하는 정도로만 숙지하면 되겠다. 사실상 dto, model, util package 에 있는 java 파일 역시 만들지 않아도 된다.

포트 번호를 설정하고 싶을 경우, resource 폴더 아래에 있는 `application.yml`에 설정해주면 된다. `application.properties` 파일로 생성되어있을 경우, 확장자를 변경하여 주도록 하자.

좀 더 상세하게 알고 싶으신 분들은 아래의 링크를 참고 바란다.
https://yadon079.github.io/2021/spring%20boot/servlet-container

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
implementation 'com.h2database:h2'
// JPA
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
```

### 3.2. Git 세팅
`.gitignore`에 민감 정보가 담길 우려가 있는 `application.yml`을 등록한다. 반드시 src 경로부터 적어줘야한다.

GitHub 의 Repository 에 프로젝트를 업로드 하기 위해 Git 을 사용해보자. 방법은 3가지가 있다. 설치 방법은 알아서 검색해보기 바란다.
1. SourceTree 사용
2. IntelliJ Terminal 사용
3. Git Bash 사용

### 3.3. Database 세팅
??? 는 각자 알맞게 적어넣으면 된다.
#### 3.3.1. h2 사용
`Wrong user name or password [28000-214]` 에러가 발생한다면 [여기](https://haema-dev.tistory.com/34)로.
```yaml
spring:
  datasource:
    url: ???
    driver-class-name: org.h2.Driver
    username: ???
```
#### 3.3.2. MySQL 사용
```yaml
spring:
  datasource:
    url: ???
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: ???
```
#### 3.3.3. Oracle 사용
```yaml
spring:
  datasource:
    url: ???
    driver-class-name: oracle.jdbc.driver.OracleDriver
    username: ???
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

개발 과정에 대해서는 [Basic Board](https://haema-dev.tistory.com/category/Project/Basic%20Board)에 기록할 것이니, 혼자서 하기 버거우신 분들은 따라서 해보시길 권장합니다. 그래도 잘 안 되는 부분이 있으신 분들은 [질문](#)을 남겨주세요.
