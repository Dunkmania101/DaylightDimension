package dunkmania101.daylightdimension.objects.blocks;

import dunkmania101.daylightdimension.DaylightDimension;
import dunkmania101.daylightdimension.util.DaylightTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class DaylightPortalBlock extends Block {
    public DaylightPortalBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote()) {
            if (!player.isCrouching()) {
                MinecraftServer server = worldIn.getServer();
                if (server != null) {
                    if (worldIn.getDimensionKey() == DaylightDimension.DAYLIGHT_DIMENSION) {
                        ServerWorld overWorld = server.getWorld(World.OVERWORLD);
                        if (overWorld != null) {
                            player.changeDimension(overWorld, new DaylightTeleporter(pos, false));
                        }
                    } else {
                        ServerWorld daylightWorld = server.getWorld(DaylightDimension.DAYLIGHT_DIMENSION);
                        if (daylightWorld != null) {
                            player.changeDimension(daylightWorld, new DaylightTeleporter(pos, true));
                        }
                    }
                    return ActionResultType.SUCCESS;
                }
            }
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
