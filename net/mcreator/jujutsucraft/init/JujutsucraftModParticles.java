package net.mcreator.jujutsucraft.init;

import net.mcreator.jujutsucraft.client.particle.ParticleBigSmokeParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleBlackFlash1Particle;
import net.mcreator.jujutsucraft.client.particle.ParticleBlood2Particle;
import net.mcreator.jujutsucraft.client.particle.ParticleBloodPurpleParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleBloodRedParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleBlueParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleBrokenGlassParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleBrokenGlassSmallParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleClawsParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleCockroachParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleCursePowerBlueParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleCursePowerGreenParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleCursePowerOrangeParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleCursePowerPurpleParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleCursePowerRedParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleCursePowerWhiteParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleDismantleItadoriParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleFangsParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleFireSparkParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleFlameParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleFlamePurpleParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleFlowerParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleGravityParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleHollowWickerBasketParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleIceParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleLiquidMetalParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleMagmaParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleNanami1Particle;
import net.mcreator.jujutsucraft.client.particle.ParticleNanami2Particle;
import net.mcreator.jujutsucraft.client.particle.ParticleRedParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleShockHitParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleSlashLargeParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleSlashParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleThunderBlueMiniParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleThunderBlueParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleThunderPurpleParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleUnlimitedVoidHoleParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleUnlimitedVoidParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleWater2Particle;
import net.mcreator.jujutsucraft.client.particle.ParticleWaterNoGravityParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleWaterParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleWhiteParticle;
import net.mcreator.jujutsucraft.client.particle.ParticleWiFiParticle;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class JujutsucraftModParticles {
   @SubscribeEvent
   public static void registerParticles(RegisterParticleProvidersEvent event) {
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), ParticleCursePowerBlueParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), ParticleCursePowerOrangeParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_RED.get(), ParticleCursePowerRedParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), ParticleBloodRedParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_PURPLE.get(), ParticleBloodPurpleParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_SHOCK_HIT.get(), ParticleShockHitParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), ParticleWaterParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), ParticleBlackFlash1Particle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_FIRE_SPARK.get(), ParticleFireSparkParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_FANGS.get(), ParticleFangsParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_CLAWS.get(), ParticleClawsParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), ParticleThunderBlueParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS.get(), ParticleBrokenGlassParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER_2.get(), ParticleWater2Particle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_NANAMI_1.get(), ParticleNanami1Particle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_NANAMI_2.get(), ParticleNanami2Particle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), ParticleBrokenGlassSmallParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_WI_FI.get(), ParticleWiFiParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), ParticleMagmaParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_FLOWER.get(), ParticleFlowerParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_FLAME.get(), ParticleFlameParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), ParticleBigSmokeParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_COCKROACH.get(), ParticleCockroachParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), ParticleIceParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_HOLLOW_WICKER_BASKET.get(), ParticleHollowWickerBasketParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_2.get(), ParticleBlood2Particle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_SLASH.get(), ParticleSlashParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_UNLIMITED_VOID.get(), ParticleUnlimitedVoidParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_UNLIMITED_VOID_HOLE.get(), ParticleUnlimitedVoidHoleParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), ParticleCursePowerGreenParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), ParticleThunderBlueMiniParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_LIQUID_METAL.get(), ParticleLiquidMetalParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER_NO_GRAVITY.get(), ParticleWaterNoGravityParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_GRAVITY.get(), ParticleGravityParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_DISMANTLE_ITADORI.get(), ParticleDismantleItadoriParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_PURPLE.get(), ParticleCursePowerPurpleParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_RED.get(), ParticleRedParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_BLUE.get(), ParticleBlueParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_FLAME_PURPLE.get(), ParticleFlamePurpleParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_SLASH_LARGE.get(), ParticleSlashLargeParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_WHITE.get(), ParticleCursePowerWhiteParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_PURPLE.get(), ParticleThunderPurpleParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftModParticleTypes.PARTICLE_WHITE.get(), ParticleWhiteParticle::provider);
   }
}
