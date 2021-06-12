package com.yiyiwii.leetcode.editor.en;

public class Turnstile {

}

//import java.util.*;
//         
//public class Turnstile {
//    public static List<Integer> getTimes(int n, List<Integer> arrTime, List<Integer> direction) {
//        Queue<Person> enterq = new LinkedList<>();
//        Queue<Person> exitq = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            if (direction.get(i) == 0) {
//                enterq.offer(new Person(i, arrTime.get(i)));
//            } else {
//                exitq.offer(new Person(i, arrTime.get(i)));
//            }
//        }
//        List<Integer> ans = Arrays.asList(new Integer[n]);
//        int currTime = 0;
//        Dir lastDir = Dir.EXIT;
//        while (!enterq.isEmpty() && !exitq.isEmpty()) {
//            Queue<Person> currq;
//            Person in = enterq.peek();
//            Person out = exitq.peek();
//            int intime = Math.max(in.time, currTime);
//            int outtime = Math.max(out.time, currTime);
//            if (intime < outtime) {
//                ans.set(in.idx, intime);
//                lastDir = Dir.ENTER;
//                enterq.poll();
//                currTime = intime + 1;
//            } else if (intime > outtime) {
//                ans.set(out.idx, outtime);
//                lastDir = Dir.EXIT;
//                exitq.poll();
//                currTime = outtime + 1;
//            } else {
//                if (lastDir == Dir.ENTER) {
//                    ans.set(in.idx, intime);
//                    enterq.poll();
//                    currTime = intime + 1;
//                } else {
//                    ans.set(out.idx, outtime);
//                    exitq.poll();
//                    currTime = outtime + 1;
//                }
//            }
//        }
// 
//        Queue<Person> remain = enterq.isEmpty() ? exitq : enterq;
//        while (!remain.isEmpty()) {
//            Person curr = remain.poll();
//            currTime = Math.max(currTime, curr.time);
//            ans.set(curr.idx, currTime);
//            currTime++;
//        }
//        return ans;
//    }
//}
// 
//enum Dir {
//    EXIT,
//                ENTER;
//}
// 
//class Person {
//    int idx;
//    int time;
//    public Person(int i, int time) {
//        this.idx = i;
//        this.time = time;
//    }
//}