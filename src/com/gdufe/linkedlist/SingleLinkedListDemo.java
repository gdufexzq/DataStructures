package com.gdufe.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

        // 测试
        // 先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // 创建单链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();



        // 加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);

        // 测试一下单链表的反转
        System.out.println("原来链表的情况~~~");
        singleLinkedList.list();

//        System.out.println("反转单链表");
//        reversetList(singleLinkedList.getHead());
//        singleLinkedList.list();

        System.out.println("逆序打印单链表~~~");
        reversePrint2(singleLinkedList.getHead().next);


        // 加入按照编号顺序
//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero3);
//
//        System.out.println("修改前");
//        singleLinkedList.list();
//        HeroNode hero5 = new HeroNode(2, "小卢", "玉麒麟~~");
//        singleLinkedList.update(hero5);
//        System.out.println("修改前");
//        singleLinkedList.list();
//
//        // 删除一个节点
//        singleLinkedList.del(1);
//        singleLinkedList.del(4);
//        System.out.println("删除后的链表情况~~~");
//        singleLinkedList.list();
//
//        // 测试一下 求单链表中有效节点的个数
//        System.out.println("有效的节点个数：" + getLength(singleLinkedList.getHead()));
//
//        // 测试一下看看是否得到了倒数第K个节点
//        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 3);
//        System.out.println("res=" + res);
    }

    // 使用方式二，可以利用栈这个数据结构，将各个节点压入栈中， 然后利用栈的先进后出的特点，就实现了逆序打印的效果
    public static void reversePrint(HeroNode head) {
        if(head.next == null) {
            return ;
        }
        // 创建一个栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next; // cur后移，这样就可以压入下一个节点
        }
        // 将栈进行打印 pop
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    public static void reversePrint2(HeroNode head) {
        if(head == null) {
           return;
        } else {
            reversePrint2(head.next);
        }

        System.out.println(head);
    }

    // 将单链表反转
    public static void reversetList(HeroNode head) {
        // 如果当前链表为空，或则只有一个节点，无需反转，直接返回
        if(head.next == null || head.next.next == null) {
            return ;
        }
        // 定义一个辅助的变量，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null; // 指向当前节点【cur】的下一个节点
        HeroNode reverseNext = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        // 遍历原来的链表
        // 并从头到位遍历原来的链表，每遍历一个节点，就将其取出，并放在新的reverseHead的最前端
       /** while (cur != null) {
            next = cur.next; // 先暂时保存当前节点的下一节点，后面有用
            reverseNext = reverseHead.next;
            reverseHead.next = cur; // 将cur的下一节点指向新的链表的最前端
            cur.next = null; // 去掉摘取下来的节点的引用，防止循环引用
            if(reverseNext != null) {
                reverseHead.next.next = reverseNext;
            }
            cur = next; // 让cur后移
        }*/

       while (cur != null) {
           next = cur.next; // 先暂时保存当前节点的下一节点，因为后面需要使用
           cur.next = reverseHead.next; // 将cur的下一个节点指向新的链表的最前端
           reverseHead.next = cur; // 将cur链接到新的链表上
           cur = next; //让cur后移
       }
        // 将head.next 指向reverseHead.next,实现单链表的反转
        head.next = reverseHead.next;
    }

    // 查找单链表的倒数第k个节点 [新浪面试题]
    // 思路：
    // 1.编写一个方法，接收head节点，同时接收一个index
    // 2.index表示是倒数第index个节点
    // 3. 先把链表从头到尾遍历，得到链表的总长度length
    // 4.得到size后，我们从链表的第一个开始遍历（size - index)个，就可以得到
    // 5. 如果找到了，则返回该节点，否则返回Null
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        // 判断链表是否为空，返回null
        if(head.next == null) {
            return  null; // 没有找到
        }
        // 第一个遍历得到链表的长度（节点个数）
        int size = getLength(head);
        // 第二次遍历size - index 位置，就是我们倒数的第k个节点
        // 先做一个index的校验
        if(index <=0 || index > size) {
            return null;
        }

        // 定义辅助变量 for循环定位
        HeroNode cur = head.next; // 3 3 - 1 = 2
        for(int i=0; i<size-index;i++) {
            cur = cur.next;
        }
        return cur;

    }


    // 方法：获取到单链表的节点个数（如果是带头节点的链表，需求不统计头节点）
    public static int getLength(HeroNode head) {
        int length = 0;
        // 定义一个辅助变量
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

}

// 定义SingleLinkedList  管理我们的英雄
class SingleLinkedList {
    // 先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    // 返回头节点
    public HeroNode getHead() {
        return head;
    }

    // 添加节点到单向链表
    // 思路：当不考虑编号顺序时
    // 1. 找到当前链表的最后节点
    // 2. 将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode) {
        // 因为head节点不能动，因此我们需要一个辅助节点 temp
        HeroNode temp = head;
        // 遍历节点，找到最后
        while (true) {
            // 找到链表的最后
            if(temp.next == null) {
                break;
            }
            // 如果没有找到左后则将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，teimp就指向了链表最后
        // 将最后这个节点的next 指向新的节点
        temp.next = heroNode;
    }

    // 第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    // （如果有这个排名，则添加失败，并给出提示）
    public void addByOrder(HeroNode heroNode) {
        // 因为头节点不能动，因此我们仍然通过一个辅助指针（变量）来帮助我们找到添加的位置
        // 因为单链表，因为我们找的temp, 是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; // flag标志添加的编号是否存在，默认为false
        while (true) {
            if(temp.next == null) { // 说明temp已经在链表的最后
                break; //
            }
            if(temp.next.no > heroNode.no) { // 位置已找到，就在temp的后面插入
                break;
            } else if( temp.next.no == heroNode.no) { // 说明希望添加的heroNode的编号已然存在
                flag = true; // 说明编号存在
                break;
            }
            temp = temp.next; // 后移，遍历当前链表
        }

        // 判断flag的值
        if(flag == true) { //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号%d 已经存在了，不能加入\n", heroNode.no);
        } else {
            // 插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 修改节点信息，
    // 根据no来修改
    public void update(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if(temp.next == null) {
                break;
            } else if(temp.next.no == heroNode.no) {
                flag = true;
                temp.next.name = heroNode.name;
                temp.next.nickname = heroNode.nickname;
            }
            temp = temp.next;
        }
        if(flag == false) {
            System.out.printf("没有找到编号为%d 的节点，不能修改\n", heroNode.no);
        }
    }

    // 删除节点
    // 思路
    // 1.head不能动，因此我们需要一个temp辅助节点找到待删除的前一个节点
    // 2.说明我们在比较时，是temp.next.no和需要删除的节点的no进行比较
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false; // 标记是否找到待删除节点的
        while (true) {
            if(temp.next == null) {
                break;
            }
            if(temp.next.no == no) {
                // 找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 判断flag
        if(flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的节点%d不存在。。。\n", no);
        }
    }

    // 显示链表[遍历]
    public void list() {
        // 判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点，不能动，需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            // 判断链表是否到最后
            if(temp == null) {
                break;
            }
            // 输出节点的信息
            System.out.println(temp);
            // 将temp后移，一定小心
            temp = temp.next;
        }

    }
}

// 定义HeroNode, 每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; // 指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 为了显示方法，我们重写toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
