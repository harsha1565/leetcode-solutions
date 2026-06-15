class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
     int n = passingFees.length;

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        int[] minCost = new int[n];
        int[] minTime = new int[n];

        Arrays.fill(minCost, Integer.MAX_VALUE);
        Arrays.fill(minTime, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{passingFees[0], 0, 0});

        minCost[0] = passingFees[0];
        minTime[0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int cost = cur[0];
            int time = cur[1];
            int node = cur[2];

            if (node == n - 1)
                return cost;

            for (int[] nei : graph[node]) {
                int nextNode = nei[0];
                int travelTime = nei[1];

                int newTime = time + travelTime;
                int newCost = cost + passingFees[nextNode];

                if (newTime > maxTime)
                    continue;

                if (newCost < minCost[nextNode]) {
                    minCost[nextNode] = newCost;
                    minTime[nextNode] = newTime;
                    pq.offer(new int[]{newCost, newTime, nextNode});
                } else if (newTime < minTime[nextNode]) {
                    minTime[nextNode] = newTime;
                    pq.offer(new int[]{newCost, newTime, nextNode});
                }
            }
        }

        return -1;   
    }
}