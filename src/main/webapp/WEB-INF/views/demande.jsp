<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion Demandes - ETU 3661</title>
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
            <a href="client.jsp" class="nav-item">
                <i class="fas fa-users"></i>
                <span>Clients</span>
            </a>
            <a href="demande.jsp" class="nav-item active">
                <i class="fas fa-clipboard-list"></i>
                <span>Demandes</span>
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
    <h1>Tableau de Bord Demandes</h1>
    
    <!-- FORMULAIRE DEMANDE -->
    <div class="demande-section">
        <h2>Ajouter une Demande</h2>
        <form action="demande" method="post">
            <div>
                <label>ID Client</label>
                <input type="number" name="id_client" placeholder="Entrer l'ID du client" required>
            </div>
            <div>
                <label>Date Demande</label>
                <input type="date" name="date_demande" required>
            </div>
            <div>
                <label>Lieu</label>
                <input type="text" name="lieu" placeholder="Entrer le lieu de la demande" required>
            </div>
            <div>
                <label>District</label>
                <input type="text" name="district" placeholder="Entrer le district" required>
            </div>
            
            <div>
                <button type="submit">Ajouter Demande</button>
            </div>
        </form>
    </div>

    <!-- LISTE DES DEMANDES -->
    <div class="demande-list-section">
        <h2>Liste des Demandes</h2>
        <table class="data-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Client</th>
                    <th>Date Demande</th>
                    <th>Lieu</th>
                    <th>District</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty demandes}">
                    <c:forEach var="demande" items="${demandes}">
                        <tr>
                            <td>${demande.idDemande}</td>
                            <td>${demande.client.nom}</td>
                            <td>${demande.dateDemande}</td>
                            <td>${demande.lieu}</td>
                            <td>${demande.district}</td>
                            <td>
                                <a href="demande/edit/${demande.idDemande}" class="btn-edit">
                                    <i class="fas fa-edit"></i>
                                </a>
                                <a href="demande/delete/${demande.idDemande}" class="btn-delete">
                                    <i class="fas fa-trash"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty demandes}">
                    <tr>
                        <td colspan="6" style="text-align: center;">Aucune demande trouvée</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>

    <!-- RECHERCHE -->
    <div class="search-section">
        <h2>Rechercher des Demandes</h2>
        <form action="demande/search" method="get">
            <div>
                <label>Par Client ID:</label>
                <input type="number" name="clientId" placeholder="ID Client">
            </div>
            <div>
                <label>Par Lieu:</label>
                <input type="text" name="lieu" placeholder="Lieu">
            </div>
            <div>
                <label>Par District:</label>
                <input type="text" name="district" placeholder="District">
            </div>
            <div>
                <button type="submit">Rechercher</button>
            </div>
        </form>
    </div>
        
</main>

</body>
</html>
