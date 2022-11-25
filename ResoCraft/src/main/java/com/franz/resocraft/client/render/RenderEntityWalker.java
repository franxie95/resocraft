package com.franz.resocraft.client.render;

import com.franz.resocraft.client.model.ModelWalker;
import com.franz.resocraft.client.model.ModelWalkerFur;
import com.franz.resocraft.entity.EntityWalker;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class RenderEntityWalker extends MobRenderer<EntityWalker, EntityModel<EntityWalker>> {
    private static final ResourceLocation TEXTURES = new ResourceLocation("resocraaft:textures/entity/walker.png");

    public RenderEntityWalker(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelWalker(), 1.0F);
        this.addLayer(new LayerWalkerFur(this, new ModelWalkerFur()));
    }

    public ResourceLocation getEntityTexture(EntityWalker entity) {
        return TEXTURES;
    }
}
