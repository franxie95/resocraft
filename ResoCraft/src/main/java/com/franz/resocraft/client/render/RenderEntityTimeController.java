package com.franz.resocraft.client.render;

import com.franz.resocraft.client.model.ModelTimeController;
import com.franz.resocraft.tragicmc2.entity.boss.EntityRCBoss;
import com.franz.resocraft.tragicmc2.entity.boss.EntityTimeController;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class RenderEntityTimeController extends RenderEntityTragicBoss {
    private static final ResourceLocation TEXTURES = new ResourceLocation("resocraft:textures/entity/time_controller.png");
    public ModelTimeController model = new ModelTimeController();

    public RenderEntityTimeController(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelTimeController(), 0.415F);
        this.addLayer(new LayerTimeControllerPurge(this, TEXTURES));
    }

    public void render(EntityRCBoss entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        boolean shouldSit = entityIn.isPassenger() && entityIn.getRidingEntity() != null && entityIn.getRidingEntity().shouldRiderSit();
        float f = MathHelper.interpolateAngle(partialTicks, entityIn.prevRenderYawOffset, entityIn.renderYawOffset);
        float f1 = MathHelper.interpolateAngle(partialTicks, entityIn.prevRotationYawHead, entityIn.rotationYawHead);
        float f2 = f1 - f;
        float f7;
        if (shouldSit && entityIn.getRidingEntity() instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity)entityIn.getRidingEntity();
            f = MathHelper.interpolateAngle(partialTicks, livingentity.prevRenderYawOffset, livingentity.renderYawOffset);
            f2 = f1 - f;
            f7 = MathHelper.wrapDegrees(f2);
            if (f7 < -85.0F) {
                f7 = -85.0F;
            }

            if (f7 >= 85.0F) {
                f7 = 85.0F;
            }

            f = f1 - f7;
            if (f7 * f7 > 2500.0F) {
                f += f7 * 0.2F;
            }

            f2 = f1 - f;
        }

        float f6 = MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch);
        f7 = this.handleRotationFloat(entityIn, partialTicks);
        float f8 = 0.0F;
        float f5 = 0.0F;
        matrixStackIn.scale(1.0F, -1.0F, 1.0F);
        if (!shouldSit && entityIn.isAlive()) {
            f8 = MathHelper.lerp(partialTicks, entityIn.prevLimbSwingAmount, entityIn.limbSwingAmount);
            f5 = entityIn.limbSwing - entityIn.limbSwingAmount * (1.0F - partialTicks);
            if (f8 > 1.0F) {
                f8 = 1.0F;
            }
        }

        if (!entityIn.isInvisible() && !entityIn.isInvisibleToPlayer(Minecraft.getInstance().player)) {
            matrixStackIn.push();
            matrixStackIn.translate(0.0, -1.5010000467300415, 0.0);
            float f22 = 1.8F;
            EntityTimeController ctrl = (EntityTimeController)entityIn;
            Minecraft minecraft = Minecraft.getInstance();
            boolean flag = this.isVisible(entityIn);
            boolean flag1 = !flag && !entityIn.isInvisibleToPlayer(minecraft.player);
            boolean flag2 = minecraft.isEntityGlowing(entityIn);
            RenderType rendertype = this.func_230496_a_(entityIn, flag, flag1, flag2);
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(770, 771);
            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(rendertype);
            int i = getPackedOverlay(entityIn, this.getOverlayProgress(entityIn, partialTicks));
            float red = 1.0F;
            float green = 1.0F;
            float blue = 1.0F;
            float alpha = flag1 ? 0.15F : 1.0F;
            if (ctrl.getLeapTicks() > 0) {
                f22 = 1.0F + MathHelper.cos((float)ctrl.ticksExisted * 0.4F) * 0.876F;
                red = f22 - 0.4F;
                green = f22;
                blue = f22 - 0.4F;
                alpha = 1.0F;
            }

            this.model.setLivingAnimations(entityIn, f5, f8, partialTicks);
            this.model.setRotationAngles(entityIn, f5, f8, f7, f2, f6);
            this.model.render(matrixStackIn, ivertexbuilder, packedLightIn, i, red, green, blue, alpha);
            if (!entityIn.isSpectator()) {
                Iterator var28 = this.layerRenderers.iterator();

                while(var28.hasNext()) {
                    LayerRenderer<EntityRCBoss, EntityModel<EntityRCBoss>> layerrenderer = (LayerRenderer)var28.next();
                    layerrenderer.render(matrixStackIn, bufferIn, packedLightIn, entityIn, f5, f8, partialTicks, f7, f2, f6);
                }
            }

            RenderSystem.disableBlend();
            matrixStackIn.pop();
        } else {
            this.model.setRotationAngles(entityIn, f5, f8, f7, f2, f6);
        }

    }

    public ResourceLocation getEntityTexture(EntityRCBoss entity) {
        return TEXTURES;
    }
}
