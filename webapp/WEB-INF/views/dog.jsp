<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        	<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
 					<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
                    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
					<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
                    
                    <title>註冊</title>
				
                </head>

                <body>

                   
              
      				<div class="container">
    				 
      				<c:forEach begin="1"  end="${list.size()}" step="1" var="i" >

				 		<c:if test="${i%3==1}">
				 			   	<div class="row">
				 		</c:if>
										
						<c:if test="${i /3 !=1 || i==3 }">	
                         	<div class="card col-md-4">
                            		<img src="<c:url value="/image/${list[i-1].dogImage}"/>."  class="card-img-top img-thumbnail rounded mx-auto d-block"    style="max-height:350px ;max-width:350px " >
                            		 <div class="card-body">
                            		 	<h5 class="card-title">${list[i-1].dogName} </h5>
                            		 	<h5 class="card-text">年齡:${list[i-1].dogAge}</h5>
                            		  	<c:if test="${list[i-1].dogSex=='0'}">
		                                	<h5 class="card-text">雄性</h5>
		                                </c:if>	
		                                <c:if test="${list[i].dogSex=='1'}">
		                                	 <h5 class="card-text">雌性</h5>
		                                </c:if>	
		                                <h5 class="card-text">飼主:${list[i-1].dogUser}</h5>
		                                <h5 class="card-text">上傳者:${list[i-1].dogUploadUser}</h5>
		                                <button type="button"  class="btn-outline-warning" >${list[i-1].dogCounter} </button>	  
                            		 </div>
                            </div>

                            
                         </c:if>
                        
    
                        <c:if test="${i%3==0}">
				 			   	</div>
				 		</c:if>              
               
                	</c:forEach>
                  
                    </div>
                    


                  
                </body>
                </html>
