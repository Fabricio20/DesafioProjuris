package br.com.projuris;

public class MyFindChar implements FindCharachter {

    @Override
    public char findChar(String word) {
        if (word == null)
            return ' ';
        String wordLowercase = word.toLowerCase();
        // Cria um map com o count de caracteres, ordenado por caractere, suporta unicode.
        int[] map = new int[2048];
        for (int i = 0; i < word.length(); i++) {
            map[wordLowercase.charAt(i)]++;
        }
        // Encontra o primeiro caractere que é unico.
        for (int i = 0; i < word.length(); i++) {
            if (map[wordLowercase.charAt(i)] == 1) {
                return word.charAt(i);
            }
        }
        return ' ';
    }

}