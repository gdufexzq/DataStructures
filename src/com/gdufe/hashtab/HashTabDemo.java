package com.gdufe.hashtab;

import java.util.Scanner;

/**
 * @Description: 哈希表
 * @author xuzq
 * @date 2019/12/19 11:19
 * @version V1.0
 */
public class HashTabDemo {
    public static void main(String[] args) {
        // 创建哈希表
        HashTab hashTab = new HashTab(7);

        // 写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("del: 删除雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    // 创建雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("输入id");
                    int findId = scanner.nextInt();
                    hashTab.findEmpById(findId);
                    break;
                case "del":
                    System.out.println("输入id");
                    int delId = scanner.nextInt();
                    hashTab.delEmpById(delId);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }


}

// 创建HashTab,管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size; // 表示共有多少条链表
    // 构造器
    public HashTab(int size) {
        this.size = size;
        // 初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        // ? 留一个坑, 这个时候不要忘了分别初始化每条链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    // 添加一个雇员，
    public void add(Emp emp) {
        // 根据员工的id,得到该员工应当添加到哪条链表
        int empLinkListNO = hashFun(emp.id);
        // 将emp 添加到对应的链表中
        empLinkedListArray[empLinkListNO].add(emp);
    }

    // 遍历所有的链表
    public void list() {
        for(int i=0; i<size; i++) {
            empLinkedListArray[i].list(i+1);
        }
    }

    // 根据输入的id,查找雇员
    public void findEmpById(int id) {
        // 使用散列函数确定到哪条链表查找
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if(emp != null) {
            System.out.println("在第" + (empLinkedListNO + 1) + "条链表中找到，" +
                    "雇员 id = " + id);
        } else {
            System.out.println("在哈希表中，没有找到该雇员");
        }
    }

    // 根据输入的id，删除雇员
    public void delEmpById(int id) {
        int empLinkedListNO = hashFun(id);
        int flag = empLinkedListArray[empLinkedListNO].delEmpById(id);
        if(flag == 1) {
            System.out.printf("在第%d条链表删除雇员成功 雇员id=%d\n", (empLinkedListNO + 1), id);
        } else {
            System.out.println("在哈希表中，没有找到该雇员，删除失败");
        }
    }

    // 编写散列函数，使用一个简单的取模法
    public int hashFun(int id) {
        return id % size;
    }
}

// 表示一个雇员
class Emp {

    public int id;
    public String name;
    public Emp next; // 默认为空

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

// 创建一条链表
class EmpLinkedList {
    // 头指针，指向第一个Emp,因此我们这个链表的head是直接指向第一个Emp
    private Emp head; // 默认为null;

    // 添加雇员到链表
    // 说明
    // 1.假定，当添加雇员时，id是自增长的，即id的分配总是从小到大，
    // 因此我们将雇员直接加入到本链表的最后即可
    public void add(Emp emp) {
        //如果是添加第一个雇员
        if(head == null) {
            head = emp;
            return;
        }

        // 如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Emp curEmp = head;

        while(true) {
            if(curEmp.next == null) { // 说明到链表最后
                break;
            }
            curEmp = curEmp.next; // 后移
        }
        // 退出时直接将emp加入链表
        curEmp.next = emp;
    }

    // 遍历链表的雇员信息
    public void list(int no) {
        if(head == null) { // 说明链表为空
            System.out.println("第" + no + "条链表为空");
            return;
        }
        System.out.print("第" + no + "条链表的信息为");
        Emp curEmp = head; // 辅助指针
        while (true) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            if(curEmp.next == null){ // 说明curEmp已经是最后的节点
                break;
            }
            curEmp = curEmp.next; // 后移，遍历
        }
        System.out.println();
    }

    // 根据id查找雇员
    // 如果查找到，就返回Emp, 如果没有找到，就返回null
    public Emp findEmpById(int id) {
        // 判断链表是否为空
        if(head == null) {
            System.out.println("链表为空");
            return null;
        }
        // 辅助指针
        Emp curEmp = head;
        while (true) {
            if(curEmp.id == id) { // 找到
                break; // 这时curEmp就指向要查找的雇员
            }
            // 退出
            if(curEmp.next == null) { // 说明遍历当前链表没有找到该雇员
                curEmp = null;
                break;
            }
            curEmp = curEmp.next; // 后移
        }
        return curEmp;
    }

    // 删除雇员
    public int delEmpById(int id) {
        Emp curEmp = head;
        if(head == null) {
            return 0;
        } else {
            if(head.id == id) {
                head = head.next;
                curEmp=null;
                return 1;
            }
        }
        while (true) {
            if(curEmp.next == null) {
                return 0;
            }
            if(curEmp.next.id == id) {
                Emp tempEmp = curEmp;
                curEmp = curEmp.next;
                tempEmp = null;
                return 1;
            }
            curEmp = curEmp.next;
        }
    }
}
