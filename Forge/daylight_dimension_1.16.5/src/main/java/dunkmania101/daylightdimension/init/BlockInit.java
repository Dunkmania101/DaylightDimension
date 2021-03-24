package dunkmania101.daylightdimension.init;

import dunkmania101.daylightdimension.DaylightDimension;
import dunkmania101.daylightdimension.objects.blocks.DaylightPortalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DaylightDimension.modid);

    public static final RegistryObject<DaylightPortalBlock> DAYLIGHT_PORTAL = BLOCKS.register("daylight_portal",
            () -> new DaylightPortalBlock(
                    Block.Properties
                            .create(Material.IRON)
                            .sound(SoundType.METAL)
                            .hardnessAndResistance(5f, 6f)
                            .harvestTool(ToolType.PICKAXE)
            ));
}
