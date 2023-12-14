<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD ITEM</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="css/styles.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  
</head>
<body background= images/grey3.jpg>
	<center><h1 style= "color:red; font-family: 'Impact' ">Add a new Item</h1></center>
	<br>
	<br>
	<div class="container">
	<form action="insertItem" method="post">
	                            <div class="form-group row">
	                                <label class="col-md-4 col-form-label text-md-right">Item Code</label>
	                                <div class="col-md-6">
	                                    <input type="text" id="id" class="form-control" name="itemID" placeholder = "00***" pattern="[0-5]{5}" required>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group row">
	                                <label class="col-md-4 col-form-label text-md-right">Quantity</label>
	                                <div class="col-md-6">
	                                    <input type="text" id="quantity" class="form-control" name="qty"  required>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group row">
	                                <label class="col-md-4 col-form-label text-md-right">Unit Price</label>
	                                <div class="col-md-6">
	                                    <input type="text" id="price" class="form-control" name="unitPrice" required>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group row">
	                                <label class="col-md-4 col-form-label text-md-right">Stock Type</label>
	                                <div class="col-md-6">
	                                    <select id="description" name="description" class="form-control">
    										<option value="Material 01">Materials 01</option>
    										<option value="Material 02">Materials 02</option>
    										<option value="Material 03">Materials 03</option>
    
										</select>
	                                </div>
	                            </div>

	                  

	                            <div class="col-md-6 offset-md-4">
	                                <button type="submit" class="btn btn-primary">
	                                    Add
	                                </button>
	                                <input type="button" class ="btn btn-primary" value="View stock" onClick="javascript:window.location='viewItem.jsp';">
	                            </div>
	                    	</form>
	               </div>
	               
</body>
</html>