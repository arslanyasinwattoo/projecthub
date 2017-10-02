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
								<th data-type="numeric" data-sort-initial="true">UserName</th>
								<th>FirstName</th>
								<th data-sort-ignore="true">LastName</th>
								<th data-hide="phone,tablet">ContactNo</th>
								<th data-hide="phone,tablet">Email-Id</th>
								<th data-hide="phone,tablet">Pending</th>
								<th data-hide="phone,tablet">blocked</th>
								<th data-hide="phone">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${blockedList}" var="user">
								<tr>
									<td>${user.username}</td>
									<td>${user.firstName}</td>
									<%-- 								<td><a href="#">Boudreaux</a></td> --%>
									<td>${user.lastName}</td>
									<td>${user.userContactNo}</td>
									<td data-value="78025368997">${user.userEmailId}</td>
									<td><c:if test="${user.enabled==1}">0</c:if> <c:if
											test="${user.enabled==0}">1</c:if></td>
									<td>${user.block}</td>
									<td><div class="input-group-btn">
											<button type="button" data-toggle="dropdown"
												class="btn dropdown-toggle">
												Action <span class="caret"></span>
											</button>
											<ul class="dropdown-menu">
												<li><a
													href="${pageContext.request.contextPath}/sysadmin/updateUsersStatus.bnu?username=${user.username}&amp;block=0&amp;enabled=${user.enabled}&amp;check=1">Remove</a></li>
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