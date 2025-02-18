package net.veroxuniverse.epicsamurai.client;

import com.hollingsworth.arsnouveau.client.renderer.item.ArmorRenderer;
import com.hollingsworth.arsnouveau.client.renderer.tile.GenericModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.amethyst.AmethystSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.aquamarine.BlueSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.deeperdarker.SculkSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.diamond.DiamondSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.gold.GoldSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.iron.IronSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.jade.GreenSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.netherite.NetheriteSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.oni_mask.OniMaskArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.onyx.GraySamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.quartz.QuartzSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.ruby.RedSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.silver.WhiteSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.straw_hat.StrawHatArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.steel_armor.SteelArmorRenderer;
import net.veroxuniverse.epicsamurai.compat.ArsNouveauCompat;
import net.veroxuniverse.epicsamurai.compat.CreateCompat;
import net.veroxuniverse.epicsamurai.compat.DeeperDarkerCompat;
import net.veroxuniverse.epicsamurai.item.armor.*;
import net.veroxuniverse.epicsamurai.particle.BlueFlame;
import net.veroxuniverse.epicsamurai.registry.ItemsRegistry;
import net.veroxuniverse.epicsamurai.registry.ParticlesInit;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import static com.hollingsworth.arsnouveau.client.events.ClientHandler.colorFromArmor;

@Mod.EventBusSubscriber(modid = EpicSamuraiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EpicSamuraiClientMod {

    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event)
    {
        //Minecraft.getInstance().particleEngine.register(ParticlesInit.BLUE_FLAME.get(),BlueFlame.Provider::new);
        event.register(ParticlesInit.BLUE_FLAME.get(), BlueFlame.Provider::new);
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
    }

    @SubscribeEvent
    public static void initItemColors(final RegisterColorHandlersEvent.Item event) {

        if (ModList.get().isLoaded("ars_nouveau")){

            event.register((stack, color) -> color > 0 ? -1 :
                            colorFromArmor(stack),
                    ArsNouveauCompat.MAGE_SAMURAI_BOOTS.get());
            event.register((stack, color) -> color > 0 ? -1 :
                            colorFromArmor(stack),
                    ArsNouveauCompat.MAGE_SAMURAI_CHESTPLATE.get());
            event.register((stack, color) -> color > 0 ? -1 :
                            colorFromArmor(stack),
                    ArsNouveauCompat.MAGE_SAMURAI_HELMET.get());
            event.register((stack, color) -> color > 0 ? -1 :
                            colorFromArmor(stack),
                    ArsNouveauCompat.MAGE_SAMURAI_LEGGINGS.get());

        }

    }

    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(RedSamuraiArmorItem.class, RedSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(BlueSamuraiArmorItem.class, BlueSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(GreenSamuraiArmorItem.class, GreenSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(GraySamuraiArmorItem.class, GraySamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(WhiteSamuraiArmorItem.class, WhiteSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(IronSamuraiArmorItem.class, IronSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(GoldSamuraiArmorItem.class, GoldSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(DiamondSamuraiArmorItem.class, DiamondSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(NetheriteSamuraiArmorItem.class, NetheriteSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(StrawHatArmorItem.class, StrawHatArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(OniMaskArmorItem.class, OniMaskArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(SteelArmorItem.class, SteelArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(AmethystSamuraiArmorItem.class, AmethystSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(QuartzSamuraiArmorItem.class, QuartzSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(SculkSamuraiArmorItem.class, SculkSamuraiArmorRenderer::new);
        if (ModList.get().isLoaded("ars_nouveau")){
            ArsNouveauCompat.registerArmorRenderer();
        }
        if (ModList.get().isLoaded("deeperdarker")) {
            DeeperDarkerCompat.registerArmorRenderer();
        }
        if (ModList.get().isLoaded("create")) {
            CreateCompat.registerArmorRenderer();
        }
    }
}

