<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Add Assessment</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Faculty/AddAssessment.css">

</head>

<body>

	<%@ include file="FacultySideBar.jsp"%>


	<main class="main-content">

		<!-- HEADER -->

		<header class="top-header">

			<div class="header-left">

				<h1>Add Assessment</h1>

				<p>Create a new assessment for your batch</p>

			</div>


			<div class="header-right">

				<div class="faculty-profile">

					<div class="profile-avatar">F</div>

					<div class="profile-info">

						<strong>Faculty</strong> <span> Faculty Panel </span>

					</div>

				</div>

			</div>

		</header>


		<!-- CONTENT -->

		<section class="page-content">


			<div class="form-container">

				<div class="form-header">

					<div class="form-icon">📝</div>

					<div>

						<h2>Assessment Details</h2>

						<p>Enter the details of the new assessment</p>

					</div>

				</div>


				<c:if test="${empty batchList}">

					<div class="warning-message">

						<strong>No active batches available.</strong> <span> You
							cannot create an assessment until a batch is assigned to you. </span>

					</div>

				</c:if>


				<form
					action="${pageContext.request.contextPath}/faculty/assessments/save"
					method="post" class="assessment-form">


					<!-- BATCH -->

					<div class="form-group">

						<label for="batchName"> Batch <span>*</span>
						</label> <select id="batchName" name="batchName"
							required
                            ${emptybatchList ? 'disabled' : ''}>

							<option value="">Select Batch</option>

							<c:forEach var="batch" items="${batchList}">

								<option value="${batch}">${batch}</option>

							</c:forEach>

						</select>

					</div>


					<!-- COURSE -->

					<div class="form-group">

						<label for="courseName"> Course <span>*</span>
						</label> <input type="text" id="courseName" name="courseName"
							placeholder="Enter course name"
							required
                            ${emptybatchList ? 'disabled' : ''}>

						<small> Example: Java Full Stack </small>

					</div>


					<!-- ASSESSMENT NAME -->

					<div class="form-group">

						<label for="assessmentName"> Assessment Name <span>*</span>
						</label> <input type="text" id="assessmentName" name="assessmentName"
							placeholder="Enter assessment name" maxlength="150"
							required
                            ${emptybatchList ? 'disabled' : ''}>

						<small> Example: Java OOP Test </small>

					</div>


					<!-- DATE + MARKS -->

					<div class="form-row">


						<div class="form-group">

							<label for="assessmentDate"> Assessment Date <span>*</span>
							</label> <input type="date" id="assessmentDate" name="assessmentDate"
								required
                                ${emptybatchList ? 'disabled' : ''}>

						</div>


						<div class="form-group">

							<label for="totalMarks"> Total Marks <span>*</span>
							</label> <input type="number" id="totalMarks" name="totalMarks" min="1"
								placeholder="Enter total marks"
								required
                                ${emptybatchList ? 'disabled' : ''}>

						</div>

					</div>


					<!-- ACTIONS -->

					<div class="form-actions">

						<a href="${pageContext.request.contextPath}/faculty/assessments"
							class="cancel-btn"> Cancel </a>


						<button type="submit" class="save-btn"
							${empty batchList ? 'disabled' : ''}>Save Assessment</button>

					</div>


				</form>

			</div>

		</section>

	</main>

</body>

</html>