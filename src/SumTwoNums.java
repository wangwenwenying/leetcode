import java.util.HashMap;
import java.util.Map;

public class SumTwoNums {
    /** 
    * @Description: 暴力解除，使用两次循环对比。 即从当前位置每次都与后面的进行对比，直到找出结果。
    * @Param: [nums, target] 
    * @return: int[] 
    * @Author: www
    * @Date: 2019/7/30 
    */ 
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

    /**
    * @Description: 两遍哈希表，使用hashMap,其中使用两次循环，第一次将所有的值put进hashmap的key中,然后第二次循环先取出原有值与target的差值，然后看差值是否包含在map中，如果包含，而且差值所对应的value不等于i，
     * 即：两个数不是同一个数，不在同一位置。
    * @Param: [nums, target]
    * @return: int[]
    * @Author: www
    * @Date: 2019/7/31
    */
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
    /**
    * @Description: 一遍hash ，边插入，边对比。
    * @Param: [nums, target]
    * @return: int[]
    * @Author: www
    * @Date: 2019/7/31
    */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        SumTwoNums sumTwoNums = new SumTwoNums() ;
        int[] index = sumTwoNums.twoSum3(new int[]{2, 7, 11, 15},9) ;
        for(int i=0; i<index.length; i++){
            System.out.println(index[i]);
        }
    }
}
