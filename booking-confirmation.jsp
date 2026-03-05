<!DOCTYPE html>
<html>

<head>

<title>Booking Confirmed</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-7">

<div class="card shadow p-5 text-center">

<h2 class="text-success mb-3">

✔ Booking Confirmed!

</h2>

<p class="lead">

Congratulations! Your flight ticket has been booked successfully.

</p>

<h4 class="mt-3">

Booking ID: <span class="text-primary">${bookingId}</span>

</h4>

<hr>

<div class="row mt-4">

<div class="col">

<p class="text-success fw-bold">Secured</p>
<p class="text-muted">Your booking is protected</p>

</div>

<div class="col">

<p class="text-success fw-bold">Email Sent</p>
<p class="text-muted">Confirmation details sent</p>

</div>

<div class="col">

<p class="text-success fw-bold">Ready</p>
<p class="text-muted">Check-in 24 hours before flight</p>

</div>

</div>

<hr>

<p class="text-muted">

Please arrive at the airport **2 hours before departure**.

</p>

<div class="mt-4">

<a href="${pageContext.request.contextPath}/dashboard"
class="btn btn-success">

Go to Dashboard

</a>

<button class="btn btn-outline-secondary">

Print Confirmation

</button>

</div>

</div>

</div>

</div>

</div>

</body>

</html>
