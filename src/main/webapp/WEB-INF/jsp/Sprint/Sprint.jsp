<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>

<div class="col-lg-6 col-lg-offset-3">
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <c:if test="${not empty message}">
                        <div class="alert alert-${css} alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <strong class="error">${message}</strong>
                        </div>
                    </c:if>
                    <form:form id="myForm" method="post" action="/sprint"
                               class="bs-example form-horizontal" commandName="sprint">
                        <fieldset>
                            <legend>Sprint Form</legend>
                            <form:hidden path="sid"/>
                            <div class="form-group">
                                <label for="nameInput" class="col-lg-3 control-label">Name</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="form-control" path="name"
                                                id="nameInput" placeholder="Name"/>
                                    <form:errors path="name" cssClass="error"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="descriptionInput" class="col-lg-3 control-label">Description</label>
                                <div class="col-lg-9">
                                    <form:input type="text" class="form-control" path="description"
                                                id="descriptionInput" placeholder="Description"/>
                                    <form:errors path="description" cssClass="error"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="assignedDateInput" class="col-lg-3 control-label">Assign Date</label>
                                <div class="col-lg-9">
                                    <form:input type="date" class="form-control" path="assignedDate"
                                                cssClass="date-picker"
                                                id="assignedDateInput"/>
                                    <form:errors path="assignedDate" cssClass="error"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="startDateInput" class="col-lg-3 control-label">Start Date</label>
                                <div class="col-lg-9">
                                    <form:input type="date" class="form-control" path="startDate" cssClass="date-picker"
                                                id="startDateInput"/>
                                    <form:errors path="startDate" cssClass="error"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="endDateInput" class="col-lg-3 control-label">End Date</label>
                                <div class="col-lg-9">
                                    <form:input type="date" class="form-control" path="endDate" cssClass="date-picker"
                                                id="endDateInput"/>
                                    <form:errors path="endDate" cssClass="error"/>
                                </div>
                            </div>

                            <form:hidden path="status"/>
                            <form:hidden path="createdBy" value="${sessionScope.employee.eid}"/>
                            <input id="prodId" name="prodId" type="hidden" value="" />

                            <div class="col-lg-9 col-lg-offset-3">
                                <button type="reset" class="btn btn-default" onclick="location.href='/sprintlist'"
                                        formnovalidate>Cancel
                                </button>

                                <c:choose>
                                    <c:when test="${sprint.sid != 0}">
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
                                                <h3>Sprint Form Submission</h3>
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


