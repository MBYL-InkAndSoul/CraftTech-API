package inkandsoul.ctapi.main.common.both.util;

public class Vec2b {
    public static final Vec2b MAX = new Vec2b(Byte.MAX_VALUE, Byte.MAX_VALUE);
    public static final Vec2b MIN = new Vec2b(Byte.MIN_VALUE, Byte.MIN_VALUE);
    public final byte x;
    public final byte y;

    public Vec2b(byte f, byte g) {
        this.x = f;
        this.y = g;
    }

    public Vec2b scale(byte f) {
        return new Vec2b((byte)(this.x * f), (byte)(this.y * f));
    }

    public byte dot(Vec2b vec2i) {
        return (byte)(this.x * vec2i.x + this.y * vec2i.y);
    }

    public Vec2b add(Vec2b vec2i) {
        return new Vec2b((byte)(this.x + vec2i.x), (byte)(this.y + vec2i.y));
    }

    public Vec2b add(byte f) {
        return new Vec2b((byte)(this.x + f), (byte)(this.y + f));
    }

    public boolean equals(Vec2b vec2i) {
        return this.x == vec2i.x && this.y == vec2i.y;
    }

    @Override
    public boolean equals(Object vec2i) {
        if(vec2i==null){
            return false;
        }
        if(!(vec2i instanceof Vec2b)){
            return false;
        }
        return ((Vec2b)vec2i).equals(this);
    }

    public byte lengthSquared() {
        return (byte)(this.x * this.x + this.y * this.y);
    }

    public byte distanceToSqr(Vec2b vec2i) {
        byte f = (byte)(vec2i.x - this.x);
        byte g = (byte)(vec2i.y - this.y);
        return (byte)(f * f + g * g);
    }

    public Vec2b negated() {
        return new Vec2b((byte)(-this.x), (byte)(-this.y));
    }
}
