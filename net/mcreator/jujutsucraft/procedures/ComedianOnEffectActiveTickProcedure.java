package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.TakabaFumihikoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ComedianOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM2 = (double)0.0F;
         double NUM1 = (double)0.0F;
         double tick = (double)0.0F;
         double T1 = (double)0.0F;
         double T2 = (double)0.0F;
         if (entity.m_6084_()) {
            int var10000;
            label145: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).m_19564_();
                     break label145;
                  }
               }

               var10000 = 0;
            }

            if (var10000 > 0) {
               label139: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                        var43 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).m_19557_();
                        break label139;
                     }
                  }

                  var43 = (double)0.0F;
               }

               tick = var43;
               if (tick % (double)10.0F == (double)0.0F) {
                  JujutsucraftModVariables.PlayerVariables pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
                  if (entity instanceof Player) {
                     T1 = pVars.PlayerCurseTechnique;
                     T2 = pVars.PlayerCurseTechnique2;
                  }

                  if (entity instanceof Player) {
                     if (pVars.PlayerCurseTechnique != (double)17.0F && pVars.PlayerCurseTechnique2 != (double)17.0F) {
                        return;
                     }
                  } else if (!(entity instanceof TakabaFumihikoEntity)) {
                     return;
                  }

                  label166: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt6 = (LivingEntity)entity;
                        if (_livEnt6.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                           break label166;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt7 = (LivingEntity)entity;
                        if (_livEnt7.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                           break label166;
                        }
                     }

                     if (tick % (double)60.0F == (double)0.0F) {
                        float var44;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var44 = _livEnt.m_21223_();
                        } else {
                           var44 = -1.0F;
                        }

                        double var45 = (double)var44;
                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21233_();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (var45 <= (double)var10001 * (double)0.5F) {
                           label115: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                                    var45 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).m_19564_();
                                    break label115;
                                 }
                              }

                              var45 = (double)0.0F;
                           }

                           label110: {
                              NUM1 = var45;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                                    var45 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).m_19557_();
                                    break label110;
                                 }
                              }

                              var45 = (double)0.0F;
                           }

                           NUM2 = var45;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get());
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get(), (int)NUM2, (int)(NUM1 - (double)1.0F)));
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.m_21223_();
                              } else {
                                 var10001 = -1.0F;
                              }

                              double var49 = (double)var10001;
                              float var10002;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var10002 = _livEnt.m_21233_();
                              } else {
                                 var10002 = -1.0F;
                              }

                              _entity.m_21153_((float)(var49 + (double)var10002 * (double)0.5F));
                           }
                        }
                     }

                     if (tick % (double)100.0F == (double)0.0F) {
                        Vec3 _center = new Vec3(x, y, z);

                        for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)24.0F), (e) -> true)) {
                           if (entity != entityiterator && !entityiterator.getPersistentData().m_128471_("CursedSpirit") && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get(), 120, 0));
                              }
                           }
                        }
                     }

                     return;
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get());
                  }
               }
            }
         }

      }
   }
}
