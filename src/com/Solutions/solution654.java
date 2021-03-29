package com.Solutions;

/**
 * 构建最大二叉树
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 *
 */
public class solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length -1);
    }
    private TreeNode constructMaximumBinaryTree(int[] nums, int low, int high){
        if(low > high){
            return null;
        }


        // 标准定位最大值，定位最大值的索引
        int index = 0;
        int maxVal = Integer.MIN_VALUE;
        for(int i = low; i <= high ; ++i){
            if(nums[i] > maxVal){
                maxVal = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);

        //记住根做什么就行了，左右按照他们的规则进行相应的递归即可.
        root.left = constructMaximumBinaryTree(nums, low, index - 1);
        root.right =constructMaximumBinaryTree(nums, index+1, high);
        return root;
    }
}
