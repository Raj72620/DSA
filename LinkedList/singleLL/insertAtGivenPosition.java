package LinkedList.singleLL;

public class insertAtGivenPosition{

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

        void insertAtMiddle(int data,int idx){
            Node newNode=new Node(data);
             idx=idx-1;
            if(idx<=0){
                newNode.next=head;
                head=newNode;
                return;
            }
            Node curr=head;

            while(idx!=0 ){
                curr=curr.next;
                idx--;
            }
            newNode.next=curr.next;
            curr.next=newNode;
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

        list.insertAtMiddle(25, 2);
    
        list.printLL();
    }
}
