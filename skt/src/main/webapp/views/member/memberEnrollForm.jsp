<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="<%=contextPath %>/views/member/css/memberEnrollForm.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<jsp:include page="/views/common/menubar.jsp" /> 
<br><br><br>
    <div class="content">
        <form action="<%=contextPath %>/insert.me" method="post" id="join-member">
            <h1>회원가입</h1>
            <p>아이디</p>
            <div>
	            <input type="text" name="memId" id="insertId" required>
	            <button type="button" onclick="idCheck()" id="checkBtn">중복확인</button>
	        </div>
            <p>비밀번호</p>
            <input type="password" name="memPwd" required> 
            <p>비밀번호 재입력</p>
            <input type="password" name="memPwdCheck" required>
            <p>이름</p>
            <input type="text" name="memName" required>
            <p>전화번호</p>
            <input type="text" name="phone" required>
            <p>주소</p>
            <input type="text" name="address" required>
            <p>주민등록번호</p>
            <input type="text" name="memNo" required>
            <p>이메일</p>
            <div class="email" required>
            <input type="hidden" name="email" >
            <input type="text" id="emailId">
            <select name="emailDomain" id="emailDomain">
                <option name="email">@naver.com</option>
                <option name="email">@gmail.com</option>
            </select>
        </div>
            <div class="button-container">
                <input type="reset" value="초기화">
                <input type="submit" value="계정생성" onclick="return handleSubmit()">
            </div>
        </form>
    </div>
     <jsp:include page="/views/common/footer.jsp" />
    <script>
    	function insertEmail(){
    		$("#join-member input[name=email]").val($("#emailId").val() + $("#emailDomain").val())
    	}
    	
    	function checkPwd() {
        const pwd = document.querySelector("#join-member input[name=memPwd]").value;
        const pwdCheck = document.querySelector("#join-member input[name=memPwdCheck]").value;

        if (pwd !== pwdCheck) {
            alert("비밀번호가 일치하지 않습니다.");
            return false;
        }
        return true; // 비밀번호가 일치하면 true를 반환
        }

        function handleSubmit() {
            // 이메일을 삽입
            insertEmail();
            // 비밀번호 확인
            return checkPwd(); // 비밀번호가 일치하면 true, 아니면 false
        }
        
        function idCheck(){
        	console.log("함수 실행")
           //중복확인버튼 클릭시 사용자가 입력한 아이디값을 서버에 보내서 조회요청 -> 응답받기
            //1) 사용불가 -> alert메세지출력(이미 존재하는 아이디입니다.)
            //2) 사용가능 -> 진짜사용할거니? ->  ok : 더이상아이디 수정못하게
            //                                 no : 다시 입력하도록 유도

            const idInput = document.querySelector("input[name=memId]");
            console.log(idInput)

            $.ajax({
                type : "get",
                url: "<%=contextPath%>/idCheck.me",
                data : {
                    checkId : idInput.value
                }, 
                success : function(result){
                    if(result === "NNNNY") {
                        if(confirm("사용가능한 아이디입니다. 정말 사용하시겠습니까? ")){
                            idInput.setAttribute("readonly", true);

                            const subminBtn = document.querySelector("input[type=submit]");
                            subminBtn.removeAttribute("disabled");
                        } else {
                            idInput.focus();
                        }
                    } else {
                        alert("사용불가능한 아이디입니다.");
                        idInput.focus();
                    }
                },
                error : function(err){
                    console.log("실패 : ", err)
                }
            })
        }
    </script>
</body>
</html>