package com.yiyiwii.leetcode.editor.en;
import java.io.IOException;
import java.util.*;

public class MsJumpGame {

    public static boolean jumpGame(int[] arr, int start) {
        // WRITE YOUR BRILLIANT CODE HERE
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visited = new boolean[arr.length];
        while (!queue.isEmpty()) {
            int currInx = queue.poll();
            int step = arr[currInx];
            int left = currInx - step, right = currInx + step;
            if (left >= 0 && !visited[left]) {
                if (arr[left] == 0) return true;
                else queue.offer(left);
            }
            if (right < arr.length && !visited[right]) {
                if (arr[right] == 0) return true;
                else queue.offer(right);
            }
            visited[currInx] = true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = Integer.parseInt(scanner.nextLine());
        System.out.println(jumpGame(arr, start));
    }

}