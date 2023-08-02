package inkandsoul.ctapi.main.common.both.collection;

public class Vec2<A, B> {
    public void setKey(A key) {
        this.key = key;
    }

    public void setValue(B value) {
        this.value = value;
    }

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
