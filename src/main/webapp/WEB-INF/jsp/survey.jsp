<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
<head>


    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Survay"/>
    </jsp:include>

</head>


<body>

    <jsp:include page="navbar.jsp">
        <jsp:param name="home_text" value="${messages.getMessage('HOME',lang)}"/>
        <jsp:param name="logout_text" value="${messages.getMessage('LOGOUT',lang)}"/>
    </jsp:include>


    <div class="container">


        <div class="row my-5">
            <div class="col">


                <div class="card shadow-lg bg-white rounded ">
                    <div class="card-body">

                        <div class="scroller scroller-left mt-2">
                            <i class="fas fa-chevron-left"></i>
                        </div>
                        <div class="scroller scroller-right mt-2">
                            <i class="fas fa-chevron-right"></i>
                        </div>
                        <div class="wrapper">
                            <ul class="nav nav-tabs list mt-2" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="${part.title}-tab" data-toggle="tab"
                                       href="#${survey.title}" role="tab"
                                       aria-controls="${survey.title}" aria-selected="true">${messages.getMessage(survey.title,lang)}
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <form:form action="survey" method="POST" modelAttribute="answerList" >
                        <c:forEach items="${survey.surveyParts}" var="part">
                            <div class="tab-content" id="myTabContent">
                                <div class="tab-pane fade show active" id="${part.title}" role="tabpanel"
                                     aria-labelledby="${part.title}-tab">

                                    <div class="card shadow-sm bg-white rounded my-5">
                                        <div class="card-header bg-info text-center text-white">${messages.getMessage(part.title,lang)}</div>
                                            <div class="card-body">
                                                <div class="card">
                                                    <c:forEach items="${part.questions}" var="question" varStatus="statusQ">

                                                                <ul class="list-group list-group-flush">
                                                                    <li class="list-group-item">
                                                                        <div class="my-3">
                                                                            <h6>
                                                                                ${messages.getMessage(question.text,lang)}
                                                                            </h6>
    <input name="answers[${question.inSurveyIndex-1}].questionTitle" value="${question.text}" type="hidden"/>
    <input name="answers[${question.inSurveyIndex-1}].questionId" value="${question.id}" type="hidden"/>
    <input name="sid" value="${survey.id}" type="hidden"/>
                                                                            <c:if test='${question.type.equals("AGR")}'>
                                                                            <!-- OPTIONS -->
                                                                            <div class="form-check custom-control custom-radio">
                                                                                <input type="radio" class="custom-control-input"
                                                                                       id="${question.text}fullyAgree"
                                                                                       value = "6"
                                                                                       name="answers[${question.inSurveyIndex-1}].answer">
                                                                                <label class="custom-control-label"
                                                                                       for="${question.text}fullyAgree">${messages.getMessage('FULLY_AGREE',lang)}
                                                                                </label>
                                                                            </div>
                                                                            <div class="form-check custom-control custom-radio">
                                                                                <input type="radio" class="custom-control-input"
                                                                                       id="${question.text}agree"
                                                                                       value = "5"
                                                                                       name="answers[${question.inSurveyIndex-1}].answer">
                                                                                <label class="custom-control-label"
                                                                                       for="${question.text}agree">${messages.getMessage('AGREE',lang)}
                                                                                </label>
                                                                            </div>
                                                                            <div class="form-check custom-control custom-radio">
                                                                                <input type="radio" class="custom-control-input"
                                                                                       id="${question.text}partiallyAgree"
                                                                                       value = "4"
                                                                                       name="answers[${question.inSurveyIndex-1}].answer">
                                                                                <label class="custom-control-label"
                                                                                       for="${question.text}partiallyAgree">
                                                                                    ${messages.getMessage('PARTIALLY_AGREE',lang)}
                                                                                </label>
                                                                            </div>
                                                                            <div class="form-check custom-control custom-radio">
                                                                                <input type="radio" class="custom-control-input"
                                                                                       id="${question.text}partiallyDisagree"
                                                                                       value = "3"
                                                                                       name="answers[${question.inSurveyIndex-1}].answer">
                                                                                <label class="custom-control-label"
                                                                                       for="${question.text}partiallyDisagree">
                                                                                    ${messages.getMessage('PARTIALLY_DISAGREE',lang)}
                                                                                </label>
                                                                            </div>
                                                                            <div class="form-check custom-control custom-radio">
                                                                                <input type="radio" class="custom-control-input"
                                                                                       id="${question.text}disagree"
                                                                                       value = "2"
                                                                                       name="answers[${question.inSurveyIndex-1}].answer">
                                                                                <label class="custom-control-label"
                                                                                       for="${question.text}disagree">${messages.getMessage('DISAGREE',lang)}
                                                                                </label>
                                                                            </div>
                                                                            <div class="form-check custom-control custom-radio">
                                                                                <input type="radio" class="custom-control-input"
                                                                                       id="${question.text}fullyDisagree"
                                                                                       value = "1"
                                                                                       name="answers[${question.inSurveyIndex-1}].answer">
                                                                                <label class="custom-control-label"
                                                                                       for="${question.text}fullyDisagree">${messages.getMessage('FULLY_DISAGREE',lang)}
                                                                                </label>
                                                                            </div>
                                                                            <!-- /OPTIONS -->
                                                                            </c:if>
                                                                            <c:if test='${question.type.equals("DES")}'>
                                                                                  <textarea name="answers[${question.inSurveyIndex-1}].answer" ></textarea>
                                                                            </c:if>
                                                                        </div>
                                                                    </li>
                                                                </ul>

                                                    </c:forEach>
                                                </div>
                                            </div>

                                    </div>

                                </div>
                                <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                    ...
                                </div>
                                <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                                    ...
                                </div>
                            </div>
                        </c:forEach>
                            <input type="submit"  value="${messages.getMessage('SUBMIT',lang)}"/>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <jsp:include page="partials/bootstrapScripts.jsp"/>
    <script type="text/javascript" src="/js/navTabOverflow.js"></script>


</body>
</html>