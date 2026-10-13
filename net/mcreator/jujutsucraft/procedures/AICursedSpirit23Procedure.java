package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.BathynomusGiganteusEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AICursedSpirit23Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         Entity entity_a = null;
         if (entity.m_6084_() && entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof BathynomusGiganteusEntity) {
               label151: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt5 = (LivingEntity)entity;
                     if (_livEnt5.m_21023_(MobEffects.f_19600_)) {
                        break label151;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 6, false, false));
                     }
                  }
               }

               label146: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt7 = (LivingEntity)entity;
                     if (_livEnt7.m_21023_(MobEffects.f_19606_)) {
                        break label146;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 2, false, false));
                     }
                  }
               }

               label141: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt9 = (LivingEntity)entity;
                     if (_livEnt9.m_21023_(MobEffects.f_19593_)) {
                        break label141;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19593_, Integer.MAX_VALUE, 4, false, false));
                     }
                  }
               }

               label136: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt11 = (LivingEntity)entity;
                     if (_livEnt11.m_21023_(MobEffects.f_19608_)) {
                        break label136;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19608_, Integer.MAX_VALUE, 0, false, false));
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
                  if (LogicOwnerExistProcedure.execute(world, entity)) {
                     label174: {
                        entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                        if (entity_a.m_6084_()) {
                           label171: {
                              if (entity_a instanceof LivingEntity) {
                                 LivingEntity _livEnt17 = (LivingEntity)entity_a;
                                 if (_livEnt17.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                    break label171;
                                 }
                              }

                              if (entity.getPersistentData().m_128459_("friend_num") != entity_a.getPersistentData().m_128459_("friend_num") && !entity.m_9236_().m_5776_()) {
                                 entity.m_146870_();
                              }
                              break label174;
                           }
                        }

                        if (!entity.m_9236_().m_5776_()) {
                           entity.m_146870_();
                        }
                     }
                  } else if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               }

               entity.getPersistentData().m_128347_("cnt_settarget", entity.getPersistentData().m_128459_("cnt_settarget") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_settarget") > (double)10.0F) {
                  entity.getPersistentData().m_128347_("cnt_settarget", (double)-20.0F);
                  SetTargetProcedure.execute(world, x, y, z, entity);
               }
            } else {
               label172: {
                  label157: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt27 = (LivingEntity)entity;
                        if (_livEnt27.m_21023_(MobEffects.f_19600_)) {
                           break label157;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 7, false, false));
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt29 = (LivingEntity)entity;
                     if (_livEnt29.m_21023_(MobEffects.f_19606_)) {
                        break label172;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 1, false, false));
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)1.0F) {
               AttackBiteProcedure.execute(world, x, y, z, entity);
            } else if (entity.getPersistentData().m_128459_("skill") == (double)2.0F) {
               AttackGroundBiteProcedure.execute(world, x, y, z, entity);
            } else {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                     ResetCounterProcedure.execute(entity);
                     if (!LogicCooldownCombatProcedure.execute(entity) && Math.random() < (double)0.25F) {
                        if (!(Math.random() < (double)0.5F) && !(entity instanceof BathynomusGiganteusEntity)) {
                           entity.getPersistentData().m_128347_("skill", (double)2.0F);
                        } else {
                           entity.getPersistentData().m_128347_("skill", (double)1.0F);
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50, 0, false, false));
                           }
                        }
                     } else {
                        CalculateAttackProcedure.execute(world, entity);
                     }
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
               }
            }
         }

      }
   }
}
