<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
    <title>修改书籍</title>

    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.0.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <%--更新的语句是根据bookID来查询的, 所以我们要把bookID传过去, 但又不想让用户知道ID 所以用隐藏域 --%>
        <div class="input-group">
           <input type="hidden" class="form-control" aria-describedby="basic-addon1" name="bookID" required value=${book.bookID}>
        </div>

        <div class="input-group">
          <span class="input-group-addon" id="basic-addon1">书籍名称</span>
          <input type="text" class="form-control" aria-describedby="basic-addon1" name="bookName" required value=${book.bookName}>
        </div>
        <div class="input-group">
           <span class="input-group-addon" id="basic-addon1">书籍库存</span>
           <input type="text" class="form-control" aria-describedby="basic-addon1" name="inventory" required value=${book.inventory}>
        </div>
        <div class="input-group">
           <span class="input-group-addon" id="basic-addon1">书籍描述</span>
           <input type="text" class="form-control" aria-describedby="basic-addon1" name="detail" required value=${book.detail}>
        </div>
        <div class="input-group">
           <input type="submit" class="form-control btn btn-primary" value="修改">
        </div>
    </form>
</div>
</body>
</html>
