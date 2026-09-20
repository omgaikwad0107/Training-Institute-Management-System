<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
    uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Enter Results</title>

    <link rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/Faculty/EnterResults.css">

</head>

<body>


    <%@ include file="FacultySideBar.jsp" %>


    <main class="main-content">


        <!-- HEADER -->

        <header class="top-header">

            <div class="header-left">

                <h1>Enter Results</h1>

                <p>
                    Enter marks for students
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



        <section class="page-content">


            <!-- BACK BUTTON -->

            <div class="back-section">

                <a
                    href="${pageContext.request.contextPath}/faculty/results"
                    class="back-btn">

                    ← Back to Results

                </a>

            </div>



            <!-- ASSESSMENT INFORMATION -->

            <c:if test="${not empty assessment}">

                <div class="assessment-info-card">


                    <div class="assessment-info-icon">
                        📝
                    </div>


                    <div class="assessment-info-content">

                        <h2>
                            ${assessment.assessmentName}
                        </h2>

                        <div class="assessment-meta">

                            <span>
                                <strong>Course:</strong>
                                ${assessment.courseName}
                            </span>

                            <span>
                                <strong>Batch:</strong>
                                ${assessment.batchName}
                            </span>

                            <span>
                                <strong>Date:</strong>
                                ${assessment.assessmentDate}
                            </span>

                            <span>
                                <strong>Total Marks:</strong>
                                ${assessment.totalMarks}
                            </span>

                        </div>

                    </div>


                </div>

            </c:if>



            <!-- MESSAGES -->

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



            <!-- STUDENTS -->

            <div class="students-card">


                <div class="students-card-header">

                    <div>

                        <h2>
                            Student Results
                        </h2>

                        <p>
                            Enter marks and result status for each student
                        </p>

                    </div>


                    <div class="student-count">

                        <span>
                            ${studentList.size()}
                        </span>

                        Students

                    </div>

                </div>



                <c:choose>


                    <c:when test="${not empty studentList}">


                        <div class="table-wrapper">

                            <table>

                                <thead>

                                    <tr>

                                        <th>#</th>

                                        <th>Student</th>

                                        <th>Marks</th>

                                        <th>Status</th>

                                        <th>Remarks</th>

                                        <th>Action</th>

                                    </tr>

                                </thead>


                                <tbody>


                                    <c:forEach
                                        var="student"
                                        items="${studentList}"
                                        varStatus="status">


                                        <tr>


                                            <!-- NUMBER -->

                                            <td class="serial-number">
                                                ${status.count}
                                            </td>



                                            <!-- STUDENT -->

                                            <td>

                                                <div class="student-info">

                                                    <div class="student-avatar">
                                                        ${student.studentName.substring(0,1)}
                                                    </div>

                                                    <div>

                                                        <strong>
                                                            ${student.studentName}
                                                        </strong>

                                                        <span>
                                                            ${student.batchName}
                                                        </span>

                                                    </div>

                                                </div>

                                            </td>



                                            <!-- MARKS -->

                                            <td>

                                                <form
                                                    action="${pageContext.request.contextPath}/faculty/results/save"
                                                    method="post"
                                                    class="result-form"
                                                    onsubmit="return validateMarks(this);">


                                                    <input
                                                        type="hidden"
                                                        name="studentId"
                                                        value="${student.studentId}">

                                                    <input
                                                        type="hidden"
                                                        name="assessmentId"
                                                        value="${student.assessmentId}">


                                                    <div class="marks-input">

                                                        <input
                                                            type="number"
                                                            name="marksObtained"
                                                            value="${student.marksObtained}"
                                                            min="0"
                                                            max="${student.totalMarks}"
                                                            required>

                                                        <span>
                                                            / ${student.totalMarks}
                                                        </span>

                                                    </div>

                                            </td>



                                            <!-- STATUS -->

                                            <td>

                                                <select
                                                    name="resultStatus"
                                                    class="status-select"
                                                    required>

                                                    <option
                                                        value="PASS"
                                                        ${student.resultStatus == 'PASS' ? 'selected' : ''}>
                                                        PASS
                                                    </option>

                                                    <option
                                                        value="FAIL"
                                                        ${student.resultStatus == 'FAIL' ? 'selected' : ''}>
                                                        FAIL
                                                    </option>

                                                </select>

                                            </td>



                                            <!-- REMARKS -->

                                            <td>

                                                <input
                                                    type="text"
                                                    name="remarks"
                                                    class="remarks-input"
                                                    value="${student.remarks}"
                                                    placeholder="Optional">

                                            </td>



                                            <!-- ACTION -->

                                            <td>

                                                <button
                                                    type="submit"
                                                    class="save-btn">

                                                    Save

                                                </button>

                                                </form>

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
                                👥
                            </div>

                            <h3>
                                No Students Found
                            </h3>

                            <p>
                                There are no active students enrolled
                                in this assessment's batch.
                            </p>

                        </div>


                    </c:otherwise>


                </c:choose>


            </div>


        </section>


    </main>


    <script>

        function validateMarks(form) {

            const marksInput =
                form.querySelector(
                    'input[name="marksObtained"]'
                );

            const marks =
                parseInt(marksInput.value);

            const maxMarks =
                parseInt(marksInput.getAttribute("max"));


            if (marks < 0 || marks > maxMarks) {

                alert(
                    "Marks must be between 0 and "
                    + maxMarks
                );

                return false;
            }


            return true;
        }

    </script>


</body>

</html>