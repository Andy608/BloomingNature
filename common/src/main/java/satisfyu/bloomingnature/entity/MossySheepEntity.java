package satisfyu.bloomingnature.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import satisfyu.bloomingnature.BloomingNature;
import satisfyu.bloomingnature.registry.EntityRegistry;

public class MossySheepEntity extends SheepEntity {
    public MossySheepEntity(EntityType<? extends Sheep> entityType, Level world) {
        super(entityType, world, Blocks.MOSS_BLOCK, new ResourceLocation(BloomingNature.MOD_ID, "entities/mossy_sheep"));
    }

    @Override
    public Sheep getBreedOffspring(ServerLevel serverWorld, AgeableMob passiveEntity) {
        return EntityRegistry.MOSSY_SHEEP.get().create(serverWorld);
    }
}