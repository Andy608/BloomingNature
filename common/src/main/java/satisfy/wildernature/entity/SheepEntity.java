package satisfy.wildernature.entity;

import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import satisfy.wildernature.registry.EntityRegistry;

import java.util.Map;

public class SheepEntity extends Sheep {
    private final Block woolBlock;

    private final ResourceLocation lootTable;
    private final Map<DyeColor, ItemLike> DROPS = Util.make(Maps.newEnumMap(DyeColor.class), map -> {
        map.put(DyeColor.ORANGE, Blocks.ORANGE_WOOL);
        map.put(DyeColor.MAGENTA, Blocks.MAGENTA_WOOL);
        map.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_WOOL);
        map.put(DyeColor.YELLOW, Blocks.YELLOW_WOOL);
        map.put(DyeColor.LIME, Blocks.LIME_WOOL);
        map.put(DyeColor.PINK, Blocks.PINK_WOOL);
        map.put(DyeColor.GRAY, Blocks.GRAY_WOOL);
        map.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_WOOL);
        map.put(DyeColor.CYAN, Blocks.CYAN_WOOL);
        map.put(DyeColor.PURPLE, Blocks.PURPLE_WOOL);
        map.put(DyeColor.BLUE, Blocks.BLUE_WOOL);
        map.put(DyeColor.BROWN, Blocks.BROWN_WOOL);
        map.put(DyeColor.GREEN, Blocks.GREEN_WOOL);
        map.put(DyeColor.RED, Blocks.RED_WOOL);
        map.put(DyeColor.BLACK, Blocks.BLACK_WOOL);
    });

    public SheepEntity(EntityType<? extends Sheep> entityType, Level world, Block woolBlock, ResourceLocation lootTable) {
        super(entityType, world);
        this.woolBlock = woolBlock;
        this.lootTable = lootTable;
    }

    public static AttributeSupplier.Builder createMobAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 9.0).add(Attributes.MOVEMENT_SPEED, 0.23000000417232513);
    }

    @Override
    public Sheep getBreedOffspring(ServerLevel serverWorld, AgeableMob passiveEntity) {
        return EntityRegistry.MOSSY_SHEEP.get().create(serverWorld);
    }

    @Override
    public void shear(SoundSource shearedSoundCategory) {
        if (!DROPS.containsValue(woolBlock)) DROPS.put(DyeColor.WHITE, woolBlock);
        this.level().playSound(null, this, SoundEvents.SHEEP_SHEAR, shearedSoundCategory, 1.0F, 1.0F);
        this.setSheared(true);
        int i = 1 + this.random.nextInt(3);

        for (int j = 0; j < i; ++j) {
            ItemEntity itemEntity = this.spawnAtLocation(DROPS.get(this.getColor()), 1);
            if (itemEntity != null) {
                itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().add((this.random.nextFloat() - this.random.nextFloat()) * 0.1F, this.random.nextFloat() * 0.05F, (this.random.nextFloat() - this.random.nextFloat()) * 0.1F));
            }
        }

    }

    @Override
    public ResourceLocation getDefaultLootTable() {
        if (this.isSheared()) {
            return this.getType().getDefaultLootTable();
        }
        switch (this.getColor()) {
            default: {
                return lootTable;
            }
            case ORANGE: {
                return BuiltInLootTables.SHEEP_ORANGE;
            }
            case MAGENTA: {
                return BuiltInLootTables.SHEEP_MAGENTA;
            }
            case LIGHT_BLUE: {
                return BuiltInLootTables.SHEEP_LIGHT_BLUE;
            }
            case YELLOW: {
                return BuiltInLootTables.SHEEP_YELLOW;
            }
            case LIME: {
                return BuiltInLootTables.SHEEP_LIME;
            }
            case PINK: {
                return BuiltInLootTables.SHEEP_PINK;
            }
            case GRAY: {
                return BuiltInLootTables.SHEEP_GRAY;
            }
            case LIGHT_GRAY: {
                return BuiltInLootTables.SHEEP_LIGHT_GRAY;
            }
            case CYAN: {
                return BuiltInLootTables.SHEEP_CYAN;
            }
            case PURPLE: {
                return BuiltInLootTables.SHEEP_PURPLE;
            }
            case BLUE: {
                return BuiltInLootTables.SHEEP_BLUE;
            }
            case BROWN: {
                return BuiltInLootTables.SHEEP_BROWN;
            }
            case GREEN: {
                return BuiltInLootTables.SHEEP_GREEN;
            }
            case RED: {
                return BuiltInLootTables.SHEEP_RED;
            }
            case BLACK:
        }
        return BuiltInLootTables.SHEEP_BLACK;
    }
}