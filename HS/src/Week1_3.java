
public class Week1_3 {
    public static void main(String[] args) {
    // numbers	        target	return
    // [1, 1, 1, 1, 1]	3	    5
    // [4, 1, 2, 1]	    4	    2
    // +4+1-2+1 = 4
    // +4-1+2-1 = 4
    // 총 2가지 방법이 있으므로, 2를 return 합니다.

    solution(new int[]{4, 1, 2, 1}, 4);
    }
    public static int solution(int[] numbers, int target) {
//        System.out.println(dfs(numbers, 0, target, 0));
        return dfs(numbers, 0, target, 0);
    }

    public static int dfs(int[] numbers, int depth, int target, int calculate) {

        int result = 0;

        if (depth == numbers.length) {
            if (calculate == target) {
                result += 1;
                return result;
            }
        } else {
            result += dfs(numbers, depth + 1, target, calculate + numbers[depth]);
            result += dfs(numbers, depth + 1, target, calculate - numbers[depth]);
        }

        return result;
    }
}
