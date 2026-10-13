package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade112Entity;
import net.mcreator.jujutsucraft.entity.EntityCrystalEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

public class CrystalExplosionProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double cnt6 = (double)0.0F;
         double x_target = (double)0.0F;
         double distance = (double)0.0F;
         double picth = (double)0.0F;
         double HP = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double y_target = (double)0.0F;
         double z_target = (double)0.0F;
         double yaw = (double)0.0F;
         double speed = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double y_pos = (double)0.0F;
         double range = (double)0.0F;
         double num1 = (double)0.0F;
         String stt1 = "";
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)0.0F) {
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            picth = Math.toRadians((double)entity.m_146909_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(picth) * ((double)1.5F + (double)entity.m_20205_());
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.6 + Math.sin(picth) * (double)-1.0F * ((double)1.5F + (double)entity.m_20205_());
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(picth) * ((double)1.5F + (double)entity.m_20205_());
            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, 2, 0.1, 0.1, 0.1, 0.2);
               }
            } else {
               entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, 10, 0.1, 0.1, 0.1, (double)0.5F);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, 2, 0.1, 0.1, 0.1, 0.1);
               }

               if (entity instanceof Player) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)1.0F;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
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
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) > (double)8.0F) {
                  label259: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                        label260: {
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
                                 break label260;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                              break label259;
                           }
                        }
                     }

                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt2", Math.min(entity.getPersistentData().m_128459_("cnt2"), (double)0.0F));
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
               entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
               entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") > (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt2", (double)-3.0F);
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            LivingEntity var94;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var94 = _mobEnt.m_5448_();
            } else {
               var94 = null;
            }

            if (var94 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var94 = _mobEnt.m_5448_();
               } else {
                  var94 = null;
               }

               x_target = ((Entity)var94).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var94 = _mobEnt.m_5448_();
               } else {
                  var94 = null;
               }

               double var97 = ((Entity)var94).m_20186_();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               y_target = var97 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
               LivingEntity var98;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var98 = _mobEnt.m_5448_();
               } else {
                  var98 = null;
               }

               z_target = ((Entity)var98).m_20189_();
            } else {
               x_target = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)48.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_target = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)48.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_target = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)48.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
            }

            x_power = x_target - entity.getPersistentData().m_128459_("x_pos");
            y_power = y_target - entity.getPersistentData().m_128459_("y_pos");
            z_power = z_target - entity.getPersistentData().m_128459_("z_pos");
            distance = Math.sqrt(Math.pow(x_power, (double)2.0F) + Math.pow(y_power, (double)2.0F) + Math.pow(z_power, (double)2.0F));
            if (distance > (double)0.0F) {
               x_power /= distance;
               y_power /= distance;
               z_power /= distance;
            }

            for(int index0 = 0; index0 < (int)((double)5.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2)); ++index0) {
               entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") + x_power);
               entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + y_power);
               entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") + z_power);
            }

            if (world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"))).m_60815_() || world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"))).m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
               for(int index1 = 0; index1 < 255 && (world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"))).m_60815_() || world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"))).m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))); ++index1) {
                  entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + (double)1.0F);
               }
            }

            for(int index2 = 0; index2 < 255; ++index2) {
               if (world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"))).m_60815_() || world.m_8055_(BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"))).m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
                  entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") - (double)3.5F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2));
                  break;
               }

               entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") - (double)1.0F);
            }

            range = 0.1;
            yaw = (double)entity.m_146908_();
            picth = (double)entity.m_146909_();
            num1 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            x_pos = entity.getPersistentData().m_128459_("x_pos") + Math.cos(num1) * range;
            y_pos = entity.getPersistentData().m_128459_("y_pos") - range * 0.17;
            z_pos = entity.getPersistentData().m_128459_("z_pos") + Math.sin(num1) * range;
            logic_a = false;
            entity.m_146922_((float)(Math.toDegrees(num1) - (double)90.0F));
            entity.m_146926_(-60.0F);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
            entity.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") / (double)3.0F);
            entity.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") / (double)3.0F);
            entity.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") / (double)3.0F);
            String var99;
            if (entity instanceof CursedSpiritGrade112Entity) {
               CursedSpiritGrade112Entity animatable = (CursedSpiritGrade112Entity)entity;
               var99 = animatable.getTexture();
            } else {
               var99 = "null";
            }

            stt1 = var99;
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_CRYSTAL.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                     entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b}");
                  }

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

                  entityinstance.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.m_9236_().m_5776_()) {
                        MobEffectInstance var100;
                        MobEffect var10003;
                        int var10005;
                        label187: {
                           var100 = new MobEffectInstance;
                           var10003 = MobEffects.f_19606_;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                 var10005 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                 break label187;
                              }
                           }

                           var10005 = 0;
                        }

                        var100.<init>(var10003, Integer.MAX_VALUE, var10005, false, false);
                        _entity.m_7292_(var100);
                     }
                  }

                  entityinstance.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power"));
                  entityinstance.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power"));
                  entityinstance.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power"));
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity153 = (LivingEntity)entityinstance;
                     if (_livingEntity153.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity153.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)2.5F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2));
                     }
                  }

                  if (entityinstance instanceof EntityCrystalEntity) {
                     EntityCrystalEntity _datEntSetI = (EntityCrystalEntity)entityinstance;
                     _datEntSetI.m_20088_().m_135381_(EntityCrystalEntity.DATA_mode, 1);
                  }

                  if (entity instanceof CursedSpiritGrade112Entity && entityinstance instanceof EntityCrystalEntity) {
                     EntityCrystalEntity animatable = (EntityCrystalEntity)entityinstance;
                     animatable.setTexture(stt1);
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }

            entity.m_146922_((float)yaw);
            entity.m_146926_((float)picth);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)8.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
