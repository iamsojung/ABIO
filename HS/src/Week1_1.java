import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Week1_1 {


    public static void main(String[] args) {
//"aabbaccc"	7
//"ababcdcdababcdcd"	9
//"abcabcdede"	8
//"abcabcabcabcdededededede"	14
//"xababcdcdababcdcd"	17
        // 2a2ba2cc
        System.out.println(solution("aabbaccc"));
    }
    public static int solution(String s) {

        int answer = s.length();
        int halfLen = s.length() / 2; // 묶을수있는 최대값

        for (int i = 1; i <= halfLen; i++) {
            int zipLevel = 1; // 특정문자열이 몇개씩 압축되나
            String zipStr = s.substring(0, i); // 압축되든 말든 앞 문자는 다 잘라낼거라 항상 0부터 시작함.
            StringBuffer result = new StringBuffer();

            for (int j = i; j <= s.length(); j = j + i) {
                String next = s.substring(j, i+j > s.length() ? s.length() : i+j);
                if (zipStr.equals(next)) {
                    zipLevel++; // 몇개씩 압축되는지 저장
                } else {
                    result.append((zipLevel == 1 ? "" : zipLevel)+zipStr);
                    zipStr = next;
                    zipLevel = 1;
                }
            }
            result.append(zipStr);
            answer = Math.min(answer, result.length()); // 가장 작은 문자열 길이 저장
        }

        return answer;
    }

//    public static boolean isEqualNext(String origin, int targetLen, int startIndex) {
//
//        String targetString = origin.substring(startIndex, startIndex + targetLen);
//
//        System.out.println(targetString);
//        return targetString.equals(origin.substring(startIndex + targetLen, startIndex + targetLen + targetLen));
//    }



}
