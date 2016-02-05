<%@page language="java" contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout title="商品管理">

    <jsp:attribute name="scripts">
        <script type="text/javascript" src="${contextPath}/resources/dist/js/book.js"></script>
    </jsp:attribute>

    <jsp:body>

        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <div class="content-header">商品管理</div>
                    <div class="content-body">
                        <div class="toolbar">
                            <a class="btn btn-primary" href="${contextPath}/book/add">
                                <i class="fa fa-plus"></i> 发布商品
                            </a>
                        </div>

                        <table data-toggle="table"
                               data-locale="zh-CN"
                               data-url="${contextPath}/book/list"
                               data-toolbar=".toolbar"
                               data-pagination="true"
                               data-side-pagination="server"
                               data-sort-name="lastModifiedDate"
                               data-sort-order="desc"
                               data-query-params="queryParams">

                            <thead>
                            <tr>
                                <th data-field="title" data-sortable="true" data-width="100%">标题</th>
                                <th data-field="author" data-sortable="true" data-width="100px">作者</th>
                                <th data-field="price" data-sortable="true" data-width="100px">单价</th>
                                <th data-width="100px"
                                    data-field="action"
                                    data-align="center"
                                    data-formatter="actionFormatter"
                                    data-events="actionEvents">操作
                                </th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>

    </jsp:body>

</t:layout>