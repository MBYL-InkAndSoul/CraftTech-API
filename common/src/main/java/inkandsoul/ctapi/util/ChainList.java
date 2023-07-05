package inkandsoul.ctapi.util;

import java.util.ArrayList;

public class ChainList<E> extends ArrayList<E> {
    public ChainList<E> addC(E thing){
        this.add(thing);
        return this;
    }
}
