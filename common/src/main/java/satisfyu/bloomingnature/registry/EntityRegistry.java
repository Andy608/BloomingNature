package satisfyu.bloomingnature.registry;

import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import satisfyu.bloomingnature.BloomingNature;
import satisfyu.bloomingnature.entity.boar.BoarEntity;
import satisfyu.bloomingnature.entity.deer.DeerEntity;
import satisfyu.bloomingnature.entity.mossy_sheep.MossySheepEntity;
import satisfyu.bloomingnature.entity.mossy_sheep.SheepEntity;
import satisfyu.bloomingnature.entity.muddy_pig.MuddyPigEntity;
import satisfyu.bloomingnature.entity.owl.OwlEntity;
import satisfyu.bloomingnature.entity.pelican.PelicanEntity;
import satisfyu.bloomingnature.entity.raccoon.RaccoonEntity;
import satisfyu.bloomingnature.entity.red_wolf.RedWolfEntity;
import satisfyu.bloomingnature.entity.squirrel.SquirrelEntity;
import satisfyu.bloomingnature.entity.wandering_gardener.WanderingGardenerEntity;
import satisfyu.bloomingnature.util.BloomingNatureIdentifier;

import java.util.function.Supplier;

public class EntityRegistry {
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BloomingNature.MOD_ID, Registries.ENTITY_TYPE);


    public static final RegistrySupplier<EntityType<WanderingGardenerEntity>> WANDERING_GARDENER = create("wandering_gardener",
            () -> EntityType.Builder.of(WanderingGardenerEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 1.95f)
                    .clientTrackingRange(10)
                    .build(new BloomingNatureIdentifier("wandering_gardener").toString()));

    public static final RegistrySupplier<EntityType<RedWolfEntity>> RED_WOLF = create("red_wolf",
            () -> EntityType.Builder.of(RedWolfEntity::new, MobCategory.CREATURE)
                    .sized(0.4f, 1.5f)
                    .clientTrackingRange(10)
                    .build(new BloomingNatureIdentifier("red_wolf").toString()));

    public static final RegistrySupplier<EntityType<PelicanEntity>> PELICAN = create("pelican",
            () -> EntityType.Builder.of(PelicanEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.3f)
                    .build(new BloomingNatureIdentifier("pelican").toString())
    );

    public static final RegistrySupplier<EntityType<RaccoonEntity>> RACCOON = create("raccoon",
            () -> EntityType.Builder.of(RaccoonEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.3f)
                    .build(new BloomingNatureIdentifier("raccoon").toString())
    );

    public static final RegistrySupplier<EntityType<MossySheepEntity>> MOSSY_SHEEP = create("mossy_sheep",
            () -> EntityType.Builder.of(MossySheepEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.3f)
                    .build(new ResourceLocation(BloomingNature.MOD_ID, "mossy_sheep").toString())
    );

    public static final RegistrySupplier<EntityType<SquirrelEntity>> SQUIRREL = create("squirrel",
            () -> EntityType.Builder.of(SquirrelEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.3f)
                    .build(new BloomingNatureIdentifier("raccoon").toString())
    );

    public static final RegistrySupplier<EntityType<MuddyPigEntity>> MUDDY_PIG = create("muddy_pig",
            () -> EntityType.Builder.of(MuddyPigEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.3f)
                    .build(new BloomingNatureIdentifier("muddy_pig").toString())
    );

    public static final RegistrySupplier<EntityType<DeerEntity>> DEER = create("deer",
            () -> EntityType.Builder.of(DeerEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.3f)
                    .build(new BloomingNatureIdentifier("deer").toString())
    );

    public static final RegistrySupplier<EntityType<OwlEntity>> OWL = create("owl",
            () -> EntityType.Builder.of(OwlEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.3f)
                    .build(new BloomingNatureIdentifier("owl").toString())
    );

    public static final RegistrySupplier<EntityType<BoarEntity>> BOAR = create("boar",
            () -> EntityType.Builder.of(BoarEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.9f)
                    .build(new BloomingNatureIdentifier("boar").toString())
    );



    public static <T extends EntityType<?>> RegistrySupplier<T> create(final String path, final Supplier<T> type) {
        return ENTITY_TYPES.register(new BloomingNatureIdentifier(path), type);
    }

    public static void init() {
        BloomingNature.LOGGER.debug("Registering Entities for " + BloomingNature.MOD_ID);
        ENTITY_TYPES.register();
        EntityAttributeRegistry.register(WANDERING_GARDENER, WanderingGardenerEntity::createMobAttributes);
        EntityAttributeRegistry.register(MOSSY_SHEEP, SheepEntity::createMobAttributes);
        EntityAttributeRegistry.register(DEER, DeerEntity::createMobAttributes);
        EntityAttributeRegistry.register(PELICAN, PelicanEntity::createMobAttributes);
        EntityAttributeRegistry.register(RED_WOLF, RedWolfEntity::createMobAttributes);
        EntityAttributeRegistry.register(RACCOON, RaccoonEntity::createMobAttributes);
        EntityAttributeRegistry.register(SQUIRREL, SquirrelEntity::createMobAttributes);
        EntityAttributeRegistry.register(MUDDY_PIG, MuddyPigEntity::createMobAttributes);
        EntityAttributeRegistry.register(OWL, OwlEntity::createMobAttributes);
        EntityAttributeRegistry.register(BOAR, BoarEntity::createMobAttributes);
    }
}
