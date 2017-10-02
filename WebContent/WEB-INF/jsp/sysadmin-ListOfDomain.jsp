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
					<h3 class="panel-title">List of Domains</h3>
				</div>
				<div class="panel-body">
					<table id="foo-table" class="table">
						<thead>
							<tr>
								<th data-type="numeric" data-sort-initial="true">Name</th>
								<th data-sort-ignore="true">Blocked</th>
								<th data-hide="phone">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ListOfDomain}" var="user">
								<tr>
									<td>${user.domainName}</td>
									<td>${user.block}</td>
									<td><div class="input-group-btn">
											<button type="button" data-toggle="dropdown"
												class="btn dropdown-toggle">
												Action <span class="caret"></span>
											</button>
											<ul class="dropdown-menu">
												<li><a
													href="${pageContext.request.contextPath}/sysadmin/updateDomainStatus.bnu?id=${user.domainId}&amp;name=${user.domainName}&amp;block=1&amp;check=3">block</a></li>
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