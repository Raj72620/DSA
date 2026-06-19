package LinkedList.singleLL;

public class deleteKthNode {
    
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

        void deleteK(int idx){
            if(idx==0){
                head=head.next;
            }
            Node curr=head;
            int i=0;
            while(i<idx-1 && curr !=null){
                curr=curr.next;
                i++;
            }
            if(curr==null || curr.next==null){
                System.out.print("Idx out of bound");
                return;
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
    
        list.printLL();
    }
    
}
