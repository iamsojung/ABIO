// programmers.조이스틱
// 다른 사람 풀이 참고는 했으나 소스 수정은 안함
public class Week3_2 {
    public static void main(String[] args) {
        solution("JEROEN"); // 56
        solution("JAN"); // 23
        solution("JAZ");

    }
    public static int solution(String name) {
        int answer = 0;
        char[] nameCharArr = name.toCharArray();
        // 아스키코드 : 65 ~ 90
        // 초기글자 A (65)
        // 77.5가 중간.
        for(int i = 0; i < nameCharArr.length; i ++) {
            int ascii = (int)nameCharArr[i];
            int count;
            if (ascii <= 78) {
                // 위로 조작하는 갯수
                count = ascii - 65;
            } else {
                count = 90 - ascii + 1;
            }
//            // A면 건너뜀
//            if (ascii == 65) {
//                count = count - 1;
//            }
            answer += count;
        }
        // 양옆 이동 갯수 구하기
        answer += nameCharArr.length - 1;
        return answer;
    }

    public static int getMoveCount(char[] charArr) {
//        str = "JAZ";//+13+1+1  // AAZ +1+1 // BAAAZ // BBAAAAAZ
        int count = 0;
        int visit = 1;


        return 0;
    }
}
