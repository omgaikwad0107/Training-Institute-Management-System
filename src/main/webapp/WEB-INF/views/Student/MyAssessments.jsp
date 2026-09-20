<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>My Assessments | Training Institute</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Student/StudentSideBar.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Student/MyAssessments.css">

</head>


<body>


	<jsp:include page="StudentSideBar.jsp" />


	<main class="main-content">


		<header class="top-header">

			<div class="header-left">

				<h3>My Assessments</h3>

			</div>


			<div class="header-right">

				<div class="notification">

					🔔 <span class="notification-dot"></span>

				</div>


				<div class="student-profile">

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


					<div class="profile-info">

						<strong> ${student.studentName} </strong> <span> Student </span>

					</div>

				</div>

			</div>

		</header>


		<section class="page-content">


			<div class="page-heading">

				<div>

					<h1>My Assessments</h1>

					<p>View assessments scheduled for your batch.</p>

				</div>

			</div>


			<div class="student-info-card">


				<div class="student-info-item">

					<span>Student</span> <strong> ${student.studentName} </strong>

				</div>


				<div class="student-info-item">

					<span>Course</span> <strong> ${student.course} </strong>

				</div>


				<div class="student-info-item">

					<span>Batch</span> <strong> ${student.batch} </strong>

				</div>


			</div>


			<div class="assessment-section">


				<div class="section-title">

					<h2>Assessment List</h2>

				</div>


				<c:choose>

					<c:when test="${not empty assessmentList}">


						<div class="assessment-list">


							<c:forEach var="assessment" items="${assessmentList}">


								<div class="assessment-card">


									<div class="assessment-icon">📝</div>


									<div class="assessment-details">


										<div class="assessment-title-row">


											<h3>${assessment.assessmentName}</h3>


											<c:choose>

												<c:when test="${assessment.status == 'UPCOMING'}">

													<span class="status upcoming"> Upcoming </span>

												</c:when>


												<c:otherwise>

													<span class="status completed"> Completed </span>

												</c:otherwise>

											</c:choose>


										</div>


										<p class="course-name">${assessment.courseName}</p>


										<div class="assessment-info">


											<div class="info-item">

												<span> 📅 Date </span> <strong>
													${assessment.assessmentDate} </strong>

											</div>


											<div class="info-item">

												<span> 🎯 Total Marks </span> <strong>
													${assessment.totalMarks} </strong>

											</div>


											<div class="info-item">

												<span> 🎓 Batch </span> <strong>
													${assessment.batchName} </strong>

											</div>


										</div>


									</div>


								</div>


							</c:forEach>


						</div>


					</c:when>


					<c:otherwise>


						<div class="empty-state">


							<div class="empty-icon">📝</div>


							<h3>No Assessments Available</h3>


							<p>There are currently no assessments scheduled for your
								batch.</p>


						</div>


					</c:otherwise>

				</c:choose>


			</div>


			<div class="page-footer">


				<a href="${pageContext.request.contextPath}/student/dashboard"
					class="back-btn"> ← Back to Dashboard </a>


			</div>


		</section>


	</main>


</body>

</html>