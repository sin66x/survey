<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>


    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Survay"/>
    </jsp:include>

</head>

<body>

<jsp:include page="navbar.jsp">
    <jsp:param name="home_text" value="HOME"/>
    <jsp:param name="logout_text" value="LOGOUT"/>
</jsp:include>


<div class="container">
    <div class="row my-5 justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Login</div>

                <div class="card-body">
                    <form action="login" method='POST'>

                        <%-- Username --%>
                        <div class="form-group row">
                            <label for="username" class="col-sm-4 col-form-label text-md-right">Username</label>

                            <div class="col-md-6">
                                <input id="username" type="text" class="form-control" name="username" required
                                       autofocus>
                            </div>
                        </div>

                        <%-- Password --%>
                        <div class="form-group row">
                            <label for="password" class="col-md-4 col-form-label text-md-right">Password</label>

                            <div class="col-md-6">
                                <input id="password" type="password"
                                       class="form-control"
                                       name="password" required>
                            </div>
                        </div>

                        <%-- Submit Button --%>
                        <div class="form-group row mb-0">
                            <div class="col-md-8 offset-md-4">
                                <button type="submit" class="btn btn-info">
                                    Login
                                </button>
                            </div>
                        </div>


                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="partials/bootstrapScripts.jsp"/>

</body>
</html>