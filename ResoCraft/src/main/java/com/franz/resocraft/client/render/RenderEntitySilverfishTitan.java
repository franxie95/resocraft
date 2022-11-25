package com.franz.resocraft.client.render;

import com.franz.resocraft.client.model.ModelOmegafish;
import com.franz.resocraft.entity.EntitySilverfishTitan;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class RenderEntitySilverfishTitan extends LivingRenderer<EntitySilverfishTitan, EntityModel<EntitySilverfishTitan>> {
    private static final ResourceLocation TEXTURES = new ResourceLocation("resocraft", "textures/entity/omegafish.png");

    public RenderEntitySilverfishTitan(EntityRendererManager rendererManager) {
        super(rendererManager, new ModelOmegafish(), 0.3F);
    }

    public ResourceLocation getEntityTexture(EntitySilverfishTitan entity) {
        return TEXTURES;
    }

    protected float getDeathMaxRotation(EntitySilverfishTitan entityLivingBaseIn) {
        return this.func_180584_a(entityLivingBaseIn);
    }

    protected float func_180584_a(EntitySilverfishTitan p_180584_1_) {
        return 180.0F;
    }

    protected void preRenderCallback(EntitySilverfishTitan entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        this.func_180592_a(matrixStackIn, entitylivingbaseIn, partialTickTime);
    }

    protected void func_180592_a(MatrixStack stack, EntitySilverfishTitan p_180592_1_, float p_180592_2_) {
        int i = p_180592_1_.getInvulTime();
        float f1 = 16.0F;
        if (i > 0) {
            f1 -= ((float)i - p_180592_2_) / 440.0F * 7.75F;
        }

        int i2 = p_180592_1_.getExtraPower();
        if (i2 > 0) {
            f1 += (float)i2 * 0.5F;
        }

        if (p_180592_1_.isBurrowing) {
            stack.translate(0.0, 8.0, 0.0);
        }

        stack.scale(f1, f1, f1);
        stack.translate(0.0, 0.009999999776482582, 0.0);
    }
}
