import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int solution(String s) {
        int result = s.length();

        if (s.length() == 1) {
            return 1;
        }

        for (int i = 1; i <= s.length() / 2; i++) {
            int count = 1;

            String words = new String();

            String word1 = s.substring(0, i);

            for (int j = i; j <= s.length() - i; j += i) {
                String word2 = s.substring(j, j + i);

                if (word1.equals(word2)) {
                    count++;
                } else {
                    if (count > 1) {
                        words += String.valueOf(count);
                    }
                    words += word1;

                    word1 = s.substring(j, j + i);
                    count = 1;
                }
            }

            if (count > 1) {
                words += String.valueOf(count);
            }
            words += word1;

            result = Math.min(result, words.length() + (s.length() % i));
        }

        return result;
    }

    public static void main(String[] args) {
        int answer = solution("aabbaccc");
        System.out.println(answer);
    }

    // public static int solution(String s) {
    // int answer = s.length();
    //
    // for (int i = 1; i <= 1; i++) {
    // int count = 0;
    //
    // String words = s;
    //
    // while (true) {
    // if(words.length() < i) {
    // count += words.length();
    // break;
    // }
    //
    // String word = s.substring(0, i);
    //
    // int repeat = 0;
    // int index = 0;
    //
    // while(true) {
    // if(word.equals(words.substring(index, index + i))) {
    // words = words.substring(i);
    // repeat += 1;
    // } else {
    // words = words.substring(i);
    // break;
    // }
    //
    // index += i;
    // }
    //
    // if(repeat > 1) {
    // count += repeat;
    // } else {
    // count += i;
    // }
    // }
    // }
    //
    // return answer;
    // }

    // public static int solution(String s) {
    // int answer = s.length();
    //
    // for (int i = 1; i <= 1; i++) {
    // HashMap<String, Integer> words = new HashMap<>();
    //
    // int count = 0;
    //
    // for (int j = 0; j < s.length(); j += i) {
    // if(j + i <= s.length()) {
    // String word = s.substring(j, j + i);
    //
    // words.put(word, words.containsKey(word) ? words.get(word) + 1 : 1);
    // } else {
    // count += s.length() - j;
    // }
    // }
    //
    // for (Map.Entry<String, Integer> entry: words.entrySet()) {
    // if(entry.getValue() == 1) {
    // count += entry.getKey().length();
    // } else {
    // count += entry.getValue();
    // }
    // }
    //
    // if(answer > count) {
    // answer = count;
    // }
    // }
    //
    // return answer;
    // }

}