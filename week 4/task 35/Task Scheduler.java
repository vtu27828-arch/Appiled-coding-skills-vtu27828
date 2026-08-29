class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        // Count frequency of each task
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find the maximum frequency
        int maxFreq = 0;

        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Number of gaps created by the most frequent task
        int gaps = maxFreq - 1;

        // Each gap needs n idle/other-task intervals
        int intervals = gaps * (n + 1);

        // Find how many tasks have the maximum frequency
        int maxCount = 0;

        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }

        intervals += maxCount;

        // We cannot have fewer intervals than the number of tasks
        return Math.max(tasks.length, intervals);
    }
}

Input
tasks =
["A","A","A","B","B","B"]
n =
2
Output
8
