<%@tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="contextPath" required="true" %>

<div class="navbar-default sidebar" role="navigation">

    <div class="sidebar-nav navbar-collapse">

        <ul class="nav" id="side-menu">

            <t:menu-item title="上传图书〉"
                         href="${contextPath}/book/add"
                         level="0"
                         hasSubMenu="false"
                         iconClass="fa fa-book"/>

            <t:menu-item title="我的图书〉"
                         href="${contextPath}/book"
                         level="0"
                         hasSubMenu="false"
                         iconClass="fa fa-cloud"/>

        </ul>
    </div>
</div>