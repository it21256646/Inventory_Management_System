<%@page import="Model.*"%>
<%@page import="Service.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="css/styles.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body background= images/grey3.jpg>
		<center><h1 style= "color:red; font-family: 'Impact' ">Update Item Details </h1> </center>
		<%
		Item item = (Item) request.getAttribute("itemID");
		%>
		 <%
							if(request.getAttribute("errors_success")!=null){
								if(request.getAttribute("errors_success").equals(1)){
									%>	<div class="alert alert-success">
										  Successful!
										</div>	<%
								}else{
									%>	<div class="alert alert-danger">
										  Unsuccessful!
										</div>	<%
								}
							}
						%>
						<script>
						const params = new URLSearchParams(document.location.search);
const s = params.get("itemCode");

console.info(s); //show C
document.write(s);
document.getElementById('id1').value=s; 
</script>
		<form action="updateItem" method="post">
								 <div class="form-group row">
	                                <label class="col-md-4 col-form-label text-md-right">Item Code</label>
	                                <div class="col-md-6">
	                                    <input type="text" id="id1" class="form-control" name="itemcode" >
	                                    
	                                </div>
	                            </div>
		
	                            <div class="form-group row">
	                                <label class="col-md-4 col-form-label text-md-right">Quantity</label>
	                                <div class="col-md-6">
	                                    <input type="text" id="qty" class="form-control" name="qty" >
	                                </div>
	                            </div>
	                            
	                            <div class="form-group row">
	                                <label class="col-md-4 col-form-label text-md-right">Unit Price</label>
	                                <div class="col-md-6">
	                                    <input type="text" id="price" class="form-control" name="price" >
	                                </div>
	                            </div>
	                            
	                            <div class="form-group row">
	                                <label class="col-md-4 col-form-label text-md-right">Description</label>
	                                <div class="col-md-6">
	                                    <select id="desc" name="desc" class="form-control">
    										<option value="Material 01">Materials 01</option>
    										<option value="Material 02">Materials 02</option>
    										<option value="Material 03">Materials 03</option>
    
										</select>
	                                </div>
	                            </div>
	                            
	                           


	                            <div class="col-md-6 offset-md-4">
	                                <button type="submit" class="btn btn-primary">
	                                    Update
	                                </button>
	                            </div>
	                    	</form>
</body>
</html>