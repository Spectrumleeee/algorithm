package xmu.cs.lgp.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Des leetcode.1
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author gplee@sina.cn
 * @Date 2019/6/9 17:04
 **/
public class SumOfTwoNums {

    public static void main(String[] args) {
        int[] nums = new int[]{7, 8, 9, 11};
        int[] rst = twoSum(nums,  18);
        for (int i=0; i<rst.length; i++) {
            System.out.print(" " + rst[i]);
        }
    }

    public static int[] twoSum(int[] nums,  int target) {
        Map<Integer, Integer> num2IndexMap = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            int complement = target - nums[i];
            if (num2IndexMap.containsKey(complement)) {
                return new int[]{num2IndexMap.get(complement), i};
            } else {
                num2IndexMap.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two number");
    }

}
