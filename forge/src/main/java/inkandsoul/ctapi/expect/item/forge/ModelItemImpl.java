package inkandsoul.ctapi.expect.item.forge;

import inkandsoul.ctapi.expect.item.ModelItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

import static inkandsoul.ctapi.CT_API_ClientForgeInit.BEWLR_Instance;

public class ModelItemImpl extends ModelItem {
    public static ModelItem of(){
        return new ModelItemImpl();
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return BEWLR_Instance;
            }
        });
    }
}
