<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page session="false" %>

                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
                    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

                    <title>登入畫面</title>

					<script type="text/javascript">
					
						$(function(){
							
								var status = "${STATUS}";
								
								if(status!=""){
									
									alert("${MESSAGE}");
									
									
								}
							
						});
					
					
					</script>
              
                </head>

                <body>
               		 <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                               
                        
                    <form action="/main/loginAction"  method="post" class="form-inline">
                    
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="media">
                                        <div class="container">
                                            <img src="resources/images/dog.jpg" alt="dog" class="rounded-circle img-fluid align-self-center mr-3 ">
                                        </div>
                                        <div class="media-body">
                                            <div class="container">
                                                <div class="row">
                                                    <div>
                                                        <div class="form-group">
                                                            <input type="email" class="form-control" placeholder="EMAIL:EMAIL:name@name.com" name="email" id="EMAIL" value="${EMAIL}" >
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div>
                                                        <div>
                                                            <input type="password" class="form-control" placeholder="密碼" name="password" id="PASSWORD">
                                                        </div>
                                                    </div>
                                                </div>

												<div class="row">
                                                    <div>
                                                        <div>
                                                           <input type="checkbox" name="remember-me">記住我
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div>
                                                        <div>
                                                            <br>
                                                            <button id="SUBMIT" type="submit" class="btn btn-md btn-primary">登入</button>
                                                            <a href="/main/forget/forgetAccPage" role="button" class="btn btn-md btn-primary">忘記密碼</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>


                                        </div>
                                    </div>
                                </div>
                            </div>
						
                        </div>
                    </form>
	   						 </div>
                        </div>
                    </div>
	

                </body>

                </html>
