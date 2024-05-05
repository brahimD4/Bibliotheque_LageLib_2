<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PharmacyStock</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="ajouter.do">Ajouter</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="index.do">Home</a>
      </li>
    <form action="chercher.do" method="get" class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search" name="motCle" value="${model.motCle}">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
<table class="table table-dark">
    <tr>
      <th>id</th>
      <th>Name</th>
      <th>Quantity</th>
      <th>Price</th>
    </tr>
    <c:forEach items="${model.products}" var="p">
     <tr>
	    <td>${p.id}</td>
	    <td>${p.name}</td>
	    <td>${p.quantity}</td>
	    <td>${p.price}</td>
     </tr>
    </c:forEach>
</table>
</div>
</body>
</html>