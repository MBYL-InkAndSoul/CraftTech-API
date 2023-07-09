package inkandsoul.ctapi.mixin.common.both.data;

import inkandsoul.ctapi.main.common.both.event.tag.TagLoader;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.ReloadableServerResources;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.TagManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;
import java.util.Map;

@Mixin(ReloadableServerResources.class)
public class DataPackHooks {
    @Inject(method = "updateRegistryTags(Lnet/minecraft/core/RegistryAccess;Lnet/minecraft/tags/TagManager$LoadResult;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/core/RegistryAccess;registryOrThrow(Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/core/Registry;"),
    locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private static <T> void tagModifyHooks(RegistryAccess registryAccess,
                                           TagManager.LoadResult<T> loadResult,
                                           CallbackInfo ci,
                                           ResourceKey<? extends Registry<T>> resourceKey,
                                           Map<TagKey<T>, List<Holder<T>>> map){
        // var key = loadResult.key();
        TagLoader.EVENT.invoker().onTagLoad(loadResult, map);

    }
}
