<%@ page import="pixiv.Users" %><%
    Users currentUser = (Users) session.getAttribute("currentUser");
%>

<div class="container">
    <nav class="navbar navbar-expand-lg bg-success navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">
                <%=siteName%>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                    <li class="nav-item">
                        <a class="nav-link" href="/posts">All Posts</a>
                    </li>

                    <%
                        if(currentUser!=null){
                    %>
                    <%
                        if(currentUser.getRole()==1){
                    %>
                    <li class="nav-item">
                        <a class="nav-link" href="/add-posts">Add Post</a>
                    </li>

                    <%
                        }
                    %>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <%=currentUser.getFullName()%>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/profile.jsp">Profile</a></li>
                            <li><a class="dropdown-item" href="/">Settings</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="/logout">Logout</a></li>
                        </ul>
                    </li>

                    <%
                    }else {
                    %>
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/register">Register</a>
                    </li>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" href="/get-image">Show Image</a>--%>
<%--                    </li>--%>
                    <%
                        }
                    %>
                </ul>

            </div>
        </div>
    </nav>
</div>