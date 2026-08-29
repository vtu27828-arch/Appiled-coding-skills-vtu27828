import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;

        for (int i = 0; i < n; i++) {

            // Remove elements that are outside the window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back
            while (!deque.isEmpty() && 
                   nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Window is ready
            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}

Input
nums =
[1,3,-1,-3,5,3,6,7]
k =
3
Output
[3,3,5,5,6,7]
