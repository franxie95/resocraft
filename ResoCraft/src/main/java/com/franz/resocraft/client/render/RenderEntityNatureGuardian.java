package com.franz.resocraft.client.render;

import com.franz.resocraft.arsmagica2.bosses.EntityNatureGuardian;
import com.franz.resocraft.client.model.ModelNatureGuardian;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class RenderEntityNatureGuardian extends MobRenderer<EntityNatureGuardian, EntityModel<EntityNatureGuardian>> {
    private static final ResourceLocation TEXTURES = new ResourceLocation("resocraft:textures/entity/nature_guardian.png");

    public RenderEntityNatureGuardian(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelNatureGuardian(), 1.0F);
    }

    public ResourceLocation getEntityTexture(EntityNatureGuardian entity) {
        return TEXTURES;
    }
}
