import java.util.*;

public class ArrayHashset_ {

    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> unique= new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(unique.contains(nums[i])) return true;
            unique.add(nums[i]);
        }
        return false;
    }

    public static boolean isAnagram(String s, String t) {
        //char arrays for each character of the array
        char[] firstWord= s.toCharArray();
        char[] secondWord= t.toCharArray();

        //hash map for frequency of each character
        HashMap<Character, Integer> firstWordSet= new HashMap<>();
        HashMap<Character, Integer> secondWordSet= new HashMap<>();

        for(char a: firstWord){
            if(firstWordSet.containsKey(a)){
                int frequency= firstWordSet.get(a);
                firstWordSet.replace(a, frequency+1);
            }else{
                firstWordSet.put(a, 1);
            }
        }

        for(char a: secondWord){
            if(secondWordSet.containsKey(a)){
                int frequency= secondWordSet.get(a);
                secondWordSet.replace(a, frequency+1);
            }else{
                secondWordSet.put(a, 1);
            }
        }

        for(char u: firstWordSet.keySet()){
            if(!secondWordSet.containsKey(u) || secondWordSet.get(u)!=firstWordSet.get(u)){
                return false;
            }
        }
        return true;

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] pair;
        for(int i=0; i<nums.length;i++){
            for(int j= i+1; j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return pair= new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> ListOfLists= new HashMap<>();
        for(String s:strs){
            char[] word= s.toCharArray();
            Arrays.sort(word);//**
            String SortedWord= new String(word);//**
            if(!ListOfLists.containsKey(SortedWord)){
                ListOfLists.put(SortedWord, new ArrayList<>());
            }

            ListOfLists.get(SortedWord).add(s);
        }
        return new ArrayList<>(ListOfLists.values());//**

    }

    public static int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer, Integer> freqCounter= new HashMap<>();
       ArrayList<Integer>[] buckets= new ArrayList[nums.length];

       for(int num : nums){
           if(!freqCounter.containsKey(num)){
               freqCounter.put(num,1);
           }else{
               freqCounter.replace(num, freqCounter.get(num), freqCounter.get(num)+1);
           }
       }

       for(int key: freqCounter.keySet()){//for each key, store that key at the corresponding index to its frequency in buckets array.
           int freq= freqCounter.get(key);

           if(buckets[freq]==null){
               buckets[freq]= new ArrayList<>();
           }
           buckets[freq].add(key);
       }

       int[] result= new int[k];
       int index=0;
       for(int i=buckets.length-1; i>=0; i--){
           if(buckets[i]!=null){
               for(int a: buckets[i]){
                   result[index]=a;
                   index++;
                   if(index==k){
                       return result;
                   }
               }
           }

       }

        return result;

    }

    public static String encode(List<String> strs) {
        StringBuilder encoded= new StringBuilder();
        for(String s: strs){
            encoded.append(s.length()).append("#").append(s);
        }
        return encoded.toString();
    }

    public static List<String> decode(String str) {
        List<String> finalString= new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#') j++;

            int nextStringLen= Integer.valueOf(str.substring(i, j));
            finalString.add(str.substring(j+1, j+1+nextStringLen));
            i= j+1+nextStringLen;
        }
        return finalString;
    }

    public static int[] productExceptSelf(int[] nums) {
        int [] result= new int[nums.length];
        for(int i= 0; i<nums.length; i++){
            int j=0;
            result[i]=1;
            while(j< nums.length){
                if(j!=i){
                    result[i]*= nums[j];
                }
                j++;
            }
        }
        return result;
    }


    public static void main(String[] args){

        //hasDuplicate

//        int[] nums = {1,2,3,3};
//        boolean hasDupe= hasDuplicate(nums);
//        System.out.println(hasDupe);

        //isAnagram

//        String s= "racecar";
//        String t= "carrace";
//        System.out.println(isAnagram(s,t));

        //groupAnagrams

//       String[] strs = {"act","pots","tops","cat","stop","hat"};
//       System.out.println(groupAnagrams(strs));

        //k frequent elements

//       int[] nums = {1,2,2,3,3,3};
//       int k = 2;
//       int[] nums1 = {7,7};
//       int k1 = 1;
//       System.out.println(Arrays.toString(topKFrequent(nums1, k1)));

        //encode decode

//        List<String> inputList= new ArrayList<>();
//        inputList.add("neet");
//        inputList.add("code");
//        inputList.add("loves");
//        inputList.add("you");
//
//        String encodedList= encode(inputList);
//        System.out.println(encodedList);
//        System.out.println(decode(encodedList).toString());

        //product except self

        //int[] nums= {1,2,4,6};
        int[] nums= {-1,0,1,2,3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }
}
