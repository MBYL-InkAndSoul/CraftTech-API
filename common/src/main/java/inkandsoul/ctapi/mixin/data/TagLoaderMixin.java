package inkandsoul.ctapi.mixin.data;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.tags.TagLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.*;

// TODO: Fix it!
@Mixin(TagLoader.class)
public abstract class TagLoaderMixin<T> {
    // @Shadow
    // private volatile Map<ResourceLocation, Collection<CommandFunction>> tags = new LinkedHashMap<>();
    //
    // @Accessor("tags")
    // public abstract Map<ResourceLocation, Collection<CommandFunction>> getTags();

    @ModifyVariable(method = "build(Ljava/util/Map;)Ljava/util/Map;",
        at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private Map<ResourceLocation, Collection<T>> tagAddHooks(Map<ResourceLocation, Collection<T>> map) {
        return map;
    }

    @Inject(method = "load(Lnet/minecraft/server/packs/resources/ResourceManager;)Ljava/util/Map;",
        at = @At(value = "RETURN"),
        locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    public void load(ResourceManager resourceManager,
                     CallbackInfoReturnable<Map<ResourceLocation,
                         List<TagLoader.EntryWithSource>>> cir, Map<ResourceLocation, List<TagLoader.EntryWithSource>> map) {

        // ModLogger.LOGGER.info("{}", map);
        // ModLogger.LOGGER.info("Try to add tag...");
        // JsonObjectBuilder builder = new JsonObjectBuilder();
        // builder.add("values", new JsonArrayBuilder().add("minecraft:dirt").get().getAsJsonArray());
        //
        // List<TagLoader.EntryWithSource> list = map.put(ResourceUtil.of("test"), new ArrayList<>());
        // TagFile tagFile = TagFile.CODEC.parse(new Dynamic<>(JsonOps.INSTANCE, builder.get()))
        //     .getOrThrow(false, ModLogger.LOGGER::error);
        // String string = "vanilla";
        // tagFile.entries().forEach(tagEntry -> list.add(new TagLoader.EntryWithSource(tagEntry, string)));
    }
}
