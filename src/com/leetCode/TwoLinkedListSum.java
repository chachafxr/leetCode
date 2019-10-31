package com.leetCode;

/**
 * 求两个数的和，这两个数的每一位分别位于链表的结点中，返回二者和的链表
 * @fufu
 */
public class TwoLinkedListSum {
    public static void main(String[] args){
        //创建两个节点
        NumNode l1 = new NumNode(3);
        NumNode l2 = new NumNode(4);
        //构建链表
        l1.next = new NumNode(4);
        l1.next.next = new NumNode(4);
        l2.next = new NumNode(6);
        l2.next.next = new NumNode(3);

        NumNode result =LinkedListSum(l1,l2);
        LinkedList list = new LinkedList();
        list.print(l1);
        list.print(l2);
        list.print(result);
    }
    public static NumNode LinkedListSum(NumNode l1,NumNode l2) {
        //先求出两个链表第一结点，也就是个位相加的结果
        int m = (l1.val + l2.val) % 10;
        int l = (l1.val + l2.val) / 10;//尽量不用小写l,无法和数字1区分
        //创建存储结果的链表的头节点，将个位数据加入
        NumNode result = new NumNode(m);
        //再创建一个节点用来后期遍历，以免后期，无法得到存放结果链表的头节点
        NumNode newResult = result;
        while (l1 .next!= null) {
            if (l2 .next!= null) {
                //计算十位的和，并将结果放入结果链表的十位上
                m = (l1.next.val + l2.next.val + l) % 10;
                l = (l1.next.val + l2.next.val + l) / 10;
                newResult.next = new NumNode(m);

                //为了下一次计算，将位置由十位移动到百位
                l1 = l1.next;
                l2 = l2.next;
                newResult = newResult.next;
            } else {
                m = (l1.next.val + l) % 10;
                l = (l1.next.val + l) / 10;
                newResult.next = new NumNode(m);
                l1 = l1.next;
                newResult = newResult.next;
            }
        }
        while(l1.next==null&&l2.next!=null){
            m = (l2.next.val + l) % 10;
            l = (l2.next.val + l) / 10;
            newResult.next = new NumNode(m);
            l2 = l2.next;
            newResult = newResult.next;
        }
        //最后高位之和大于10
        if(l!=0){
            newResult.next = new NumNode(1);
        }
        return result;
    }
}
class LinkedList{
    public void  print(NumNode head){
        NumNode temp = head;
        StringBuilder stringBuilder = new StringBuilder("[");
        while(true){
            if(temp==null){
                break;
            }
            stringBuilder.append(temp.val+",");
            temp = temp.next;
        }
        stringBuilder.setCharAt(stringBuilder.length()-1,' ');
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }
}
class NumNode{
    int val;
    NumNode next;
    public NumNode(int val){
        this.val = val;
    }
}