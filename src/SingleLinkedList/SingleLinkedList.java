package SingleLinkedList;

import java.awt.desktop.SystemEventListener;

public class SingleLinkedList {
    public static class Node{  //
        private Node next;
        private int value;

        public Node(int value,Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }
    }

    private Node head = null;

    public void PrintList(){
        Node position = head;
        while (position != null){
            System.out.println(position.value);
            position = position.next;
        }
    }

    public void InsertToHead(Node newNode){
        if (newNode == null)return;

        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
    }

    public void InsertToHead(int value){//Insert a new node as the head
        Node newNode = new Node(value,null);
        InsertToHead(newNode);
    }

    public void InsertToTail(Node newNode){
        Node tailNode = head;

        if (head==null) {
            head = newNode;
        }else {
            while (tailNode.next != null){
                tailNode = tailNode.next;
            }
            tailNode.next = newNode;
        }
    }

    public void InsertToTail(int value){
        Node newNode = new Node(value,null);
        InsertToTail(newNode);
    }

    public void InsertBefore(Node position, Node newNode){
        if (position == null)return;
        if (position == head){
            InsertToHead(newNode);
        }
        Node beforeNode = head;

        while (beforeNode.next != position){
            beforeNode = beforeNode.next;
        }
        newNode.next = position;
        beforeNode.next = newNode;
    }

    public void InsertBefore(Node position, int value){
        Node newNode = new Node(value,null);
        InsertBefore(position, newNode);
    }

    public void InsertAfter(Node position,Node newNode){
        if (position == null)return;
        newNode.next = position.next;
        position.next = newNode;
    }

    public void InsertAfter(Node position, int value){
        Node newNode = new Node(value,null);
        InsertAfter(position,newNode);
    }

    public void DeleteNode(int value) {//delete all the nodes if node.value == value
        if (head == null) return;

        if(head.value == value){
            head = head.next;
        }

        Node position = head;
        while(position.next != null){
            if (position.next.value == value){
                position.next = position.next.next;
                continue;
            }
            position = position.next;
        }
    }

    public void DeleteNode(Node position){
        if (head == null)return;

        Node beforeNode = head;

        while (beforeNode.next == position){
            beforeNode = beforeNode.next;
        }
        beforeNode.next = position.next;
    }

    public void InverseList(){
        if (head == null)return;

        Node newList = new Node(head.value, null);
        Node position = head;

        while (position.next != null){
            position = position.next;
            newList = new Node(position.value, newList);
        }
        head = newList;
    }

    public boolean HasCycle(Node listHead){
        if (listHead == null)
            return false;

        Node walker = listHead;
        Node runner = listHead;
        while (runner != null && runner.next != null){
            walker = walker.next;
            runner = runner.next.next;
            if(walker == runner)return true;
        }

        return false;
    }

    public Node FindNode(int value){//Find the first Node that Node.value == value
        Node position = head;

        while (position.value != value){
            position = position.next;
        }

        return position;
    }

    public int GetLengthOfLinkedList(){
        if (head == null)return 0;

        int length = 1;
        Node position = head;

        while (position.next != null){
            position = position.next;
            length++;
        }

        return length;
    }
    public void DeleteNodeReversely(int BackCount){//Delete the (BackCount)th Node in a reverse order;
        int length = GetLengthOfLinkedList();
        if(length == 0)return;

        int NumOfBeforeNode = length - BackCount -1;
        Node BeforeNode = head;
        for(int i = 0; i < NumOfBeforeNode; i++){
            BeforeNode = BeforeNode.next;
        }

        BeforeNode.next = BeforeNode.next.next;
    }

    public void FineMiddleNode(){

    }

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        int[] value = new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29};
        for (int j : value) {
            linkedList.InsertToTail(j);
        }
        linkedList.PrintList();

//        //Creat a linked list with cycle
//        Node StartCycle = linkedList.FindNode(13);
//        Node TailNode = linkedList.FindNode(29);
//        TailNode.next = StartCycle;
//        boolean HasCycle = linkedList.HasCycle(linkedList.head);
//        if (HasCycle == true){
//            System.out.println("The linked list has a cycle");
//        }else {
//            System.out.println("The lined list has no cycle");
//        }

//        System.out.println("Test insert to head");
//        linkedList.InsertToHead(11);
//        linkedList.PrintList();
//
//        System.out.println("Test insert to tail");
//        linkedList.InsertToTail(13);
//        linkedList.PrintList();

//        System.out.println("Test deleteNode by value");
//        linkedList.DeleteNode(1);
//        linkedList.PrintList();

//        System.out.println("Test inverse list");
//        linkedList.InverseList();
//        linkedList.PrintList();

        System.out.println("Test delete the ith Node in a reverse order");
        linkedList.DeleteNodeReversely(5);
        linkedList.PrintList();
    }
}
