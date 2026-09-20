<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>My Courses | Training Institute</title>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Student/StudentSideBar.css">


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Student/MyCourses.css">

</head>


<body>


	<!-- =====================================================
         SIDEBAR
         ===================================================== -->

	<jsp:include page="StudentSideBar.jsp" />


	<!-- =====================================================
         MAIN CONTENT
         ===================================================== -->

	<main class="main-content">


		<!-- =================================================
             TOP HEADER
             ================================================= -->

		<header class="top-header">

			<div class="header-left">

				<h3>My Courses</h3>

			</div>


			<div class="header-right">


				<div class="notification">

					🔔 <span class="notification-dot"></span>

				</div>


				<div class="student-profile">


					<div class="profile-avatar">R</div>


					<div class="profile-info">

						<strong> ${student.studentName} </strong> <span> Student </span>

					</div>

				</div>

			</div>

		</header>



		<!-- =================================================
             PAGE CONTENT
             ================================================= -->

		<section class="page-content">


			<!-- =================================================
                 PAGE HEADING
                 ================================================= -->

			<div class="page-heading">

				<div>

					<h1>My Courses</h1>

					<p>View your enrolled courses and course details.</p>

				</div>

			</div>



			<!-- =================================================
                 COURSE CARD
                 ================================================= -->

			<div class="course-card">


				<!-- =================================================
                     COURSE HEADER
                     ================================================= -->

				<div class="course-header">


					<div class="course-icon">☕</div>


					<div class="course-title">


						<h2>${student.course}</h2>


						<span class="course-status"> ${student.enrollmentStatus} </span>


						<p>Full Stack Development Program</p>

					</div>

				</div>



				<!-- =================================================
                     COURSE INFORMATION
                     ================================================= -->

				<div class="course-info-grid">


					<!-- Batch -->

					<div class="info-box">

						<span> Batch </span> <strong> ${student.batch} </strong>

					</div>



					<!-- Duration -->

					<div class="info-box">

						<span> Duration </span> <strong>
							${student.courseDuration} </strong>

					</div>



					<!-- Course Fees -->

					<div class="info-box">

						<span> Course Fees </span> <strong>
							₹${student.courseFees} </strong>

					</div>



					<!-- Faculty -->

					<div class="info-box">

						<span> Faculty </span> <strong> Amit Patil </strong>

					</div>



					<!-- Enrollment Date -->

					<div class="info-box">

						<span> Enrollment Date </span> <strong>
							${student.enrollmentDate} </strong>

					</div>



					<!-- Course Status -->

					<div class="info-box">

						<span> Course Status </span> <strong class="active-text">

							${student.enrollmentStatus} </strong>

					</div>

				</div>



				<!-- =================================================
                     COURSE PROGRESS
                     ================================================= -->

				<div class="progress-section">


					<div class="progress-heading">


						<div>

							<span> Course Progress </span>

						</div>


						<strong> 65% </strong>

					</div>


					<div class="progress-bar">

						<div class="progress-value" style="width: 65%;"></div>

					</div>

				</div>



				<!-- =================================================
                     COURSE FOOTER
                     ================================================= -->

				<div class="course-footer">


					<div class="footer-info">📚 Currently Enrolled</div>


					<a href="${pageContext.request.contextPath}/student/dashboard"
						class="back-btn"> ← Back to Dashboard </a>

				</div>

			</div>



			<!-- =================================================
                 COURSE SUMMARY
                 ================================================= -->

			<div class="summary-card">


				<div class="summary-icon">📖</div>


				<div class="summary-content">


					<h3>Keep Learning!</h3>


					<p>Continue your course regularly and keep track of your
						attendance, assessments and results.</p>

				</div>

			</div>


		</section>

	</main>


</body>

</html>