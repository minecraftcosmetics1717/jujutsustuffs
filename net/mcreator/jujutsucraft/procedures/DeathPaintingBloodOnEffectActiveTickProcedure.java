package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.ItadoriYujiEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShibuyaEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShinjukuEntity;
import net.mcreator.jujutsucraft.entity.KenjakuEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class DeathPaintingBloodOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean damage = false;
         double playerTechnique1 = (double)0.0F;
         double playerTechnique2 = (double)0.0F;
         double tick = (double)0.0F;
         double level = (double)0.0F;
         if (entity.m_6084_()) {
            double var10000;
            label180: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                     var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).m_19564_();
                     break label180;
                  }
               }

               var10000 = (double)0.0F;
            }

            label175: {
               level = var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                     var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).m_19557_();
                     break label175;
                  }
               }

               var10000 = (double)0.0F;
            }

            tick = var10000;
            damage = true;
            if (!(entity instanceof Player)) {
               if (entity instanceof KenjakuEntity || entity instanceof ItadoriYujiEntity || entity instanceof ItadoriYujiShibuyaEntity || entity instanceof ItadoriYujiShinjukuEntity) {
                  damage = false;
               }
            } else {
               JujutsucraftModVariables.PlayerVariables cap = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
               playerTechnique1 = cap.PlayerCurseTechnique;
               playerTechnique2 = cap.PlayerCurseTechnique2;
               if (playerTechnique1 == (double)10.0F || playerTechnique2 == (double)10.0F || playerTechnique1 == (double)21.0F || playerTechnique2 == (double)21.0F) {
                  damage = false;
               }

               if (cap.PlayerCursePowerFormer == (double)0.0F) {
                  damage = false;
               }
            }

            if (damage) {
               if (ReturnInsideItemProcedure.execute(entity).m_41720_() == JujutsucraftModItems.DEATH_PAINTING.get()) {
                  damage = false;
               }

               if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting"))) || entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
                  damage = false;
               }

               if (entity.getPersistentData().m_128471_("CursedSpirit")) {
                  damage = false;
               }
            }

            if (damage) {
               if (tick % (double)200.0F == (double)0.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 80, 0, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 1, false, false));
                     }
                  }

                  entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat")))), (float)((double)6.0F * ((double)1.0F + level)));
               }
            } else if (level == (double)0.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get());
               }
            } else {
               if (playerTechnique1 == (double)10.0F || playerTechnique2 == (double)10.0F || entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting")))) {
                  label140: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                           var32 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).m_19564_();
                           break label140;
                        }
                     }

                     var32 = 0;
                  }

                  int var10001;
                  label135: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label135;
                        }
                     }

                     var10001 = 0;
                  }

                  if (var32 < var10001 + 1) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get());
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffect var10003;
                           int var10004;
                           int var10005;
                           label125: {
                              var33 = new MobEffectInstance;
                              var10003 = (MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get();
                              var10004 = (int)tick;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label125;
                                 }
                              }

                              var10005 = 0;
                           }

                           var33.<init>(var10003, var10004, var10005 + 1);
                           _entity.m_7292_(var33);
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 2, 2, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19603_, 2, 1, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19611_, 219, 0, false, false));
                     }
                  }
               }

               label192: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt26 = (LivingEntity)entity;
                     if (_livEnt26.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label192;
                     }
                  }

                  if (!(entity instanceof LivingEntity)) {
                     return;
                  }

                  LivingEntity _livEnt27 = (LivingEntity)entity;
                  if (!_livEnt27.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                     return;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get());
               }
            }
         }

      }
   }
}
