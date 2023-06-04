class Solution {
    class Op {
        int val;
        int time;
        
        Op(int val, int time) {
            this.val = val;
            this.time = time;
        }
        
        public int getTime() {
            return this.time;
        }
        
        public int getVal(){
            return this.val;
        }
    }
    
    public long matrixSumQueries(int n, int[][] queries) {
        
        Op rowOps[] = new Op[n];
        Op colOps[] = new Op[n];
        
        int colDone[] = new int[n];
        int rowDone[] = new int[n];
        
        int nQueries = queries.length;
        long sum = 0;
        
        int nR = n;
        int nC = n;
        
        for(int i = nQueries - 1; i >= 0; i--){
            int tuple[] = queries[i];
            int type = tuple[0];
            int index = tuple[1];
            int val = tuple[2];
            
            if (type == 0) {
                
                if (rowDone[index] == 0)
                {
                    sum += (long) val*nC;
                    rowDone[index] = 1;
                    
                    nR--;
                }
            }
            else if (type == 1) {
                if (colDone[index] == 0)
                {
                    sum += (long) val*nR;
                    colDone[index] = 1;
                    
                    nC--;
                }
            }
        }
        
        // for (int i = 0; i< n; i++) {
        //     if(rowOps[i] != null)
        //         System.out.println(rowOps[i].getVal());
        //     if(colOps[i] != null)
        //         System.out.println(colOps[i].getVal());
        // }
        
//         for (int i= 0; i < n; i++) {
//             Op rowOp = rowOps[i];
//             for(int j = 0; j < n; j++) {
//                 Op colOp = colOps[j];
                
//                 if (rowOp == null && colOp == null)
//                     continue;
//                 else if (colOp == null)
//                     sum += (long) (rowOp.getVal());
//                 else if(rowOp == null)
//                     sum += (long) (colOp.getVal());
//                 else
//                     sum += (long) (rowOp.getTime() > colOp.getTime() ? rowOp.getVal(): colOp.getVal());
                
//                 // System.out.println(i + ", " + j + ", " + sum);
//             }
//         }
        return sum;
    }
}