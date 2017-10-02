<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<t:template>

	<sec:authorize access="hasRole('ROLE_USER')">
		<h1>Welcome User</h1>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_SYSADMIN')">
		<h1>Welcome System Admin</h1>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_INIADMIN')">
		<h1>Welcome Intitute Admin</h1>
	</sec:authorize>

	</h1>
</t:template>