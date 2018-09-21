<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>

    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Survay"/>
    </jsp:include>

</head>


<body>

<jsp:include page="../navbar.jsp">
    <jsp:param name="home_text" value="${messages.getMessage('HOME',lang)}"/>
    <jsp:param name="logout_text" value="${messages.getMessage('LOGOUT',lang)}"/>
</jsp:include>


<div class="container">

    <div class="row my-5">

        <div class="col">

            <div class="card">
                <div class="card-header">${messages.getMessage("QUESTION_RATE_CHART", lang)}</div>
                <div class="card-body">
                    <canvas id="question-rate" width="800" height="400"></canvas>
                </div>


            </div>
        </div>
    </div>

    <div class="row my-5">
        <div class="col">

            <div class="card">
                <div class="card-header">${messages.getMessage("PART_RATE_CHART", lang)}</div>
                <div class="card-body">
                    <canvas id="part-rate" width="800" height="400"></canvas>
                </div>


            </div>
        </div>
    </div>

    <div class="row my-5">

        <div class="col">

            <div class="card">
                <div class="card-header">${messages.getMessage("QUESTION_RATE_CHART", lang)}</div>
                <div class="card-body">
                </div>
                <canvas id="question-engagement" width="800" height="400"></canvas>


            </div>
        </div>
    </div>


</div>




<jsp:include page="../partials/bootstrapScripts.jsp"/>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js"></script>
<script type="text/javascript" src="/js/questionRate/questionRateController.js"></script>
<script type="text/javascript" src="/js/questionRate/partRateController.js"></script>
<script type="text/javascript" src="/js/questionRate/questionEngagement.js"></script>

</body>
</html>