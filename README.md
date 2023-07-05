# be-chess
소프티어 부트캠프 2기 체스 프로젝트


### 7월 3일
#### 미션 1 - 폰 생성
- [x] 체스 규칙 익히기
- [x] 1. Pawn Test
    - [x] PawnTest 클래스 생성
    - [x] create() 메소드 작성
- [x] 2. Pawn class 구현
    - [x] 어느 팀의 말인지 구별하기 위해 white/black 구분해서 생성할 수 있도록 하기
- [x] 3. Refactoring
    - [x] "white", "black" 문자열 중복 제거
    - [x] PawnTest에서 흰색과 검은색 Pawn을 생성하고 결과 값을 확인하는 부분 중복 코드 제거

#### 미션 2 - 체스판 생성
- [x] 1. Board class 구현
  - [x] 여러개의 Pawn 저장 가능해야 함(ArrayList)
- [x] 2. Pawn class 변경
  - [x] 색이 없는 Pawn 생성할 경우 white가 기본값으로 설정되는 생성자 추가
  - [x] white/black Pawn 클래스에 상수화

### 7월 4일
#### 미션 2 - 체스판 생성
- [x] 3. BoardTest
  - [x] BoardTest 클래스 생성
  - [x] create() 메소드 작성
- [x] 4. 패키지 분리
- [x] 5. 추가 테스트
  - [x] 체스판에 Pawn 이외의 객체가 추가되지 않도록 구현(다른 객체 추가 시 컴파일 에러 발생)
- [x] 6. 중복 제거
  - [x] @Before 애노테이션 활용

#### 미션 3 - 체스판 초기화
- [x] 1. 8X8 체스판 초기화
  - [x] Board 클래스에 initialize() 메소드로 초기화
    - [x] Pawn 색에 따라 다른 출력 문자 부여(검정색-P/흰색-p)
    - [x] 중복 코드 리팩토링
  - [x] Board 클래스에 print() 메소드로 출력값 반환
- [x] 2. 게임 시작/종료

### 7월 5일
#### 미션 4 - 기물 배치
- [ ] 1. 개행문자 반복 제거
  - [ ] StringUtils 클래스 구현
- [ ] 2. Pawn을 Piece로 rename
  - [ ] 기물은 이름으로 구분
  - [ ] 인스턴스 생성 후 변경 불가(private constructor)
  - [ ] color, name 받아 객체 생성하는 팩토리 메소드 작성
  - [ ] 기본 생성자 제거
- [ ] 3. 팩토리 메소드 생성
  - [ ] 흰/검 생성 메소드 따로
- [ ] 4. 전체 기물 상태 및 체스판 테스트
- [ ] 5. 흰/검 구분 메소드 추가
- [ ] 6. 리팩토링