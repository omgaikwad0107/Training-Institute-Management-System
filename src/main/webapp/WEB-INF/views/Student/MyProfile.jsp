<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>My Profile | Training Institute</title>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Student/StudentSideBar.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Student/MyProfile.css">

</head>


<body>


	<!-- SIDEBAR -->

	<jsp:include page="StudentSideBar.jsp" />


	<!-- MAIN CONTENT -->

	<main class="main-content">


		<!-- HEADER -->

		<header class="top-header">


			<div class="header-left">

				<h3>My Profile</h3>

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


			<!-- PAGE HEADING -->

			<div class="page-heading">

				<div>

					<h1>My Profile</h1>

					<p>View your personal and academic information.</p>

				</div>

			</div>



			<!-- PROFILE CARD -->

			<div class="profile-card">


				<!-- PROFILE HEADER -->

				<div class="profile-header">


					<div class="large-avatar">

						<c:choose>

							<c:when test="${not empty student.studentName}">
                                ${student.studentName.substring(0,1).toUpperCase()}
                            </c:when>

							<c:otherwise>
                                U
                            </c:otherwise>

						</c:choose>

					</div>


					<div class="profile-title">

						<h2>${student.studentName}</h2>

						<p>Student</p>

						<span class="status-badge"> ${student.status} </span>

					</div>


				</div>



				<!-- PERSONAL INFORMATION -->

				<div class="profile-section">


					<h3>Personal Information</h3>


					<div class="profile-grid">


						<div class="profile-item">

							<span> Full Name </span> <strong> ${student.studentName}
							</strong>

						</div>


						<div class="profile-item">

							<span> Email </span> <strong> ${student.email} </strong>

						</div>


						<div class="profile-item">

							<span> Mobile </span> <strong> ${student.mobile} </strong>

						</div>


						<div class="profile-item">

							<span> Gender </span> <strong> ${student.gender} </strong>

						</div>


						<div class="profile-item">

							<span> Date of Birth </span> <strong> ${student.dob} </strong>

						</div>


						<div class="profile-item">

							<span> Admission Date </span> <strong>
								${student.admissionDate} </strong>

						</div>


						<div class="profile-item full-width">

							<span> Address </span> <strong> ${student.address} </strong>

						</div>


					</div>

				</div>



				<!-- ACADEMIC INFORMATION -->

				<div class="profile-section">


					<h3>Academic Information</h3>


					<div class="profile-grid">


						<div class="profile-item">

							<span> Course </span> <strong> ${student.course} </strong>

						</div>


						<div class="profile-item">

							<span> Batch </span> <strong> ${student.batch} </strong>

						</div>


						<div class="profile-item">

							<span> Enrollment Date </span> <strong>
								${student.enrollmentDate} </strong>

						</div>


						<div class="profile-item">

							<span> Enrollment Status </span> <strong>
								${student.enrollmentStatus} </strong>

						</div>


					</div>

				</div>



				<!-- FOOTER -->

				<div class="profile-footer">

					<a href="${pageContext.request.contextPath}/student/dashboard"
						class="back-btn"> ← Back to Dashboard </a>

				</div>


			</div>


		</section>


	</main>


</body>

</html>