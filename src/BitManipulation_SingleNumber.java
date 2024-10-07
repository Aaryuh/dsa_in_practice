public class BitManipulation_SingleNumber {
    public static int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) ans = ans ^ nums[i]; //xor (1 xor 1= 0) ,
        return ans;
    }
    public static void main(String[] args) {
        int[] array={ 3,3,1,2,4,2,4};
        System.out.println(singleNumber(array));
    }
}
