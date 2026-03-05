<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>

<title>Add Passenger</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-6">

<div class="card shadow p-4">

<h4 class="mb-3">

Add Passenger ${current}

</h4>

<p class="text-muted">

Remaining passengers: ${count - current}

</p>

<form action="${pageContext.request.contextPath}/save-passenger" method="post">

<input type="hidden" name="count" value="${count}">
<input type="hidden" name="current" value="${current}">
<input type="hidden" name="flightId" value="${flightId}">

<div class="mb-3">

<label class="form-label">Passenger Name *</label>

<input type="text"
class="form-control"
name="name"
placeholder="Enter full name"
required>

</div>

<div class="mb-3">

<label class="form-label">Age *</label>

<input type="number"
class="form-control"
name="age"
min="1"
max="120"
required>

</div>

<div class="mb-3">

<label class="form-label">Gender *</label>

<select name="gender"
class="form-select"
required>

<option value="">Select Gender</option>
<option>Male</option>
<option>Female</option>
<option>Other</option>

</select>

</div>

<button class="btn btn-primary w-100">

<c:choose>

<c:when test="${current == count}">
Complete Booking
</c:when>

<c:otherwise>
Add Passenger & Continue
</c:otherwise>

</c:choose>

</button>

</form>

</div>

</div>

</div>

</div>

</body>

</html>
