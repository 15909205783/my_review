package com.yangfan.neo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static void main(String[] args) {
        List<Integer> integers1 = Arrays.asList(9, 3, 15, 20, 7);
        Integer[] postorder = integers1.toArray(new Integer[0]);
        List<Integer> integers2 = Arrays.asList( 9,15,7,20,3);
        Integer[] inorder = integers2.toArray(new Integer[0]);
        Solution1 solution1 = new Solution1();
        TreeNode treeNode = solution1.buildIndexMap(postorder, inorder);
        System.out.println(treeNode);
    }

    Map<Integer,Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(Integer[] inorder, Integer[] postorder) {
        return buildIndexMap(inorder, postorder);
    }

    public TreeNode build(Integer[] postorder, Integer[] inorder,int inOrderLeft,int inOrderRight,int postorderLeft,int postorderRight){
        if(postorderLeft > postorderRight){
            return null;
        }
        int postOrderRoot = postorderRight;
        int rootInInorder =  indexMap.get(postorder[postOrderRoot]);
        int tempSize = rootInInorder  - inOrderLeft;
        TreeNode root = new TreeNode(postorder[postOrderRoot]);
        root.left=build(postorder,inorder,inOrderLeft,rootInInorder-1,postorderLeft,postorderLeft+tempSize-1);
        root.right=build(postorder,inorder,rootInInorder+1,inOrderRight,postorderLeft+tempSize,postorderRight-1);
        return root;
    }

    public TreeNode buildIndexMap(Integer[] inorder, Integer[] postorder){
        for(int i=0; i<inorder.length; i++){
            indexMap.put(inorder[i],i);
        }
        int n = postorder.length;
        return build(postorder,inorder,0,n-1,0,n-1);
    }
}
