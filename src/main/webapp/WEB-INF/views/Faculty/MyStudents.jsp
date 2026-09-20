<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>My Students</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Faculty/MyStudents.css">

</head>

<body>

	<%@ include file="FacultySideBar.jsp"%>


	<div class="main-content">

		<!-- Header -->

		<div class="top-header">

			<div class="header-left">

				<h1>My Students</h1>

				<p>Students assigned to your batches</p>

			</div>


			<div class="header-right">

				<div class="faculty-profile">

					<div class="profile-avatar">F</div>

					<div class="profile-info">

						<strong>Faculty</strong> <span>Faculty</span>

					</div>

				</div>

			</div>

		</div>


		<!-- Page Content -->

		<div class="page-content">

			<div class="page-title">

				<div>

					<h2>Student List</h2>

					<p>Students from your assigned batches</p>

				</div>


				<div class="student-count">

					Total Students: <strong>${totalStudents}</strong>

				</div>

			</div>


			<!-- Student Table -->

			<div class="student-table-card">

				<c:choose>

					<c:when test="${empty studentList}">

						<div class="empty-state">

							<div class="empty-icon">👥</div>

							<h3>No Students Found</h3>

							<p>No active students are currently assigned to your batches.
							</p>

						</div>

					</c:when>


					<c:otherwise>

						<div class="table-wrapper">

							<table>

								<thead>

									<tr>

										<th>#</th>

										<th>Student</th>

										<th>Email</th>

										<th>Mobile</th>

										<th>Course</th>

										<th>Batch</th>

										<th>Status</th>

									</tr>

								</thead>


								<tbody>

									<c:forEach var="student" items="${studentList}"
										varStatus="status">


										<tr>

											<td>${status.index + 1}</td>


											<td>

												<div class="student-info">

													<div class="student-avatar">

														${student.studentName.substring(0,1)}</div>


													<div>

														<strong> ${student.studentName} </strong> <span>
															ID: ${student.id} </span>

													</div>

												</div>

											</td>


											<td>${student.email}</td>


											<td>${student.mobile}</td>


											<td>${student.course}</td>


											<td>${student.batch}</td>


											<td><span class="status-badge"> ${student.status}
											</span></td>

										</tr>


									</c:forEach>

								</tbody>

							</table>

						</div>

					</c:otherwise>

				</c:choose>

			</div>

		</div>

	</div>

</body>

</html>