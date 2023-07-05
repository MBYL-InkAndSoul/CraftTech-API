package inkandsoul.ctapi.util;

// import java.util.ArrayList;
// import java.util.LinkedHashMap;
// import java.util.List;
// import java.util.Map;

// import net.minecraft.Util;
import net.minecraft.core.NonNullList;

/**
 * 序列號從左到右，從上到下。
 * <p>例：</p>
 * <table border="1">
 * <tr>
 * <td>0</td>
 * <td>1</td>
 * <td>2</td>
 * </tr>
 * <tr>
 * <td>3</td>
 * <td>4</td>
 * <td>5</td>
 * </tr>
 * <tr>
 * <td>6</td>
 * <td>7</td>
 * <td>8</td>
 * </tr>
 * </table>
 */
public class SmallGrid<T> {
    
    private NonNullList<T> map;

    public SmallGrid(byte heigth, byte widgth, T defaultValue){
        map = NonNullList.withSize(widgth*heigth, defaultValue);
    }

    public void set(byte x, T thing){
        map.set(x, thing);
    }

    public T get(byte x){
        return map.get(x);
    }

    public int size(){
        return map.size();
    }

    public NonNullList<T> getMap(){
        return map;
    }
}
