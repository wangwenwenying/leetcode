public class SumTwoNumsTwo {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    /** 
    * @Description: 不懂，标记。 
    * @Param: [args] 
    * @return: void 
    * @Author: www
    * @Date: 2019/7/31 
    */ 
    public static void main(String[] args) {
        ListNode l1 = new ListNode(123);
        ListNode l2 = new ListNode(321) ;
        SumTwoNumsTwo sumTwoNumsTwo = new SumTwoNumsTwo() ;
        System.out.println(sumTwoNumsTwo.addTwoNumbers(l1,l2)) ;
    }
}
