<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>

<title>Book Flight</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-6">

<div class="card shadow p-4">

<h4 class="mb-4">

Book Flight

</h4>

<div class="alert alert-info">
<b>Flight Number:</b> ${flight.flightNumber}
</div>

<c:if test="${not empty seatError}">
<div class="alert alert-danger">
${seatError}
</div>
</c:if>

<form action="/check-seat" method="post">

<input type="hidden" name="flightId" value="${flight.flightId}"/>

<div class="mb-3">

<label>Journey Date *</label>

<input type="date"
name="journeyDate"
class="form-control"
required/>

</div>

<div class="mb-3">

<label>Number of Passengers *</label>

<input type="number"
name="passengers"
class="form-control"
min="1"
max="10"
required/>

<small class="text-muted">

Maximum 10 passengers allowed

</small>

</div>

<button class="btn btn-primary w-100">

Book Now

</button>

<a href="/dashboard"
class="btn btn-dark w-100 mt-2">

Back to Dashboard

</a>

</form>

</div>

</div>

</div>

</div>

</body>

</html>
