package com.leetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @fufu
 */
public class TwoSum {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {2,5,6,9,7,5,4};
        int target = 9;
        int[] indexs = twoSum(nums,target);
        System.out.println(Arrays.toString(indexs));
    }
    public static int[] twoSum(int[] nums, int target) {
/*      //时间复杂度高On(n^2)
        HashMap<Integer,Integer> hash = new HashMap<>();
        int indexs[] = new int[2];
        //将数组nums对应的下标和数值作为hash的value和key
        for(int i = 0;i<nums.length;i++){
            hash.put(nums[i],i);
        }
        //查找hash表中是否存在补集
        for(int i = 0;i<nums.length;i++){
            int temp = target - nums[i];
            //hash.get(temp)!=i一定要放在后面，因为是短路与，当满足第一个条件，就直接进入if语句
            //否则可能会报空指针异常
            //这句hash.get(temp)!=i可能多余
            if(hash.containsKey(temp)*//*&&hash.get(temp)!=i*//*){
                indexs[0] = i;
                indexs[1] = hash.get(temp);
                return indexs;
                //return new int[]{i,hash.get(temp)};
            }
        }
        //最后一句返回一定要有，代表未找到
        return indexs;*/

        //时间复杂度最低
        //思路：采取一边插入哈希表一边寻找一边在已经插入的哈希表中寻找的方式，每次都拿着即将插入哈希表的数字然后在哈希表中找是否存在剩下的那个函数。
        // 有人可能会问，在循环里面查找的话时间复杂度不就变高了嘛，
        // 但是哈希表查找时间可以说是o(1)是常数（避免冲突的算法采用链地址可能不为o(1)，但一般不用链地址来避免冲突），
        // 所以总的时间复杂度就为o(n)，哈希表就是一种用空间换取时间的算法。
        HashMap<Integer,Integer> hash = new HashMap<>();
        int[] indexs = new int[2];
        int complement = 0;
        for(int i = 0;i<nums.length;i++){
            //求补数
            complement = target-nums[i];
            //判断hash表中有补数吗，没有就将原数加入到哈希表中，如果有就取得二者的下标
            if(hash.containsKey(complement)){
                indexs[0] = i;
                indexs[1] = hash.get(complement);
                return indexs;
            }
            //将数值作为key,下标作为value
            hash.put(nums[i],i);
        }
        //最后一句返回一定要有，代表未找到
        return indexs;

        // 双重循环 循环极限为(n^2-n)/2
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = nums.length - 1; j > i; j --){
        //         if(nums[i]+nums[j] == target){
        //            indexs[0] = i;
        //            indexs[1] = j;
        //            return indexs;
        //         }
        //     }
        // }
        //最后一句返回一定要有，代表未找到
        //return indexs;


        // //普通的双重循环//时间复杂度高On(n^2)
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = 0; j < nums.length; j++)){
        //         if(nums[i]+nums[j] == target){
        //            indexs[0] = i;
        //            indexs[1] = j;
        //            return indexs;
        //         }
        //     }
        // }
        //最后一句返回一定要有，代表未找到
        //return indexs;
    }
}
