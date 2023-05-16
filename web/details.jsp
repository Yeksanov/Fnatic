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


            <%
                if (currentUser != null && currentUser.getRole() == 1 ) {
            %>
                <div class="row mt-3 mb-3">
                    <div class="col-12">
                        <button class="btn btn-primary" type="submit" data-bs-toggle="modal" data-bs-target="#editPost" >EDIT POST</button>
                        <button class="btn btn-danger" type="submit" data-bs-toggle="modal" data-bs-target="#deletePost" >DELETE POST</button>
                    </div>
                </div>
            <%@include file="editModal.jsp"%>
            <%@include file="deleteModal.jsp"%>

            <%
                } if(currentUser!=null) {
            %>

            <%@include file="comment.jsp"%>


            <%
                }
            %>

            <div class="row pb-5">
                <div class="col-12">
                    <%
                        ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");
                        if (comments != null){
                            for(Comment comment : comments){
                    %>
                    <div class="list-group">
                        <a href="JavaScript:void(0)" class="list-group-item list-group-item-action">
                            <div class="d-flex w-100 justify-content-between">
                                <h5 class="mb-1"><%=comment.getUser().getFullName()%></h5>
                                <small class="text-body-secondary"><%=comment.getPostDate()%></small>
                            </div>
                            <p class="mb-1"><%=comment.getComment()%></p>
                        </a>
                    </div>
                    <%
                            }
                        }
                    %>
                </div>
            </div>

        </div>
    </div>



    <%
        }
    %>
</div>
