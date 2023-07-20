package inkandsoul.ctapi.main.common.both.machine;

import inkandsoul.ctapi.main.common.both.recipe.machine.RecipeFactory;
import inkandsoul.ctapi.main.common.both.storage.UniContainer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class MachineRecipeProgress {
    private int progress;
    private RecipeFactory.Recipe cache;
    private final RecipeFactory recipeFactory;

    public MachineRecipeProgress(int progress, RecipeFactory recipeFactory) {
        this.progress = progress;
        this.recipeFactory = recipeFactory;
    }

    public void onContainerUpdate(Level world, UniContainer container) {
        cache = null;
        //recipeFactory.
        //world.getServer().getRecipeManager().getRecipeFor(RecipeType.CRAFTING, container, world);
    }

    public int getProgress() {
        return progress;
    }

    public void clearProgress() {
        this.progress = 0;
    }
}
