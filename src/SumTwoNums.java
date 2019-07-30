import java.util.HashMap;
import java.util.Map;

public class SumTwoNums {
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        for( int i=0; i<nums.length; i++){
            for( int j=i+1; j<nums.length; j++){
                if(nums[i]==target-nums[j]){
                    index[0] = i ;
                    index[1] = j ;
                    return index ;
                }
            }
        }
        return index ;
    }


    public int[] twoSum2(int[] nums, int target) {
        int[] index = new int[2];
        Map<Integer,Integer> map = new HashMap<>() ;
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],i) ;
        }
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i] ;
            if(map.containsKey(complement)&&map.get(complement)!=i){
                index[0] = i ;
                index[1] = map.get(complement) ;
                return index ;
            }
        }
        return index ;
    }

    public static void main(String[] args) {
        SumTwoNums sumTwoNums = new SumTwoNums() ;
        int[] index = sumTwoNums.twoSum2(new int[]{2, 7, 11, 15},9) ;
        for(int i=0; i<index.length; i++){
            System.out.println(index[i]);
        }
    }
}
