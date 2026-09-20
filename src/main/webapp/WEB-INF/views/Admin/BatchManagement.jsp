<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%@ taglib prefix="c" uri="jakarta.tags.core" %>

		<!DOCTYPE html>
		<html>

		<head>

			<meta charset="UTF-8">

			<title>Batch Management</title>

			<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Admin/BatchManagement.css">

		</head>

		<body>

			<jsp:include page="AdminSideBar.jsp"></jsp:include>

			<div class="page-container">

				<div class="page-header">

					<div>
						<h1>Batch Management</h1>

						<p>
							Manage training institute batches
						</p>
					</div>

					<a href="${pageContext.request.contextPath}/admin/batches/add" class="add-batch-btn">
						+ Add Batch
					</a>

				</div>


				<c:if test="${param.success == 'true'}">

					<div class="success-message">
						Batch added successfully!
					</div>

				</c:if>


				<c:if test="${param.updated == 'true'}">

					<div class="success-message">
						Batch updated successfully!
					</div>

				</c:if>


				<c:if test="${param.deleted == 'true'}">

					<div class="success-message">
						Batch deleted successfully!
					</div>

				</c:if>


				<c:if test="${param.error != null}">

					<div class="error-message">
						Something went wrong!
					</div>

				</c:if>


				<div class="batch-table-container">

					<table class="batch-table">

						<thead>

							<tr>

								<th>ID</th>

								<th>Batch Name</th>

								<th>Course</th>

								<th>Start Date</th>

								<th>End Date</th>

								<th>Status</th>

								<th>Actions</th>

							</tr>

						</thead>


						<tbody>

							<c:choose>

								<c:when test="${not empty batches}">

									<c:forEach var="batch" items="${batches}">

										<tr>

											<td>
												${batch.id}
											</td>

											<td>

												<strong>
													${batch.batchName}
												</strong>

											</td>

											<td>
												${batch.courseName}
											</td>

											<td>
												${batch.startDate}
											</td>

											<td>
												${batch.endDate}
											</td>

											<td>

												<c:choose>

													<c:when test="${batch.status == 'ACTIVE'}">

														<span class="status active">
															Active
														</span>

													</c:when>

													<c:when test="${batch.status == 'COMPLETED'}">

														<span class="status completed">
															Completed
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

												<a href="${pageContext.request.contextPath}/admin/batches/edit/${batch.id}"
													class="edit-btn">
													Edit
												</a>

												<a href="${pageContext.request.contextPath}/admin/batches/delete/${batch.id}"
													class="delete-btn"
													onclick="return confirm('Are you sure you want to delete this batch?');">
													Delete
												</a>

											</td>

										</tr>

									</c:forEach>

								</c:when>


								<c:otherwise>

									<tr>

										<td colspan="7" class="no-data">

											No batches available.

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