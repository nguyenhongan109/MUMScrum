<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<%@ page import="edu.mum.se.mumscrum.utilities.Role" %>
<div class="navbar navbar-default">

    <%--
    <div class="navbar-header">
        <a class="navbar-brand"><span style="font-weight: bold;">MUMScrum System</span>
            | <span style="font-size: medium"> ${Role.valueOf(sessionScope.employee.role).desc()} </span></a>
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target=".navbar-responsive-collapse">
            <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                class="icon-bar"></span>
        </button>
    </div>--%>

    <div class="navbar-collapse collapse navbar-responsive-collapse">
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${sessionScope.employee.role == 'ADMIN'}">
                    <li><a href="/admin">Home</a></li>
                    <li><a>|</a></li>
                    <li><a href="/employee">New Employee</a></li>
                    <li><a>|</a></li>
                    <li><a href="http://localhost:8080/login">Logout</a></li>
                </c:when>
                <c:when test="${sessionScope.employee.role == 'POWNER'}">
                    <li><a href="/userstorylist">Home</a></li>
                    <li><a>|</a></li>
                    <li><a href="/productBackLogList">Product Backlog</a></li>
                    <li><a>|</a></li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">User Story<b
                            class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="userstory">Create User Story</a></li>
                            <li class="divider"></li>
                            <li><a href="/userstorylist">User Story List</a></li>
                        </ul>
                    </li>
                    <li><a>|</a></li>
                    <li><a href="#">Assign Scrum Master</a></li>
                    <li><a>|</a></li>
                    <li><a href="/login">Logout</a></li>
                </c:when>
                <c:when test="${sessionScope.employee.role == 'SCRUMASTER'}">
                    <li><a href="#">Home</a></li>
                    <li><a>|</a></li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Sprint<b
                            class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Create Sprint</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Sprint List</a></li>
                        </ul>
                    </li>
                    <li><a>|</a></li>
                    <li><a href="#">View Burndown Chart</a></li>
                    <li><a>|</a></li>
                    <li><a href="#">Assign Sprint</a></li>
                    <li><a>|</a></li>
                    <li><a href="/login">Logout</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="#">Home</a></li>
                    <li><a>|</a></li>
                    <li><a href="#">Effort List</a></li>
                    <li><a>|</a></li>
                    <li><a href="/login">Logout</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>


</div>
