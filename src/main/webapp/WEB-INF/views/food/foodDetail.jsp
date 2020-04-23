<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>공지사항</title>
    <meta charset="UTF-8">
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
</head>
    <body>
    <div class="container div-margin-bottom">
        <nav class="navbar sticky-top navbar-expand-lg navbar-light">
            <img src="${pageContext.request.contextPath}/res/img/safefood.jpg" alt="SSAFY" style="width: 70px;">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="http://localhost:8080/food/list">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="http://localhost:8080/food/list">MyPage</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Logout</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="http://localhost:8080/post/main">공지사항</a>
                    </li>

                    <li class="nav-item dropdown active">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Menu
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="http://localhost:8080/eat/list">식품목록</a>
                            <a class="dropdown-item" href="">섭취목록</a>
                            <a class="dropdown-item" href="">회원명단</a>
                        </div>
                    </li>
                </ul>

                <div class="float-right div-margin-top">
                    <h4> 님 "Hello, SSAFY!"</h4>
                </div>
            </div>
        </nav>

    <div class="row text-center">
        <div class="col-6 div-margin-top">
            <img src="${pageContext.request.contextPath}/res/${image}" alt="FOOD"
                 class="product-detail-card text-center div-margin-bottom">

            <div class="margin-auto div-margin-top">
                <a href="http://localhost:8080/food/add?foodId=${foodId}">
                    <button type="button" class="btn btn-primary">담기</button>
                </a>
                <a href="http://localhost:8080/food/list">
                    <button type="button" class="btn btn-primary">식품 목록으로 돌아가기</button>
                </a>
            </div>
            <div class="margin-auto div-margin-top">
                <form action="" method="post">
                    <button class="btn btn-danger" type="submit">식품 삭제</button>
                </form>
            </div>
            <div>
                <canvas id="myChart" width="300" height="300"></canvas>
            </div>
        </div>
        <div class="col-6 div-margin-top table-responsive">
            <table class="table table-hover table-bordered"
                   style="width: 80%;">
                <thead>
                <tr>
                    <th colspan="2">식품 정보</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td style="width: 50%;">식품명</td>
                    <td style="width: 50%;">${food.foodName}</td>
                </tr>
                <tr>
                    <td style="width: 50%;">제조사</td>
                    <td style="width: 50%;">${food.manufacturer}</td>
                </tr>
                <tr>
                    <td style="width: 50%;">1회 제공량</td>
                    <td style="width: 50%;">${food.amountPerServings}g</td>
                </tr>
                <tr>
                    <td style="width: 50%;">1회 제공 칼로리</td>
                    <td style="width: 50%;">${food.amountPerCalorie} kcal</td>
                </tr>
                <tr>
                    <td style="width: 50%;">원료</td>
                    <td style="width: 50%;">${food.material}</td>
                </tr>
                </tbody>
            </table>
        </div>


    </div>
</div>
</body>
</html>