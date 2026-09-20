<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Faculty Dashboard | Training Institute</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/Faculty/FacultyDashboard.css">

</head>

<body>

    <%@ include file="FacultySideBar.jsp"%>


    <!-- =====================================================
         MAIN CONTENT
    ====================================================== -->

    <main class="main-content">


        <!-- TOP HEADER -->

        <header class="top-header">

            <div class="header-left">

                <h3>Faculty Panel</h3>

            </div>


            <div class="header-right">

                <!-- Notification -->

                <div class="notification">

                    🔔

                    <span class="notification-dot"></span>

                </div>


                <!-- Faculty Profile -->

                <div class="faculty-profile">

                    <div class="profile-avatar">

                        <c:choose>

                            <c:when test="${not empty facultyName}">
                                ${facultyName.substring(0,1)}
                            </c:when>

                            <c:otherwise>
                                F
                            </c:otherwise>

                        </c:choose>

                    </div>


                    <div class="profile-info">

                        <strong>
                            ${facultyName}
                        </strong>

                        <span>Faculty</span>

                    </div>

                </div>

            </div>

        </header>



        <!-- =====================================================
             PAGE CONTENT
        ====================================================== -->

        <section class="page-content">


            <!-- WELCOME -->

            <div class="welcome-section">

                <div>

                    <h1>
                        Welcome back, ${facultyName}! 👋
                    </h1>

                    <p>
                        Here's your teaching overview for today.
                    </p>

                </div>


                <div class="date-box">

                    📅

                    <span id="currentDate"></span>

                </div>

            </div>



            <!-- =====================================================
                 STAT CARDS
            ====================================================== -->

            <div class="stats-grid">


                <!-- STUDENTS -->

                <div class="stat-card">

                    <div class="stat-icon students-icon">
                        👥
                    </div>

                    <div class="stat-details">

                        <span class="stat-title">
                            My Students
                        </span>

                        <strong>
                            ${totalStudents}
                        </strong>

                        <small>
                            Students assigned
                        </small>

                    </div>

                </div>



                <!-- BATCHES -->

                <div class="stat-card">

                    <div class="stat-icon batches-icon">
                        🗓️
                    </div>

                    <div class="stat-details">

                        <span class="stat-title">
                            My Batches
                        </span>

                        <strong>
                            ${totalBatches}
                        </strong>

                        <small>
                            Active batches
                        </small>

                    </div>

                </div>



                <!-- ATTENDANCE -->

                <div class="stat-card">

                    <div class="stat-icon attendance-icon">
                        ✅
                    </div>

                    <div class="stat-details">

                        <span class="stat-title">
                            Today's Attendance
                        </span>

                        <strong>
                            ${todayPresent}/${totalStudents}
                        </strong>

                        <small>
                            Students present
                        </small>

                    </div>

                </div>



                <!-- PENDING ASSESSMENTS -->

                <div class="stat-card">

                    <div class="stat-icon assessment-icon">
                        📝
                    </div>

                    <div class="stat-details">

                        <span class="stat-title">
                            Pending Assessments
                        </span>

                        <strong>
                            ${pendingAssessments}
                        </strong>

                        <small>
                            Need evaluation
                        </small>

                    </div>

                </div>

            </div>



            <!-- =====================================================
                 MAIN GRID
            ====================================================== -->

            <div class="dashboard-grid">


                <!-- =================================================
                     MY BATCHES
                ================================================== -->

                <div class="dashboard-card">

                    <div class="card-header">

                        <div>

                            <h2>
                                My Batches
                            </h2>

                            <p>
                                Your assigned batches
                            </p>

                        </div>


                        <a href="${pageContext.request.contextPath}/faculty/batches">

                            View All

                        </a>

                    </div>


                    <div class="batch-list">


                        <c:choose>

                            <c:when test="${not empty batchList}">


                                <c:forEach var="batch"
                                           items="${batchList}">


                                    <div class="batch-item">


                                        <!-- BATCH ICON -->

                                        <div class="batch-icon">

                                            <c:choose>

                                                <c:when test="${batch.courseName.toLowerCase().contains('python')}">
                                                    🐍
                                                </c:when>

                                                <c:when test="${batch.courseName.toLowerCase().contains('java')}">
                                                    ☕
                                                </c:when>

                                                <c:otherwise>
                                                    📚
                                                </c:otherwise>

                                            </c:choose>

                                        </div>



                                        <!-- BATCH DETAILS -->

                                        <div class="batch-details">

                                            <h3>
                                                ${batch.courseName}
                                            </h3>

                                            <p>
                                                ${batch.batchName}
                                            </p>


                                            <div class="batch-meta">

                                                <span>
                                                    👥
                                                    ${batch.studentCount}
                                                    Students
                                                </span>

                                                <span>

                                                    📅

                                                    ${batch.startDate}

                                                </span>

                                            </div>

                                        </div>



                                        <!-- STATUS -->

                                        <span class="active-badge">

                                            ${batch.status}

                                        </span>

                                    </div>


                                </c:forEach>


                            </c:when>


                            <c:otherwise>

                                <div class="empty-message">

                                    No batches assigned.

                                </div>

                            </c:otherwise>

                        </c:choose>


                    </div>

                </div>



                <!-- =================================================
                     TODAY'S CLASSES
                ================================================== -->

                <div class="dashboard-card">

                    <div class="card-header">

                        <div>

                            <h2>
                                Today's Classes
                            </h2>

                            <p>
                                Your scheduled classes
                            </p>

                        </div>


                        <a href="${pageContext.request.contextPath}/faculty/batches">

                            View All

                        </a>

                    </div>


                    <div class="class-list">


                        <!--
                            Class schedule is not stored in the
                            current database schema.
                        -->

                        <div class="class-item">


                            <div class="class-time">

                                <strong>
                                    --
                                </strong>

                                <span>
                                    --
                                </span>

                            </div>


                            <div class="class-details">

                                <h3>
                                    Class schedule
                                </h3>

                                <p>
                                    📚 Schedule not configured
                                </p>

                                <p>
                                    📍 —
                                </p>

                            </div>


                            <span class="today-badge">

                                Today

                            </span>

                        </div>


                    </div>

                </div>

            </div>



            <!-- =====================================================
                 BOTTOM GRID
            ====================================================== -->

            <div class="bottom-grid">


                <!-- =================================================
                     RECENT ASSESSMENTS
                ================================================== -->

                <div class="dashboard-card">


                    <div class="card-header">

                        <div>

                            <h2>
                                Recent Assessments
                            </h2>

                            <p>
                                Recently created assessments
                            </p>

                        </div>


                        <a href="${pageContext.request.contextPath}/faculty/assessments">

                            View All

                        </a>

                    </div>



                    <div class="assessment-list">


                        <c:choose>


                            <c:when test="${not empty assessmentList}">


                                <c:forEach var="assessment"
                                           items="${assessmentList}"
                                           varStatus="status">


                                    <c:if test="${status.index < 5}">


                                        <div class="assessment-item">


                                            <div class="assessment-icon-small">

                                                📝

                                            </div>


                                            <div class="assessment-details">

                                                <h3>

                                                    ${assessment.assessmentName}

                                                </h3>


                                                <span>

                                                    ${assessment.batchName}

                                                    •

                                                    ${assessment.assessmentDate}

                                                </span>

                                            </div>


                                            <c:choose>

                                                <c:when test="${assessment.status eq 'COMPLETED'}">

                                                    <span class="assessment-status">

                                                        Completed

                                                    </span>

                                                </c:when>


                                                <c:otherwise>

                                                    <span class="pending-status">

                                                        ${assessment.status}

                                                    </span>

                                                </c:otherwise>

                                            </c:choose>


                                        </div>


                                    </c:if>


                                </c:forEach>


                            </c:when>


                            <c:otherwise>

                                <div class="empty-message">

                                    No assessments available.

                                </div>

                            </c:otherwise>


                        </c:choose>


                    </div>

                </div>



                <!-- =================================================
                     QUICK ACTIONS
                ================================================== -->

                <div class="dashboard-card">


                    <div class="card-header">

                        <div>

                            <h2>
                                Quick Actions
                            </h2>

                            <p>
                                Frequently used actions
                            </p>

                        </div>

                    </div>



                    <div class="quick-actions">


                        <!-- MARK ATTENDANCE -->

                        <a href="${pageContext.request.contextPath}/faculty/attendance"
                           class="action-card blue">

                            <span class="action-icon">
                                ✅
                            </span>

                            <span>
                                Mark Attendance
                            </span>

                            <span class="arrow">
                                →
                            </span>

                        </a>



                        <!-- ADD ASSESSMENT -->

                        <a href="${pageContext.request.contextPath}/faculty/assessments/add"
                           class="action-card green">

                            <span class="action-icon">
                                📝
                            </span>

                            <span>
                                Add Assessment
                            </span>

                            <span class="arrow">
                                →
                            </span>

                        </a>



                        <!-- VIEW STUDENTS -->

                        <a href="${pageContext.request.contextPath}/faculty/students"
                           class="action-card purple">

                            <span class="action-icon">
                                👥
                            </span>

                            <span>
                                View Students
                            </span>

                            <span class="arrow">
                                →
                            </span>

                        </a>



                        <!-- ENTER RESULTS -->

                        <a href="${pageContext.request.contextPath}/faculty/results"
                           class="action-card orange">

                            <span class="action-icon">
                                📈
                            </span>

                            <span>
                                Enter Results
                            </span>

                            <span class="arrow">
                                →
                            </span>

                        </a>


                    </div>

                </div>

            </div>



            <!-- =====================================================
                 RECENT NOTICES
            ====================================================== -->

            <div class="dashboard-card notices-card">


                <div class="card-header">

                    <div>

                        <h2>
                            Recent Notices
                        </h2>

                        <p>
                            Latest institute announcements
                        </p>

                    </div>

                </div>



                <div class="notice-list">


                    <c:choose>


                        <c:when test="${not empty noticeList}">


                            <c:forEach var="notice"
                                       items="${noticeList}"
                                       varStatus="status">


                                <c:if test="${status.index < 5}">


                                    <div class="notice-item">


                                        <div class="notice-icon-small">

                                            📢

                                        </div>


                                        <div class="notice-details">

                                            <h3>
                                                ${notice.title}
                                            </h3>

                                            <p>
                                                ${notice.message}
                                            </p>

                                            <span>
                                                ${notice.createdAt}
                                            </span>

                                        </div>

                                    </div>


                                </c:if>


                            </c:forEach>


                        </c:when>


                        <c:otherwise>

                            <div class="notice-item">


                                <div class="notice-icon-small">

                                    📢

                                </div>


                                <div class="notice-details">

                                    <h3>
                                        No Recent Notices
                                    </h3>

                                    <p>
                                        There are no new institute announcements.
                                    </p>

                                </div>


                            </div>

                        </c:otherwise>


                    </c:choose>


                </div>

            </div>


        </section>

    </main>



    <!-- =====================================================
         DATE SCRIPT
    ====================================================== -->

    <script>

        function updateDateTime() {

            const now = new Date();

            const dateOptions = {

                weekday: "long",

                day: "numeric",

                month: "long",

                year: "numeric"

            };

            document.getElementById("currentDate").innerText =
                now.toLocaleDateString("en-IN", dateOptions);

        }

        updateDateTime();

    </script>


</body>

</html>