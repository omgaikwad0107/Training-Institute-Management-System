<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<!DOCTYPE html>
	<html>

	<head>

		<meta charset="UTF-8">

		<title>Add Course</title>

		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Admin/addCourse.css">

	</head>

	<body>
		<jsp:include page="AdminSideBar.jsp"></jsp:include>


		<div class="page-container">

			<div class="page-header">

				<div>
					<h1>Add Course</h1>
					<p>Add a new training course</p>
				</div>

				<a href="${pageContext.request.contextPath}/admin/courses" class="back-btn">
					← Back to Courses
				</a>

			</div>


			<div class="form-container">

				<form action="${pageContext.request.contextPath}/admin/courses/save" method="post" class="course-form">


					<!-- Course Name -->

					<div class="form-group">

						<label for="courseName">
							Course Name <span>*</span>
						</label>

						<input type="text" id="courseName" name="courseName" placeholder="Enter course name" required>

					</div>


					<!-- Duration -->

					<div class="form-group">

						<label for="duration">
							Duration <span>*</span>
						</label>

						<input type="text" id="duration" name="duration" placeholder="Example: 6 Months" required>

					</div>


					<!-- Fees -->

					<div class="form-group">

						<label for="fees">
							Course Fees <span>*</span>
						</label>

						<input type="number" id="fees" name="fees" placeholder="Enter course fees" min="0" step="0.01"
							required>

					</div>


					<!-- Status -->

					<div class="form-group">

						<label for="status">
							Status <span>*</span>
						</label>

						<select id="status" name="status" required>

							<option value="ACTIVE" selected>
								Active
							</option>

							<option value="INACTIVE">
								Inactive
							</option>

						</select>

					</div>


					<!-- Buttons -->

					<div class="form-actions">

						<a href="${pageContext.request.contextPath}/admin/courses" class="cancel-btn">
							Cancel
						</a>

						<button type="submit" class="save-btn">
							Save Course
						</button>

					</div>

				</form>

			</div>

		</div>

	</body>

	</html>