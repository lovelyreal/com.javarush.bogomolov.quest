<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Знакомство</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            padding: 20px;
        }
        .container {
            max-width: 700px;
            margin: 50px auto;
        }
        .story-card {
            background: white;
            border-radius: 20px;
            box-shadow: 0 10px 40px rgba(0,0,0,0.2);
            padding: 40px;
            animation: fadeIn 0.8s ease-in;
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }
        .story-text {
            font-size: 1.1rem;
            line-height: 1.6;
            color: #333;
            margin-bottom: 30px;
        }
        .greeting-text {
            background: #f8f9fa;
            padding: 20px;
            border-radius: 15px;
            border-left: 4px solid #667eea;
            margin-bottom: 30px;
            font-style: italic;
        }
        .form-control {
            border-radius: 10px;
            border: 2px solid #e0e0e0;
            padding: 12px;
            font-size: 1rem;
        }
        .form-control:focus {
            border-color: #667eea;
            box-shadow: 0 0 0 0.2rem rgba(102, 126, 234, 0.25);
        }
        .btn-start {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            border: none;
            border-radius: 10px;
            padding: 12px 30px;
            font-size: 1.1rem;
            font-weight: bold;
            transition: transform 0.2s;
        }
        .btn-start:hover {
            transform: translateY(-2px);
            background: linear-gradient(135deg, #764ba2 0%, #667eea 100%);
        }
        h2 {
            color: #667eea;
            margin-bottom: 25px;
            font-weight: bold;
        }
    </style>
</head>

<body>
<div class="container">
    <div class="story-card">
        <h2 class="text-center">📖 Начало истории</h2>

        <div class="story-text">
            <c:out value="">
                Ты на вчерашней тусовке познакомился с одной девушкой.
                Она тебе очень понравилась. И вот в один день ты пригласил её на свидание.
            </c:out>
        </div>

        <div class="greeting-text">
                "Привет, Мерелин! Меня зовут <strong>______</strong>.
                Мы виделись на тусовке в Лос-Анджелесе у Питта.
                Ты мне очень понравилась, и я хочу пригласить тебя на свидание завтра вечером."
        </div>
        <c:if test="${not empty error}">
            <div class="alert alert-danger text-center">
                    ${error}
            </div>
        </c:if>

        <form action="/start" method="post">
            <div class="mb-4">
                <label for="playerName" class="form-label fw-bold">Как тебя зовут?</label>
                <input type="text"
                       class="form-control"
                       id="playerName"
                       name="playerName"
                       required
                       placeholder="Введите ваше имя...">
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary btn-start">
                    ✨ Начать свидание ✨
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>