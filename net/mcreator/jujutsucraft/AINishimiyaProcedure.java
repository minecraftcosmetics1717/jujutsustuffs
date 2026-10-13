package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.EntityBroomEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class AINishimiyaProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean weapon = false;
         boolean logicStart = false;
         double rnd = (double)0.0F;
         double distance = (double)0.0F;
         double tick = (double)0.0F;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity.m_20159_()) {
               AIActiveFlyingProcedure.execute(world, entity);
            }

            label140: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                     break label140;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), Integer.MAX_VALUE, 0, false, false));
                  }
               }
            }

            label135: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19600_)) {
                     break label135;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 5, false, false));
                  }
               }
            }

            label130: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.m_21023_(MobEffects.f_19606_)) {
                     break label130;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 1, false, false));
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > (double)10.0F) {
               if (!(entity.m_20202_() instanceof EntityBroomEntity)) {
                  ItemStack var30;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var30 = _livEnt.m_21205_();
                  } else {
                     var30 = ItemStack.f_41583_;
                  }

                  if (var30.m_41720_() == JujutsucraftModItems.BROOM.get()) {
                     entity.m_8127_();
                     SummonBroomProcedure.execute(world, x, y, z, entity);
                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s weapon.mainhand with air");
                     }
                  }
               }

               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               entity.getPersistentData().m_128347_("cnt_x2", (double)0.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)-10.0F);
                  ResetCounterProcedure.execute(entity);
                  distance = GetDistanceNearestEnemyProcedure.execute(world, entity);
                  logicStart = LogicStartProcedure.execute(entity);
                  if ((distance > (double)4.0F || Math.random() < 0.1) && logicStart) {
                     label150: {
                        if (!(entity.m_20202_() instanceof EntityBroomEntity)) {
                           ItemStack var31;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var31 = _livEnt.m_21205_();
                           } else {
                              var31 = ItemStack.f_41583_;
                           }

                           if (var31.m_41720_() != JujutsucraftModItems.BROOM.get()) {
                              break label150;
                           }
                        }

                        if (Math.random() < (double)0.5F) {
                           rnd = (double)3605.0F;
                           tick = (double)25.0F;
                        } else if (Math.random() < (double)0.5F) {
                           rnd = (double)3606.0F;
                           tick = (double)60.0F;
                        } else {
                           rnd = (double)3610.0F;
                           tick = (double)200.0F;
                        }
                     }
                  }

                  if (rnd > (double)0.0F) {
                     entity.getPersistentData().m_128347_("skill", (double)Math.round(rnd));
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
               if (entity.m_20202_() instanceof EntityBroomEntity) {
                  entity.getPersistentData().m_128347_("cnt_x2", entity.getPersistentData().m_128459_("cnt_x2") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("cnt_x2") > (double)200.0F) {
                     entity.getPersistentData().m_128347_("cnt_x2", (double)0.0F);
                     if (!entity.m_20202_().m_9236_().m_5776_()) {
                        entity.m_20202_().m_146870_();
                     }

                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s weapon.mainhand with jujutsucraft:broom");
                     }
                  }
               }
            }
         }

      }
   }
}
