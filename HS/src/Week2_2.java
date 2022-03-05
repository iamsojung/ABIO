import java.math.BigInteger;

// leetCode.addTwoNumbers
public class Week2_2 {
    public static void main(String[] args) {
        //Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        //Output: [8,9,9,9,0,0,0,1]
        ListNode l1 = new ListNode(2,new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6, new ListNode(4)));

        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        BigInteger plusResult = new BigInteger(listNodeToString(l1)).add(new BigInteger(listNodeToString(l2)));
        String result = new StringBuffer(String.valueOf(plusResult)).reverse().toString();

        return stringToListNode(result);
    }

    public static ListNode stringToListNode(String str) {
        if (str.length() > 1) {
            return new ListNode(Integer.parseInt(str.substring(0, 1)), stringToListNode(str.substring(1)));
        } else {
            return new ListNode(Integer.parseInt(str.substring(0, 1)));
        }
    }

    public static String listNodeToString(ListNode ll) {
        StringBuffer result = new StringBuffer();
        while(true) {
            result.append(ll.val);
            if (ll.next == null) break;
            ll = ll.next;
        }
        return result.reverse().toString();
    }

    public static class ListNode {


        public String toString() {
            if (next != null) {
                return "val:" + val + ", next: " + next.toString();
            } else {
                return "val:" + val + ", next: " + next;
            }
        }
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

}
