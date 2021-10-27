package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class GGGetSongNotRecentOnes {
    public static void main(String[] args) {
        GGGetSongNotRecentOnes sol = new GGGetSongNotRecentOnes();
        int[] songs = {0,1,2,3,4,5,6,7,8,9};
        PlayList pl = sol.new PlayList(songs, 3);

        int n = 26;
        for (int i = 0; i < n; i++) {
            System.out.println("before get: " + Arrays.toString(pl.songs));
            int s = pl.getSong();
//            System.out.println("get song: " + s);
            System.out.println("after get: " + Arrays.toString(pl.songs));
            System.out.println("------");
        }

    }

    class PlayList {
        int[] songs;
        int K;
        Random rd;
        int pointer;
        PlayList(int[] songs, int K) {
            this.rd = new Random();
            this.K = K;
            this.songs = songs;
            this.pointer = -1;
        }
        private int getSong() {
            this.pointer++;
            int len = this.songs.length;
            int usedRange = (this.pointer >= this.K) ? this.K : this.pointer;
            int idx = rd.nextInt(len - usedRange) + usedRange;
            swapWithPointer(idx);
            int song = this.songs[this.pointer % this.K];
            System.out.println("get song: " + song);
            return song;
        }
        private void swapWithPointer(int idx) {
            int tmp = songs[this.pointer % this.K];
            songs[this.pointer % this.K] = songs[idx];
            songs[idx] = tmp;
        }
    }
    // Method1, using Queue
//    class PlayList {
//        int[] songs;
//        int K;
//        Queue<Integer> queue = new LinkedList<>();
//        Random rd;
//        PlayList(int[] songs, int K) {
//            this.rd = new Random();
//            this.K = K;
//            this.songs = songs;
//        }
//        private int getSong() {
//            int idx = rd.nextInt(this.songs.length);
//            while (queue.contains(idx)) {
//                idx = rd.nextInt(songs.length);
//            }
//
//            if (queue.size() >= this.K) {
//                queue.remove();
//            }
//            queue.offer(idx);
//
//            return this.songs[idx];
//        }
//    }

}
