package dunkmania101.daylightdimension;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

public class DaylightDimension implements ModInitializer {
	public static final String modid = "daylightdimension";

	public static RegistryKey<World> DAYLIGHT_DIMENSION = RegistryKey.of(Registry.DIMENSION, new Identifier(modid, "daylight_dimension"));

	@Override
	public void onInitialize() {
	}
}
