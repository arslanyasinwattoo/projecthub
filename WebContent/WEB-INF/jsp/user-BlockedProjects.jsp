<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<t:template>


	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">List of Blocked Projects</h3>
			</div>
			<div class="panel-body">
				<table id="foo-table" class="table">
					<thead>
						<tr>
							<th data-type="numeric" data-sort-initial="true">Name</th>
							<th data-sort-ignore="true">Description</th>
							<th data-sort-ignore="true">Start Date</th>
							<th data-sort-ignore="true">Start Time</th>
							<th data-sort-ignore="true">Duration</th>
							<th data-sort-ignore="true">Project Status</th>
							<th data-sort-ignore="true">Pending</th>
							<th data-sort-ignore="true">Block</th>

							<th data-hide="phone">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ListOfProjects}" var="user">
							<tr>
								<td>${user.projectName}</td>
								<td>${user.projectDescription}</td>
								<td>${user.projectDate}</td>
								<td>${user.projectTime}</td>
								<td>${user.projectDuration}</td>
								<td>${user.projectStatus}</td>
								<td><c:if test="${user.pending==1}">0</c:if> <c:if
										test="${user.pending==0}">1</c:if></td>
								<td>${user.block}</td>
								<td><div class="input-group-btn">
										<button type="button" data-toggle="dropdown"
											class="btn dropdown-toggle">
											Action <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a
												href="${pageContext.request.contextPath}/user/updateProjectStatus.bnu?id=${user.projectId}&amp;status=${user.projectStatus}&amp;block=0&amp;check=2&amp;projectName=${user.projectName}&amp;projectDuration=${user.projectDuration}&amp;
												 date=${user.projectDate}&amp;time=${user.projectTime}&amp;pending=${user.pending}&amp;projectDescription=${user.projectDescription}&amp;instituteId=${user.institute.instituteId}">block</a></li>

										</ul>
									</div></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	</div>
	</div>

	</div>

</t:template>