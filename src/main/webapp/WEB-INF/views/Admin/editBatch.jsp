<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Edit Batch</title>

		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Admin/editBatch.css">
	</head>

	<body>

		<jsp:include page="AdminSideBar.jsp"></jsp:include>

		<div class="page-container">

			<div class="page-header">

				<div>
					<h1>Edit Batch</h1>
					<p>Update batch information</p>
				</div>

				<a href="${pageContext.request.contextPath}/admin/batches" class="back-btn"> ← Back </a>

			</div>


			<div class="form-container">

				<form action="${pageContext.request.contextPath}/admin/batches/update" method="post">

					<!-- Hidden ID -->
					<input type="hidden" name="id" value="${batch.id}">


					<!-- Batch Name -->
					<div class="form-group">

						<label> Batch Name <span>*</span>
						</label> <input type="text" name="batchName" value="${batch.batchName}"
							placeholder="Enter batch name" required>

					</div>


					<!-- Course Name -->
					<div class="form-group">

						<label> Course Name <span>*</span>
						</label> <input type="text" name="courseName" value="${batch.courseName}"
							placeholder="Enter course name" required>

					</div>


					<!-- Start Date -->
					<div class="form-group">

						<label> Start Date </label> <input type="date" name="startDate" value="${batch.startDate}">

					</div>


					<!-- End Date -->
					<div class="form-group">

						<label> End Date </label> <input type="date" name="endDate" value="${batch.endDate}">

					</div>


					<!-- Status -->
					<div class="form-group">

						<label> Status </label> <select name="status">

							<option value="ACTIVE" ${batch.status=='ACTIVE' ? 'selected' : '' }>Active</option>

							<option value="INACTIVE" ${batch.status=='INACTIVE' ? 'selected' : '' }>
								Inactive</option>

							<option value="COMPLETED" ${batch.status=='COMPLETED' ? 'selected' : '' }>
								Completed</option>

						</select>

					</div>


					<!-- Buttons -->
					<div class="form-actions">

						<a href="${pageContext.request.contextPath}/admin/batches" class="cancel-btn"> Cancel </a>

						<button type="submit" class="update-btn">Update Batch</button>

					</div>

				</form>

			</div>

		</div>

	</body>

	</html>