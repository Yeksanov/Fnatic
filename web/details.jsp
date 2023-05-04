<%@ page import="pixiv.Post" %><%--
  Created by IntelliJ IDEA.
  User: adik
  Date: 4/20/23
  Time: 01:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<%@include file="navbar.jsp"%>
<div class="container mt-5">
    <%
        Post post = (Post) request.getAttribute("postSelected");
        if(post !=null) {
    %>
    <div class="container">
    <div class="row">
        <div class="col-6 mx-auto">
                <div class="row">
                    <div class="col-12">
                        <label>Author:</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" name="post_author" value="<%=post.getAuthor()%>" readonly>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>Image:</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12 h-25">


                        <div class="block">
                            <img src="<%=post.getImageUrl()%>" alt="" class="img-thumbnail">
                        </div>

                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <label>DESCRIPTION : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <textarea name="post_description" class="form-control" rows="10" readonly><%=post.getDescription()%></textarea>
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <button class="btn btn-success" type="submit" data-bs-toggle="modal" data-bs-target="#editPost" >EDIT POST</button>
                    </div>
                </div>

        </div>
    </div>

        <%@include file="editModal.jsp"%>

    <%
        }
    %>
</div>
