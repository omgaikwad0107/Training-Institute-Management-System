<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>

		<!DOCTYPE html>
		<html>

		<head>

			<meta charset="UTF-8">

			<meta name="viewport" content="width=device-width, initial-scale=1.0">

			<title>Update Student</title>

			<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Admin/editStudent.css">

		</head>

		<body>

			<!-- Admin Sidebar -->
			<jsp:include page="AdminSideBar.jsp"></jsp:include>


			<div class="edit-student-page">

				<!-- Header -->
				<header class="top-header">

					<div>
						<h2>Training Institute</h2>
						<span>Admin Panel</span>
					</div>

					<div class="admin-profile">

						<div class="profile-icon">A</div>

						<div class="profile-info">
							<strong>Administrator</strong> <small>Admin</small>
						</div>

					</div>

				</header>


				<!-- Main Content -->
				<main class="main-content">

					<div class="page-heading">

						<div>
							<h1>Update Student</h1>

							<p>विद्यार्थ्याची माहिती अपडेट करा</p>
						</div>

						<a href="${pageContext.request.contextPath}/admin/students" class="back-btn"> ← Back to Students
						</a>

					</div>


					<!-- Error Message -->

					<c:if test="${not empty error}">

						<div class="error-message">${error}</div>

					</c:if>


					<!-- Update Form -->

					<form action="${pageContext.request.contextPath}/admin/students/update" method="post"
						class="student-form">


						<!-- Student ID -->

						<input type="hidden" name="id" value="${student.id}">

						<!-- User ID -->
						<input type="hidden" name="userId" value="${student.userId}">


						<!-- Personal Information -->

						<section class="form-section">

							<div class="section-heading">

								<h2>Personal Information</h2>

								<p>विद्यार्थ्याची वैयक्तिक माहिती</p>

							</div>


							<div class="form-grid">


								<!-- Student Name -->

								<div class="form-group">

									<label for="studentName"> Student Name <span>*</span>
									</label> <input type="text" id="studentName" name="studentName"
										value="${student.studentName}" placeholder="Enter student name" required>

								</div>


								<!-- Email -->

								<div class="form-group">

									<label for="email"> Email <span>*</span>
									</label> <input type="email" id="email" name="email" value="${student.email}"
										placeholder="Enter email" required>

								</div>


								<!-- Mobile -->

								<div class="form-group">

									<label for="mobile"> Mobile <span>*</span>
									</label> <input type="text" id="mobile" name="mobile" value="${student.mobile}"
										placeholder="Enter mobile number" required>

								</div>


								<!-- Gender -->

								<div class="form-group">

									<label for="gender"> Gender <span>*</span>
									</label> <select id="gender" name="gender" required>

										<option value="">Select Gender</option>

										<option value="MALE" ${student.gender=='MALE' ? 'selected' : '' }>Male</option>

										<option value="FEMALE" ${student.gender=='FEMALE' ? 'selected' : '' }>
											Female</option>

										<option value="OTHER" ${student.gender=='OTHER' ? 'selected' : '' }>Other
										</option>

									</select>

								</div>


								<!-- Date of Birth -->

								<div class="form-group">

									<label for="dob"> Date of Birth </label> <input type="date" id="dob" name="dob"
										value="${student.dob}">

								</div>


								<!-- Address -->

								<div class="form-group full-width">

									<label for="address"> Address </label>

									<textarea id="address" name="address" rows="4"
										placeholder="Enter address">${student.address}</textarea>

								</div>

							</div>

						</section>


						<!-- Course Information -->

						<section class="form-section">

							<div class="section-heading">

								<h2>Course Information</h2>

								<p>विद्यार्थ्याचा Course आणि Batch अपडेट करा</p>

							</div>


							<div class="form-grid">


								<!-- Course -->

								<div class="form-group">

									<label for="course"> Course <span>*</span>
									</label> <select id="course" name="course" required>

										<option value="">Select Course</option>

										<option value="JAVA_FULL_STACK" ${student.course=='JAVA_FULL_STACK' ? 'selected'
											: '' }>
											Java Full Stack</option>

										<option value="PYTHON_FULL_STACK" ${student.course=='PYTHON_FULL_STACK'
											? 'selected' : '' }>
											Python Full Stack</option>

										<option value="C_CPP_PROGRAMMING" ${student.course=='C_CPP_PROGRAMMING'
											? 'selected' : '' }>
											C/C++ Programming</option>

									</select>

								</div>


								<!-- Batch -->

								<div class="form-group">

									<label for="batch"> Batch <span>*</span>
									</label> <select id="batch" name="batch" required>

										<option value="">Select Batch</option>

										<option value="JAVA_MORNING" ${student.batch=='JAVA_MORNING' ? 'selected' : ''
											}>
											Java Morning</option>

										<option value="JAVA_EVENING" ${student.batch=='JAVA_EVENING' ? 'selected' : ''
											}>
											Java Evening</option>

										<option value="PYTHON_MORNING" ${student.batch=='PYTHON_MORNING' ? 'selected'
											: '' }>
											Python Morning</option>

										<option value="PYTHON_EVENING" ${student.batch=='PYTHON_EVENING' ? 'selected'
											: '' }>
											Python Evening</option>

										<option value="CPP_MORNING" ${student.batch=='CPP_MORNING' ? 'selected' : '' }>
											C/C++ Morning</option>

										<option value="CPP_EVENING" ${student.batch=='CPP_EVENING' ? 'selected' : '' }>
											C/C++ Evening</option>

									</select>

								</div>

							</div>

						</section>


						<!-- Login Information -->

						<section class="form-section">

							<div class="section-heading">

								<h2>Login Information</h2>

								<p>विद्यार्थ्याच्या Login ची माहिती अपडेट करा</p>

							</div>


							<div class="form-grid">


								<!-- Username -->

								<div class="form-group">

									<label for="username"> Username <span>*</span>
									</label> <input type="text" id="username" name="username"
										value="${student.username}" placeholder="Enter username" required>

								</div>


								<!-- Password -->

								<div class="form-group">

									<label for="password"> Password <span>*</span>
									</label> <input type="password" id="password" name="password"
										value="${student.password}" placeholder="Enter password" required>

								</div>


								<!-- Status -->

								<div class="form-group">

									<label for="status"> Status <span>*</span>
									</label> <select id="status" name="status" required>

										<option value="ACTIVE" ${student.status=='ACTIVE' ? 'selected' : '' }>
											Active</option>

										<option value="INACTIVE" ${student.status=='INACTIVE' ? 'selected' : '' }>
											Inactive</option>

										<option value="COMPLETED" ${student.status=='COMPLETED' ? 'selected' : '' }>
											Completed</option>

									</select>

								</div>

							</div>

						</section>


						<!-- Buttons -->

						<div class="form-buttons">

							<a href="${pageContext.request.contextPath}/admin/students" class="cancel-btn"> Cancel </a>

							<button type="reset" class="reset-btn">Reset</button>

							<button type="submit" class="update-btn">Update Student</button>

						</div>


					</form>

				</main>

			</div>

		</body>

		</html>