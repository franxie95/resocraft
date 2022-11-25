package com.franz.resocraft.client.render;

import com.franz.resocraft.client.model.ModelSkultar;
import com.franz.resocraft.tragicmc2.entity.boss.EntitySkultar;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class RenderEntitySkultar extends MobRenderer<EntitySkultar, EntityModel<EntitySkultar>> {
    private static final ResourceLocation TEXTURES = new ResourceLocation("resocraft:textures/entity/skultar.png");
    private static final ResourceLocation TEXTURE_AGGRESSIVE = new ResourceLocation("resocraft:textures/entity/skultar_aggressive.png");

    public RenderEntitySkultar(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelSkultar(), 0.475F);
    }

    public ResourceLocation getEntityTexture(EntitySkultar entity) {
        return entity.isBeingAggressive() ? TEXTURE_AGGRESSIVE : TEXTURES;
    }
}
