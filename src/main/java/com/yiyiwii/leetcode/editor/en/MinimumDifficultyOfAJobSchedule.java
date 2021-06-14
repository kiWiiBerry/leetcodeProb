//You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work
// on the i-th job, you have to finish all the jobs j where 0 <= j < i). 
//
// You have to finish at least one task every day. The difficulty of a job sched
//ule is the sum of difficulties of each day of the d days. The difficulty of a da
//y is the maximum difficulty of a job done in that day. 
//
// Given an array of integers jobDifficulty and an integer d. The difficulty of 
//the i-th job is jobDifficulty[i]. 
//
// Return the minimum difficulty of a job schedule. If you cannot find a schedul
//e for the jobs return -1. 
//
// 
// Example 1: 
//
// 
//Input: jobDifficulty = [6,5,4,3,2,1], d = 2
//Output: 7
//Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
//Second day you can finish the last job, total difficulty = 1.
//The difficulty of the schedule = 6 + 1 = 7 
// 
//
// Example 2: 
//
// 
//Input: jobDifficulty = [9,9,9], d = 4
//Output: -1
//Explanation: If you finish a job per day you will still have a free day. you c
//annot find a schedule for the given jobs.
// 
//
// Example 3: 
//
// 
//Input: jobDifficulty = [1,1,1], d = 3
//Output: 3
//Explanation: The schedule is one job per day. total difficulty will be 3.
// 
//
// Example 4: 
//
// 
//Input: jobDifficulty = [7,1,7,1,7,1], d = 3
//Output: 15
// 
//
// Example 5: 
//
// 
//Input: jobDifficulty = [11,111,22,222,33,333,44,444], d = 6
//Output: 843
// 
//
// 
// Constraints: 
//
// 
// 1 <= jobDifficulty.length <= 300 
// 0 <= jobDifficulty[i] <= 1000 
// 1 <= d <= 10 
// Related Topics Dynamic Programming 
// 👍 737 👎 90


package com.yiyiwii.leetcode.editor.en;
public class MinimumDifficultyOfAJobSchedule {
    public static void main(String[] args) {
        Solution solution = new MinimumDifficultyOfAJobSchedule().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) return -1;
        int[][] F = new int[d+1][n+1];
        for (int i = 1; i <= n; i++) F[1][i] = Math.max(F[1][i-1], jobDifficulty[i-1]);
        for (int i = 2; i <= d; i++) {
            for (int j = i; j <= n; j++) {
                F[i][j] = Integer.MAX_VALUE;
                int currMax = 0;
                for (int k = j; k >= i; k--) {
                    currMax = Math.max(currMax, jobDifficulty[k-1]);
                    F[i][j] = Math.min(F[i][j], F[i-1][k-1] + currMax);
                }
            }
        }
        return F[d][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}