class Solution {
    public static String solution(String p) {
        if ("".equals(p)) {
            return p;
        }

        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        int left = 0;
        int right = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                left++;
            }
            if (p.charAt(i) == ')') {
                right++;
            }

            if (left == right) {
                u.append(p.substring(0, i + 1));
                v.append(p.substring(i + 1, p.length()));

                break;
            }
        }

        int count = 0;

        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                count++;
            }
            if (u.charAt(i) == ')') {
                count--;
            }

            if (count < 0) {
                StringBuilder str = new StringBuilder();
                str.append("(");
                str.append(solution(v.toString()));
                str.append(")");

                for (int j = 1; j < u.length() - 1; j++) {
                    if (u.charAt(j) == '(') {
                        str.append(')');
                    }
                    if (u.charAt(j) == ')') {
                        str.append('(');
                    }
                }
                return str.toString();
            }
        }

        return u.toString() + solution(v.toString());
    }

    public static void main(String[] args) {
        // String[] strings = new String[] { "(()())()", ")(", "()))((()", ")()(()" };
        //
        // for(String s: strings) {
        // System.out.println(solution(s));
        // }

        System.out.println(solution("()))((()"));
    }

    // public static String solution(String p) {
    // if("".equals(p)) { return p; }
    //
    // int number = 0;
    // int change = 0;
    //
    // for(int i = 0; i < p.length(); i++) {
    // if("(".equals(String.valueOf(p.charAt(i)))) {
    // number++;
    // } else if(")".equals(String.valueOf(p.charAt(i)))) {
    // number--;
    // }
    //
    // if(number < 0) {
    // p = new StringBuffer(p).replace(i, i + 1, "(").toString();
    // number++;
    // change++;
    // } else {
    // if(change > 0) {
    // if(i == p.length() - 1) {
    // p = new StringBuffer(p).replace(i, i + 1, ")").toString();
    // number--;
    // change--;
    // } else {
    // if("(".equals(String.valueOf(p.charAt(i + 1)))) {
    // System.out.println("p: " + p);
    // p = new StringBuffer(p).replace(i, i + 1, ")").toString();
    // number--;
    // change--;
    // }
    // }
    // }
    // }
    // }
    // return p;
    // }
}