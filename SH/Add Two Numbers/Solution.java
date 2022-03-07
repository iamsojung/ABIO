import java.math.BigInteger;
import java.util.Objects;

class Solution {
    public static class ListNode {
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        ListNode ln1 = new ListNode(l1.val, l1.next);
        ListNode ln2 = new ListNode(l2.val, l2.next);

        while (true) {
            s1.append(ln1.val);

            if (Objects.isNull(ln1.next)) {
                break;
            }

            if (Objects.isNull(ln1.next.next)) {
                ln1 = new ListNode(ln1.next.val);
            } else {
                ln1 = new ListNode(ln1.next.val, ln1.next.next);
            }
        }

        while (true) {
            s2.append(ln2.val);

            if (Objects.isNull(ln2.next)) {
                break;
            }

            if (Objects.isNull(ln2.next.next)) {
                ln2 = new ListNode(ln2.next.val);
            } else {
                ln2 = new ListNode(ln2.next.val, ln2.next.next);
            }
        }

        BigInteger b1 = new BigInteger(s1.reverse().toString());
        BigInteger b2 = new BigInteger(s2.reverse().toString());

        String s = b1.add(b2).toString();

        ListNode result = new ListNode();

        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                result = new ListNode(Character.getNumericValue(s.charAt(i)));
            } else {
                result = new ListNode(Character.getNumericValue(s.charAt(i)), result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4))));
    }
}