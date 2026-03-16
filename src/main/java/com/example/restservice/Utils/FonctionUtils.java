package com.example.restservice.Utils;

import java.util.List;

import com.example.restservice.entity.Parametre;

public class FonctionUtils {

    public static double[] ajouterElement(double[] tableau, double nouvelElement) {

    if (tableau == null) {
        return new double[]{nouvelElement};
    }
    
    int nouvelleTaille = tableau.length + 1;
    double[] nouveauTableau = new double[nouvelleTaille];
    
    for (int i = 0; i < tableau.length; i++) {
        nouveauTableau[i] = tableau[i];
    }

    nouveauTableau[nouveauTableau.length - 1] = nouvelElement;
    
    return nouveauTableau;
}

  public static Parametre compareMin(List<Parametre> parametres) {
    
    // Vérification
    if (parametres == null || parametres.isEmpty()) {
        throw new IllegalArgumentException("La liste de paramètres ne peut pas être null ou vide");
    }

    Parametre minParam = parametres.get(0);

    for (int i = 1; i < parametres.size(); i++) {
        Parametre courant = parametres.get(i);
        if (courant.getValeur().doubleValue() < minParam.getValeur().doubleValue()) {
            minParam = courant;
        }
    }
    return minParam;
}
    }
