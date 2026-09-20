<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">

			<title>Student List</title>

			<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Admin/studentList.css">
		</head>

		<body>

			<!-- SIDEBAR -->
			<jsp:include page="AdminSideBar.jsp"></jsp:include>

			<!-- MAIN PAGE -->
			<div class="student-list-page">

				<!-- HEADER -->
				<header class="top-header">

					<div class="header-left">
						<h2>Training Institute</h2>
						<span>Admin Panel</span>
					</div>

					<div class="header-right">

						<div class="admin-profile">

							<div class="profile-icon">A</div>

							<div class="profile-info">
								<strong>Administrator</strong> <small>Admin</small>
							</div>

						</div>

					</div>

				</header>


				<!-- MAIN CONTENT -->
				<main class="main-content">

					<!-- PAGE HEADING -->
					<div class="page-heading">

						<div>
							<h1>Student List</h1>
							<p>View and manage all registered students</p>
						</div>

						<a href="${pageContext.request.contextPath}/admin/students/add" class="add-student-btn">
							<span>+</span> Add Student
						</a>

					</div>


					<!-- MESSAGES -->

					<c:if test="${param.success == 'true'}">
						<div class="success-message">✓ Student added successfully!</div>
					</c:if>

					<c:if test="${param.updated == 'true'}">
						<div class="success-message">✓ Student updated successfully!</div>
					</c:if>

					<c:if test="${param.deleted == 'true'}">
						<div class="success-message">✓ Student deleted successfully!</div>
					</c:if>

					<c:if test="${param.error == 'notfound'}">
						<div class="error-message">✕ Student not found!</div>
					</c:if>


					<!-- STUDENT TABLE CARD -->
					<section class="student-table-section">

						<div class="section-header">

							<div>
								<h2>Registered Students</h2>
								<p>List of all students with their course and batch details</p>
							</div>

							<div class="student-count">
								Total: <strong>${students.size()}</strong>
							</div>

						</div>


						<!-- TABLE -->
						<div class="table-container">

							<c:choose>

								<c:when test="${not empty students}">

									<table class="student-table">

										<thead>

											<tr>
												<th>ID</th>
												<th>Student Name</th>
												<th>Email</th>
												<th>Mobile</th>
												<th>Gender</th>
												<th>Course</th>
												<th>Batch</th>
												<th>Status</th>
												<th>Actions</th>
											</tr>

										</thead>


										<tbody>

											<c:forEach var="student" items="${students}">

												<tr>

													<td>${student.id}</td>


													<td>

														<div class="student-name">

															<div class="student-avatar">
																${student.studentName.substring(0,1).toUpperCase()}
															</div>

															<div>
																<strong> ${student.studentName} </strong> <small>
																	@${student.username} </small>
															</div>

														</div>

													</td>


													<td>${student.email}</td>


													<td>${student.mobile}</td>


													<td>${student.gender}</td>


													<td>
														<c:choose>

															<c:when test="${student.course == 'JAVA_FULL_STACK'}">
																Java Full Stack
															</c:when>

															<c:when test="${student.course == 'PYTHON_FULL_STACK'}">
																Python Full Stack
															</c:when>

															<c:when test="${student.course == 'C_CPP_PROGRAMMING'}">
																C/C++ Programming
															</c:when>

															<c:otherwise>
																${student.course}
															</c:otherwise>

														</c:choose>
													</td>


													<td>
														<c:choose>

															<c:when test="${student.batch == 'JAVA_MORNING'}">
																Java Morning
															</c:when>

															<c:when test="${student.batch == 'JAVA_EVENING'}">
																Java Evening
															</c:when>

															<c:when test="${student.batch == 'PYTHON_MORNING'}">
																Python Morning
															</c:when>

															<c:when test="${student.batch == 'PYTHON_EVENING'}">
																Python Evening
															</c:when>

															<c:when test="${student.batch == 'CPP_MORNING'}">
																C/C++ Morning
															</c:when>

															<c:when test="${student.batch == 'CPP_EVENING'}">
																C/C++ Evening
															</c:when>

															<c:otherwise>
																${student.batch}
															</c:otherwise>

														</c:choose>
													</td>


													<td>
														<c:choose>

															<c:when test="${student.status == 'ACTIVE'}">
																<span class="status-badge active"> Active </span>
															</c:when>

															<c:when test="${student.status == 'INACTIVE'}">
																<span class="status-badge inactive"> Inactive </span>
															</c:when>

															<c:when test="${student.status == 'COMPLETED'}">
																<span class="status-badge completed"> Completed </span>
															</c:when>

															<c:otherwise>
																<span class="status-badge"> ${student.status} </span>
															</c:otherwise>

														</c:choose>
													</td>


													<td>

														<div class="action-buttons">

															<a href="${pageContext.request.contextPath}/admin/students/edit/${student.id}"
																class="edit-btn"> Edit </a> <a
																href="${pageContext.request.contextPath}/admin/students/delete/${student.id}"
																class="delete-btn"
																onclick="return confirm('Are you sure you want to delete this student?');">
																Delete </a>

														</div>

													</td>

												</tr>

											</c:forEach>

										</tbody>

									</table>

								</c:when>


								<c:otherwise>

									<div class="empty-state">

										<div class="empty-icon">👥</div>

										<h2>No Students Found</h2>

										<p>There are no students registered yet.</p>

										<a href="${pageContext.request.contextPath}/admin/students/add"
											class="empty-add-btn"> + Add First Student </a>

									</div>

								</c:otherwise>

							</c:choose>

						</div>

					</section>


					<!-- BOTTOM ACTIONS -->
					<div class="bottom-actions">

						<a href="${pageContext.request.contextPath}/admin/students/add" class="secondary-btn"> + Add New
							Student </a> <a href="${pageContext.request.contextPath}/admin/students"
							class="secondary-btn"> ↻ Refresh List </a>

					</div>

				</main>

			</div>

		</body>

		</html>