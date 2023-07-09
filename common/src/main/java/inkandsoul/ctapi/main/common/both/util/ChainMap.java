package inkandsoul.ctapi.main.common.both.util;

import java.util.LinkedHashMap;

public class ChainMap<K, V> extends LinkedHashMap<K, V> {
    public ChainMap<K, V> putC(K k, V v){
        this.put(k, v);
        return this;
    }

}
