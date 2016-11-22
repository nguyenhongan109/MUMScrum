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
                            <strong>${message}</strong>
                        </div>
                    </c:if>
                    <form:form id="myForm" method="post" action="/assignUStoDev"
                               class="bs-example form-horizontal" commandName="userstory">
                        <fieldset>
                            <legend>UserStory Assign to Developer Form</legend>

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
                                <label class="col-lg-3 control-label" for="eid">Developer/Tester:</label>
                                <div class="col-lg-9">
                                    <form:select id="eid" path="eid">
                                        <option value="">--- Select ---</option>
                                        <c:forEach var="dev" items="${devlist}">
                                            <form:option value="${dev.eid}"><c:out value="${dev.firstName}' : ' ${dev.role}"/></form:option>
                                        </c:forEach>
                                    </form:select>
                                    <form:errors path="eid" cssClass="error"/>

                                </div>
                            </div>
                            <form:hidden path="uid"/>
                            <form:hidden path="sid"/>
                            <form:hidden path="pid"/>
                            <form:hidden path="rid"/>
                            <form:hidden path="estimatedEffort"/>
                            <form:hidden path="actualEffort"/>
                            <form:hidden path="completDate"/>
                            <form:hidden path="assignedDate"/>
                            <form:hidden path="status"/>

                            <div class="col-lg-9 col-lg-offset-3">
                                <button type="reset" class="btn btn-default" onclick="location.href='/AssignDevList'"  formnovalidate>Cancel</button>

                                <c:choose>
                                    <c:when test="${userstory.uid != 0}">
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
                                                <h3>User Story Form Submission</h3>
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

