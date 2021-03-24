package dunkmania101.daylightdimension.init;

import dunkmania101.daylightdimension.DaylightDimension;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemInit implements ModInitializer {
    public static final BlockItem DAYLIGHT_PORTAL = registerItem(
            new BlockItem(BlockInit.DAYLIGHT_PORTAL,
                    new FabricItemSettings()
                    .group(ItemGroup.TOOLS)
            ),
            "daylight_portal"
    );

    public static <I extends Item> I registerItem(I item, String name) {
        Registry.register(Registry.ITEM, new Identifier(DaylightDimension.modid, name), item);
        return item;
    }

    @Override
    public void onInitialize() {
    }
}
