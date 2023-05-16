<%--
  Created by IntelliJ IDEA.
  User: adik
  Date: 4/9/23
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css
">
    <%@include file="head.jsp"%>

</head>
<body>
<%@include file="navbar.jsp"%>

<div class="container mt-3">
    <div class="row">
        <div class="col-6 mx-auto">
            <form action="/login" method="post">
                <div class="row">
                    <div class="col-12">
                        <label >EMAIL: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="email" class="form-control" name="email" required placeholder="Insert Email">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label >PASSWORD: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="password" class="form-control" name="password" required placeholder="Insert Password">
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                       <button class="btn btn-success"> SIGN IN</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>


</body>
</html>
