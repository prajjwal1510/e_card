<%@ page import="com.App.Modal.User" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: forteeninches
  Date: 7/6/16
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>e-Card</title>
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="/js/jquery-1.12.0.min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

<header class="container-fluid">
    <img src="/images/dwit_logo.png" title="e-Card">
    <ul style="list-style: none; float: right; padding-top: 4%; position: relative; margin-right: 2%;">
        <li><a href="/logout">Logout</a></li>
    </ul>
</header>

<nav class="navbar navbar-default" style="border: none;background-color: #E3E7EA;">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <div class="collapse navbar-collapse" id="menu">
            <ul class="nav navbar-nav">
                <li><a href="#"><span class="glyphicon glyphicon-home"></span>Home</a></li>
            </ul>
            <ul class="nav navbar-nav pull-right">
                <li style="margin-top: 8%">Good Day! &nbsp;<% out.print(session.getAttribute("username"));%></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <a href="/addPerson"><button class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span>Person</button></a>

    <%
        if (request.getAttribute("message")!=null){%>
    <div class="alert alert-dismissable">
        <%
            out.println(request.getAttribute("message"));%>
    </div>
    <%}
    %>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Photo</th>
            <th>Name</th>
            <th>Roll Number</th>
            <th>Validity Date</th>
            <th>Actions</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${personList}" var="person">

        <tr>
            <td><a href="/identity?id=${person.id}"> <img style="height: 50px;width: 50px" class="img-circle" src="/person_images/${person.photo}"></a></td>
            <td>${person.firstName}&nbsp;&nbsp;${person.lastName}</td>
            <td>${person.rollNumber}</td>
            <td>${person.validityDate}</td>
            <td>
                <a href="/delete?id=${person.id}"><button class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button></a>
                <a href="/edit?id=${person.id}"><button class="btn btn-success"><span class="glyphicon glyphicon-edit"></span></button></a>
            </td>
        </tr>
        </c:forEach>
        <tbody>

        </tbody>
    </table>
</div>

<nav class="navbar navbar-default navbar-fixed-bottom" style="border: none;background-color: #E3E7EA;">

    <p style="text-align: center;margin-top: 2%">@e-Card Generator 2016</p>
</nav>

<div>

</div>
</body>
</html>
