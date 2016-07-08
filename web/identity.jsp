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
    <link type="text/css" href="css/card.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

</head>
<body>
<header class="container-fluid" style="background-color: #A9D8E6;height: 10%">
    <a href="/login"><img src="/images/dwit_logo.png" title="e-Card" style="height: 100%"></a>
    <ul style="list-style: none; float: right; padding-top: 2%; position: relative; margin-right: 2%;">
        <li><a href="/logout">Logout</a></li>
    </ul>
</header>

<div style="background-color: #5A1B1B;height: 100%;margin-top: -4%">
    <div class="content">

        <div style="height: 15%;width: 100%">
            <img src="images/dwit.jpg" style="height: 100%;width: 100%" alt="image not found">
        </div>

        <div class="headerId" style="height: 7%">
            <h1 class="subTitle">STUDENT IDENTITY CARD</h1>
        </div>

        <div class="containerId" style="height: 63%">
            <h2 class="subTitle1">ID#: 2016_Bcs_${person.rollNumber}</h2><br>
            <img  class="subTitle2" src="person_images/${person.photo}"><br>
            <h2 class="personName">${person.firstName}&nbsp;${person.lastName}</h2><br>
            <p class="personAddress">${person.city},&nbsp;${person.district}</p><br>

            <p class="program">Program &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: ${person.program}</p><br>
            <p class="validity">Validity &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: ${person.validityDate}</p><br>


            <table width="100%">
                <tr>
                    <td colspan="2">_________________</td>
                    <td colspan="10"></td>
                    <td colspan="2">_________________</td>
                </tr>
                <tr>
                    <td colspan="2">Student's Signature</td>
                    <td colspan="10"></td>
                    <td colspan="2">Principal's Signature</td>
                </tr>
            </table>

        </div>

        <div class="footerId">
            <p class="phone">Phone : 01-4485424  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Website: www.dwit.edu.np</p>
        </div>

    </div>
</div>
<nav class="navbar navbar-default navbar-fixed-bottom" style="border: none;background-color: #E3E7EA;">

    <p style="text-align: center;margin-top: 2%">@e-Card Generator 2016</p>
</nav>
</body>
</html>