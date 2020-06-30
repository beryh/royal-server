# Royal Server
---
- Spring Boot 2.3.0
- Spring Web MVC
- Multi module을 기본 골격으로 가지도록 작성

## 개발환경
 - [VS Code](https://code.visualstudio.com/download)
   - 필요 Extensions
     - [Gradle Tasks](https://marketplace.visualstudio.com/items?itemName=richardwillis.vscode-gradle)
     - [Java Extention Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
     - [Language Support for Java](https://marketplace.visualstudio.com/items?itemName=redhat.java)
     - [Lombok Annotations Support for VS Code](https://marketplace.visualstudio.com/items?itemName=GabrielBB.vscode-lombok)
     - [Spring Boot Tools](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-spring-boot)
     - [Git Extension Pack](https://marketplace.visualstudio.com/items?itemName=donjayamanne.git-extension-pack)
     - [Docker](https://marketplace.visualstudio.com/items?itemName=ms-azuretools.vscode-docker)

 - Docker
   - Docker for windows
   - Docker for mac
   - Linux

## 아키텍쳐
 - TBD

## 주요 기능 명세
 - [GET] /health : 서버의 정상 동작 여부를 확인
 - [GET] /api/roulette/rewards?level={level} : 요청된 레벨의 룰렛 리워드 조회
 - [POST] /api/roulette/spin : 로그인 한 (현재는 더미 유저)로 룰렛을 돌림. 획득한 리워드 정보를 반환받음.
   
## 설치 및 구동법
### VsCode
- https://m.blog.naver.com/PostView.nhn?blogId=humy2833&logNo=221491910099&categoryNo=39&proxyReferer=https:%2F%2Fwww.google.com%2F
- https://medium.com/@eungook/vscode%EC%97%90%EC%84%9C-gradle%EB%A1%9C-spring-boot-%EC%84%B8%ED%8C%85%ED%95%98%EA%B8%B0-ac520fc2b772
- Ctrl+Shfit+P -> Run a Gradle Build -> clean bootJar

### Windows 
- [Docker Toolbox 설치](https://steemit.com/kr/@mystarlight/docker)

### MacOS

### Linux
