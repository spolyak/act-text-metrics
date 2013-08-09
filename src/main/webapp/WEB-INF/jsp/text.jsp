<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<%@include file="header.jsp"%>
<style type="text/css">
textarea {
	border: 1px solid #999999;
	width: 100%;
	height: 150px;
	margin: 5px 0;
	padding: 3px;
}
</style>
</head>

<body>
	<div id="wrap">
		<%@include file="nav.jsp"%>
		<div class="container">
			<div class="page-header">
				<h1>Text Metrics</h1>
			</div>
			<div class="row">
				<div class="span12">
					<form:form method="post" action="compute" commandName="text"
						class="form-vertical">
						<form:textarea path="value" />

						<input type="submit" value="Analyze" class="btn" />
					</form:form>
				</div>
				<div class="span12">
					<c:if test="${text.results}">
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Metric</th>
									<th>Results</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Paragraph Count</td>
									<td>${text.paragraphCount}</td>
								</tr>
								<tr>
									<td>Sentence Count</td>
									<td>${text.sentenceCount}</td>
								</tr>
								<tr>
									<td>Word Count</td>
									<td>${text.wordCount}</td>
								</tr>
								<tr>
									<td>Paragraph Length (mean)</td>
									<td>${text.paragraphLengthMean}</td>
								</tr>
								<tr>
									<td>Paragraph Length (sd)</td>
									<td>${text.paragraphLengthSD}</td>
								</tr>
								<tr>
									<td>Sentence Length (mean)</td>
									<td>${text.sentenceLengthMean}</td>
								</tr>
								<tr>
									<td>Sentence Length (sd)</td>
									<td>${text.sentenceLengthSD}</td>
								</tr>
								<tr>
									<td>Word Length - syllabels (mean)</td>
									<td>${text.syllabelsLengthMean}</td>
								</tr>
								<tr>
									<td>Word Length - syllabels (sd)</td>
									<td>${text.syllabelsLengthSD}</td>
								</tr>
								<tr>
									<td>Word Length - letters (mean)</td>
									<td>${text.wordLengthMean}</td>
								</tr>
								<tr>
									<td>Word Length - letters (sd)</td>
									<td>${text.wordLengthsSD}</td>
								</tr>
								<tr>
									<td>Flesch-Kincaid Grade Level</td>
									<td>${text.getFleschKincaidGradeLevel}</td>
								</tr>
								
							</tbody>
						</table>
					</c:if>
				</div>
			</div>
			<div id="push"></div>
		</div>
		<%@include file="footer.jsp"%>
</body>