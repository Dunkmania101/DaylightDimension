package dunkmania101.daylightdimension.init;

import dunkmania101.daylightdimension.DaylightDimension;
import dunkmania101.daylightdimension.objects.blocks.DaylightPortalBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockInit implements ModInitializer {
    public static final DaylightPortalBlock DAYLIGHT_PORTAL = registerBlock(
            new DaylightPortalBlock(FabricBlockSettings.of(Material.METAL)
                    .sounds(BlockSoundGroup.METAL)
                    .hardness(5f)
                    .resistance(6f)
                    .breakByTool(FabricToolTags.PICKAXES)
            ),
            "daylight_portal"
    );

    public static <B extends Block> B registerBlock(B block, String name) {
        Registry.register(Registry.BLOCK, new Identifier(DaylightDimension.modid, name), block);
        return block;
    }

    @Override
    public void onInitialize() {
    }
}
