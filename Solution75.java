public class Solution75 {
    public void sortColors(int[] nums) {
        // Initialize three pointers
        int low = 0;    // All elements before 'low' are 0 (red)
        int mid = 0;    // 'mid' is used to traverse the array
        int high = nums.length - 1;  // All elements after 'high' are 2 (blue)
        
        // Traverse the array
        while (mid <= high) {
            switch (nums[mid]) {
                case 0: 
                    // If the element is 0, swap it with the element at 'low'
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1: 
                    // If the element is 1, just move the 'mid' pointer forward
                    mid++;
                    break;
                case 2: 
                    // If the element is 2, swap it with the element at 'high'
                    swap(nums, mid, high);
                    high--;
                    break;
            }
        }
    }
    
    // Helper method to swap elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Main method to run the solution
    public static void main(String[] args) {
        Solution75 solution = new Solution75();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
