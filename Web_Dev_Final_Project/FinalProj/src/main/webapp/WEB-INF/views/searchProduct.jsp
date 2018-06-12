<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/searchProduct.css" />"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="updateCard()">
	<c:import url="dashboardUi.jsp" />
	<div id="page-wrapper">
		<div class="container-fluid">
		<div class="container">
  <!-- Trigger the modal with a button -->
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
   
      
    </div>
  </div>
  
</div>
		
			<!-- Page Heading -->
			<div class="ui-widget">
			<div class="input-group">
			
				<input class="form-control" id="tags" placeholder="Search by Title:">
				
			
	</div>
<div id="filter">Filter: </div>					

			</div>

			<div class="row" id="main">
				<div class="col-sm-12 col-md-12 well" id="content"
					style="width: 80%">

		<!-- Cards dynamically created using jquery -->
		

				</div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<script>
		var globalJson;
		var globalJsonArray = [];
		var clickedItem=[];
		
		$("#tags").keyup(function(event) {
			$("#tags").autocomplete({
				source : globalJsonArray
			});
			var search = $(this).val();
			$.post("../search/products/searchByTitle", {
				search : search,
			}, function(data, status) {
				// alert("Data: " + data + "\nStatus: " + status);
				var json;
				json = JSON.parse(data);
				makeCards(json);
			});
		});

		function convertJson(json) {
			var array = [];
			for (var i = 0; i < json.length; i++) {
				array[i] = json[i].title;
			}
			globalJsonArray = array;

		}
		function makeCards(json) {
			var content = document.getElementById("content");
			content.innerHTML = '';

			if (json.length == 0) {
				var content = document.getElementById("content");
				content.innerHTML = "No Listing found";

			}
			for (var i = 0; i < json.length; i++) {
				var input = document.createElement("input");
				input.setAttribute("type", "hidden");
				input.setAttribute("name", "id");
				input.setAttribute("value", json[i].id);
				var divcard = document.createElement("div");
				divcard.id = "card" + i;
				divcard.className = "card";
				var img = document.createElement("img");
				img.src=".."+json[i].imagepath;
				var caption = document.createElement("div");
				caption.className = "caption";
				caption.id = "caption";
				var h3 = document.createElement("h3");
				h3.textContent = json[i].title;
				h3.className = "text";

				var viewbutton = document.createElement("button");
				viewbutton.id = json[i].id;
				viewbutton.className = "btn btn-default btn-sm";
				var acceptspan = document.createElement("span");
				acceptspan.className = "glyphicon glyphicon-info-sign";
				viewbutton.textContent = "View ";
				
				viewbutton.appendChild(acceptspan);
				var a = document.createElement("a");
				a.href="finalproj/search/products?id="+json[i].id;
				viewbutton.appendChild(a);					
				divcard.appendChild(img);
				document.getElementById("content").appendChild(divcard);
				caption.appendChild(input);
				caption.appendChild(h3);
				caption.appendChild(viewbutton);
				document.getElementById("card" + i).appendChild(caption);
			}
		}
		function loadFilter(){
			var http;
			try {
				var http = new XMLHttpRequest();
			} catch (e) {
				// TODO: handle exception
			}

			http.onreadystatechange = function() {
				if (http.readyState === 4 && http.status === 200) {
					var json;
					json = JSON.parse(http.responseText);
					makeFilter(json);
				}
			};
			http.open("GET", "../search/products/addfilter", true);
			http.send();
			
			}

		function makeFilter(json){
			for (var i = 0; i < json.length; i++) {
			var checkbox = document.createElement('input');
			checkbox.type = "checkbox";
			checkbox.name = "filter";
			checkbox.value = json[i].name;
			checkbox.className="filter";
			checkbox.id = json[i].categoryId;

			var label = document.createElement('label')
			label.htmlFor = json[i].categoryId;
			label.appendChild(document.createTextNode(json[i].name+" "));

			document.getElementById("filter").appendChild(checkbox);
			document.getElementById("filter").appendChild(label);
			}
		}
		
		function updateCard() {
			loadFilter();
			var http;
			try {
				var http = new XMLHttpRequest();
			} catch (e) {
				// TODO: handle exception
			}

			http.onreadystatechange = function() {
				if (http.readyState === 4 && http.status === 200) {
					var json;
					json = JSON.parse(http.responseText);
					makeCards(json);
					convertJson(json);
				}
			};
			http.open("GET", "../search/products/ajaxload", true);
			http.send();

		}


		$(document).on("click", ".filter", function() {
		    var ischecked= $(this).is(':checked');
			var length=clickedItem.length;
		    if(ischecked){
		    	clickedItem[length]=$(this).attr('id');
				filterCall();
		    	
		    }
		    else if(!ischecked){
				for (var i = 0; i < clickedItem.length; i++) {
					if(clickedItem[i]==$(this).attr('id')){
						clickedItem.splice(i,1);
						break;
					}						
					
				}
				if(clickedItem.length==0){
					var http;
					try {
						var http = new XMLHttpRequest();
					} catch (e) {
						// TODO: handle exception
					}

					http.onreadystatechange = function() {
						if (http.readyState === 4 && http.status === 200) {
							var json;
							json = JSON.parse(http.responseText);
							makeCards(json);
							convertJson(json);
						}
					};
					http.open("GET", "../search/products/ajaxload", true);
					http.send();

			    }
				else
				filterCall();
		    }
			
					    
		});
		function filterCall(){
			$.ajax({
			    type : "POST",
			    url : "../search/products/filter",
			    data : {
			    	clickedItem: clickedItem //notice that "myArray" matches the value for @RequestParam
			    },
			    success : function(data) {
					var json;
					json = JSON.parse(data);
					makeCards(json);
					convertJson(json);
					
			    },
			    error : function(e) {
			       alert('Error: ' + e);
			    }
			}); 
			}

		
				
	</script>

</body>
</html>