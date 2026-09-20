<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>My Results | Training Institute</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Student/StudentSideBar.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Student/MyResults.css">

</head>

<body>

	<jsp:include page="StudentSideBar.jsp" />


	<main class="main-content">


		<!-- TOP HEADER -->

		<header class="top-header">

			<div class="header-left">

				<h3>My Results</h3>

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



		<!-- PAGE CONTENT -->

		<section class="page-content">


			<div class="page-heading">

				<div>

					<h1>My Results</h1>

					<p>View your assessment results and marks.</p>

				</div>

			</div>



			<!-- STUDENT INFORMATION -->

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



			<!-- RESULT SECTION -->

			<div class="result-section">


				<div class="section-title">

					<h2>Result List</h2>

				</div>



				<c:choose>


					<c:when test="${not empty resultList}">


						<div class="result-list">


							<c:forEach var="result" items="${resultList}">


								<div class="result-card">


									<div class="result-icon">📊</div>



									<div class="result-details">


										<div class="result-title-row">


											<div>

												<h3>${result.assessmentName}</h3>

												<p class="course-name">${result.courseName}</p>

											</div>


											<c:choose>


												<c:when test="${result.resultStatus == 'PASS'}">

													<span class="status pass"> PASS </span>

												</c:when>


												<c:otherwise>

													<span class="status fail"> FAIL </span>

												</c:otherwise>


											</c:choose>


										</div>



										<!-- RESULT INFORMATION -->

										<div class="result-info">


											<div class="info-item">

												<span> 📅 Assessment Date </span> <strong>
													${result.assessmentDate} </strong>

											</div>



											<div class="info-item">

												<span> 🎯 Total Marks </span> <strong>
													${result.totalMarks} </strong>

											</div>



											<div class="info-item">

												<span> 📝 Marks Obtained </span> <strong>
													${result.marksObtained} </strong>

											</div>



											<div class="info-item">

												<span> 🎓 Batch </span> <strong>
													${result.batchName} </strong>

											</div>


										</div>



										<!-- REMARKS -->

										<c:if test="${not empty result.remarks}">

											<div class="remarks">

												<span> Remarks </span>

												<p>${result.remarks}</p>

											</div>

										</c:if>


									</div>

								</div>


							</c:forEach>


						</div>


					</c:when>



					<c:otherwise>


						<div class="empty-state">


							<div class="empty-icon">📊</div>


							<h3>No Results Available</h3>


							<p>Your assessment results will appear here once marks are
								entered by faculty.</p>


						</div>


					</c:otherwise>


				</c:choose>


			</div>



			<!-- FOOTER -->

			<div class="page-footer">


				<a href="${pageContext.request.contextPath}/student/dashboard"
					class="back-btn"> ← Back to Dashboard </a>


			</div>


		</section>


	</main>

</body>

</html>