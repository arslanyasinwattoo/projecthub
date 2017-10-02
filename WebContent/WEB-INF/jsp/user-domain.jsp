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
				action="${pageContext.request.contextPath}/user/SaveProjectDomain.bnu"
				id="project" autocomplete="off" method="POST" class="signin-form">
				<div class="form-group">
					<select name="projectId" class="form-control">
						<option>Projects</option>
						<c:forEach items="${ListOfProjects}" var="user">
							<option value="${user.projectId}">${user.projectName }</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group">
					<select name="domainId" class="form-control">
						<option>Domain</option>
						<c:forEach items="${ListOfDomains}" var="user">
							<option value="${user.domainId}">${user.domainName }</option>
						</c:forEach>
					</select>
				</div>

				<button type="submit" class="btn btn-lg btn-primary btn-block">Save</button>
			</form>
		</div>
	</div>
	</div>




</t:template>