package satisfyu.bloomingnature;

import dev.architectury.hooks.item.tool.AxeItemHooks;
import net.minecraft.world.level.block.Blocks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import satisfyu.bloomingnature.registry.*;

public class BloomingNature {
    public static final String MOD_ID = "bloomingnature";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static void init() {
        ObjectRegistry.init();
        BoatsAndSignsRegistry.init();
        BlockEntityRegistry.init();
        EntityRegistry.init();
        TabRegistry.init();
        PlacerTypesRegistry.init();
    }

    public static void commonInit() {
        ObjectRegistry.registerCompostable();
        AxeItemHooks.addStrippable(ObjectRegistry.ASPEN_LOG.get(), ObjectRegistry.STRIPPED_ASPEN_LOG.get());
        AxeItemHooks.addStrippable(ObjectRegistry.ASPEN_WOOD.get(), ObjectRegistry.STRIPPED_ASPEN_WOOD.get());
        AxeItemHooks.addStrippable(ObjectRegistry.BAOBAB_LOG.get(), ObjectRegistry.STRIPPED_BAOBAB_LOG.get());
        AxeItemHooks.addStrippable(ObjectRegistry.BAOBAB_WOOD.get(), ObjectRegistry.STRIPPED_BAOBAB_WOOD.get());
        AxeItemHooks.addStrippable(ObjectRegistry.SWAMP_CYPRESS_LOG.get(), ObjectRegistry.STRIPPED_SWAMP_CYPRESS_LOG.get());
        AxeItemHooks.addStrippable(ObjectRegistry.SWAMP_CYPRESS_WOOD.get(), ObjectRegistry.STRIPPED_SWAMP_CYPRESS_WOOD.get());
        AxeItemHooks.addStrippable(ObjectRegistry.SWAMP_OAK_LOG.get(), ObjectRegistry.STRIPPED_SWAMP_OAK_LOG.get());
        AxeItemHooks.addStrippable(ObjectRegistry.SWAMP_OAK_WOOD.get(), ObjectRegistry.STRIPPED_SWAMP_OAK_WOOD.get());
        AxeItemHooks.addStrippable(ObjectRegistry.PALM_LOG.get(), ObjectRegistry.STRIPPED_PALM_LOG.get());
        AxeItemHooks.addStrippable(ObjectRegistry.PALM_WOOD.get(), ObjectRegistry.STRIPPED_PALM_WOOD.get());
        AxeItemHooks.addStrippable(ObjectRegistry.FIR_LOG.get(), ObjectRegistry.STRIPPED_FIR_LOG.get());
        AxeItemHooks.addStrippable(ObjectRegistry.FIR_WOOD.get(), ObjectRegistry.STRIPPED_FIR_WOOD.get());
        AxeItemHooks.addStrippable(ObjectRegistry.LARCH_LOG.get(), ObjectRegistry.STRIPPED_LARCH_LOG.get());
        AxeItemHooks.addStrippable(ObjectRegistry.LARCH_WOOD.get(), ObjectRegistry.STRIPPED_LARCH_WOOD.get());
    }
}

