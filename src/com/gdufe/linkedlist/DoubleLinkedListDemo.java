package com.gdufe.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        System.out.println("双向链表的测试");

        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

//        创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        // 修改
        HeroNode2 hero5 = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(hero5);
        System.out.println("修改后");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.del(3);
        System.out.println("删除后");
        doubleLinkedList.list();
    }


}

// 创建一个双向链表的类
class DoubleLinkedList {

    // 先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    // 返回头节点
    public HeroNode2 getHead() {
        return head;
    }


    //遍历双向链表
    // 显示链表[遍历]
    public void list() {
        // 判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点，不能动，需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
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

    // 添加一个节点到双向链表的最后
    public void add(HeroNode2 heroNode) {
        // 因为head节点不能动，因此我们需要一个辅助节点 temp
        HeroNode2 temp = head;
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
        // 形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    // 修改节点信息，
    // 根据no来修改
    // 修改一个节点的内容，可以看到双向链表的节点内容修改和单项链表一样
    // 只是 节点类型改成 HeroNode2
    public void update(HeroNode2 heroNode) {
        HeroNode2 temp = head;
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


    // 从双向链表中删除一个节点
    // 说明
    // 1. 对于双向链表，我们可以直接找到要删除的这个节点
    // 2.找到后，自我删除即可
    public void del(int no) {

        // 判断当前链表链表是否为空，
        if(head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false; // 标记是否找到待删除节点的
        while (true) {
            if(temp == null) {
                break;
            }
            if(temp.no == no) {
                // 找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 判断flag
        if(flag) {
            temp.pre.next = temp.next;
            // 这里我们的代码有问题，如果是最后一个节点，则下面不需要执行,否则会出现空指针异常
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
            temp.next = null;
            temp.pre = null;
        } else {
            System.out.printf("要删除的节点%d不存在。。。\n", no);
        }
    }
}

// 定义HeroNode, 每个HeroNode对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; // 指向下一个节点, 默认为null
    public HeroNode2 pre; // 指向前一个节点,默认为null

    public HeroNode2(int no, String name, String nickname) {
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


