<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="<c:url value="/resources/css/housingAdmin.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" >
  <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:import url="dashboardUi.jsp"/>
 <div id="page-wrapper">
        <div class="container-fluid">
            <!-- Page Heading -->
            <div class="row" id="main" >
                <div class="col-sm-12 col-md-12 well" id="content" style="width: 80%">
                        <font color="blue"><h3>${success}</h3></font>
                 		<font color="red"><h3>${errormessage}</h3></font>
                    
     	<h2>Add a New Category</h2>


	<form:form action="${contextPath}/add/category" method="post" commandName="category">

		<table>
			<tr>
				<td>Category Title:</td>
				<td><form:input path="name" size="30" required="required" /> <font color="red"><form:errors
							path="name" /></font></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Create Category" /></td>
			</tr>
		</table>

	</form:form>

                    
                    
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>

</body>
</html>