import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        boolean check = false;

        Arrays.sort(citations);

        for(int i = 0; i < citations.length; i++) {
            if(citations[i] > citations.length - i){
                if(check == true) {
                    return answer;
                } else {
                    return citations.length - i;
                }

            } else if(answer != citations[i] && citations[i] == citations.length - i) {
                check = true;
                answer = citations[i];
            }
        }

        return answer;
    }
}