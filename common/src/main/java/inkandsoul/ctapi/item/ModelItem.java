package inkandsoul.ctapi.item;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.Item;

// TODO: Complete this rendering.
/**
 * Used to render anything
 */
public abstract class ModelItem extends Item {

    protected ModelItem() {
        super(new Properties());
    }

    @ExpectPlatform
    public static ModelItem of(){
        throw new AssertionError("");
    }
}
