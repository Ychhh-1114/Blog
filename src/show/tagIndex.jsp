<%--
  Created by IntelliJ IDEA.
  User: Y_ch
  Date: 2022/4/20
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="http://cdn.bootcss.com/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="http://localhost:8080/show/css/main.css">
    <title>ychhh_blog</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
</head>
<body>
<div class="side-bar">
    <div class="header">
        <a href="/show/index.html" class="logo">ychhh_</a>
        <div class="intro">拼搏百日，我上北邮！</div>
    </div>
    <div class="nav">
        <a href="http://localhost:8080/show/aboutme.html" class="item">关于我</a>
        <a href="http://localhost:8080/show/pay.html" class="item">打我😄</a>
    </div>
    <div class="tag-list">
        <a href="http://localhost:8080/articles/web" class="item">👉 Web </a>
        <a href="http://localhost:8080/articles/java" class="item">👉 Java </a>
        <a href="http://localhost:8080/articles/python" class="item">👉 Python </a>
        <a href="http://localhost:8080/articles/design" class="item">👉 设计模式 </a>
        <a href="http://localhost:8080/articles/person" class="item">👉 个人心得 </a>
    </div>
</div>


<div class="main">
    <div class="article" style="background-color: grey">
      <c:forEach items="${requestScope.list}" var="article" varStatus="id">
          <a href="http://localhost:8080/articles/page/${article.id}" class="title">${article.title}</a>
          <div class="status">发布于：${article.createDate} || 标签：${article.tagName}</div>
          <div class="content">
                  ${article.summary}
          </div>
      </c:forEach>
        </div>
    </div>
</div>



</body>
</html>
