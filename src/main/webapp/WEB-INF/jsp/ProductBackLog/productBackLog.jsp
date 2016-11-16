<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<div class="col-lg-6 col-lg-offset-3">
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <c:if test="${not empty message}">
                        <div cssClass="error">${message}</div>
                    </c:if>
                    <spring:url value="/productBackLog" var="ActionUrl"/>
                    <form:form id="myForm" method="post" action="${ActionUrl}"
                               class="bs-example form-horizontal" commandName="productBackLog">
                        <fieldset>

                            <legend>Product BackLog Form</legend>
                            <form:hidden path="pid"/>
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
                                <label for="status" class="col-lg-3 control-label">Status</label>
                                <div class="col-lg-9">
                                    <form:select path="status">
                                        <form:option value="" label="--- Select ---"/>
                                        <form:options items="${statusList}"/>
                                    </form:select>
                                    <form:errors path="status" cssClass="error"/>
                                </div>
                            </div>



                            <div class="col-lg-9 col-lg-offset-3">
                                <spring:url value="/productBackLogList" var="pblURL"/>

                                <button type="reset" class="btn btn-default" onclick="location.href='${pblURL}'" formnovalidate>Cancel</button>

                                <c:choose>
                                    <c:when test="${productBackLog.pid != 0}">
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
                                                <h3>Product BackLog Form Submission</h3>
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

