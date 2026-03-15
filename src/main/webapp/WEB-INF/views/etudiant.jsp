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
            <a href="parametre.jsp" class="nav-item">
                <i class="fas fa-sliders-h"></i>
                <span>Configuration</span>
            </a>
            <a href="etudiant.jsp" class="nav-item active">
                <i class="fas fa-user-graduate"></i>
                <span>Étudiants & Notes</span>
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

    <div class="card form-section">
    <h2><i class="fas fa-user-graduate"></i> Sélectionner Étudiant et Matière</h2>
    <form action="finalNote" method="get"> <!-- le controller qui calcule la note finale -->
        
        <!-- Liste déroulante Étudiant -->
        <div class="form-group">
            <label>Nom de l'étudiant</label>
            <select name="candidatId" required>
                <option value="">-- Sélectionner un étudiant --</option>
                <c:forEach items="${etudiants}" var="e">
                    <option value="${e.id}">${e.nom} ${e.prenom}</option>
                </c:forEach>
            </select>
        </div>

        <!-- Liste déroulante Matière -->
        <div class="form-group">
            <label>Intitulé de la matière</label>
            <select name="matiereId" required>
                <option value="">-- Sélectionner une matière --</option>
                <c:forEach items="${matieres}" var="m">
                    <option value="${m.id}">${m.nomMatiere}</option>
                </c:forEach>
            </select>
        </div>

        <!-- Bouton de validation -->
        <button type="submit" class="btn-primary">
            <i class="fas fa-calculator"></i> Calculer Note Finale
        </button>
    </form>
</div>

        <div class="card final-note-card">
            <div class="note-content">
                <div class="note-icon">
                    <i class="fas fa-award"></i>
                </div>
                <div class="note-info">
                    <h2>Note Finale Globale</h2>
                    <p class="student-name">Résultat pour : <span>Cette eleve</span></p>
                    <div class="score-display">
                        <span class="score-value">${noteFinale}</span>
                        <span class="score-max">/ 20</span>
                    </div>
                </div>
            </div>
            <div class="note-footer">
                <span class="status-tag">Moyenne calculée automatiquement</span>
            </div>
        </div>
    </div>
</main>

</body>
</html>