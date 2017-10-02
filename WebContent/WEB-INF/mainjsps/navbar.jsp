<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize
	access="hasAnyRole('ROLE_USER','ROLE_INIADMIN','ROLE_SYSADMIN')">
	<aside class="social-sidebar">

		<div class="social-sidebar-content">

			<div class="user">

				<img width="25" height="25"
					src="${pageContext.request.contextPath}/resources/img/avatars/avatar-30.png"
					alt="Julio Marquez" class="avatar"> <span><sec:authentication
						property="principal.username" /></span> <i data-toggle="dropdown"
					class="trigger-user-settings fa fa-user"></i>
				<div class="user-settings">

					<h3 class="user-settings-title">Settings shortcuts</h3>


					<div class="user-settings-content">
						<a href="#my-profile">

							<div class="icon">
								<i class="fa fa-user"></i>
							</div>

							<div class="title">My Profile</div>

							<div class="content">View your profile</div>
						</a> <a href="#view-messages">

							<div class="icon">
								<i class="fa fa-envelope-o"></i>
							</div>

							<div class="title">View Messages</div>

							<div class="content">
								You have <strong>17</strong> new messages
							</div>
						</a> <a href="#view-pending-tasks">

							<div class="icon">
								<i class="fa fa-tasks"></i>
							</div>

							<div class="title">View Tasks</div>

							<div class="content">
								You have <strong>8</strong> pending tasks
							</div>
						</a>
					</div>


					<div class="user-settings-footer">
						<a href="#more-settings">See more settings</a>
					</div>

				</div>
			</div>



			<div class="search-sidebar">
				<form class="search-sidebar-form has-icon">
					<label for="sidebar-query" class="fa fa-search"></label> <input
						id="sidebar-query" type="text" placeholder="Search"
						class="search-query">
				</form>
			</div>
			<div class="clearfix"></div>


			<div class="menu">
				<div class="menu-content">
					<ul id="social-sidebar-menu">


						<li class="active"><a href="index.jsp"> <i
								class="fa fa-home"></i> <span>Home</span> <span class="badge">9</span>
						</a></li>
						<!-- 						// starts USER -->
						<!-- <--------------------------------------------------------------------------------------------->
						<sec:authorize access="hasRole('ROLE_USER')">

							<li><a href="#menu-ui" data-toggle="collapse"
								data-parent="#social-sidebar-menu"> <i class="fa fa-cogs"></i>
									<span>Manage Project</span> <i class="fa arrow"></i>
							</a>

								<ul id="menu-ui" class="collapse">
									<li><a
										href="${pageContext.request.contextPath}/user/ManageProject.bnu">Projects</a></li>
									<li><a
										href="${pageContext.request.contextPath}/user/ProjectStatus.bnu">Project
											Status</a></li>
									<li><a
										href="${pageContext.request.contextPath}/user/BlockedProject.bnu">Blocked
											Projects</a></li>
									<li><a
										href="${pageContext.request.contextPath}/user/CompletedProjects.bnu">Completed
											Projects</a></li>
									<li><a
										href="${pageContext.request.contextPath}/user/ProjectRatings.bnu">Project
											Ratings</a></li>
									<li><a
										href="${pageContext.request.contextPath}/user/ListOfProjects.bnu">List
											of projects</a></li>
									<li><a
										href="${pageContext.request.contextPath}/user/AddProjectDomain.bnu">Manange
											domain</a></li>
									<li><a
										href="${pageContext.request.contextPath}/user/AddProjectKeywords.bnu">Manage
											Keywords</a></li>
								</ul></li>


							<li><a href="#menu-form" data-toggle="collapse"
								data-parent="#social-sidebar-menu"> <i
									class="fa fa-list-alt"></i> <span>Manage Team Memebers</span> <i
									class="fa arrow"></i>
							</a>

								<ul id="menu-form" class="collapse">
									<li><a
										href="${pageContext.request.contextPath}/user/TeamMember.bnu">Team
											Members</a></li>
									<li><a
										href="${pageContext.request.contextPath}/user/BlockedTeamMember.bnu">Blocked
											Members</a></li>
									<li><a
										href="${pageContext.request.contextPath}/user/ListOfTeamMember.bnu">List
											of Team members</a></li>
								</ul></li>


							<li><a href="#menu-pages" data-toggle="collapse"
								data-parent="#social-sidebar-menu"> <i
									class="fa fa-file-text"></i> <span>Manage Supervisor</span> <i
									class="fa arrow"></i>
							</a>

								<ul id="menu-pages" class="collapse">
									<li><a
										href="${pageContext.request.contextPath}/user/SuperVisor.bnu">Supervisor</a></li>
									<li><a
										href="${pageContext.request.contextPath}/user/BlockedSuperVisor.bnu"">Blocked
											SuperVisor</a></li>
									<li><a
										href="${pageContext.request.contextPath}/user/ListOfSuperVisor.bnu">List
											Of SuperVisors</a></li>
									<!-- 								<li><a href="pages_login_2.html">Login 2</a></li> -->
									<!-- 								<li><a href="pages_timelines.html">Timelines</a></li> -->
									<!-- 								<li><a href="pages_timeline_facebook.html">Timeline -->
									<!-- 										(Facebook)</a></li> -->
									<!-- 								<li><a href="pages_user_profile_cards.html">User -->
									<!-- 										Profile/Cards</a></li> -->
									<!-- 								<li><a href="pages_inbox.html">Inbox</a></li> -->
									<!-- 								<li><a href="pages_blank_page.html">Blank Page</a></li> -->
									<!-- 								<li><a href="pages_reduced_sidebar.html">Reduced -->
									<!-- 										Sidebar</a></li> -->
									<!-- 								<li><a href="pages_404_error.html">404 Error Page</a></li> -->
									<!-- 								<li><a href="pages_500_error.html">500 Error Page</a></li> -->
									<!-- 								<li><a href="pages_pricing_tables.html">Pricing Tables</a></li> -->
								</ul></li>


							<li><a data-toggle="collapse"
								data-parent="#social-sidebar-menu" href="#menu-multilevel"><i
									class="fa fa-sitemap"></i> <span>Manage Ratings</span><i
									class="fa arrow"></i> </a>
								<ul id="menu-multilevel" class="collapse">

									<!-- 								<li><a data-toggle="collapse" data-parent="#collapseOne" -->
									<!-- 									href="#collapseOneOne">Level 2<i class="fa arrow"></i> -->
									<!-- 								</a> -->
									<!-- 									<ul id="collapseOneOne" class="collapse"> -->

									<!-- 										<li><a data-toggle="collapse" -->
									<!-- 											data-parent="#collapseOneOne" href="#collapseOneOneOne">Level -->
									<!-- 												3<i class="fa arrow"></i> -->
									<!-- 										</a> -->
									<!-- 											<ul id="collapseOneOneOne" class="collapse"> -->

									<!-- 												<li><a href="#">Level 4</a></li> -->
									<!-- 												<li><a href="#">Level 4</a></li> -->
									<!-- 												<li><a href="#">Level 4</a></li> -->

									<!-- 											</ul></li> -->


									<!-- 										<li><a href="#">Level 3</a></li> -->
									<!-- 										<li><a href="#">Level 3</a></li> -->

									<!-- 									</ul></li> -->


									<li><a href="#">Team member Rating</a></li>
									<li><a href="#">SuperVisor Rating</a></li>

								</ul></li>


							<li><a href="charts.html" target=""> <i
									class="fa fa-bar-chart-o"></i> <span>Manage Project
										References</span> <span class="badge">6</span>
							</a></li>
						</sec:authorize>

						<!-- 						// starts SysAdmin -->
						<!-- <--------------------------------------------------------------------------------------------->

						<sec:authorize access="hasRole('ROLE_SYSADMIN')">
							<li><a href="#menu-ui" data-toggle="collapse"
								data-parent="#social-sidebar-menu"> <i class="fa fa-cogs"></i>
									<span>Manage users</span> <i class="fa arrow"></i>
							</a>

								<ul id="menu-ui" class="collapse">
									<li><a
										href="${pageContext.request.contextPath}/sysadmin/Users.bnu">Users</a></li>
									<li><a
										href="${pageContext.request.contextPath}/sysadmin/BlockedUsers.bnu">Blocked
											users</a></li>
									<li><a
										href="${pageContext.request.contextPath}/sysadmin/ListOfUsers.bnu">List
											of Users</a></li>
								</ul></li>


							<li><a href="#menu-form" data-toggle="collapse"
								data-parent="#social-sidebar-menu"> <i
									class="fa fa-list-alt"></i> <span>Manage Institutes</span> <i
									class="fa arrow"></i>
							</a>

								<ul id="menu-form" class="collapse">
									<li><a
										href="${pageContext.request.contextPath}/sysadmin/Institute.bnu">Institutes</a></li>
									<li><a
										href="${pageContext.request.contextPath}/sysadmin/BlockedInstitute.bnu">Blocked
											Institues</a></li>
									<li><a
										href="${pageContext.request.contextPath}/sysadmin/ListOfInstitute.bnu">List
											of Institues</a></li>
								</ul></li>


							<li><a href="#menu-pages" data-toggle="collapse"
								data-parent="#social-sidebar-menu"> <i
									class="fa fa-file-text"></i> <span>Manage Admins</span> <i
									class="fa arrow"></i>
							</a>

								<ul id="menu-pages" class="collapse">
									<li><a href="pages_email_templates.html">Admins</a></li>
									<li><a href="pages_invoice.html">Blocked Admins</a></li>
									<li><a href="pages_login_1.html">List Of Admins</a></li>
								</ul></li>


							<li><a data-toggle="collapse"
								data-parent="#social-sidebar-menu" href="#menu-multilevel"><i
									class="fa fa-sitemap"></i> <span>Manage Keywords</span><i
									class="fa arrow"></i> </a>
								<ul id="menu-multilevel" class="collapse">

									<li><a
										href="${pageContext.request.contextPath}/sysadmin/Keywords.bnu">keywords</a></li>
									<li><a
										href="${pageContext.request.contextPath}/sysadmin/BlockedKeywords.bnu">Blocked
											Keywords</a></li>
									<li><a
										href="${pageContext.request.contextPath}/sysadmin/ListOfKeywords.bnu">List
											of keywords</a></li>

								</ul></li>

							<li><a href="" data-toggle="collapse"
								data-parent="#social-sidebar-menu"> <i class="fa fa-cogs"></i>
									<span>Manage Domain</span> <i class="fa arrow"></i>
							</a>

								<ul id="menu-ui" class="collapse">

									<li><a
										href="${pageContext.request.contextPath}/sysadmin/Domains.bnu">Domain</a></li>
									<li><a
										href="${pageContext.request.contextPath}/sysadmin/BlockedDomains.bnu">Blocked
											Domains</a></li>
									<li><a
										href="${pageContext.request.contextPath}/sysadmin/ListOfDomains.bnu">List
											of Domains</a></li>

								</ul></li>
							<li><a data-toggle="collapse"
								data-parent="#social-sidebar-menu" href=""><i
									class="fa fa-sitemap"></i> <span>Manage Technologies</span><i
									class="fa arrow"></i> </a>
								<ul id="menu-multilevel" class="collapse">

									<li><a
										href="${pageContext.request.contextPath}/sysadmin/Technology.bnu">Technologies</a></li>
									<li><a
										href="${pageContext.request.contextPath}/sysadmin/BlockedTechnology.bnu">Blocked
											Technologies</a></li>
									<li><a
										href="${pageContext.request.contextPath}/sysadmin/ListOfTechnology.bnu">List
											of Technologies</a></li>

								</ul></li>


						</sec:authorize>
						<!-- 						// starts INIAdmin -->
						<!-- <--------------------------------------------------------------------------------------------->

						<sec:authorize access="hasRole('ROLE_INIADMIN')">
							<li><a href="#menu-ui" data-toggle="collapse"
								data-parent="#social-sidebar-menu"> <i class="fa fa-cogs"></i>
									<span>Manage Projects</span> <i class="fa arrow"></i>
							</a>

								<ul id="menu-ui" class="collapse">
									<li><a
										href="${pageContext.request.contextPath}/iniadmin/Projects.bnu">Projects</a></li>
									<li><a href="ui_general.html">Blocked Projects</a></li>
									<li><a href="ui_buttons.html">List of Projects</a></li>
								</ul></li>


							<li><a href="#menu-form" data-toggle="collapse"
								data-parent="#social-sidebar-menu"> <i
									class="fa fa-list-alt"></i> <span>Manage SuperVisor</span> <i
									class="fa arrow"></i>
							</a>

								<ul id="menu-form" class="collapse">
									<li><a href="form_elements.html">SuperVisor</a></li>
									<li><a href="form_validation.html">Blocked SuperVisor</a></li>
									<li><a href="form_wizards.html">List of SuperVisor</a></li>
								</ul></li>


							<li><a href="#menu-pages" data-toggle="collapse"
								data-parent="#social-sidebar-menu"> <i
									class="fa fa-file-text"></i> <span>Manage TeamMembers</span> <i
									class="fa arrow"></i>
							</a>

								<ul id="menu-pages" class="collapse">
									<li><a href="pages_email_templates.html">TeamMembers</a></li>
									<li><a href="pages_invoice.html">Blocked TeamMembers</a></li>
									<li><a href="pages_login_1.html">List Of TeamMembers</a></li>
								</ul></li>


							<li><a data-toggle="collapse"
								data-parent="#social-sidebar-menu" href="#menu-multilevel"><i
									class="fa fa-sitemap"></i> <span>Manage Institute</span><i
									class="fa arrow"></i> </a>
								<ul id="menu-multilevel" class="collapse">

									<li><a
										href="${pageContext.request.contextPath}/iniadmin/Institute.bnu">Institute</a></li>
									<li><a
										href="${pageContext.request.contextPath}/iniadmin/BlockedInstitute.bnu">Blocked
											Institute</a></li>
									<li><a
										href="${pageContext.request.contextPath}/iniadmin/ListOfInstitute.bnu">List
											Of Institute</a></li>

								</ul></li>
						</sec:authorize>
				</div>
			</div>

		</div>


	</aside>
</sec:authorize>
