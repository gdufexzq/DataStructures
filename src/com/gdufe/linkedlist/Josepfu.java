package com.gdufe.linkedlist;

public class Josepfu {
    public static void main(String[] args) {

        // 测试
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(125);
        circleSingleLinkedList.showBoy();

        // 测试一把小孩出圈是否正确
        circleSingleLinkedList.countBoy(1, 2, 125); // 2-> 4->1->5->3
    }

}

// 创建一个环形的单向链表
class CircleSingleLinkedList {
    // 创建一个first节点，当前没有编号
    private Boy first = null;

    // 添加小孩节点，构建成一个环形链表
    public void addBoy(int nums) {
        // nums做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null; //辅助指针， 帮助构建环形链表
        // 使用for循环创建环形链表
        for(int i=1; i<=nums; i++) {
            // 根据编号创建小孩节点
            Boy boy = new Boy(i);
            if(i == 1) {
//                boy.setNext(boy);
//                first = boy;
//                curBoy = first;

                first = boy;
                first.setNext(first); // 构成环状
                curBoy = first; // 让curBoy执行第一个小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    // 遍历当前环形链表
    public void showBoy() {
        // 判断链表是否为空
        if(first == null) {
            return;
        }
        // 因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号%d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    // 根据用户的输入，计算出小孩出圈的顺序
    /**
     *
     * @param startNo 表示从第几个小孩开始
     * @param countNum 表示数几下
     * @param nums 表示最初有多少个小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {

        // 先对数据进行校验
        if(first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        // 创建辅助指针，指向first的前一个节点
        Boy helper = first;
        // 需求创建一个辅助指针helper,事先应该指向环形链表的最后一个节点
        while (true) {
            if(helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //报数之前，first和helper一定startNo-1次
        for(int i=0; i<startNo-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        // 当小孩报数时，让first和help 移动 countNum-1次,然后出圈，
        // 这里是一个循环的操作，直到圈中只有一个节点
        while (true) {
            if (helper == first) {
                // 说明圈中只有一个节点
                break;
            }
            for (int i=0; i<countNum-1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 这时,first指向的节点就是要出圈的节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            Boy temp = first;
            first = first.getNext();
            helper.setNext(first);
            temp.setNext(null);
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());
    }
}

// 创建一个boy类，表示一个节点
class Boy{
    private int no; // 编号
    private Boy next; // 指向下一个节点，默认为null

    public int getNo() {
        return no;
    }

    public Boy(int no) {
        this.no = no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
