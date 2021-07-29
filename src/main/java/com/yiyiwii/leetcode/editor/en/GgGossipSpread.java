package com.yiyiwii.leetcode.editor.en;

import java.util.*;

public class GgGossipSpread {
    class Event {
        int sender;
        int receiver;
        int time;
        Event(int[] record) {
            this.sender = record[0];
            this.receiver = record[1];
            this.time = record[2];
        }
        Event(int sender, int receiver, int time) {
            this.sender = sender;
            this.receiver = receiver;
            this.time = time;
        }
    }
    public static void main(String[] args) {
//        int[][] meetings = {{1,2,10}, {2,3,10}, {3,4,10}, {4,1,10}};
//        int source = 4;
//        int[][] meetings = {{1,2,100},{4,2,100},{3,2,100},{2,5,100}};  //,{3,4,200},{1,3,300},{2,5,400}
//        int source = 4;
//        int[][] meetings = {{1,2,100}, {3,4,200}, {3,5,200}, {1,3,200}, {2,5,300}};
        int[][] meetings = {{7,1,10}, {6, 1, 10}, {1,2,100}, {3,4,200}, {2,5,200}, {3,5,200}, {1,3,200}};
        int source = 1;
        GgGossipSpread sol = new GgGossipSpread();
        Map<Integer, Boolean> res = sol.gossipSpread(meetings, source);
        sol.printMap(res);
    }

    public Map<Integer, Boolean> gossipSpreadBFS(int[][] meetings, int source) {
        Map<Integer, Boolean> res = new HashMap<>();
        Map<Integer, List<int[]>> graph = buildGraph(meetings, res);

        Set<Integer> known = new HashSet<>();
        known.add(source);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        List<int[]> sourceNext = graph.get(source);
        for (int[] next : sourceNext) {
            pq.offer(next);
        }

        int minTime = pq.peek()[1];
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int receiver = curr[0];
            int time = curr[1];

            if (time < minTime) continue;
            if (known.contains(receiver)) continue;

            res.put(receiver, true);
            known.add(receiver);
            List<int[]> nextLev = graph.get(receiver);
            for (int[] next : nextLev) {
                pq.offer(next);
            }
        }

        return res;
    }
    public Map<Integer, List<int[]>> buildGraph(int[][] meetings, Map<Integer, Boolean> res) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] meeting : meetings) {
            int sender = meeting[0];
            int receiver = meeting[1];
            int time = meeting[2];
            graph.putIfAbsent(sender, new LinkedList<>());
            graph.get(sender).add(new int[]{receiver, time});
            res.putIfAbsent(sender, false);
            res.putIfAbsent(receiver, false);
        }
        return graph;
    }

    public Map<Integer, Boolean> gossipSpread(int[][] meetings, int source) {
        Map<Integer, Boolean> res = new HashMap<>();

        List<Event> events = new LinkedList<>();
        for (int[] meeting : meetings) {
            int sender = meeting[0];
            int receiver = meeting[1];

            events.add(new Event(meeting));
            res.putIfAbsent(sender, false);
            res.putIfAbsent(receiver, false);
        }
        Collections.sort(events, Comparator.comparingInt(a -> a.time));
        Set<Integer> known = new HashSet<>();
        known.add(source);
        res.put(source, true);

        int sameTime = events.get(0).time;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        List<Event> sameTimeMeeting = new LinkedList<>();
        for (int i = 0; i < events.size(); i++) {
            Event e = events.get(i);
            if (e.time == sameTime) {
                insertEdge(e, graph);
                sameTimeMeeting.add(e);
            }
            if (e.time != sameTime || (e.time == sameTime && i == events.size() - 1)) {
                printGraph(graph);
                System.out.println(events.get(i - 1).sender);
                processMeeting(graph, sameTimeMeeting, res, known);
                graph.clear();
                sameTimeMeeting.clear();
                insertEdge(e, graph);
                sameTimeMeeting.add(e);
            }
            sameTime = e.time;
            if (known.contains(e.sender)) {
                res.put(e.receiver, true);
                known.add(e.receiver);
            }
        }
        return res;
    }
    void insertEdge(Event e, Map<Integer, List<int[]>> graph) {
        graph.putIfAbsent(e.sender, new LinkedList<>());
        graph.get(e.sender).add(new int[]{e.receiver, 0});
    }
    void dfs(Map<Integer, List<int[]>> graph,
             Map<Integer, Boolean> res,
             Set<Integer> known,
             int sender) {
        List<int[]> nextLev = graph.get(sender);
        if (nextLev == null) return;
        if (known.contains(sender)) {
            for (int i = 0; i < nextLev.size(); i++) {
                int child = nextLev.get(i)[0];
                int changed = nextLev.get(i)[1];
                if (changed == 1) continue;
                res.put(child, true);
                known.add(child);
                nextLev.get(i)[1] = 1;
                dfs(graph, res, known, child);
            }
        }
    }
    void processMeeting(Map<Integer, List<int[]>> graph,
                        List<Event> list,
                        Map<Integer, Boolean> res,
                        Set<Integer> known) {
        for (Event e : list) {
            if (known.contains(e.sender)) {
                dfs(graph, res, known, e.sender);
            }
        }
    }

    // Printer Functions
    void printMap(Map<Integer, Boolean> map) {
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            System.out.println("people: " + entry.getKey() + ";  " + entry.getValue());
        }
    }
    void printGraph(Map<Integer, List<int[]>> graph) {
        for (Map.Entry<Integer, List<int[]>> entry : graph.entrySet()) {
            System.out.println("people: " + entry.getKey() + ";  " );
            for (int[] rec : entry.getValue()) {
                System.out.print("val: " + rec[0] + ", change: " + rec[1] + ",    ");
            }
            System.out.println("------");
        }
    }
}
