<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- 引入jstl -->
<%@include file="common/tag.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%@include file="common/head.jsp" %>
</head>
<body>
<!-- 页面显示部分 -->
<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading text-center">
			<h2>秒杀列表</h2>
		</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>名称</th>
						<th>库存</th>
						<th>开始时间</th>
						<th>结束时间</th>
						<th>创建时间</th>
						<th>详情页</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="sk" items="${list }">
						<tr>
							<td>${sk.name }</td>
							<td>${sk.number }</td>
							<td>
								<fmt:formatDate value="${sk.startTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
							</td>
							<td>
								<fmt:formatDate value="${sk.endTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
							</td>
							<td>
								<fmt:formatDate value="${sk.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
							</td>
							<td>
								<a class="btn btn-info" href="${pageContext.request.contextPath }/seckill/${sk.seckillId }/detail" target="_blank">link</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>