package recursividade;

import java.util.List;
import java.util.Objects;

/**
 * Dados um vetor de inteiros distintos e ordenados de maneira crescente e um inteiro target,
 * crie um algoritmo recursivo que determine se existem dois inteiros no vetor que a soma seja
 * igual a target.
 */
public class HasTwoNumber {
    public static void main(String[] args) {
        System.out.println(hasTwoNumber(List.of(4, 0, 0, 0, 0), 8));
    }

    public static boolean hasTwoNumber(List<Integer> array, Integer target){
        return hasTwoNumber(array, target, 0, 0);
    }


    public static boolean hasTwoNumber(List<Integer> array,
                                       Integer target,
                                       Integer indexNumber1,
                                       Integer indexNumber2){

        if (indexNumber2 != indexNumber1 && (array.get(indexNumber1) + array.get(indexNumber2)) == target){
                return true;
        }

        if (indexNumber1 == array.size()-1 && indexNumber2 == array.size()-1)
            return false;

        if (indexNumber2 == array.size()-1)
            return hasTwoNumber(array, target, ++indexNumber1, 0);
        else {
            return hasTwoNumber(array, target, indexNumber1, ++indexNumber2);
        }

    }

}
