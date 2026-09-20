<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%@ taglib prefix="c" uri="jakarta.tags.core" %>

		<!DOCTYPE html>
		<html>

		<head>

			<meta charset="UTF-8">

			<title>Admin Dashboard</title>

			<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Admin/AdminDashboard.css">

		</head>

		<body>

			<div class="dashboard-container">

				<!-- Sidebar -->
				<jsp:include page="AdminSideBar.jsp" />

				<!-- Main Content -->
				<main class="main-content">

					<!-- Header -->
					<div class="dashboard-header">

						<div>
							<h1>Admin Dashboard</h1>
							<p>Welcome to Training Institute Management System</p>
						</div>

						<div class="admin-info">
							<span>👤 Admin</span>
						</div>

					</div>


					<!-- Statistics Cards -->
					<div class="stats-container">

						<!-- Total Students -->
						<div class="stat-card">

							<div class="stat-icon">
								👨‍🎓
							</div>

							<div class="stat-info">
								<p>Total Students</p>
								<h2>${totalStudents}</h2>
							</div>

						</div>


						<!-- Total Courses -->
						<div class="stat-card">

							<div class="stat-icon">
								📚
							</div>

							<div class="stat-info">
								<p>Total Courses</p>
								<h2>${totalCourses}</h2>
							</div>

						</div>


						<!-- Total Faculty -->
						<div class="stat-card">

							<div class="stat-icon">
								👨‍🏫
							</div>

							<div class="stat-info">
								<p>Total Faculty</p>
								<h2>${totalFaculty}</h2>
							</div>

						</div>


						<!-- Total Batches -->
						<div class="stat-card">

							<div class="stat-icon">
								🏫
							</div>

							<div class="stat-info">
								<p>Total Batches</p>
								<h2>${totalBatches}</h2>
							</div>

						</div>

					</div>


					<!-- Quick Actions -->
					<section class="quick-actions">

						<h2>Quick Actions</h2>

						<div class="action-grid">

							<!-- Add Student -->
							<a href="${pageContext.request.contextPath}/admin/students/add" class="action-card">

								<div class="action-icon">
									➕
								</div>

								<h3>Add Student</h3>

								<p>Register a new student</p>

							</a>


							<!-- Add Course -->
							<a href="${pageContext.request.contextPath}/admin/courses/add" class="action-card">

								<div class="action-icon">
									📚
								</div>

								<h3>Add Course</h3>

								<p>Create a new course</p>

							</a>


							<!-- Add Batch -->
							<a href="${pageContext.request.contextPath}/admin/batches/add" class="action-card">

								<div class="action-icon">
									🏫
								</div>

								<h3>Add Batch</h3>

								<p>Create a new batch</p>

							</a>


							<!-- Add Faculty -->
							<a href="${pageContext.request.contextPath}/admin/faculty/add" class="action-card">

								<div class="action-icon">
									👨‍🏫
								</div>

								<h3>Add Faculty</h3>

								<p>Register faculty member</p>

							</a>


							<!-- Attendance -->
							<a href="${pageContext.request.contextPath}/admin/attendance" class="action-card">

								<div class="action-icon">
									📝
								</div>

								<h3>Attendance</h3>

								<p>Manage student attendance</p>

							</a>


							<!-- Assessment -->
							<a href="${pageContext.request.contextPath}/admin/assessments/add" class="action-card">

								<div class="action-icon">
									📊
								</div>

								<h3>Assessment</h3>

								<p>Manage student assessments</p>

							</a>

						</div>

					</section>


					<!-- Student Management -->
					<section class="student-management">

						<h2>Student Management</h2>

						<div class="management-buttons">

							<a href="${pageContext.request.contextPath}/admin/students/add" class="management-btn">
								➕ Add Student
							</a>

							<a href="${pageContext.request.contextPath}/admin/students" class="management-btn">
								👥 View Students
							</a>

							<a href="${pageContext.request.contextPath}/StudentManagement" class="management-btn">
								⚙️ Manage Students
							</a>

						</div>

					</section>

				</main>

			</div>

		</body>

		</html>