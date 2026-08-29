import java.util.*;

class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        // Add the new request
        queue.add(t);

        // Remove requests older than 3000 milliseconds
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        // Number of requests in [t - 3000, t]
        return queue.size();
    }
}


Input
["RecentCounter","ping","ping","ping","ping"]
[[],[1],[100],[3001],[3002]]
Output
[null,1,2,3,3]
