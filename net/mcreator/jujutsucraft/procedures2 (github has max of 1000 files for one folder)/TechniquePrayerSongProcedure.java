package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class TechniquePrayerSongProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double power = (double)0.0F;
         String STR1 = "";
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 20, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               MobEffectInstance var10001;
               MobEffect var10003;
               int var10005;
               label22: {
                  var10001 = new MobEffectInstance;
                  var10003 = (MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label22;
                     }
                  }

                  var10005 = 0;
               }

               var10001.<init>(var10003, 3600, var10005, true, true);
               _entity.m_7292_(var10001);
            }
         }

         boolean _setval = true;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.noChangeTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         entity.getPersistentData().m_128347_("skill", (double)0.0F);
      }
   }
}
