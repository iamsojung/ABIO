import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Week0_3 {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String input = br.readLine();
            if ("0".equals(input)) break;

            // 팰린드롬 구하기
            int[] palindromeArr = makePalindrome(input);
            // 구한 팰린드롬 형변환
            String stringPalindrome = Arrays.toString(palindromeArr).replaceAll("[^0-9]","");
            // 입력숫자구문 형변환
            int intPalindrome = Integer.parseInt(stringPalindrome);
            // 팰린드롬 - 입력숫자
            bw.write((intPalindrome - Integer.parseInt(input)) + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static int[] makePalindrome(String input) {

        int len = input.length();
        int halfLen = len / 2;
        int[] intArray = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int i = 0; i < halfLen; i++) {
            int front = intArray[i];
            int back = intArray[len-i-1];
            if (front != back) {
                intArray[len-i-1] = front;
                int numDiff = front - back;
                if (numDiff < 0) {
                    // 더해진 숫자로 10을 넘어갔다면 앞자리도 1씩 올리고 다시 팰린드롬 구하기.
                    recursivePlus(len-i-2, intArray);
                    intArray = makePalindrome(Arrays.toString(intArray).replaceAll("[^0-9]",""));
                }
            }
        }
        return intArray;
    }

    public static int[] recursivePlus(int index, int[] arr) {

        if (index < 0) {
            return arr;
        }

        arr[index] ++;

        if (arr[index] >= 10) {
            arr[index] = 10 - arr[index];
            recursivePlus(index-1, arr);
        }

        return arr;
    }

}
