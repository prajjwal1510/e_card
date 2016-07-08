<%--
  Created by IntelliJ IDEA.
  User: forteeninches
  Date: 7/6/16
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>e-Card</title>
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
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
            </div>
        </div>
    </nav>

    <div class="container">
        <%
            if(request.getAttribute("addMessage") != null){%>
        <div class="alert alert-dismissable">
            <%
                out.println(request.getAttribute("addMessage"));%>
        </div>

        <%}%>
        <fieldset>
            <legend><span class="glyphicon glyphicon-pencil"></span>Register</legend>
            <form class="form-horizontal" role="form" id="login-form" method="post" action="`/register">

                <div class="form-group">
                    <label class="control-label col-sm-2" for="username"><span class="glyphicon glyphicon-user"/></label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="email"><span class="glyphicon glyphicon-envelope"/></label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email" name="email" placeholder="Enter Email">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="pwd"><span class="glyphicon glyphicon-lock"/></label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="pwd" name="password" placeholder="Enter password">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="confirmPassword"><span class="glyphicon glyphicon-lock"/></label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Re-Enter password">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                       <button type="submit" class="btn btn-default">Save</button>
                    </div>
                </div>
            </form>
        </fieldset>

    </div>

    <nav class="navbar navbar-default navbar-fixed-bottom" style="border: none;background-color: #E3E7EA;">

        <p style="text-align: center;margin-top: 2%">@e-Card Generator 2016</p>
    </nav>
</body>
</html>
