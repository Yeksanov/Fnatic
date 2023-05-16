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


<%@include file="head.jsp"%>
<%@include file="navbar.jsp"%>



<div class="container mt-5">

    <div class="container d-flex flex-row-reverse pb-lg-4">

        <div class="row">

                        <%
                           ArrayList<Post> posts = (ArrayList<Post>) request.getAttribute("posty");
                           if(posts!=null) {
                               for (int i = posts.size()-1; i >=0 ; i--) {


                        %>


<%--        <div class="col-sm-3 mt-3" >--%>
            <div class="col mt-3" >
            <div class="card  " style="; text-align: center; border-width: 5px; border-color: #0a53be; border-radius: 10px; width: 300px;"   >

                <a href="/details?post_id=<%=posts.get(i).getId()%>">
                    <picture >
                        <%--                                <source srcset="<%=post.getImageUrl()%>" type="image/svg+xml" width="1080px" height="768px">--%>
                        <img name="image" style="height: 12rem; " src="<%=posts.get(i).getImageUrl()%>" class=" img-thumbnail" >
                    </picture>
                </a>

            </div>

        </div>


                        <%

                            }
                           } else { %>
                            <p>Image not found</p>
                       <%
                           }
                        %>



        </div>
                </div>



</div>

</body>
</html>
