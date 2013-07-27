<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="baseu" value="${pageContext.request.contextPath eq '/' ? '' :  pageContext.request.contextPath}"/>

<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<button type="button" class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="brand" href="http://www.act.org">ACT</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li><a href="${baseu}/web/text">Home</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>