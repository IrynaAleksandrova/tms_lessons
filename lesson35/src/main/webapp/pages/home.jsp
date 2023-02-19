<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>

<h1 align="center">Horserace</h1>

<center>
<input type="submit" style="border: 2px solid DodgerBlue;" value="Total balance: ${balance}">
</center>

<form action="/races/add-pair" method="post">
    <p>Name Horse:</p>
    <input type="text" name="nameHorse">
    <p>Name Rider:</p>
    <input type="text" name="nameRider">
    <input type="submit" value="Save"></form>

<h1>Pairs that take part in races:</h1>
<table class="table" style="width:100%">
    <tr>
        <th>Number Of Pair</th>
        <th>Name Horse</th>
        <th>Speed Horse</th>
        <th>Name Rider</th>
        <th>Experience Rider</th>
    </tr>

    <c:forEach items="${pairs}" var="pair">
        <tr>
            <td><script>
                $('.table tbody tr').each(function(i) {
                    var number = i++;
                    $(this).find('td:first').text(number+".");
                });
            </script></td>
            <td><c:out value="${pair.horse.name}"/></td>
            <td><c:out value="${pair.horse.speed}"/></td>
            <td><c:out value="${pair.rider.name}"/></td>
            <td><c:out value="${pair.rider.experience}"/></td>
        </tr>
    </c:forEach>

</table>

<form action="/races/start-race" method="post">
    <p>Number of pair:</p>
    <input type="text" name="pairNumber">
    <p>Your bet:</p>
    <input type="text" name="bet">
    <input type="submit" value="Start Race"></form>

<p><h2 style="color:Tomato;"> Result: ${result} </h2></p>

</form>
</body>
</html>
