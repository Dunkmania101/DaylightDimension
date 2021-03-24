package dunkmania101.daylightdimension.init;

import dunkmania101.daylightdimension.DaylightDimension;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DaylightDimension.modid);

    public static final RegistryObject<BlockItem> DAYLIGHT_PORTAL = ITEMS.register("daylight_portal",
            () -> new BlockItem(
                    BlockInit.DAYLIGHT_PORTAL.get(),
                    new Item.Properties()
                            .group(ItemGroup.TOOLS)
            ));
}
