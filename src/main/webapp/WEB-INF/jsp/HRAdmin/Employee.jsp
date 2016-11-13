<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<c:if test="${not empty message}">
    <div cssClass="error">${message}</div>
</c:if>
<c:choose>
    <c:when test="${employee['new']}">
        <legend>New Employee Form</legend>
    </c:when>
    <c:otherwise>
        <legend>Update Employee Form</legend>
    </c:otherwise>
</c:choose>
<form:form id="myForm" method="post"
           class="bs-example form-horizontal"  commandName="employee">
    <fieldset>

        <legend>Employee Form</legend>

        <div class="form-group">
            <label for="role" class="col-lg-3 control-label">Role</label>
            <div class="col-lg-9">
                <form:select path="role">
                    <form:option value="" label="--- Select ---" />
                    <form:options items="${roleList}" />
                </form:select>
                <form:errors path="role" cssClass="error"/>
            </div>
        </div>

        <div class="form-group">
            <label for="firstNameInput" class="col-lg-3 control-label">First Name</label>
            <div class="col-lg-9">
                <form:input type="text" class="form-control" path="firstName"
                            id="firstNameInput" placeholder="First Name"/>
                <form:errors path="firstName" cssClass="error"/>
            </div>
        </div>

        <div class="form-group">
            <label for="lastNameInput" class="col-lg-3 control-label">Last Name</label>
            <div class="col-lg-9">
                <form:input type="text" class="form-control" path="lastName"
                            id="lastNameInput" placeholder="Last Name"/>
                <form:errors path="lastName" cssClass="error"/>
            </div>
        </div>

        <div class="form-group">
            <label for="emailInput" class="col-lg-3 control-label">Email Address</label>
            <div class="col-lg-9">
                <form:input type="text" class="form-control" path="email"
                            id="emailInput"
                            placeholder="Email Address"/>
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

            <button class="btn btn-primary" data-toggle="modal"
                    data-target="#themodal">Submit
            </button>
            <div id="themodal" class="modal fade" data-backdrop="static">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"
                                    aria-hidden="true">&times;</button>
                            <h3>Employee Form Submission</h3>
                        </div>
                        <div class="modal-body">
                            <p>Are you sure you want to do this?</p>
                            <div class="progress progress-striped active">
                                <div id="doitprogress" class="progress-bar"></div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
                            <input type="submit" value="Yes" id="yesbutton"
                                   class="btn btn-primary" data-loading-text="Saving.."
                                   data-complete-text="Submit Complete!">
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </fieldset>
</form:form>

