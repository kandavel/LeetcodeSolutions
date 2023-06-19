class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (p1, p2) -> (p1[0]*p1[0] + p1[1]*p1[1] - p2[0]*p2[0] - p2[1]*p2[1]));
        
        for (int i = 0; i < points.length; i++) {
            int point[] = new int[2];
            point[0] = points[i][0];
            point[1] = points[i][1];

            pq.add(point);
        }

        int [][]topKPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            topKPoints[i] = pq.poll();
        }
        return topKPoints;
    }
}