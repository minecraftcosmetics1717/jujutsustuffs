package net.mcreator.jujutsucraft.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.common.ForgeMod;

public class GetPowerFixProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         double playerLevel = (double)0.0F;
         double fix = (double)0.0F;
         boolean logic_fix = false;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.m_21023_(MobEffects.f_19600_)) {
               int var10000;
               label65: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label65;
                     }
                  }

                  var10000 = 0;
               }

               playerLevel = (double)Math.min(var10000 + 1, 15);
            }
         }

         fix = (double)0.75F + playerLevel / (double)30.0F;
         if (entity.m_20072_() && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:swim_attackable")))) {
            double var14;
            double var10001;
            label57: {
               var14 = fix * (double)0.5F;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity4 = (LivingEntity)entity;
                  if (_livingEntity4.m_21204_().m_22171_((Attribute)ForgeMod.SWIM_SPEED.get())) {
                     label53: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity5 = (LivingEntity)entity;
                           if (_livingEntity5.m_21204_().m_22171_((Attribute)ForgeMod.SWIM_SPEED.get())) {
                              var10001 = _livingEntity5.m_21051_((Attribute)ForgeMod.SWIM_SPEED.get()).m_22135_();
                              break label53;
                           }
                        }

                        var10001 = (double)0.0F;
                     }

                     var10001 = Math.min(var10001, (double)2.0F);
                     break label57;
                  }
               }

               var10001 = (double)1.0F;
            }

            fix = var14 * var10001;
         }

         entity.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") * fix);
         entity.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") * fix);
         entity.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") * fix);
         if (entity.getPersistentData().m_128471_("canFly")) {
            entity.getPersistentData().m_128379_("canFly", false);
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt14 = (LivingEntity)entity;
               if (_livEnt14.m_21023_(MobEffects.f_19597_)) {
                  int var10002;
                  label43: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19597_)) {
                           var10002 = _livEnt.m_21124_(MobEffects.f_19597_).m_19564_();
                           break label43;
                        }
                     }

                     var10002 = 0;
                  }

                  fix = Math.max((double)1.0F - 0.15 * (double)(var10002 + 1), (double)0.0F);
                  entity.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") * fix);
                  entity.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") * fix);
                  entity.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") * fix);
               }
            }

            entity.getPersistentData().m_128347_("y_power", Math.min(entity.getPersistentData().m_128459_("y_power"), (double)1.5F));
         }

      }
   }
}
