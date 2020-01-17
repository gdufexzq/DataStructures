package com.gdufe.tree.threadedbinarytree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: https://blog.51cto.com/yushiwh/2439518
 * @author xuzq
 * @date 2020/1/9 16:47
 * @version V1.0
 */
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        // 测试一把中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");


        // 二叉树，后面我们要递归创建，现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        // 测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
//        threadedBinaryTree.threadNodes(); // 中序线索化
//        threadedBinaryTree.preThreadNodes(); // 前序线索化
        threadedBinaryTree.postThreadNodes(); // 后序线索化

        // 测试: 以10号节点测试
        HeroNode left = node5.getLeft();
        HeroNode right = node5.getRight();
//        System.out.println("10号节点的前驱节点是 = " + left);
//        System.out.println("10号节点的后驱节点是 = " + right);


        // 当线索化二叉树后，不能再使用原来的遍历方法
//        threadedBinaryTree.infixOrder();
        System.out.println("使用线索化的方式遍历线索化二叉树");
//        threadedBinaryTree.threadedList(); // 中序 8,3,10,1,6,14
//        threadedBinaryTree.preThreadedList(); // 前序 1,3,8,10,6,14


        /**
         * 线索化后序遍历
         */
        //如果是后序，需要创建二叉树的时候，将parent进行保存。这个是用于后续二叉树的遍历的
        node2.setParent(root);
        node3.setParent(root);
        node4.setParent(node2);
        node5.setParent(node2);
        node6.setParent(node3);
        threadedBinaryTree.postThreadedList(); // 后序 8,10,3,14,6,1
    }
}


// 定义ThreadedBinaryTree 二叉树
class ThreadedBinaryTree {
    private HeroNode root;

    // 为了实现线索化，需要创建一个指向当前节点的前驱节点的指针
    // 在递归进行线索化时，pre总是保留前一个节点
    private HeroNode pre = null;




    public void setRoot(HeroNode root) {
        this.root = root;
    }


    // 中序遍历遍历线索化二叉树的方法
    public void threadedList() {
        // 定义一个变量，存储当前遍历的节点，从root开始
        HeroNode node = root;
        while (node != null) {
            // 循环的找到leftType == 1的节点，第一个找到的就是8节点
            // 后面随着遍历而变化，因为当LeftType==1时，说明该节点是按照线索化
            // 处理后面的有效节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }

            // 打印当前这个节点
            System.out.println(node);

            // 如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType() == 1) {
                // 获取到当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            // 替换这个遍历的节点
            node = node.getRight();
        }
    }


    // 前序遍历遍历线索化二叉树的方法
    public void  preThreadedList() {
        // 定义一个变量，存储当前遍历的节点，从root开始
        HeroNode node = root;
        while (node != null) {

            // 循环的找到leftType == 1的节点，第一个找到的就是8节点
            // 后面随着遍历而变化，因为当LeftType==1时，说明该节点是按照线索化
            // 处理后面的有效节点
            while (node.getLeftType() == 0) {
                // 打印当前这个节点
                System.out.println(node);
                node = node.getLeft();
            }
            // 打印当前节点
            System.out.println(node);
            // 如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType() == 1) {
                // 获取到当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            // 替换这个遍历的节点
            node = node.getRight();
        }
    }

    /**
     * 后序线索化二叉树遍历方法
     * <p>
     * 注意后序有点复杂，需要建立二叉树的时候，将节点的parent进行赋值，否则不能遍历成功
     * 1
     * /   \
     * 3     6
     * / \   /
     * 8  10 14
     * <p>
     * {8,10,3,1,14,6}
     * 1. 如果leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
     * 2. 如果rightType == 0 表示指向是右子树, 如果 1表示指向后继结点
     */
    public void postThreadedList() {
        //1、找后序遍历方式开始的节点
        HeroNode node = root;
        while ( node != null && node.getLeftType() == 0 ) {
            node = node.getLeft();
        }
        while ( node != null ) {
            //右节点是线索
            if (node.getRightType() == 1) {
                System.out.print(node + ", ");
                pre = node;
                node = node.getRight();
            } else {
                //如果上个处理的节点是当前节点的右节点
                if (node.getRight() == pre) {
                    System.out.print(node + ", ");
                    if (node == root) {
                        return;
                    }
                    pre = node;
                    node = node.getParent();
                } else {    //如果从左节点的进入则找到有子树的最左节点
                    node = node.getRight();
                    while ( node != null && node.getLeftType() == 0 ) {
                        node = node.getLeft();
                    }
                }
            }
        }
    }



    // 重载一把threadNodes方法
    public void threadNodes() {
        this.threadedNodes(root);
    }

    public void preThreadNodes() {
        this.preThreadedNodes(root);
    }

    public void postThreadNodes() {
        this.postThreadedNodes(root);
    }

    // 编写对二叉树进行中序线索化的方法

    /**
     * 前序线索化: 1,3,8,10,6,14
     * 根是左的前驱
     * 左是右的前驱
     *中序遍历的结果：{8, 3, 10, 1, 14, 6}
     * 左是根的前驱
     * 根是右的前驱
     *
     * 前序线索化: 8,10,3,14,6,1
     * 左是右的前驱
     * 右是根的前驱
     * @param node 为当前需要线索化的节点
     */
    public void threadedNodes(HeroNode node) {

        // 如果node==null,不能线索化
        if(node == null) {
            return;
        }

        // (一) 先线索化左子树
        threadedNodes(node.getLeft());
        // (二) 线索化当前节点[有难度]
        // 处理当前节点的前驱节点
        // 以8节点来理解
        // 8节点的.left = null, 8节点的leftType = 1
        if(node.getLeft() == null) {
            // 让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            // 修改当前节点的左指针类型，指向前驱节点
            node.setLeftType(1);
        }

        // 处理后继节点
        if(pre != null && pre.getRight() == null) {
            // 让前驱节点的右指针指向当前节点
            pre.setRight(node);
            // 修改前序节点的右指针类型
            pre.setRightType(1);
        }
        // !!! 每处理一个节点后，让当前节点是下一个节点的前驱节点
        // pre等于node,等到下次递归回退时，pre为上次递归访问的节点
        pre = node;

        // (三) 再线索化右子树
        threadedNodes(node.getRight());

    }

    /**
     * 前序线索化: 1,3,8,10,6,14
     * 根是左的前驱
     * 左是右的前驱
     * @param node
     */
    public void preThreadedNodes(HeroNode node) {

        // 如果node==null,不能线索化
        if(node == null) {
            return;
        }

        // (一) 线索化当前节点[有难度]
        // 处理当前节点的前驱节点
        // 以8节点来理解
        // 8节点的.left = null, 8节点的leftType = 1
        boolean leftFlag = true; // 线索化的标志
        if(node.getLeft() == null) {
            leftFlag = false; // 如果该节点的左节点进行了线索化之后，进入下次循环时，让它为null，否则会死循环
            // 让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            // 修改当前节点的左指针类型，指向前驱节点
            node.setLeftType(1);
        }

        // 处理后继节点
        boolean rightFlag = true;
        if(pre != null && pre.getRight() == null) {
            // 让前驱节点的右指针指向当前节点
            rightFlag = false;  // 如果该节点的右节点进行了线索化之后，进入下次循环时，让它为null，否则会死循环
            pre.setRight(node);
            // 修改前序节点的右指针类型
            pre.setRightType(1);
        }
        // !!! 每处理一个节点后，让当前节点是下一个节点的前驱节点
        // pre等于node,等到下次递归回退时，pre为上次递归访问的节点
        pre = node;

        // (二) 先线索化左子树
        preThreadedNodes(leftFlag ? node.getLeft() : null);
        // (三) 再线索化右子树
        preThreadedNodes(rightFlag ? node.getRight() : null);
    }


    /**
     * 后序线索化
     * @param node
     */
    public void postThreadedNodes(HeroNode node) {

        // 如果node==null,不能线索化
        if(node == null) {
            return;
        }

        // (一) 先线索化左子树
        postThreadedNodes(node.getLeft());
        // (二) 再线索化右子树
        postThreadedNodes(node.getRight());

        // (三) 线索化当前节点[有难度]
        // 处理当前节点的前驱节点
        // 以8节点来理解
        // 8节点的.left = null, 8节点的leftType = 1
        if(node.getLeft() == null) {
            // 让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            // 修改当前节点的左指针类型，指向前驱节点
            node.setLeftType(1);
        }

        // 处理后继节点
        if(pre != null && pre.getRight() == null) {
            // 让前驱节点的右指针指向当前节点
            pre.setRight(node);
            // 修改前序节点的右指针类型
            pre.setRightType(1);
        }
        // !!! 每处理一个节点后，让当前节点是下一个节点的前驱节点
        // pre等于node,等到下次递归回退时，pre为上次递归访问的节点
        pre = node;
    }


    // 前序遍历
    public void preOrder() {
        if(this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 中序遍历
    public void infixOrder() {
        if(this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 后序遍历
    public void postOrder() {
        if(this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 非递归前序遍历
     */
    public void preOrderByNoRecursion() {
        HeroNode cur = root;
        ArrayList<HeroNode> list = new ArrayList<>();
        Stack<HeroNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {

            while (cur != null) {
                stack.push(cur);
                list.add(cur);
                cur = cur.getLeft();
            }
            HeroNode top = stack.pop();
            cur = top.getRight();
        }
        System.out.println("非递归前序遍历:"  + list);
    }


    /**
     * 非递归中序遍历
     *
     */
    public void infixOrderByNoRecursion() {
        HeroNode cur = root;
        ArrayList list = new ArrayList<>();
        Stack<HeroNode> stack = new Stack<>();
        // 两者之一不为空都说明还有元素未遍历
        while (cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.getLeft();
            }
            HeroNode top = stack.pop();
            list.add(top);
            cur = top.getRight();
        }
        System.out.println("中序遍历:" + list);
    }

    /**
     * 非递归后序遍历
     */
    public void postOrderByNoRecursion() {
        HeroNode cur = root;
        ArrayList<HeroNode> list = new ArrayList<>();
        ArrayList<HeroNode> supList = new ArrayList<>(); // 辅助栈，用来判断根节点的访问状态
        Stack<HeroNode> stack = new Stack<>();


        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.getLeft();
            }

            HeroNode top = stack.peek();

            // 只有当前右节点为空，才把当前节点加入到list
            if(top.getRight() == null) {
                HeroNode pop = stack.pop();
                list.add(pop);

            } else {
                if(supList.contains(top)){
                    // 该节点已经被访问过，直接弹出
                    HeroNode pop = stack.pop();
                    list.add(pop);
                } else {
                    supList.add(top);
                    // 当cur到达二叉树的最右边的节点时，cur的值就不要让它变了，一直为空，否则有问题
                    cur = stack.peek().getRight();
                }
            }
        }
        System.out.println("非递归后序遍历:"  + list);
    }


    // 前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if(root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    // 中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        if(root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    // 后序遍历查找
    public HeroNode postOrderSearch(int no) {
        if(root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    // 删除节点
    public void delNode(int no) {
        if(root != null) {
            // 如果只有一个节点，这里立即判断root是不是就是要删除的系欸但
            if(root.getNo() == no) {
                root = null;
            } else {
                // 递归删除
                root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除");
        }
    }
}


// 先创建HeroNode, 节点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    /**
     * //父节点的指针（为了后序线索化使用）
     */
    private HeroNode parent;

    public HeroNode getParent() {
        return parent;
    }

    public void setParent(HeroNode parent) {
        this.parent = parent;
    }

    // 说明
    // 1. 如果leftType = 0, 表示指向的是左子树，1，表示指向前驱节点
    // 2. 如果rightType == 0, 表示指向的是 右子树， 为1表示指向的是后驱节点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    // 编写前序遍历的方法
    public void preOrder() {
        System.out.println(this); // 先输出父节点
        // 递归向左子树遍历
        if(this.left != null) {
            this.left.preOrder();
        }
        // 递归向右子树前序遍历
        if(this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void infixOrder() {
        // 递归向左子树中序遍历
        if(this.left != null) {
            this.left.infixOrder();
        }
        // 输出父节点
        System.out.println(this);
        // 递归向右子树中序遍历
        if(this.right != null) {
            this.right.infixOrder();
        }
    }

    // 后序遍历
    public void postOrder() {
        // 递归向左子树后续遍历
        if(this.left != null) {
            this.left.postOrder();
        }
        // 递归向右子树后序遍历
        if(this.right != null) {
            this.right.postOrder();
        }
        // 输出父节点
        System.out.println(this);
    }

    // 前序遍历查找
    /**
     *如果找到则返回该Node,如果没有找到返回null
     */
    public HeroNode preOrderSearch(int no) {
        // 比较当前节点是不是
        System.out.println("进入前序遍历...");
        if(this.no == no) {
            return this;
        }
        // 判断当前节点的左节点是否为空，如果不为空，则递归前序查找
        HeroNode resNode = null;
        if(this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode != null) {
            return resNode;
        }
        // 1. 左递归前序,找到节点，则返回，否则继续判断
        // 2. 当前节点的右子节点是否为空，如果不空，则继续向右递归前序查找
        if(this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    // 中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;
        // 判断当前节点的子节点是否为空，如果不为空，则递归中序查找
        if(this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        // 需要这个判断，因为左递归resNode找到了，这一步可以提前结束递归，不用继续执行右递归,否则会找不到
        if(resNode != null) {
            return resNode;
        }
        // 如果找到，则返回，如果没有找到，就和当前节点比较，如果是则返回当前节点
        System.out.println("进入中序遍历...");
        if(this.no == no) {
            return this;
        }
        // 否则继续进行右递归的中序查找
        if(this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    // 后续遍历查找
    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if(this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        // 左子树找到就不用往右子树继续找
        if(resNode != null) {
            return resNode;
        }
        if(this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        // 如果在右子树找到则返回
        if(resNode != null) {
            return resNode;
        }
        System.out.println("进入后序遍历..");
        if(this.no == no) {
            return this;
        }
        return resNode;
    }


    // 递归删除节点
    // 1. 如果删除的节点时叶子节点，则删除该节点
    // 2. 如果删除的节点是非叶子节点，则删除该子树
    public void delNode(int no) {
        // 思路
        /*
         1. 因为我们的二叉树是单向的，所以我们是判断当前节点的子几点是否是需要删除的节点，而不能判断当前这个节点的
            是不是需要删除的节点。
          2. 如果当前节点的左子节点不为空，并且左子节点就是要删除的节点，就将this.left = null, 并且返回(结束递归删除)
          3. 如果当前节点的右子节点不为空，并且右子节点就是要删除的节点，就将this.right = null, 并且返回(结束递归删除)
          4. 如果第2和第3步没有删除节点，那么我们就需要向左子树递归删除
          5. 如果第4步也没有删除节点，则应当向右子树进行递归删除
         */
        if(this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if(this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
//        4. 如果第2和第3步没有删除节点，那么我们就需要向左子树递归删除
        if(this.left != null) {
            this.left.delNode(no);
        }
        if(this.right != null) {
            this.right.delNode(no);
        }

    }
}

