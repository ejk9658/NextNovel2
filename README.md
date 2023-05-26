# 🎲 [고도화 프로젝트] [그림이 소설이 되는, Next Novel](https://lab.ssafy.com/s08-ai-image-sub2/S08P22A502)

<br>

![logo](docs/img/logo.png)

## ⌛️ 프로젝트 진행 기간

2023.04.10(월) ~ 2023.05.19(금)<br>
SSAFY 8기 2학기 자율 프로젝트

## 🌞 팀원 소개

### 명규당

명규를 기준으로 프론트, 백엔드 신들이 모인 서울 5반 9조

- 강은진 - 팀장, BackEnd
- 이명규 - BackEnd, 인프라
- 이인재 - BackEnd
- 장지웅 - BackEnd
- 소지현 - FrontEnd
- 서철원 - FrontEnd

<br>

## ✨ 고도화 프로젝트 방향

- `Django` 프레임워크로 개발된 서비스를 `Spring Boot` 프레임워크로 개발
- `MSA (Micro Service Architecture)` 구조로 각 서비스별 독립적 개발
- 실운영 서비스만큼의 트래픽을 주고, 성능을 개선하는 개발
- 코드 중복을 줄이고, AI 처리 속도 감소
- 새로운 기능 추가 (결제 시스템, 회원 관리, 유사도 검색 기능)
- 반응형 웹 개발

<br>

## 🏃 Next Novel 의 추가된 기능

### 1) [결제 시스템](https://lab.ssafy.com/s08-final/S08P31A509/-/blob/main/backend/service_payment/README.md)

- 소설 작성에 필요한 포인트를 결제하는 시스템
- 실 운영시 발생하는 트래픽 문제를 해결하기 위해 도입

### 2) 회원 관리

- `Api Gate Way` 에서 `Spring Security` 및 `JWT 토큰`을 적용한 보안 처리
- 기존의 Kakao 로그인 뿐만 아니라 `Google Oauth2` 로그인 추가

### 3) 유사도 검색 기능

- 소설 내용을 검색하기 위한 기능
- 단순한 문자 검색이 아닌, 단어간의 유사도를 바탕으로 소설을 검색

<br>

## ![MSA](docs/img/msa.png) Spring Cloud MSA (Micro Service Architecture) 적용

### ![장고](docs/img/djang.png)`Django` 서버를  ![스프링 클라우드](docs/img/%EC%8A%A4%ED%94%84%EB%A7%81.png)`Spring Cloud` 기반의 `MSA`로 변경함

### [고도화 이전, `Django` 서버]
- 소셜 로그인을 통한 회원관리 기능 + 소설 작성 + 소설 CRUD 기능
- 모든 기능을 하나의 서버에서 관리하는 `Monolithic Architecture`

### [고도화 이후, `Spring Cloud MSA` 서버]
- `회원(8011)` + `소설(8012)` + `결제(8014~8017)` + `검색(8018)` 총 7개의 서비스로 분할
- 서비스 각각에 대한 엔드포인트는 `APIGateway`에서 리버스 프록시로 접근


### 장점
- 각각의 서비스를 독립적으로 개발 할 수 있어 `GitLab` 형상관리, 서비스 의존성, `CI/CD`에서 유용
- 배포 환경에서 장애 발생시, 모든 기능을 정지하지 않고도 Fix 가능
- 서비스의 `추가`, `삭제`, `수정`이 용이

### 단점
- Learning Curve가 큰 편이라 초기 개발 속도 저하 우려
- 분할한 `Micro Service`에 대한 담당자들의 높은 이해가 필수적

### 개선점
- `Kafka`를 사용한 DB 분할 및 부하 분산 시스템 구축(결제 서비스만 적용됨)
- `Kubernetes`를 활용한 무중단 배포 도입


<br>

## ✔️ 아키텍처 구성도

![architecture](docs/img/architecture.png)

## ✔️ ERD

![erd](docs/img/erd.png)

## ✔️ 프로젝트 산출물

- [기능 명세서](https://chipped-cart-851.notion.site/a96e0e004e4c4f39bab65fa821f4825f?v=f77e4329cc5e4b4fbb3a73894ba13c8c)
- [API 명세서 - 회원, 결제](https://www.notion.so/9e2bd3e4fbb744d1ad5bf18dc1e6df6a?v=17131d147e2840b885d3c6dbe2ee21ee&pvs=4)
- [API 명세서 - 소설](https://www.notion.so/2314602a137247208b770252cffebc24?v=bfbcd7265e444ce888f5b116e24bda92&pvs=4)
- [ER-Diagram](docs/img/erd.png)

## ✔️ 프로젝트 결과물

- [포팅 메뉴얼](https://irradiated-apology-665.notion.site/b16c15405eb5480c9d5e4e3176b51fa1)
- [중간 발표 자료](docs/서울_5반_A509_중간발표자료.pptx)
- [최종 발표 자료](docs/서울_5반_A509_발표자료.pdf)
- [UCC 영상](docs/자율PJT_서울_5반_A509_UCC경진대회.mp4)

## ✔️ 프로젝트 파일 구조

```markdown
Repository
│
├── backend
│ │
│ ├── api_gateway
│ │ ├── src
│ │ │ ├── ...
│ │ ├── build.gradle
│ │ ├── ...
│ │
│ ├── eureka_server
│ │ ├── src
│ │ │ ├── ...
│ │ ├── build.gradle
│ │ ├── ...
│ │
│ ├── service_ai
│ │ ├── diffusion
│ │ │ ├── diffusion_ControlNet.py
│ │ │ ├── ...
│ │ ├── app.py
│ │ ├── caption.py
│ │ ├── gpt.py
│ │ ├── ...
│ │
│ ├── service_member
│ │ ├── src
│ │ │ ├── ...
│ │ ├── build.gradle
│ │ ├── ...
│ │
│ ├── service_novel
│ │ ├── src
│ │ │ ├── ...
│ │ ├── build.gradle
│ │ ├── ...
│ │
│ ├── service_payment
│ │ ├── core
│ │ │ ├── src
│ │ │ │ ├── ...
│ │ │ ├── ...
│ │ ├── item-service
│ │ │ ├── src
│ │ │ │ ├── ...
│ │ │ ├── ...
│ │ ├── order-item-service
│ │ │ ├── src
│ │ │ │ ├── ...
│ │ │ ├── ...
│ │ ├── order-service
│ │ │ ├── src
│ │ │ │ ├── ...
│ │ │ ├── ...
│ │ ├── point-service
│ │ │ ├── src
│ │ │ │ ├── ...
│ │ │ ├── ...
│ │ ├── build.gradle
│ │ ├── ...
│ │
│ ├── service_search
│ │ ├── app.py
│ │ ├── ...
│ │
│ ├── ...
│
├── frontend
│ │
│ ├── public
│ │ ├── fonts
│ │ │ ├── ...
│ │ ├── game
│ │ │ ├── ...
│ │ ├── icon
│ │ │ ├── ...
│ │ ├── img
│ │ │ ├── ...
│ │ ├── novel
│ │ │ ├── ...
│ │ ├── ...
│ │
│ ├── src
│ │ ├── api
│ │ │ ├── ...│
│ │ ├── components
│ │ │ ├── common
│ │ │ │ ├── ...
│ │ │ ├── game
│ │ │ │ ├── ...
│ │ │ ├── landing
│ │ │ │ ├── ...
│ │ │ ├── library
│ │ │ │ ├── ...
│ │ │ ├── login
│ │ │ │ ├── ...
│ │ │ ├── mypage
│ │ │ │ ├── ...
│ │ │ ├── novelintro
│ │ │ │ ├── ...
│ │ │ ├── novelread
│ │ │ │ ├── ...
│ │ │ ├── novelwrite
│ │ │ │ ├── ...
│ │ │ ├── payment
│ │ │ │ ├── ...
│ │ │ ├── search
│ │ │ │ ├── ...
│ │ ├── context
│ │ │ ├── ...
│ │ ├── hooks
│ │ │ ├── ...
│ │ ├── pages
│ │ │ ├── ...
│ │ ├── types
│ │ │ ├── ...
│ │ ├── App.css
│ │ ├── App.tsx
│ │ ├── App.test.tsx
│ │ ├── index.css
│ │ ├── index.tsx
│ │ ├── react-app-env.d.ts
│ │ ├── reportWebVitals.ts
│ │ ├── setupTests.ts
│ │
│ ├── ...
│
├── docs
│ ├── img
│ │ ├── ...
│ ├── ...
│
├── exec
│ │
│ ├── 포팅매뉴얼.md
│
├── README.md
├── ...
```

<br>

## 🎲 Next Novel 서비스 화면

### 랜딩

![img](docs/img/랜딩.gif)

### 회원가입

![img](docs/img/회원가입.gif)

### 로그인

![img](docs/img/로그인.gif)

### 카카오 로그인

![img](docs/img/카카오로그인.gif)

### 구글 로그인

![img](docs/img/구글로그인.gif)

### 내정보보기

![img](docs/img/내정보보기.gif)

### 내정보수정

![img](docs/img/내정보수정.gif)

### 소설목록

![img](docs/img/소설목록.gif)

### 소설검색

![img](docs/img/소설검색.gif)

### 소설인트로

![img](docs/img/소설인트로.gif)

### 소설읽기

![img](docs/img/소설읽기.gif)

### 소설감상평작성

![img](docs/img/소설감상평작성.gif)

### 소설작성1

![img](docs/img/소설작성1.gif)

### 소설작성2

![img](docs/img/소설작성2.gif)

### 소설작성3

![img](docs/img/소설작성3.gif)

### 소설작성4

![img](docs/img/소설작성4.gif)

### 소설작성5

![img](docs/img/소설작성5.gif)

### 소설작성6

![img](docs/img/소설작성6.gif)

### 소설작성7

![img](docs/img/소설작성7.gif)

### 소설작성8

![img](docs/img/소설작성8.gif)

### 소설작성9

![img](docs/img/소설작성9.gif)

### 결제시스템

![img](docs/img/결제시스템.gif)

<hr>
