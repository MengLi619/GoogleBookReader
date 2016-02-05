<%--suppress HtmlUnknownTarget --%>
<%@tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@attribute name="title" required="true" %>
<%@attribute name="styles" fragment="true" required="false" %>
<%@attribute name="scripts" fragment="true" required="false" %>
<%@variable name-given="contextPath" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<t:layout title="${title}">

    <jsp:attribute name="scripts">
        <script src="${contextPath}/resources/lib/ueditor/ueditor.config.js"></script>
        <script src="${contextPath}/resources/lib/ueditor/ueditor.all.js"></script>
    </jsp:attribute>

    <jsp:body>

        <div class="container-fluid">

            <div class="row content-header">
                <div class="col-md-12">
                    <div>${title}</div>
                </div>
            </div>

            <div class="row content-body">

                <div class="col-md-12">

                </div>
            </div>

        </div>

    </jsp:body>

</t:layout>