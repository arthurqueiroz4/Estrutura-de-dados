package recursividade;

/**
 * Crie uma função recursiva que determina se uma string s tem  mais vogais do que consoantes
 */
public class HasMoreVowel {
    public static void main(String[] args) {
        System.out.println(hasMoreVowel("ColoqueStringAqui", 0, 0));
    }

    public static boolean hasMoreVowel(String word, Integer countVowel, Integer countConsonant){
        if (word.isEmpty()){
            return countVowel > countConsonant;
        } else {
            Character firstChar = word.charAt(0);

            if ("aeiou".contains(firstChar.toString().toLowerCase())){
                return hasMoreVowel(word.substring(1), ++countVowel, countConsonant);
            } else {
                return hasMoreVowel(word.substring(1), countVowel, ++countConsonant);
            }
        }
    }
}
