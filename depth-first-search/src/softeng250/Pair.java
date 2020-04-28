package softeng250;

public class Pair<T1, T2> {
    private final T1 _left;
    private final T2 _right;

    Pair(T1 left, T2 right) {
        _left = left;
        _right = right;
    }

    public T1 getLeft() {
        return _left;
    }

    public T2 getRight() {
        return _right;
    }
}
