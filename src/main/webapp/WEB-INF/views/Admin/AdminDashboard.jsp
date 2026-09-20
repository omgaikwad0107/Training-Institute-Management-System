<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Admin Dashboard | Training Institute</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Admin/AdminDashboard.css">

</head>

<body>

	<div class="dashboard-container">

		<!-- ================= SIDEBAR ================= -->

		<jsp:include page="AdminSideBar.jsp"></jsp:include>


		<!-- ================= MAIN CONTENT ================= -->

		<main class="main-content">


			<!-- ================= TOP HEADER ================= -->

			<header class="top-header">

				<div></div>

				<div class="admin-profile">

					<div class="profile-icon">👤</div>

					<div>

						<strong>Admin</strong> <small>Administrator</small>

					</div>

					<span class="dropdown-arrow"> ⌄ </span>

				</div>

			</header>



			<!-- ================= PAGE CONTENT ================= -->

			<section class="content">


				<!-- ================= WELCOME ================= -->

				<div class="welcome-section">

					<div>

						<h1>Welcome, Admin!</h1>

						<p>Here's what's happening at your institute today.</p>

					</div>


					<div class="date-time">

						<span>📅</span> <span id="currentDate"></span> <span
							class="separator"> | </span> <span>🕐</span> <span
							id="currentTime"></span>

					</div>

				</div>



				<!-- ================= STATISTICS ================= -->

				<div class="stats-container">


					<!-- ================= STUDENTS ================= -->

					<div class="stat-card students">

						<div class="stat-icon">👥</div>

						<div class="stat-info">

							<h3>Total Students</h3>

							<h2>${totalStudents}</h2>

						</div>

					</div>



					<!-- ================= COURSES ================= -->

					<div class="stat-card courses">

						<div class="stat-icon">📚</div>

						<div class="stat-info">

							<h3>Total Courses</h3>

							<h2>${totalCourses}</h2>

						</div>

					</div>



					<!-- ================= FACULTY ================= -->

					<div class="stat-card faculty">

						<div class="stat-icon">👨‍🏫</div>

						<div class="stat-info">

							<h3>Total Faculty</h3>

							<h2>${totalFaculty}</h2>

						</div>

					</div>



					<!-- ================= BATCHES ================= -->

					<div class="stat-card batches">

						<div class="stat-icon">📅</div>

						<div class="stat-info">

							<h3>Total Batches</h3>

							<h2>${totalBatches}</h2>

						</div>

					</div>

				</div>



				<!-- ================= QUICK ACTIONS ================= -->

				<div class="quick-actions">

					<h2>Quick Actions</h2>


					<div class="action-grid">


						<!-- ================= ADD STUDENT ================= -->

						<a href="${pageContext.request.contextPath}/admin/students/add"
							class="action-card blue"> <span class="action-icon">
								👤 </span> <span> Add Student </span> <span class="arrow"> → </span>

						</a>



						<!-- ================= ADD COURSE ================= -->

						<a href="${pageContext.request.contextPath}/admin/courses/add"
							class="action-card green"> <span class="action-icon">
								📚 </span> <span> Add Course </span> <span class="arrow"> → </span>

						</a>



						<!-- ================= CREATE BATCH ================= -->

						<a href="${pageContext.request.contextPath}/admin/batches/add"
							class="action-card purple"> <span class="action-icon">
								👥 </span> <span> Create Batch </span> <span class="arrow"> → </span>

						</a>



						<!-- ================= ADD FACULTY ================= -->

						<a href="${pageContext.request.contextPath}/admin/faculty/add"
							class="action-card orange"> <span class="action-icon">
								👨‍🏫 </span> <span> Add Faculty </span> <span class="arrow"> →
						</span>

						</a>



						<!-- ================= MARK ATTENDANCE ================= -->

						<a href="${pageContext.request.contextPath}/admin/attendance"
							class="action-card cyan"> <span class="action-icon">
								📅 </span> <span> Attendance </span> <span class="arrow"> → </span>

						</a>



						<!-- ================= ADD ASSESSMENT ================= -->

						<a href="${pageContext.request.contextPath}/admin/assessments"
							class="action-card red"> <span class="action-icon">📝</span>

							<span>Assessments</span> <span class="arrow">→</span>

						</a>
					</div>

				</div>

			</section>

		</main>

	</div>



	<!-- ================= DATE & TIME ================= -->

	<script>
		function updateDateTime() {

			const now = new Date();

			const dateOptions = {

				weekday : 'long',

				day : 'numeric',

				month : 'long',

				year : 'numeric'

			};

			document.getElementById("currentDate").innerText = now
					.toLocaleDateString('en-IN', dateOptions);

			document.getElementById("currentTime").innerText = now
					.toLocaleTimeString('en-IN', {

						hour : '2-digit',

						minute : '2-digit'

					});

		}

		updateDateTime();

		setInterval(updateDateTime, 1000);
	</script>


</body>

</html>