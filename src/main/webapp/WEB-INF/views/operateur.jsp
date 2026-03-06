<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Planning Flotte Premium - ETU 3661</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<aside class="sidebar">
    <div class="sidebar-header">
        <div class="logo-icon"><i class="fas fa-bolt"></i></div>
        <div class="brand-name">Parametre</div>
    </div>

    <div class="nav-section">
        <div class="nav-label">Menu Principal</div>
        <nav class="nav-menu">
            <a href="/" class="nav-item">
                <i class="fas fa-calendar-check"></i>
                <span>Correcteur</span>
            </a>
            <a href="#" class="nav-item active">
                <i class="fas fa-chart-line"></i>
                <span>Planning Note</span>
            </a>
            <a href="/etudiant" class="nav-item">
                <i class="fas fa-car-side"></i>
                <span>Etudiant</span>
            </a>
        </nav>
    </div>


    <div class="sidebar-footer">
        <div class="user-profile">
            <div class="user-avatar"></div>
            <div style="font-size: 13px;">
                <div style="font-weight: 600;">Admin User</div>
                <div style="color: var(--text-dim); font-size: 11px;">ETU 3661</div>
            </div>
        </div>
    </div>
</aside>



<main class="main-content">

<div class="container">
      
    <div class="resolution-section">

    <h2>Ajouter une Resolution</h2>

    <form action="resolution" method="post">

        <div>
            <label>Nom de la resolution</label>
            <input type="text" name="nom_resolution" placeholder="Ex: Grand, Petit...">
        </div>

        <div>
            <button type="submit">Ajouter Resolution</button>
        </div>
    </form>

</div>

    <h1>Parametre</h1>

    <!-- FORMULAIRE PARAMETRE -->
    <div class="parametre-section">

        <h2>Ajouter un Parametre</h2>

        <form action="parametre" method="post">

            <div>
                <label>Valeur</label>
                <input type="number" step="0.01" name="valeur" placeholder="Entrer la valeur">
            </div>

            <div>
                <label>Matiere</label>
                <select name="id_matiere">
                    <c:forEach items="${matieres}" var="m">
                        <option value="${m.id_matiere}">
                            ${m.nom_matiere}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div>
                <label>Operateur</label>
                <select name="id_operateur">
                    <c:forEach items="${operateurs}" var="o">
                        <option value="${o.id_operateur}">
                            ${o.signe}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div>
                <label>Resolution</label>
                <select name="id_resolution">
                    <c:forEach items="${resolutions}" var="r">
                        <option value="${r.id_resolution}">
                            ${r.nom_resolution}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div>
                <button type="submit">Ajouter Parametre</button>
            </div>
        </form>
    </div>


    <!-- FORMULAIRE OPERATEUR -->
    <div class="operateur-section">

        <h2>Ajouter un Operateur</h2>

        <form action="operateur" method="post">

            <div>
                <label>Signe</label>
                <input type="text" name="signe" placeholder="Ex: >= , <= , =">
            </div>
            <div>
                <button type="submit">Ajouter Operateur</button>
            </div>
        </form>
    </div>
</div>
        
</main>

</body>
</html>