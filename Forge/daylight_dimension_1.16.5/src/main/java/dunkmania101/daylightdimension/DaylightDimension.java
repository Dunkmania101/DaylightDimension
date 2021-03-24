package dunkmania101.daylightdimension;

import dunkmania101.daylightdimension.init.BlockInit;
import dunkmania101.daylightdimension.init.ItemInit;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DaylightDimension.modid)
public class DaylightDimension {
    public static final String modid = "daylightdimension";
    public static RegistryKey<World> DAYLIGHT_DIMENSION;

    public DaylightDimension() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        modBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);

        ItemInit.ITEMS.register(modBus);
        BlockInit.BLOCKS.register(modBus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DAYLIGHT_DIMENSION = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(modid, "daylight_dimension"));
    }
}
