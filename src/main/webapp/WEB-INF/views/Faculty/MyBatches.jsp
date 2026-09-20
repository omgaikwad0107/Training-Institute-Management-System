<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>My Batches</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Faculty/MyBatches.css">

</head>

<body>

	<%@ include file="FacultySideBar.jsp"%>


	<main class="main-content">

		<!-- ================= HEADER ================= -->

		<header class="top-header">

			<div class="header-left">

				<h1>My Batches</h1>

				<p>View and manage your assigned batches</p>

			</div>


			<div class="header-right">

				<div class="faculty-profile">

					<div class="profile-avatar">F</div>

					<div class="profile-info">

						<strong>Faculty</strong> <span>Faculty Panel</span>

					</div>

				</div>

			</div>

		</header>


		<!-- ================= PAGE CONTENT ================= -->

		<section class="page-content">


			<!-- ================= PAGE TITLE ================= -->

			<div class="page-title">

				<div>

					<h2>Assigned Batches</h2>

					<p>Batches assigned to you</p>

				</div>


				<div class="batch-count">

					<span class="count-number"> ${totalBatches} </span> <span
						class="count-label"> Total Batches </span>

				</div>

			</div>


			<!-- ================= BATCH LIST ================= -->

			<div class="batch-grid">

				<c:choose>

					<c:when test="${not empty batchList}">

						<c:forEach var="batch" items="${batchList}">

							<div class="batch-card">


								<!-- Batch Header -->

								<div class="batch-card-header">

									<div class="batch-icon">🗓️</div>

									<span class="status-badge ${batch.status}">
										${batch.status} </span>

								</div>


								<!-- Batch Details -->

								<div class="batch-details">

									<h3>${batch.batchName}</h3>

									<p class="course-name">${batch.courseName}</p>


									<div class="detail-row">

										<span class="detail-label"> Start Date </span> <span
											class="detail-value"> ${batch.startDate} </span>

									</div>


									<div class="detail-row">

										<span class="detail-label"> End Date </span> <span
											class="detail-value"> ${batch.endDate} </span>

									</div>


									<div class="detail-row">

										<span class="detail-label"> Status </span> <span
											class="detail-value"> ${batch.status} </span>

									</div>

								</div>


								<!-- Card Footer -->

								<div class="batch-card-footer">

									<a href="${pageContext.request.contextPath}/faculty/students"
										class="view-students-btn"> View Students → </a>

								</div>


							</div>

						</c:forEach>

					</c:when>


					<c:otherwise>

						<div class="empty-state">

							<div class="empty-icon">🗓️</div>

							<h3>No Batches Assigned</h3>

							<p>You currently don't have any batches assigned to you.</p>

						</div>

					</c:otherwise>

				</c:choose>

			</div>

		</section>

	</main>

</body>
</html>