<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
    uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>My Profile</title>

    <link rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/Faculty/MyProfile.css">

</head>

<body>

    <%@ include file="FacultySideBar.jsp" %>


    <main class="main-content">


        <!-- ================= HEADER ================= -->

        <header class="top-header">

            <div class="header-left">

                <h1>My Profile</h1>

                <p>
                    View your faculty profile information
                </p>

            </div>


            <div class="header-right">

                <div class="faculty-profile">

                    <div class="profile-avatar">
                        F
                    </div>

                    <div class="profile-info">

                        <strong>
                            ${faculty.facultyName}
                        </strong>

                        <span>
                            Faculty
                        </span>

                    </div>

                </div>

            </div>

        </header>


        <!-- ================= CONTENT ================= -->

        <section class="page-content">


            <!-- PROFILE HEADER CARD -->

            <div class="profile-card">


                <div class="profile-card-top">


                    <div class="large-avatar">

                        <c:choose>

                            <c:when test="${not empty faculty.facultyName}">
                                ${faculty.facultyName.substring(0,1).toUpperCase()}
                            </c:when>

                            <c:otherwise>
                                F
                            </c:otherwise>

                        </c:choose>

                    </div>


                    <div class="profile-main-info">

                        <h2>
                            ${faculty.facultyName}
                        </h2>

                        <p>
                            ${faculty.specialization}
                        </p>

                        <span class="status-badge ${faculty.status}">
                            ${faculty.status}
                        </span>

                    </div>


                </div>


                <!-- ================= PERSONAL DETAILS ================= -->

                <div class="section-title">

                    <h3>Personal Information</h3>

                    <p>
                        Your registered personal details
                    </p>

                </div>


                <div class="details-grid">


                    <div class="detail-item">

                        <span class="detail-label">
                            Full Name
                        </span>

                        <span class="detail-value">
                            ${faculty.facultyName}
                        </span>

                    </div>


                    <div class="detail-item">

                        <span class="detail-label">
                            Username
                        </span>

                        <span class="detail-value">
                            ${faculty.username}
                        </span>

                    </div>


                    <div class="detail-item">

                        <span class="detail-label">
                            Email
                        </span>

                        <span class="detail-value">
                            ${faculty.email}
                        </span>

                    </div>


                    <div class="detail-item">

                        <span class="detail-label">
                            Mobile
                        </span>

                        <span class="detail-value">
                            ${faculty.mobile}
                        </span>

                    </div>


                    <div class="detail-item">

                        <span class="detail-label">
                            Gender
                        </span>

                        <span class="detail-value">
                            ${faculty.gender}
                        </span>

                    </div>


                    <div class="detail-item">

                        <span class="detail-label">
                            Date of Birth
                        </span>

                        <span class="detail-value">

                            <c:choose>

                                <c:when test="${not empty faculty.dob}">
                                    ${faculty.dob}
                                </c:when>

                                <c:otherwise>
                                    Not Available
                                </c:otherwise>

                            </c:choose>

                        </span>

                    </div>


                    <div class="detail-item">

                        <span class="detail-label">
                            Joining Date
                        </span>

                        <span class="detail-value">

                            <c:choose>

                                <c:when test="${not empty faculty.joiningDate}">
                                    ${faculty.joiningDate}
                                </c:when>

                                <c:otherwise>
                                    Not Available
                                </c:otherwise>

                            </c:choose>

                        </span>

                    </div>


                    <div class="detail-item">

                        <span class="detail-label">
                            Specialization
                        </span>

                        <span class="detail-value">

                            <c:choose>

                                <c:when test="${not empty faculty.specialization}">
                                    ${faculty.specialization}
                                </c:when>

                                <c:otherwise>
                                    Not Available
                                </c:otherwise>

                            </c:choose>

                        </span>

                    </div>


                    <div class="detail-item full-width">

                        <span class="detail-label">
                            Address
                        </span>

                        <span class="detail-value">

                            <c:choose>

                                <c:when test="${not empty faculty.address}">
                                    ${faculty.address}
                                </c:when>

                                <c:otherwise>
                                    Not Available
                                </c:otherwise>

                            </c:choose>

                        </span>

                    </div>


                </div>


                <!-- ================= ACCOUNT INFORMATION ================= -->

                <div class="section-title account-section">

                    <h3>Account Information</h3>

                    <p>
                        Your training institute account details
                    </p>

                </div>


                <div class="account-grid">


                    <div class="account-item">

                        <div class="account-icon">
                            👤
                        </div>

                        <div>

                            <span>
                                Username
                            </span>

                            <strong>
                                ${faculty.username}
                            </strong>

                        </div>

                    </div>


                    <div class="account-item">

                        <div class="account-icon">
                            🎓
                        </div>

                        <div>

                            <span>
                                Role
                            </span>

                            <strong>
                                Faculty
                            </strong>

                        </div>

                    </div>


                    <div class="account-item">

                        <div class="account-icon">
                            ●
                        </div>

                        <div>

                            <span>
                                Account Status
                            </span>

                            <strong>
                                ${faculty.status}
                            </strong>

                        </div>

                    </div>


                </div>


            </div>


        </section>


    </main>

</body>

</html>