<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>My Batches | Training Institute</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Student/StudentSideBar.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Student/MyBatches.css">

</head>

<body>

	<!-- Student Sidebar -->
	<jsp:include page="StudentSideBar.jsp" />


	<!-- Main Content -->
	<main class="main-content">

		<!-- Top Header -->
		<header class="top-header">

			<div class="header-left">
				<h3>My Batches</h3>
			</div>

			<div class="header-right">

				<div class="notification">
					🔔 <span class="notification-dot"></span>
				</div>

				<div class="student-profile">

					<div class="profile-avatar">R</div>

					<div class="profile-info">
						<strong>${student.studentName}</strong> <span>Student</span>
					</div>

				</div>

			</div>

		</header>


		<!-- Page Content -->
		<section class="page-content">

			<!-- Page Heading -->
			<div class="page-heading">

				<div>
					<h1>My Batches</h1>

					<p>View your enrolled batch details.</p>
				</div>

			</div>


			<!-- Batch Card -->
			<div class="batch-card">

				<!-- Batch Header -->
				<div class="batch-header">

					<div class="batch-icon">🎓</div>

					<div class="batch-title">

						<h2>${student.batch}</h2>

						<span class="batch-status"> ${student.enrollmentStatus} </span>

						<p>${student.course}</p>

					</div>

				</div>


				<!-- Batch Information -->
				<div class="batch-info-grid">

					<div class="info-box">

						<span>Batch Name</span> <strong> ${student.batch} </strong>

					</div>


					<div class="info-box">

						<span>Course</span> <strong> ${student.course} </strong>

					</div>


					<div class="info-box">

						<span>Enrollment Date</span> <strong>
							${student.enrollmentDate} </strong>

					</div>


					<div class="info-box">

						<span>Batch Status</span> <strong class="active-text">
							${student.enrollmentStatus} </strong>

					</div>

				</div>


				<!-- Batch Schedule -->
				<div class="schedule-section">

					<h3>Batch Schedule</h3>

					<div class="schedule-grid">

						<div class="schedule-box">

							<span>Class Days</span> <strong> Monday - Saturday </strong>

						</div>


						<div class="schedule-box">

							<span>Class Time</span> <strong> 9:00 AM - 11:00 AM </strong>

						</div>

					</div>

				</div>


				<!-- Footer -->
				<div class="batch-footer">

					<div class="footer-info">🎓 Currently Enrolled</div>

					<a href="${pageContext.request.contextPath}/student/dashboard"
						class="back-btn"> ← Back to Dashboard </a>

				</div>

			</div>


			<!-- Information Card -->
			<div class="info-card">

				<div class="info-icon">📚</div>

				<div class="info-content">

					<h3>Stay Consistent!</h3>

					<p>Attend your batch regularly and keep track of your
						attendance, classes and assessments.</p>

				</div>

			</div>

		</section>

	</main>

</body>

</html>