package inkandsoul.ctapi.main.common.both.storage;

import dev.architectury.fluid.FluidStack;
import dev.architectury.hooks.fluid.FluidBucketHooks;
import dev.architectury.hooks.fluid.FluidStackHooks;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SimpleUniContainer implements UniContainer {

    public static UniContainer of(int containerSize, int tankSize) {
        return new SimpleUniContainer(containerSize, tankSize);
    }

    private final NonNullList<ItemStack> container;
    private final NonNullList<FluidStack> tank;

    private SimpleUniContainer(int containerSize, int tankSize) {
        container = NonNullList.withSize(containerSize, ItemStack.EMPTY);
        tank = NonNullList.withSize(tankSize, FluidStack.empty());
    }

    @Override
    public boolean isContainerEmpty() {
        return container.isEmpty();
    }

    @Override
    public boolean isTankEmpty() {
        return tank.isEmpty();
    }

    @Override
    public int getTankSize() {
        return tank.size();
    }

    @Override
    public FluidStack getFluid(int i) {
        return tank.get(i);
    }

    @Override
    public FluidStack removeFluid(int i, int a) {
        var re = tank.get(i);
        re.shrink(a);
        setChanged();
        return re;
    }

    @Override
    public FluidStack removeFluidNoUpdate(int i) {
        return tank.remove(i);
    }

    @Override
    public void setFluid(int i, FluidStack stack) {
        tank.set(i, stack);
    }

    @Override
    public int getContainerSize() {
        return container.size();
    }

    @Override
    public ItemStack getItem(int i) {
        return container.get(i);
    }

    @Override
    public ItemStack removeItem(int i, int j) {
        return ContainerHelper.removeItem(container, i, j);
    }

    @Override
    public ItemStack removeItemNoUpdate(int i) {
        return container.remove(i);
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {
        container.set(i, itemStack);
    }

    @Override
    public void setChanged() {

    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void clearContent() {
        container.clear();
        tank.clear();
    }
}
