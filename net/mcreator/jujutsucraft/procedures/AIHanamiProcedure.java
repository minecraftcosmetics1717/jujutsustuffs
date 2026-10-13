package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIHanamiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         boolean domain = false;
         if (entity.m_6084_()) {
            label124: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label124;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 14, false, false));
                  }
               }
            }

            label119: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label119;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 3, false, false));
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

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  ResetCounterProcedure.execute(entity);
                  rnd = (double)0.0F;
                  if ((!LogicStartProcedure.execute(entity) || !(Math.random() > (double)0.5F)) && !domain) {
                     CalculateAttackProcedure.execute(world, entity);
                  } else {
                     if (domain) {
                        tick = (double)20.0F;
                        rnd = (double)20.0F;
                     } else {
                        for(int index0 = 0; index0 < 512; ++index0) {
                           rnd = (double)(5L + Math.round(Math.random() * (double)15.0F));
                           if (rnd == (double)5.0F) {
                              tick = (double)60.0F;
                              break;
                           }

                           if (rnd == (double)6.0F) {
                              tick = (double)40.0F;
                              break;
                           }

                           if (rnd == (double)10.0F) {
                              tick = (double)250.0F;
                              if (!(entity.getPersistentData().m_128459_("cnt_target") < (double)600.0F) && !(Math.random() > 0.1)) {
                                 break;
                              }
                           } else if (rnd == (double)15.0F) {
                              tick = (double)0.0F;
                              double var25 = Math.random();
                              float var10002;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var10002 = _livEnt.m_21223_();
                              } else {
                                 var10002 = -1.0F;
                              }

                              var10002 = Math.max(var10002, 1.0F);
                              float var10003;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var10003 = _livEnt.m_21233_();
                              } else {
                                 var10003 = -1.0F;
                              }

                              if (!(var25 > (double)(1.0F - var10002 / Math.max(var10003, 1.0F))) && (world.m_8055_(BlockPos.m_274561_(x, y - (double)1.0F, z)).m_204336_(BlockTags.create(new ResourceLocation("minecraft:animals_spawnable_on"))) || world.m_8055_(BlockPos.m_274561_(x, y - (double)1.0F, z)).m_204336_(BlockTags.create(new ResourceLocation("minecraft:replaceable_plants"))))) {
                                 break;
                              }
                           } else if (rnd == (double)20.0F) {
                              tick = (double)20.0F;
                              if (!(Math.random() > 0.1) && !AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                 break;
                              }
                           }
                        }
                     }

                     entity.getPersistentData().m_128347_("skill", (double)1400.0F + rnd);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

      }
   }
}
