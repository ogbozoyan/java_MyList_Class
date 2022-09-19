import org.jetbrains.annotations.NotNull;

public class MyList<T> {
    protected T element;
    protected MyList<T> Next; //указатель на предыдущую ноду
    protected MyList<T> Prev;//указатель на следующую ноду
    int index = 0; /*индекс текущей ноды немного некроктно показывает
    если добавлять ноду start.addNode() несколько раз, нужно добавлять относительно последней ноды*/
    static int buff = 0;
    static int size = 0;
    private boolean isHead = false;
    private boolean isTail = false;
    protected void clear() {/*Нужно запускать от головы*/
        var ptr = this;
        if (ptr.isHead != true) {
            System.out.println("To clear List -  start from Head");
        } else if(ptr.isHead == true){
            do {
                if(ptr.isTail){
                    ptr.element = null;
                    break;
                }
                ptr.element = null;
                ptr = ptr.Next;
            }while (true);
        }
    }
    protected void delVal(T toDel){/*Поиск нужно начинать от head
    удаляет первое появление элемента*/
        var ptr = this;
        var val = ptr.element;
        if(val == toDel){
            ptr.element = null;
        }
        while(val !=  toDel){
            if(ptr.Next != null){
                ptr = ptr.Next;
                val = ptr.element;
                if(val == toDel){
                    ptr.element = null;
                }
            }
            else if(ptr.Next == null){
                System.out.println("Don't have that value");
                break;
            }
        }
    }
    protected void delTop() {//можно начать с любой точки
        var buf = this.isHead;
        if (buf) {
            this.element = null;
        } else {
            var ptr = this;
            do{
                if (buf != true) {
                    ptr = ptr.Prev;
                    buf = ptr.isHead;
                    if(buf){
                        System.out.println("Worked");
                        ptr.element = null;
                    }
                }
            } while(buf != true);
        }
    }
    protected void addToEnd(T val){
        var ptr = this;
        if(ptr.isTail){
            ptr.element = val;
        }
        while(true){
            if(!ptr.isTail){
                ptr = ptr.Next;
                if(ptr.isTail){
                    ptr.element = val;
                    System.out.println("Worked");
                    break;
                }
            }
        }
    }
    protected void add(T element) {//добавляет в current node
        this.element = element;
        this.setTail();
        if (this.Prev == null) {
            this.setHead();
            this.setTail();
        } else if (this.Prev.isHead)
            this.setTail();
        else if (this.Prev.isTail)
            this.Prev.isTail = false;
        size += 1;
    }
    protected void addNext(T element) {//добавляет в current node
        this.addNode();
        this.Next.element = element;
        this.Next.setTail();
        if (this.Next.Prev == null) {
            this.Next.setHead();
            this.Next.setTail();
        } else if (this.Next.Prev.isHead)
            this.Next.setTail();
        else if (this.Next.Prev.isTail)
            this.Next.Prev.isTail = false;
        size += 1;
    }
    private void addNode() {
        MyList<T> node = new MyList<>(this);
        node.setTail();
        node.element = null;
        node.isHead = false;
        this.setNext(node);
            if (node.Prev.isHead) {
                node.setTail();
            }
            if (node.Prev.isTail) {
                node.Prev.isTail = false;
            }
                buff++;
                node.index = buff;
        }


    private void setNext(@NotNull MyList<T> Next) {
        this.Next = Next;
        Next.Prev = this;
    }

    private void setHead() {
        try {
            if (this.Prev.isHead) {
                System.out.println("Head is" + this.Prev);
            } else {
                this.isHead = true;
            }
        } catch (NullPointerException e) {
            this.isHead = true;
        }
    }
    public MyList() {
        this.Next = null;
        this.Prev = null;
        this.element = null;
        size = 0;
        setTail();
        setHead();
    }
    protected MyList(MyList<T> needtocopy) {
        this.Next = needtocopy.Next;
        this.Prev = needtocopy.Prev;
        this.element = needtocopy.element;
        this.isHead = needtocopy.isHead;
        this.isTail = needtocopy.isTail;
    }
    public boolean getHead() {
        return this.isHead;
    }
    private void setTail() {
        this.isTail = true;
    }
    public boolean getTail() {
        return this.isTail;
    }
    public T getPrev() {
        return (T) this.Prev;
    }
    public T getNext() {
        return (T) this.Next;
    }
    public int sizeofMyList() {
        return size;
    }
    public T getValue() {
        return this.element;
    }
    public boolean isEmpty() {
        if ((this.Prev == null) && (this.Next == null)) return true;
        return false;
    }
    protected void print(String name) {
        System.out.println("-----Info----- this is ---- "+name +" -ID- "+ this );
        System.out.println("Index: " + this.index);
        System.out.println("Empty: " + this.isEmpty());
        System.out.println("Prev: " + this.getPrev());
        System.out.println("Next: " + this.getNext());
        System.out.println("Head: " + this.getHead());
        System.out.println("Tail: " + this.getTail());
        System.out.println("Value: " + this.getValue());
        System.out.println("Size: " + this.sizeofMyList());
        System.out.println("--------------------------------");
    }
}