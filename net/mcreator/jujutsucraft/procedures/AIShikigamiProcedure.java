package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.EntityTsuchigumoEntity;
import net.mcreator.jujutsucraft.entity.RozetsuShikigamiEntity;
import net.mcreator.jujutsucraft.entity.RozetsuShikigamiVessel2Entity;
import net.mcreator.jujutsucraft.entity.RozetsuShikigamiVesselEntity;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class AIShikigamiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity owner_uuid = null;
         double count_a = (double)0.0F;
         double NUM2 = (double)0.0F;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double NUM1 = (double)0.0F;
         boolean failed = false;
         boolean old_sneak = false;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof RozetsuShikigamiVesselEntity) {
               NUM1 = (double)3.0F;
               NUM2 = (double)1.0F;
            } else if (entity instanceof RozetsuShikigamiVessel2Entity) {
               NUM1 = (double)6.0F;
               NUM2 = (double)2.0F;
            } else {
               double var10001;
               label176: {
                  NUM1 = (double)(2L + Math.round(entity.getPersistentData().m_128459_("Strength") * (double)0.5F));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity4 = (LivingEntity)entity;
                     if (_livingEntity4.m_21204_().m_22171_(Attributes.f_22281_)) {
                        var10001 = _livingEntity4.m_21051_(Attributes.f_22281_).m_22115_();
                        break label176;
                     }
                  }

                  var10001 = (double)0.0F;
               }

               NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * (double)3.0F) / (double)4.0F, (double)3.0F)));
            }

            label169: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.m_21023_(MobEffects.f_19600_)) {
                     break label169;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)NUM1, false, false));
                  }
               }
            }

            int var10000;
            label164: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                     var10000 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                     break label164;
                  }
               }

               var10000 = 0;
            }

            if ((double)var10000 < NUM2 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, (int)NUM2, false, false));
               }
            }

            LivingEntity var38;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var38 = _mobEnt.m_5448_();
            } else {
               var38 = null;
            }

            if (var38 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               entity.getPersistentData().m_128347_("cnt_x2", (double)0.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  if (entity instanceof RozetsuShikigamiVessel2Entity) {
                     rnd = (double)0.0F;
                     if (LogicStartProcedure.execute(entity)) {
                        rnd = Math.random() < (double)0.75F ? (double)8.0F : (double)7.0F;
                        tick = (double)100.0F;
                     }

                     if (rnd > (double)0.0F) {
                        ResetCounterProcedure.execute(entity);
                        entity.getPersistentData().m_128347_("TenShadowsTechnique4", (double)1.0F);
                        entity.getPersistentData().m_128347_("skill", (double)(600L + Math.round(rnd)));
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
                     } else {
                        CalculateAttackProcedure.execute(world, entity);
                     }
                  } else if (entity instanceof EntityTsuchigumoEntity) {
                     int var39;
                     if (entity instanceof EntityTsuchigumoEntity) {
                        EntityTsuchigumoEntity _datEntI = (EntityTsuchigumoEntity)entity;
                        var39 = (Integer)_datEntI.m_20088_().m_135370_(EntityTsuchigumoEntity.DATA_model);
                     } else {
                        var39 = 0;
                     }

                     if (var39 == 2) {
                        ResetCounterProcedure.execute(entity);
                        entity.getPersistentData().m_128347_("skill", (double)4203.0F);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 100, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                           }
                        }
                     }
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt_x2", entity.getPersistentData().m_128459_("cnt_x2") + (double)1.0F);
               if (entity instanceof RozetsuShikigamiVessel2Entity && entity.getPersistentData().m_128459_("cnt_x2") > (double)120.0F) {
                  entity.getPersistentData().m_128347_("cnt_x2", (double)0.0F);
                  entity.getPersistentData().m_128347_("skill", (double)1.0F);
                  ReturnShadowProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }
         }

         if (entity.getPersistentData().m_128471_("Shikigami")) {
            owner_uuid = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (owner_uuid instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_life") > (double)(entity instanceof RozetsuShikigamiEntity ? 400 : 600)) {
                  old_sneak = owner_uuid.m_6144_();
                  owner_uuid.m_20260_(true);
                  ShikigamiRightClickedOnEntityProcedure.execute(world, entity, owner_uuid);
                  owner_uuid.m_20260_(old_sneak);
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                  }
               }

               if (!owner_uuid.m_6084_() && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
            }

            if ((!(entity instanceof RozetsuShikigamiEntity) || entity.getPersistentData().m_128471_("domain_entity")) && owner_uuid instanceof LivingEntity) {
               LivingEntity _livEnt52 = (LivingEntity)owner_uuid;
               if (_livEnt52.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()) && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

      }
   }
}
