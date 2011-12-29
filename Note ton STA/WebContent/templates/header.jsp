<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Note Ton STA<c:if test="${not empty pageTitle}"> − <c:out value="${pageTitle}" /></c:if></title>
<link rel="stylesheet" type="text/css" href="<c:out value="${baseUrl}" />/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<c:out value="${baseUrl}" />/css/style.css" />
<script type="text/javascript" src="<c:out value="${baseUrl}" />/js/jquery-1.7.1.min.js"></script>
</head>
<body>
	<div class="topbar">
		<div class="fill">
			<div class="container">
				<a class="brand" href="<c:out value="${baseUrl}" />/">Note Ton STA</a>
				<c:choose>
					<c:when test="${logged}">
						<ul class="nav">
							<li><a href="<c:out value="${baseUrl}" />/speaker/intervention/">Mes interventions</a></li>
							<li><a href="<c:out value="${baseUrl}" />/speaker/intervention/add">Ajouter une intervention</a></li>
						</ul>
						<ul class="nav secondary-nav">
							<li class="active"><a href="#">Bienvenue <c:out value="${speakerName}" /></a></li>
							<li><a href="<c:out value="${baseUrl}" />/logout">Déconnexion</a></li>
						</ul>
					</c:when>
					<c:otherwise>
						<ul class="nav">
							<li><a href="<c:out value="${baseUrl}" />/register">Vous êtes STA ? Créez votre compte</a></li>
						</ul>
						<form class="pull-right" action="<c:out value="${baseUrl}" />/login" method="POST">
							<input type="text" name="username" required class="input-small" placeholder="Nom de compte" />
							<input type="password" name="password" required class="input-small" placeholder="Mot de passe" />
							<button type="submit" class="btn">Connexion</button>
						</form>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="content">