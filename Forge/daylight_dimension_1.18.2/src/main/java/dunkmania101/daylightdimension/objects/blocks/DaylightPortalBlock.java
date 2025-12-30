package dunkmania101.daylightdimension.objects.blocks;

import dunkmania101.daylightdimension.DaylightDimension;
import dunkmania101.daylightdimension.util.DaylightTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class DaylightPortalBlock extends Block {
    public DaylightPortalBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (!worldIn.isClientSide()) {
            if (!player.isCrouching()) {
                MinecraftServer server = worldIn.getServer();
                if (server != null) {
                    if (worldIn.dimension() == DaylightDimension.DAYLIGHT_DIMENSION) {
                        ServerLevel overWorld = server.getLevel(Level.OVERWORLD);
                        if (overWorld != null) {
                            player.changeDimension(overWorld, new DaylightTeleporter(pos, false));
                        }
                    } else {
                        ServerLevel daylightWorld = server.getLevel(DaylightDimension.DAYLIGHT_DIMENSION);
                        if (daylightWorld != null) {
                            player.changeDimension(daylightWorld, new DaylightTeleporter(pos, true));
                        }
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return super.use(state, worldIn, pos, player, handIn, hit);
    }
}
