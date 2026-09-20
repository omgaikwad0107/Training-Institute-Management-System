<%@ page contentType="text/html;charset=UTF-8" language="java" %>

	<!DOCTYPE html>
	<html>

	<head>

		<meta charset="UTF-8">

		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<title>Student Management</title>

		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Admin/StudentManagement.css">

	</head>

	<body>
		<jsp:include page="AdminSideBar.jsp"></jsp:include>
		<div class="student-management-page">

			<!-- ================= HEADER ================= -->

			<header class="top-header">

				<div class="header-left">
					<h2>Training Institute</h2>
					<span>Admin Panel</span>
				</div>

				<div class="header-right">

					<div class="admin-profile">
						<div class="profile-icon">A</div>

						<div class="profile-info">
							<strong>Administrator</strong> <small>Admin</small>
						</div>
					</div>

				</div>

			</header>


			<!-- ================= MAIN CONTENT ================= -->

			<main class="main-content">

				<!-- PAGE TITLE -->

				<div class="page-heading">

					<div>
						<h1>Student Management</h1>

						<p>Manage student records, enrollment and student accounts</p>
					</div>

					<a href="${pageContext.request.contextPath}/admin/students/add" class="add-student-btn">
						<span>+</span> Add Student

					</a>

				</div>


				<!-- ================= STATISTICS ================= -->

				<section class="statistics">

					<div class="stat-card">

						<div class="stat-icon total-icon">👥</div>

						<div class="stat-details">

							<span>Total Students</span>

							<h2>${empty totalStudents ? 0 : totalStudents}</h2>

							<small>All registered students</small>

						</div>

					</div>


					<div class="stat-card">

						<div class="stat-icon active-icon">✓</div>

						<div class="stat-details">

							<span>Active Students</span>

							<h2>${empty activeStudents ? 0 : activeStudents}</h2>

							<small>Currently active</small>

						</div>

					</div>


					<div class="stat-card">

						<div class="stat-icon inactive-icon">⏸</div>

						<div class="stat-details">

							<span>Inactive Students</span>

							<h2>${empty inactiveStudents ? 0 : inactiveStudents}</h2>

							<small>Inactive accounts</small>

						</div>

					</div>


					<div class="stat-card">

						<div class="stat-icon completed-icon">★</div>

						<div class="stat-details">

							<span>Completed</span>

							<h2>${empty completedStudents ? 0 : completedStudents}</h2>

							<small>Course completed</small>

						</div>

					</div>

				</section>


				<!-- ================= MANAGEMENT SECTION ================= -->

				<section class="management-section">

					<div class="section-title">

						<h2>Student Operations</h2>

						<p>Select an operation to manage student records</p>

					</div>


					<div class="operation-grid">


						<!-- ADD STUDENT -->

						<a href="${pageContext.request.contextPath}/admin/students/add" class="operation-card">

							<div class="operation-icon add-icon">+</div>

							<div class="operation-content">

								<h3>Add Student</h3>

								<p>Register a new student and create their account.</p>

							</div> <span class="arrow">→</span>

						</a>


						<!-- VIEW STUDENTS -->

						<a href="${pageContext.request.contextPath}/admin/students" class="operation-card">

							<div class="operation-icon view-icon">👁</div>

							<div class="operation-content">

								<h3>View Students</h3>

								<p>View all registered students and their details.</p>

							</div> <span class="arrow">→</span>

						</a>


						<!-- UPDATE STUDENT -->

						<a href="${pageContext.request.contextPath}/admin/students" class="operation-card">

							<div class="operation-icon update-icon">✎</div>

							<div class="operation-content">

								<h3>Update Student</h3>

								<p>Edit student information, course and status.</p>

							</div> <span class="arrow">→</span>

						</a>


						<!-- DELETE STUDENT -->

						<a href="${pageContext.request.contextPath}/admin/students" class="operation-card">

							<div class="operation-icon delete-icon">🗑</div>

							<div class="operation-content">

								<h3>Delete Student</h3>

								<p>Remove a student record from the system.</p>

							</div> <span class="arrow">→</span>

						</a>


						<!-- SEARCH STUDENT -->

						<a href="${pageContext.request.contextPath}/admin/students" class="operation-card">

							<div class="operation-icon search-icon">🔍</div>

							<div class="operation-content">

								<h3>Search Students</h3>

								<p>Find students using name, email or course.</p>

							</div> <span class="arrow">→</span>

						</a>


						<!-- ENROLLMENT -->

						<a href="${pageContext.request.contextPath}/admin/students" class="operation-card">

							<div class="operation-icon enrollment-icon">📚</div>

							<div class="operation-content">

								<h3>Student Enrollment</h3>

								<p>View student course and batch enrollment.</p>

							</div> <span class="arrow">→</span>

						</a>

					</div>

				</section>


				<!-- ================= QUICK ACTIONS ================= -->

				<section class="quick-section">

					<div class="section-title">

						<h2>Quick Actions</h2>

					</div>

					<div class="quick-actions">

						<a href="${pageContext.request.contextPath}/admin/students/add">
							+ Add New Student </a> <a href="${pageContext.request.contextPath}/admin/students"> 👥
							View All Students </a> <a href="${pageContext.request.contextPath}/admin/students"> ✎
							Manage Student Records </a>

					</div>

				</section>

			</main>

		</div>

	</body>

	</html>