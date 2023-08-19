package recursividade;

import java.util.ArrayList;
import java.util.List;

/**
 * Dado um array S não ordenado de inteiros e um inteiro k, crie um algoritmo recursivo para
 * reorganizar os elementos de S tal que todos os elementos menores ou iguais a K apareçam
 * antes do que os elementos maiores.
 */
public class OrganizeArrayForTarget {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(List.of(18, 30, 42, 55, 67, 10, 23, 35, 48,
                60, 73, 85, 98, 15, 28, 40, 53, 65, 78, 5));
        System.out.println(organize(array, 5, 0, array.size()-1));
    }
    public static Object organize(List<Integer> array, Integer target, Integer low, Integer high){

        var element = array.get(low);
        if (low > high)
            return array;
        if (element > target){
            array.remove(element);
            array.add(element);
            return organize(array, target, low, high-1);
        } else {
            return organize(array, target, low+1, high);
        }
    }
}
