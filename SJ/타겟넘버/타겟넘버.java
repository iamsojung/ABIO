class Solution {
    static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);

        return answer;
    }
    private static void dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        sum = sum + numbers[index];
        dfs(numbers, target, index + 1, sum);

        sum = sum - numbers[index];

        sum = sum + (-1 * numbers[index]);
        dfs(numbers, target, index + 1, sum);

    }
}