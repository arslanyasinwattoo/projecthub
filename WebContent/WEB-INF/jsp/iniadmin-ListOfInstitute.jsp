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
					<h3 class="panel-title">List of Institutes</h3>
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
							<c:forEach items="${pendingList}" var="user">
								<tr>
									<td>${user.institute.instituteName}</td>
									<td><c:if test="${user.institute.pending==1}">0</c:if> <c:if
											test="${user.institute.pending==0}">1</c:if></td>
									<td>${user.institute.block}</td>
									<td><div class="input-group-btn">
											<button type="button" data-toggle="dropdown"
												class="btn dropdown-toggle">
												Action <span class="caret"></span>
											</button>
											<ul class="dropdown-menu">
												<li><a
													href="${pageContext.request.contextPath}/iniadmin/updateInstituteStatus.bnu?id=${user.institute.instituteId}&amp;name=${user.institute.instituteName}&amp;block=1&amp;enabled=${user.institute.pending}&amp;check=3">Block</a></li>
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