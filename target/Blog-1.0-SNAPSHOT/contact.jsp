<%--
  Created by IntelliJ IDEA.
  User: turan
  Date: 11.08.2021
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <title>Contact</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/contact.css" />
</head>
<body style="background-color: lavender">
<form action="contact-servlet" method="post" >
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
        <div class="row">
            <div class="col-sm-8">
                <h2>Bizimle İletişime Geçin!</h2>
                <form action="contact-servlet" method="post">
                    <div class="mb-3">
                        <input type="text" name="name" placeholder="Adınız" class="form-control"/>
                    </div>
                    <div class="mb-3">
                        <input type="text" name="email" placeholder="Mail Adresiniz" class="form-control"/>
                    </div>
                    <div class="mb-3">
                        <input type="text" name="phone" placeholder="Telefon Numaranız" class="form-control"/>
                    </div>
                    <div class="form-floating">
                        <textarea name="message" class="form-control" placeholder="Messajınızı Yazınız" id="floatingTextarea2" style="height: 200px"></textarea>
                        <label for="floatingTextarea2">Message</label>
                        <br>
                    </div>
                    <button type="submit" class="btn btn-success">Gönder</button>



                </form>
            </div>




        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </div>
</form>


</body>
</html>

