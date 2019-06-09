package xmu.cs.lgp.algorithm.hash;

import xmu.cs.lgp.algorithm.sort.QuickSortRecursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Des leetcode.15
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author gplee@sina.cn
 * @Date 2019/6/9 17:51
 **/
public class SumOfThreeNums {

    public static void main(String[] args) {
        int[]  nums = new int[] {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> rst = threeSum(nums);

        if (rst != null && rst.size() > 0) {
            for (List<Integer> answer : rst) {
                if (answer != null && answer.size() > 0) {
                    for (Integer item : answer) {
                        System.out.print(" " + item);
                    }
                    System.out.println();
                }
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // 首先按照从小到大排序
        QuickSortRecursive.sort(nums, 0,   nums.length - 1);

        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        for (int i=0; i<nums.length; i++) {
            // 3个数字之和为0，那么最小的那个数定然是负数
            if (nums[i] > 0) {
                break;
            }

            // 如果两个数字相同，直接跳到下个循环(之前已经计算过)，因为输出不重复的三元组
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            int j = i+1, k=nums.length-1;
            int target = 0 - nums[i];
            while(j < k) {
                if (nums[j] + nums[k] == target) {
                    List<Integer> newAnswer = new ArrayList<Integer>();
                    newAnswer.addAll(Arrays.asList(nums[i], nums[j], nums[k]));
                    rst.add(newAnswer);

                    while(j < k && nums[j] == nums[j+1]) {
                        j += 1;
                    }
                    while(j < k && nums[k] == nums[k-1]) {
                        k -= 1;
                    }

                    j += 1;
                    k -= 1;
                } else if (nums[j] + nums[k] < target) {
                    j += 1;
                } else {
                    k -= 1;
                }
            }
        }

        return rst;
    }

}
