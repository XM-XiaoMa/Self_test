package com.data_structure.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by mbc on 19-6-21
 * Description: 二叉排序树
 */
public class BinarySortTree extends IBinaryTree {

    private static BinarySortTree tree;

    private BinarySortTree() {
    }

    public synchronized static BinarySortTree getInstance() {
        if (tree == null) {
            synchronized (BinarySortTree.class) {
                if (tree == null) {
                    tree = new BinarySortTree();
                }
            }
        }
        return tree;
    }

    /**
     * 二叉排序树独有的查找方法
     *
     * @param root
     * @param key
     * @return
     */
    @Override
    public Node find(Node root, int key) {
        if (root == null)
            return null;
        Node currentNode = root;
        while (currentNode != null && Integer.valueOf(currentNode.getKey()) != key) {
            if (key < Integer.valueOf(currentNode.getKey()))
                currentNode = currentNode.getlTree();
            else if (key > Integer.valueOf(currentNode.getKey()))
                currentNode = currentNode.getrTree();
        }
        return currentNode;
    }

    @Override
    public boolean update(Node root, int key, int value) {
        Node node = find(root, key);
        node.setValue(String.valueOf(value));
        return true;
    }

    @Override
    public void insert(Node root, int key, int value) {
        // 二叉树为空，新增根节点
        if (root == null) {
            root = new Node();
            root.setKey(String.valueOf(key));
            root.setKey(String.valueOf(value));
            return;
        }
        //  要么就替换相同key的值，要么就当成叶子插入
        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftNode = false;
        while (currentNode != null) {
            parentNode = currentNode;
            if (key < Integer.valueOf(currentNode.getKey())) {
                isLeftNode = true;
                // 在左子树处理
                currentNode = currentNode.getlTree();
            } else if (key > Integer.valueOf(currentNode.getKey())) {
                isLeftNode = false;
                // 在右子树处理
                currentNode = currentNode.getrTree();
            } else {
                // 替换相同key的值
                parentNode.setValue(String.valueOf(value));
                return;
            }
        }
        // 队列中没有key相同的，作为叶子插入就好
        Node newRoot = new Node();
        newRoot.setKey(String.valueOf(key));
        newRoot.setValue(String.valueOf(value));
        if (isLeftNode) {
            parentNode.setlTree(newRoot);
        } else {
            parentNode.setrTree(newRoot);
        }
    }

    @Override
    public boolean delete(Node root, int key) {
        Node currentNode = root;// 用来保存待删除节点
        Node parentNode = root;// 用来保存待删除节点的父亲节点
        Node temp = null;// 用来保存待删除节点的父亲节点
        boolean isLeftChild = true;// 用来保存待删除节点是父亲节点的左孩子还是右孩子
        // 寻找删除节点并记录删除节点的父节点以及他是父节点的左孩子还是右孩子
        while ((currentNode != null) && (Integer.valueOf(currentNode.getKey()) != key)) {
            parentNode = currentNode;
            if (key < Integer.valueOf(currentNode.getKey())) {
                currentNode = currentNode.getlTree();
                isLeftChild = true;
            } else {
                currentNode = currentNode.getrTree();
                isLeftChild = false;
            }
        }
        if (currentNode == null) return false;

        if ((currentNode.getlTree() == null) && (currentNode.getrTree() == null)) {
            // 要删除的节点为叶子节点，删除的第一种情况
            if (currentNode == root) {
                root = null;
            } else if (isLeftChild) {
                parentNode.setlTree(null);
            } else {
                parentNode.setrTree(null);
            }
        } else if ((currentNode.getrTree() == null) && (currentNode.getlTree() != null)) {
            // 要删除的节点只有左孩子 第二种情况
            if (currentNode == root) {
                root = currentNode.getlTree();
            } else if (isLeftChild) {
                parentNode.setrTree(currentNode.getlTree());
            } else {
                parentNode.setrTree(currentNode.getlTree());
            }
        } else if ((currentNode.getlTree() == null) && (currentNode.getrTree() != null)) {
            // 要删除的节点只有右孩子 第三种情况
            if (currentNode == root) {
                root = currentNode.getrTree();
            } else if (isLeftChild) {
                parentNode.setlTree(currentNode.getrTree());
            } else {
                parentNode.setrTree(currentNode.getrTree());
            }
        } else {
            /* 1. 查询前驱 2. 前驱key-value代替待删除项key-value 3. 删除前驱结点（前驱结点的子结点代替前驱结点成为前驱结点父结点的子结点）*/
            Node pre_node = currentNode.getlTree(); // 前驱结点
            Node pre_node_par = currentNode; // 前驱结点的父结点
            while (pre_node.getrTree() != null) {
                // 某结点的前驱是左子树最右边的结点（最大的数）
                pre_node_par = pre_node;
                pre_node = pre_node.getrTree();
            }
            currentNode.setKey(pre_node.getKey());
            currentNode.setValue(pre_node.getValue());
            // pre_node指向被删结点的前驱, 注意pre_node是只有左子树的
            if (pre_node_par != currentNode) {
                // pre_node是pre_node_par的右子树，pre_node右结点成为pre_node_par右结点
                pre_node_par.setrTree(pre_node.getlTree());
            } else {
                // pre_node时pre_node_oar的左子树，pre_node左结点成为pre_node_par左结点
                pre_node_par.setlTree(pre_node.getlTree());
            }
        }
        return true;
    }

    public Node getRchildMin(Node root) {
        Stack<Node> minParentStack = new Stack<Node>();
        Node min = null, temp = root.getrTree();
        minParentStack.push(temp);
        Node insertNode = temp;
        while (temp != null) {
            if (temp.getlTree() != null) {
                minParentStack.push(temp);
                min = temp;
                temp = temp.getlTree();
            } else if (temp.getrTree() != null) {
                min = temp;
                Node minParent = minParentStack.pop();
                minParent.setlTree(null);
                while (temp != null) {
                    if (temp.getrTree() == null) {
                        temp.setrTree(insertNode);
                        break;
                    } else {
                        temp = temp.getrTree();
                    }
                }
                break;
            } else {
                min = temp;
                break;
            }
        }
        return min;
    }

    @Override
    public Node getDirectPostNode(Node delNode) {
        // 方法作用为得到待删除节点的直接后继节点
        // 用来保存待删除节点的直接后继节点的父亲节点
        Node parentNode = delNode;
        // 用来保存待删除节点的直接后继节点
        Node direcrPostNode = delNode;
        // 待删除节点右子树
        Node currentNode = delNode.getrTree();
        while (currentNode != null) {
            parentNode = direcrPostNode;
            direcrPostNode = currentNode;
            currentNode = currentNode.getlTree();
        }
        if (direcrPostNode != delNode.getrTree()) {
            parentNode.setlTree(direcrPostNode.getrTree());
            direcrPostNode.setrTree(null);
        }
        return direcrPostNode;
        // 返回此直接后继节点
    }

    @Override
    public void preOrder(Node rootNode) {
        if (rootNode == null)
            return;
        System.out.print(rootNode.getValue() + "-");
        preOrder(rootNode.getlTree());
        preOrder(rootNode.getrTree());
    }

    @Override
    public void inOrder(Node rootNode) {
        if (rootNode == null)
            return;
        inOrder(rootNode.getlTree());
        System.out.print(rootNode.getValue() + "-");
        inOrder(rootNode.getrTree());
    }

    @Override
    public void postOrder(Node rootNode) {
        if (rootNode == null)
            return;
        postOrder(rootNode.getlTree());
        postOrder(rootNode.getrTree());
        System.out.print(rootNode.getValue() + "-");

    }

    @Override
    public void layerOrder(Node rootNode) {
        /*精髓在于拿取第一结点之后，将该结点的左右子结点自左向右顺序放入队尾*/
        if (rootNode == null)
            return;
        LinkedList<Node> nodeLinkedList = new LinkedList<>();
        nodeLinkedList.offer(rootNode);
        while (nodeLinkedList.size() > 0) {
            /*处理结点*/
            Node node = nodeLinkedList.pollFirst();
            System.out.print(node.getValue() + "-");
            /*放入结点*/
            if (node.getlTree() != null)
                nodeLinkedList.offer(node.getlTree());
            if (node.getrTree() != null)
                nodeLinkedList.offer(node.getrTree());
        }
    }
}
