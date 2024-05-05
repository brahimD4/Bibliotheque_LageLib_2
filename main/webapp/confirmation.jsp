<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation</title>
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
  </div>
</nav>
<div class="from-group">
 <label>ID</label>
 <label>${product.id}</label>
</div>
<div class="from-group">
 <label>Name</label>
 <label>${product.name}</label>
</div>
<div class="from-group">
 <label>Quantity</label>
 <label>${product.quantity}</label>
</div>
<div class="from-group">
 <label>Price</label>
 <label>${product.price}</label>
</div>
</div>
</body>
</html>