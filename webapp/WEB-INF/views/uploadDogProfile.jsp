<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
            <%@ page session="false"%>

                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="utf-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
                    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

                    <title>新增狗狗</title>
					
					<script type="text/javascript">
							
						$(function(){
							
							$("#DOG_IMAGE").change(function(){
								var file = this.files[0];
								console.log($(this).val());
								console.log(file.size);
								
								if ( $(this).val().split('.').pop().toLowerCase() != "jpg" ) {
							        alert("圖檔格式錯誤，只支援jpg檔!");
							        $(this).val('');
							        $('#IMAGE').prop('src',"/resources/images/dogLogo.jpg");
							        return false;
							    }
								
								var reader = new FileReader();
								reader.onload = function(e) {
								      $('#IMAGE').attr('src', e.target.result);
								    }		
								
								reader.readAsDataURL(file); 
								
							});
							
						});
					
					
					</script>


                </head>

                <body>



					<form:form action="${pageContext.request.contextPath}/dog/saveDogProfile" method="post" modelAttribute="dogProfile" enctype="multipart/form-data" cssClass="form-group">
						<form:hidden path="dogCounter"/>
						<form:hidden path="dogUser"/>
						<form:hidden path="dogUploadUser"/>
						<div class="container">
							<div class="row">
								<div class="col-md-8 offset-md-4">
									<div class="card" style="max-height:250px ;max-width:250px " >
										<img alt="" src="/resources/images/dogLogo.jpg"   id="IMAGE" class="card-img-top">
									</div>												
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-8 offset-md-4">		
									<input type="file" id="DOG_IMAGE"  name="image"  class="btn btn-md btn-outline-primary" />								
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-8 offset-md-4">
									<form:select path="dogClass">
										<form:option value="<--請選擇狗類-->"></form:option>
										<form:options items="${dogClass}"  itemValue="dogClass"  itemLabel="dogName" cssClass="btn btn-md btn-outline-primary" />	
									</form:select>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-8 offset-md-4">
									<form:radiobutton path="dogSex" value="0" /> 雄性 &nbsp;&nbsp;&nbsp;&nbsp;
									<form:radiobutton path="dogSex" value="1" /> 雌性
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-8 offset-md-4">
									<form:input path="dogName" placeholder="狗名" cssClass="form-control" />
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-8 offset-md-4">
								<form:label path="dogAge" cssClass="btn btn-md btn-outline-primary">狗年齡</form:label>					
									<select id="DOG_AGE" name="dogAge"  >
										<option value=0>0</option>
										<option value=1>1</option>
										<option value=2>2</option>
										<option value=3>3</option>
										<option value=4>4</option>
										<option value=5>5</option>
										<option value=6>6</option>
										<option value=7>7</option>
										<option value=8>8</option>
										<option value=9>9</option>
										<option value=10>10</option>
										<option value=11>11</option>
										<option value=12>12</option>
										<option value=13>13</option>
										<option value=14>14</option>
										<option value=15>15</option>
										<option value=16>16</option>
									</select>
									
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-8 offset-md-4">
									<button type="submit" class="btn btn-lg btn-primary" >新增狗狗</button>
								</div>
							</div>
							
							
						</div>
					</form:form>
					
					
					

                </body>



                </html>
