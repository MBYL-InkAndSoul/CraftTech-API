package inkandsoul.ctapi.item;

import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;

public interface Washable {
	public static final Event<Washable> EVENT = EventFactory.createEventResult(Washable.class);

	public static void setFluidAmount(Level level, BlockPos pos, BlockState state, int value){
		var block = state.getBlock();
		level.setBlock(pos, state.setValue(LayeredCauldronBlock.LEVEL, value), 0);
		
		level.updateNeighborsAt(pos, block);
		// 將一個方塊的刻事件延緩X tick。
      	// level.scheduleTick(pos, block, block.ticksToStayPressed);
	}

	public static void shrinkFluidAmount(Level level, BlockPos pos, BlockState state, int value){
		setFluidAmount(level, pos, state, state.getValue(LayeredCauldronBlock.LEVEL)-value);
	}

	public static boolean cauldronFluidIsWater(BlockState state){
		return BuiltInRegistries.BLOCK.getKey(state.getBlock()).getPath().equals("water_cauldron");
	}

	public static boolean cauldronFluidIsPowderSnow(BlockState state){
		return BuiltInRegistries.BLOCK.getKey(state.getBlock()).getPath().equals("powder_snow_cauldron");
	}

	public static boolean cauldronFluidIsLava(BlockState state){
		return BuiltInRegistries.BLOCK.getKey(state.getBlock()).getPath().equals("lava_cauldron");
	}

	// public static Fluid getCauldronFluid(BlockState state){
	// 	return state.getV
	// }

	ItemStack wasWashed(Level world, BlockState state, BlockPos pos, ItemStack stack);
}