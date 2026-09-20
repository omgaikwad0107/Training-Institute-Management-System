<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%@ taglib prefix="c" uri="jakarta.tags.core" %>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Course Management</title>

			<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Admin/CourseManagement.css">
		</head>

		<body>
			<jsp:include page="AdminSideBar.jsp"></jsp:include>

			<div class="page-container">

				<!-- Header -->
				<div class="page-header">

					<div>
						<h1>Course Management</h1>
						<p>Manage training institute courses</p>
					</div>

					<a href="${pageContext.request.contextPath}/admin/courses/add" class="add-course-btn">
						+ Add Course
					</a>

				</div>


				<!-- Success Messages -->

				<c:if test="${param.success == 'true'}">
					<div class="success-message">
						Course added successfully!
					</div>
				</c:if>

				<c:if test="${param.updated == 'true'}">
					<div class="success-message">
						Course updated successfully!
					</div>
				</c:if>

				<c:if test="${param.deleted == 'true'}">
					<div class="success-message">
						Course deleted successfully!
					</div>
				</c:if>


				<!-- Error Message -->

				<c:if test="${param.error != null}">
					<div class="error-message">
						Something went wrong!
					</div>
				</c:if>


				<!-- Course Table -->

				<div class="course-table-container">

					<table class="course-table">

						<thead>
							<tr>
								<th>ID</th>
								<th>Course Name</th>
								<th>Duration</th>
								<th>Fees</th>
								<th>Status</th>
								<th>Actions</th>
							</tr>
						</thead>


						<tbody>

							<c:choose>

								<c:when test="${not empty courses}">

									<c:forEach var="course" items="${courses}">

										<tr>

											<td>
												${course.id}
											</td>

											<td>
												<strong>${course.courseName}</strong>
											</td>

											<td>
												${course.duration}
											</td>

											<td>
												₹${course.fees}
											</td>

											<td>

												<c:choose>

													<c:when test="${course.status == 'ACTIVE'}">

														<span class="status active">
															Active
														</span>

													</c:when>

													<c:otherwise>

														<span class="status inactive">
															Inactive
														</span>

													</c:otherwise>

												</c:choose>

											</td>


											<td>

												<!-- Edit -->

												<a href="${pageContext.request.contextPath}/admin/courses/edit/${course.id}"
													class="edit-btn">
													Edit
												</a>


												<!-- Delete -->

												<a href="${pageContext.request.contextPath}/admin/courses/delete/${course.id}"
													class="delete-btn"
													onclick="return confirm('Are you sure you want to delete this course?');">
													Delete
												</a>

											</td>

										</tr>

									</c:forEach>

								</c:when>


								<c:otherwise>

									<tr>

										<td colspan="6" class="no-data">
											No courses available.
										</td>

									</tr>

								</c:otherwise>

							</c:choose>

						</tbody>

					</table>

				</div>

			</div>

		</body>

		</html>