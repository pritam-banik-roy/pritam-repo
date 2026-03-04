<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<title>Sign Up</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-5">

<div class="card p-4 shadow">

<h3 class="text-center mb-4">Sign Up</h3>

<form:form method="post" action="signup" modelAttribute="user">

<div class="mb-3">

<label>Email</label>

<form:input path="email" cssClass="form-control" placeholder="Enter your email"/>

</div>

<div class="mb-3">

<label>Password</label>

<form:password path="password" cssClass="form-control" placeholder="Enter password"/>

</div>

<div class="mb-3">

<label>Role</label>

<form:select path="role" cssClass="form-control">

<form:option value="">-- Select Role --</form:option>

<form:option value="USER">User</form:option>

<form:option value="ADMIN">Admin</form:option>

</form:select>

</div>

<button class="btn btn-primary w-100">

Sign Up

</button>

</form:form>

<p class="text-center mt-3">

Already have an account?

<a href="login">Login here</a>

</p>

</div>

</div>

</div>

</div>

</body>

</html>
