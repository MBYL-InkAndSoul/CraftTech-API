package inkandsoul.ctapi.main.common.both.fluid;

import inkandsoul.ctapi.CT_API;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class BaseFluidTags {

    public static final TagKey<Fluid> WATER_LIKE = TagKey.create(Registries.FLUID, CT_API.REG.ofId("water_like"));

}
