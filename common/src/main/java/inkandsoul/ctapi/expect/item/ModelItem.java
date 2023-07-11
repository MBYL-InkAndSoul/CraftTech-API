package inkandsoul.ctapi.expect.item;

import dev.architectury.injectables.annotations.ExpectPlatform;
import inkandsoul.ctapi.main.common.both.util.ItemUtil;
import net.minecraft.world.item.Item;

// TODO: Complete this rendering.
/**
 * Used to render anything
 */
public abstract class ModelItem extends Item {

    protected ModelItem() {
        super(ItemUtil.VOID_PROPERTIES);
    }

    @ExpectPlatform
    public static ModelItem of(){
        throw new AssertionError();
    }
}
