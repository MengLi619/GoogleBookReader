<%--suppress HtmlUnknownTarget --%>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ attribute name="entityName" required="true" %>

<sf:form modelAttribute="${entityName}" role="form" cssClass="validate">
    <jsp:doBody />
</sf:form>