package Algorithms.Sort;

public class Test {
    public static int[] sortArray(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1) return nums;
        sort(nums, 0, len - 1);
        return nums;
    }

    public static void sort(int[] nums, int i , int j){
        if(i >= j) return;
        int pivot = partition(nums, i, j);
        sort(nums, i, pivot-1);
        sort(nums, pivot + 1, j);
    }

    public static int partition(int[] nums, int i, int j){
        int pivot = nums[j];
        int tempLocation = i;
        for(int k = i; k < j; ++k){
            if(nums[k] < pivot){
                int temp = nums[tempLocation];
                nums[tempLocation] = nums[k];
                nums[k] = temp;
                ++tempLocation;
            }
        }
        int temp = nums[tempLocation];
        nums[tempLocation] = nums[j];
        nums[j] = temp;
        return tempLocation;
    }

    public static void main(String[] args) {
        int[] array = {5,1,1,2,0,0};
        sortArray(array);
        for(int i:array) System.out.println(i);
    }
}

