<%@ page import="java.util.Random" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <title>Admin Login</title>
</head>
<body>
<div class="container">

    <div class="row" style="padding-top: 20%">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <h2>Admin Login</h2>
            <%
            Object loginObj = request.getAttribute("loginError");
            if( loginObj != null ){
                String errorMessage = ""+loginObj;
            %>

            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>DİKKAT!</strong> <p> <%=errorMessage%> </p>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%}%>

            <form action="login-servlet" method="post">
                <div class="mb-3">
                    <input type="email" class="form-control" name="email" placeholder="E-mail Giriniz" required>
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control" name="password" placeholder="Şifrenizi Giriniz" required>
                </div>
                <div class="mb-3 form-check">
                    <input name="remember" type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Beni Hatırla</label>
                </div>
                <input class="btn btn-danger" type="submit" value="Giriş">
            </form>
        </div>
        <div class="col-sm-4"></div>
    </div>




<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
</div>
</body>
</html>