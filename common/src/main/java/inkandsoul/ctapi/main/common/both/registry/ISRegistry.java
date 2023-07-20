package inkandsoul.ctapi.main.common.both.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

import java.util.Collection;
import java.util.Map;

public interface ISRegistry<ID, OBJ> {

    ResourceKey<Registry<OBJ>> getKey();

    boolean isLocked();

    boolean contains(ID id);

    Map<ID, OBJ> getRegistry();

    OBJ register(ID id, OBJ obj);

    OBJ delete(ID id);

}
