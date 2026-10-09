<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background: #f4f7fb; }
        .navbar { background: linear-gradient(135deg, #0d6efd, #4f46e5) !important; }
        .profile-card, .sidebar-card { border: 0; border-radius: 1rem; }
    </style>
</head>
<body class="bg-light">
<nav class="navbar navbar-dark shadow-sm">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/dashboard">Training Application</a>
        <span class="text-white">Welcome, ${user.fullName}</span>
    </div>
</nav>
<main class="container py-5">
    <div class="row g-4">
        <div class="col-md-3">
            <div class="card sidebar-card shadow-sm">
                <div class="list-group list-group-flush">
                    <a href="${pageContext.request.contextPath}/dashboard" class="list-group-item list-group-item-action active">Dashboard</a>
                    <a href="${pageContext.request.contextPath}/courses" class="list-group-item list-group-item-action">Courses</a>
                    <a href="${pageContext.request.contextPath}/login" class="list-group-item list-group-item-action text-danger">Logout</a>
                </div>
            </div>
        </div>
        <div class="col-md-9">
            <div class="card profile-card shadow-sm">
                <div class="card-body p-4 p-md-5">
                    <p class="text-primary fw-semibold small mb-1">ACCOUNT OVERVIEW</p>
                    <h1 class="h3">Welcome, ${user.fullName}!</h1>
                    <p class="text-secondary mb-4">You are signed in and ready to manage training courses.</p>
                    <table class="table align-middle mb-0">
                        <tr><th>Name</th><td>${user.fullName}</td></tr>
                        <tr><th>Email</th><td>${user.email}</td></tr>
                        <tr><th>Role</th><td><span class="badge bg-success">${user.role}</span></td></tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>
</body>
</html>
