class Solution {
    public void adjListPush(int root, int child, HashMap<Integer, ArrayList<Integer>> adjList) {
        
        ArrayList<Integer> adjListCurr = adjList.get(root);

        if (adjListCurr == null)
            adjListCurr = new ArrayList<>();
          
        adjListCurr.add(child);
        adjList.put(root, adjListCurr);
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n];

        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    adjListPush(i, j, adjList);
                    adjListPush(j, i, adjList);
                }
            }
        }

        int rounds = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == false)
            {
                rounds++;

                Queue<Integer> q = new LinkedList<>();
                q.add(i);

                while(!q.isEmpty()) {
                    int curr = q.remove();
                    ArrayList<Integer> connected = adjList.get(curr);

                    for(int j = 0; j < connected.size(); j++)
                    {
                        int neighbor = connected.get(j);

                        if (visited[neighbor] == false) {
                            visited[neighbor] = true;
                            q.add(neighbor);
                        }   
                    }
                }
            }
        }
        return rounds;
    }
}