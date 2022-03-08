import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// leetCode.937.Reorder Data in Log Files
public class Week2_3 {
    public static void main(String[] args) {
// 풀이 실패!
//        List<String> list = new ArrayList<>(Arrays.asList("dd", "bb", "cc"));
//        list.sort((o1, o2) -> o1. < o2);
        System.out.println("8".compareTo("a"));
        System.out.println("own".compareTo("8"));
        // 8 1 5 2 3
        // 1 8 5 2 3
        // 1 5 8 2 3
        // 1 5 2 8 3

        String [] arr = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.toString(reorderLogFiles(arr)));
        // "let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"
    }
    public static String[] reorderLogFiles(String[] logs) {

        Map<String, String[]> listMap = new HashMap<>();
        for(String s : logs) {

            listMap.put(s.substring(0, s.indexOf(" ")), s.substring(s.indexOf(" ") + 1).split(" "));

        }

        listMap.forEach((k, v) -> { System.out.println(k); System.out.println(Arrays.toString(v));});
//        String[][] arrArr = new String[logs.length - 1][];
//        for(int i = 0; i < logs.length; i++) {
//            arrArr[i] = logs[i].split(" ");
//
//
//        }
//
//        for(String[] a : arrArr) {
//            System.out.println(Arrays.toString(a));
//        }
//        for (int j = 0; j < arr.length; j++) {
//            arr[j];
//        }


        return null;
    }
}
