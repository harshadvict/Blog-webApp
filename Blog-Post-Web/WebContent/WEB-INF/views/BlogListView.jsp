<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link type="text/css" rel="stylesheet" href="./css/blog.css">
    <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
<title>blog</title>
</head>
<body>
 <nav>
        <img src="${pageContext.request.contextPath}/assets/logo.svg" alt="logo" />
        <ul>
           <li> <a href="${pageContext.request.contextPath}/myblogs">My Blogs</a></li>
           		 <li> <a href="${pageContext.request.contextPath}/allblogs">All Blogs</a></li>
             <li> <a href="${pageContext.request.contextPath}/login">Login</a></li>
            <li> <a href="${pageContext.request.contextPath}/signup">Sign Up</a></li>
           
        </ul>
    </nav>
<%--     <div class="body-div1">
        <div>Your Blog Posts</div>
   <c:if test="${bloglist == null}">
  <a href="${pageContext.request.contextPath}/new"><button class="button" id="addBlog" ><i class="fas fa-plus-circle"></i>Add New Post</button></a>  
   </c:if>
    </div>
<!-- <div id="popup"> -->
<!-- Popup Div Starts Here -->
<div id="popupContact">
<img id="close" src="./assets/close-button.svg">
<img id="rect" src=./assets/rect.svg>
<h2>Your Post</h2> --%>
 

<!-- Contact Us Form -->
<form action="${pageContext.request.contextPath}/new" id="form" method="post" name="form">
		<input id="title" name="title" placeholder="title" type="text"/>
		<textarea id="msg" name="message" placeholder="Description"></textarea>
		<button id="post" type="submit" >POST</button>
</form>
</body>
</html>