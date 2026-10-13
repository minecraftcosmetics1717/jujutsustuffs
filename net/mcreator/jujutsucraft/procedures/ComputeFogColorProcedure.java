package net.mcreator.jujutsucraft.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class ComputeFogColorProcedure {
   public static ViewportEvent.ComputeFogColor provider = null;

   public static void setColor(int color) {
      provider.setRed((float)(color >> 16 & 255) / 255.0F);
      provider.setGreen((float)(color >> 8 & 255) / 255.0F);
      provider.setBlue((float)(color & 255) / 255.0F);
   }

   public static void setColor(float level, int color) {
      if (!(level <= 0.0F)) {
         if (level >= 1.0F) {
            provider.setRed((float)(color >> 16 & 255) / 255.0F);
            provider.setGreen((float)(color >> 8 & 255) / 255.0F);
            provider.setBlue((float)(color & 255) / 255.0F);
         } else {
            level = Mth.m_14036_(level, 0.0F, 1.0F);
            provider.setRed(Mth.m_14036_(Mth.m_14179_(level, Mth.m_14036_(provider.getRed(), 0.0F, 1.0F), (float)(color >> 16 & 255) / 255.0F), 0.0F, 1.0F));
            provider.setGreen(Mth.m_14036_(Mth.m_14179_(level, Mth.m_14036_(provider.getGreen(), 0.0F, 1.0F), (float)(color >> 8 & 255) / 255.0F), 0.0F, 1.0F));
            provider.setBlue(Mth.m_14036_(Mth.m_14179_(level, Mth.m_14036_(provider.getBlue(), 0.0F, 1.0F), (float)(color & 255) / 255.0F), 0.0F, 1.0F));
         }

      }
   }

   @SubscribeEvent
   public static void computeFogColor(ViewportEvent.ComputeFogColor event) {
      provider = event;
      ClientLevel level = Minecraft.m_91087_().f_91073_;
      Entity entity = provider.getCamera().m_90592_();
      if (level != null && entity != null) {
         Vec3 entPos = entity.m_20318_((float)provider.getPartialTick());
         execute(provider, entity);
      }

   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         double var9;
         label74: {
            double color = (double)0.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt0 = (LivingEntity)entity;
               if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var9 = entity.getPersistentData().m_128459_("skill_domain") + (double)10.0F;
                  break label74;
               }
            }

            label65: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COLOR.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COLOR.get()).m_19564_();
                     break label65;
                  }
               }

               var10000 = 0;
            }

            var9 = (double)(var10000 + 10);
         }

         double var6 = var9;
         if (var6 <= (double)10.0F) {
            label58: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     var9 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                     break label58;
                  }
               }

               var9 = (double)0.0F;
            }

            var6 = var9;
         }

         if (var6 > (double)10.0F) {
            var6 -= (double)10.0F;
            if (var6 != (double)1.0F && var6 != (double)18.0F) {
               if (var6 != (double)4.0F && var6 != (double)26.0F && var6 != (double)43.0F) {
                  if (var6 != (double)6.0F && var6 != (double)11.0F && var6 != (double)23.0F && var6 != (double)25.0F) {
                     if (var6 == (double)24.0F) {
                        setColor(-3618561);
                     }
                  } else {
                     setColor(-16777216);
                  }
               } else {
                  setColor(-14155776);
               }
            } else {
               setColor(-11534336);
            }
         }

      }
   }
}
