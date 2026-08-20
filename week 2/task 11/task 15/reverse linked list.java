class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }
}

Input
head =
[1,2,3,4,5]
Output
[5,4,3,2,1]
