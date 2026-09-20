<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Assessments - Admin</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Admin/AdminAssessments.css">

</head>

<body>

	<%@ include file="AdminSideBar.jsp"%>


	<main class="main-content">

		<!-- =========================
             PAGE HEADER
        ========================== -->

		<div class="page-header">

			<div>
				<h1>Assessments</h1>

				<p>View and monitor all assessments</p>
			</div>

		</div>


		<!-- =========================
             SUMMARY CARDS
        ========================== -->

		<div class="summary-grid">

			<div class="summary-card">

				<div class="summary-icon">📝</div>

				<div class="summary-info">

					<span class="summary-title"> Total Assessments </span>

					<h2>${totalAssessments}</h2>

				</div>

			</div>


			<div class="summary-card">

				<div class="summary-icon upcoming-icon">📅</div>

				<div class="summary-info">

					<span class="summary-title"> Upcoming </span>

					<h2>${totalUpcoming}</h2>

				</div>

			</div>


			<div class="summary-card">

				<div class="summary-icon completed-icon">✅</div>

				<div class="summary-info">

					<span class="summary-title"> Completed </span>

					<h2>${totalCompleted}</h2>

				</div>

			</div>

		</div>


		<!-- =========================
             FILTER SECTION
        ========================== -->

		<div class="filter-card">

			<div class="filter-header">

				<h3>Filter Assessments</h3>

			</div>


			<form action="${pageContext.request.contextPath}/admin/assessments"
				method="get" class="filter-form">


				<!-- COURSE -->

				<div class="filter-group">

					<label for="course"> Course </label> <select name="course"
						id="course">

						<option value="">All Courses</option>

						<c:forEach var="course" items="${courses}">

							<option value="${course.courseName}"
								<c:if test="${selectedCourse == course.courseName}">
                                    selected
                                </c:if>>

								${course.courseName}</option>

						</c:forEach>

					</select>

				</div>


				<!-- BATCH -->

				<div class="filter-group">

					<label for="batch"> Batch </label> <select name="batch" id="batch">

						<option value="">All Batches</option>

						<c:forEach var="batch" items="${batches}">

							<option value="${batch.batchName}"
								<c:if test="${selectedBatch == batch.batchName}">
                                    selected
                                </c:if>>

								${batch.batchName}</option>

						</c:forEach>

					</select>

				</div>


				<!-- STATUS -->

				<div class="filter-group">

					<label for="status"> Status </label> <select name="status"
						id="status">

						<option value="">All Status</option>

						<option value="UPCOMING"
							<c:if test="${selectedStatus == 'UPCOMING'}">
                                selected
                            </c:if>>
							Upcoming</option>

						<option value="COMPLETED"
							<c:if test="${selectedStatus == 'COMPLETED'}">
                                selected
                            </c:if>>
							Completed</option>

					</select>

				</div>


				<!-- BUTTONS -->

				<div class="filter-actions">

					<button type="submit" class="filter-btn">🔍 Filter</button>

					<a href="${pageContext.request.contextPath}/admin/assessments"
						class="clear-btn"> Clear </a>

				</div>

			</form>

		</div>


		<!-- =========================
             ASSESSMENT TABLE
        ========================== -->

		<div class="table-card">

			<div class="table-header">

				<div>

					<h3>Assessment List</h3>

					<p>All assessments created by faculty</p>

				</div>

			</div>


			<c:choose>

				<c:when test="${not empty assessmentList}">

					<div class="table-wrapper">

						<table>

							<thead>

								<tr>

									<th>#</th>

									<th>Assessment</th>

									<th>Course</th>

									<th>Batch</th>

									<th>Date</th>

									<th>Total Marks</th>

									<th>Status</th>

								</tr>

							</thead>


							<tbody>

								<c:forEach var="assessment" items="${assessmentList}"
									varStatus="loop">

									<tr>

										<td>${loop.index + 1}</td>


										<td>

											<div class="assessment-name">

												${assessment.assessmentName}</div>

										</td>


										<td>${assessment.courseName}</td>


										<td>${assessment.batchName}</td>


										<td><fmt:parseDate value="${assessment.assessmentDate}"
												pattern="yyyy-MM-dd" var="assessmentDate" /> <fmt:formatDate
												value="${assessmentDate}" pattern="dd-MM-yyyy" /></td>


										<td><span class="marks"> ${assessment.totalMarks}

										</span></td>


										<td><c:choose>

												<c:when test="${assessment.status == 'UPCOMING'}">

													<span class="status upcoming"> Upcoming </span>

												</c:when>


												<c:when test="${assessment.status == 'COMPLETED'}">

													<span class="status completed"> Completed </span>

												</c:when>


												<c:otherwise>

													<span class="status"> ${assessment.status} </span>

												</c:otherwise>

											</c:choose></td>

									</tr>

								</c:forEach>

							</tbody>

						</table>

					</div>

				</c:when>


				<c:otherwise>

					<div class="empty-state">

						<div class="empty-icon">📝</div>

						<h3>No Assessments Found</h3>

						<p>There are no assessments matching the selected filters.</p>

					</div>

				</c:otherwise>

			</c:choose>

		</div>

	</main>

</body>

</html>