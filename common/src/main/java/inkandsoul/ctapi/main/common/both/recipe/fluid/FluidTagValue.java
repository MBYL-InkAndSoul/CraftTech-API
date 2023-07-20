package inkandsoul.ctapi.main.common.both.recipe.fluid;

import net.minecraft.world.level.material.Fluid;

/**
 * How much fluid can equals.
 * @param fluid
 * @param amount
 */
public record FluidTagValue(Fluid fluid, int amount) {
}
