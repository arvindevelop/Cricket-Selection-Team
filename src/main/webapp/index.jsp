<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home | Cricket Team Selection</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
	crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" 
	crossorigin="anonymous"></script>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div style="padding-left:20px">
				<a href="#" class="navbar-brand">Cricket Team Selection </a>
			</div>

			<ul class="navbar-nav">
				<c:if test="${uid != null}">
					<li><a href="<%=request.getContextPath()%>/player"
					class="nav-link">Players</a></li>
				</c:if>
				<c:if test="${uid == null}">
					<li><a href="<%=request.getContextPath()%>/login.jsp"
					class="nav-link">Login/Register</a></li>
				</c:if>
				
			</ul>
		</nav>
	</header>
<section class="first">
	<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
     <img src="https://source.unsplash.com/1200x530/?ipl" class="d-block  w-100 h-50 rounded" />
    </div>
    <div class="carousel-item">
     <img src="https://source.unsplash.com/1200x530/?dhoni" class="d-block  w-100 h-50 rounded" />
    </div>
    <div class="carousel-item">
     <img src="https://source.unsplash.com/1200x530/?cricket" class="d-block  w-100 h-50 rounded" />
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
	
	</section>
	
</body>
</html>