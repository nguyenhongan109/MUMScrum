<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<div class="col-lg-6 col-lg-offset-3">
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <c:if test="${not empty message}">
                        <div Class="message error">${message}</div>
                    </c:if>
                    <spring:url value="/employee" var="ActionUrl"/>
                    <form:form id="myForm" method="post" action="${ActionUrl}"
                               class="bs-example form-horizontal" commandName="employee">
                        <fieldset>

                            <legend>Employee Form</legend>
                            <form:hidden path="eid"/>
                            <div class="form-group">
                                <label for="role" class="col-lg-3 control-label">Role</label>
                                <div class="col-lg-9">
                                    <form:select path="role">
                                        <form:option value="" label="--- Select ---"/>
                                        <form:options items="${roleList}"/>
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

                            <spring:bind path="password">
                                <div class="form-group">
                                    <label for="passwordInput" class="col-lg-3 control-label">Password</label>
                                    <div class="col-lg-9">
                                        <form:password path="password" class="form-control" id="passwordInput"
                                                       placeholder="password"/>
                                        <form:errors path="password" cssClass="error"/>
                                    </div>
                                </div>
                            </spring:bind>

                            <div class="col-lg-9 col-lg-offset-3">
                                <spring:url value="/admin" var="adminUrl"/>

                                <button type="reset" class="btn btn-default" onclick="location.href='${adminUrl}'"  formnovalidate>Cancel</button>

                                <c:choose>
                                    <c:when test="${employee.eid != 0}">
                                        <button class="btn btn-primary" data-toggle="modal"
                                                data-target="#themodal">Update
                                        </button>
                                    </c:when>
                                    <c:otherwise>
                                        <button class="btn btn-primary" data-toggle="modal"
                                                data-target="#themodal">Save
                                        </button>
                                    </c:otherwise>
                                </c:choose>

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
                </div>
            </div>
        </div>
    </div>
</div>

