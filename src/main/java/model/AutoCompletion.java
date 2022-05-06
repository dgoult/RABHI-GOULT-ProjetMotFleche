package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AutoCompletion {



    public static ArrayList<String> findWordWithRegex(String regex) throws IOException {

        ArrayList<String> motsCompatibles = new ArrayList<String>();
        ArrayList<String> everyMots = getWordFromFile();

        for (String unMot : everyMots) {
            if (unMot.matches(regex)) {
                motsCompatibles.add(unMot);
            }
        }
        return motsCompatibles;

    }

    private static ArrayList<String> getWordFromFile() throws IOException {

        ArrayList<String> mots = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader("liste_francais.txt"))) {

            StringBuilder sb = new StringBuilder();
            String line;

            while (br.readLine() != null) {
                mots.add(br.readLine());
            }

        }
        return mots;
    }


}
