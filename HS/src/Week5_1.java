import java.util.HashSet;
import java.util.Set;

public class Week5_1 {
    public static void main(String[] args) {

        int[] arr = {3,1,2,4};

        System.out.println(solution(arr));
    }
    public static int solution(int[] nums) {
        int len = nums.length;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        if (set.size() > len / 2) {
            return len / 2;
        } else {
            return set.size();
        }
    }

}
