@org.hibernate.annotations.NamedQueries({

		@org.hibernate.annotations.NamedQuery(name = "getOrdersWithinPeriod", query = "SELECT s FROM SalesOrder s "
				+ "WHERE s.orderDate >= ? AND s.orderDate <= ?"),

		@org.hibernate.annotations.NamedQuery(name = "getOrdersWithDetails", query = "SELECT s FROM SalesOrder s "
				+ "JOIN FETCH s.customer c ORDER BY c.name"),

		@org.hibernate.annotations.NamedQuery(name = "getCustomerOrders", query = "SELECT s FROM SalesOrder s "
				+ "JOIN s.customer c WHERE c.customerId = ?"),
		@org.hibernate.annotations.NamedQuery(name = "getUser", query = "SELECT s FROM Users s "
				+ " WHERE s.username = ?"),
		@org.hibernate.annotations.NamedQuery(name = "getInstituteAdmin", query = "SELECT s FROM InstituteAdmin s "
				+ "Join s.institute Join s.users WHERE s.users.username = ? And s.institute.pending=1 And s.institute.block=0"),

		@org.hibernate.annotations.NamedQuery(name = "getAllInstituteAdmin", query = "SELECT s FROM InstituteAdmin s "
				+ "Join s.institute Join s.users WHERE s.users.username = ? "),

		@org.hibernate.annotations.NamedQuery(name = "getBlockedInstituteAdmin", query = "SELECT s FROM InstituteAdmin s "
				+ "Join s.institute Join s.users WHERE s.users.username = ? And s.institute.block=1"),

		@org.hibernate.annotations.NamedQuery(name = "getPendingInstituteAdmin", query = "SELECT s FROM InstituteAdmin s "
				+ "Join s.institute Join s.users WHERE s.users.username = ? And s.institute.pending=0"),
		@org.hibernate.annotations.NamedQuery(name = "getAllProjects", query = "SELECT s FROM Project s "
				+ "Join s.users WHERE s.pending = ? and s.block=? And s.users.username=? "),
		@org.hibernate.annotations.NamedQuery(name = "getAllCompletedProjects", query = "SELECT s FROM Project s "
				+ "Join s.users WHERE s.projectStatus=? And s.users.username=?"),
		@org.hibernate.annotations.NamedQuery(name = "getAllBlockedProjects", query = "SELECT s FROM Project s "
				+ "Join s.users WHERE s.block=? And s.users.username=?"),
		@org.hibernate.annotations.NamedQuery(name = "getAllusers", query = "SELECT s FROM Users s "
				+ "WHERE s.username !=?"),
		@org.hibernate.annotations.NamedQuery(name = "getAllTeamMembers", query = "SELECT s FROM ProjectRole s "
				+ "Join s.project Join s.role WHERE s.project.projectId =? and s.role.roleId=?"),
		@org.hibernate.annotations.NamedQuery(name = "getAllBlockedTeamMembers", query = "SELECT s FROM ProjectRole s "
				+ "Join s.project Join s.role WHERE s.project.projectId =? and s.block=? and s.role.roleId=?"),
//		@org.hibernate.annotations.NamedQuery(name = "updateProjectStatus", query = "update s Project  set s.projectStatus,s.block values(?,?)"
//				+ "WHERE s.projectId =?"), 
				})
package com.bnu.springdemo.dao.query;