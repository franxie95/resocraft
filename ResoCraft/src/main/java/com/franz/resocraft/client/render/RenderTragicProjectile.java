package com.franz.resocraft.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;

public class RenderTragicProjectile extends EntityRenderer<Entity> {
    public final Item item;
    public final float scale;

    public RenderTragicProjectile(EntityRendererManager renderManager, Item item, float scale) {
        super(renderManager);
        this.item = item;
        this.scale = scale;
    }

    public void render(Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.scale(this.scale, this.scale, this.scale);
        matrixStackIn.rotate(this.renderManager.getCameraOrientation());
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F));
        TextureAtlasSprite textureatlassprite = Minecraft.getInstance().getItemRenderer().getItemModelMesher().getParticleIcon(new ItemStack(this.item));
        RenderType rendertype = RenderTypeLookup.func_239219_a_(new ItemStack(this.item), true);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(rendertype);
        MatrixStack.Entry matrixstack$entry = matrixStackIn.getLast();
        Matrix4f matrix4f = matrixstack$entry.getMatrix();
        Matrix3f matrix3f = matrixstack$entry.getNormal();
        float f = textureatlassprite.getMinU();
        float f1 = textureatlassprite.getMaxU();
        float f2 = textureatlassprite.getMinV();
        float f3 = textureatlassprite.getMaxV();
        vertex(ivertexbuilder, matrix4f, matrix3f, -0.5F, -0.25F, 0.0F, f, f3, packedLightIn);
        vertex(ivertexbuilder, matrix4f, matrix3f, 0.5F, -0.25F, 0.0F, f1, f3, packedLightIn);
        vertex(ivertexbuilder, matrix4f, matrix3f, 0.5F, 0.75F, 0.0F, f1, f2, packedLightIn);
        vertex(ivertexbuilder, matrix4f, matrix3f, -0.5F, 0.75F, 0.0F, f, f2, packedLightIn);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    private static void vertex(IVertexBuilder bufferIn, Matrix4f matrixIn, Matrix3f matrixNormalIn, float x, float y, float z, float texU, float texV, int packedLightIn) {
        bufferIn.pos(matrixIn, x, y, z).color(1.0F, 1.0F, 1.0F, 1.0F).tex(texU, texV).overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLightIn).normal(matrixNormalIn, 0.0F, 1.0F, 0.0F).endVertex();
    }

    public ResourceLocation getEntityTexture(Entity entity) {
        return PlayerContainer.LOCATION_BLOCKS_TEXTURE;
    }
}
