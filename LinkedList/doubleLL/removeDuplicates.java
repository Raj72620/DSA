package LinkedList.doubleLL;

public class removeDuplicates {

   static class Node{
    int data;
    Node prev;
    Node next;

        public Node(int data) {
            this.data=data;
            this.prev=null;
            this.next=null;
        }
   }
  static class DLL{
    Node head;
    Node tail;

    void add(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }

    void remove(){
        if(head==null || head.next==null) return;

        Node temp1=head;
        Node temp2=temp1.next;

        while(temp2!=null){
            if(temp1.data==temp2.data){
                temp2=temp2.next;
            }else{
               temp1.next=temp2;
               temp2.prev=temp1;

               temp1=temp2;
               temp2=temp1.next;
            }

        }
         temp1.next=null;
    }
    void print(){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+ "<=>");
            curr=curr.next;
        }
        System.out.print("null");
    }
   }
    public static void main(String[] args) {
        DLL list = new DLL();
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(20);
        list.add(30);

        list.remove();
        list.print();

    }
}
