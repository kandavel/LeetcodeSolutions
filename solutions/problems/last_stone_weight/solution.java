class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = 
        new PriorityQueue<Integer>((a,b)-> (b-a));

        for (int i = 0; i < stones.length; i++) 
        pq.add(stones[i]);

        while(!pq.isEmpty()) {
            int y = pq.remove();

            if (pq.isEmpty())
            return y;

            int x = pq.remove();

            if (x != y)
            pq.add(y - x);
        }
        return 0;
    }
}