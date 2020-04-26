<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
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
                    <a class="nav-link" href="http://localhost:8080/logout">Logout</a>
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
                        <a class="dropdown-item" href="http://localhost:8080/food/list">식품목록</a>
                        <a class="dropdown-item" href="http://localhost:8080/eat/list">섭취목록</a>
                        <a class="dropdown-item" href="">회원명단</a>
                    </div>
                </li>
            </ul>

            <div class="float-right div-margin-top">
                <h4> 님 "Hello, SSAFY!"</h4>
            </div>
        </div>
    </nav>
    <!-- ./ 메뉴바 -->
    <hr>
    <form class="form-inline my-2 my-lg-0" action="http://localhost:8080/food/search">
        <input type="hidden" name="action" value="search">

        <div style="width: 100%; text-align:center">
            <select name="sb" class="form-control mr-sm-2">
                <option value="all">전체</option>
                <option value="code">식품코드</option>
                <option value="name">식품명</option>
                <option value="maker">제조사</option>
            </select>
            <input class="form-control mr-sm-2" type="search" name="st" placeholder="Search" aria-label="Search">

            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </div>
    </form>
    <hr>
    <div class="row text-center">
        <c:forEach items="${lists}" var="f">
            <div class="col-sm">
                <div class="card custom-card">
                    <a href="http://localhost:8080/food/detail?code=${f.foodId}"
                       class="product-font-color">
                        <img src="${pageContext.request.contextPath}/res/${f.image}" alt="FOOD"
                             class="card-img-top" style="width: 70% !important;">
                        <div class="card-body">
                            <h4 class="card-title">${f.manufacturer} / ${f.foodName}</h4>
                            <h5>1회 제공량: ${f.amountPerServings}g</h5>
                            <h5>칼로리: ${f.amountPerCalorie} kcal</h5>
                        </div>
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>