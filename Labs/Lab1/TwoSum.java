package Lab.Lab1;
import java.util.*;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> sum = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            //value is 9-i
            int complement = target - nums[i];
            if (sum.containsKey(complement))
            {
                return new int [] {sum.get(complement),nums[i]};
            }
            sum.put(nums[i],i);
        }
        return new int[]{};
        
    }
}
