import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SearchBinary {

    public static void main(String[] args) {
        var list = Arrays.asList(1,3,5,6,7,8,10,33,234);
        System.out.println(searchBinary(list, 234, 0, list.size()-1));
    }

    private static boolean searchBinary(List<Integer> array, Integer target,
                                        Integer low, Integer high) {
        int mid = (high + low) / 2;

        if (low > high)
            return false;
        else {
            if (Objects.equals(array.get(mid), target))
                return true;

            if (array.get(mid) < target) {
                return searchBinary(array, target, mid+1 , high);
            }

            if (array.get(mid) > target)
                return searchBinary(array, target, low , mid-1);
        }


        return false;
    }

}
