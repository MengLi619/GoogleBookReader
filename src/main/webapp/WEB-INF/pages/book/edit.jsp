<%@page language="java" contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%--@elvariable id="book" type="com.xiaoheifamily.bookstore.model.Book"--%>

<c:set var="title" value="${book.new ? '上传图书' : '编辑图书'}"/>

<t:edit-layout title="${title}">
    
    <t:edit-form entityName="book">

        <sf:hidden path="id"/>

        <t:form-control-text path="title" label="标题" />
        <t:form-control-text path="author" label="作者" />
        <t:form-control-upload-image path="" label="上传图片" />
        <t:form-control-text path="price" label="单价" />
        <t:form-control-editor path="description" label="商品说明" />

        <div class="submit-buttons clearfix">
            <button type="submit" class="btn btn-primary">
                保存
            </button>
        </div>
    </t:edit-form>
    
</t:edit-layout>