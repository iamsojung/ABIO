package Feburary;

import java.util.LinkedList;
import java.util.Queue;

public class p문자열압축 {
    public static void main(String[] args) {
        String s = "aabbaccc";
        solution(s);
    }

    static public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        String str = s;
        for (int i = 5; i < s.length()-1; i++) {
            int N = i + 1;

            Queue<String> q = new LinkedList<>();
            for (int j = 0; j < str.length(); j++) {
                if(s.equals(""))
                    break;
                if(s.length()<N){
                    q.add(s.substring(0, s.length()));
                    s = s.substring(s.length());
                }else{
                    q.add(s.substring(0, N));
                    s = s.substring(N);
                }
            }
            System.out.println(q.size());

            String tmp = q.poll();
            boolean flag = false;
            int cnt = 1;
            StringBuilder sb = new StringBuilder();
            String tmp1 = q.peek();
            if(!tmp.equals(tmp1)){
                sb.append(tmp);
            }
            while (!q.isEmpty()){
                tmp1 = q.poll();
                if(tmp.equals(tmp1)){
                    if(flag){
                        cnt++;
                    }else{
                        cnt = 2;
                        flag = true;
                        if(q.isEmpty()){
                            if(cnt>1){
                                int t = sb.indexOf(tmp);
                                sb.delete(t-1,t+tmp.length()-1);
                                System.out.println(sb.toString());
                                sb.append(cnt+tmp);

                            }else{
                                sb.append(tmp1);
                            }
                        }
                    }
                }else{
                    System.out.println(cnt +" "+tmp +" "+tmp1);
                    if(cnt>1){
                        sb.append(cnt+tmp);
                        sb.append(tmp1);
                    }else{
                        sb.append(tmp1);
                    }
                    cnt = 0;
                    flag = false;
                }
                tmp = tmp1;
            }

            System.out.println(sb.toString());
            System.out.println("길이 : "+sb.length());
            answer = Math.min(sb.length(),answer);
            s = str;
        }
        System.out.println("정답"+answer);

        return answer;
    }

}
