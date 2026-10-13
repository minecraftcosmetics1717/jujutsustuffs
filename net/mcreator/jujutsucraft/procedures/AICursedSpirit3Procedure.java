package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade312Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade313Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade314Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade315Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade317Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade318Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade319Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade31Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade320Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade322Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade323Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade33Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade34Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade35Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade36Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade37Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade39Entity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AICursedSpirit3Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double speed = (double)0.0F;
         double lv_df = (double)0.0F;
         double lv_st = (double)0.0F;
         Entity owner_uuid = null;
         if (entity instanceof CursedSpiritGrade39Entity && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123746_, x, y + (double)entity.m_20206_() * (double)0.5F, z, (int)((double)1.0F * ReturnEntitySizeProcedure.execute(entity)), (double)entity.m_20205_() * (double)0.25F, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.25F, 0.1);
         }

         if (entity.m_6084_()) {
            label178: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
                     break label178;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), Integer.MAX_VALUE, 9, false, false));
                  }
               }
            }

            label173: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     break label173;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_(MobEffects.f_19597_);
               }
            }

            label187: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt11 = (LivingEntity)entity;
                  if (_livEnt11.m_21023_(MobEffects.f_19600_)) {
                     break label187;
                  }
               }

               if (entity instanceof CursedSpiritGrade312Entity) {
                  lv_st = (double)4.0F;
               } else if (!(entity instanceof CursedSpiritGrade35Entity) && !(entity instanceof CursedSpiritGrade36Entity) && !(entity instanceof CursedSpiritGrade313Entity)) {
                  if (!(entity instanceof CursedSpiritGrade31Entity) && !(entity instanceof CursedSpiritGrade34Entity) && !(entity instanceof CursedSpiritGrade314Entity) && !(entity instanceof CursedSpiritGrade318Entity) && !(entity instanceof CursedSpiritGrade319Entity) && !(entity instanceof CursedSpiritGrade320Entity) && !(entity instanceof CursedSpiritGrade322Entity) && !(entity instanceof CursedSpiritGrade323Entity)) {
                     if (!(entity instanceof CursedSpiritGrade33Entity) && !(entity instanceof CursedSpiritGrade37Entity) && !(entity instanceof CursedSpiritGrade317Entity)) {
                        lv_st = (double)2.0F;
                     } else {
                        lv_st = (double)0.0F;
                     }
                  } else {
                     lv_st = (double)1.0F;
                  }
               } else {
                  lv_st = (double)3.0F;
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)lv_st, false, false));
                  }
               }
            }

            label141: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt28 = (LivingEntity)entity;
                  if (_livEnt28.m_21023_(MobEffects.f_19606_)) {
                     break label141;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 0, false, false));
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)1.0F) {
               AttackJumpProcedure.execute(world, x, y, z, entity);
            } else {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (!(var10000 instanceof LivingEntity)) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
               } else {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                  if (entity instanceof CursedSpiritGrade312Entity && entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                     label129: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt38 = (LivingEntity)entity;
                           if (_livEnt38.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              break label129;
                           }
                        }

                        entity.getPersistentData().m_128347_("cnt_x", (double)-40.0F - Math.random() * (double)40.0F);
                        ResetCounterProcedure.execute(entity);
                        entity.getPersistentData().m_128347_("skill", (double)1.0F);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                           }
                        }
                     }
                  }

                  if (entity instanceof CursedSpiritGrade39Entity && entity.getPersistentData().m_128471_("Shikigami") && entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                     ResetCounterProcedure.execute(entity);
                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("friend_num_worker") != (double)0.0F && (entity instanceof CursedSpiritGrade36Entity || entity instanceof CursedSpiritGrade315Entity)) {
               AICursedSpiritsFlyingAttackProcedure.execute(world, x, y, z, entity);
            }
         }

         if (entity.getPersistentData().m_128471_("Shikigami")) {
            owner_uuid = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (owner_uuid instanceof LivingEntity) {
               if (!owner_uuid.m_6084_() && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
            }
         }

      }
   }
}
