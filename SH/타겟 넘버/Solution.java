class Solution {
    public static int solution(int[] numbers, int target) {
        twoThings(0, 0, numbers, target);
        return answer;
    }

    public static int answer = 0;

    public static void twoThings(int length, int sum, int[] numbers, int target) {
        if (length == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        twoThings(length + 1, sum - numbers[length], numbers, target);
        twoThings(length + 1, sum + numbers[length], numbers, target);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 4, 1, 2, 1 }, 4));
    }
}