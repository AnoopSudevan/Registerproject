<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


<style>
body {
	background-color: #525252;
}

.centered-form {
	margin-top: 60px;
}

.centered-form .panel {
	background: rgba(255, 255, 255, 0.8);
	box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
}
</style>
<div class="container">

	<c:if test="${status}">
		<strong>${message }</strong>
		</c:if>

	<div class="row centered-form">
		<div
			class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">

						User Registration <small>!!!</small>
					</h3>
				</div>
				<div class="panel-body">
					<form role="form" action="Register" method="post">

						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="text" name="first_name" id="first_name"
										class="form-control input-sm" placeholder="First Name"
										value="${newcustomer.fname }">
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="text" name="last_name" id="last_name"
										class="form-control input-sm" placeholder="Last Name"
										value="${newcustomer.lname }">
								</div>
							</div>
						</div>

						<div class="form-group">
							<input type="email" name="email" id="email"
								class="form-control input-sm" placeholder="Email Address"
								value="${newcustomer.emailID }">
						</div>
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="password" name="user-password" id="user-password"
										clas0s="form-control input-sm" placeholder="Password">
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="password" name="password_confirmation"
										id="password_confirmation" class="form-control input-sm"
										placeholder="Confirm Password">
								</div>
							</div>
						</div>
						<input type="submit" value="Register"
							class="btn btn-info btn-block">
							<div class="col-xs-6 col-sm-6 col-md-6">
									<a href="dispdetails" class="btn btn-success btn-block">VIEWDETAILS</a> 
								</div>
							

					</form>
				</div>
			</div>
		</div>
	</div>
</div>