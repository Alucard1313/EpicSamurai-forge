package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.EnenraEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EnenraModel extends GeoModel<EnenraEntity> {
    @Override
    public ResourceLocation getModelResource(EnenraEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/enenra.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EnenraEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/enenra.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EnenraEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/enenra.animation.json");
    }

    @Override
    public void setCustomAnimations(EnenraEntity animatable, long instanceId, AnimationState<EnenraEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}