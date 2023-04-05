package com.steady.leetcode.d1_array;

/**
 * 原地,移除数组中的指定元素,不使用额外的空间,返回删除后的长度
 */
public class RemoveEle {
    /**
     * 暴力解法,两层for遍历
     */
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int count = len;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val){
                for (int j = i; j < len; j++) {
                    nums[j] = nums[j+1];
                }
                count--;
            }
        }
        return count;
    }
    
    
    /**
     * 双指针法,通过一个快指针和慢指针在一个for循环下完成两个for循环的工作<br>
     * * 快指针：寻找新数组的元素 ，新数组就是不含有目标元素的数组<br>
     * * 慢指针：指向更新 新数组下标的位置
     */
    public int removeElement1(int[] nums, int val) {
        // 快慢指针
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            //如果 = 直接跳过!
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
    
    
    /**
     * 相向双指针法
     */
    public int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while(right >= 0 && nums[right] == val)
            right--; //将right移到从右数第一个值不为val的位置
        
        while(left <= right) {
            if(nums[left] == val) { //left位置的元素需要移除
                //将right位置的元素移到left（覆盖），right位置移除
                nums[left] = nums[right];
                right--;
            }
            left++;
            while(right >= 0 && nums[right] == val) right--;
        }
        return left;
    }
}
