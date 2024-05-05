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
<title>page users</title>

  <link rel="stylesheet" href="../css/navbar.css">
 
</head>
<body>

    <div class="navbare">
       <img id="profil" src="../images/pile-de-livres.png" alt="">
     
        <div class="nave" >
            <ul class="navbar-nave">
                <li class="nave-item">
                    <a class="nave-link" href="#">Home</a>
                </li>
                <li class="nave-item">
                    <a class="nave-link" href="#">Book List</a>
                </li>
                <li class="nave-item">
                    <a class="nave-link" href="#">Favoris</a>
                </li>
                <li class="nave-item">
                    <a class="nave-link" href="<%=request.getContextPath()%>/logout.java">Logout</a>
                </li>
                <li class="nave-item">
                    <div class="profil">
                        <a class="nave-link" href="#"><img id="profil" src="../images/profil.png"></a>
                        <span><%=login%></span>
                    </div>
                
                </li>
            </ul>
        </div>
    </div>
    <div class="content">
    
   <h1>bonjour <%=login%></h1>
    </div>

</body>
</html>