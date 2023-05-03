<%--
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
    <div class="row">
        <div class="col-6 mx-auto">
            <form action="/upload" method="post" enctype="multipart/form-data">

                <div class="row">
                    <div class="col-12">
                        <label>Author:</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" name="post_author">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>Image:</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="file" class="form-control" name="post_image" accept="image/*">
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <label>DESCRIPTION : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <textarea name="post_description" class="form-control" rows="5"></textarea>
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <button class="btn btn-success" type="submit" >ADD POST</button>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>
