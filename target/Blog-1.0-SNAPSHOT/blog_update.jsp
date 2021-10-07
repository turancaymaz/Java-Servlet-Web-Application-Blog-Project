<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="props.Admin" %>
<%@ page import="props.Blog" %>
<jsp:useBean id="util" class="utils.Util"></jsp:useBean>
<% Admin adm = util.isLogin(request, response); %>

<jsp:useBean id="dbUtil" class="utils.DBUtil"></jsp:useBean>

<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
  <title>Blog Update</title>
</head>
<body>
<div class="container">
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Blogger</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="dashboard.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="about.jsp">Hakkında</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="contact.jsp">İletişim</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Profile
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">

              <li><hr class="dropdown-divider"></li>
              <li><a class="dropdown-item" href="logout">Çıkış</a></li>
            </ul>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true"><%=adm.getName()%></a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <hr/>

  <div class="row">
    <div class="col-sm-6">
      <h2>Blog Düzenle</h2>
      <%
        Blog blo = (Blog) request.getAttribute("blo");
      %>
      <form action="blog-update" method="post">
        <div class="mb-3">
          <input value="<%=blo.getAuthor()%>" type="text" name="author" placeholder="Blog Yazarı" class="form-control"/>
        </div>
        <div class="mb-3">
          <input value="<%=blo.getTitle()%>" type="text" name="title" placeholder="Blog Başlıgını Giriniz" class="form-control"/>
        </div>
        <div class="mb-3">
          <input value="<%=blo.getContent()%>" type="text" name="content" placeholder="Blog İçerik" class="form-control"/>
        </div>
        <div class="form-floating">
          <textarea value="<%=blo.getDetail()%>" name="detail" class="form-control" placeholder="Blog Detay" id="floatingTextarea2" style="height: 200px"></textarea>
          <label for="floatingTextarea2">Comments</label>
          <br>
        </div>
        <button type="submit" class="btn btn-success">Güncelle</button>



      </form>
    </div>


  </div>


  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

</div>
</body>
</html>
