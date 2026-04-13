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
    <div class="demande-form">
    
        <label>Entrer ID demande</label>
       <input type="text" id="demandeId" placeholder="ID demande" required>
        <button id="btnLoad">Charger</button>

            <table id="tableau" class="t" style="display:none;">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Client</th>
                    <th>Lieu</th>
                    <th>District</th>
                </tr>
            </thead>
            <tbody id="tbodyClient">
            </tbody>
        </table>
    </div>  

<!-- FORMULAIRE DEVIS -->
     <div class="devis-form">
        <label>Type</label>
           <select id="typeDevisSelect" required>
            <c:forEach var="type" items="${typeDevis}">
                <option value="${type.idTypeDevis}">${type.type}</option>
            </c:forEach>
        </select>

            <table id="tableau" class="t" style="display:none;">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Client</th>
                    <th>Lieu</th>
                    <th>District</th>
                </tr>
            </thead>
            <tbody id="tbodyClient">
            </tbody>
        </table>

    <div class="demande-list-section">
    <h2><i class="fas fa-shopping-cart"></i> Saisie des Lignes</h2>
    <table id="tab2" class="data-table">
        <thead>
            <tr>
                <th>Libellé</th>
                <th style="width: 200px;">P.U Unitaire</th>
                <th style="width: 150px;">Quantité</th>
                <th style="width: 80px; text-align: center;">Action</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                    <input type="text" name="libelle" placeholder="Ex: Ecran Dell 24\" class="input-table">
                </td>
                <td>
                    <input type="number" name="pu" placeholder="0.00" step="0.01" class="input-table">
                </td>
                <td>
                    <input type="number" name="qte" placeholder="1" class="input-table">
                </td>
                <td style="text-align: center;">
                    <button type="button" class="btn-delete-row" onclick="supprimerLigne(this)" title="Supprimer la ligne">
                        <i class="fas fa-trash-alt"></i>
                    </button>
                </td>
            </tr>
        </tbody>
    </table>
        <div style="margin-bottom: 1rem; float:right; ">
        <button type="button" onclick="ajouterLigne()" class="btn-primary" style="width: auto; padding: 10px 20px;">
            <i class="fas fa-plus"></i> Ajouter une ligne
        </button>
    </div>

    <div style="margin-bottom: 1rem; float:right; margin-right: 10px; border-radius:20px;">
        <button type="button" onclick="sendDataDevisDetails()" class="btn-success" style="width: auto; padding: 10px 20px;">
            <i class="fas fa-save"></i> Enregistrer le Devis
        </button>
</div>
    </div>
    
<!-- Listes de devis -->

<div class="devis-resultat" style="margin-top: 120px; padding: 20px; border: 1px solid #ccc;"></div> 


    <div style="text-align: center; color: #94a3b8; margin-top: 20px; display: flex; flex-direction: column; align-items: center; justify-content: center; min-height: 200px;">
        <h1>Chiffre d'affaire</h1>
        <h3 id="chiffre-affaire" style="text-align:center; color: #2c3e50; font-size: 2.5rem; font-weight: bold; text-shadow: 2px 2px 4px rgba(0,0,0,0.1); background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); -webkit-background-clip: text; -webkit-text-fill-color: transparent; background-clip: text; margin: 20px 0; padding: 10px;">Chargement...</h3>
    </div>

<script>
document.getElementById("btnLoad").addEventListener("click", function () {
    const id = document.getElementById("demandeId").value;
    if(id == ''){
        alert("Veuiller d'abord rentrer une ID");
        return;
    }
    loadDemandes(id);
});


window.onload = function() {
    chargerListeDevis();

};

function loadDemandes(demandeId) {

    fetch('/rest/ajax/' + demandeId)
        .then(response => response.json())
        .then(d => {

            console.log("DATA =", d);

            const table = document.getElementById("tableau");
            const tbody = document.getElementById("tbodyClient");
            table.style.display = "table";
            tbody.innerHTML = 
            "<tr>" +
                "<td>" + d.idClient + "</td>" +
                "<td>" + d.nom + "</td>" +
                "<td>" + d.contact + "</td>" +
                "<td>" + d.adresse + "</td>" +
            "</tr>";
        })
        .catch(err => {
            console.error("[LOAD_DEMANDES_ERROR]", err);
        });
}

function ajouterLigne(){

    const tbody = document.querySelector("#tab2 tbody ");
    const nouvelleLigne = document.createElement("tr");

    nouvelleLigne.innerHTML = `
        <td>
            <input type="text" name="libelle" placeholder="Nouveau libellé" class="input-table">
        </td>
        <td>
            <input type="number" name="pu" placeholder="0.00" step="0.01" class="input-table">
        </td>
        <td>
            <input type="number" name="qte" placeholder="1" class="input-table">
        </td>
        <td style="text-align: center;">
            <button type="button" class="btn-delete-row" onclick="supprimerLigne(this)">
                <i class="fas fa-trash-alt"></i>
            </button>
        </td>
    `;
    tbody.appendChild(nouvelleLigne);
}

function supprimerLigne(bouton) {
    const ligne = bouton.closest('tr');
    if (confirm("Voulez-vous vraiment retirer cette ligne ?")) {

        ligne.style.transition = "all 0.3s ease";
        ligne.style.opacity = "0";
        ligne.style.transform = "translateX(20px)";

        setTimeout(() => {
            ligne.remove();
        }, 300); 
    }
}

function recupererDonne() {

    const lignes = document.querySelectorAll("#tab2 tbody tr");
    const details = [];

    console.log("Nombre de lignes trouvées :", lignes.length);

    lignes.forEach((ligne, index) => {
        const libelleInput = ligne.querySelector('input[name="libelle"]');
        const puInput = ligne.querySelector('input[name="pu"]');
        const qteInput = ligne.querySelector('input[name="qte"]');
        
        // Vérifier si les inputs existent
        if (!libelleInput || !puInput || !qteInput) {
            console.log("Ligne", index, "inputs manquants");
            return;
        }
        
        const libelle = libelleInput.value;
        const pu = puInput.value;
        const quantite = qteInput.value;

        console.log(`Ligne ${index}:`, { libelle, pu, quantite });

        // Accepter les lignes même si le libellé est vide (on peut mettre une valeur par défaut)
        if (libelle.trim() !== "" || pu.trim() !== "" || quantite.trim() !== "") {
            details.push({
                designation: libelle.trim() || `Article ${index + 1}`,
                prixUnitaire: parseFloat(pu) || 0,
                quantite: parseInt(quantite) || 1  
            });
        }
    });

    console.log("Détails collectés :", details);

    const idDemande = document.getElementById("demandeId").value;
    const idTypeDevis = document.getElementById("typeDevisSelect").value;

    return {
        idDemande: parseInt(idDemande),
        idTypeDevis: parseInt(idTypeDevis),
        details: details
    };
}

function minusTenpourcent(prixUnitaire){
    if(prixUnitaire >= 1000000){
        console.log("prixUnitaire est sup à 1000000")
        const reduction = 10 * prixUnitaire / 100;
        return prixUnitaire - reduction;
    }
    return prixUnitaire;
}

function dataWithKnewPrixUnitaire(data){
    data.details.forEach(d => {
        d.prixUnitaire = minusTenpourcent(d.prixUnitaire)
    });
    return data;
}

async function sendDataDevisDetails() {

    const data = recupererDonne();
    const dataModified = dataWithKnewPrixUnitaire(data);

    console.log("DATA ENVOYÉE =", JSON.stringify(dataModified, null, 2));

    // Validation
    if (!dataModified.idDemande) {
        alert("Veuillez charger une demande d'abord.");
        return;
    }
    if (!dataModified.idTypeDevis) {
        alert("Veuillez sélectionner un type de devis.");
        return;
    }
    if (dataModified.details.length === 0) {
        alert("Veuillez ajouter au moins une ligne.");
        return;
    }

    try {
        const response = await fetch('ajax/devis', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(dataModified)
        });

        if (response.ok) {
            const resultat = await response.text();
            alert("Bravo ! Les données ont été enregistrées.");
            document.querySelectorAll("input").forEach(input => input.value = "");
            console.log("Retour du serveur :", resultat);
        } else {
            alert("Erreur serveur : " + response.status);
        }
    } catch (error) {
        console.error("Erreur de connexion AJAX :", error);
    }

}

function afficherDevis(devisList) {

  console.log("DATA =", devisList);

    const devis = {type: "Forage", dateDevis: "2026-03-30", montantTotal: null};
    const html = `<p>Type: ${devis.type || 'N/A'}</p><p>Date: ${devis.dateDevis || 'N/A'}</p>`;
    console.log(html);

    let container = document.querySelector(".devis-resultat");
    container.innerHTML = "";
  
    if (devisList.length === 0) {
    container.innerHTML = "<p style='color: red;'>Aucun devis disponible</p>";
    return;
}

    devisList.forEach(devis => {
        const type = devis.type ? devis.type : 'N/A';
        const date = devis.dateDevis ? devis.dateDevis : 'N/A';
        
        let montant = devis.montantTotal;
        if (!montant && devis.details && devis.details.length > 0) {
            montant = devis.details.reduce((total, detail) => {
                const prixUnitaire = parseFloat(detail.prixUnitaire) || 0;
                const quantite = parseInt(detail.quantite) || 0;
                return total + (prixUnitaire * quantite);
            }, 0);
        }
        
        const montantFormate = montant ? montant.toLocaleString('fr-FR') + ' Ar' : '0.00 Ar';
         
        console.log("DEBUG - type:", type, "date:", date, "montant:", montant);
        
        let html = '<div>' +
            '<h3>Devis ' + devis.idDevis + '</h3>' +
            '<p>Type: ' + type + '</p>' +
            '<p>Date: ' + date + '</p>' +
            '<p>Montant: ' + montantFormate + '</p>' +
            '<table border="1">' +
                '<tr>' +
                    '<th>Description</th>' +
                    '<th>Prix Unitaire</th>' +
                    '<th>Quantité</th>' +
                    '<th>Total Ligne</th>' +
                '</tr>';

        if (devis.details && devis.details.length > 0) {
            devis.details.forEach(d => {
                const totalLigne = (parseFloat(d.prixUnitaire) * parseInt(d.quantite)).toLocaleString('fr-FR') + ' Ar';
                html += '<tr>' +
                    '<td>' + (d.designation || 'N/A') + '</td>' +
                    '<td>' + (parseFloat(d.prixUnitaire).toLocaleString('fr-FR') + ' Ar' || '0 Ar') + '</td>' +
                    '<td>' + (d.quantite || '0') + '</td>' +
                    '<td><strong>' + totalLigne + '</strong></td>' +
                '</tr>';
            });
        } else {
            html += '<tr>' +
            '<td colspan="4" style="text-align: center;">Aucun détail disponible</td>' +
        '</tr>';
        }

        html += '</table></div>';

        container.innerHTML += html;
    });
}

function chargerListeDevis(){
    
    fetch('ajax/liste-details')
    .then(response => response.json())
    .then(data => {
        console.log("Données reçues :", data);
        console.log("Type du premier devis :", data[0]?.type);
        console.log("Date du premier devis :", data[0]?.dateDevis);
        
        if (!data || data.length === 0) {
            console.log("Liste vide");
            return;
        }

        afficherDevis(data);
        console.log("Liste des devis chargée :", data);
    })
    .catch(error => console.error("Erreur fetch :", error));
}


function loadChiffreAffaire() {
    fetch('/ajax/chiffre-affaire')
    .then(response => response.json())
    .then(data => {
        console.log("Chiffre d'affaire :", data);
        const element = document.getElementById("chiffre-affaire");
        if (element) {
            if (data !== null && data !== undefined) {
                element.textContent = data.toLocaleString('fr-FR', { 
                    minimumFractionDigits: 1, 
                    maximumFractionDigits: 2
                }) + ' MGA';
            } else {
                element.textContent = '0,00 MGA';
            }
        }
    })
    .catch(error => {
        console.error("Erreur chiffre d'affaire :", error);
        const element = document.getElementById("chiffre-affaire");
        if (element) {
            element.textContent = 'Erreur';
        }
    });
}

document.addEventListener('DOMContentLoaded', function() {
    loadChiffreAffaire();
});
</script>
