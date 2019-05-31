package com.hangsing.easy;

import com.hangsing.beans.ListNode;

import java.util.HashMap;
import java.util.Map;

public class solution {

    public static void main(String[] args) {
        twosum();
        add();
    }
    /**
     * 两数之和
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 解决思路 一遍hash法
     */
     private static void twosum(){
        System.out.println("两数之和");
        int[] nums = {2,7,11,15};
        int target = 9;
        //定义一个map来存放需要比较的值
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int comm = target - nums[i];
            if(mp.containsKey(comm) && mp.get(comm)!=i){
                System.out.println(mp.get(comm)+" "+i);
            }else{
                mp.put(nums[i],i);
            }
        }
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public static void add(){
        System.out.println("链表两数相加");
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(2);
        addTwoNumbers(l1,l2);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义哑结点
        ListNode sumList = new ListNode(0);
        ListNode p=l1, q=l2, curr = sumList;
        int carry = 0;//进位
        while(p!=null || q!=null) {
            int x = (p!=null) ? p.val : 0;
            int y = (q!=null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p!=null){
                p = p.next;}
            if (q!=null){
                q = q.next;}
        }
        if (carry > 0){
            curr.next = new ListNode(carry);
        }
        System.out.println("进位："+carry);
        System.out.println("当前位："+sumList.next.val);
        return sumList.next;
    }

}
