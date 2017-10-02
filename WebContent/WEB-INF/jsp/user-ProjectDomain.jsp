<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<t:template>

	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">List of Projects</h3>
			</div>
			<div class="panel-body">
				<table id="foo-table" class="table">
					<thead>
						<tr>
							<th data-type="numeric" data-sort-initial="true">Name</th>
							<th data-sort-ignore="true">Project Status</th>
							<th data-sort-ignore="true">Domains</th>
							<th data-hide="phone">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ListOfProjectsDomain}" var="user">
							<tr>
								<td>${user.project.projectName}</td>
								<td>${user.project.projectStatus}</td>

								<td>${user.domain.domainName}</td>
								<td><div class="input-group-btn">
										<button type="button" data-toggle="dropdown"
											class="btn dropdown-toggle">
											Action <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a
												<%-- href="${pageContext.request.contextPath}/sysadmin/updateProjectStatus.bnu?id=${user.domainId}&amp;name=${user.domainName}&amp;block=1&amp;check=1">block</a></li> --%>
										<ul class="dropdown-menu">
											<li><a href="${pageContext.request.contextPath}/user/ListOfDomain.bnu?id=${user.project.projectId}">Domain</a></li> 
										<li><a href="${pageContext.request.contextPath}/user/ListOfKeywords.bnu?id=${user.project.projectId}">Keywords</a></li>
										
						</c:forEach>

						</ul>
									</div></td>
							</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	</div>
	</div>

	</div>



</t:template>