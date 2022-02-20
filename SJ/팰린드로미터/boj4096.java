import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true){
            int ans = 0;
            String input = br.readLine(); //입력
            int len = input.length(); //숫자 길이
            if(input.equals("0")) //입력 종료
                break;

            while (true){
                if(palindrom(input)){ //팰린드롬인 경우 while 탈출
                    break;
                } else{ //팰린드롬 아닌경우 1씩 증가하면서 확인
                    ans++; //1 증가 횟수 추가
                    int num = Integer.parseInt(input);
                    num++; //1 증가시켜줌

                    input = String.valueOf(num); //문자열로 바꿈
                    while(len > input.length()) input = "0" + input;
                }
            }
            System.out.println(ans);
        }
    }

    private static boolean palindrom(String arr) { //팰린드롬 판별
        for (int i = 0; i < arr.length()/2; i++) {
            if(arr.charAt(i) != arr.charAt(arr.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}

