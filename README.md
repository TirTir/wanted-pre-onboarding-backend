# wanted-pre-onboarding-backend

<br>

## ✨ Entity Diagram
<img width="767" alt="image" src="https://github.com/user-attachments/assets/56a5b15f-54b0-4b92-86b3-48eead96e18c">

<br>
<br>

## 💻 개발환경
- **Version** : Java 17
- **IDE** : IntelliJ
- **Framework** : SpringBoot 3.3.2
- **ORM** : JPA

<br>
<br>

## 📌 프로젝트 구조
- API 공통 응답 형식
  - 오류 및 공통 응답을 표준화하여 API 응답을 체계적으로 관리하였습니다.
  - 에러 코드와 메시지를 정의하여, 클라이언트 측에서 에러 핸들링을 처리할 수 있도록 하였습니다.
  
  ```json
  {
      "status": "OK",
      "message": "채용 공고 등록 성공",
      "data": null
  }
  ```
  ```json
  {
    "success": false,
    "status": "NOT_FOUND",
    "message": "존재하지 않는 공고입니다."
  }
  ```

- DTO
  - 데이터베이스 엔티티와 DTO를 분리하여 데이터의 직접 노출을 방지하였습니다.
  - className 간편화를 위하여 엔티티 별로 DTO를 Inner class 로 관리하였습니다.
 
- 구현 과정
  - 엔티티 설계
  - DTO 생성
  - service / repository 생성
  - controller 생성

<br>
<br>

## 📌 주요 기능
### 채용공고 등록
- 회사는 새로운 채용공고를 등록합니다.
- 회사 ID로 회사를 찾고, 없을 경우 예외를 발생시킵니다.
- RecruitPost 객체 생성 후 저장합니다.

<br>

### 채용공고 수정
- 회사는 기존 채용공고를 회사Id 이외 수정할 수 있습니다.
- 채용 공고 ID로 채용 공고를 찾고, 없을 경우 예외를 발생시킵니다.
- UpdatePost DTO를 이용하여 업데이트를 수행합니다.
- null 값이나 0 값을 가진 필드는 업데이트되지 않습니다.

<br>

### 채용공고 삭제
- 회사는 특정 채용공고를 삭제할 수 있습니다.
- 채용 공고 ID로 채용 공고를 찾아 삭제하고, 없으면 예외를 발생시킵니다.

<br>

### 채용공고 목록
- 채용 목록 페이지
  - 모든 채용공고를 조회하여 각 채용공고의 기본 정보를 리스트로 반환합니다.
  ```json
      {
      "status": "OK",
      "message": "채용 공고 조회 성공",
      "data": [
          {
            "postId": 28,
            "companyName": "노매딕피스",
            "nation": "한국",
            "region": "서울",
            "position": "백엔드",
            "reward": 2000000,
            "skills": "Typescript"
          },
          {
            "postId": 29,
            "companyName": "원티드",
            "nation": "한국",
            "region": "서울",
            "position": "백엔드",
            "reward": 3000000,
            "skills": "JAVA"
          }
      ]
  }
  ```
- 채용 상세 페이지
  - 회사 ID와 현재 채용공고 ID를 파라미터로 받아 특정 회사에서 현재 공고를 제외한 다른 채용공고 ID 리스트를 반환합니다.
  ```json
      {
      "status": "OK",
      "message": "채용 공고 조회 성공",
      "data": {
          "postId": 14,
          "companyName": "노매딕피스",
          "nation": "한국",
          "region": "서울",
          "position": "백엔드 개발자",
          "reward": 100000,
          "description": "test description",
          "skills": "Java, Spring",
          "otherRecruitPosts": [15, 16]
          }
      }
  ```

<br>

## 🖋 Unit Test
### recruitPostServiceTest
- 각 테스트 메서드는 등록, 수정, 삭제 기능의 성공 여부를 검증합니다.
- 테스트 실행 전 데이터베이스를 초기화하고 필요한 데이터를 설정하여 일관된 테스트 환경을 제공합니다.

<br>
<br>

## 📖 Commit Message Convention
- Feat : 기능 추가
- Add : 코드 추가 ( 어떠한 기능 내에 기능을 더 추가할 때 )
- Modify : 코드 수정 ( 버그 등 수정하는 모든 과정들 )
- Delete : 코드 삭제

<br>
<br>
