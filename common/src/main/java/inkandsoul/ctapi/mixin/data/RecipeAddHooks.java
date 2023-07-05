package inkandsoul.ctapi.mixin.data;

import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import inkandsoul.ctapi.util.ResourceUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.crafting.RecipeManager;

@Mixin(RecipeManager.class)
public class RecipeAddHooks {
    @Inject(method = "apply*", at = @At("HEAD"))
	protected void onReload(Map<ResourceLocation, JsonElement> map, ResourceManager resourceManager,
						  ProfilerFiller profiler, CallbackInfo ci) {
		var testRecipe = new JsonObject();
		testRecipe.addProperty("null", "null");
		map.put(ResourceUtil.of("test"), testRecipe);
	}
}
