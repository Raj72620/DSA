package LinkedList.singleLL;

public class implementingLL {

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

        void addFirst(int data){
            Node newNode = new Node(data);
            if(head==null){
                head= newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }

        void addLast(int data){
            Node newNode = new Node(data);
            if(head==null){
                head=newNode;
                return;
            }
            Node curr=head;
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next=newNode;
        }

        void deleteFirst(){
            if(head==null) return ;

            head=head.next;
        }

        void deleteLast(){

            if(head==null) return ;

            Node curr=head;
            while(curr.next.next!=null){
                curr=curr.next;
            }
            curr.next=null;

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

        list.addFirst(0);
        list.addLast(50);

        list.deleteFirst();
        list.deleteLast();

        list.printLL();
    }
}
