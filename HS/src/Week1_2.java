public class Week1_2 {

    public static void main(String[] args) {
//        1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
//        2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
//        3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
//        3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
//        4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
//        4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
//        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
//        4-3. ')'를 다시 붙입니다.
//        4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
//        4-5. 생성된 문자열을 반환합니다.
        is올바른괄호문자열("()))((()");
        solution("(())((()))()");
    }

    public static String solution(String p) {
        String answer = "";

        for(int i = 2; i < p.length(); i += 2) {
            String u = p.substring(0, i);
            String v = p.substring(i);

            if (is올바른괄호문자열(u)) {
                return u + solution(v);
            } else {
               // "(" + solution(v) + ")";
            }

        }



        return answer;
    }

    public static boolean is균형잡힌괄호문자열(String str) {
        int openCount = 0;
        int closeCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);

            if (s == '(') openCount ++;
            if (s == ')') closeCount ++;
        }

        return openCount == closeCount;
    }

    public static boolean is올바른괄호문자열(String str) {
        int notClosedBracketCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);

            if (s == '(') notClosedBracketCount ++;
            if (s == ')') notClosedBracketCount --;

            if(notClosedBracketCount < 0) return false;
        }

        return true;
    }

}
