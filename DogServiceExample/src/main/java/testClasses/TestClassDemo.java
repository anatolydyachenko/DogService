package testClasses;

import java.io.IOException;

/**
 * Created by adyachenko on 4/25/2017.
 */
public class TestClassDemo {

    public static void main(String[] args) throws IOException {
        int nums[] = {99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49};

        for (int j = 0; j < nums.length; j++) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
                System.out.print("Iteration (j/i) " + j + "/" + i + ": ");
                printNums(nums);
            }
        }
        printNums(nums);
    }

    public static void printNums(int nums[]) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.print("\n");
    }
}
