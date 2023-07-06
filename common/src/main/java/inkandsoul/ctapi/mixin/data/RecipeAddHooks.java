package inkandsoul.ctapi.mixin.data;

import java.util.Map;

import inkandsoul.ctapi.CT_API;
import inkandsoul.ctapi.recipe.RecipeLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.crafting.RecipeManager;

@Mixin(RecipeManager.class)
public class RecipeAddHooks {
    @Inject(method = "apply*", at = @At("HEAD"))
	protected void onReload(Map<ResourceLocation, JsonElement> map, ResourceManager resourceManager,
						  ProfilerFiller profiler, CallbackInfo ci) {
		RecipeLoader.onRecipeReload(map);
	}
}
