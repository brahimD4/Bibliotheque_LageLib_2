<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/sinscrire.css">
<title>Page de Connexion</title>
</head>
<body>
  <div class="login-container">
    <h2>Inscription</h2>
    <form action="<%=request.getContextPath()+"/Enregistrer.java" %>"   id="form" method="post">
     
      <div class="form-group">
        <label for="username">User name:</label>
        <input type="text" id="username" name="username" required>
      </div>
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
      </div>
      <div class="form-group">
        <label for="password">Mot de passe:</label>
        <input type="password" id="password" name="password" required>
      </div>
      <div class="form-group">
        <label for="confirm-password">Confirmez le mot de passe:</label>
        <input type="password" id="confirm-password" name="confirm-password" required>
      </div>
      <div class="form-group">
        <button type="submit"> S'inscrire</button>
      </div>
      <span id="message"></span>
    </form>
  </div>
  <script src="main.js" type="text/javascript"></script>
</body>
</html>
