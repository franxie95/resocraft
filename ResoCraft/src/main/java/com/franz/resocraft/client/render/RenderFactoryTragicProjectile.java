package com.franz.resocraft.client.render;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFactoryTragicProjectile implements IRenderFactory<Entity> {
    public final Item item;
    public final float scale;

    public RenderFactoryTragicProjectile(Item item, float scale) {
        this.item = item;
        this.scale = scale;
    }

    public EntityRenderer<Entity> createRenderFor(EntityRendererManager manager) {
        return new RenderTragicProjectile(manager, this.item, this.scale);
    }
}
