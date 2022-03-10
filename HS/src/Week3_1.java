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

        for(int i = 1; i < strArr.length; i++) {
            for(int j = 0; j < strArr.length - i; j++) {
                String front = strArr[j];
                String back = strArr[j+1];
                if (isChange(front, back, 1)) {
                    strArr[j+1] = front;
                    strArr[j] = back;
                }
            }
        }

        answer = Arrays.toString(strArr).replaceAll("[^0-9]","");
        return answer;
    }

    public static boolean isChange(String front, String back, int index) {
        int compareFrontBack = front.substring(index-1, index).compareTo(back.substring(index-1, index));
        if (compareFrontBack < 0) {
            // 앞에꺼가 작으면? 앞에꺼를 뒤로.
            return true;
        } else if (compareFrontBack == 0) {
            // 첫번째가 같을 때. 두번째 이상 비교
            index++;
            while (true) {
                // 앞에꺼 길이가 더 작지만 뒤에꺼와 비교해서 예외처리
                if (front.length() < index && back.length() >= index )  {
                    if (front.substring(index-2, index-1).compareTo(back.substring(index-1, index)) < 0)
                        return true;
                }
                if (front.length() < index) {
                    return false;
                }
                if (back.length() < index) {
                    // 뒤에꺼가 길이가 더 작다면
                    return true;
                } else {
                    // 재귀
                    return isChange(front, back, index);
                }
            }
        }
        return false;
    }

}
