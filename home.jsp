src/main/webapp/WEB-INF/views

home.jsp


<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Flight Reservation System</title>
</head>
<body>
    <h1>Welcome to Flight Reservation System</h1>
</body>
</html>

=====================================================================================================


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Flight Reservation System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">

    <h2 class="text-center mb-4">Flight Reservation System</h2>

    <div class="card p-4 shadow">

        <h4>Search Flights</h4>

        <form:form method="post" action="search" modelAttribute="searchFlight">

            <div class="mb-3">
                <label>Source</label>
                <form:input path="source" cssClass="form-control"/>
                <form:errors path="source" cssClass="text-danger"/>
            </div>

            <div class="mb-3">
                <label>Destination</label>
                <form:input path="destination" cssClass="form-control"/>
                <form:errors path="destination" cssClass="text-danger"/>
            </div>

            <button type="submit" class="btn btn-primary">Search Flights</button>

        </form:form>

        <hr>

        <div class="mt-3">
            <a href="login" class="btn btn-outline-success">Login</a>
            <a href="signup" class="btn btn-outline-primary">Sign Up</a>
        </div>

    </div>
</div>

</body>
</html>
=============================================================================================================================



<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Flight Reservation System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">

    <h2 class="text-center mb-4">Flight Reservation System</h2>

    <div class="card p-4 shadow">

        <h4>Search Flights</h4>

        <form:form method="post" action="search" modelAttribute="searchFlight">

            <div class="mb-3">
                <label>Source</label>
                <form:input path="source" cssClass="form-control"/>
                <form:errors path="source" cssClass="text-danger"/>
            </div>

            <div class="mb-3">
                <label>Destination</label>
                <form:input path="destination" cssClass="form-control"/>
                <form:errors path="destination" cssClass="text-danger"/>
            </div>

            <button type="submit" class="btn btn-primary">Search Flights</button>

        </form:form>

        <!-- SHOW SEARCH RESULT BELOW -->
        <c:if test="${not empty flights}">
            <hr>
            <h5>Available Flights</h5>

            <table class="table table-bordered mt-3">
                <thead class="table-dark">
                <tr>
                    <th>Flight No</th>
                    <th>Source</th>
                    <th>Destination</th>
                    <th>Price</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${flights}" var="flight">
                    <tr>
                        <td>${flight.flightNumber}</td>
                        <td>${flight.source}</td>
                        <td>${flight.destination}</td>
                        <td>₹ ${flight.price}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>

        <hr>

        <div class="mt-3">
            <a href="login" class="btn btn-outline-success">Login</a>
            <a href="signup" class="btn btn-outline-primary">Sign Up</a>
        </div>

    </div>
</div>

</body>
</html>
