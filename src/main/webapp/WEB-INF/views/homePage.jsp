<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%@ taglib prefix="c" uri="jakarta.tags.core" %>

		<!DOCTYPE html>
		<html lang="en">

		<head>

			<meta charset="UTF-8">

			<meta name="viewport" content="width=device-width, initial-scale=1.0">

			<title>TechTrain - Training Institute</title>


			<!-- ================= GOOGLE FONT ================= -->

			<link rel="preconnect" href="https://fonts.googleapis.com">

			<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

			<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap"
				rel="stylesheet">


			<!-- ================= FONT AWESOME ================= -->

			<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">


			<!-- ================= MAIN CSS ================= -->

			<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/homePage.css">

		</head>


		<body>


			<!-- =====================================================
     NAVBAR
     ===================================================== -->

			<header class="navbar">

				<div class="container nav-container">


					<!-- LOGO -->

					<div class="logo">

						<div class="logo-icon">

							<i class="fa-solid fa-graduation-cap"></i>

						</div>


						<div class="logo-text">

							<h2>TechTrain</h2>

							<span>Training Institute</span>

						</div>

					</div>


					<!-- NAVIGATION -->

					<nav>

						<a href="${pageContext.request.contextPath}/" class="active">

							Home </a> <a href="#about"> About </a> <a href="#courses"> Courses

						</a> <a href="#contact"> Contact </a> <a href="${pageContext.request.contextPath}/loginPage"
							class="login-btn"> <i class="fa-solid fa-user"></i> Login

						</a>

					</nav>

				</div>

			</header>



			<!-- =====================================================
     HERO SECTION
     ===================================================== -->

			<section class="hero">


				<!-- Hero overlay -->

				<div class="hero-overlay"></div>


				<div class="container hero-container">


					<!-- LEFT CONTENT -->

					<div class="hero-content">


						<div class="hero-small-text">

							LEARN <span>|</span> PRACTICE <span>|</span> GROW

						</div>


						<h1>

							Empower Your Skills. <span> Build Your Future. </span>

						</h1>


						<p>Learn industry-ready technologies through practical training,
							expert guidance and real-world projects.</p>


					<%-- --%>	<div class="hero-buttons">


							<a href="#courses" class="primary-btn"> Explore Courses <i
									class="fa-solid fa-arrow-right"></i>

							</a> 
							<%--<a href="${pageContext.request.contextPath}/loginPage" class="secondary-btn"> <i
									class="fa-solid fa-user"></i>

								Student Login

							</a>
							 --%>

						</div>

					</div>



					<!-- RIGHT GLASS CARD -->

					<div class="hero-image">


						<div class="student-card">


							<i class="fa-solid fa-laptop-code"></i>


							<h3>Learn. Build. Grow.</h3>


							<p>Industry-focused training</p>


						</div>

					</div>


				</div>

			</section>



			<!-- =====================================================
     WHY CHOOSE US
     ===================================================== -->

			<section class="why-section">


				<div class="container">


					<div class="section-title">

						<h2>Why Choose Us?</h2>

						<div class="title-line"></div>

					</div>



					<div class="features-grid">


						<!-- FEATURE 1 -->

						<div class="feature-card">

							<div class="feature-icon blue">

								<i class="fa-solid fa-graduation-cap"></i>

							</div>


							<h3>Expert Training</h3>


							<p>Learn from industry experts with real-world experience.</p>

						</div>



						<!-- FEATURE 2 -->

						<div class="feature-card">

							<div class="feature-icon purple">

								<i class="fa-solid fa-users"></i>

							</div>


							<h3>Experienced Faculty</h3>


							<p>Get mentored by qualified and skilled professionals.</p>

						</div>



						<!-- FEATURE 3 -->

						<div class="feature-card">

							<div class="feature-icon green">

								<i class="fa-solid fa-laptop"></i>

							</div>


							<h3>Practical Learning</h3>


							<p>Work on real projects and hands-on assignments.</p>

						</div>



						<!-- FEATURE 4 -->

						<div class="feature-card">

							<div class="feature-icon orange">

								<i class="fa-solid fa-chart-line"></i>

							</div>


							<h3>Career Growth</h3>


							<p>Build your skills and unlock better career opportunities.</p>

						</div>


					</div>

				</div>

			</section>



			<!-- =====================================================
     COURSES
     ===================================================== -->

			<section class="courses-section" id="courses">


				<div class="container">


					<div class="section-title">

						<h2>Popular Courses</h2>

						<div class="title-line"></div>

					</div>



					<div class="courses-grid">


						<!-- =================================================
                 JAVA COURSE
                 ================================================= -->

						<div class="course-card">


							<div class="course-header">


								<img src="${pageContext.request.contextPath}/resources/images/java.jpg"
									alt="Java Full Stack Course">


								<div class="course-overlay">


									<h3>Java</h3>


									<strong> Full Stack </strong>


								</div>

							</div>



							<div class="course-body">


								<h3>Java Full Stack</h3>


								<p>Java &nbsp; | &nbsp; Spring MVC &nbsp; | &nbsp; MySQL
									&nbsp; | &nbsp; React</p>


								<a href="#" class="course-btn"> View Details <i class="fa-solid fa-arrow-right"></i>

								</a>

							</div>


						</div>



						<!-- =================================================
                 PYTHON COURSE
                 ================================================= -->

						<div class="course-card">


							<div class="course-header">


								<img src="${pageContext.request.contextPath}/resources/images/python.jpg"
									alt="Python Full Stack Course">


								<div class="course-overlay">


									<h3>Python</h3>


									<strong> Full Stack </strong>


								</div>

							</div>



							<div class="course-body">


								<h3>Python Full Stack</h3>


								<p>Python &nbsp; | &nbsp; Django &nbsp; | &nbsp; MySQL &nbsp;
									| &nbsp; Web</p>


								<a href="#" class="course-btn"> View Details <i class="fa-solid fa-arrow-right"></i>

								</a>

							</div>


						</div>



						<!-- =================================================
                 C / C++ COURSE
                 ================================================= -->

						<div class="course-card">


							<div class="course-header">


								<img src="${pageContext.request.contextPath}/resources/images/cpp.jpg"
									alt="C C++ Programming Course">


								<div class="course-overlay">


									<h3>C / C++</h3>


									<strong> Programming </strong>


								</div>

							</div>



							<div class="course-body">


								<h3>C/C++ Programming</h3>


								<p>C &nbsp; | &nbsp; C++ &nbsp; | &nbsp; Linux &nbsp; | &nbsp;
									Data Structures</p>


								<a href="#" class="course-btn"> View Details <i class="fa-solid fa-arrow-right"></i>

								</a>

							</div>


						</div>


					</div>

				</div>

			</section>



			<!-- =====================================================
     STATISTICS
     ===================================================== -->

			<section class="statistics">


				<div class="container statistics-grid">


					<div class="stat">

						<i class="fa-solid fa-user-graduate"></i>

						<h2>500+</h2>

						<p>Students</p>

					</div>


					<div class="stat">

						<i class="fa-solid fa-book-open"></i>

						<h2>15+</h2>

						<p>Courses</p>

					</div>


					<div class="stat">

						<i class="fa-solid fa-users"></i>

						<h2>20+</h2>

						<p>Faculty</p>

					</div>


					<div class="stat">

						<i class="fa-solid fa-building"></i>

						<h2>10+</h2>

						<p>Active Batches</p>

					</div>


				</div>

			</section>



			<!-- =====================================================
     ABOUT
     ===================================================== -->

			<section class="about-section" id="about">


				<div class="container about-container">


					<!-- ABOUT IMAGE -->

					<div class="about-image">


						<img src="${pageContext.request.contextPath}/resources/images/institute.jpg"
							alt="TechTrain Training Institute">


						<div class="about-image-overlay">


							<i class="fa-solid fa-building-columns"></i>


							<h3>TechTrain</h3>


							<p>Training Institute</p>


						</div>


					</div>



					<!-- ABOUT CONTENT -->

					<div class="about-content">


						<span> ABOUT OUR INSTITUTE </span>


						<h2>Training Institute Management System</h2>


						<p>Our Training Institute Management System provides a
							centralized platform for managing students, courses, batches,
							faculty, attendance, assignments and assessments.</p>


						<p>We focus on practical and industry-oriented training to help
							students develop the skills required for their careers.</p>


						<a href="#contact" class="primary-btn"> Learn More <i class="fa-solid fa-arrow-right"></i>

						</a>


					</div>


				</div>

			</section>



			<!-- =====================================================
     CONTACT
     ===================================================== -->

			<section class="contact-section" id="contact">


				<div class="container">


					<div class="contact-container">


						<!-- CONTACT INFORMATION -->

						<div class="contact-info">


							<div class="section-title left">

								<h2>Contact Us</h2>

								<div class="title-line"></div>

							</div>


							<p>

								<i class="fa-solid fa-location-dot"></i> Pune, Maharashtra

							</p>


							<p>

								<i class="fa-solid fa-phone"></i> +91 98765 43210

							</p>


							<p>

								<i class="fa-solid fa-envelope"></i> training@example.com

							</p>



							<div class="social-icons">


								<a href="#"> <i class="fa-brands fa-facebook-f"></i>

								</a> <a href="#"> <i class="fa-brands fa-linkedin-in"></i>

								</a> <a href="#"> <i class="fa-brands fa-twitter"></i>

								</a> <a href="#"> <i class="fa-brands fa-instagram"></i>

								</a>


							</div>


						</div>



						<!-- CONTACT FORM -->

						<div class="contact-form">


							<form>


								<div class="form-row">


									<input type="text" placeholder="Name" required> <input type="email"
										placeholder="Email" required>


								</div>


								<textarea placeholder="Message" rows="6" required></textarea>


								<button type="submit">

									<i class="fa-solid fa-paper-plane"></i> Send Message

								</button>


							</form>


						</div>


					</div>

				</div>

			</section>



			<!-- =====================================================
     FOOTER
     ===================================================== -->

			<footer>


				<div class="container footer-container">


					<!-- FOOTER LOGO -->

					<div class="footer-logo">


						<i class="fa-solid fa-graduation-cap"></i>


						<div>

							<h3>TechTrain</h3>


							<span> Training Institute </span>

						</div>


					</div>



					<!-- FOOTER LINKS -->

					<div class="footer-links">


						<a href="${pageContext.request.contextPath}/"> Home </a> <span>|</span>


						<a href="#about"> About </a> <span>|</span> <a href="#courses">

							Courses </a> <span>|</span> <a href="#contact"> Contact </a> <span>|</span>


						<a href="${pageContext.request.contextPath}/loginPage"> Login </a>


					</div>



					<!-- COPYRIGHT -->

					<div class="copyright">

						© 2026 Training Institute Management System <br> All Rights
						Reserved.

					</div>


				</div>

			</footer>


		</body>

		</html>