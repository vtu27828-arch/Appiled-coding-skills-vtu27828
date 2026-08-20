class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        // Check if there are at least k nodes
        ListNode temp = head;

        for (int i = 0; i < k; i++) {
            if (temp == null) {
                return head;
            }
            temp = temp.next;
        }

        // Reverse k nodes
        ListNode prev = null;
        ListNode current = head;

        for (int i = 0; i < k; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Connect remaining list
        head.next = reverseKGroup(current, k);

        return prev;
    }
}

Input
head =
[1,2,3,4,5]
k =
2
Output
[2,1,4,3,5]
