<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>

</head>
<body>

      <form:form action="testarray" method="POST" modelAttribute="answerList" >
          <c:forEach items="${testArrayForm.testModelList}" var="tm" varStatus="status">
            ${answerList.answers[status.index].questionTitle}
            <input name="answers[${status.index}].answer"/><br/>
            <input name="answers[${status.index}].questionTitle" value="${tm.myName}"/><br/>
          </c:forEach>
          <input type="submit"  value="Do"/>
      </form:form>


</body>

</html>
