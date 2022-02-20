import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BAJ_4096 {
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String value = bf.toString();
        int intValue = Integer.parseInt(value);
    
        int cnt = 0;

        while(isCheck(value)){
            intValue++;
            cnt++;

            int sizeGap = value.toString().length() - Integer.toString(intValue).length();
            value = addZero(intValue,sizeGap);
        }
        System.out.println(value);
        System.out.println(cnt);
    }
    public static boolean isCheck(String value){
        StringBuffer str = new StringBuffer(value);
        if(value.equals(str.reverse().toString())){
            return false;
        }else{
            return true;
        }
    }

    public static String addZero(int intValue, int sizeGap){
        String addZeroValue = Integer.toString(intValue);
        for(var i=0; i<sizeGap; i++){
           addZeroValue = "0" + addZeroValue;
        }
        return addZeroValue;

    }
}
