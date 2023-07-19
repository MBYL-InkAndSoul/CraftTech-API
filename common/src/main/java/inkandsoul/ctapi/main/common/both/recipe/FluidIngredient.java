package inkandsoul.ctapi.main.common.both.recipe;

import com.google.common.collect.Lists;
import dev.architectury.fluid.FluidStack;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * A fluid ingredient.
 */
public class FluidIngredient implements Predicate<FluidStack> {

    public static final FluidIngredient EMPTY = new FluidIngredient();

    private FluidStack[] stacks;

    @Override
    public boolean test(FluidStack itemStack) {
        return false;
    }

    public interface Value {
        Collection<FluidStack> getStacks();
    }

    public static class TagValue implements Value {

        private final TagKey<Fluid> tag;

        public TagValue(TagKey<Fluid> tag) {
            this.tag = tag;
        }

        @Override
        public Collection<FluidStack> getStacks() {
            List<FluidStack> list = Lists.newArrayList();

            for (Holder<Fluid> holder : BuiltInRegistries.FLUID.getOrCreateTag(tag)) {
                list.add(FluidStack.create(holder.value(), 1));
            }

            return list;
        }
    }

    public static class FluidValue implements Value {

        private final FluidStack stack;

        public FluidValue(FluidStack stack) {
            this.stack = stack;
        }

        @Override
        public Collection<FluidStack> getStacks() {
            return Collections.singleton(stack);
        }
    }
}
