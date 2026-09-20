<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
    uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>My Assessments</title>

    <link rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/Faculty/FacultyAssessments.css">

</head>

<body>

    <%@ include file="FacultySideBar.jsp" %>


    <main class="main-content">

        <!-- HEADER -->

        <header class="top-header">

            <div class="header-left">

                <h1>Assessments</h1>

                <p>
                    Create and manage assessments for your batches
                </p>

            </div>


            <div class="header-right">

                <div class="faculty-profile">

                    <div class="profile-avatar">
                        F
                    </div>

                    <div class="profile-info">

                        <strong>Faculty</strong>

                        <span>
                            Faculty Panel
                        </span>

                    </div>

                </div>

            </div>

        </header>


        <!-- PAGE CONTENT -->

        <section class="page-content">


            <div class="page-title">

                <div>

                    <h2>My Assessments</h2>

                    <p>
                        Assessments created for your assigned batches
                    </p>

                </div>


                <div class="title-actions">

                    <div class="assessment-count">

                        <span class="count-number">
                            ${totalAssessments}
                        </span>

                        <span class="count-label">
                            Total
                        </span>

                    </div>


                    <a href="${pageContext.request.contextPath}/faculty/assessments/add"
                       class="add-btn">

                        + Add Assessment

                    </a>

                </div>

            </div>


            <!-- SUCCESS MESSAGE -->

            <c:if test="${not empty successMessage}">

                <div class="success-message">
                    ${successMessage}
                </div>

            </c:if>


            <!-- ERROR MESSAGE -->

            <c:if test="${not empty errorMessage}">

                <div class="error-message">
                    ${errorMessage}
                </div>

            </c:if>


            <!-- ASSESSMENT LIST -->

            <div class="assessment-card">

                <c:choose>

                    <c:when test="${not empty assessmentList}">

                        <div class="table-wrapper">

                            <table class="assessment-table">

                                <thead>

                                    <tr>

                                        <th>#</th>

                                        <th>Assessment</th>

                                        <th>Course</th>

                                        <th>Batch</th>

                                        <th>Date</th>

                                        <th>Total Marks</th>

                                        <th>Status</th>

                                        <th>Action</th>

                                    </tr>

                                </thead>


                                <tbody>

                                    <c:forEach
                                        var="assessment"
                                        items="${assessmentList}"
                                        varStatus="status">

                                        <tr>

                                            <td>
                                                ${status.index + 1}
                                            </td>


                                            <td>

                                                <div class="assessment-name">

                                                    <div class="assessment-icon">
                                                        📝
                                                    </div>

                                                    <span>
                                                        ${assessment.assessmentName}
                                                    </span>

                                                </div>

                                            </td>


                                            <td>
                                                ${assessment.courseName}
                                            </td>


                                            <td>

                                                <span class="batch-badge">
                                                    ${assessment.batchName}
                                                </span>

                                            </td>


                                            <td>
                                                ${assessment.assessmentDate}
                                            </td>


                                            <td>

                                                <strong>
                                                    ${assessment.totalMarks}
                                                </strong>

                                            </td>


                                            <td>

                                                <span class="status-badge ${assessment.status}">
                                                    ${assessment.status}
                                                </span>

                                            </td>


                                            <td>

                                                <a href="${pageContext.request.contextPath}/faculty/assessments/delete?id=${assessment.id}"
                                                   class="delete-btn"
                                                   onclick="return confirm('Are you sure you want to delete this assessment?');">

                                                    Delete

                                                </a>

                                            </td>

                                        </tr>

                                    </c:forEach>

                                </tbody>

                            </table>

                        </div>

                    </c:when>


                    <c:otherwise>

                        <div class="empty-state">

                            <div class="empty-icon">
                                📝
                            </div>

                            <h3>
                                No Assessments Found
                            </h3>

                            <p>
                                You haven't created any assessments yet.
                            </p>


                            <a href="${pageContext.request.contextPath}/faculty/assessments/add"
                               class="empty-add-btn">

                                + Create Assessment

                            </a>

                        </div>

                    </c:otherwise>

                </c:choose>

            </div>

        </section>

    </main>

</body>

</html>