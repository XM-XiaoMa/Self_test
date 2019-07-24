package com.data_structure.tree;

/**
 * Created by mbc on 19-6-21
 * Description:
 */
public class Node {
    private String key;/*数据key*/

    private String value;/*数据value*/
    private Node lTree;/*左子树*/
    private Node rTree;/*右子树*/
    private Node pTree;/*双亲结点*/

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getlTree() {
        return lTree;
    }

    public void setlTree(Node lTree) {
        this.lTree = lTree;
    }

    public Node getrTree() {
        return rTree;
    }

    public void setrTree(Node rTree) {
        this.rTree = rTree;
    }

    public Node getpTree() {
        return pTree;
    }

    public void setpTree(Node pTree) {
        this.pTree = pTree;
    }


    /**
     * 创建随便的二叉树
     *
     * @return
     */
    static Node createBinaryTree() {
        Node A = new Node();
        A.setValue("A");
        Node B = new Node();
        B.setValue("B");
        Node C = new Node();
        C.setValue("C");
        Node D = new Node();
        D.setValue("D");
        Node E = new Node();
        E.setValue("E");
        Node F = new Node();
        F.setValue("F");
        Node G = new Node();
        G.setValue("G");
        Node H = new Node();
        H.setValue("H");
        Node I = new Node();
        I.setValue("I");
        Node J = new Node();
        J.setValue("J");

        A.setlTree(B);
        A.setrTree(C);

        B.setlTree(D);
        B.setrTree(E);

        C.setlTree(F);
        C.setrTree(G);

        D.setlTree(H);
        D.setrTree(I);

        E.setlTree(J);
        return A;
    }

    /**
     * 创建二叉排序树
     *
     * @return
     */
    static Node createBinarySortTree() {
        Node _8 = new Node();
        _8.setKey("8");
        _8.setValue("8");
        Node _3 = new Node();
        _3.setKey("3");
        _3.setValue("3");
        Node _10 = new Node();
        _10.setKey("10");
        _10.setValue("10");
        Node _1 = new Node();
        _1.setKey("1");
        _1.setValue("1");
        Node _6 = new Node();
        _6.setKey("6");
        _6.setValue("6");
        Node _4 = new Node();
        _4.setKey("4");
        _4.setValue("4");
        Node _7 = new Node();
        _7.setKey("7");
        _7.setValue("7");
        Node _14 = new Node();
        _14.setKey("14");
        _14.setValue("14");
        Node _13 = new Node();
        _13.setKey("13");
        _13.setValue("13");

        _8.setlTree(_3);
        _8.setrTree(_10);

        _3.setlTree(_1);
        _3.setrTree(_6);

        _6.setlTree(_4);
        _6.setrTree(_7);

        _10.setrTree(_14);

        _14.setlTree(_13);
        return _8;
    }
}
