<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>

		<!DOCTYPE html>
		<html>

		<head>

			<meta charset="UTF-8">

			<meta name="viewport" content="width=device-width, initial-scale=1.0">

			<title>Training Institute Management System</title>

			<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loginPage.css">

		</head>

		<body>

			<div class="page">


				<!-- ================= HEADER ================= -->

				<header class="header">

					<div class="brand">

						<div class="brand-icon">🎓</div>

						<div class="brand-text">

							<h2>Training Institute</h2>

							<h2>Management System</h2>

							<p>
								Learn <span>|</span> Grow <span>|</span> Build Your Future
							</p>

						</div>

					</div>

				</header>



				<!-- ================= LOGIN AREA ================= -->

				<main class="main-content">


					<div class="login-card">


						<!-- LOGIN ICON -->

						<div class="login-icon">🎓</div>


						<!-- TITLE -->

						<h1>Login to Your Account</h1>

						<p class="subtitle">Select your role and enter your credentials
						</p>



						<!-- ================= FORM ================= -->

						<form action="VerifyUser" method="post">


							<!-- ROLE -->

							<div class="input-group">

								<span class="input-symbol"> 👤 </span> <select name="role" id="role" required>

									<option value="">Select Role</option>

									<option value="ADMIN">Admin</option>

									<option value="STUDENT">Student</option>

									<option value="FACULTY">Faculty</option>

								</select> <span class="arrow"> ▼ </span>

							</div>



							<!-- USERNAME -->

							<div class="input-group">

								<span class="input-symbol"> 👤 </span> <input type="text" name="username"
									placeholder="Username" required>

							</div>



							<!-- PASSWORD -->

							<div class="input-group">

								<span class="input-symbol"> 🔒 </span> <input type="password" name="password"
									id="password" placeholder="Password" required>

								<button type="button" class="eye-button" onclick="showPassword()">

									👁</button>

							</div>



							<!-- OPTIONS -->

							<div class="options">

								<label> <input type="checkbox" name="remember"> <span>
										Remember me </span>

								</label> <a href="${pageContext.request.contextPath}/forgotPassword">
									Forgot Password? </a>

							</div>



							<!-- LOGIN BUTTON -->

							<button type="submit" class="login-button">

								<span>→</span> Login

							</button>


						</form>



						<!-- ================= STUDENT REGISTER ================= -->
						<%-- <div class="register-section">

							<span> New Student? </span> <a
								href="${pageContext.request.contextPath}/studentRegistration">
								Register Now </a>

					</div>


			</div>

			</main> --%>



			<!-- ================= FOOTER ================= -->

			<footer> © 2026 Training Institute Management System </footer>


			</div>



			<script>
				function showPassword() {

					var password = document.getElementById("password");

					if (password.type === "password") {

						password.type = "text";

					} else {

						password.type = "password";

					}

				}
			</script>
		</body>

		</html>