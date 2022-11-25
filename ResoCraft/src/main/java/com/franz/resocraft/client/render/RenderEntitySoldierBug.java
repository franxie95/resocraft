package com.franz.resocraft.client.render;

import com.franz.resocraft.antiplantvirus.entity.living.EntitySoldierBug;
import com.franz.resocraft.client.model.ModelSoldierBug;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class RenderEntitySoldierBug extends MobRenderer<EntitySoldierBug, EntityModel<EntitySoldierBug>> {
    private ModelSoldierBug model;
    private static final ResourceLocation TEXTURES = new ResourceLocation("resocraft:textures/entity/soldier_bug.png");

    public RenderEntitySoldierBug(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelSoldierBug(), 1.0F);
        this.model = (ModelSoldierBug)this.entityModel;
        this.addLayer(new LayerSoldierBugArmor(this, new ModelSoldierBug()));
    }

    public void render(EntitySoldierBug entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        if (entityIn.isOnGround() && !entityIn.getwind()) {
            this.model.wing = false;
        } else {
            this.model.wing = true;
        }

    }

    protected void preRenderCallback(EntitySoldierBug entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }

    public ResourceLocation getEntityTexture(EntitySoldierBug entity) {
        return TEXTURES;
    }
}
