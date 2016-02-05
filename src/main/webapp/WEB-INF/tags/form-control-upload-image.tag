<%--suppress HtmlUnknownTarget --%>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ attribute name="path" required="true" %>
<%@ attribute name="label" %>
<%@ attribute name="required" %>

<c:set var="required" value="${empty required ? false : required}"/>

<div class="form-group <c:if test="${required}">required</c:if>">
    <label for="${path}">${label}</label>

    <div class="row">
        <div class="col-lg-8">
            <spring:bind path="${path}">
                <input type="text"
                       id="${path}"
                       name="${status.expression}"
                       value="${status.value}"
                        <c:if test="${required}">
                            data-validation="required"
                            data-validation-error-msg="请填写${label}"
                        </c:if> />
            </spring:bind>
        </div>
    </div>
</div>