//programmers.큰 수 만들기
public class Week3_3 {
    public static void main(String[] args) {
        System.out.println(solution("4177252841", 4));
        // System.out.println(infinite(0,4, 2, 0));
//        System.out.println("1234".charAt(1));
//        System.out.println("1234".charAt(1) - '0');
    }


    public static String solution(String number, int k) {
        //"1924"	    2	"94"
        //"1231234"	    3	"3234"
        //"4177252841"	4	"775841"
        int scope = number.length() - k;
        StringBuffer sb = new StringBuffer();
        int index = 0;
        for (int i = 1; i <= scope; i++) {
            int max = Integer.MIN_VALUE;
            // 각 자리 수를 정하기 위해 정해진 범위를 탐색하는 반복문
            // 현재 문자열의 길이 - (만들어야 하는 자리 수 - 현재 만들고 있는 자리 수)
            for (int j = 0; j < number.length() - (scope - i); j++) {
                if (number.charAt(j) - '0' == 9) {
                    max = 9;
                    index = j;
                    break;
                }
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    index = j;
                }
            }
            sb.append(max);
            number = number.substring(index + 1, number.length());
        }

        return sb.toString();
    }
}
