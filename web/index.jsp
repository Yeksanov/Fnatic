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
</head>
<body>
<%
    boolean online = true;
    if (online)  {
%>

<h1>HELLO US1ER</h1>
<%@include file="head.jsp"%>
<%@include file="navbar.jsp"%>

<div class="container p-3">
<%--            <%--%>
<%--                for (int i = 0; i < 10; i++) {--%>


<%--            %>--%>

<%--            <div class="card" >--%>
<%--                <img src="https://assets.nintendo.com/image/upload/ar_16:9,c_lpad,w_1240/b_white/f_auto/q_auto/ncom/en_US/games/switch/a/azur-lane-crosswave-switch/hero" class="card-img-top">--%>
<%--                <div class="card-body">--%>
<%--                    <h5 class="card-title">Lovely Azur lane</h5>--%>
<%--                    <a href="#" class="btn btn-primary">Tap to start</a>--%>
<%--                </div>--%>
<%--            </div>--%>


                <div class="row">
                    <div class="col px-3 d-flex align-items-stretch flex-wrap bg-success">
                        <div class="col-sm m-3 "><img src="https://gachax.com/arknights/wp-content/uploads/sites/6/2020/01/arknights-guide-for-beginners.jpg" class="img-fluid"></div>
                        <div class="col-sm m-3"><img src="https://assets.nintendo.com/image/upload/ar_16:9,c_lpad,w_1240/b_white/f_auto/q_auto/ncom/en_US/games/switch/a/azur-lane-crosswave-switch/hero" class="img-fluid"></div>
                        <div class="col-sm m-3"><img src="data:image/jpeg;base64,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" class="img-fluid"></div>
                    </div>

                </div>


<%--            <%--%>
<%--                }--%>
<%--            %>--%>
</div>
<%
    } else {
%>
   <div class="text-center">
       <h1>SITE IS OFFLINE</h1>
   </div>
<%
    }
%>


</body>
</html>
