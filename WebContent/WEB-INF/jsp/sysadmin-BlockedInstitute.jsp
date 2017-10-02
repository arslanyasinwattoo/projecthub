<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<t:template>
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Blocked List</h3>
				</div>
				<div class="panel-body">
					<table id="foo-table" class="table">
						<thead>
							<tr>
								<th data-type="numeric" data-sort-initial="true">Name</th>
								<th>Pending</th>
								<th data-sort-ignore="true">Blocked</th>
								<th data-hide="phone">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${blockedList}" var="user">
								<tr>
									<td>${user.instituteName}</td>
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
													href="${pageContext.request.contextPath}/sysadmin/updateInstituteStatus.bnu?id=${user.instituteId}&amp;name=${user.instituteName}&amp;block=0&amp;enabled=${user.pending}&amp;check=1">Remove</a></li>
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