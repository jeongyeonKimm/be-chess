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
- [x] 1. 개행문자 반복 제거
  - [x] StringUtils 클래스 구현
- [x] 2. Pawn을 Piece로 rename
  - [x] 기물은 이름으로 구분
  - [x] 인스턴스 생성 후 변경 불가(private constructor)
  - [x] color, name 받아 객체 생성하는 팩토리 메소드 작성
  - [x] 기본 생성자 제거
- [x] 3. 팩토리 메소드 생성
  - [x] 흰/검 생성 메소드 따로
- [x] 4. 전체 기물 상태 및 체스판 테스트
- [x] 5. 흰/검 구분 메소드 추가
- [x] 6. 리팩토링


#### 미션 5 - 기물 위치 부여 및 점수 계산
- [x] 1. 기물 색, 종류 enum 구현
  - [x] 식별 문자는 소문자만 관리(Character.toUpperCase() 메소드를 활용해 대문자로 변경)
- [x] 2. Piece의 색, 종류에 enum 사용
  - [x] 색과 기물의 종류에 따라 다른 Piece 생성하는 팩토리 메소드 구현
  - [x] 기물이 존재하지 않는 경우도 createBlank() 메소드 구현
- [s] 3. 팩토리 메소드 리팩토링(중복 코드 제거)

### 7월 6일
#### 미션 5 - 기물 위치 부여 및 점수 계산
- [x] 4. 체스판의 모든 칸 Piece로 초기화
  - [x] 체스판의 row에 해당하는 부분인 Rank를 이용해 ArrayList<ArrayList<Piece>> 대신 ArrayList<Rank> 고려
- [x] 5. 기물과 색에 해당하는 기물의 개수 반환
- [x] 6. 주어진 위치의 기물 조회
- [x] 7. 임의의 기물을 체스판 위에 추가
  - [x] 빈 체스판 생성 후 임의의 위치에 기물 추가
  - [x] 위치값 전담 클래스 구현
- [x] 8. 점수 계산
  - [x] 같은 줄에 같은 색의 pawn이 존재하면 0.5점
  - [x] 한 개의 기물이 있는 체스판에서 부터 시작해 하나씩 기물을 추가하면서 구현
  - [x] enum 클래스의 생성자를 통해 점수 값 추가 가능
- [x] 9. 기물의 점수가 높은 순으로 정렬
  - [x] 낮은 순서로도 정렬해보기
  - [x] 각 색에 해당하는 모든 기물을 자바 Collection에 저장
- [x] 10. 리팩토링