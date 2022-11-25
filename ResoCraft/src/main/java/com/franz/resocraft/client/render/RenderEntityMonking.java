package com.franz.resocraft.client.render;

import com.franz.resocraft.client.model.BipedModelMonking;
import com.franz.resocraft.client.model.ModelMonking;
import com.franz.resocraft.entity.EntityMonking;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class RenderEntityMonking extends BipedRendererMonking<EntityMonking, BipedModelMonking<EntityMonking>> {
    private static final ResourceLocation TEXTURES = new ResourceLocation("resocraft:textures/entity/monking.png");

    public RenderEntityMonking(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelMonking(), 1.0F);
    }

    protected void preRenderCallback(EntityMonking entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
        float scale = entitylivingbaseIn.getScaleSize() * 0.76F;
        matrixStackIn.scale(scale, scale, scale);
        matrixStackIn.translate(0.0, 0.0, -0.10000000149011612);
    }

    public ResourceLocation getEntityTexture(EntityMonking entity) {
        return TEXTURES;
    }
}
