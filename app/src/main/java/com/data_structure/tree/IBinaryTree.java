package com.data_structure.tree;

/**
 * Created by mbc on 19-6-21
 * Description:
 */
public abstract class IBinaryTree {

    public abstract Node find(Node root, int key);

    public abstract boolean update(Node node, int key, int value);

    public abstract void insert(Node root, int key, int value); // 插入节点

    public abstract boolean delete(Node node, int key); // 删除指定节点

    public abstract Node getDirectPostNode(Node delNode); // 得到待删除节点的直接后继节点

    public abstract void preOrder(Node rootNode); // 先序遍历树

    public abstract void inOrder(Node rootNode); // 中序遍历树

    public abstract void postOrder(Node rootNode); // 后序遍历树

    public abstract void layerOrder(Node rootNode); // 层序遍历
}
