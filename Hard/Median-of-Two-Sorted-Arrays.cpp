class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        int m = nums2.size();
            int i = 0;
            int   j = 0;
            int k = 0;
            vector<int> dp(n+m);
        while(i < n && j < m) {
                if(nums1[i] < nums2[j]) {
                 dp[k] = nums1[i];
                  i++;
                } else{
                 dp[k] = nums2[j];
                 j++;       
                }
                k++;
        }
        while(i < n){
                dp[k]=nums1[i];
                k++;
                i++;
        }
        while(j < m) {
                dp[k] = nums2[j];
                k++;
                j++;
        }
        double median = 0.0;
        
           
        if(dp.size() % 2 == 0){
                median =  dp[dp.size() / 2] + dp[(dp.size() / 2) - 1];
                 median = median / 2;
        }    else {
               median = (double)dp[dp.size() / 2];
        }
        return median;
    }
};
