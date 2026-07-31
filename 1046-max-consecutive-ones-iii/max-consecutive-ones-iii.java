class Solution {
    public int longestOnes(int[] nums, int k) {
        // int left =0
        // int right =0;
        // int zeroCount =0;
        // int maxOnes =0;

        // while(right<nums.length){
        //     if(nums[left]==1 && nums[right]==1){
        //         right++;
        //         maxOnes = Math.max(maxOnes , right-left)
        //     }
        //     else if(nums[right]==0){
        //     left=right;
        //     if(right-left<k){
        //         right++;
        //         zeoOnes = M
        //     }
        //     }
        // }

        int maxLen =0;
        for(int i=0;i<nums.length;i++){
            int zeros=0;
            for(int j=i;j<nums.length;j++){
                if(nums[j]==0){
                    zeros++;
                }
                if(zeros>k){
                    break;
                }
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;

    }
}