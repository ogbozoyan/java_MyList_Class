import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        var f = new MyList();
        System.out.println(f.Last);
        f.add(10);
        System.out.println(f.Last);
        System.out.println(f.Head);
        f.add(11);
        f.add(12);
        System.out.println(f.Head.Next);
        System.out.println(f.Last);
        f.delVal(12);
        System.out.println(f.Head.Next.element);

    }
}