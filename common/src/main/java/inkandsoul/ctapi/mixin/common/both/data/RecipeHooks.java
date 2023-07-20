package inkandsoul.ctapi.mixin.common.both.data;

import com.google.gson.JsonElement;
import inkandsoul.ctapi.main.common.both.data.recipe.RecipeLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.crafting.RecipeManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(RecipeManager.class)
public class RecipeHooks {

	@Inject(method = "apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V"
		, at = @At("HEAD"))
	public void onReload(Map<ResourceLocation, JsonElement> map, ResourceManager resourceManager, ProfilerFiller profilerFiller, CallbackInfo ci) {
		//RecipeLoader
		RecipeLoader.onRecipesReload(map);
		//RecipeReloadEvent.EVENT.invoker().reload((HashMap<RecipeType, ImmutableMap.Builder<ResourceLocation, Recipe<?>>>) map2);
	}
}
