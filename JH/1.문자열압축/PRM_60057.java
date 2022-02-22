class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=1; i<s.length()+1; i++){
            String str ="";
            String result = "";
            int cnt = 1;
            for(int j=0; j<=Math.ceil(s.length()/i); j++){
                int k = i*j+i;
                if(k > s.length()){
                    k = s.length();
                }

                if(j==0){
                }else if(str.equals(s.substring(i*j,k))){
                    cnt++;
                }else{
                    if(cnt==1){ 
                        result += str;
                    }else{
                        result += String.valueOf(cnt) + str;
                        
                    }
                    cnt = 1;
                }
                str = s.substring(i*j,k);
            }
            if(answer == 0 || answer > result.length()){
                answer = result.length();
            }
        }
        return answer;
    }
}