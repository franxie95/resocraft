package com.franz.resocraft.client.render;

import com.franz.resocraft.entity.EntityMagicCircle;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

public class RenderEntityMagicCircle extends EntityRenderer<EntityMagicCircle> {
    private static final ResourceLocation TEXTURES = new ResourceLocation("resocraft:textures/effects/magic_circle.png");
    protected float[] colorR = new float[]{255.0F, 255.0F, 255.0F, 0.0F, 0.0F, 0.0F, 255.0F};
    protected float[] colorG = new float[]{0.0F, 165.0F, 255.0F, 255.0F, 0.0F, 255.0F, 0.0F};
    protected float[] colorB = new float[]{0.0F, 0.0F, 0.0F, 0.0F, 255.0F, 255.0F, 255.0F};

    public RenderEntityMagicCircle(EntityRendererManager renderManager) {
        super(renderManager);
    }

    public void render(EntityMagicCircle circle, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        float size = circle.getCircleSize() * 6.0F;
        matrixStackIn.scale(size, -1.0F, size);
        float umin = 0.0F;
        float umax = 1.0F;
        float vmin = 0.0F;
        float vmax = 1.0F;
        int color = circle.getCircleType();
        matrixStackIn.translate(0.0, -0.5, 0.0);
        if (color >= 16) {
            float angle = MathHelper.sin(2.0F * (float)circle.getAnimationCount() / 180.0F * 3.1415927F) * 40.0F;
            Quaternion quat = this.renderManager.getCameraOrientation();
            matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F - quat.getY() + angle));
            matrixStackIn.rotate(Vector3f.XP.rotationDegrees(-quat.getX() - angle));
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees((float)circle.getAnimationCount() * 5.0F));
            color %= 16;
        } else {
            matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90.0F));
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees((float)circle.getAnimationCount() * 5.0F));
        }

        if (color != 9) {
            color %= 8;
        }

        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RCRenderType.getGlowingEffect(TEXTURES));
        MatrixStack.Entry matrixstack$entry = matrixStackIn.getLast();
        Matrix4f matrix4f = matrixstack$entry.getMatrix();
        Matrix3f matrix3f = matrixstack$entry.getNormal();
        vertex(ivertexbuilder, matrix4f, matrix3f, -0.6F, -0.6F, 0.0F, umin, vmax, packedLightIn);
        vertex(ivertexbuilder, matrix4f, matrix3f, 0.6F, -0.6F, 0.0F, umax, vmax, packedLightIn);
        vertex(ivertexbuilder, matrix4f, matrix3f, 0.6F, 0.6F, 0.0F, umax, vmin, packedLightIn);
        vertex(ivertexbuilder, matrix4f, matrix3f, -0.6F, 0.6F, 0.0F, umin, vmin, packedLightIn);
        matrixStackIn.pop();
    }

    private static void vertex(IVertexBuilder bufferIn, Matrix4f matrixIn, Matrix3f matrixNormalIn, float x, float y, float z, float texU, float texV, int packedLightIn) {
        bufferIn.pos(matrixIn, x, y, z).color(255.0F, 1.0F, 1.0F, 0.5F).tex(texU, texV).overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLightIn).normal(matrixNormalIn, 0.0F, 1.0F, 0.0F).endVertex();
    }

    public ResourceLocation getEntityTexture(EntityMagicCircle entity) {
        return TEXTURES;
    }
}
