package com.yiyiwii.leetcode.editor.en;

import java.util.Date;
import java.util.PriorityQueue;

public class AmzMergeKSortedArrays {
    public AmzMergeKSortedArrays() {
    }

    public AmzMergeKSortedArrays.Song[] mergeKPlaylists(AmzMergeKSortedArrays.Song[][] lists) {
        if (lists != null && lists.length != 0) {
            int len = lists.length;
            PriorityQueue<AmzMergeKSortedArrays.Entry> pq = new PriorityQueue(len);
            int size = 0;

            for(int i = 0; i < len; ++i) {
                if (lists[i].length > 0) {
                    size += lists[i].length;
                    pq.add(new AmzMergeKSortedArrays.Entry(lists[i][0], i, 0));
                }
            }

            AmzMergeKSortedArrays.Song[] res = new AmzMergeKSortedArrays.Song[size];

            for(int i = 0; !pq.isEmpty(); ++i) {
                AmzMergeKSortedArrays.Entry curr = (AmzMergeKSortedArrays.Entry)pq.poll();
                res[i] = curr.song;
                int nextIdx = curr.index + 1;
                if (nextIdx < lists[curr.arrIdx].length) {
                    pq.add(new AmzMergeKSortedArrays.Entry(lists[curr.arrIdx][nextIdx], curr.arrIdx, nextIdx));
                }
            }

            return res;
        } else {
            return null;
        }
    }

    private class Entry implements Comparable<AmzMergeKSortedArrays.Entry> {
        final AmzMergeKSortedArrays.Song song;
        int arrIdx;
        int index;

        public Entry(AmzMergeKSortedArrays.Song song, int arrIdx, int index) {
            this.song = song;
            this.arrIdx = arrIdx;
            this.index = index;
        }

        public int compareTo(AmzMergeKSortedArrays.Entry that) {
            return this.song.getTime().compareTo(that.song.getTime());
        }
    }

    class Song {
        String author;
        int duration;
        Date time;

        Song() {
        }

        Song(String author, int duration, Date time) {
            this.author = author;
            this.duration = duration;
            this.time = time;
        }

        public Date getTime() {
            return this.time;
        }
    }
}