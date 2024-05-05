<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<title>Historique</title>
</head>
<body>
	<nav class="navbar navbar-expand-md">
		<img class="img1" src="OIP.jpeg" alt="">
		<div class="collapse navbar-collapse" id="main-navigation">
		<ul class="navbar-nav">
			<li class="nav-item">                         
			<a class="nav-link" href="#">Home</a></li>
			<li class="nav-item">
			<a class="nav-link" href="#">About</a></li>
			<li class="nav-item">
			<a class="nav-link" href="#">Contact</a></li>
			<li class="nav-item"><a class="nav-link" href="login.html">login</a></li>
			<li class="nav-item"><a class="nav-link" href="signip.html">sign up</a></li>
			<form action="chercher.java" class="form-inline my-2 my-lg-0">
		      <input name="motCle" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
		      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		    </form>
			</ul>
		</div>
	</nav>
	<div class="container">
	<c:forEach items="${mo.historiques}" var="L">
	  <div class="card text-white bg-secondary mb-3" style="width: 18rem;">
	  <div class="card-body">
	    <h5 class="card-title"></h5>
	    <h3 class="card-text">${L.titre}</h3>
	    <h3 class="card-text">${L.auteur}</h3>
	    <p class="card-text">Date de retour: ${L.date_emprunt}</p>
	     <p class="card-text">Date de retour: ${L.date_retour}</p>
	      <p class="card-text">Statut: ${L.statut}</p>
	  </div>
	</div>
	</c:forEach>
	<c:forEach items="${model.historiques}" var="L">
	  <div class="card text-white bg-secondary mb-3" style="width: 18rem;">
	  <div class="card-body">
	    <h5 class="card-title"></h5>
	    <h3 class="card-text">${L.titre}</h3>
	    <h3 class="card-text">${L.auteur}</h3>
	    <p class="card-text">Date de retour: ${L.date_emprunt}</p>
	     <p class="card-text">Date de retour: ${L.date_retour}</p>
	      <p class="card-text">Statut: ${L.statut}</p>
	</div>
	</c:forEach>
	</div>
	</div>
</body>
</html>