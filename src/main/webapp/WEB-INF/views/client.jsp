<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion Forage - ETU 3661</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="etudiant.css">

</head>
<body>

<jsp:include page="/WEB-INF/views/fragments/navbar.jsp" />


<main class="main-content">

    <h1>Tableau de Bord Étudiant</h1>
  <!-- FORMULAIRE PARAMETRE -->
    <div class="client-section">
        <h2>Ajouter un Parametre</h2>
        <form action="/api/clients" method="post">
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
        <c:if test="${not empty message}">
    <div class="success-message">${message}</div>

</c:if>
    </div>
        </div>
</main>
</body>
</html>