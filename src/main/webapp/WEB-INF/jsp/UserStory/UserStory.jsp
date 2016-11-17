<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>

<div class="col-lg-6 col-lg-offset-3">
    <div class="well">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <form:form id="myForm" method="post" action="/userstory"
                               class="bs-example form-horizontal" commandName="userstory">
                        <fieldset>
                            <legend>UserStory Form</legend>
                            <form:hidden path="uid"/>
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
                                <label class="col-lg-3 control-label" for="pid">Product BackLog:</label>
                                <div class="col-lg-9">
                                    <form:select path="pid" id="PFilter" cssClass="form-control" >
                                        <form:option value="0" label="--- Select ---"/>
                                        <form:options items="${productBackLogs}" itemLabel="name" itemValue="pid"/>
                                    </form:select>
                                    <form:errors path="pid" cssClass="error"/>
                                </div>
                            </div>
                            <input id="relId" name="relId" type="hidden" value="${userstory.rid}" />
                            <div class="form-group">
                                <label class="control-label col-lg-3" for="rid">Release:</label>
                                <div class="col-lg-9">
                                    <form:select id="releaseFilter" path="rid" cssClass="form-control">
                                        <form:options items="${releases}" itemLabel="name" itemValue="rid"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="status" class="col-lg-3 control-label">Status</label>
                                <div class="col-lg-9">
                                    <form:select path="status">
                                        <form:options items="${statuslists}"/>
                                    </form:select>
                                    <form:errors path="status" cssClass="error"/>
                                </div>
                            </div>
                            <form:hidden path="sid"/>
                            <form:hidden path="eid"/>
                            <form:hidden path="actualEffort"/>
                            <form:hidden path="completDate"/>
                            <form:hidden path="assignedDate"/>

                            <input id="prodId" name="prodId" type="hidden" value="" />


                            <div class="col-lg-9 col-lg-offset-3">
                                <button type="reset" class="btn btn-default" onclick="location.href='/userstorylist'"  formnovalidate>Cancel</button>

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
<script type="text/javascript" charset="utf-8">
    $(document).ready(function() {
       UpdateRelease();
        $('#PFilter').change(function()
        {
            UpdateRelease();
        });

        function UpdateRelease()
        {
            $("#prodId").val($('#PFilter').val());
            var prodId = $("#prodId").val();
            console.log("Pid: "+prodId);
            var relId=$("#relId").val();
            console.log("Rid:"+relId);

            var data = {
                "prodId" : prodId
            };

            var url = "<c:url value='/releasebyproduct/'/>";
            $.ajax({
                type : "GET",
                contentType : "application/json",
                url : url + prodId,
                data : JSON.stringify(data),
                success : function(data) {
                    var html = '<option value="">--- Select ---</option>';
                    var len = data.length;
                    for ( var i = 0; i < len; i++) {
                        console.log(data[i].name);
                        console.log(data[i].rid);
                        html += '<option value="' + data[i].rid + '">'
                                + data[i].name + '</option>';
                    }
                    html += '</option>';

                    $('#releaseFilter').html(html);
                    $('#releaseFilter').val(relId);
                },
                error : function(xhr, status, exception) {
                    console.log(xhr, status, exception);
                },
                done : function(e) {
                    console.log("DONE");
                }
            });
        }
    });
</script>

