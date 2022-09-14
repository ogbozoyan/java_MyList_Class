import org.jetbrains.annotations.NotNull;

public class MyList<T> {
    protected T element;
    protected MyList<T> Next;
    protected MyList<T> prev;
    protected int index = 0;
    static int size = 0;
    protected boolean isHead = false;
    protected boolean isTail = false;

    public void add(T element) {
        this.element = element;
        this.setTail();
        if (this.prev == null) {
            this.setHead();
            this.setTail();
        } else if (this.prev.isHead)
            this.setTail();
        else if (this.prev.isTail)
            this.prev.isTail = false;

        size += 1;
    }

    public void addNode() {
        MyList<T> node = new MyList<T>(this);
        this.setNext(node);
        node.setTail();
        node.element = null;
        node.isHead = false;
         if (node.prev.isHead) {
            node.setTail();
        } if (node.prev.isTail) {
            node.prev.isTail = false;
        }

    }

    public void setNext(@NotNull MyList<T> Next) {
        this.Next = Next;
        Next.prev = this;
    }

    public void setHead() {
        try {
            if (this.prev.isHead) {
                System.out.println("Head is" + this.prev);
            } else {
                this.isHead = true;
            }
        } catch (NullPointerException e) {
            this.isHead = true;
        }
    }
    public MyList() {
        this.Next = null;
        this.prev = null;
        this.element = null;
        size = 0;
        this.isTail = true ;
        this.isHead = true;
    }
    public MyList(MyList<T> needtocopy) {
        this.Next = needtocopy.Next;
        this.prev = needtocopy.prev;
        this.element = needtocopy.element;
        this.isHead = needtocopy.isHead;
        this.isTail = needtocopy.isTail;
    }
    public boolean getHead() {
        return this.isHead;
    }
    public void setTail() {
        this.isTail = true;
    }
    public boolean getTail() {
        return this.isTail;
    }
    public T getPrev() {
        return (T) this.prev;
    }
    public T getNext() {
        return (T) this.Next;
    }
    public int sizeofMylist() {
        return size;
    }
    public T getValue() {
        return this.element;
    }
    public boolean isEmpty() {
        if ((this.prev == null) && (this.Next == null)) return true;
        return false;
    }
    public void print(String name) {
        System.out.println("-----Info----- this is ---- "+name +" -ID- "+ this );
        System.out.println("Empty " + this.isEmpty());
        System.out.println("Prev " + this.getPrev());
        System.out.println("Next " + this.getNext());
        System.out.println("Head is " + this.getHead());
        System.out.println("Tail is " + this.getTail());
        System.out.println("Value " + this.getValue());
        System.out.println("Size " + this.sizeofMylist());
        System.out.println("--------------------------------");
    }
}
