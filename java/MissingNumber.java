public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = 0;
        for (int i = 0; i <= n; i++) {
            expectedSum += i;
        }
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        return expectedSum - sum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3,0,1}));
        System.out.println(missingNumber(new int[]{0,1}));
        System.out.println(missingNumber(new int[]{0}));
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
