package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;

public class AIRikaProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean attack = false;
         Entity entity_a = null;
         double rnd = (double)0.0F;
         double dis = (double)0.0F;
         double distance = (double)0.0F;
         double level = (double)0.0F;
         double tick = (double)0.0F;
         double setItem = (double)0.0F;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof Rika2Entity) {
               entity.getPersistentData().m_128347_("cnt_connect", entity.getPersistentData().m_128459_("cnt_connect") + (double)1.0F);
            }

            label173: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19600_)) {
                     break label173;
                  }
               }

               entity.m_274367_((float)Math.max((double)entity.getStepHeight(), 2.4));
               if (entity instanceof RikaEntity) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 20, false, false));
                     }
                  }
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 16, false, false));
                  }
               }
            }

            label168: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt10 = (LivingEntity)entity;
                  if (_livEnt10.m_21023_(MobEffects.f_19606_)) {
                     break label168;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 3, false, false));
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
               if (entity instanceof Rika2Entity && entity.getPersistentData().m_128459_("cnt_connect") > (double)3600.0F && LogicOwnerExistProcedure.execute(world, entity)) {
                  entity.getPersistentData().m_128347_("despawn_flag", (double)1.0F);
               }

               if (entity.getPersistentData().m_128459_("despawn_flag") > (double)0.0F && entity.getPersistentData().m_128459_("friend_num_worker") != (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_target", (double)0.0F);
                  entity.getPersistentData().m_128347_("cnt_die", entity.getPersistentData().m_128459_("cnt_die") + (double)1.0F);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123783_, x, y + (double)entity.m_20206_() * (double)0.5F, z, (int)((double)20.0F * ReturnEntitySizeProcedure.execute(entity)), (double)0.25F * (double)entity.m_20205_(), (double)0.25F * (double)entity.m_20206_(), (double)0.25F * (double)entity.m_20205_(), (double)0.0F);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123755_, x, y + (double)entity.m_20206_() * (double)0.5F, z, (int)((double)5.0F * ReturnEntitySizeProcedure.execute(entity)), (double)0.25F * (double)entity.m_20205_(), (double)0.25F * (double)entity.m_20206_(), (double)0.25F * (double)entity.m_20205_(), (double)0.0F);
                  }

                  if (entity.getPersistentData().m_128459_("cnt_die") > (double)(entity.getPersistentData().m_128459_("despawn_flag") == (double)1.0F ? 60 : 5)) {
                     DieRikaProcedure.execute(world, entity);
                     if (!entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }
                  }
               } else {
                  attack = entity.getPersistentData().m_128471_("flag_attack");
                  LivingEntity var10000;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if ((!(var10000 instanceof LivingEntity) || !(entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F)) && !attack) {
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  } else {
                     entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                     if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F || attack) {
                        label192: {
                           label184: {
                              entity.getPersistentData().m_128379_("flag_attack", false);
                              if (!attack) {
                                 if (!(Math.random() < 0.2)) {
                                    break label184;
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt42 = (LivingEntity)entity;
                                    if (_livEnt42.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                       break label184;
                                    }
                                 }
                              }

                              entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                              ResetCounterProcedure.execute(entity);
                              rnd = (double)Math.abs(Math.round(Math.random() * (double)50.0F) + (long)(entity.getPersistentData().m_128459_("friend_num_worker") == (double)0.0F ? 20 : 100));
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)Math.round(rnd), 0, false, false));
                                 }
                              }

                              if (entity.getPersistentData().m_128459_("friend_num_worker") == (double)0.0F) {
                                 entity.getPersistentData().m_128347_("skill_num", entity.getPersistentData().m_128459_("skill_num") + (double)1.0F);
                              }

                              if (entity.getPersistentData().m_128459_("skill_num") < (double)8.0F) {
                                 entity.getPersistentData().m_128347_("skill", (double)(Math.random() < (double)0.75F ? 11 : 13));
                              } else {
                                 entity.getPersistentData().m_128347_("skill", (double)12.0F);
                                 entity.getPersistentData().m_128347_("skill_num", (double)0.0F);
                              }
                              break label192;
                           }

                           entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                           CalculateAttackProcedure.execute(world, entity);
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F && entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
                     if (LogicOwnerExistProcedure.execute(world, entity)) {
                        entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                        if (entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
                           if (entity_a.m_6084_()) {
                              dis = Math.sqrt(Math.pow(entity_a.m_20185_() - entity.m_20185_(), (double)2.0F) + Math.pow(entity_a.m_20186_() - entity.m_20186_(), (double)2.0F) + Math.pow(entity_a.m_20189_() - entity.m_20189_(), (double)2.0F));
                              if (dis > (double)24.0F) {
                                 entity.getPersistentData().m_128379_("canFly", true);
                                 GetPowerForwardProcedure.execute((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_(), entity);
                                 entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)0.5F, entity.getPersistentData().m_128459_("y_power") * (double)0.5F, entity.getPersistentData().m_128459_("z_power") * (double)0.5F));
                                 if (dis > (double)36.0F) {
                                    entity.m_6021_((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_());
                                    if (entity instanceof ServerPlayer) {
                                       ServerPlayer _serverPlayer = (ServerPlayer)entity;
                                       _serverPlayer.f_8906_.m_9774_((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_(), entity.m_146908_(), entity.m_146909_());
                                    }

                                    entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
                                    entity.m_146922_(entity_a.m_146908_());
                                    entity.m_146926_(entity_a.m_146909_());
                                    entity.m_5618_(entity.m_146908_());
                                    entity.m_5616_(entity.m_146908_());
                                    entity.f_19859_ = entity.m_146908_();
                                    entity.f_19860_ = entity.m_146909_();
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entity;
                                       _entity.f_20884_ = _entity.m_146908_();
                                       _entity.f_20886_ = _entity.m_146908_();
                                    }
                                 }
                              }
                           } else {
                              entity.getPersistentData().m_128347_("friend_num", (double)0.0F);
                              entity.getPersistentData().m_128347_("friend_num_worker", (double)0.0F);
                              entity.getPersistentData().m_128359_("OWNER_UUID", "");
                           }
                        }
                     } else {
                        entity.getPersistentData().m_128347_("friend_num", (double)0.0F);
                        entity.getPersistentData().m_128347_("friend_num_worker", (double)0.0F);
                        entity.getPersistentData().m_128359_("OWNER_UUID", "");
                     }
                  }
               }
            } else {
               if (entity.getPersistentData().m_128459_("skill") == (double)11.0F) {
                  AIRika1Procedure.execute(world, x, y, z, entity);
               } else if (entity.getPersistentData().m_128459_("skill") == (double)12.0F) {
                  AIRika3Procedure.execute(world, x, y, z, entity);
               } else if (entity.getPersistentData().m_128459_("skill") == (double)13.0F) {
                  RikaBlastProcedure.execute(world, x, y, z, entity);
               }

               if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  CursedTechniquePotionExpiresProcedure.execute(world, x, y, z, entity);
               }
            }
         }

      }
   }
}
