package inkandsoul.ctapi.mixin.common.both.data;

//import inkandsoul.ctapi.main.common.both.event.tag.TagLoader;
import inkandsoul.ctapi.main.common.both.data.tag.TagsReloadEvent;
import net.minecraft.core.RegistryAccess;
import net.minecraft.server.ReloadableServerResources;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ReloadableServerResources.class)
public class TagAddHooks {
    @Inject(method = "updateRegistryTags(Lnet/minecraft/core/RegistryAccess;)V",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Blocks;rebuildCache()V"))
    public void tagReloadHooks(RegistryAccess registryAccess, CallbackInfo ci) {
        TagsReloadEvent.EVENT.invoker().reload(registryAccess);
    }

}
