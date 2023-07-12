package inkandsoul.ctapi.mixin.forge.both;

import net.minecraftforge.registries.GameData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("UnstableApiUsage")
@Mixin(GameData.class)
public class GameDataMixin {
    @Inject(method = "init", remap = false, at = @At("TAIL"))
    public void regAddHooks(CallbackInfo ci) {

    }
}
