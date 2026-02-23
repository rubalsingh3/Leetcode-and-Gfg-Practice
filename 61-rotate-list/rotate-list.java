/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k ==0) return head;
        ListNode tail = head;
        ListNode temp = head;

        int n = 1;
        while(tail.next != null){
            n++;
            tail = tail.next;
            
        }
        if(k % n == 0) return head;
        k = k%n;
        tail.next = head;
        int steps = n-k;
        int count = 1;

        while(count < steps){
            count++;
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}