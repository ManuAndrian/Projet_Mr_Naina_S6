<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion Étudiants - ETU 3661</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="etudiant.css">
</head>
<body>

<aside class="sidebar">
    <div class="sidebar-header">
        <div class="logo-icon"><i class="fas fa-graduation-cap"></i></div>
        <div class="brand-name">EduManager</div>
    </div>

    <div class="nav-section">
        <div class="nav-label">Menu Principal</div>
        <nav class="nav-menu">
            <a href="demande" class="nav-item">
                <i class="fas fa-sliders-h"></i>
                <span>Demandes</span>
            </a>
            <a href="client" class="nav-item active">
                <i class="fas fa-user-graduate"></i>
                <span>Client</span>
            </a>
        </nav>
    </div>

    <div class="sidebar-footer">
        <div class="user-profile">
            <div class="user-avatar"></div>
            <div class="user-info">
                <span class="user-name">Admin User</span>
                <span class="user-id">ETU 3661</span>
            </div>
        </div>
    </div>
</aside>

<main class="main-content">
    <h1>Tableau de Bord Étudiant</h1>
    
  <!-- FORMULAIRE PARAMETRE -->
    <div class="client-section">
        <h2>Ajouter un Parametre</h2>
        <form action="client" method="post">
            <div>
                <label>Nom</label>
                <input type="text" name="nom" placeholder="Entrer le nom du client" required>
            </div>
            <div>
                <label>Prénom</label>
                <input type="text" name="prenom" placeholder="Entrer le prénom du client" required>
            </div>

            <div>
                <label>Contact</label>
                <input type="text" name="contact" placeholder="Entrer le contact du client" required>
            </div>

            <div>
                <label>Adresse</label>
                <input type="text" name="adresse" placeholder="Entrer l'adresse du client" required>
            </div>
            
            <div>
                <button type="submit">Ajouter Client</button>
            </div>
        </form>
    </div>

    </div>
        
</main>

</body>
</html>