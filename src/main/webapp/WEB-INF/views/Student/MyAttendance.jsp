<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>My Attendance | Training Institute</title>


<!-- Sidebar CSS -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Student/StudentSideBar.css">


<!-- Attendance CSS -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Student/MyAttendance.css">

</head>


<body>


	<!-- =====================================================
         SIDEBAR
    ====================================================== -->

	<jsp:include page="StudentSideBar.jsp" />



	<!-- =====================================================
         MAIN CONTENT
    ====================================================== -->

	<main class="main-content">


		<!-- =================================================
             HEADER
        ================================================== -->

		<header class="top-header">

			<div class="header-left">

				<h3>My Attendance</h3>

			</div>


			<div class="header-right">

				<div class="notification">
					🔔 <span class="notification-dot"></span>
				</div>


				<div class="student-profile">

					<div class="profile-avatar">

						<c:choose>

							<c:when test="${not empty student.studentName}">

                                ${student.studentName
                                    .substring(0,1)
                                    .toUpperCase()}

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



		<!-- =================================================
             PAGE CONTENT
        ================================================== -->

		<section class="page-content">


			<!-- Page Heading -->

			<div class="page-heading">

				<div>

					<h1>My Attendance</h1>

					<p>Track your class attendance and attendance history.</p>

				</div>

			</div>



			<!-- =================================================
                 ATTENDANCE SUMMARY
            ================================================== -->

			<div class="attendance-summary">


				<!-- Overall -->

				<div class="attendance-card overall">

					<div class="attendance-card-icon">📊</div>

					<div>

						<span> Overall Attendance </span> <strong>
							${String.format("%.2f", attendancePercentage)}% </strong>

					</div>

				</div>



				<!-- Total Classes -->

				<div class="attendance-card total">

					<div class="attendance-card-icon">📚</div>

					<div>

						<span> Total Classes </span> <strong> ${totalClasses} </strong>

					</div>

				</div>



				<!-- Present -->

				<div class="attendance-card present">

					<div class="attendance-card-icon">✓</div>

					<div>

						<span> Present </span> <strong> ${presentClasses} </strong>

					</div>

				</div>



				<!-- Absent -->

				<div class="attendance-card absent">

					<div class="attendance-card-icon">✕</div>

					<div>

						<span> Absent </span> <strong> ${absentClasses} </strong>

					</div>

				</div>

			</div>



			<!-- =================================================
                 ATTENDANCE PROGRESS
            ================================================== -->

			<div class="attendance-progress-card">

				<div class="progress-heading">

					<div>

						<h2>Attendance Progress</h2>

						<p>Your current overall attendance</p>

					</div>


					<strong> ${String.format(
                            "%.2f",
                            attendancePercentage
                        )}%

					</strong>

				</div>


				<div class="progress-bar">

					<div class="progress-value"
						style="width: ${attendancePercentage}%;"></div>

				</div>

			</div>



			<!-- =================================================
                 ATTENDANCE HISTORY
            ================================================== -->

			<div class="attendance-history-card">


				<div class="card-header">

					<div>

						<h2>Attendance History</h2>

						<p>Your daily attendance records</p>

					</div>

				</div>



				<!-- Table -->

				<div class="table-container">

					<table>

						<thead>

							<tr>

								<th>#</th>

								<th>Date</th>

								<th>Status</th>

								<th>Remarks</th>

							</tr>

						</thead>


						<tbody>


							<c:choose>


								<c:when test="${not empty attendanceList}">


									<c:forEach var="attendance" items="${attendanceList}"
										varStatus="loop">


										<tr>

											<td>${loop.index + 1}</td>


											<td>${attendance.attendanceDate}</td>


											<td><c:choose>

													<c:when test="${attendance.status == 'PRESENT'}">

														<span class="status present-status"> PRESENT </span>

													</c:when>


													<c:otherwise>

														<span class="status absent-status"> ABSENT </span>

													</c:otherwise>

												</c:choose></td>


											<td><c:choose>

													<c:when test="${not empty attendance.remarks}">

                                                        ${attendance.remarks}

                                                    </c:when>


													<c:otherwise>

                                                        -

                                                    </c:otherwise>

												</c:choose></td>

										</tr>


									</c:forEach>


								</c:when>


								<c:otherwise>


									<tr>

										<td colspan="4" class="no-data">No attendance records
											found.</td>

									</tr>


								</c:otherwise>


							</c:choose>


						</tbody>

					</table>

				</div>

			</div>



			<!-- =================================================
                 BACK BUTTON
            ================================================== -->

			<div class="page-footer">

				<a href="${pageContext.request.contextPath}/student/dashboard"
					class="back-btn"> ← Back to Dashboard </a>

			</div>


		</section>

	</main>


</body>

</html>