<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Courses | Training Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background: #f4f7fb; }
        .navbar { background: linear-gradient(135deg, #0d6efd, #4f46e5) !important; }
        .course-card { border: 0; border-radius: 1rem; overflow: hidden; }
        .course-card .card-footer { border: 0; }
    </style>
</head>
<body class="bg-light">
<nav class="navbar navbar-dark shadow-sm"><div class="container"><a class="navbar-brand fw-semibold" href="${pageContext.request.contextPath}/dashboard">Training Application</a><a href="${pageContext.request.contextPath}/login" class="btn btn-outline-light btn-sm">Logout</a></div></nav>
<main class="container py-5">
    <div class="d-flex flex-wrap justify-content-between align-items-end gap-3 mb-4">
        <div><p class="text-primary fw-semibold small mb-1">LEARNING CATALOG</p><h1 class="h2 mb-1">Available courses</h1><p class="text-secondary mb-0">Manage the training courses available to your team.</p></div>
        <div class="d-flex gap-2"><a href="${pageContext.request.contextPath}/dashboard" class="btn btn-outline-secondary">Dashboard</a><a href="${pageContext.request.contextPath}/courses/form" class="btn btn-primary">+ Add Course</a></div>
    </div>
    <c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
    <div class="row g-3">
        <c:forEach items="${courses}" var="course">
            <div class="col-md-6 col-lg-4">
                <div class="card course-card shadow-sm h-100">
                    <div class="card-body p-4"><span class="badge text-bg-primary-subtle text-primary mb-3">Course #<c:out value="${course.id}" /></span><h5 class="card-title"><c:out value="${course.courseName}" /></h5><p class="card-text text-secondary mb-0"><c:out value="${course.description}" /></p></div>
                    <div class="card-footer bg-white d-flex justify-content-end gap-2 p-3"><a href="${pageContext.request.contextPath}/courses/form?id=${course.id}" class="btn btn-sm btn-outline-primary">Edit</a><form action="${pageContext.request.contextPath}/courses/delete" method="post" class="d-inline" onsubmit="return confirm('Delete this course?');"><input type="hidden" name="id" value="${course.id}"><button class="btn btn-sm btn-outline-danger">Delete</button></form></div>
                </div>
            </div>
        </c:forEach>
    </div>
    <c:if test="${empty courses}"><div class="alert alert-info mt-3">No courses found. Click Add Course to create one.</div></c:if>
</main>
</body>
</html>
