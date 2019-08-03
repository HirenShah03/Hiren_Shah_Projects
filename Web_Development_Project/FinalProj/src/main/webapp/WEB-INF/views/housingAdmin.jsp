<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="<c:url value="/resources/css/housingAdmin.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" >
  <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="updateCard()">
<c:import url="dashboardUi.jsp"/>
 <div id="page-wrapper">
        <div class="container-fluid">
            <!-- Page Heading -->
            <div class="row" id="main" >
                <div class="col-sm-12 col-md-12 well" id="content" style="width: 80%">



		<!-- Cards dynamically created using jquery -->

                    
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <script>
    function makeCards(json){
        if(json.length==0){
    		var content = document.getElementById("content");
    		content.innerHTML = "No Request Pending";
    			
            }
	    for(var i=0;i<json.length;i++){
	    	var input = document.createElement("input");
	    	input.setAttribute("type", "hidden");
	    	input.setAttribute("name", "id");
	    	input.setAttribute("value", json[i].id);
		    var divcard = document.createElement("div");
		    divcard.id="card"+i;
		    divcard.className="card";
		    var img = document.createElement("img");
		    img.src=".."+json[i].imagepath;
		    var caption = document.createElement("div");
		    caption.className="caption";
		    caption.id="caption";
		    var h3=document.createElement("h3");
		    h3.textContent=json[i].title;
		    h3.className="text";

		    var acceptbutton = document. createElement("button");
		    acceptbutton.id=json[i].id;
		    acceptbutton.className="btn btn-default btn-sm";
		    var acceptspan = document. createElement("span");
		    acceptspan.className="glyphicon glyphicon-ok";
		    acceptbutton.textContent="Accept";
		    acceptbutton.appendChild(acceptspan);
		    var rejectbutton = document. createElement("button");
		    rejectbutton.id=json[i].id;
		    rejectbutton.className="btn btn-default btn-sm";
		    var rejectspan = document. createElement("span");
		    rejectspan.className="glyphicon glyphicon-remove";
		    rejectbutton.textContent="Reject";
		    rejectbutton.appendChild(rejectspan);
		    
		    divcard.appendChild(img);
		    document.getElementById("content").appendChild(divcard);
		    caption.appendChild(input);
		    caption.appendChild(h3);
		    caption.appendChild(acceptbutton);
		    caption.appendChild(rejectbutton);
		    document.getElementById("card"+i).appendChild(caption);			    
		    }
        }
    function updateCard() {
        
		var http;		
		try{
		var http= new XMLHttpRequest();		
		}catch (e) {
			// TODO: handle exception
		}		
		var content = document.getElementById("content");
		content.innerHTML = '';

		http.onreadystatechange = function () {
			  if(http.readyState === 4 && http.status === 200) {
				var json;
			    json=JSON.parse(http.responseText);
			    makeCards(json);
			  }
			};
			http.open("GET","../validate/housing/ajaxload",true);
			http.send();

    }
    $(document).on("click", ".btn-sm", function(){
    	 $.post("../validate/housing/ajaxload",
    			    {
    			        id: this.id,
    			        decision: this.innerText
    			    },
    			    function(data, status){
    			       // alert("Data: " + data + "\nStatus: " + status);
    			   	  	updateCard();
    			        
    			    });
    	  //alert (this.innerText);
    	});
    	
	    
    </script>

</body>
</html>