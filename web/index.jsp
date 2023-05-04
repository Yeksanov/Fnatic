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


<%@include file="head.jsp"%>
<h1><%=siteName%></h1>
<%@include file="navbar.jsp"%>

<%




%>

<div class="container mt-5">
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



<%--                    <div class="col px-3 d-flex align-items-stretch flex-wrap">--%>
    <div class="container d-flex flex-row-reverse pb-lg-4">

        <div class="row">

                        <%
                           ArrayList<Post> posts = (ArrayList<Post>) request.getAttribute("posty");
                           if(posts!=null) {
                               for (int i = posts.size()-1; i >=0 ; i--) {


                        %>


        <div class="col-sm-3 mt-3" >
            <div class="block ">

                <a href="/details?post_id=<%=posts.get(i).getId()%>">
                    <picture >
                        <%--                                <source srcset="<%=post.getImageUrl()%>" type="image/svg+xml" width="1080px" height="768px">--%>
                        <img name="image" src="<%=posts.get(i).getImageUrl()%>" class="img-thumbnail " >
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
