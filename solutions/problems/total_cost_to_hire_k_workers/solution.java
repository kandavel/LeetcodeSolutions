class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> prefixPQ = new PriorityQueue<>();
        PriorityQueue<Integer> suffixPQ = new PriorityQueue<>();

        int n = costs.length;
        int l = 0, r = n - 1;
        while(l <= r && l < candidates && (n - r <= candidates)) {
            prefixPQ.add(costs[l++]);

            if (l <= r)
            suffixPQ.add(costs[r--]);
        }
// System.out.println(prefixPQ.size() +", "+suffixPQ.size());
        long totCost = 0;
        for (int i = 0; i < k; i++) {
            int left = (prefixPQ.size() > 0? prefixPQ.peek(): Integer.MAX_VALUE);
            int right = (suffixPQ.size() > 0? suffixPQ.peek(): Integer.MAX_VALUE);

            int minCost = Math.min(left, right);
            // System.out.println("minCost = " + minCost);

            totCost = totCost + (long) minCost; 

            if (left <= right) {
                prefixPQ.remove();

                if (l <= r)
                prefixPQ.add(costs[l++]);
            } else {
                suffixPQ.remove();

                if (r >= l)
                suffixPQ.add(costs[r--]);
            }
        }
        return totCost;

    }
}