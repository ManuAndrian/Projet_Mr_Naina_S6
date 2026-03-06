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
    <h1>Gestion des Étudiants & Notes</h1>

    <div class="container">
        <div class="card form-section">
            <h2><i class="fas fa-user-plus"></i> Inscription Étudiant</h2>
            <form action="etudiant" method="post">
                <div class="form-group">
                    <label>Nom de l'étudiant</label>
                    <input type="text" name="nom" placeholder="Ex: Jean Dupont" required>
                </div>
                <button type="submit">Enregistrer l'étudiant</button>
            </form>
        </div>

        <div class="card form-section">
            <h2><i class="fas fa-book"></i> Nouvelle Matière</h2>
            <form action="matiere" method="post">
                <div class="form-group">
                    <label>Intitulé de la matière</label>
                    <input type="text" name="nom_matiere" placeholder="Ex: Programmation Java" required>
                </div>
                <button type="submit" class="btn-secondary">Ajouter la matière</button>
            </form>
        </div>

        <div class="card display-section">
            <div class="card-header">
                <h2><i class="fas fa-list-check"></i> Relevé de Notes</h2>
            </div>
            
            <div class="table-container">
                <table>
                    <thead>
                        <tr>
                            <th>Étudiant</th>
                            <th>Matière</th>
                            <th>Note / 20</th>
                            <th>Statut</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>ManuAndria</td>
                            <td>Développement Web</td>
                            <td><span class="note-badge">16.50</span></td>
                            <td><span class="status-badge status-pass">Admis</span></td>
                        </tr>
                        <c:forEach items="${notes}" var="n">
                            <tr>
                                <td>${n.nom_etudiant}</td>
                                <td>${n.nom_matiere}</td>
                                <td><span class="note-badge">${n.valeur}</span></td>
                                <td><span class="status-badge status-pass">Validé</span></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>

</body>
</html>