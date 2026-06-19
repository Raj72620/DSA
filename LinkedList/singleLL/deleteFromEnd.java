package LinkedList.singleLL;

public class deleteFromEnd{
    
    static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data=data;
            this.next=null;
        }
    }
    static class LL{
        Node head;

        void add(int data){
            Node newNode= new Node(data);
                if(head==null){
                    head=newNode;
                }else{
                    Node curr = head;
                    while(curr.next!=null){
                        curr=curr.next;
                    }
                    curr.next=newNode;
                }
        }

        void delete(int idx){
            if(head==null){
                System.out.println("list is empty");
                return;
            }
            if(idx<=0){
                System.out.println("Invalid idx");
                return;
            }
            int count=1;
            Node curr=head;
            while(curr.next!=null){
                 curr=curr.next;
                count++;
            }
            if(idx > count){
    System.out.println("Invalid idx");
    return;
}
            int target = count-idx;
               if(target==0){
                head=head.next;
                return;
            }
            int i=1;
     
            curr=head;
            while(i<target){
                curr=curr.next;
                i++;
            }
            curr.next=curr.next.next;
        }

         void printLL(){
            if(head==null) return;
            Node curr=head;
            while(curr!=null){
                System.out.print(curr.data+"->");
                curr=curr.next;
            }
            System.out.print("null");
        }
    }
    public static void main(String[] args) {
        LL list = new LL();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
    
        list.delete(5);

        list.printLL();
    }
    
}
