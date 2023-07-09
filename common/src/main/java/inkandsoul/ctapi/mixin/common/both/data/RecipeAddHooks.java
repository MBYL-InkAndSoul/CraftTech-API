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
public class RecipeAddHooks {
    @Inject(method = "apply*", at = @At("HEAD"))
	protected void onReload(Map<ResourceLocation, JsonElement> map, ResourceManager resourceManager,
						  ProfilerFiller profiler, CallbackInfo ci) {
		RecipeLoader.onRecipeReload(map);
	}
}
