#include<math.h>

bool valid(int x, int n)
{
    return (x>=0 && x<n);
}

int max(int x, int y)
{
    if(x>=y)
        return x;
    else return y;
}

int min(int x, int y)
{
    if(x<=y)
        return x;
    else return y;
}

double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    if(nums1Size > nums2Size)
    {
        int *temp = nums1;
        nums1 = nums2;
        nums2 = temp;
        
        int x = nums2Size;
        nums2Size = nums1Size;
        nums1Size = x;
        /*
        for(int i=0;i<nums1Size;i++)
            cout<<nums1[i]<<" ";
        cout<<endl;
        
        for(int i=0;i<nums2Size;i++)
            cout<<nums2[i]<<" ";
        cout<<endl;
        */
    }
    
    int imin=0, imax=nums1Size;
    int i, j;
    
    while(imin<=imax)
    {
        i = (imin+imax)/2;
        j = (nums1Size+nums2Size+1)/2 - i;
        
       if(j>0 && nums1[i]<nums2[j-1])
            imin = i+1;
        else if(i>0 && nums2[j]<nums1[i-1])
            imax = i-1;
        else break;        
    }
    
    int maxL, minR;
    
    if(i==0)
        maxL= nums2[j-1];
    else if(j==0)
        maxL = nums1[i-1];
    else maxL= max(nums1[i-1], nums2[j-1]);
    
    //printf("%d %d",maxL, minR);
    if(i==nums1Size)
        minR = nums2[j];
    else if(j==nums2Size)
        minR = nums1[i];
    else minR = min(nums1[i], nums2[j]);
    
    if((nums1Size+nums2Size)%2 ==1)
    return maxL;
    else return (maxL+minR)*(0.5);
}