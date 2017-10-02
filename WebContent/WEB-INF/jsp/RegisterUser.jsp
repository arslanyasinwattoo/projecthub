<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<t:template>
	<div class="container">

		<div class="signin">

			<h3 class="title">
				<a href="${pageContext.request.contextPath}/login.bnu"> Login</a>
			</h3>

			<div class="row row-sm-offset-3 signin-or">
				<div class="col-xs-12 col-sm-6">

					<hr class="hr-or">

					<span class="span-or">or</span>
				</div>
			</div>
			<div class="row row-sm-offset-3">
				<div class="col-xs-12 col-sm-6">
					<form action="${pageContext.request.contextPath}/saveRegister.bnu"
						autocomplete="off" method="POST" class="signin-form">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user"></i>
							</span> <input type="text" name="firstName" placeholder="FirstName"
								class="form-control">
						</div>
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user"></i>
							</span> <input type="text" name="lastName" placeholder="LastName"
								class="form-control">
						</div>
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user"></i>
							</span> <input type="text" name="userName" placeholder="UserName"
								class="form-control">
						</div>
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user"></i>
							</span> <input type="text" name="contactNo" placeholder="ContactNo"
								class="form-control">
						</div>
						<span class="help-block"></span>
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-lock"></i>
							</span> <input type="text" name="emailId" placeholder="Email-Id"
								class="form-control">
						</div>
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-lock"></i>
							</span> <input type="password" name="password" placeholder="Password"
								class="form-control">
						</div>
						<input type="hidden" name="check" value="${check}" />
						<button type="submit" class="btn btn-lg btn-primary btn-block">Sign
							Up</button>
					</form>
				</div>
			</div>
			<div class="row row-sm-offset-3">
				<div class="col-xs-12 col-md-6">

					<p class="forgot-password">
						<a href="#">Forgot password?</a>

					</p>
					<h1></h1>
				</div>
			</div>
		</div>

	</div>




</t:template>