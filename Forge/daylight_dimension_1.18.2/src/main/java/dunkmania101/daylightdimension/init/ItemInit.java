package dunkmania101.daylightdimension.init;

import dunkmania101.daylightdimension.DaylightDimension;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DaylightDimension.modid);

    public static final RegistryObject<BlockItem> DAYLIGHT_PORTAL = ITEMS.register("daylight_portal",
            () -> new BlockItem(
                    BlockInit.DAYLIGHT_PORTAL.get(),
                    new Item.Properties()
                            .tab(CreativeModeTab.TAB_TOOLS)
            ));
}
