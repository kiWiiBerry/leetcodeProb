package com.yiyiwii.leetcode.editor.en;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AmzTurnstile {
    public static void main(String[] args) {
        AmzTurnstile.Solution sol = new AmzTurnstile().new Solution();

//        // output: res = {2,0,1,5}
//        int[] time = {0,0,1,5}; //{1, 2, 4, 4, 8, 12};
//        int[] dirs = {0,1,1,0}; //{1,0,1,0,1,0};
//        int[] res = sol.getTimes(time, dirs);
//        System.out.println(Arrays.toString(res));

        System.out.println("Turnstile");
        sol.test(new int[] {0,0,1,1000000000}, new int[]{0,1,1,0},new int[]{2,0,1,1000000000});
//        sol.test(new int[] {0, 0, 1, 5}, new int[] {0,1,1,0}, new int[] {2, 0, 1, 5});
//        sol.test(new int[] {0, 0, 5, 5}, new int[] {0,1,1,0}, new int[] {1, 0, 5, 6});
//        sol.test(new int[] {0, 0, 1, 1}, new int[] {0,1,1,0}, new int[] {2, 0, 1, 3});
//        sol.test(new int[] {0, 0, 0, 0}, new int[] {0,1,1,0}, new int[] {2, 0, 1, 3});
//        sol.test(new int[] {0, 0, 0, 0}, new int[] {0,0,0,0}, new int[] {0, 1, 2, 3});
//        sol.test(new int[] {0, 0, 1, 3, 10}, new int[] {0,1,1,1,0}, new int[] {2, 0, 1, 3, 10});
//        sol.test(new int[] {0, 1, 1, 3, 3}, new int[] {0, 1, 0, 0, 1}, new int[] {0,2,1,4,3});
//        sol.test(new int[] {1,1}, new int[]{1,1}, new int[]{1,2});
//        sol.test(new int[] {1, 1, 3, 3, 4, 5, 6, 7, 7}, new int[]{1, 1, 0, 0, 0, 1, 1, 1, 1}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    class Solution {
        class Person{
            int id;
            int dir;
            int time;
            Person(int id, int dir, int time) {
                this.id = id;
                this.dir = dir;
                this.time = time;
            }
        }
        public void test(int[] time, int[] direction, int[] expected) {
            int[] result = getTimes(time, direction);
            System.out.println("ACTUAL: " + Arrays.toString(result));
            System.out.println("EXPECTED: " + Arrays.toString(expected));
        }

        public int[] getTimes(int[] times, int[] directions) {
            int[] res = new int[times.length];

            PriorityQueue<Person> enter = new PriorityQueue<>((o1, o2) -> o1.time == o2.time ? o1.id - o2.id : o1.time - o2.time);
            PriorityQueue<Person> exit = new PriorityQueue<>((o1, o2) -> o1.time == o2.time ? o1.id - o2.id : o1.time - o2.time);
            for (int i = 0; i < times.length; i ++) {
                if (directions[i] == 1) {
                    exit.offer(new Person(i, 1, times[i]));
                } else {
                    enter.offer(new Person(i, 0, times[i]));
                }
            }

            int lastDir = -1;
            int timeStamp = 0;
            while (!exit.isEmpty() || !enter.isEmpty()) {
                int exitTime = exit.isEmpty() ? Integer.MAX_VALUE : exit.peek().time;
                int enterTime = enter.isEmpty() ? Integer.MAX_VALUE : enter.peek().time;
//                if (exitTime > timeStamp && enterTime > timeStamp) {
//                    // ts not used, set dir = 1 , to let people exit
//                    lastDir = 1;
//                } else if (exitTime <= timeStamp && enterTime <= timeStamp) {
//                    Person person = lastDir == 1 ? exit.poll() : enter.poll();
//                    res[person.id] = timeStamp;
//                } else {
//                    Person person = enterTime <= timeStamp ? enter.poll() : exit.poll();
//                    res[person.id] = timeStamp;
//                    lastDir = person.dir;
//                }

                if (!exit.isEmpty() && exitTime <= timeStamp &&
                        (lastDir != 0 || enter.isEmpty() || (lastDir == 0 && enterTime > timeStamp)) ) {
                    Person person = exit.poll();
                    res[person.id] = timeStamp;
                    lastDir = 1;
                } else if (!enter.isEmpty() && enterTime <= timeStamp){
                    Person person = enter.poll();
                    res[person.id] = timeStamp;
                    lastDir = 0;
                } else {  // timestamp not used
                    lastDir = -1;
                }

                timeStamp++;
            }
            return res;
        }
//        public int[] getTimes(int[] time, int[] directions){
//            PriorityQueue<Integer> enter = new PriorityQueue<>((a, b) -> time[a] - time[b]);
//            PriorityQueue<Integer> exit = new PriorityQueue<>((a, b) -> time[a] - time[b]);
//            int[] res = new int[time.length];
//
//            for (int i = 0; i < directions.length; i++) {
//                if (directions[i] == 1) {
//                    exit.add(i);
//                } else {
//                    enter.add(i);
//                }
//            }
//
//            int curr = 0, last = -1;
//            while (!exit.isEmpty() || !enter.isEmpty()) {
//                int curTime =
//            }
//
//            while (!(enter.isEmpty() && exit.isEmpty())) {
//                int nextEnterTime = enter.isEmpty() ? Integer.MAX_VALUE : enter.peek();
//                int nextExitTime = exit.isEmpty() ? Integer.MAX_VALUE : exit.peek().time;
//                if (nextEnterTime > timeStamp && nextExitTime > timeStamp) {
//                    lastDir = 1;
//                } else if (nextEnterTime <= timeStamp && nextExitTime <= timeStamp) {
//                    Visitor v = lastDir == 1 ? exit.poll() : enter.poll();
//                    res[v.id] = timeStamp;
//                } else {
//                    Visitor v = nextEnterTime <= timeStamp ? enter.poll() : exit.poll();
//                    res[v.id] = timeStamp;
//                    lastDir = v.dir;
//                }
//                timeStamp ++;
//            }
//
//            return null;
//        }
    }
}
