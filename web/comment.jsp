<%@ page import="pixiv.Comment" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: adik
  Date: 5/16/23
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="mt-3">
  <form action="/add-comment" method="post">
    <input type="hidden" name="post_id" value="<%=post.getId()%>">
    <div class="row">
      <div class="col-12">
        <textarea class="form-control" name="comment"></textarea>
      </div>
    </div>
    <div class="row mt-3">
      <div class="col-12">
        <button class="btn btn-success btn-sm">ADD COMMENT</button>
      </div>
    </div>
  </form>
</div>

