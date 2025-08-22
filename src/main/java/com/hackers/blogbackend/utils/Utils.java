package com.hackers.blogbackend.utils;

import java.util.Comparator;
import java.util.List;


public class Utils {

    public static String generateUniqueSlug(final String title, final List<String> slugs) {
        // Nettoyer le titre et créer le slug de base
        String baseSlug = title.toLowerCase()
                .replaceAll("[^a-z0-9\\s]", "")
                .replaceAll("\\s+", "-");


        if (slugs.isEmpty()) {
            // Aucun slug existant, on peut utiliser directement le baseSlug
            return baseSlug;
        }

        // Trier les slugs pour récupérer le dernier
        slugs.sort(Comparator.naturalOrder());
        String lastSlug = slugs.get(slugs.size() - 1);

        // Extraire le numéro final
        int lastNumber = 0;
        String[] parts = lastSlug.split("-");
        try {
            lastNumber = Integer.parseInt(parts[parts.length - 1]);
        } catch (NumberFormatException e) {
            lastNumber = 0; // Si le dernier slug n'a pas de numéro
        }

        // Retourner le nouveau slug incrémenté
        return baseSlug + "-" + (lastNumber + 1);
    }

    public static int compterMots(String texte) {
        String[] mots = texte.trim().split("\\s+");
        return mots.length;
    }

    public static String tempsLecture(String texte, int vitesse) {
        int nbMots = compterMots(texte);
        double minutes = (double) nbMots / vitesse;
        int minutesArrondi = (int) Math.round(minutes);
        return "Temps de lecture estimé : " + minutesArrondi + " min";
    }

}
