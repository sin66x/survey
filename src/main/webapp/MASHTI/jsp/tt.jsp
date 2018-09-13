<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>

</head>
<body>

      <div class="error_msg">
            HELLO ${name}
      </div>
      <form:form action="test" method="POST" modelAttribute="testMod" >
            <form:input path="myName" value=""/>
            <input type="submit"  value="Do"/>
      </form:form>

      <c:forEach items="${testModels}" var="tm">
        ${tm.myName}
      </c:forEach>

</body>

</html>
