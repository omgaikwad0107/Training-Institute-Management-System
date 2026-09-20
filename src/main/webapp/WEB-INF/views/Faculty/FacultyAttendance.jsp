<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Faculty Attendance</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Faculty/FacultyAttendance.css">

</head>

<body>

	<%@ include file="FacultySideBar.jsp"%>


	<main class="main-content">

		<header class="top-header">

			<div class="header-left">

				<h1>Attendance</h1>

				<p>Mark attendance for your students</p>

			</div>


			<div class="header-right">

				<div class="faculty-profile">

					<div class="profile-avatar">F</div>

					<div class="profile-info">

						<strong>Faculty</strong> <span> Faculty Panel </span>

					</div>

				</div>

			</div>

		</header>


		<section class="page-content">


			<div class="page-title">

				<div>

					<h2>Mark Attendance</h2>

					<p>Attendance of students assigned to you</p>

				</div>


				<div class="student-count">

					<span class="count-number"> ${totalStudents} </span> <span
						class="count-label"> Students </span>

				</div>

			</div>


			<c:if test="${not empty successMessage}">

				<div class="success-message">${successMessage}</div>

			</c:if>


			<c:if test="${not empty errorMessage}">

				<div class="error-message">${errorMessage}</div>

			</c:if>


			<div class="attendance-card">


				<div class="attendance-header">

					<div>

						<h3>Student Attendance</h3>

						<p>Select attendance status</p>

					</div>


					<div class="date-box">

						<label> Attendance Date </label> <input type="date"
							id="attendanceDate" value="${today}">

					</div>

				</div>


				<c:choose>

					<c:when test="${not empty studentList}">


						<div class="student-table-wrapper">

							<table class="student-table">

								<thead>

									<tr>

										<th>#</th>

										<th>Student</th>

										<th>Course</th>

										<th>Batch</th>

										<th>Attendance</th>

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

													<span> ${student.studentName} </span>

												</div>

											</td>


											<td>${student.courseName}</td>


											<td>${student.batchName}</td>


											<td>

												<form
													action="${pageContext.request.contextPath}/faculty/attendance/save"
													method="post" class="attendance-form">


													<input type="hidden" name="studentId"
														value="${student.studentId}"> <input type="hidden"
														name="attendanceDate" class="date-input">


													<div class="attendance-actions">

														<label class="radio-option present"> <input
															type="radio" name="status" value="PRESENT" required>

															<span> Present </span>

														</label> <label class="radio-option absent"> <input
															type="radio" name="status" value="ABSENT"> <span>
																Absent </span>

														</label> <input type="text" name="remarks" placeholder="Remarks"
															class="remarks-input">


														<button type="submit" class="save-btn">Save</button>

													</div>

												</form>

											</td>

										</tr>

									</c:forEach>

								</tbody>

							</table>

						</div>


					</c:when>


					<c:otherwise>

						<div class="empty-state">

							<div class="empty-icon">👥</div>

							<h3>No Students Found</h3>

							<p>No active students are assigned to your batches.</p>

						</div>

					</c:otherwise>

				</c:choose>

			</div>

		</section>

	</main>


	<script>
		const datePicker = document.getElementById("attendanceDate");

		const dateInputs = document.querySelectorAll(".date-input");

		function updateAttendanceDates() {

			dateInputs.forEach(function(input) {

				input.value = datePicker.value;

			});

		}

		datePicker.addEventListener("change", updateAttendanceDates);

		updateAttendanceDates();
	</script>

</body>

</html>