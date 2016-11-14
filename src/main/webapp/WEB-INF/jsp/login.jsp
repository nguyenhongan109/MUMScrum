<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<div class="col-lg-6 col-lg-offset-3">
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <form:form id="myForm" method="post"
                               class="bs-example form-horizontal" commandName="employeeLogin">
                        <fieldset>
                            <legend>Log In Form</legend>
                            <div class="form-group">
                                <label for="emailInput" class="col-lg-3 control-label">Email</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="form-control" path="email"
                                                id="emailInput" placeholder="Email"/>
                                    <form:errors path="email" cssClass="error"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="passwordInput" class="col-lg-3 control-label">Password</label>
                                <div class="col-lg-9">
                                    <form:input type="password" class="form-control"
                                                path="password" id="passwordInput" placeholder="Password"/>
                                    <form:errors path="password" cssClass="error"/>
                                </div>
                            </div>

                            <div class="col-lg-9 col-lg-offset-3">
                                <button class="btn btn-default">Cancel</button>

                                <button class="btn btn-primary">Login</button>
                            </div>


                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>