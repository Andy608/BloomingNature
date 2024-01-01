package satisfyu.bloomingnature.entity.owl;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import satisfyu.bloomingnature.BloomingNature;

public class OwlRenderer extends MobRenderer<OwlEntity, OwlModel>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(BloomingNature.MOD_ID, "textures/entity/owl.png");

    public OwlRenderer(EntityRendererProvider.Context context) {
        super(context, new OwlModel(context.bakeLayer(OwlModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(OwlEntity entity) {
        return TEXTURE;
    }

    @Override
    protected void renderNameTag(OwlEntity entity, Component component, PoseStack poseStack, MultiBufferSource multiBufferSource, int i)
    {
        poseStack.pushPose();
        if(entity.isBaby())
            poseStack.translate(0, 0.5F, 0);

        super.renderNameTag(entity, component, poseStack, multiBufferSource, i);

        poseStack.popPose();
    }

    @Override
    protected void setupRotations(OwlEntity owl, PoseStack poseStack, float f, float g, float h) {
        super.setupRotations(owl, poseStack, f, g, h);
        if(owl.isInSittingPose()) poseStack.translate(0, -0.1F, 0);

        float i = owl.getSwimAmount(h);

        poseStack.translate(0, (i / 7F) / 2F, (i / 7F) / 2F);
        if(i > 0.0F)
        {
            poseStack.mulPose(Axis.XP.rotationDegrees(Mth.lerp(i, 0, -7.0F)));
        }
        poseStack.scale(0.75F, 0.75F, 0.75F);
    }
}
