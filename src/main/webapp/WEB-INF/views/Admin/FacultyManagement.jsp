<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%@ taglib prefix="c" uri="jakarta.tags.core" %>

		<!DOCTYPE html>
		<html lang="en">

		<head>

			<meta charset="UTF-8">

			<meta name="viewport" content="width=device-width, initial-scale=1.0">

			<title>Faculty Management</title>

			<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Admin/FacultyManagement.css">

		</head>

		<body>

			<!-- Sidebar -->
			<jsp:include page="AdminSideBar.jsp"></jsp:include>


			<div class="page-container">

				<!-- ================= HEADER ================= -->

				<div class="page-header">

					<div>

						<h1>Faculty Management</h1>

						<p>
							Manage training institute faculty members
						</p>

					</div>


					<a href="${pageContext.request.contextPath}/admin/faculty/add" class="add-faculty-btn">

						+ Add Faculty

					</a>

				</div>


				<!-- ================= SUCCESS / ERROR ================= -->

				<c:if test="${param.success == 'true'}">

					<div class="success-message">
						Faculty added successfully!
					</div>

				</c:if>


				<c:if test="${param.updated == 'true'}">

					<div class="success-message">
						Faculty updated successfully!
					</div>

				</c:if>


				<c:if test="${param.deleted == 'true'}">

					<div class="success-message">
						Faculty deleted successfully!
					</div>

				</c:if>


				<c:if test="${param.error != null}">

					<div class="error-message">
						Something went wrong!
					</div>

				</c:if>


				<!-- ================= FACULTY TABLE ================= -->

				<div class="faculty-table-container">

					<table class="faculty-table">

						<thead>

							<tr>

								<th>ID</th>

								<th>Faculty Name</th>

								<th>Email</th>

								<th>Mobile</th>

								<th>Specialization</th>

								<th>Joining Date</th>

								<th>Status</th>

								<th>Actions</th>

							</tr>

						</thead>


						<tbody>

							<c:choose>

								<c:when test="${not empty facultyList}">

									<c:forEach var="faculty" items="${facultyList}">

										<tr>

											<!-- ID -->

											<td>
												${faculty.id}
											</td>


											<!-- Faculty Name -->

											<td>

												<strong>
													${faculty.facultyName}
												</strong>

											</td>


											<!-- Email -->

											<td>
												${faculty.email}
											</td>


											<!-- Mobile -->

											<td>
												${faculty.mobile}
											</td>


											<!-- Specialization -->

											<td>
												${faculty.specialization}
											</td>


											<!-- Joining Date -->

											<td>
												${faculty.joiningDate}
											</td>


											<!-- Status -->

											<td>

												<c:choose>

													<c:when test="${faculty.status == 'ACTIVE'}">

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


											<!-- Actions -->

											<td>

												<a href="${pageContext.request.contextPath}/admin/faculty/edit/${faculty.id}"
													class="edit-btn">

													Edit

												</a>


												<a href="${pageContext.request.contextPath}/admin/faculty/delete/${faculty.id}"
													class="delete-btn"
													onclick="return confirm('Are you sure you want to delete this faculty?');">

													Delete

												</a>

											</td>

										</tr>

									</c:forEach>

								</c:when>


								<c:otherwise>

									<tr>

										<td colspan="8" class="no-data">

											No faculty available.

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