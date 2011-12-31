<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/templates/header.jsp" %>
<h1>Créer un compte</h1>
<c:if test="${errorCount > 0}"><div class="alert-message error">Il y a <c:out value="${errorCount}" /> erreur(s) dans votre saisie :</div></c:if>
<form method="POST" action="<c:out value="${baseUrl}" />/register" id="registerform">
	<div class="clearfix<c:if test="${errorCount > 0}"> <c:choose><c:when test="${not empty firstnameError}">error</c:when><c:otherwise>success</c:otherwise></c:choose></c:if>">
		<label for="firstname">Prénom</label>
		<div class="input">
			<input type="text" name="firstname" id="firstname"<c:if test="${not empty firstnameValue}"> value="<c:out value="${firstnameValue}" />"</c:if> required />
			<c:if test="${not empty firstnameError}"><span class="help-inline"><c:out value="${firstnameError}" /></span></c:if>
		</div>
	</div>
	<div class="clearfix<c:if test="${errorCount > 0}"> <c:choose><c:when test="${not empty lastnameError}">error</c:when><c:otherwise>success</c:otherwise></c:choose></c:if>">
		<label for="lastname">Nom</label>
		<div class="input">
			<input type="text" name="lastname" id="lastname"<c:if test="${not empty lastnameValue}"> value="<c:out value="${lastnameValue}" />"</c:if> required />
			<c:if test="${not empty lastnameError}"><span class="help-inline"><c:out value="${lastnameError}" /></span></c:if>
		</div>
	</div>
	<div class="clearfix<c:if test="${errorCount > 0}"> <c:choose><c:when test="${not empty emailError}">error</c:when><c:otherwise>success</c:otherwise></c:choose></c:if>">
		<label for="email">Adresse e-mail</label>
		<div class="input">
			<input type="email" name="email" id="email"<c:if test="${not empty emailValue}"> value="<c:out value="${emailValue}" />"</c:if> required />
			<c:if test="${not empty emailError}"><span class="help-inline"><c:out value="${emailError}" /></span></c:if>
		</div>
	</div>
	<div class="clearfix<c:if test="${errorCount > 0}"> <c:choose><c:when test="${not empty passwordError}">error</c:when><c:otherwise>success</c:otherwise></c:choose></c:if>">
		<label for="password">Mot de passe</label>
		<div class="input">
			<input type="password" name="password" id="password" required />
			<c:if test="${not empty passwordError}"><span class="help-inline"><c:out value="${passwordError}" /></span></c:if>
		</div>
	</div>
	<div class="clearfix<c:if test="${errorCount > 0}"> <c:choose><c:when test="${not empty password2Error}">error</c:when><c:otherwise>success</c:otherwise></c:choose></c:if>">
		<label for="password2">Confirmez le mot de passe</label>
		<div class="input">
			<input type="password" name="password2" id="password2" required />
			<c:if test="${not empty password2Error}"><span class="help-inline"><c:out value="${password2Error}" /></span></c:if>
		</div>
	</div>
	<div class="actions">
		<button type="submit" class="btn primary">Créer un compte</button>
		<button type="reset" class="btn">Réinitialiser</button>
	</div>
</form>
<%@ include file="/templates/footer.jsp" %>