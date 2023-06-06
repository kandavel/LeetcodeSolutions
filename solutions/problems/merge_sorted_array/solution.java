class Solution {
    public void print(int []a) {
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i]);
        System.out.println(",");
    }
    
    public void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int r = m + n - 1;
        //shift zeroes to the front to have n zero elements in the result array, nums1
        while (r >= n)
        {
            nums1[r] = nums1[r - n]; 
            r--;
        }
        
        while (r >= 0) 
            nums1[r--] = 0;
        
        int i = n, j = 0, k = 0;
        
        while(i < n + m && j < n) {
            int a = nums1[i];
            int b = nums2[j];
            
            if (a < b) {
                int temp = nums1[i];
                nums1[i] = nums1[k];
                nums1[k] = temp; 
                
                k++; i++;
            } else {
                nums1[k] = nums2[j]; 
                
                k++; j++;
            }
        }
        
        while (j < n) {
            nums1[k] = nums2[j]; 
                
            k++; j++;
        }
        
    }
}