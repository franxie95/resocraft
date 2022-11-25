package com.franz.resocraft.client.render;

import com.franz.resocraft.tragicmc2.entity.boss.EntityRCBoss;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class RenderEntityTragicBoss extends MobRenderer<EntityRCBoss, EntityModel<EntityRCBoss>> {
    protected float scale;

    public RenderEntityTragicBoss(EntityRendererManager renderManagerIn, EntityModel<EntityRCBoss> entityModelIn, float shadowSize, float scale) {
        super(renderManagerIn, entityModelIn, shadowSize);
        this.scale = scale;
    }

    public RenderEntityTragicBoss(EntityRendererManager renderManagerIn, EntityModel<EntityRCBoss> entityModelIn, float shadowSizeIn) {
        this(renderManagerIn, entityModelIn, shadowSizeIn, 1.0F);
    }

    protected void preRenderCallback(EntityRCBoss entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
        matrixStackIn.scale(this.scale, this.scale, this.scale);
    }

    public void render(EntityRCBoss entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public ResourceLocation getEntityTexture(EntityRCBoss entity) {
        return null;
    }
}
