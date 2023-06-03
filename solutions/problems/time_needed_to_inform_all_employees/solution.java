class Solution {

    public int maxTimeNAryTree(int head, HashMap<Integer, ArrayList<Integer>> children, int []informTime) {

        int selfPropTime = informTime[head];
        int maxNAryChildrenTime = 0;

        ArrayList<Integer> nAryChildren = children.get(head);

        if (nAryChildren == null)
            return selfPropTime;

        for (int i = 0; i < nAryChildren.size(); i++) {
            int currChild = nAryChildren.get(i);
            int currTime = informTime[currChild];

            maxNAryChildrenTime = Math.max(maxNAryChildrenTime, maxTimeNAryTree(currChild, children, informTime));
        }
        return selfPropTime + maxNAryChildrenTime;
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        HashMap<Integer, ArrayList<Integer>> children = new HashMap<>();

        int head = -1;

        for (int i = 0; i < manager.length; i++) {

            if (manager[i] == -1)
                head = i;
            else
                {
                    int currManager = manager[i];
                    ArrayList<Integer> currChildren = children.get(currManager);

                    if (currChildren == null) 
                        currChildren = new ArrayList<>();
                    
                    currChildren.add(i);

                    children.remove(currManager);
                    children.put(currManager, currChildren);
                }
        }
        return maxTimeNAryTree(head, children, informTime);
    }
}