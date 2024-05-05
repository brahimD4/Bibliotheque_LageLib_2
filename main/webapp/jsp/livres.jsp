
<%--<%@ page import="metier.Produit" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
     <%
    String login="";
    if(session.getAttribute("login")!=null){
    	 login=session.getAttribute("login").toString();
    	
    }else{
    	
   	 response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
    }
    %>

<!DOCTYPE html>
<html>
<head>
    <title>Gestion des livres</title>
   
     
 
      <link rel="stylesheet" href="./css/navbar.css">
     <link rel="stylesheet" href="./css/livres.css">
        <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/bootstrap2.min.css">
</head>
<body>

 <div class="navbare">
        <img id="profil" src="./images/pile-de-livres.png" alt="">
     
        <div class="nave" >
            <ul class="navbar-nave">
                <li class="nave-item">
                    <a class="nave-link" href="#">Home</a>
                </li>
                <li class="nave-item">
                    <a class="nave-link" href="<%=request.getContextPath()%>/livres.liv">Gestoion livres</a>
                </li>
                <li class="nave-item">
                    <a class="nave-link" href="#">Gestoion Emprunts</a>
                </li>
                <li class="nave-item">
                    <a class="nave-link" href="<%=request.getContextPath()%>/logout.java">Logout</a>
                </li>
                <li class="nave-item">
                    <div class="profil">
                        <a class="nave-link" href="jsp/profil.jsp"><img id="profil" src="./images/profil.png"></a>
                    <%--     <span><%=login%></span> --%>
                    </div>
                
                </li>
            </ul>
        </div>
    </div>

<div class="content">

  <div class="panel panel-primary ">
    <div class="panel-heading d-flex justify-content-between align-items-center">
      <span>les livres </span>
      <form class="navbar-form navbar-center " action="chercher.liv" method="get">
            <input type="text" class="form-control" placeholder="Search" name="motCle" value="${livre_recherche.motCle}">
            <button type="submit" class="btn btn-default">recherche</button>
        
      </form>
      <a class="navbar-brand" href="./html/NewLivre.html" id="newLivre"><img id="icon_Ajouter" src="images/plus.png"></a>
     
    </div>
        
    <div class="panel-body">
        <table class="table table-bordered">
            <thead>
              <tr>
                <th>ID_livre</th>
                <th >Titre</th>
                <th>Auteur</th>
                <th>Editeur</th>
                <th>Anne de publication</th>
                <th >Supprimer</th>
                <th >Modifier</th>
              </tr>
            </thead>
            <tbody>
            
               <c:forEach items="${Touslivres.livres}" var="liv">
		             <tr>
		                 <td>${liv.id}</td>
		                 <td>${liv.titre}</td>
		                 <td>${liv.auteur}</td>
		                 <td>${liv.editeur}</td>
		                 <td>${liv.année_de_publication}</td>
		                 <td><a href="Supprimer.liv?id=${liv.id}"><img class="action_icon" src="images/supprimer.png"></a></td>
		                 <td><a href="Edit.liv?id=${liv.id}"><img class="action_icon" src="images/editer.png"></a></td>	
		               </tr>
               </c:forEach>

                <c:forEach items="${livre_recherche.livres}" var="liv">
		             <tr>
		                 <td>${liv.id}</td>
		                 <td>${liv.titre}</td>
		                 <td>${liv.auteur}</td>
		                 <td>${liv.editeur}</td>
		                 <td>${liv.année_de_publication}</td>
                         <td><a href="Supprimer.liv?id=${liv.id}"><img class="action_icon" src="images/supprimer.png"></a></td>
		                 <td><a href="Edit.liv?id=${liv.id}"><img class="action_icon" src="images/editer.png"></a></td>		               
		             </tr>
               </c:forEach> 
             
            </tbody>
          </table>
    </div>
    <!-- <div class="panel-footer">Panel Footer</div> -->
  </div>
</div>


 
<!-- <script src="js/main.js"></script> -->

</body>

</html>