<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion Demandes - ETU 3661</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="index.css">
</head>
<body>

<jsp:include page="/WEB-INF/views/fragments/navbar.jsp" />

<main class="main-content">
    <h1>Bienvenue sur l'application</h1>
    <p>Sélectionnez une action rapide pour commencer :</p>
    
    <div class="dashboard-grid">
    <a href="/demande" class="big-button btn-demande">
        <div class="icon-circle"><i class="fas fa-file-signature"></i></div>
        <span class="label">Demande</span>
    </a>

    <a href="/devis" class="big-button btn-ajouter">
        <div class="icon-circle"><i class="fas fa-user-plus"></i></div>
        <span class="label">Devis</span>
    </a>

    <a href="/client" class="big-button btn-client">
        <div class="icon-circle"><i class="fas fa-users-cog"></i></div>
        <span class="label">Client</span>
    </a>
</div>
</main>

</body>
</html>
