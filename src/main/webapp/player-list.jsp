<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Player List | Create Team</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
	crossorigin="anonymous">
<style>
	a{
		text-decoration:none;
	}
</style>
</head>
<body class="container" style="background-color:#ff00ff">
	<div style="padding:30px">
		<div class="row">
			<div class="container" style="background-color:#ff00ff">
				<h3 class="text-center" style="font-family: 'Zen Old Mincho', serif; color: purple;font-size: 50px;">List of Players</h3>
				<hr>
				<br>
				<button class="btn btn-success mb-3"><a href="#createTeam" style="text-decoration:none; color:white; ">CreateTeam</a></button><br>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>PLAYER NAME</th>
							<th>RATING</th>
						</tr>
					</thead>
					<tbody>
					
						<c:forEach var="player" items="${listPlayer}">
	
							<tr>
								<td><c:out value="${player.pid}" /></td>
								<td><c:out value="${player.playername}" /></td>
								<td><c:out value="${player.rating}" /></td>
							</tr>
						</c:forEach>
			
					</tbody>
	
				</table><br>
				
				<div id = "createTeam" class="row">
					<div class="container">
						<h3 class="text-center">List of <span style="color:aqua;">${listMember[0].teamname}</span> Player</h3>
						<hr>
						<div class="container text-left">
			
							<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
								New Player</a>
						</div>
						<br>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>PID</th>
									<th>Player Name</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
							
								<c:forEach var="member" items="${listMember}">
			
									<tr>
										<td><c:out value="${member.pid}" /></td>
										<td><c:out value="${member.playername}" /></td>
										<td><a href="delete?pid=<c:out value='${member.pid}'/>&uid=
										<c:out value='${member.uid}'/>">Delete</a></td>
									</tr>
								</c:forEach>
					
							</tbody>
			
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>