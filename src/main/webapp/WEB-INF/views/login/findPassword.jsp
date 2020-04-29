<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>비밀번호 찾기</title>

    <link rel="icon" href="${pageContext.request.contextPath}/res/img/ssafy.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/res/css/application.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/res/js/login.js"></script>
    <script src="${pageContext.request.contextPath}/res/js/findpw.js"></script>
</head>
<body>
<div class="container text-center login-margin-top">
    <div>
        <h1>비밀번호 찾기</h1>
    </div>
    <hr>

    <form action="http://localhost:8080/findPassword" method="post">
        <input type="hidden" name="action" value="findPw">

        <div class="form-group">
            <input class="form-control margin-auto login-input-width"
                   type="text" id="id" name="id"
                   placeholder="ID를 입력하세요.">

            <c:if test="${errorMessages.idError != null}">
                <span class="error">${errorMessages.idError}</span>
            </c:if>
        </div>

        <div class="form-group">
            <input class="form-control margin-auto login-input-width"
                   type="text" id="name" name="name"
                   placeholder="이름을 입력하세요.">

            <c:if test="${errorMessages.nameError != null}">
                <span class="error">${errorMessages.nameError}</span>
            </c:if>
        </div>
        <hr>
        <div>
            <button class="btn btn-primary" type="submit" onclick="validate();">비밀번호 찾기</button>
        </div>
    </form>
</div>

</body>
</html>