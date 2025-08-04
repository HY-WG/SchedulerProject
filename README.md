## 이름 및 설명
- 이름: 기본 스케줄러  
- 설명: 작성자 ID나 별도 ID 없이 일정을 조회할 수 있습니다. 개별 일정에 대해 댓글을 달 수 있고, 댓글을 조회할 수 있습니다. 작성한 글은 수정할 수 있습니다.

## 기본 정보
- Host 주소: [`/api/schedules`](http://localhost:8080/api/schedules/1)

| HTTP Method | Endpoint                | 설명          | 요청 Body             | 응답 Body             |
|-------------|-------------------------|---------------|------------------------|------------------------|
| POST        | /api/schedules          | 일정 생성     | ScheduleRequestDto     | ScheduleResponseDto    |
| GET         | /api/schedules          | 전체 일정 조회 | 없음                  | List<ScheduleResponseDto> |
| GET         | /api/schedules/{id}     | 단일 일정 조회 | 없음                  | ScheduleResponseDto    |
| PUT         | /api/schedules/{id}     | 일정 수정     | ScheduleRequestDto     | ScheduleResponseDto    |

---

### Request

- **Header**
  - Content-Type: application/json

- **Parameter**
  - 없음

- **Body**
```json
{
 "title": "점심",
  "content": "도시락 먹기",
  "writer": "김미미",
  "password": "5678"
}

```

### Request

- **Header**
  - Content-Type: application/json

- **Parameter**
  - 없음

- **Body**
```json
{
 "id": 5,
    "title": "점심",
    "content": "도시락 먹기",
    "writer": "김미미",
    "createdAt": "2025-08-04T10:14:47.6627124",
    "modifiedAt": "2025-08-04T10:14:47.6627124",
    "comments": []
}
```

### ERD

| Schedule | Type  | 설명          | 
|----------|-------|---------------|
| id       | Long   | 식별자       | 
| title    | String | 일정 제목    | 
| content  | String | 식별자       | 
| writer   | String | 일정 작성자  | 
| password | String | 비밀번호     | 
|createdAt | DateTime| 생성 시간   | 
|modifiedAt| DateTime | 수정 시간  | 



