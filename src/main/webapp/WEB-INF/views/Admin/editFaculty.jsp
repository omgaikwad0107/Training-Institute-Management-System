<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<!DOCTYPE html>
	<html lang="en">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<title>Edit Faculty | Training Institute</title>

		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Admin/editFaculty.css">
	</head>

	<body>

		<jsp:include page="AdminSideBar.jsp"></jsp:include>

		<div class="page-container">

			<!-- Page Header -->
			<div class="page-header">

				<div>
					<h1>✏️ Edit Faculty</h1>
					<p>Update faculty member information.</p>
				</div>

				<a href="${pageContext.request.contextPath}/admin/faculty" class="back-btn">
					← Back to Faculty
				</a>

			</div>


			<!-- Error Message -->
			<% String error=(String) request.getAttribute("error"); if (error !=null) { %>

				<div class="error-message">
					<%= error %>
				</div>

				<% } %>


					<!-- Edit Faculty Form -->
					<form action="${pageContext.request.contextPath}/admin/faculty/update" method="post"
						class="faculty-form">


						<!-- Hidden IDs -->
						<input type="hidden" name="id" value="${faculty.id}">

						<input type="hidden" name="userId" value="${faculty.userId}">


						<!-- Personal Information -->
						<div class="form-section">

							<div class="section-title">

								<div class="section-icon">
									👤
								</div>

								<div>
									<h2>Personal Information</h2>
									<p>Update the faculty member's personal details.</p>
								</div>

							</div>


							<div class="form-grid">


								<!-- Faculty Name -->
								<div class="form-group">

									<label for="facultyName">
										Faculty Name <span>*</span>
									</label>

									<input type="text" id="facultyName" name="facultyName"
										value="${faculty.facultyName}" placeholder="Enter faculty name" required>

								</div>


								<!-- Email -->
								<div class="form-group">

									<label for="email">
										Email Address <span>*</span>
									</label>

									<input type="email" id="email" name="email" value="${faculty.email}"
										placeholder="Enter email address" required>

								</div>


								<!-- Mobile -->
								<div class="form-group">

									<label for="mobile">
										Mobile Number <span>*</span>
									</label>

									<input type="tel" id="mobile" name="mobile" value="${faculty.mobile}" maxlength="10"
										placeholder="Enter mobile number" required>

								</div>


								<!-- Gender -->
								<div class="form-group">

									<label for="gender">
										Gender <span>*</span>
									</label>

									<select id="gender" name="gender" required>

										<option value="">
											Select Gender
										</option>

										<option value="MALE" ${faculty.gender=='MALE' ? 'selected' : '' }>
											Male
										</option>

										<option value="FEMALE" ${faculty.gender=='FEMALE' ? 'selected' : '' }>
											Female
										</option>

										<option value="OTHER" ${faculty.gender=='OTHER' ? 'selected' : '' }>
											Other
										</option>

									</select>

								</div>


								<!-- DOB -->
								<div class="form-group">

									<label for="dob">
										Date of Birth
									</label>

									<input type="date" id="dob" name="dob" value="${faculty.dob}">

								</div>


								<!-- Specialization -->
								<div class="form-group">

									<label for="specialization">
										Specialization <span>*</span>
									</label>

									<input type="text" id="specialization" name="specialization"
										value="${faculty.specialization}" placeholder="e.g. Java, Python, C++" required>

								</div>


								<!-- Address -->
								<div class="form-group full-width">

									<label for="address">
										Address
									</label>

									<textarea id="address" name="address" rows="3"
										placeholder="Enter complete address">${faculty.address}</textarea>

								</div>

							</div>

						</div>



						<!-- Professional Information -->
						<div class="form-section">

							<div class="section-title">

								<div class="section-icon">
									💼
								</div>

								<div>
									<h2>Professional Information</h2>
									<p>Update faculty joining and status information.</p>
								</div>

							</div>


							<div class="form-grid">


								<!-- Joining Date -->
								<div class="form-group">

									<label for="joiningDate">
										Joining Date
									</label>

									<input type="date" id="joiningDate" name="joiningDate"
										value="${faculty.joiningDate}">

								</div>


								<!-- Status -->
								<div class="form-group">

									<label for="status">
										Status <span>*</span>
									</label>

									<select id="status" name="status" required>

										<option value="ACTIVE" ${faculty.status=='ACTIVE' ? 'selected' : '' }>
											Active
										</option>

										<option value="INACTIVE" ${faculty.status=='INACTIVE' ? 'selected' : '' }>
											Inactive
										</option>

									</select>

								</div>

							</div>

						</div>



						<!-- Login Information -->
						<div class="form-section">

							<div class="section-title">

								<div class="section-icon">
									🔐
								</div>

								<div>
									<h2>Login Information</h2>
									<p>Update faculty login credentials.</p>
								</div>

							</div>


							<div class="form-grid">


								<!-- Username -->
								<div class="form-group">

									<label for="username">
										Username <span>*</span>
									</label>

									<input type="text" id="username" name="username" value="${faculty.username}"
										placeholder="Enter username" required>

								</div>


								<!-- Password -->
								<div class="form-group">

									<label for="password">
										Password <span>*</span>
									</label>

									<input type="password" id="password" name="password" value="${faculty.password}"
										placeholder="Enter password" required>

								</div>

							</div>

						</div>



						<!-- Form Actions -->
						<div class="form-actions">

							<a href="${pageContext.request.contextPath}/admin/faculty" class="btn btn-cancel">
								Cancel
							</a>

							<button type="reset" class="btn btn-reset">
								Reset
							</button>

							<button type="submit" class="btn btn-update">
								💾 Update Faculty
							</button>

						</div>

					</form>

		</div>

	</body>

	</html>