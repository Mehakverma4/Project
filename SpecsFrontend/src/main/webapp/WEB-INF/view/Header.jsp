<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>Home</title>
</head>
<body>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" href="Home">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav"> 
         <li>
         <li class="nav-item">
        <a class="nav-link" href="category">Category</a>
      </li>  
       <li>
         <li class="nav-item">
        <a class="nav-link" href="Product">Product</a>
      </li>  
       
       
      <li>
      <security:athorization access="isAnonymous()">
          <li class="nav-item">
        <a class="nav-link" href="LogIn">Login</a>
      </li>
         <li class="nav-item">
        <a class="nav-link" href="SignUp">SignUp</a>
      </li>  
     </security:athorization>
     
      <security:authorization access="isAuthenticated()">
     
      <li>
         <li class="nav-item">
        <a class="nav-link" href="LogIn">Logout</a>
      </li>  
     
       </security:authorization>
    </ul>
  </div>
   </nav>
   
   
</body>
</html>
