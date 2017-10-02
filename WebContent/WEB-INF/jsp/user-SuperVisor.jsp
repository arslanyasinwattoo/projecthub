<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<t:template>
	<div class="container">

		<div class="signin"></div>
	</div>
	<div class="row row-sm-offset-3">
		<div class="col-xs-12 col-sm-6">
			<form
				action="${pageContext.request.contextPath}/user/SaveTeamMember.bnu"
				id="project" autocomplete="off" method="POST" class="signin-form">
				<div class="form-group">

					<div class="form-group">
						<select name="username" class="form-control">
							<option>Users</option>
							<c:forEach items="${usersList}" var="user">
								<option value="${user.username}">${user.username}</option>
							</c:forEach>
						</select>
					</div>
					<select name="projectId" class="form-control">
						<option>Projects</option>
						<c:forEach items="${projectList}" var="user">
							<option value="${user.projectId}">${user.projectName }</option>
						</c:forEach>
					</select>
				</div>
				<input type="hidden" name="roleId" value=2 />
				<button type="submit" class="btn btn-lg btn-primary btn-block">Save</button>
			</form>
		</div>
	</div>
	</div>
</t:template>