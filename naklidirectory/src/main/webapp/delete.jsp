<%@ page language = "java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8"%>
<html>
<head>
 <style>
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

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
    </style>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <title> Delete :: Nakli Employee Directory</title>
</head>
<body>
    <div class="container-fluid">
    	<!-- NavBar-->
    	<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
		  <a class="navbar-brand" href="#">Nakli Directory</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav">
		      <li class="nav-item active">
		        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="#">About</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="#">Pricing</a>
		      </li>
		    </ul>
		  </div>
		</nav>
		<!-- Jumbotron + Introduction-->
		<div class="jumbotron">
		  <h1 class="display-4">Hello, world!</h1>
		  <p class="lead">This is a Directory Which Aims to Store Details of Employees and Provide Create, Read, Update & Delete Functionality</p>
		  <hr class="my-4">
		  <p>Some More Useless Bakwaaassss....</p>
		  <p class="lead">
		    <a class="btn btn-primary btn-lg" href="#" role="button">Don't Learn more</a>
		  </p>
		</div>
		<!--Create of CRUD-->
		<!--form-->
        <form action="preDelete" method="POST">
              <h1>Enter Employee ID...</h1>
              <div class="form-group">
                  <label for="id">empID</label>
                  <input type="text" class="form-control" id="id" aria-describedby="id" placeholder="Enter EID" name="empID">
              </div>
              <button type="submit" class="btn btn-danger">Proceed</button>
            </form>
		<!--Footer-->
		<div class="container">
		  <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
		    <div class="col-md-4 d-flex align-items-center">
		      <a href="/" class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
		        <svg class="bi" width="30" height="24"><use xlink:href="#bootstrap"/></svg>
		      </a>
		      <span class="mb-3 mb-md-0 text-muted">&copy; 2022 Nakli Directory, Inc</span>
		    </div>
		    <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
		      <li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#twitter"/></svg></a></li>
		      <li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#instagram"/></svg></a></li>
		      <li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#facebook"/></svg></a></li>
		    </ul>
		</footer>
		</div>
    </div>
</body>
</html>