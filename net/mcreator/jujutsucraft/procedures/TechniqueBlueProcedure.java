package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueBlueProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double dis = (double)0.0F;
         boolean logic_a = false;
         boolean picth = false;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) > (double)8.0F) {
                  label201: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                        label202: {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128471_("attack")) {
                                 break label202;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                              break label201;
                           }
                        }
                     }

                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt15 = (LivingEntity)entity;
                  if (_livEnt15.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 4, false, false));
                  }
               }

               x_pos = entity.m_20185_() + entity.m_20154_().f_82479_ * (double)3.0F;
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + entity.m_20154_().f_82480_ * (double)3.0F;
               z_pos = entity.m_20189_() + entity.m_20154_().f_82481_ * (double)3.0F;

               for(int index0 = 0; index0 < 2; ++index0) {
                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     ParticleGeneratorProcedure.execute(world, (double)0.0F, (double)1.0F, (double)0.0F, (double)2.0F, x_pos + (Math.random() - (double)0.5F) * (double)2.0F, x_pos, y_pos + (Math.random() - (double)0.5F) * (double)2.0F, y_pos, z_pos + (Math.random() - (double)0.5F) * (double)2.0F, z_pos, "minecraft:enchanted_hit");
                  } else {
                     ParticleGeneratorProcedure.execute(world, (double)0.0F, (double)1.0F, (double)0.0F, (double)2.0F, x_pos + (Math.random() - (double)0.5F) * (double)2.0F, x_pos, y_pos + (Math.random() - (double)0.5F) * (double)2.0F, y_pos, z_pos + (Math.random() - (double)0.5F) * (double)2.0F, z_pos, "minecraft:crit");
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") < (double)3.0F) {
                  entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("cnt5") > (double)20.0F) {
                     entity.getPersistentData().m_128347_("cnt5", (double)0.0F);
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + (double)1.0F);
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        if (!_player.m_9236_().m_5776_()) {
                           CompoundTag var10001 = entity.getPersistentData();
                           _player.m_5661_(Component.m_237113_("§l\"" + Component.m_237115_("chant.jujutsucraft.blue" + Math.round(var10001.m_128459_("cnt6"))).getString() + "\""), false);
                        }
                     }

                     ChangeCurseEnergyProcedure.execute(entity, (double)-50.0F);
                  }
               } else if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, 20, (double)0.25F, (double)0.25F, (double)0.25F, (double)1.5F);
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)1.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if ((entity.m_6144_() || !(entity instanceof Player) && Math.random() < (double)0.5F) && entity.getPersistentData().m_128459_("cnt6") > (double)0.0F) {
                  dis = (double)8.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1);
                  entity.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_());
                  entity.getPersistentData().m_128347_("y_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_());
                  entity.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());
                  entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
               } else {
                  dis = (double)16.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1);
                  entity.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123341_());
                  entity.getPersistentData().m_128347_("y_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123342_());
                  entity.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123343_());
                  entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }
            }

            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
            if (entity.getPersistentData().m_128459_("cnt1") <= (double)5.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().m_128459_("cnt6") * (double)5.0F), (double)0.25F, (double)0.25F, (double)0.25F, (double)0.5F);
               }
            } else {
               int var59;
               label149: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var59 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label149;
                     }
                  }

                  var59 = 0;
               }

               HP = (double)(40 + var59 * 8) * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1);
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.BLUE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     entityinstance.m_146922_(entity.m_146908_());
                     entityinstance.m_146926_(entity.m_146909_());
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity83 = (LivingEntity)entityinstance;
                        if (_livingEntity83.m_21204_().m_22171_(Attributes.f_22276_)) {
                           _livingEntity83.m_21051_(Attributes.f_22276_).m_22100_(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.m_21153_((float)HP);
                     }

                     entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                     entityinstance.getPersistentData().m_128379_("circle", entity.getPersistentData().m_128459_("cnt2") != (double)0.0F);
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity94 = (LivingEntity)entityinstance;
                        if (_livingEntity94.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity94.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)5.0F + entity.getPersistentData().m_128459_("cnt6") * (double)0.5F);
                        }
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
