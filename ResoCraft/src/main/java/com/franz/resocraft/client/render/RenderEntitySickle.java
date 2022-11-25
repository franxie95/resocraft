package com.franz.resocraft.client.render;

import com.franz.resocraft.antiplantvirus.entity.EntitySickle;
import com.franz.resocraft.client.model.ModelSickle;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;

public class RenderEntitySickle extends EntityRenderer<EntitySickle> {
    ModelSickle model = new ModelSickle();
    private static final ResourceLocation TEXTURES = new ResourceLocation("resocraft:textures/entity/sickle.png");

    public RenderEntitySickle(EntityRendererManager renderManager) {
        super(renderManager);
    }

    private float func_82400_a(float par1, float par2, float par3) {
        float var4;
        for(var4 = par1 - par2; var4 > 180.0F; var4 -= 360.0F) {
        }

        while(var4 <= 180.0F) {
            var4 += 360.0F;
        }

        return par1 + par3 * var4;
    }

    public void render(EntitySickle entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.model.getRenderType(TEXTURES));
        matrixStackIn.translate(0.0, 0.0, 0.0);
        matrixStackIn.scale(2.0F, 1.0F, 2.0F);
        float var10 = this.func_82400_a(entityIn.prevRotationYaw, entityIn.rotationYaw, partialTicks);
        float var11 = entityIn.prevRotationPitch + (entityIn.rotationPitch - entityIn.prevRotationPitch) * partialTicks;
        this.model.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        this.model.setRotationAngles(entityIn, 0.0F, 0.0F, 0.0F, var10, var11);
        matrixStackIn.pop();
    }

    public ResourceLocation getEntityTexture(EntitySickle entity) {
        return TEXTURES;
    }
}
