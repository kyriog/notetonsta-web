<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/templates/header.jsp" %>
<h1>Bienvenue sur Note Ton STA !</h1>
<p>Ce site vous propose d'évaluer les interventions des professeurs de SUPINFO International University.</p>
<p>Vous pouvez également visualiser des statistiques par intervenant ou par campus.</p>
<p>Merci de sélectionner votre campus :</p>
<form method="GET" action="<c:out value="${baseUrl}" />/campus/">
<select name="id">
	<c:forEach items="${campuses}" var="campus">
	<option value="<c:out value="${campus.id}" />"><c:out value="${campus.name}" /></option>
	</c:forEach>
</select>
<button type="submit" class="btn primary">Voir les interventions !</button>
</form>
<p>Si vous êtes un intervenant et que vous avez déjà un compte, veuillez vous identifier pour gérer vos interventions.</p>
<p>Si vous ne disposez pas encore un compte, <a href="<c:out value="${baseUrl}" />/register">enregistrez-vous</a>.</p>
<%@ include file="/templates/footer.jsp" %>