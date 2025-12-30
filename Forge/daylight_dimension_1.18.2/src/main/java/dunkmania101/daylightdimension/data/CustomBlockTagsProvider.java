package dunkmania101.daylightdimension.data;

import dunkmania101.daylightdimension.DaylightDimension;
import dunkmania101.daylightdimension.init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CustomBlockTagsProvider extends BlockTagsProvider {
    public CustomBlockTagsProvider(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, DaylightDimension.modid, existingFileHelper);
    }

    @Override
    protected void addTags() {
        BlockInit.BLOCKS.getEntries().forEach((entry) -> {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(entry.get());
        });
    }
}
