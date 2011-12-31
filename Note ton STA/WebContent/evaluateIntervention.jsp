<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/templates/header.jsp" %>
<p><a href="<c:out value="${baseUrl}" />/intervention/view/?id=<c:out value="${intervention.id}" />">&larr; Retour à l'intervention</a></p>
<h1>Evaluation de l'intervention <c:out value="${intervention.name}" /></h1>
<c:if test="${errorCount > 0}"><div class="alert-message error">Il y a <c:out value="${errorCount}" /> erreur(s) dans votre saisie :</div></c:if>
<form method="POST" action="<c:out value="${baseUrl}" />/intervention/evaluate/">
<input type="hidden" name="id" value="<c:out value="${intervention.id}" />" />
<div class="row">
	<div class="span8">ID Booster : <input type="number" name="idBooster"<c:if test="${not empty idBoosterValue}"> value="${idBoosterValue}"</c:if> required /></div>
	<c:if test="${not empty idBoosterError}"><div class="span8"><c:out value="${idBoosterError}" /></div></c:if>
</div>
<div class="span16">
	<h2>A propos de l'intervenant...</h2>
	<div class="row">
		<div class="span-one-third">Sa connaissance du sujet</div>
		<div class="span-one-third">
			<input type="radio" name="speakerKnowledge" value="1" class="star" required<c:if test="${speakerKnowledgeValue == 1}"> checked</c:if> />
			<input type="radio" name="speakerKnowledge" value="2" class="star" required<c:if test="${speakerKnowledgeValue == 2}"> checked</c:if> />
			<input type="radio" name="speakerKnowledge" value="3" class="star" required<c:if test="${speakerKnowledgeValue == 3}"> checked</c:if> />
			<input type="radio" name="speakerKnowledge" value="4" class="star" required<c:if test="${speakerKnowledgeValue == 4}"> checked</c:if> />
			<input type="radio" name="speakerKnowledge" value="5" class="star" required<c:if test="${speakerKnowledgeValue == 5}"> checked</c:if> />
		</div>
		<c:if test="${not empty speakerKnowledgeError}"><div class="span-one-third"><c:out value="${speakerKnowledgeError}" /></div></c:if>
	</div>
	<div class="row">
		<div class="span-one-third">Sa capacité d'enseignement</div>
		<div class="span-one-third">
			<input type="radio" name="speakerAbility" value="1" class="star" required<c:if test="${speakerAbilityValue == 1}"> checked="checked"</c:if> />
			<input type="radio" name="speakerAbility" value="2" class="star" required<c:if test="${speakerAbilityValue == 2}"> checked="checked"</c:if> />
			<input type="radio" name="speakerAbility" value="3" class="star" required<c:if test="${speakerAbilityValue == 3}"> checked="checked"</c:if> />
			<input type="radio" name="speakerAbility" value="4" class="star" required<c:if test="${speakerAbilityValue == 4}"> checked="checked"</c:if> />
			<input type="radio" name="speakerAbility" value="5" class="star" required<c:if test="${speakerAbilityValue == 5}"> checked="checked"</c:if> />
		</div>
		<c:if test="${not empty speakerAbilityError}"><div class="span-one-third"><c:out value="${speakerAbilityError}" /></div></c:if>
	</div>
	<div class="row">
		<div class="span-one-third">La qualité de ses réponses</div>
		<div class="span-one-third">
			<input type="radio" name="speakerAnswers" value="1" class="star" required<c:if test="${speakerAnswersValue == 1}"> checked="checked"</c:if> />
			<input type="radio" name="speakerAnswers" value="2" class="star" required<c:if test="${speakerAnswersValue == 2}"> checked="checked"</c:if> />
			<input type="radio" name="speakerAnswers" value="3" class="star" required<c:if test="${speakerAnswersValue == 3}"> checked="checked"</c:if> />
			<input type="radio" name="speakerAnswers" value="4" class="star" required<c:if test="${speakerAnswersValue == 4}"> checked="checked"</c:if> />
			<input type="radio" name="speakerAnswers" value="5" class="star" required<c:if test="${speakerAnswersValue == 5}"> checked="checked"</c:if> />
		</div>
		<c:if test="${not empty speakerAnswersError}"><div class="span-one-third"><c:out value="${speakerAnswersError}" /></div></c:if>
	</div>
	<h2>A propos des slides...</h2>
	<div class="row">
		<div class="span-one-third">La richesse du contenu</div>
		<div class="span-one-third">
			<input type="radio" name="slideContent" value="1" class="star" required<c:if test="${slideContentValue == 1}"> checked="checked"</c:if> />
			<input type="radio" name="slideContent" value="2" class="star" required<c:if test="${slideContentValue == 2}"> checked="checked"</c:if> />
			<input type="radio" name="slideContent" value="3" class="star" required<c:if test="${slideContentValue == 3}"> checked="checked"</c:if> />
			<input type="radio" name="slideContent" value="4" class="star" required<c:if test="${slideContentValue == 4}"> checked="checked"</c:if> />
			<input type="radio" name="slideContent" value="5" class="star" required<c:if test="${slideContentValue == 5}"> checked="checked"</c:if> />
		</div>
		<c:if test="${not empty slideContentError}"><div class="span-one-third"><c:out value="${slideContentError}" /></div></c:if>
	</div>
	<div class="row">
		<div class="span-one-third">Le format / mise en page</div>
		<div class="span-one-third">
			<input type="radio" name="slideFormat" value="1" class="star" required<c:if test="${slideFormatValue == 1}"> checked="checked"</c:if> />
			<input type="radio" name="slideFormat" value="2" class="star" required<c:if test="${slideFormatValue == 2}"> checked="checked"</c:if> />
			<input type="radio" name="slideFormat" value="3" class="star" required<c:if test="${slideFormatValue == 3}"> checked="checked"</c:if> />
			<input type="radio" name="slideFormat" value="4" class="star" required<c:if test="${slideFormatValue == 4}"> checked="checked"</c:if> />
			<input type="radio" name="slideFormat" value="5" class="star" required<c:if test="${slideFormatValue == 5}"> checked="checked"</c:if> />
		</div>
		<c:if test="${not empty slideFormatError}"><div class="span-one-third"><c:out value="${slideFormatError}" /></div></c:if>
	</div>
	<div class="row">
		<div class="span-one-third">Les exemples</div>
		<div class="span-one-third">
			<input type="radio" name="slideExamples" value="1" class="star" required<c:if test="${slideExamplesValue == 1}"> checked="checked"</c:if> />
			<input type="radio" name="slideExamples" value="2" class="star" required<c:if test="${slideExamplesValue == 2}"> checked="checked"</c:if> />
			<input type="radio" name="slideExamples" value="3" class="star" required<c:if test="${slideExamplesValue == 3}"> checked="checked"</c:if> />
			<input type="radio" name="slideExamples" value="4" class="star" required<c:if test="${slideExamplesValue == 4}"> checked="checked"</c:if> />
			<input type="radio" name="slideExamples" value="5" class="star" required<c:if test="${slideExamplesValue == 5}"> checked="checked"</c:if> />
		</div>
		<c:if test="${not empty slideExamplesError}"><div class="span-one-third"><c:out value="${slideExamplesError}" /></div></c:if>
	</div>
	<p>Un commentaire à rajouter ?</p>
	<textarea name="comment"><c:if test="${not empty commentValue}"><c:out value="${commentValue}" /></c:if></textarea>
	<div class="actions"><button type="submit" class="btn primary">Envoyer</button></div>
</div>
</form>
<%@ include file="/templates/footer.jsp" %>