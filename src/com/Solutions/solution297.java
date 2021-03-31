package com.Solutions;
import java.util.*;

/**
 * 二叉树的 序列化 和 反序列化
 */

public class solution297 {

    String SEP = ",";
    String NULL = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<Integer> list = new LinkedList<Integer>();
        for(String s : data.split(",")){
            if(s.equals("#")){
                list.add(-1001);
            }else{
                list.add(Integer.parseInt(s));
            }

        }
        return deserialize(list);
    }

    private TreeNode deserialize(Deque<Integer> list){
        if(list.isEmpty()) return null;

        int rootVal = list.removeFirst();
        TreeNode root;
        if(rootVal == -1001){
            return null;
        }else{
            root = new TreeNode(rootVal);
        }

        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;

    }
}
