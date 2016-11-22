<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<div class="col-lg-6 col-lg-offset-3">
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <form:form id="myForm" method="post" action="/burndownchart"
                               class="bs-example form-horizontal" commandName="sprint">
                        <fieldset>

                            <legend>Burn Down Chart Form</legend>
                            <div class="form-group">
                                <label for="sid" class="col-lg-3 control-label">Sprint</label>
                                <div class="col-lg-9">
                                    <form:select path="sid" id="sid" cssClass="form-control">
                                        <form:options items="${sprints}" itemLabel="name" itemValue="sid"/>
                                    </form:select>
                                </div>
                            </div>

                            <div class="col-lg-9 col-lg-offset-3">

                                <button type="reset" class="btn btn-default" onclick="location.href='/burndownchart'"
                                        formnovalidate>Cancel
                                </button>
                                <button class="btn btn-primary" type="submit">View Chart
                                </button>
                            </div>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

