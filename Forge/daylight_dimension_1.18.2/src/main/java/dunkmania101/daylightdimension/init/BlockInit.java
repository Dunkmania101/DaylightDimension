package dunkmania101.daylightdimension.init;

import dunkmania101.daylightdimension.DaylightDimension;
import dunkmania101.daylightdimension.objects.blocks.DaylightPortalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DaylightDimension.modid);

    public static final RegistryObject<DaylightPortalBlock> DAYLIGHT_PORTAL = BLOCKS.register("daylight_portal",
            () -> new DaylightPortalBlock(
                    Block.Properties
                            .of(Material.METAL)
                            .sound(SoundType.METAL)
                            .strength(5f, 6f)
                            .requiresCorrectToolForDrops()
            ));
}
