<%--
  Created by IntelliJ IDEA.
  User: adik
  Date: 5/3/23
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%
   String imageUrl = (String)request.getAttribute("imageUrl");
%>

<div class="row" style="width: 1024px; height: 800px;" >
    <div class="col px-3 d-flex align-items-stretch flex-wrap bg-success">

<div class="col-sm m-3" >
<a href="<%= imageUrl %>">

  <img   class="img-fluid" src="<%= imageUrl %>" alt="Image" />
</a>

</div>
    </div>
</div>

</body>
</html>
