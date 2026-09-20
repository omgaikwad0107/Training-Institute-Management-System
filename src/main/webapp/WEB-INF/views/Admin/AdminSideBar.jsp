<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%@ taglib prefix="c" uri="jakarta.tags.core" %>

		<!DOCTYPE html>

		<html>

		<head>

			<meta charset="UTF-8">

			<title>Training Institute Management System</title>

			<link rel="stylesheet" type="text/css"
				href="${pageContext.request.contextPath}/resources/css/Admin/AdminSideBar.css">

		</head>

		<body>

			<!-- ================= SIDEBAR ================= -->

			<aside class="sidebar">


				<!-- ================= LOGO ================= -->

				<div class="logo-section">

					<div class="logo-icon">🎓</div>

					<div class="logo-text">

						<h2>Training Institute</h2>

						<p>Management System</p>

					</div>

				</div>


				<!-- ================= MENU ================= -->

				<nav class="sidebar-menu">


					<!-- ================= DASHBOARD ================= -->

					<a href="${pageContext.request.contextPath}/Dashboard"
						class="menu-item ${pageContext.request.servletPath == '/Dashboard' ? 'active' : ''}">

						<span class="menu-icon">⌂</span> <span>Dashboard</span>

					</a>


					<!-- ================= STUDENT MANAGEMENT ================= -->

					<a href="${pageContext.request.contextPath}/StudentManagement"
						class="menu-item ${pageContext.request.servletPath == '/StudentManagement' ? 'active' : ''}">

						<span class="menu-icon">👥</span> <span>Student Management</span>

					</a>


					<!-- ================= COURSE MANAGEMENT ================= -->

					<a href="${pageContext.request.contextPath}/admin/courses"
						class="menu-item ${pageContext.request.servletPath == '/admin/courses' ? 'active' : ''}">

						<span class="menu-icon">📚</span> <span>Course Management</span>

					</a>


					<!-- ================= BATCH MANAGEMENT ================= -->

					<a href="${pageContext.request.contextPath}/admin/batches"
						class="menu-item ${pageContext.request.servletPath == '/admin/batches' ? 'active' : ''}">

						<span class="menu-icon">👨‍👩‍👧</span> <span>Batch
							Management</span>

					</a>


					<!-- ================= FACULTY MANAGEMENT ================= -->

					<a href="${pageContext.request.contextPath}/admin/faculty"
						class="menu-item ${pageContext.request.servletPath == '/admin/faculty' ? 'active' : ''}">

						<span class="menu-icon">👨‍🏫</span> <span>Faculty Management</span>

					</a>


					<!-- ================= ATTENDANCE ================= -->

					<a href="${pageContext.request.contextPath}/admin/attendance"
						class="menu-item ${pageContext.request.servletPath == '/admin/attendance' ? 'active' : ''}">

						<span class="menu-icon">📅</span> <span>Attendance</span>

					</a>


					<!-- ================= ASSESSMENTS ================= -->

					<a href="${pageContext.request.contextPath}/admin/assessments"
						class="menu-item ${pageContext.request.servletPath == '/admin/assessments' ? 'active' : ''}">

						<span class="menu-icon">📄</span> <span>Assessments</span>

					</a>


					<!-- ================= REPORTS ================= -->

					<a href="${pageContext.request.contextPath}/admin/reports"
						class="menu-item ${pageContext.request.servletPath == '/admin/reports' ? 'active' : ''}">

						<span class="menu-icon">📊</span> <span>Reports</span>

					</a>

				</nav>


				<!-- ================= LOGOUT ================= -->

				<div class="logout-section">

					<a href="${pageContext.request.contextPath}/logout" class="menu-item logout"> <span
							class="menu-icon">↪</span> <span>Logout</span>

					</a>

				</div>


			</aside>

		</body>

		</html>