package com.Solutions;

import java.util.*;

/**
 * 寻找重复的子树，只返回重复的一颗。
 *
 * 注意 HashSet 不能对对象进行添加去重
 * 除非自己改写equals和hashcode方法。否则对象的值相同，但是对象的哈希并不相同。
 */
public class solution652 {
    Map<String, Integer> map = new HashMap<String, Integer>();
    List<TreeNode> result = new LinkedList<TreeNode>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return result;
    }

    private String traverse(TreeNode root){
        if(root == null) return "#";

        String left = traverse(root.left);
        String right = traverse(root.right);

        String str = left + ',' + right + ',' + root.val;

        if(map.getOrDefault(str, 0) == 1){
            map.put(str,2);
            result.add(root);
        }else{
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        return str;
    }
}
