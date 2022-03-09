import java.util.Arrays;

// programmers.가장 큰 수
public class Week3_1 {
    public static void main(String[] args) {

        int[] arr = {3, 30, 34, 5, 9};

        System.out.println(solution(arr)); // "9534330"
    }

    public static String solution(int[] numbers) {
        String answer = "";

        String[] strArr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        System.out.println(Arrays.toString(strArr));

        // 0 1
        // 1 2
        // 2 3
        // 3 4

        // 0 1
        // 1 2
        // 2 3

        // 0 1
        // 1 2

        // 0 1

        for(int i = 1; i < strArr.length; i++) {
            for(int j = 0; j < strArr.length - i; j++) {
                if (strArr[j].substring(0,1).compareTo(strArr[j+1].substring(0,1)) > 0) {
                    // 앞에꺼가 크면? 앞에꺼를 뒤로.
                    // 앞에꺼 임시저장
                    String temp = strArr[j];
                    strArr[j+1] = strArr[j];
                    strArr[j] = temp;
                } else if (strArr[j].substring(0,1).compareTo(strArr[j+1].substring(0,1)) == 0) {
                    // 두번째 이상 비교해야하는데.. while문으로 해야할듯
//                    strArr[j]

                }

            }
        }

        System.out.println(Arrays.toString(strArr));
        return answer;
    }
}
