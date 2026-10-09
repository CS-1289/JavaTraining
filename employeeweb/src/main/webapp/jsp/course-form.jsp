<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Course Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>body { background: #f4f7fb; } .card { border: 0; border-radius: 1rem; }</style>
</head>
<body class="bg-light">
<div class="container py-5" style="max-width: 650px;">
    <a class="text-decoration-none" href="${pageContext.request.contextPath}/courses">&larr; Back to courses</a>
    <div class="card shadow-sm mt-3"><div class="card-body p-4">
        <p class="text-primary fw-semibold small mb-1">COURSE MANAGEMENT</p>
        <h1 class="h3 mb-4">${course.id == 0 ? 'Add Course' : 'Edit Course'}</h1>
        <form action="${pageContext.request.contextPath}/courses/save" method="post">
            <input type="hidden" name="id" value="${course.id}">
            <div class="mb-3"><label class="form-label">Course Name</label><input type="text" name="courseName" class="form-control" value="${course.courseName}" required></div>
            <div class="mb-3"><label class="form-label">Description</label><textarea name="description" class="form-control" rows="4">${course.description}</textarea></div>
            <button class="btn btn-primary">Save Course</button><a href="${pageContext.request.contextPath}/courses" class="btn btn-secondary">Cancel</a>
        </form>
    </div></div>
</div>
</body>
</html>
