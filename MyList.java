import org.jetbrains.annotations.NotNull;
import java.util.Scanner;
public class MyList<T extends Comparable<T>> {
     public Node<T> Head;
     public @NotNull Node Last;
     static int size = 0;
    public class Node<T> extends MyList{
        public T element;
        public Node Next;
        public Node(){
            this.element = null;
            this.Next = null;
        }
        public Node(T val){
            this.Head = this;
            this.element = val;
        }
        public Node(@NotNull Node ob){ //copy
            this.Next = ob.Next;
            this.element = (T) ob.element;
            this.size = ob.size;
            this.Head = ob.Head;
            this.Last = ob.Last;
        }
    }
    public void add(T val){
        if(isEmpty()){
            Head = new Node(val);
            Last = Head;
        }else{
            Node<T> nw = new Node(Last);
            Last.Next = nw;
            nw.Next = null;
            nw.element = val;
            Last = nw;
        }
    }
    public void addHead(T val){
        if(isEmpty()){
            Head = new Node(val);
        }else{
            Head.element = val;
        }
    }
    public void delHead(){
        Head.element = null;
    }
    public void delVal(T val){
        var ptr = Head;
        for(int i = 0;i<size();i++){
            if(ptr.element.compareTo(val) == 0 ) {ptr.element = null; break;}
            else ptr = ptr.Next;
        }
    }
    public boolean isEmpty() {
        if(size()==0){
            return true;
        }
        return false;
    }
    public int size() {
        Node<T> p;
        int size=0;
        for(p=Head;p!=null;p=p.Next){
            size++;
        }
        return size;
    }
    public void clear(){
        System.out.println("Do you want clear Your list?" +
                " Yes or No: \n");
        Scanner scanner = new Scanner(System.in);
        String agre = "";
        agre = scanner.nextLine();
        if(agre.equals("yes") || agre.equals("Yes")
           || agre.equals("y") || agre.equals("Y")){
            this.Head = null;
            this.size = 0;
            this.Last = null;
            System.out.println("Done");
        }
    }
}