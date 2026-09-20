<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Faculty/FacultySideBar.css">
</head>
<body>
<aside class="sidebar">

    <!-- Logo -->
    <div class="sidebar-logo">

        <div class="logo-icon">T</div>

        <div class="logo-text">
            <h2>Training Institute</h2>
            <span>Management System</span>
        </div>

    </div>


    <!-- Navigation -->
    <nav class="sidebar-menu">

        <a href="${pageContext.request.contextPath}/faculty/dashboard"
           class="active">
            <span class="menu-icon">📊</span>
            <span>Dashboard</span>
        </a>


        <a href="${pageContext.request.contextPath}/faculty/students">
            <span class="menu-icon">👥</span>
            <span>My Students</span>
        </a>


        <a href="${pageContext.request.contextPath}/faculty/batches">
            <span class="menu-icon">🗓️</span>
            <span>My Batches</span>
        </a>


        <a href="${pageContext.request.contextPath}/faculty/attendance">
            <span class="menu-icon">✅</span>
            <span>Attendance</span>
        </a>


        <a href="${pageContext.request.contextPath}/faculty/assessments">
            <span class="menu-icon">📝</span>
            <span>Assessments</span>
        </a>


        <a href="${pageContext.request.contextPath}/faculty/results">
            <span class="menu-icon">📈</span>
            <span>Student Results</span>
        </a>


       <%-- <a href="${pageContext.request.contextPath}/faculty/notices">
            <span class="menu-icon">🔔</span>
            <span>Notices</span>
        </a> --%>


        <a href="${pageContext.request.contextPath}/faculty/profile">
            <span class="menu-icon">👤</span>
            <span>My Profile</span>
        </a>

    </nav>


    <!-- Logout -->
    <div class="sidebar-bottom">

        <a href="${pageContext.request.contextPath}/logout"
           class="logout-link">

            <span class="menu-icon">🚪</span>
            <span>Logout</span>

        </a>

    </div>

</aside>
</body>
</html>