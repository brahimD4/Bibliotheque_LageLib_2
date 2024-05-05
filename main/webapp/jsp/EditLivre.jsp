<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Modifier livre</title>
  
      <link rel="stylesheet" href="./css/bootstrap.min.css">
      <link rel="stylesheet" href="./css/bootstrap2.min.css">
      <link rel="stylesheet" href="./css/NewLivre.css">

</head>
<body>

  <div class="formulaire">
  
   <form action="UpdateLivre.liv" method="post">
     <div class="mb-3">
        <label for="id" class="form-label">id :</label>
        <input type="text" class="form-control" id="id" name="id" value="${LivreModifier.id}"readonly>
      </div>
      <div class="mb-3">
        <label for="tite" class="form-label">Titre :</label>
        <input type="text" class="form-control" id="titre" name="titre" value="${LivreModifier.titre}">
      </div>
       <div class="mb-3">
        <label for="auteur" class="form-label">Auteur :</label>
        <input type="text" class="form-control" id="auteur" name="auteur" value="${LivreModifier.auteur}">
      </div>
      <div class="mb-3">
        <label for="editeur" class="form-label">Editeur :</label>
        <input type="text" class="form-control" id="editeur" name="editeur" value="${LivreModifier.editeur}">
      </div>
      <div class="mb-3">
        <label for="date" class="form-label">Anne de publication :</label>
        <input type="date" class="form-control" id="date" name="date" value="${LivreModifier.année_de_publication}">
      </div>
      <button type="submit" class="btn btn-primary">Modifier</button>
      
    </form>
  </div>

</body>
</html>