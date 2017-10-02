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
				action="${pageContext.request.contextPath}/user/SaveProjectKeywords.bnu"
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
					<select name="keywordId" class="form-control">
						<option>keywords</option>
						<c:forEach items="${ListOfKeywords}" var="user">
							<option value="${user.keywordsId}">${user.keywordName }</option>
						</c:forEach>
					</select>
				</div>

				<button type="submit" class="btn btn-lg btn-primary btn-block">Save</button>
			</form>
		</div>
	</div>
	</div>



</t:template>