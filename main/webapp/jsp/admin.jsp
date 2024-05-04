<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<meta charset="UTF-8">
<title>Espace admin</title>
<link rel="stylesheet" href="../css/utilisateur.css">
</head>
<body>
  <div class="navbar">
        <img id="profil" src="../images/accueil.png" alt="">
     
        <div class="nav" >
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Gestion livres</a>
                </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">Gestion Emprunts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/logout.java">Logout</a>
                </li>
                <li class="nav-item">
                    <div class="profil">
                        <a class="nav-link" href="jsp/profil.jsp"><img id="profil" src="../images/profil.png"></a>
                        <span><%=login%></span>
                    </div>
                
                </li>
            </ul>
        </div>
    </div>
    <div class="content">
    
   
    </div>
</body>
</html>