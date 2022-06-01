<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Add member</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

    

    <!-- Bootstrap core CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta name="theme-color" content="#7952b3">


    <style>
body {
  height: 100%;
}

body {
  display: flex;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f5f5f5;
}

.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}

.form-signin .checkbox {
  font-weight: 400;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

  </head>
  <body class="text-center">
    
<main class="form-signin">
  <form action ="addmember" method="post">
    <img class="mb-4" src="https://source.unsplash.com/1200x530/?cricket" alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">Add member</h1>

    <div class="form-floating">
      <input type="number" class="form-control" id="floatingInput" placeholder="Uid" name="uid" value="${uid}" disabled>
      <label for="floatingInput">UID</label>
    </div>
	<div class="form-floating">
      <input type="number" class="form-control" id="floatingInput" placeholder="Pid" name="pid" >
      <label for="floatingInput">PID</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="Player name" name="playername">
      <label for="floatingInput">Player Name</label>
    </div>
	<div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="Team name" name="teamname">
      <label for="floatingInput">Team Name</label>
    </div>

    <div class="checkbox mt-3">
    <div class="row">
      <div class=" col-6">
      <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>
      </div>
      <div class=" col-6">
      </div>
      </div>
    </div>
    
  </form>
</main>
   
  </body>
</html>
    