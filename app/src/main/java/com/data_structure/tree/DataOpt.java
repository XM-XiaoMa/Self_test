package com.data_structure.tree;


/**
 * Created by mbc on 19-6-21
 * Description:
 */
public class DataOpt {


    public static void main(String[] args) {
        // 数据准备
        Node A = Node.createBinaryTree();
        // 数据遍历
        BinarySortTree.getInstance().preOrder(A);
        System.out.print("\n");
        BinarySortTree.getInstance().inOrder(A);
        System.out.print("\n");
        BinarySortTree.getInstance().postOrder(A);
        System.out.print("\n");
        BinarySortTree.getInstance().layerOrder(A);
        System.out.print("\n");

        // 二叉排序树-数据准备
        Node _8 = Node.createBinarySortTree();
        // 二叉排序树中序遍历
        BinarySortTree.getInstance().inOrder(_8);
        System.out.print("\n");
        // 二叉排序树结点查找 - 10
        Node targetNode = BinarySortTree.getInstance().find(_8, 10);
        System.out.print("key = " + targetNode.getKey() + "  " + "value = " + targetNode.getValue());
        System.out.print("\n");
        // 二叉排序树结点插入
        BinarySortTree.getInstance().insert(_8, 10, 30);
        BinarySortTree.getInstance().inOrder(_8);
        System.out.print("\n");
        // 二叉排序树结点更新
        BinarySortTree.getInstance().update(_8, 10, 10);
        BinarySortTree.getInstance().inOrder(_8);
        System.out.print("\n");
        // 二叉排序树结点删除
        BinarySortTree.getInstance().delete(_8, 8);
        BinarySortTree.getInstance().inOrder(_8);
        System.out.print("\n");
        // 二叉排序树获取右子树最小结点
        Node rchildMin = BinarySortTree.getInstance().getRchildMin(_8);
        System.out.print("key = " + rchildMin.getKey() + "  " + "value = " + rchildMin.getValue());
        System.out.print("\n");
    }
}