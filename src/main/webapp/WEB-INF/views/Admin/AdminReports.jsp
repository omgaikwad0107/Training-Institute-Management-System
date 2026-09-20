<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Reports - Admin</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Admin/AdminReports.css">

</head>


<body>


	<%@ include file="AdminSideBar.jsp"%>


	<main class="main-content">


		<!-- =========================
             PAGE HEADER
        ========================== -->

		<div class="page-header">

			<div>

				<h1>Reports</h1>

				<p>Overview of institute management data</p>

			</div>

		</div>


		<!-- =========================
             STUDENT REPORT
        ========================== -->

		<section class="report-section">

			<div class="section-title">

				<h2>Student Summary</h2>

			</div>


			<div class="report-grid">


				<div class="report-card">

					<div class="report-icon">👥</div>

					<div>

						<span>Total Students</span>

						<h3>${report.totalStudents}</h3>

					</div>

				</div>


				<div class="report-card">

					<div class="report-icon">✅</div>

					<div>

						<span>Active Students</span>

						<h3>${report.activeStudents}</h3>

					</div>

				</div>


				<div class="report-card">

					<div class="report-icon">⏸️</div>

					<div>

						<span>Inactive Students</span>

						<h3>${report.inactiveStudents}</h3>

					</div>

				</div>


				<div class="report-card">

					<div class="report-icon">🎓</div>

					<div>

						<span>Completed Students</span>

						<h3>${report.completedStudents}</h3>

					</div>

				</div>


			</div>

		</section>


		<!-- =========================
             COURSE REPORT
        ========================== -->

		<section class="report-section">

			<div class="section-title">

				<h2>Course Summary</h2>

			</div>


			<div class="report-grid">


				<div class="report-card">

					<div class="report-icon">📚</div>

					<div>

						<span>Total Courses</span>

						<h3>${report.totalCourses}</h3>

					</div>

				</div>


				<div class="report-card">

					<div class="report-icon">✔️</div>

					<div>

						<span>Active Courses</span>

						<h3>${report.activeCourses}</h3>

					</div>

				</div>


			</div>

		</section>


		<!-- =========================
             FACULTY & BATCH REPORT
        ========================== -->

		<section class="report-section">

			<div class="section-title">

				<h2>Faculty & Batch Summary</h2>

			</div>


			<div class="report-grid">


				<div class="report-card">

					<div class="report-icon">👨‍🏫</div>

					<div>

						<span>Total Faculty</span>

						<h3>${report.totalFaculty}</h3>

					</div>

				</div>


				<div class="report-card">

					<div class="report-icon">🟢</div>

					<div>

						<span>Active Faculty</span>

						<h3>${report.activeFaculty}</h3>

					</div>

				</div>


				<div class="report-card">

					<div class="report-icon">🗓️</div>

					<div>

						<span>Total Batches</span>

						<h3>${report.totalBatches}</h3>

					</div>

				</div>


				<div class="report-card">

					<div class="report-icon">📅</div>

					<div>

						<span>Active Batches</span>

						<h3>${report.activeBatches}</h3>

					</div>

				</div>


			</div>

		</section>


		<!-- =========================
             ATTENDANCE REPORT
        ========================== -->

		<section class="report-section">

			<div class="section-title">

				<h2>Attendance Summary</h2>

			</div>


			<div class="report-grid">


				<div class="report-card">

					<div class="report-icon">📋</div>

					<div>

						<span>Total Records</span>

						<h3>${report.totalAttendanceRecords}</h3>

					</div>

				</div>


				<div class="report-card">

					<div class="report-icon">🟢</div>

					<div>

						<span>Present</span>

						<h3>${report.totalPresent}</h3>

					</div>

				</div>


				<div class="report-card">

					<div class="report-icon">🔴</div>

					<div>

						<span>Absent</span>

						<h3>${report.totalAbsent}</h3>

					</div>

				</div>


				<div class="report-card attendance-card">

					<div class="report-icon">📊</div>

					<div>

						<span>Attendance Percentage</span>

						<h3>

							<fmt:formatNumber value="${report.attendancePercentage}"
								maxFractionDigits="2" />

							%

						</h3>

					</div>

				</div>


			</div>

		</section>


		<!-- =========================
             ASSESSMENT REPORT
        ========================== -->

		<section class="report-section">

			<div class="section-title">

				<h2>Assessment Summary</h2>

			</div>


			<div class="report-grid">


				<div class="report-card">

					<div class="report-icon">📝</div>

					<div>

						<span>Total Assessments</span>

						<h3>${report.totalAssessments}</h3>

					</div>

				</div>


				<div class="report-card">

					<div class="report-icon">📅</div>

					<div>

						<span>Upcoming</span>

						<h3>${report.upcomingAssessments}</h3>

					</div>

				</div>


				<div class="report-card">

					<div class="report-icon">✅</div>

					<div>

						<span>Completed</span>

						<h3>${report.completedAssessments}</h3>

					</div>

				</div>


			</div>

		</section>


	</main>


</body>

</html>