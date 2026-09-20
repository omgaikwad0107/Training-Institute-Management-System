
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Student Dashboard | Training Institute</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Student/StudentSideBar.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Student/StudentDashboard.css">

</head>

<body>

	<!-- Sidebar -->
	<jsp:include page="StudentSideBar.jsp" />

	<!-- Main Content -->
	<main class="main-content">

		<!-- Top Header -->
		<header class="top-header">

			<div class="header-left">
				<h3>Student Panel</h3>
			</div>

			<div class="header-right">

				<div class="notification">
					🔔 <span class="notification-dot"></span>
				</div>

				<div class="student-profile">

					<!-- Profile Avatar -->
					<div class="profile-avatar">

						<c:choose>

							<c:when test="${not empty student.studentName}">
                                ${student.studentName.substring(0,1).toUpperCase()}
                            </c:when>

							<c:otherwise>
                                U
                            </c:otherwise>

						</c:choose>

					</div>

					<!-- Profile Info -->
					<div class="profile-info">
						<strong>${student.studentName}</strong> <span>Student</span>
					</div>

				</div>

			</div>

		</header>

		<!-- Page Content -->
		<section class="page-content">

			<!-- Welcome Section -->
			<div class="welcome-section">

				<div class="welcome-text">
					<h1>Welcome back, ${student.studentName}! 👋</h1>
					<p>Here's your learning overview for today.</p>
				</div>

				<div class="date-box">
					📅
					<%=new SimpleDateFormat("MMMM dd, yyyy").format(new Date())%>
				</div>

			</div>

			<!-- Statistics -->
			<div class="stats-grid">

				<!-- My Courses -->
				<div class="stat-card">

					<div class="stat-icon courses-icon">📚</div>

					<div class="stat-details">

						<span class="stat-title"> My Courses </span> <strong>
							${courseCount} </strong> <small> Active course </small>

					</div>

				</div>

				<!-- Attendance -->
				<div class="stat-card">

					<div class="stat-icon attendance-icon">✅</div>

					<div class="stat-details">

						<span class="stat-title"> Attendance </span> <strong>
							${attendancePercentage}% </strong> <small> ${presentClasses}
							Present / ${totalClasses} Classes </small>

					</div>

				</div>

				<!-- Assessments -->
				<div class="stat-card">

					<div class="stat-icon assessment-icon">📝</div>

					<div class="stat-details">

						<span class="stat-title"> Assessments </span> <strong>
							${completedAssessmentCount} </strong> <small> Completed
							assessments </small>

					</div>

				</div>

				<!-- Notices -->
				<div class="stat-card">

					<div class="stat-icon notice-icon">🔔</div>

					<div class="stat-details">

						<span class="stat-title"> Notices </span> <strong>
							${noticeCount} </strong> <small> <c:choose>

								<c:when test="${noticeCount > 0}">
                                    New notices available
                                </c:when>

								<c:otherwise>
                                    No notices available
                                </c:otherwise>

							</c:choose>

						</small>

					</div>

				</div>

			</div>

			<!-- Main Dashboard Grid -->
			<div class="dashboard-grid">

				<!-- My Course -->
				<div class="dashboard-card">

					<div class="card-header">

						<div>
							<h2>My Course</h2>
							<p>Your current enrolled course</p>
						</div>

						<a href="${pageContext.request.contextPath}/student/courses">
							View All </a>

					</div>

					<div class="course-content">

						<!-- Course Top -->
						<div class="course-top">

							<div class="course-image">📚</div>

							<div>
								<h3>${student.course}</h3>
								<p>${student.batch}</p>
							</div>

						</div>

						<!-- Course Information -->
						<div class="course-info">

							<div>
								<span>Batch</span> <strong>${student.batch}</strong>
							</div>

							<div>
								<span>Duration</span> <strong>${student.courseDuration}</strong>
							</div>

							<div>
								<span>Course Fees</span> <strong>₹${student.courseFees}</strong>
							</div>

						</div>

						<!-- Course Progress -->
						<div class="progress-section">

							<div class="progress-header">

								<span>Course Progress</span> <strong> Not Available </strong>

							</div>

							<div class="progress-bar">

								<div class="progress-value" style="width: 0%;"></div>

							</div>

						</div>

						<!-- Course Button -->
						<a href="${pageContext.request.contextPath}/student/courses"
							class="continue-btn"> View Course Details → </a>

					</div>

				</div>

				<!-- Upcoming Classes -->
				<div class="dashboard-card">

					<div class="card-header">

						<div>
							<h2>Upcoming Classes</h2>
							<p>Your next scheduled classes</p>
						</div>

						<a href="${pageContext.request.contextPath}/student/batches">
							View All </a>

					</div>

					<div class="class-list">

						<div class="empty-state">

							<div class="empty-icon">📅</div>

							<h3>No Class Schedule Available</h3>

							<p>Class schedule will appear here once it is added by the
								institute.</p>

						</div>

					</div>

				</div>

			</div>

			<!-- Bottom Dashboard Grid -->
			<div class="bottom-grid">

				<%--<!-- Recent Assessments -->
				<div class="dashboard-card">

					<div class="card-header">

						<div>
							<h2>Recent Assessments</h2>
							<p>Your latest assessment results</p>
						</div>

						<a href="${pageContext.request.contextPath}/student/results">
							View All </a>

					</div>

					<div class="assessment-list">

						<c:choose>

							<c:when test="${not empty resultList}">

								<c:forEach var="result" items="${resultList}" begin="0" end="2">

									<div class="assessment-item">

										<div class="assessment-info">

											<h3>${result.assessmentName}</h3>

											<p>${result.courseName}</p>

											<small> ${result.assessmentDate} </small>

										</div>

										<div class="assessment-result">

											<strong> ${result.marksObtained} /
												${result.totalMarks} </strong> <span> ${result.resultStatus} </span>

										</div>

									</div>

								</c:forEach>

							</c:when>

							<c:otherwise>

								<div class="empty-state">

									<div class="empty-icon">📝</div>

									<h3>No Results Available</h3>

									<p>Your assessment results will appear here once marks are
										entered by faculty.</p>

								</div>

							</c:otherwise>

						</c:choose>

					</div>

				</div> --%>

			<%-- <!-- Recent Notices -->
				<div class="dashboard-card">

					<div class="card-header">

						<div>
							<h2>Recent Notices</h2>
							<p>Latest institute announcements</p>
						</div>

					</div>

					<div class="notice-list">

						<div class="empty-state">

							<div class="empty-icon">📢</div>

							<h3>No Notices Available</h3>

							<p>Institute announcements will appear here.</p>

						</div>

					</div>

				</div>

			</div> --%>	

		</section>

	</main>

</body>

</html>

