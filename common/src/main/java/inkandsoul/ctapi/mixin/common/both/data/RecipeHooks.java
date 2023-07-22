package inkandsoul.ctapi.mixin.common.both.data;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonElement;
import inkandsoul.ctapi.main.common.both.data.recipe.RecipeLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

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

	//@Inject(method = "apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V",
	//	at = @At(value = "INVOKE", target = "Ljava/util/Set;stream()Ljava/util/stream/Stream;", remap = false),
	//	locals = LocalCapture.CAPTURE_FAILEXCEPTION
	//)
	//public void onReload2(Map<ResourceLocation, JsonElement> map,
	//					  ResourceManager resourceManager,
	//					  ProfilerFiller profilerFiller,
	//					  CallbackInfo ci,
	//					  Map<RecipeType<?>, ImmutableMap.Builder<ResourceLocation, Recipe<?>>> map2) {
	//	RecipeLoader.onBuiltInRecipesReload(map2);
	//}
	//
	//@Redirect(method = "apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V",
	//	at = @At(
	//		value = "INVOKE_ASSIGN",
	//		target = "Lcom/google/common/collect/ImmutableMap;builder()Lcom/google/common/collect/ImmutableMap$Builder;"
	//	)
	//)
	//public ImmutableMap.Builder<ResourceLocation, Recipe<?>> onReload3() {
	//	ImmutableMap.Builder<ResourceLocation, Recipe<?>> map = ImmutableMap.builder();
	//	RecipeLoader.onBuiltInRecipesPreReload(map);
	//	return map;
	//}
}
