<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
    uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Student Results</title>

    <link rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/Faculty/FacultyResults.css">

</head>

<body>

    <%@ include file="FacultySideBar.jsp" %>


    <main class="main-content">


        <!-- HEADER -->

        <header class="top-header">

            <div class="header-left">

                <h1>Student Results</h1>

                <p>
                    Manage and enter student assessment results
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


            <!-- TITLE -->

            <div class="page-title">

                <div>

                    <h2>My Assessments</h2>

                    <p>
                        Select an assessment to enter student results
                    </p>

                </div>


                <div class="result-count">

                    <span class="count-number">
                        ${totalAssessments}
                    </span>

                    <span class="count-label">
                        Total Assessments
                    </span>

                </div>

            </div>



            <!-- SUCCESS MESSAGE -->

            <c:if test="${not empty successMessage}">

                <div class="success-message">

                    <span class="message-icon">
                        ✓
                    </span>

                    <span>
                        ${successMessage}
                    </span>

                </div>

            </c:if>



            <!-- ERROR MESSAGE -->

            <c:if test="${not empty errorMessage}">

                <div class="error-message">

                    <span class="message-icon">
                        !
                    </span>

                    <span>
                        ${errorMessage}
                    </span>

                </div>

            </c:if>



            <!-- ASSESSMENT GRID -->

            <div class="assessment-grid">


                <c:choose>


                    <c:when test="${not empty assessmentList}">


                        <c:forEach
                            var="assessment"
                            items="${assessmentList}">


                            <div class="assessment-card">


                                <!-- CARD HEADER -->

                                <div class="card-header">

                                    <div class="assessment-icon">
                                        📝
                                    </div>

                                    <span class="assessment-status">
                                        Assessment
                                    </span>

                                </div>



                                <!-- CARD DETAILS -->

                                <div class="card-body">


                                    <h3>
                                        ${assessment.assessmentName}
                                    </h3>


                                    <p class="course-name">
                                        ${assessment.courseName}
                                    </p>



                                    <div class="detail-list">


                                        <div class="detail-row">

                                            <span class="detail-label">
                                                Batch
                                            </span>

                                            <span class="detail-value">
                                                ${assessment.batchName}
                                            </span>

                                        </div>



                                        <div class="detail-row">

                                            <span class="detail-label">
                                                Date
                                            </span>

                                            <span class="detail-value">
                                                ${assessment.assessmentDate}
                                            </span>

                                        </div>



                                        <div class="detail-row">

                                            <span class="detail-label">
                                                Total Marks
                                            </span>

                                            <span class="detail-value marks">
                                                ${assessment.totalMarks}
                                            </span>

                                        </div>


                                    </div>


                                </div>



                                <!-- CARD FOOTER -->

                                <div class="card-footer">

                                    <a
                                        href="${pageContext.request.contextPath}/faculty/results/enter?assessmentId=${assessment.assessmentId}"
                                        class="enter-result-btn">

                                        Enter Results
                                        <span>→</span>

                                    </a>

                                </div>


                            </div>


                        </c:forEach>


                    </c:when>



                    <c:otherwise>


                        <div class="empty-state">

                            <div class="empty-icon">
                                📊
                            </div>

                            <h3>
                                No Assessments Found
                            </h3>

                            <p>
                                You don't have any assessments available
                                for entering student results.
                            </p>

                            <a
                                href="${pageContext.request.contextPath}/faculty/assessments/add"
                                class="create-assessment-btn">

                                Create Assessment

                            </a>

                        </div>


                    </c:otherwise>


                </c:choose>


            </div>


        </section>


    </main>


</body>

</html>