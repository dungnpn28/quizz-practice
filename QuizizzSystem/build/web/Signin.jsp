<%-- 
    Document   : Signin
    Created on : May 17, 2023, 4:17:49 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/signin.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
     <body>
        <section class="login ">
		<div class="login_box row">
			<div class="left col-md-4">
				<div class="top_link"><a href="#"><img src="https://drive.google.com/u/0/uc?id=16U__U5dJdaTfNGobB_OpwAJ73vM50rPV&export=download" alt=""></a></div>
				<div class="contact">
                                    <form action="signin" method="post">
						<h3>SIGN IN</h3>
						<input name="account" type="text" placeholder="USERNAME">
						<input name="password" type="text" placeholder="PASSWORD">
                                                <div class="forget"><a href="">Forget Password</a></div>
						<button class="submit">SIGN IN</button>
                                                
					</form>
                                     
				</div>
				
			</div>
			<div class="right col-md-8">
				
				<div class="right-logo "><img src="images\logooo.png" alt="ko có"></div>
				<div class="right-text">
					
					<h2>QUIZZERO</h2>
					<h5>QUIZ FROM ZERO TO HERO</h5>
				</div>
			</div>
				
			</div>
	</section>
    </body>
</html>
