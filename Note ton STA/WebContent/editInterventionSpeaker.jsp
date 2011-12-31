<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/templates/header.jsp" %>
<h1>
<c:choose>
<c:when test="${editIntervention}">Edition de l'intervention <c:out value="${intervention.name}" /></c:when>
<c:otherwise>Ajout d'une intervention</c:otherwise>
</c:choose></h1>
<form method="<c:choose><c:when test="${editIntervention}">PUT</c:when><c:otherwise>POST</c:otherwise></c:choose>"
	action="<c:out value="${baseUrl}" />/speaker/intervention/edit/" id="interventionform">
	<c:if test="${editIntervention}"><input type="hidden" name="id" value="${intervention.id}" /></c:if>
	<div class="clearfix<c:if test="${errorCount > 0}"> <c:choose><c:when test="${not empty subjectError}">error</c:when><c:otherwise>success</c:otherwise></c:choose></c:if>">
		<label for="subject">Sujet</label>
		<div class="input">
			<input type="text" name="subject" id="subject"<c:if test="${not empty intervention}"> value="${intervention.getName()}"</c:if> required />
			<c:if test="${not empty subjectError}"><span class="help-inline"><c:out value="${subjectError}" /></span></c:if>
		</div>
	</div>
	<div class="clearfix<c:if test="${errorCount > 0}"> <c:choose><c:when test="${not empty campusError}">error</c:when><c:otherwise>success</c:otherwise></c:choose></c:if>">
		<label for="campus">Campus</label>
		<div class="input">
			<select name="campus" id="campus">
			<c:forEach items="${campuses}" var="campus">
				<option value="${campus.id}"<c:if test="${campus.id == intervention.campus.id}"> selected="selected"</c:if>><c:out value="${campus.name}" /></option>
			</c:forEach>
			</select>
			<c:if test="${not empty campusError}"><span class="help-inline"><c:out value="${campusError}" /></span></c:if>
		</div>
	</div>
	<div class="clearfix<c:if test="${errorCount > 0}"> <c:choose><c:when test="${not empty dateStartError}">error</c:when><c:otherwise>success</c:otherwise></c:choose></c:if>">
		<label for="dateStart">Du</label>
		<div class="input">
		<c:out value="${date1}" /> <c:out value="${date2}" />
			<input type="date" name="dateStart" id="dateStart"<c:if test="${not empty intervention}"> value="<c:out value="${intervention.dateStart}" />"</c:if> required />
			<c:if test="${not empty dateStartError}"><span class="help-inline"><c:out value="${dateStartError}" /></span></c:if>
		</div>
	</div>
	<div class="clearfix<c:if test="${errorCount > 0}"> <c:choose><c:when test="${not empty dateEndError}">error</c:when><c:otherwise>success</c:otherwise></c:choose></c:if>">
		<label for="dateEnd">Au</label>
		<div class="input">
			<input type="date" name="dateEnd" id="dateEnd"<c:if test="${not empty intervention}"> value="<c:out value="${intervention.dateEnd}" />"</c:if> required />
			<c:if test="${not empty dateEndError}"><span class="help-inline"><c:out value="${dateEndError}" /></span></c:if>
		</div>
	</div>
	<div class="clearfix<c:if test="${errorCount > 0}"> <c:choose><c:when test="${not empty descriptionError}">error</c:when><c:otherwise>success</c:otherwise></c:choose></c:if>">
		<label for="description">Description</label>
		<div class="input">
			<textarea name="description" id="description" required><c:if test="${not empty intervention}"><c:out value="${intervention.description}" /></c:if></textarea>
			<c:if test="${not empty descriptionError}"><span class="help-inline"><c:out value="${descriptionError}" /></span></c:if>
		</div>
	</div>
	<div class="actions">
		<button type="submit" class="btn primary">Enregistrer</button>
		<button type="reset" class="btn">Réinitialiser</button>
	</div>
</form>
<%@ include file="/templates/footer.jsp" %>