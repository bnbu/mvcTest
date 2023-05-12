# 5월12일 고객MVC JDBC 과제

### 프로젝트 클론 후 할 일
1. src/main/lib/oracle.properties 파일 내 자신의 DB정보 입력하기
2. jdbc 관련 라이브러리 다운로드 후 프로젝트에 추가 [ojdbc8 다운로드 링크](https://www.oracle.com/kr/database/technologies/appdev/jdbc-downloads.html)

### 프로젝트 
* 메뉴 <br>
![메뉴](https://file.notion.so/f/s/260dacc4-c3dd-4192-9262-918cbb0d7e5a/Untitled.png?id=2fe837ef-a326-4082-ba60-899c91f0a81b&table=block&spaceId=a841bca1-475f-452d-9dc7-6a71aea49c34&expirationTimestamp=1683984620231&signature=aAs8nBTBOlfTw_WTBxiw98D7iMTWs6hhXl6IDPocO4A&downloadName=Untitled.png)
* 전체 조회 <br>
![전체조회](https://file.notion.so/f/s/c496cd45-0311-4842-8c68-e5c187e202a1/Untitled.png?id=503c7528-8b19-4116-ae5d-7c60f08be7a3&table=block&spaceId=a841bca1-475f-452d-9dc7-6a71aea49c34&expirationTimestamp=1683984810521&signature=mltknBFt7pRZWuK18uxL-BpZ6QEExjhE1J6Xugp_sJY&downloadName=Untitled.png)
* 레코드 추가 <br>
![레코드추가](https://file.notion.so/f/s/84a824c1-497d-4753-80f7-5e3565db2bf9/Untitled.png?id=b0acb871-4863-4dfa-8e55-b8b6916c6c23&table=block&spaceId=a841bca1-475f-452d-9dc7-6a71aea49c34&expirationTimestamp=1683985081344&signature=LIc58tBf1DhyekFy5bGWzeaULFERjbZgt5y2faQklWo&downloadName=Untitled.png)
![레코드추가2](https://file.notion.so/f/s/590bed6c-45a1-4b9a-ba69-8e0a9ec5878c/Untitled.png?id=6cd874a8-7d81-46ea-9218-25ee4fd5ab28&table=block&spaceId=a841bca1-475f-452d-9dc7-6a71aea49c34&expirationTimestamp=1683985213580&signature=kqA1NzsG5eGtNp9K3YEoQlRp8WIAVIB9L3xtu5IJGbM&downloadName=Untitled.png)
* 레코드 수정 <br>
![레코드수정](https://file.notion.so/f/s/3cec653e-432d-4944-ab83-504c1dfe0053/Untitled.png?id=5b6aae70-99db-4bbd-a4d0-41b4dfd69794&table=block&spaceId=a841bca1-475f-452d-9dc7-6a71aea49c34&expirationTimestamp=1683985327053&signature=iTbZqn4W-MLAMv47nPxLpaCcPPH-S4noJ9E7FN3YvGs&downloadName=Untitled.png)
![레코드수정2](https://file.notion.so/f/s/eacf0e91-7c74-454e-82b1-1917691663f3/Untitled.png?id=d4b71bc4-7ba9-4902-8346-be0ae779ae9a&table=block&spaceId=a841bca1-475f-452d-9dc7-6a71aea49c34&expirationTimestamp=1683985349596&signature=nGvHRoPSbl17tGvXHvb8gvFZr6a8_yQR24hRg8jccL4&downloadName=Untitled.png)
* 레코드 삭제 <br>
![레코드삭제](https://file.notion.so/f/s/0724b6f8-bf89-4e9d-87cc-3f01e9d7705a/Untitled.png?id=99707710-d0ea-4267-a71d-4a1f7eb16c55&table=block&spaceId=a841bca1-475f-452d-9dc7-6a71aea49c34&expirationTimestamp=1683986090814&signature=rPnLe_DVxWgeLakpXhFh59WW44cNkdvPCFZiXoQEato&downloadName=Untitled.png)
* 조건에 의한 검색(ex> gno) <br>
![조건검색](https://file.notion.so/f/s/57ab9f95-11ae-49fe-afbd-9265b26bf31a/Untitled.png?id=fba6356d-84cb-4136-9e0d-749b515dfabb&table=block&spaceId=a841bca1-475f-452d-9dc7-6a71aea49c34&expirationTimestamp=1683986183399&signature=nan8hjy-g5uH86jfCaCULW0gpTJ41pyYffQ2sKWVhpQ&downloadName=Untitled.png)
![조건검색2](https://file.notion.so/f/s/716d5353-8c8b-4bd1-a439-d6cde8a223ea/Untitled.png?id=c6d6aa4c-79fc-4a94-8d38-6000406b5d13&table=block&spaceId=a841bca1-475f-452d-9dc7-6a71aea49c34&expirationTimestamp=1683986217064&signature=byB2juYjlfqYgHsfpvKNXbYi34yJxulxE5TUAUhg9xU&downloadName=Untitled.png)
* 프로그램 종료 <br>
![프로그램종료](https://file.notion.so/f/s/61315ec8-2476-44f7-b19b-fbe7c2158bcb/Untitled.png?id=8a291030-34fa-468b-ab67-927e19a3c4eb&table=block&spaceId=a841bca1-475f-452d-9dc7-6a71aea49c34&expirationTimestamp=1683985999005&signature=kCy8qdTZiZvCDjOCslFQGNDopxElsz-KT2zcdpJ5bk0&downloadName=Untitled.png)



### 에러
* OracleDriver 관련 [ojdbc8 다운로드 링크](https://www.oracle.com/kr/database/technologies/appdev/jdbc-downloads.html)
<br> ojdbc8-full.tar.gz 다운 후 ojdbc8.jar oraclepki.jar 프로젝트 BuildPath에 추가

