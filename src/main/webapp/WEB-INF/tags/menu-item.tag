<%@tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="title" required="true" %>
<%@attribute name="href" required="true" %>
<%@attribute name="level" type="java.lang.Integer" required="true" %>
<%@attribute name="hasSubMenu" type="java.lang.Boolean" required="true" %>
<%@attribute name="iconClass" %>

<c:choose>
    <c:when test="${level eq 0}">
        <c:set var="levelClass" value="nav-second-level" />
    </c:when>
    <c:when test="${level eq 1}">
        <c:set var="levelClass" value="nav-third-level" />
    </c:when>
    <c:otherwise>
        <c:set var="levelClass" value="" />
    </c:otherwise>
</c:choose>

<li>
    <a class="${iconClass}" href="${href}">
        ${title}
        <c:if test="${hasSubMenu}"><span class="fa arrow"></span></c:if>
    </a>
    <c:if test="${hasSubMenu}">
        <ul class="nav ${levelClass}">
            <jsp:doBody />
        </ul>
    </c:if>
</li>