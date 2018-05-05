<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
    <title>ANASAYFA</title>

    <link href='<s:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" />
    <link href='<s:url value="/resources/css/anasayfa.css"/>' rel="stylesheet" />
</head>
<body>
<div class="container">
    <div class="row">
        <div class="center-box">
            <a type="submit" class="btn btn-primary" href="/login">SIGN IN</a>
            <a type="submit" class="btn btn-success" href="/register">SIGN UP</a>
        </div>
    </div>
</div>
</body>
</html>
