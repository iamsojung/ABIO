import java.util.Scanner;
public class Main {
    static String str;
    public static boolean isPalin(int s, int e){
        if(s >= e) return true;
        else return str.charAt(s) == str.charAt(e) && isPalin(s + 1, e - 1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ans;
        int len;
        while(true){
            str = sc.next();
            if(str.equals("0")) break;
            ans = 0;
            len = str.length();
            while(!isPalin(0, str.length() - 1)){
                str = "" + (Integer.parseInt(str) + 1);
                while(str.length() < len) str = "0" + str;
                ans++;
            }
            System.out.println(ans);
        }
    }
}


// import java.util.Scanner;

// public class BAJ_4096 {
//     static String value;
    
//     public static boolean isCheck(String value){
//         StringBuffer str = new StringBuffer(value);
//         if(value.equals(str.reverse().toString())){
//             return false;
//         }else{
//             return true;
//         }
//     }
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int cnt ;
//         int size;

//         while(true){
//             value = sc.nextLine();
//             if(value.equals("0")) break;

//             size = value.length();
//             cnt = 0;

            
//             while(isCheck(value)){
//                 value = "" + (Integer.parseInt(value) + 1);
//                 while(value.length()< size) value = "0" + value;
//                 cnt++;
//             }
//             System.out.println(cnt);
//         }
//     }
// }
