<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<!DOCTYPE html>
	<html lang="en">

	<head>

		<meta charset="UTF-8">

		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<title>Add Faculty | Training Institute</title>

		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Admin/addFaculty.css">

	</head>

	<body>

		<!-- Sidebar -->
		<jsp:include page="AdminSideBar.jsp"></jsp:include>


		<div class="page-container">

			<!-- ================= HEADER ================= -->

			<div class="page-header">

				<div>

					<h1>➕ Add New Faculty</h1>

					<p>
						Add a new faculty member to the training institute.
					</p>

				</div>


				<a href="${pageContext.request.contextPath}/admin/faculty" class="back-btn">

					← Back to Faculty

				</a>

			</div>


			<!-- ================= ERROR MESSAGE ================= -->

			<c:if test="${not empty error}">

				<div class="error-message">
					${error}
				</div>

			</c:if>


			<!-- ================= FORM ================= -->

			<form action="${pageContext.request.contextPath}/admin/faculty/save" method="post" class="faculty-form">


				<!-- =================================================
                 PERSONAL INFORMATION
                 ================================================= -->

				<div class="form-section">

					<div class="section-title">

						<div class="section-icon">
							👤
						</div>

						<div>

							<h2>Personal Information</h2>

							<p>
								Enter the faculty member's personal details.
							</p>

						</div>

					</div>


					<div class="form-grid">


						<!-- Faculty Name -->

						<div class="form-group">

							<label for="facultyName">
								Faculty Name <span>*</span>
							</label>

							<input type="text" id="facultyName" name="facultyName" placeholder="Enter faculty name"
								required>

						</div>


						<!-- Email -->

						<div class="form-group">

							<label for="email">
								Email Address <span>*</span>
							</label>

							<input type="email" id="email" name="email" placeholder="Enter email address" required>

						</div>


						<!-- Mobile -->

						<div class="form-group">

							<label for="mobile">
								Mobile Number <span>*</span>
							</label>

							<input type="tel" id="mobile" name="mobile" placeholder="Enter mobile number" maxlength="10"
								required>

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

								<option value="MALE">
									Male
								</option>

								<option value="FEMALE">
									Female
								</option>

								<option value="OTHER">
									Other
								</option>

							</select>

						</div>


						<!-- DOB -->

						<div class="form-group">

							<label for="dob">
								Date of Birth
							</label>

							<input type="date" id="dob" name="dob">

						</div>


						<!-- Specialization -->

						<div class="form-group">

							<label for="specialization">
								Specialization <span>*</span>
							</label>

							<input type="text" id="specialization" name="specialization"
								placeholder="e.g. Java, Python, C++" required>

						</div>


						<!-- Address -->

						<div class="form-group full-width">

							<label for="address">
								Address
							</label>

							<textarea id="address" name="address" rows="3"
								placeholder="Enter complete address"></textarea>

						</div>

					</div>

				</div>


				<!-- =================================================
                 PROFESSIONAL INFORMATION
                 ================================================= -->

				<div class="form-section">

					<div class="section-title">

						<div class="section-icon">
							💼
						</div>

						<div>

							<h2>Professional Information</h2>

							<p>
								Enter faculty joining information.
							</p>

						</div>

					</div>


					<div class="form-grid">


						<!-- Joining Date -->

						<div class="form-group">

							<label for="joiningDate">
								Joining Date
							</label>

							<input type="date" id="joiningDate" name="joiningDate">

						</div>


						<!-- Status -->

						<div class="form-group">

							<label for="status">
								Status <span>*</span>
							</label>

							<select id="status" name="status" required>

								<option value="ACTIVE">
									Active
								</option>

								<option value="INACTIVE">
									Inactive
								</option>

							</select>

						</div>

					</div>

				</div>


				<!-- =================================================
                 LOGIN INFORMATION
                 ================================================= -->

				<div class="form-section">

					<div class="section-title">

						<div class="section-icon">
							🔐
						</div>

						<div>

							<h2>Login Information</h2>

							<p>
								Create login credentials for the faculty.
							</p>

						</div>

					</div>


					<div class="form-grid">


						<!-- Username -->

						<div class="form-group">

							<label for="username">
								Username <span>*</span>
							</label>

							<input type="text" id="username" name="username" placeholder="Enter username" required>

						</div>


						<!-- Password -->

						<div class="form-group">

							<label for="password">
								Password <span>*</span>
							</label>

							<input type="password" id="password" name="password" placeholder="Enter password" required>

						</div>

					</div>

				</div>


				<!-- =================================================
                 FORM ACTIONS
                 ================================================= -->

				<div class="form-actions">

					<a href="${pageContext.request.contextPath}/admin/faculty" class="btn btn-cancel">

						Cancel

					</a>


					<button type="reset" class="btn btn-reset">

						Reset

					</button>


					<button type="submit" class="btn btn-save">

						💾 Save Faculty

					</button>

				</div>


			</form>

		</div>

	</body>

	</html>