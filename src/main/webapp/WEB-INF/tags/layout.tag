<%--suppress HtmlUnknownTarget --%>
<%@tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="title" required="true" %>
<%@attribute name="styles" fragment="true" required="false" %>
<%@attribute name="scripts" fragment="true" required="false" %>
<%@variable name-given="contextPath" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>${title}</title>

    <link rel="icon" type="image/x-icon" href="${contextPath}/resources/common/image/favicon.ico"/>
    <link rel="stylesheet" href="${contextPath}/resources/lib/font-awesome/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/lib/bootstrap/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/lib/bootstrap-editable/bootstrap3-editable/css/bootstrap-editable.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/lib/bootstrap-table/dist/bootstrap-table.min.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/lib/metisMenu/dist/metisMenu.min.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/lib/sb-admin/dist/css/sb-admin-2.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/lib/artDialog/css/ui-dialog.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/lib/iconfont/iconfont.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/admin/css/site.css"/>

    <jsp:invoke fragment="styles"/>

    <script type="text/javascript">
        var contextPath = "${contextPath}";
        var loginUrl = "${contextPath}/shop/user/login";
    </script>
</head>
<body>

<div id="wrapper">

    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">

        <div class="navbar-header">
            <a class="navbar-brand" href="${contextPath}/admin">BookStore - demo</a>
        </div>

        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="${contextPath}/admin/user/logout">
                        <i class="fa fa-sign-out fa-fw"></i> 退出</a>
                    </li>
                </ul>
            </li>
        </ul>

        <t:menu contextPath="${contextPath}"/>

    </nav>

    <div id="page-wrapper">
        <jsp:doBody/>
    </div>
</div>

<script src="${contextPath}/resources/lib/jquery/dist/jquery.min.js"></script>
<script src="${contextPath}/resources/lib/form-validator/jquery.form-validator.min.js"></script>
<script src="${contextPath}/resources/lib/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/lib/bootstrap-editable/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
<script src="${contextPath}/resources/lib/bootstrap-table/dist/bootstrap-table.min.js"></script>
<script src="${contextPath}/resources/lib/bootstrap-table/dist/extensions/editable/bootstrap-table-editable.min.js"></script>
<script src="${contextPath}/resources/lib/bootstrap-table/dist/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="${contextPath}/resources/lib/metisMenu/dist/metisMenu.min.js"></script>
<script src="${contextPath}/resources/lib/sb-admin/dist/js/sb-admin-2.js"></script>
<script src="${contextPath}/resources/lib/laydate/laydate.js"></script>
<script src="${contextPath}/resources/lib/artDialog/dist/dialog-min.js"></script>
<script src="${contextPath}/resources/admin/js/site.js"></script>

<jsp:invoke fragment="scripts"/>

</body>
</html>