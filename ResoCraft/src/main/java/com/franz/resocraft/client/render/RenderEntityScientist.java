package com.franz.resocraft.client.render;

import com.franz.resocraft.client.model.ModelScientist;
import com.franz.resocraft.entity.EntityScientist;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class RenderEntityScientist extends MobRenderer<EntityScientist, EntityModel<EntityScientist>> {
    public RenderEntityScientist(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelScientist(), 0.0F);
        this.addLayer(new LayerScientistSaw(this, new ModelScientist()));
    }

    public ResourceLocation getEntityTexture(EntityScientist entity) {
        return EntityScientist.TEXTURES != null ? EntityScientist.TEXTURES : null;
    }
}
