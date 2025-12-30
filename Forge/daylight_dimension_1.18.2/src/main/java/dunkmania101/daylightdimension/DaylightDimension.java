package dunkmania101.daylightdimension;

import cpw.mods.modlauncher.api.ITransformationService.Resource;
import dunkmania101.daylightdimension.init.BlockInit;
import dunkmania101.daylightdimension.init.ItemInit;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DaylightDimension.modid)
public class DaylightDimension {
    public static final String modid = "daylightdimension";
    public static ResourceKey<Level> DAYLIGHT_DIMENSION;

    public DaylightDimension() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        modBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);

        ItemInit.ITEMS.register(modBus);
        BlockInit.BLOCKS.register(modBus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DAYLIGHT_DIMENSION = ResourceKey.create(Registry.DIMENSION_REGISTRY, ResourceLocation.fromNamespaceAndPath(modid, "daylight_dimension"));
    }
}
