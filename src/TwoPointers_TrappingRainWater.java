public class TwoPointers_TrappingRainWater {

    public static int trap(int[] heights) {

        if (heights == null || heights.length == 0) return 0;

        int l= 0;
        int r= heights.length - 1;
        int maxLeft= heights[l];
        int maxRight= heights[r];
        int result=0;

        while(l < r) {
            if(heights[l] > heights[r]) { //if right height is smaller
                r-=1; //decrement the right pointer
                maxRight= Math.max(maxRight, heights[r]); //compare the new height with max right height
                result+= maxRight-heights[r]; //subtract the new height from max right height to get the units of water that can be stored
            }else{//move the left even when the two heights happen to be equal
                l+=1;
                maxLeft= Math.max(maxLeft, heights[l]);
                result+= maxLeft-heights[l];
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] heights= {0,2,0,3,1,0,1,3,2,1};
        System.out.println("Water that can be trapped: "+ trap(heights));
    }
}
