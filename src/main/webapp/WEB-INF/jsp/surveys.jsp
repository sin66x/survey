<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>

    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Survay"/>
    </jsp:include>

</head>


<body>

<jsp:include page="navbar.jsp"/>


<div class="container">

    <div class="row my-5">
        <div class="col">

            <div class="card">
                <div class="card-header">${messages.getMessage("SURVEY_LIST",lang)}</div>
                <ul class="list-group list-group-flush">

                    <c:choose>
                        <%-- Show when surveys is empty--%>
                        <c:when test="${surveys.isEmpty()}">
                            <p>${messages.getMessage("NOT_FOUND_ITEMS",lang)}</p>
                        </c:when>

                        <%-- Show List --%>
                        <c:otherwise>

                            <c:forEach items="${surveys}" var="survey">

                                <li class="list-group-item">
                                    <a href="/survey?sid=${survey.id}&lang=${lang}">${messages.getMessage(survey.title,lang)}</a>
                                </li>


                            </c:forEach>
                        </c:otherwise>
                    </c:choose>

                </ul>

            </div>
        </div>
    </div>



</div>


<jsp:include page="partials/bootstrapScripts.jsp"/>
<script type="text/javascript" src="/js/navTabOverflow.js"></script>


</body>
</html>