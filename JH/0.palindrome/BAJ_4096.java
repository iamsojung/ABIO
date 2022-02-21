import java.util.Scanner;

public class BAJ_4096 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true){
            String value = sc.nextLine();
            int intValue = Integer.parseInt(value);
    
            int cnt = 0;
            if(value.equals("0")) break;
            
            while(isCheck(value)){
                intValue++;
                cnt++;
                
                int sizeGap = value.toString().length() - Integer.toString(intValue).length();
                value = addZero(intValue,sizeGap);
            }
            System.out.println(cnt);
        }
    }

    // public static boolean isCheck(String value){
    //     StringBuffer str = new StringBuffer(value);
    //     if(value.equals(str.reverse().toString())){
    //         return false;
    //     }else{
    //         return true;
    //     }
    // }
    public static boolean isCheck(String value){
        for (int i = 0; i < value.length()/2; i++) {
            if(value.charAt(i) != value.charAt(value.length()-i-1)){
                return false;
            }
        }
        return true;
    }   

    public static String addZero(int intValue, int sizeGap){
        String addZeroValue = Integer.toString(intValue);
        for(var i=0; i<sizeGap; i++){
           addZeroValue = "0" + addZeroValue;
        }
        return addZeroValue;

    }
}
