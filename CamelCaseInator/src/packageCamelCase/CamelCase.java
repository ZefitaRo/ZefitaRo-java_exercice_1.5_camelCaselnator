package packageCamelCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class CamelCase
{
    public static void main(String[] args) {

        try {
            // Lecture du fichier texte d'entrÃ©e
            File input = new File("exo_text.txt");
            Scanner scanner = new Scanner(input);

            // Création du fichier texte de sortie
            File output = new File("camel2.txt");
            PrintWriter writer = new PrintWriter(output);

            // Parcours des lignes du fichier d'entrée
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String camelCase = toCamelCase(line);

                // Ecriture de la ligne d'origine et sa version camelCase dans le fichier de sortie
                writer.println(line + " -> " + camelCase + ".");
            }

            // Fermeture des flux de lecture et d'écriture
            scanner.close();
            writer.close();

            System.out.println("Conversion terminée. Le résultat est dans le fichier camel2.txt.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Erreur: le fichier exo_text.txt n'a pas été trouvé.");
            e.printStackTrace();
        }
    }

    public static String toCamelCase(String input) {
        String[] words = input.split(" ");
        StringBuilder camelCase = new StringBuilder(words[0].toLowerCase());

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            String capitalized = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            camelCase.append(capitalized);
        }

        return camelCase.toString();
    }
}
