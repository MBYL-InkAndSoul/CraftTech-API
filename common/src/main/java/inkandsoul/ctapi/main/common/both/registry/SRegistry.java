package inkandsoul.ctapi.main.common.both.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import java.util.LinkedHashMap;
import java.util.Map;

public class SRegistry<ID, OBJ> implements ISRegistry<ID, OBJ> {
    private final Map<ID, OBJ> map;
    
    private boolean freeze = false;
    
    private final ResourceKey<Registry<OBJ>> key;

    public SRegistry(ResourceKey<Registry<OBJ>> key) {
        this.key = key;
        this.map = new LinkedHashMap<>();
    }
    
    public void freeze() {
        freeze = true;
    }

    @Override
    public ResourceKey<Registry<OBJ>> getKey() {
        return key;
    }

    @Override
    public boolean isLocked() {
        return freeze;
    }

    @Override
    public boolean contains(ID id) {
        return map.containsKey(id);
    }

    @Override
    public Map<ID, OBJ> getRegistry() {
        return map;
    }

    @Override
    public OBJ register(ID id, OBJ obj) {
        if (freeze) {
            throw new RuntimeException("Registry already freezing!");
        }
        if (map.containsKey(id)) {
            throw new RuntimeException("ID: " + id + " was already registered!");
        } else {
            return map.put(id, obj);
        }
    }

    @Override
    public OBJ delete(ID id) {
        if (freeze) {
            throw new RuntimeException("Registry already freezing!");
        }
        if (map.containsKey(id)) {
            return map.remove(id);
        } else {
            throw new RuntimeException("Can't find registered object at ID: "+id);
        }
    }

    /**
     * TODO: Save registry to server world.
     * @param level world
     */
    public void syncSave(Level level) {
        
    }
}
