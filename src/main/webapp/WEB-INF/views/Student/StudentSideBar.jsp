<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<!-- =====================================================
     STUDENT SIDEBAR
===================================================== -->

	<aside class="sidebar">

		<!-- Logo -->
		<div class="sidebar-logo">

			<div class="logo-icon">
				T
			</div>

			<div class="logo-text">
				<h2>Training Institute</h2>
				<span>Management System</span>
			</div>

		</div>


		<!-- Navigation -->
		<nav class="sidebar-menu">

			<a href="${pageContext.request.contextPath}/student/dashboard" class="active">

				<span class="menu-icon">📊</span>
				<span>Dashboard</span>

			</a>


			<a href="${pageContext.request.contextPath}/student/courses">

				<span class="menu-icon">📚</span>
				<span>My Courses</span>

			</a>


			<a href="${pageContext.request.contextPath}/student/batches">

				<span class="menu-icon">🗓️</span>
				<span>My Batches</span>

			</a>


			<a href="${pageContext.request.contextPath}/student/attendance">

				<span class="menu-icon">✅</span>
				<span>Attendance</span>

			</a>


			<a href="${pageContext.request.contextPath}/student/assessments">

				<span class="menu-icon">📝</span>
				<span>Assessments</span>

			</a>


			<a href="${pageContext.request.contextPath}/student/results">

				<span class="menu-icon">📈</span>
				<span>My Results</span>

			</a>


		<%-- 	<a href="${pageContext.request.contextPath}/student/notices">

				<span class="menu-icon">🔔</span>
				<span>Notices</span>

			</a>  --%>


			<a href="${pageContext.request.contextPath}/student/profile">

				<span class="menu-icon">👤</span>
				<span>My Profile</span>

			</a>

		</nav>


		<!-- Logout -->
		<div class="sidebar-bottom">

			<a href="${pageContext.request.contextPath}/logout" class="logout-link">

				<span class="menu-icon">🚪</span>
				<span>Logout</span>

			</a>

		</div>

	</aside>