package satisfy.wildernature.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import satisfy.wildernature.client.model.MuddyPigModel;
import satisfy.wildernature.entity.MuddyPigEntity;
import satisfy.wildernature.util.WilderNatureIdentifier;


@Environment(value = EnvType.CLIENT)
public class MuddyPigRenderer extends MobRenderer<MuddyPigEntity, MuddyPigModel<MuddyPigEntity>> {
    private static final ResourceLocation TEXTURE = new WilderNatureIdentifier("textures/entity/muddy_pig.png");

    public MuddyPigRenderer(EntityRendererProvider.Context context) {
        super(context, new MuddyPigModel(context.bakeLayer(MuddyPigModel.LAYER_LOCATION)), 0.7f);
    }

    @Override
    public void render(MuddyPigEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(MuddyPigEntity entity) {
        return TEXTURE;
    }
}
