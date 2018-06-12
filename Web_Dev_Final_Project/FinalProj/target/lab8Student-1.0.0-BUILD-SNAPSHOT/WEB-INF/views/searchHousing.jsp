<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/searchHousing.css" />"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
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
			<!-- Page Heading -->
			<div class="ui-widget">
				<input class="form-control" id="tags" placeholder="Search by Street:">
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
		$("#tags").keyup(function(event) {
			$("#tags").autocomplete({
				source : globalJsonArray
			});
			var search = $(this).val();
			$.post("../search/housing/searchByStreet", {
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
				array[i] = json[i].street;
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
				acceptspan.className = "glyphicon glyphicon-ok";
				viewbutton.textContent = "View";
				viewbutton.appendChild(acceptspan);

				divcard.appendChild(img);
				document.getElementById("content").appendChild(divcard);
				caption.appendChild(input);
				caption.appendChild(h3);
				caption.appendChild(viewbutton);
				document.getElementById("card" + i).appendChild(caption);
			}
		}
		function updateCard() {

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
			http.open("GET", "../search/housing/ajaxload", true);
			http.send();

		}

		$(document).on("click", ".btn-sm", function() {

		});
	</script>

</body>
</html>