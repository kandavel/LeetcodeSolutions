class SnapshotArray {

    // store all the (index, val) pairs before a particular snap-checkpoint is done
    // for all the snaps,extra set of (index, val) pairs for the next possible snap
    HashMap<Integer, HashMap<Integer, Integer> > indexValsAtCheckpoint;
    HashMap<Integer, ArrayList<Integer>> updateCheckpointsOfIndex;

    int snapsSoFar;

    public SnapshotArray(int length) {
        indexValsAtCheckpoint = new HashMap<>();
        updateCheckpointsOfIndex = new HashMap<>();
        snapsSoFar = 0;
    }
    
    public void set(int index, int val) {

        // get the (index, val) pairs for this next snap

        HashMap<Integer, Integer> indexValsAtNextSnap = 
        indexValsAtCheckpoint.get(snapsSoFar);

        // no index has been set for the next snap
        // this is the first index to set to a val for the next snap
        if (indexValsAtNextSnap == null) {

            // create the first (index, val) pair for the next snap
            indexValsAtNextSnap = new HashMap<>();
            indexValsAtNextSnap.put(index, val);

            indexValsAtCheckpoint.put(snapsSoFar, indexValsAtNextSnap);
        } else {
            Integer indexValAtNextSnap = indexValsAtNextSnap.get(index);

            // this particular index has never been set in the 
            // set of indexes so far for the next snap
            if (indexValAtNextSnap == null) {
                indexValsAtNextSnap.put(index, val);
            } else {
                // update the value for this index to current val
                indexValsAtNextSnap.replace(index, val);
            }
        }

        ArrayList<Integer> updateCheckpointsOfCurrIndex = 
        updateCheckpointsOfIndex.get(index);

        if (updateCheckpointsOfCurrIndex == null) {
            updateCheckpointsOfCurrIndex = new ArrayList<>();
            updateCheckpointsOfIndex.put(index, updateCheckpointsOfCurrIndex);
        }
        
        if (updateCheckpointsOfCurrIndex.isEmpty())
            updateCheckpointsOfCurrIndex.add(snapsSoFar);

        Integer lastUpdate = updateCheckpointsOfCurrIndex.get(
            updateCheckpointsOfCurrIndex.size() - 1);
        
        if (lastUpdate < snapsSoFar)
            updateCheckpointsOfCurrIndex.add(snapsSoFar);
    }
    
    public int snap() {

        snapsSoFar++;
        return snapsSoFar - 1;
    }
    
    public Integer lowerBound(ArrayList<Integer> a, int x) {
        int l = 0, r = a.size() - 1;

        while(l <= r) {
            int mid = l + (r-l)/2;

            if (a.get(mid) == x)
            return x;

            if (a.get(mid) > x)
            r = mid-1;
            else
            l = mid+1;
        }
        if (r == -1)
        return null;

        return a.get(r);
    }

    public int get(int index, int snap_id) {
        ArrayList<Integer> updateCheckpointsOfCurrIndex = 
        updateCheckpointsOfIndex.get(index);

        // this index was never updated, so return the default value of 
        // this index in the initial array which is zero
        if (updateCheckpointsOfCurrIndex == null)
        return 0;

        // get the numerically last checkpoint of update before snap
        Integer lastUpdateOfCurrIndexBeforeSnap = 
        lowerBound(updateCheckpointsOfCurrIndex, snap_id);

// System.out.println("lastUpdateOfIndexBeforeSnap + "+ lastUpdateOfCurrIndexBeforeSnap);

        // index was not set before the current snap
        if (lastUpdateOfCurrIndexBeforeSnap == null)
        return 0;

        // get the (index, val) pairs for the snap which was 
        // the last update of this index
        HashMap<Integer, Integer> indexValsAtLastUpdate = 
        indexValsAtCheckpoint.get(lastUpdateOfCurrIndexBeforeSnap);


        // something wrong
        if (indexValsAtLastUpdate == null)
            return 0;

        // get the val for this index
        Integer indexValAtLastUpdate = indexValsAtLastUpdate.get(index);
// System.out.println("indexValAtLastUpdate + "+ indexValAtLastUpdate);

        // something wrong
        if (indexValAtLastUpdate == null)
            return 0;

        // return the index val at last update before the current 'snap' 
        return indexValAtLastUpdate;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */