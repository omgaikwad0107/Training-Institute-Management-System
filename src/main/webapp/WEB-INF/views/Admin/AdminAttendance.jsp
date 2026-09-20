<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Attendance Management | Training Institute</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/Admin/AdminAttendance.css">
</head>

<body>

<jsp:include page="AdminSideBar.jsp" />

<main class="main-content">

    <!-- Header -->
    <div class="page-header">

        <div>
            <h1>Attendance Management</h1>
            <p>View and monitor student attendance records</p>
        </div>

    </div>


    <!-- Summary Cards -->
    <div class="summary-grid">

        <div class="summary-card">
            <div class="summary-icon blue">📋</div>

            <div>
                <span>Total Records</span>
                <h2>${totalRecords}</h2>
                <small>Attendance records</small>
            </div>
        </div>


        <div class="summary-card">
            <div class="summary-icon green">✅</div>

            <div>
                <span>Present</span>
                <h2>${totalPresent}</h2>
                <small>Students present</small>
            </div>
        </div>


        <div class="summary-card">
            <div class="summary-icon red">❌</div>

            <div>
                <span>Absent</span>
                <h2>${totalAbsent}</h2>
                <small>Students absent</small>
            </div>
        </div>


        <div class="summary-card">
            <div class="summary-icon purple">📊</div>

            <div>
                <span>Attendance</span>
                <h2>
                    <fmt:formatNumber
                            value="${attendancePercentage}"
                            maxFractionDigits="1" />%
                </h2>
                <small>Overall attendance</small>
            </div>
        </div>

    </div>


    <!-- Filters -->
    <div class="filter-card">

        <div class="filter-header">
            <div>
                <h2>Attendance Records</h2>
                <p>Filter attendance records</p>
            </div>
        </div>


        <form method="get"
              action="${pageContext.request.contextPath}/admin/attendance"
              class="filter-form">

            <div class="form-group">

                <label for="date">Attendance Date</label>

                <input type="date"
                       id="date"
                       name="date"
                       value="${selectedDate}">

            </div>


            <div class="form-group">

                <label for="status">Status</label>

                <select id="status"
                        name="status">

                    <option value="">All Status</option>

                    <option value="PRESENT"
                        ${selectedStatus == 'PRESENT' ? 'selected' : ''}>
                        Present
                    </option>

                    <option value="ABSENT"
                        ${selectedStatus == 'ABSENT' ? 'selected' : ''}>
                        Absent
                    </option>

                </select>

            </div>


            <div class="filter-actions">

                <button type="submit"
                        class="filter-btn">
                    🔍 Filter
                </button>

                <a href="${pageContext.request.contextPath}/admin/attendance"
                   class="clear-btn">
                    Clear
                </a>

            </div>

        </form>

    </div>


    <!-- Attendance Table -->
    <div class="table-card">

        <div class="table-header">

            <div>
                <h2>Attendance History</h2>

                <p>
                    Showing
                    <strong>${attendanceList.size()}</strong>
                    records
                </p>
            </div>

        </div>


        <div class="table-wrapper">

            <table>

                <thead>
                <tr>
                    <th>#</th>
                    <th>Student</th>
                    <th>Course</th>
                    <th>Batch</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Remarks</th>
                </tr>
                </thead>


                <tbody>

                <c:choose>

                    <c:when test="${not empty attendanceList}">

                        <c:forEach var="attendance"
                                   items="${attendanceList}"
                                   varStatus="loop">

                            <tr>

                                <td>
                                    ${loop.index + 1}
                                </td>


                                <td>
                                    <div class="student-cell">

                                        <div class="student-avatar">
                                            ${attendance.studentName.substring(0,1).toUpperCase()}
                                        </div>

                                        <div>
                                            <strong>
                                                ${attendance.studentName}
                                            </strong>
                                        </div>

                                    </div>
                                </td>


                                <td>
                                    <span class="course-text">
                                        ${attendance.courseName}
                                    </span>
                                </td>


                                <td>
                                    <span class="batch-badge">
                                        ${attendance.batchName}
                                    </span>
                                </td>


                                <td>
                                    ${attendance.attendanceDate}
                                </td>


                                <td>

                                    <c:choose>

                                        <c:when test="${attendance.status == 'PRESENT'}">

                                            <span class="status-badge present">
                                                ✓ Present
                                            </span>

                                        </c:when>

                                        <c:otherwise>

                                            <span class="status-badge absent">
                                                ✕ Absent
                                            </span>

                                        </c:otherwise>

                                    </c:choose>

                                </td>


                                <td>

                                    <c:choose>

                                        <c:when test="${not empty attendance.remarks}">
                                            ${attendance.remarks}
                                        </c:when>

                                        <c:otherwise>
                                            <span class="no-remarks">—</span>
                                        </c:otherwise>

                                    </c:choose>

                                </td>

                            </tr>

                        </c:forEach>

                    </c:when>


                    <c:otherwise>

                        <tr>

                            <td colspan="7">

                                <div class="empty-state">

                                    <div class="empty-icon">
                                        🗓️
                                    </div>

                                    <h3>No attendance records found</h3>

                                    <p>
                                        There are no attendance records
                                        matching your filter.
                                    </p>

                                </div>

                            </td>

                        </tr>

                    </c:otherwise>

                </c:choose>

                </tbody>

            </table>

        </div>

    </div>

</main>

</body>
</html>