<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Login</title>
		<link rel="icon" type="image/png" href="resources/img/favicon.png" />
		<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic&subset=latin,cyrillic-ext,cyrillic,latin-ext' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="resources/css/login_styles.css" type="text/css">
		
	</head>
	
	<body>
	
		<div class="b-page">
			<div class="b-page-wr">
				<div class="b-header">
					<div class="b-page-width">
						<img class="b-header_image" src="resources/img/header/logo.png"/>
					</div>
				</div>
				<div class="b-body">
					<div class="b-page-width">
						<div class="b-login-form active">
							<div class="b-login-form__header">
								<span class="b-login-form__header_name">Войти</span>
								<span class="b-login-form__header_text">или <a href="#" class = "b-login-form_register-link-create" onclick="changeForm()">создать аккаунт</a></span>
							</div>
							<form class="b-login-form__login-form" action="login" method="post">
								<div class="b-login-form__login-form__item">
									<label class="form-text-input-label" for="login">Логин</label>
									<div class="input-wr"><input class="form-text-input" id="login" name="userLogin" type="text" placeholder="Login" required></div>
								</div>
								<div class="b-login-form__login-form__item">
									<label class="form-text-input-label" for="password">Пароль</label>
									<div class="input-wr"><input class="form-text-input" id="password" name="userPassword" type="password" placeholder="Password" required></div>
								</div>
								<div class="b-login-form__header">
									<input class="form-checkbox-input" id="remember-me" name="remember-me" type="checkbox" checked><label for="remember-me" class="form-checkbox-input-label">Запомнить меня</label>
									<span class="form-link-forgotten-password"><a href="#">Забыли пароль?</a></span>
								</div>
								<input class="form-submit-input blue-button" type="submit" value="ВОЙТИ" onclick="randomBackground()">
								<div class="b-login-form__error-message">${message}</div>
							</form>
						</div>
						<div class="b-register-form">
							<div class="b-login-form__header">
								<span class="b-login-form__header_name">Создать аккаунт</span>
								<span class="b-login-form__header_text">или <a href="#" class = "b-login-form_register-link-create" onclick="changeForm()">войти</a></span>
							</div>
							<form class="b-login-form__login-form" action="registration" method="post">
								<div class="b-login-form__login-form__item">
									<label class="form-text-input-label" for="login">Логин</label>
									<div class="input-wr"><input class="form-text-input" id="login" name="userLogin" type="text" placeholder="Login" required></div>
								</div>
								<div class="b-login-form__login-form__item">
									<label class="form-text-input-label" for="password">Пароль</label>
									<div class="input-wr"><input class="form-text-input" id="password" name="userPassword" type="password" placeholder="Password" required></div>
								</div>
								<div class="b-login-form__login-form__item">
									<label class="form-text-input-label" for="e-mail">Электронная почта</label>
									<div class="input-wr"><input class="form-text-input" id="e-mail" name="userEmail" type="text" placeholder="e-mail" required></div>
								</div>
								<input class="form-submit-input blue-button" type="submit" value="Создать">
								<div class="b-register-form__error-message">${message}</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="resources/js/loginForm.js"></script>
	</body>
</html>