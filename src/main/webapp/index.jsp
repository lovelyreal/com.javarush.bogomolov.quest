<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Опросник</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f8f9fa; }
        .container { max-width: 600px; margin-top: 100px; text-align: center; }
        .btn-start { font-size: 1.5rem; padding: 10px 30px; }
    </style>
</head>
<body>
<div class="container">
    <div class="card shadow">
        <div class="card-body">
            <h1 class="card-title">Доброго времени суток!</h1>
            <p class="card-text">Я создал маленькую историю, в которой именно ты - главный герой.</p>
            <a href="<c:url value='/greetings'/>"
               class="btn btn-primary btn-start">
                Начать
            </a>
        </div>
    </div>
</div>
</body>
</html>