<%@ page import="java.util.ArrayList" %>
<%@ page import="pixiv.Post" %>
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

<%




%>

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

                        <%
                            String imageUrl = (String) request.getAttribute("urle");
                            if(imageUrl != null && !imageUrl.isEmpty()) {
                        %>
                        <div class="col-sm m-3"><img name="image" src="<%=imageUrl%>%> " class="img-fluid"></div>
                        <div class="col-sm m-3"><img name="image" src="data:image/jpeg;base64,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"  class="img-fluid"></div>

                        <%
                            } else { %>
                            <p>Image not found</p>
                       <%
                           }
                        %>

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
