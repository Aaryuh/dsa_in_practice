public class BinarySearch {

    public static int binarySearch(int[] arr, int key) {
        int l=0;
        int r=arr.length-1;

        while(l<=r){
            int mid= l+(r-l)/2; //add half of the distance between left and right pointers.
            if(arr[mid]==key){
                return mid;
            }else if(arr[mid]<key){
                l= mid+1;
            }else if(arr[mid]>key){
                r= mid-1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] array= {-1,0,2,4,6,8};
        int target=4;
        int result= binarySearch(array, target);
        System.out.println("Target index: "+result);
    }
}
