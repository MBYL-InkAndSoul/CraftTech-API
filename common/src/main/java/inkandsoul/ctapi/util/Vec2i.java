package inkandsoul.ctapi.util;

public class Vec2i {
    public static final Vec2i MAX = new Vec2i(Integer.MAX_VALUE, Integer.MAX_VALUE);
    public static final Vec2i MIN = new Vec2i(Integer.MIN_VALUE, Integer.MIN_VALUE);
    public final int x;
    public final int y;

    public Vec2i(int f, int g) {
        this.x = f;
        this.y = g;
    }

    public Vec2i scale(int f) {
        return new Vec2i(this.x * f, this.y * f);
    }

    public int dot(Vec2i vec2i) {
        return this.x * vec2i.x + this.y * vec2i.y;
    }

    public Vec2i add(Vec2i vec2i) {
        return new Vec2i(this.x + vec2i.x, this.y + vec2i.y);
    }

    public Vec2i add(int f) {
        return new Vec2i(this.x + f, this.y + f);
    }

    public boolean equals(Vec2i vec2i) {
        return this.x == vec2i.x && this.y == vec2i.y;
    }

    @Override
    public boolean equals(Object vec2i) {
        if(vec2i==null){
            return false;
        }
        if(!(vec2i instanceof Vec2i)){
            return false;
        }
        return ((Vec2i)vec2i).equals(this);
    }

    public int lengthSquared() {
        return this.x * this.x + this.y * this.y;
    }

    public int distanceToSqr(Vec2i vec2i) {
        int f = vec2i.x - this.x;
        int g = vec2i.y - this.y;
        return f * f + g * g;
    }

    public Vec2i negated() {
        return new Vec2i(-this.x, -this.y);
    }
}
