<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="com.captcha.botdetect.web.servlet.Captcha"%>

<html>
<head>
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

	<title>Home</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="flexbox">
  <div class="content">
      <form:form action="${contextPath}/user/login" commandName="user" method="post">
  
    <div id="login" class="box show">
      <div class="field">
        <div class="sign-in">Sign In<br><small>Login to continue</small></div>
      </div>
       <font color="red">${errorMessage}</font>
 		<font color="blue">${success}</font>
      <br>
      <div class="field">
        <label>Username</label>
        <input type="text" name="userName" required="required">
      </div>
      <div class="field">
        <label>Password</label>
        <input type="password" name="password" required="required">
      </div>
      <div class="field">
        <a href="#" id="account" class="trouble">Doesn't have an account yet?</a>
      </div>
      <div class="field">
        <a href="#" class="trouble">Trouble signing in?</a>
      </div>
      <div class="field">
        <input type="submit" value="Sign In" class="btn-sign-in"/>
      </div>
    </div>
    </form:form>
    
    <form:form action="${contextPath}/user/register" commandName="user" method="post">
    <div id="register" class="box hide">
      <div class="field">
        <div class="sign-in">Register<br><small>Create your account</small></div>
      </div>
      
      <div class="field">
        <label>Email id</label>
        <input type="email" name="emailId" required="required">
      </div>
      <div class="field">
        <label>Username</label>
        <input type="text" name="userName" required="required">
      </div>
      <div class="field">
        <label>Password</label>
        <input type="password" name="password" required="required">
      </div>
      <div class="field">
        <label>Confirm Password</label>
        <input type="password" required="required">
      </div>
    	<label for="captchaCode" class="prompt">Retype the characters from the picture:</label> 
			<%
			Captcha captcha=Captcha.load(request, "CaptchaObject");
			captcha.setUserInputID("captchaCode");
			
			String captchaHtml=captcha.getHtml();
			out.println(captchaHtml);
			%>
		<input id="captchaCode" type="text" name="captchaCode" required="required"/>
      <div class="field">
        <a href="#" id="back" class="trouble">Back to login</a>
      </div>
      
      <div class="field">
        <input type="submit" value="Register now" class="btn-sign-in"/>
      </div>
    </div>
    </form:form>
    
  </div>
</div>
    <script src="<c:url value="/resources/js/home.js" />"></script>
</body>
</html>
