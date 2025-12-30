package dunkmania101.daylightdimension.util;

import dunkmania101.daylightdimension.init.BlockInit;
import dunkmania101.daylightdimension.objects.blocks.DaylightPortalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
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
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);
        double y = 61;
        if (!thisIsToDaylightDim) {
            y = thisPos.getY();
        }
        BlockPos destPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());
        int tries = 0;
        while ((destWorld.getBlockState(destPos).getMaterial() != Material.AIR && !destWorld.getBlockState(destPos).canBeReplaced(Fluids.WATER)) &&
                (destWorld.getBlockState(destPos.above()).getMaterial() != Material.AIR && !destWorld.getBlockState(destPos.above()).canBeReplaced(Fluids.WATER)) &&
                tries < 25) {
            destPos = destPos.above(2);
            tries++;
        }
        entity.moveTo(destPos.getX(), destPos.getY(), destPos.getZ());
        if (thisIsToDaylightDim) {
            boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.betweenClosed(destPos.below(10).west(10), destPos.below(10).east(10))) {
                if (destWorld.getBlockState(checkPos).getBlock() instanceof DaylightPortalBlock) {
                    doSetBlock = false;
                    break;
                }
            }
            if (doSetBlock) {
                destWorld.setBlockAndUpdate(destPos, BlockInit.DAYLIGHT_PORTAL.get().defaultBlockState());
            }
        }
        return entity;
    }
}
