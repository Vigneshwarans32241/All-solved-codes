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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> nodes = new ArrayList<>();
        int[] ans = new int[6];
        ListNode curr = head;
        while(curr!=null) {
            nodes.add(curr.val);
            curr = curr.next;
        }
        ArrayList<Integer> points = new ArrayList<>();
        for(int i = 1;i<nodes.size()-1;i++){
            int val = nodes.get(i);
            int before = nodes.get(i-1);
            int after = nodes.get(i+1);
            if((val<after && val<before) || (val>after && val>before)){
                points.add(i+1);
            }
        }
        if(points.size()<2) return new int[] {-1,-1};
        if (points.size() < 2) {
            return new int[]{-1, -1};
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < points.size(); i++) min = Math.min(min, points.get(i) - points.get(i - 1));
        int max = points.get(points.size() - 1) - points.get(0);
        return new int[]{min, max};
    }
}
