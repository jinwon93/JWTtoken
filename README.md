### Test - POSTMAN

---

### HEADER
ACCESS_TOKEN

---
### API ULR

### SignUp - POST
/user/signUp

id,pw를 입력받아 회원가입을 한다.

ACCESS_TOKEN, REFRESH_TOKEN 발행하여 return
REFRESH_TOKEN은 서버에서 저장

### SignIn - POST
/user/signIn

ACCESS_TOKEN 이 만료될 경우 다시 로그인을 할 경우 해당 유저의 REFRESH_TOKEN을 확인 후 
ACCESS_TOKNE을 재발급 해줍니다.

### Info - GET 
/info

ACCESS_TOKEN이 유효할 때 정보 조회가 가능합니다.
