<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%@ taglib prefix="c" uri="jakarta.tags.core" %>

		<!DOCTYPE html>
		<html lang="en">

		<head>

			<meta charset="UTF-8">

			<meta name="viewport" content="width=device-width, initial-scale=1.0">

			<title>Add Student | Training Institute</title>

			<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Admin/addStudent.css">

		</head>


		<body>


			<!-- =====================================================
         SIDEBAR
    ====================================================== -->

			<jsp:include page="AdminSideBar.jsp"></jsp:include>



			<!-- =====================================================
         ADD STUDENT PAGE
    ====================================================== -->

			<div class="add-student-page">


				<!-- =================================================
             MAIN CONTENT
        ================================================== -->

				<main class="main-content">


					<!-- =============================================
                 TOP HEADER
            ============================================== -->

					<header class="top-header">

						<div class="header-left">

							<h2>Admin Panel</h2>

						</div>


						<div class="header-right">

							<div class="notification">
								🔔 <span class="notification-dot"></span>
							</div>


							<div class="admin-profile">

								<div class="profile-avatar">A</div>

								<div class="profile-info">

									<strong>Admin</strong> <span>Administrator</span>

								</div>

							</div>

						</div>

					</header>



					<!-- =============================================
                 PAGE CONTENT
            ============================================== -->

					<section class="page-content">


						<!-- =========================================
                     PAGE HEADER
                ========================================== -->

						<div class="page-header">


							<div class="page-title">

								<h1>➕ Add New Student</h1>

								<p>Add a new student to the training institute.</p>

							</div>


							<a href="${pageContext.request.contextPath}/StudentManagement" class="back-btn"> ← Back to
								Students </a>


						</div>



						<!-- =========================================
                     STUDENT FORM
                ========================================== -->

						<form action="${pageContext.request.contextPath}/admin/students/save" method="post"
							class="student-form">


							<!-- =====================================
                         PERSONAL INFORMATION
                    ====================================== -->

							<div class="form-section">


								<div class="section-title">


									<div class="section-icon">👤</div>


									<div>

										<h2>Personal Information</h2>

										<p>Enter the student's personal details.</p>

									</div>


								</div>



								<div class="form-grid">


									<!-- Student Name -->

									<div class="form-group">

										<label for="studentName"> Student Name <span>*</span>
										</label> <input type="text" id="studentName" name="studentName"
											placeholder="Enter student name" required>

									</div>



									<!-- Email -->

									<div class="form-group">

										<label for="email"> Email Address <span>*</span>
										</label> <input type="email" id="email" name="email"
											placeholder="Enter email address" required>

									</div>



									<!-- Mobile -->

									<div class="form-group">

										<label for="mobile"> Mobile Number <span>*</span>
										</label> <input type="tel" id="mobile" name="mobile"
											placeholder="Enter mobile number" maxlength="10" required>

									</div>



									<!-- Gender -->

									<div class="form-group">

										<label for="gender"> Gender <span>*</span>
										</label> <select id="gender" name="gender" required>

											<option value="">Select Gender</option>

											<option value="MALE">Male</option>

											<option value="FEMALE">Female</option>

											<option value="OTHER">Other</option>

										</select>

									</div>



									<!-- Date of Birth -->

									<div class="form-group">

										<label for="dob"> Date of Birth </label> <input type="date" id="dob" name="dob">

									</div>



									<!-- Address -->

									<div class="form-group full-width">

										<label for="address"> Address </label>

										<textarea id="address" name="address" rows="3"
											placeholder="Enter complete address"></textarea>

									</div>


								</div>

							</div>



							<!-- =====================================
                         COURSE INFORMATION
                    ====================================== -->

							<div class="form-section">


								<div class="section-title">


									<div class="section-icon">📚</div>


									<div>

										<h2>Course Information</h2>

										<p>Select the course and batch for the student.</p>

									</div>


								</div>



								<div class="form-grid">


									<!-- Course -->

									<div class="form-group">

										<label for="course"> Course <span>*</span>
										</label> <select id="course" name="course" required>

											<option value="">Select Course</option>


											<c:forEach var="course" items="${courses}">

												<option value="${course.courseName}">
													${course.courseName}</option>

											</c:forEach>


										</select>

									</div>



									<!-- Batch -->
									<div class="form-group">
										<label for="batch">
											Batch <span>*</span>
										</label>

										<select id="batch" name="batch" required>
											<option value="">Select Batch</option>

											<c:forEach var="batch" items="${batches}">
												<option value="${batch.batchName}">
													${batch.batchName}
												</option>
											</c:forEach>
										</select>
									</div>


									<!-- =====================================
                         LOGIN INFORMATION
                    ====================================== -->

									<div class="form-section">


										<div class="section-title">


											<div class="section-icon">🔐</div>


											<div>

												<h2>Login Information</h2>

												<p>Create login credentials for the student.</p>

											</div>


										</div>



										<div class="form-grid">


											<!-- Username -->

											<div class="form-group">

												<label for="username"> Username <span>*</span>
												</label> <input type="text" id="username" name="username"
													placeholder="Enter username" required>

											</div>



											<!-- Password -->

											<div class="form-group">

												<label for="password"> Password <span>*</span>
												</label> <input type="password" id="password" name="password"
													placeholder="Enter password" required>

											</div>



											<!-- Status -->

											<div class="form-group">

												<label for="status"> Status <span>*</span>
												</label> <select id="status" name="status" required>

													<option value="ACTIVE">Active</option>

													<option value="INACTIVE">Inactive</option>

												</select>

											</div>


										</div>

									</div>



									<!-- =====================================
                         FORM ACTIONS
                    ====================================== -->

									<div class="form-actions">


										<a href="${pageContext.request.contextPath}/StudentManagement"
											class="btn btn-cancel"> Cancel </a>


										<button type="reset" class="btn btn-reset">Reset</button>


										<button type="submit" class="btn btn-save">💾 Save
											Student</button>


									</div>
						</form>


					</section>


				</main>


			</div>

		</body>

		</html>