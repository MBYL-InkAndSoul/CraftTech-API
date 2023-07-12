package inkandsoul.ctapi.main.common.both.collection;

public class Vec2<A, B> {
    public A key;
    public B value;

    public Vec2(A key, B value) {
        this.key = key;
        this.value = value;
    }

    public B getValue() {
        return value;
    }

    public A getKey() {
        return key;
    }
}
