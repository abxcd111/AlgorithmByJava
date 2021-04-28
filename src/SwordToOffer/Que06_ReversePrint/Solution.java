package SwordToOffer.Que06_ReversePrint;

public class Solution {
    public static int[] reversePrint(ListNode head) {
        //先反转链表再输出到数组

        int res[] = new int[0];
        if (head == null){
            return res;
        }

        ListNode lasthead = head.next;
        ListNode temp = null;
        head.next = null;
        int len = 1;

        while (lasthead != null){
            temp = lasthead;
            lasthead = lasthead.next;
            temp.next = head;
            head = temp;
            len++;
        }

        res = new int[len];
        temp = head;
        int i = 0;

        while (temp != null && (i < len)){
            res[i] = temp.val;
            temp = temp.next;
            i++;
        }


        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        reversePrint(head);
    }
}
