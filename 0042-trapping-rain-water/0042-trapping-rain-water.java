class Solution {
    public int trap(int[] height) {
        // left max boundary
        int leftMax[] = new  int[height.length];
        leftMax[0] = height[0];
        for(int i=1; i<height.length; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        //right max  boundary
        int rightMax[] = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for(int i= height.length - 2; i>=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        int trappedWater =0;
        //loop
        for(int i=0; i<height.length; i++){
        //waterlevel -  minimum ( left max and  right max)
        int  waterLevel = Math.min(leftMax[i], rightMax[i]);
        // trappedwater = waterlevel - height
             trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }
}