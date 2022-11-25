package com.franz.resocraft.client.render;

import com.franz.resocraft.theultimatepun.pun.EntityObsidian;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IronGolemModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class RenderEntityObsidian extends MobRenderer<EntityObsidian, EntityModel<EntityObsidian>> {
    private static final ResourceLocation TEXTURES = new ResourceLocation("resocraft:textures/entity/obsidian.png");

    public RenderEntityObsidian(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new IronGolemModel(), 0.7F);
    }

    protected void applyRotations(EntityObsidian entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
        if ((double)entityLiving.limbSwingAmount >= 0.01) {
            float f3 = 13.0F;
            float f4 = entityLiving.limbSwing - entityLiving.limbSwingAmount * (1.0F - partialTicks) + 6.0F;
            float f5 = (Math.abs(f4 % 13.0F - 6.5F) - 3.25F) / 3.25F;
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(6.5F * f5));
        }

    }

    protected void preRenderCallback(EntityObsidian entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(2.0F, 2.0F, 2.0F);
    }

    public ResourceLocation getEntityTexture(EntityObsidian entity) {
        return TEXTURES;
    }
}
