package inkandsoul.ctapi.main.common.both.recipe.fluid;

import com.google.common.collect.Lists;
import dev.architectury.fluid.FluidStack;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * A fluid ingredient.
 */
public class FluidIngredient implements Predicate<FluidStack> {

    public static final FluidIngredient EMPTY = new FluidIngredient(Stream.empty());

    private final Value[] values;
    private FluidStack[] stacks;

    private FluidIngredient(Stream<? extends Value> stream) {
        this.values = stream.toArray(Value[]::new);
    }

    @Override
    public boolean test(FluidStack fluidStack) {
        if (fluidStack == null) {
            return false;
        }

        for (FluidStack stack : stacks) {
            if (!stack.equals(fluidStack)) {
                return false;
            }
        }
        return true;
    }

    public FluidStack[] getFluids() {
        if (this.stacks == null) {
            this.stacks = Arrays.stream(this.values)
                .flatMap(value -> value.getFluids().stream()).distinct().toArray(FluidStack[]::new);
        }
        return this.stacks;
    }

    public interface Value {
        Collection<FluidStack> getFluids();
    }

    public static class TagValue implements Value {

        private final TagKey<Fluid> tag;

        public TagValue(TagKey<Fluid> tag) {
            this.tag = tag;
        }

        @Override
        public Collection<FluidStack> getFluids() {
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
        public Collection<FluidStack> getFluids() {
            return Collections.singleton(stack);
        }
    }
}
