<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>

<title>Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-5">

<div class="card p-4 shadow">

<h3 class="text-center mb-4">Login</h3>

<form:form method="post" action="login" modelAttribute="user">

<div class="mb-3">

<label>Email</label>

<form:input path="email" cssClass="form-control" placeholder="Enter your email"/>

</div>

<div class="mb-3">

<label>Password</label>

<form:password path="password" cssClass="form-control" placeholder="Enter password"/>

</div>

<button class="btn btn-primary w-100">

Login

</button>

</form:form>

<p class="text-center mt-3">

Don't have an account?

<a href="signup">Sign up here</a>

</p>

</div>

</div>

</div>

</div>

</body>

</html>
=====================================================================================================================================

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>

<title>Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-5">

<div class="card p-4 shadow">

<h3 class="text-center mb-4">Login</h3>

<!-- Signup success message -->
<c:if test="${not empty successMessage}">
<div class="alert alert-success">
${successMessage}
</div>
</c:if>

<!-- Login error message -->
<c:if test="${not empty error}">
<div class="alert alert-danger">
${error}
</div>
</c:if>

<form:form method="post" action="login" modelAttribute="user">

<div class="mb-3">

<label>Email</label>

<form:input path="email" cssClass="form-control" placeholder="Enter your email"/>

</div>

<div class="mb-3">

<label>Password</label>

<form:password path="password" cssClass="form-control" placeholder="Enter password"/>

</div>

<button class="btn btn-primary w-100">

Login

</button>

</form:form>

<p class="text-center mt-3">

Don't have an account?

<a href="signup">Sign up here</a>

</p>

</div>

</div>

</div>

</div>

</body>

</html>
==================================================================================================================




<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>

<title>Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-5">

<div class="card p-4 shadow">

<h3 class="text-center mb-4">Login</h3>

<!-- Signup success -->
<c:if test="${not empty successMessage}">
<div class="alert alert-success">
${successMessage}
</div>
</c:if>

<!-- Login error -->
<c:if test="${not empty error}">
<div class="alert alert-danger">
${error}
</div>
</c:if>

<form:form method="post" action="login" modelAttribute="user">

<!-- EMAIL -->
<div class="mb-3">

<label>Email</label>

<form:input path="email" cssClass="form-control" placeholder="Enter your email"/>

<form:errors path="email" cssClass="text-danger"/>

</div>

<!-- PASSWORD -->
<div class="mb-3">

<label>Password</label>

<form:password path="password" cssClass="form-control" placeholder="Enter password"/>

<form:errors path="password" cssClass="text-danger"/>

</div>

<button class="btn btn-primary w-100">

Login

</button>

</form:form>

<p class="text-center mt-3">

Don't have an account?

<a href="signup">Sign up here</a>

</p>

</div>

</div>

</div>

</div>

</body>

</html>
