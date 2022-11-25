package com.franz.resocraft.client.render;

import com.franz.resocraft.arsmagica2.entities.EntityThrownSickle;
import com.franz.resocraft.client.model.ModelNatureGuardianSickle;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class RenderEntityThrownSickle extends LivingRenderer<EntityThrownSickle, EntityModel<EntityThrownSickle>> {
    private static final ResourceLocation TEXTURES = new ResourceLocation("resocraft:textures/entity/nature_guardian.png");

    public RenderEntityThrownSickle(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelNatureGuardianSickle(), 0.5F);
    }

    public ResourceLocation getEntityTexture(EntityThrownSickle entity) {
        return TEXTURES;
    }

    protected boolean canRenderName(EntityThrownSickle entity) {
        return false;
    }
}
