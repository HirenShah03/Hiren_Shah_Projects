<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
	 <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 	  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
      <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
      <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link href="<c:url value="/resources/css/adminHome.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/addpost.css" />" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div id="throbber" style="display:none; min-height:120px;"></div>
<div id="noty-holder"></div>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="http://cijulenlinea.ucr.ac.cr/dev-users/">
                <img src="http://placehold.it/200x50&text=LOGO" alt="LOGO"">
            </a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">
            <li><a href="${contextPath}/add/post" data-placement="bottom" data-toggle="tooltip" href="#" data-original-title="Post"><i class="glyphicon glyphicon-share"></i>
                </a>
            </li>            
            <li class="dropdown">
            	<c:if test = "${sessionScope.user.role == 'admin'}">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Admin User <b class="fa fa-angle-down"></b></a>
                </c:if>
                <c:if test = "${sessionScope.user.role == 'user'}">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessionScope.user.userName} <b class="fa fa-angle-down"></b></a>
                </c:if>
                <ul class="dropdown-menu">
                    <li><a href="#"><i class="fa fa-fw fa-user"></i> Edit Profile</a></li>
                    <li><a href="#"><i class="fa fa-fw fa-cog"></i> Change Password</a></li>
                    <li class="divider"></li>
                    <li><a href="${contextPath}/user/logout"><i class="fa fa-fw fa-power-off"></i> Logout</a></li>
                </ul>
            </li>
        </ul>
        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li>
                    <a href="#" data-toggle="collapse" data-target="#submenu-1"><i class="fa fa-fw fa-search"></i> Search <i class="fa fa-fw fa-angle-down pull-right"></i></a>
                    <ul id="submenu-1" class="collapse">
                        <li><a href="${contextPath}/search/housing"><i class="fa fa-angle-double-right"></i> Housing</a></li>
                        <li><a href="${contextPath}/search/products"><i class="fa fa-angle-double-right"></i> Products</a></li>
                    </ul>
                </li>
                <li>
                <c:if test = "${sessionScope.user.role == 'admin'}">
                <li>
                    <a href="#" data-toggle="collapse" data-target="#submenu-2"><i class="fa fa-fw fa-star"></i>  Approvals <i class="fa fa-fw fa-angle-down pull-right"></i></a>
                    <ul id="submenu-2" class="collapse">
                        <li><a href="${contextPath}/validate/housing"><i class="fa fa-angle-double-right"></i> Housing </a></li>
                        <li><a href="${contextPath}/validate/products"><i class="fa fa-angle-double-right"></i> Product</a></li>
                    </ul>
                </li>
                <li>
                    <a href="${contextPath}/add/category"><i class="fa fa-fw fa-user-plus"></i> Add Category</a>
                </li>
                </c:if>
                <li>
                    <a href="sugerencias"><i class="fa fa-fw fa-paper-plane-o"></i> MENU 4</a>
                </li>
                <li>
                    <a href="faq"><i class="fa fa-fw fa fa-question-circle"></i> MENU 5</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>

    <div id="page-wrapper">
        <div class="container-fluid">
            <!-- Page Heading -->
            <div class="row" id="main" >
                <div class="col-sm-12 col-md-12 well" id="content">
                 		<font color="blue"><h3>${success}</h3></font>
                 		<font color="red"><h3>${errormessage}</h3></font>
                
<div id="tabs">
  <ul>
    <li><a href="#tabs-1">Add Housing</a></li>
    <li><a href="#tabs-2">Add Products</a></li>
    <li><a href="#tabs-3">Under Development</a></li>
  </ul>
  <div id="tabs-1">
<form action="${contextPath}/add/housing"  method="post" enctype="multipart/form-data">
    
  <div class="form-group">
    <label for="inputAddress">Title</label>
    <input type="text" class="form-control" name="title" id="inputAddress" placeholder="Title">
  </div>
    
  <div class="form-group">
    <label for="inputAddress">Apartment No.</label>
    <input type="text" class="form-control" name="aptNo" id="inputAddress" placeholder="1234 A/B">
  </div>
  <div class="form-group">
    <label for="inputAddress2">Street Name</label>
    <input type="text" class="form-control" name="street" id="inputAddress2" placeholder="Worthington Street">
  </div>
    <div class="form-group col-md-2">
      <label for="inputZip">Zip</label>
      <input type="number" class="form-control" name="zipcode" id="inputZip">
    </div><br>
    <p>
  <label for="amount">Maximum price quotation:</label>
  <input type="text" class="amount" id="amount" name="quotation" readonly style="border:0; color:#f6931f; font-weight:bold;">
</p>
 
<div id="slider-range-min" class="slider"></div>
<br>

 <span class="btn btn-default btn-file" ><span>Choose file</span>
 <input type="file" name="imagepath" required/></span>
<br><br><br>

  <input type="submit" value="Post" class="btn btn-primary"/>
  
  
</form>
  </div>
  
  <!--Add Products-->
  <div id="tabs-2">
  <form:form action="${contextPath}/add/products" commandName="product" method="post" enctype="multipart/form-data">
    
  <div class="form-group">
    <label for="inputAddress">Title</label>
    <input type="text" class="form-control" name="title" id="inputAddress" placeholder="Title">
  </div>
    
  <div class="form-group">
    <label for="inputAddress">Description</label>
    <input type="text" class="form-control" name="description" id="inputAddress" placeholder="Describe the product">
  </div>
			Category:
		<form:select name="categories" path="categoryArray" items="${categories}"
				 itemLabel="name" itemValue="name" multiple="true" required="required" id="dates-field2" class="multiselect-ui form-control"/>

    <p>
  <label for="amount">Maximum price quotation:</label>
  <input type="text" class="amount" id="amount" name="quotations" readonly style="border:0; color:#f6931f; font-weight:bold;">
</p>
<div id="slider-range-min" class="slider"></div>
<br>

 <span class="btn btn-default btn-file"><span>Choose file</span>
 <input type="file" name="imagepaths" required/></span>
<br><br><br>

  <input type="submit" value="Post" class="btn btn-primary"/>
  
  
</form:form>
  
    </div>
  <div id="tabs-3">
    <p>Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. Aliquam vulputate, pede vel vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem. Vestibulum non ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a, lacus.</p>
    <p>Duis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing velit. Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque. Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean vehicula velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus hendrerit hendrerit.</p>
  </div>
</div>
 
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
</div><!-- /#wrapper -->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="<c:url value="/resources/js/adminHome.js" />"></script>
    <script src="<c:url value="/resources/js/addpost.js" />"></script>
<script>
  $( function() {
    $( "#tabs" ).tabs();
  } );
  $( function() {
	    $( ".slider" ).slider({
	      range: "min",
	      value: 37,
	      min: 1,
	      max: 700,
	      slide: function( event, ui ) {
	        $( ".amount" ).val( "$" + ui.value );
	      }
	    });
	    $( ".amount" ).val( "$" + $( ".slider" ).slider( "value" ) );
	  } );
  </script>
</body>
</html>