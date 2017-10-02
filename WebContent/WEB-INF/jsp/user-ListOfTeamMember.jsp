<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<t:template>


	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">List of TeamMembers</h3>
			</div>
			<div class="panel-body">
				<table id="foo-table" class="table">
					<thead>
						<tr>
							<th data-sort-ignore="true">Project Name</th>
							<th data-type="numeric" data-sort-initial="true">TeamMember
								Name</th>
							<th data-sort-ignore="true">Role</th>
							<th data-sort-ignore="true">Block</th>
							<th data-sort-ignore="true">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${TeamMemberList}" var="user">
							<tr>
								<td>${user.project.projectName}</td>
								<td>${user.users.username}</td>
								<td><c:if test="${user.role.roleId==1}">TeamMember</c:if> <c:if
										test="${user.role.roleId==2}">SuperVisor</c:if></td>

								<td>${user.block}</td>
								<td><div class="input-group-btn">
										<button type="button" data-toggle="dropdown"
											class="btn dropdown-toggle">
											Action <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a
												href="${pageContext.request.contextPath}/user/updateTeammemberStatus.bnu?id=${user.projectRoleId}&amp;roleid=${user.role.roleId}&amp;projectId=${user.project.projectId}&amp;username=${user.users.username}&amp;block=1&amp;check=${user.role.roleId}">block</a></li>
							</tr>
							<%-- 								<td><div class="input-group-btn"> --%>
							<!-- 										<button type="button" data-toggle="dropdown" -->
							<!-- 											class="btn dropdown-toggle"> -->
							<!-- 											Action <span class="caret"></span> -->
							<!-- 										</button> -->
							<!-- 										<ul class="dropdown-menu"> -->
							<%-- 											<li><ahref="${pageContext.request.contextPath}/sysadmin/updateProjectStatus.bnu?id=${user.domainId}&amp;name=${user.domainName}&amp;block=1&amp;check=1">block</a></li> --%>
							<!-- 										<ul class="dropdown-menu"> -->
							<%-- 											<li><a href="${pageContext.request.contextPath}/user/ListOfDomain.bnu?id=${user.projectId}">Domain</a></li>  --%>
							<%-- 										<li><a href="${pageContext.request.contextPath}/user/ListOfKeywords.bnu?id=${user.projectId}">Keywords</a></li> --%>

						</c:forEach>

						</ul>
						</div>
						</td>
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