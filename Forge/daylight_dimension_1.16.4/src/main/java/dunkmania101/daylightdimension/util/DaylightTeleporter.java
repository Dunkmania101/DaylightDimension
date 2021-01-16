package dunkmania101.daylightdimension.util;

import dunkmania101.daylightdimension.init.BlockInit;
import dunkmania101.daylightdimension.objects.blocks.DaylightPortalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class DaylightTeleporter implements ITeleporter {
    public static BlockPos thisPos = BlockPos.ZERO;
    public static boolean thisIsToDaylightDim = true;

    public DaylightTeleporter(BlockPos pos, boolean isToDaylightDim) {
        thisPos = pos;
        thisIsToDaylightDim = isToDaylightDim;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);
        double y = 61;
        if (!thisIsToDaylightDim) {
            y = thisPos.getY();
        }
        BlockPos destPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());
        int tries = 0;
        while ((destWorld.getBlockState(destPos).getMaterial() != Material.AIR && !destWorld.getBlockState(destPos).isReplaceable(Fluids.WATER)) &&
                (destWorld.getBlockState(destPos.up()).getMaterial() != Material.AIR && !destWorld.getBlockState(destPos.up()).isReplaceable(Fluids.WATER)) &&
                tries < 25) {
            destPos = destPos.up(2);
            tries++;
        }
        entity.setPositionAndUpdate(destPos.getX(), destPos.getY(), destPos.getZ());
        if (thisIsToDaylightDim) {
            boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.getAllInBoxMutable(destPos.down(10).west(10), destPos.up(10).east(10))) {
                if (destWorld.getBlockState(checkPos).getBlock() instanceof DaylightPortalBlock) {
                    doSetBlock = false;
                    break;
                }
            }
            if (doSetBlock) {
                destWorld.setBlockState(destPos, BlockInit.DAYLIGHT_PORTAL.get().getDefaultState());
            }
        }
        return entity;
    }
}
