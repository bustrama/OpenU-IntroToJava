public class IntNodeTwo {
    private int _num;
    private IntNodeTwo _next, _prev;

    public IntNodeTwo(int n) {
        _num = n;
        _next = null;
        _prev = null;
    }

    public IntNodeTwo(int num, IntNodeTwo n, IntNodeTwo p) {
        _num = num;
        _next = n;
        _prev = p;
    }

    public int getNum() {
        return _num;
    }

    public IntNodeTwo getNext() {
        return _next;
    }

    public IntNodeTwo getPrev() {
        return _prev;
    }

    public void setNum(int n) {
        _num = n;
    }

    public void setNext(IntNodeTwo node) {
        _next = node;
    }

    public void setPrev(IntNodeTwo node) {
        _prev = node;
    }
}