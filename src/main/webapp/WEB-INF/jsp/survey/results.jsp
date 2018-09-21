<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
<head>


    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Survay"/>
    </jsp:include>

</head>


<body>

<jsp:include page="../navbar.jsp">
    <jsp:param name="home_text" value="HOME"/>
    <jsp:param name="logout_text" value="LOGOUT"/>
</jsp:include>


<div class="container">
     <div class="row my-5">
        <div class="col">
            <div class="card">
            <div class="card-header">
                Results
            </div>
                <ul class="list-group list-group-flush">
                    <c:forEach items="${results}" var="result">
                        <li class="list-group-item">${result.answer}</li>
                    </c:forEach>
                </ul>

            </div>
        </div>

     </div>

</div>


<jsp:include page="../partials/bootstrapScripts.jsp"/>


</body>
</html>