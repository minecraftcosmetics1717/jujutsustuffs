package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.DomainExpansionEntityEntity;
import net.mcreator.jujutsucraft.entity.FrameEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;

public class SkillProjectionSorceryProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean SUCCESS = false;
         boolean move_flag = false;
         String STR1 = "";
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double size = (double)0.0F;
         double dis = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double max_num = (double)0.0F;
         double strength = (double)0.0F;

         for(int index0 = 0; index0 < 2; ++index0) {
            int var10001;
            label237: {
               STR1 = entity.m_5446_().getString();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label237;
                  }
               }

               var10001 = 0;
            }

            strength = (double)0.5F + (double)Math.min(var10001, 10) * 0.1 * (double)0.5F;
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
               String var70;
               label230: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _teamEnt = (LivingEntity)entity;
                     Scoreboard var10000 = _teamEnt.m_9236_().m_6188_();
                     String var72;
                     if (_teamEnt instanceof Player) {
                        Player _pl = (Player)_teamEnt;
                        var72 = _pl.m_36316_().getName();
                     } else {
                        var72 = _teamEnt.m_20149_();
                     }

                     if (var10000.m_83500_(var72) != null) {
                        var10000 = _teamEnt.m_9236_().m_6188_();
                        if (_teamEnt instanceof Player) {
                           Player _pl = (Player)_teamEnt;
                           var72 = _pl.m_36316_().getName();
                        } else {
                           var72 = _teamEnt.m_20149_();
                        }

                        var70 = var10000.m_83500_(var72).m_5758_();
                        break label230;
                     }
                  }

                  var70 = "";
               }

               if (var70.equals(STR1)) {
                  entity.getPersistentData().m_128347_("cnt10", (double)1.0F);
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "team add " + STR1);
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "team join " + STR1 + " @s");
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "team modify " + STR1 + " seeFriendlyInvisibles true");
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "team modify " + STR1 + " nametagVisibility hideForOwnTeam");
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "team modify " + STR1 + " collisionRule pushOwnTeam");
               }
            } else {
               entity.getPersistentData().m_128347_("cnt4", Math.sqrt(Math.pow(entity.getPersistentData().m_128459_("old_x") - entity.m_20185_(), (double)2.0F) + Math.pow(entity.getPersistentData().m_128459_("old_y") - entity.m_20186_(), (double)2.0F) + Math.pow(entity.getPersistentData().m_128459_("old_z") - entity.m_20189_(), (double)2.0F)));
               if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt4"));
               }

               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (Math.sqrt(Math.max(entity.getPersistentData().m_128459_("cnt1") * (double)0.5F, (double)1.0F)) * (double)0.5F + (double)0.5F) * strength);
               dis = entity.getPersistentData().m_128459_("cnt2");
               entity.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123341_());
               entity.getPersistentData().m_128347_("y_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123342_());
               entity.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123343_());
               if (entity.getPersistentData().m_128459_("cnt1") <= (double)21.0F && entity.getPersistentData().m_128459_("cnt1") == (double)2.0F) {
                  yaw = (double)entity.m_146908_();
                  pitch = (double)entity.m_146909_();
                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_();
                  z_pos = entity.m_20189_();
                  if (entity.getPersistentData().m_128459_("NameRanged") == (double)0.0F) {
                     entity.getPersistentData().m_128347_("NameRanged", Math.random());
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_PROJECTION_SORCERY.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        entityinstance.m_146922_((float)yaw);
                        entityinstance.m_146926_((float)pitch);
                        entityinstance.m_5618_(entityinstance.m_146908_());
                        entityinstance.m_5616_(entityinstance.m_146908_());
                        entityinstance.f_19859_ = entityinstance.m_146908_();
                        entityinstance.f_19860_ = entityinstance.m_146909_();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                           entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
                        }

                        entityinstance.getPersistentData().m_128347_("NameRanged_ranged", entity.getPersistentData().m_128459_("NameRanged"));
                        entityinstance.getPersistentData().m_128347_("cnt5", (double)Math.round(1.0F));
                        entityinstance.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos"));
                        entityinstance.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos"));
                        entityinstance.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos"));
                        entityinstance.getPersistentData().m_128359_("owner_name", STR1);
                        entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                        entityinstance.m_6842_(true);
                        entityinstance.m_6593_(Component.m_237113_("FRAME" + Math.round(1.0F)));
                        PlayerTeam _pt = entityinstance.m_9236_().m_6188_().m_83489_(STR1);
                        if (_pt != null) {
                           if (entityinstance instanceof Player) {
                              Player _player = (Player)entityinstance;
                              entityinstance.m_9236_().m_6188_().m_6546_(_player.m_36316_().getName(), _pt);
                           } else {
                              entityinstance.m_9236_().m_6188_().m_6546_(entityinstance.m_20149_(), _pt);
                           }
                        }

                        _serverLevel.m_7967_(entityinstance);
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") >= (double)6.0F) {
                  if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
                     if (!entity.getPersistentData().m_128471_("PRESS_Z")) {
                        entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
                        entity.getPersistentData().m_128347_("cnt5", (double)0.0F);
                     }
                  } else {
                     entity.f_19789_ = 0.0F;
                     if (entity.getPersistentData().m_128459_("cnt7") != (double)0.0F) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get(), 20, 0, false, false));
                           }
                        }

                        entity.getPersistentData().m_128347_("skill", (double)0.0F);
                        if (entity.getPersistentData().m_128459_("cnt10") == (double)0.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "team remove " + STR1);
                        }
                        break;
                     }

                     entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
                     x_power = entity.m_20185_() - entity.getPersistentData().m_128459_("old_x");
                     y_power = entity.m_20186_() - entity.getPersistentData().m_128459_("old_y");
                     z_power = entity.m_20189_() - entity.getPersistentData().m_128459_("old_z");
                     dis = Math.sqrt(Math.pow(x_power, (double)2.0F) + Math.pow(y_power, (double)2.0F) + Math.pow(z_power, (double)2.0F));
                     if (dis > (double)0.0F) {
                        x_pos = entity.m_20185_();
                        y_pos = entity.m_20186_();
                        z_pos = entity.m_20189_();
                        x_power /= dis;
                        y_power /= dis;
                        z_power /= dis;

                        for(int index1 = 0; index1 < (int)Math.round(dis); ++index1) {
                           Vec3 _center = new Vec3(x_pos, y_pos + (double)entity.m_20206_() * (double)0.5F, z_pos);

                           for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(((double)2.0F + ReturnEntitySizeProcedure.execute(entity)) / (double)2.0F), (e) -> true)) {
                              if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !(entityiterator instanceof FrameEntity) && !(entityiterator instanceof DomainExpansionEntityEntity) && entityiterator.getPersistentData().m_128459_("select") == (double)0.0F) {
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt94 = (LivingEntity)entityiterator;
                                    if (_livEnt94.m_21023_((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get())) {
                                       continue;
                                    }
                                 }

                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt95 = (LivingEntity)entityiterator;
                                    if (_livEnt95.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                       continue;
                                    }
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                                 }

                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    if (!_entity.m_9236_().m_5776_()) {
                                       _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get(), 30, 0, false, false));
                                    }
                                 }
                              }
                           }

                           x_pos += x_power * (double)1.0F;
                           y_pos += y_power * (double)1.0F;
                           z_pos += z_power * (double)1.0F;
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cnt5") >= (double)20.0F) {
                        entity.getPersistentData().m_128347_("skill", (double)0.0F);
                        if (entity.getPersistentData().m_128459_("cnt10") == (double)0.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "team remove " + STR1);
                        }
                        break;
                     }
                  }
               }
            }

            entity.getPersistentData().m_128347_("old_x", entity.m_20185_());
            entity.getPersistentData().m_128347_("old_y", entity.m_20186_());
            entity.getPersistentData().m_128347_("old_z", entity.m_20189_());
         }

      }
   }
}
