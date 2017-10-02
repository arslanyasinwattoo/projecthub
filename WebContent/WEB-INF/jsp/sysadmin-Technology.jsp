<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<t:template>
	<div class="container">

		<div class="signin">

			<!-- 			<h3 class="title"> -->
			<%-- 				<a href="${pageContext.request.contextPath}/login.bnu"> Login</a> --%>
			<!-- 			</h3> -->

			<div class="row row-sm-offset-3 signin-or">
				<div class="col-xs-12 col-sm-6">

					<hr class="hr-or">

					<!-- 					<span class="span-or">or</span> -->
				</div>
			</div>
			<div class="row row-sm-offset-3">
				<div class="col-xs-12 col-sm-6">
					<form
						action="${pageContext.request.contextPath}/sysadmin/SaveTechnology.bnu"
						autocomplete="off" method="POST" class="signin-form">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user"></i>
							</span> <input type="text" name="name"
								placeholder="Tools_And_Technology" class="form-control">
						</div>

						<%-- 						<input type="hidden" name="check" value="${check}" /> --%>
						<button type="submit" class="btn btn-lg btn-primary btn-block">Save</button>
					</form>
				</div>
			</div>
		</div>



		<!-- 		<div class="col-md-12"> -->
		<!-- 			<div class="panel panel-default"> -->
		<!-- 				<div class="panel-heading"> -->
		<!-- 					<h3 class="panel-title">Blocked List</h3> -->
		<!-- 				</div> -->
		<!-- 				<div class="panel-body"> -->
		<%-- 					<table id="foo-table" class="table"> --%>
		<%-- 						<thead> --%>
		<%-- 							<tr> --%>
		<%-- 								<th data-type="numeric" data-sort-initial="true">Name</th> --%>

		<%-- 								<th data-sort-ignore="true">Blocked</th> --%>
		<%-- 								<th data-hide="phone">Action</th> --%>
		<%-- 							</tr> --%>
		<%-- 						</thead> --%>
		<%-- 						<tbody> --%>
		<%-- 							<c:forEach items="${blockedList}" var="user"> --%>
		<%-- 								<tr> --%>
		<%-- 									<td>${user.keywordName}</td> --%>
		<%-- 									<td>${user.block}</td> --%>
		<%-- 									<td><div class="input-group-btn"> --%>
		<!-- 											<button type="button" data-toggle="dropdown" -->
		<!-- 												class="btn dropdown-toggle"> -->
		<!-- 												Action <span class="caret"></span> -->
		<!-- 											</button> -->
		<!-- 											<ul class="dropdown-menu"> -->
		<!-- 												<li><a -->
		<%-- 													href="${pageContext.request.contextPath}/sysadmin/updateKeywordStatus.bnu?id=${user.keywordsId}&amp;name=${user.keywordName}&amp;block=1&amp;check=1">Remove</a></li> --%>
		<!-- 											</ul> -->
		<%-- 										</div></td> --%>
		<%-- 								</tr> --%>
		<%-- 							</c:forEach> --%>
		<%-- 						</tbody> --%>
		<%-- 					</table> --%>
		<!-- 				</div> -->
		<!-- 			</div> -->
		<!-- 		</div> -->
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">List of Tools and Technologies</h3>
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
							<c:forEach items="${ListOfTechnology}" var="user">
								<tr>
									<td>${user.toolsAndTechnologyName}</td>
									<td>${user.block}</td>
									<td><div class="input-group-btn">
											<button type="button" data-toggle="dropdown"
												class="btn dropdown-toggle">
												Action <span class="caret"></span>
											</button>
											<ul class="dropdown-menu">
												<li><a
													href="${pageContext.request.contextPath}/sysadmin/updateTechnologyStatus.bnu?id=${user.toolsAndTechnologyId}&amp;name=${user.toolsAndTechnologyName}&amp;block=1&amp;check=1">block</a></li>
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