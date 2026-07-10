import java.util.*;
class list{
    int val;
    list next;
    list(int x){
        val = x;
        next = null;
    }
}
public class ll {
    public static list reverselist(list head){
        list prev = null,curr = head,next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void printlist(list head){
        list temp = head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        list head = null;
        list curr = head; 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            list newNode = new list(x);
            if(head==null){
                head = newNode;
                curr = head;
            }
            else{
                curr.next = newNode;
                curr = newNode;
            }
        }
        printlist(head);
        list reversed = reverselist(head);
        printlist(reversed);
        
    }
}
