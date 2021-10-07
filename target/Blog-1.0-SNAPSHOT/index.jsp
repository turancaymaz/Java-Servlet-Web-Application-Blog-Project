<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:useBean id="util" class="utils.Util"></jsp:useBean>


<jsp:useBean id="dbUtil" class="utils.DBUtil"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <title>Blog Projesi</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp">Blogger</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about.jsp">Hakkında</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contact.jsp">İletişim</a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>

    <div class="card">
        <c:if test="${dbUtil.allBlog().size() > 0}">

        <c:forEach items="${ dbUtil.allBlog() }" var="item">
            <div class="card-body">
                <h5 class="card-header"><c:out value="${item.title}"></c:out></h5>
                <p class="card-text"><c:out value="${item.content}"></c:out></p>
                <a href="blog-list?bid=${item.bid}" class="btn btn-primary">Detaylı Oku</a>
            </div>
            </c:forEach>
            </c:if>

    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
</body>
</html>