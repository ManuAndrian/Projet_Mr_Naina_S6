<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion Demandes - ETU 3661</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="/etudiant.css">
</head>
<body>

<jsp:include page="/WEB-INF/views/fragments/navbar.jsp" />

<main class="main-content">
    <h1>Tableau de Bord Demandes</h1>
<!-- FORMULAIRE DEMANDE -->
<form action="/demande/create" method="post">
    <div>
        <label>Client</label>
        <select name="client.idClient" required>
            <option value="">-- Sélectionner un client --</option>
            <c:forEach var="client" items="${clients}">
                <option value="${client.idClient}">${client.nom} ${client.contact}</option>
            </c:forEach>
        </select>
    </div>  
    <div>
        <label>Lieu</label>
        <input type="text" name="lieu" placeholder="Entrer le lieu de la demande" required>
    </div>

    <div>
        <label>District</label>
        <input type="text" name="district" placeholder="Entrer le district" required>
    </div>
    <div class="btn-demande">
        <button type="submit">Créer Demande</button>
    </div>
</form>

<!-- Message succès -->
<c:if test="${not empty message}">
    <div class="success-message">${message}</div>
</c:if>

<c:if test="${not empty demandes}">
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
                    <th>Statut</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="demande" items="${demandes}">
                    <tr>
                        <td>${demande.idDemande}</td>
                        <td>${demande.client.nom}</td>
                        <td>${demande.dateDemande}</td>
                        <td>${demande.lieu}</td>
                        <td>${demande.district}</td>
                        <td>
                            <c:forEach var="ds" items="${demande.demandeStatuts}">
                                <span class="badge-statut">${ds.statut.statut}</span>
                            </c:forEach>
                        </td>
                        <td>
                            <a href="/demande/edit/${demande.idDemande}" class="btn-edit" title="Modifier">
                                <i class="fas fa-edit"></i>
                            </a>
                            <a href="/demande/delete/${demande.idDemande}" class="btn-delete" onclick="return confirm('Supprimer cette demande ?')" title="Supprimer">
                                <i class="fas fa-trash"></i>
                            </a>
                        </td>       
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>

<c:if test="${empty demandes}">
    <div style="text-align: center; color: #94a3b8; margin-top: 20px;">
        <i class="fas fa-folder-open" style="font-size: 2rem; display: block; margin-bottom: 10px;"></i>
        <p>Aucune demande enregistrée pour le moment.</p>
    </div>
</c:if>
</main>

</body>
</html>
