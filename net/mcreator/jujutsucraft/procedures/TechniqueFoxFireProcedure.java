package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class TechniqueFoxFireProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean target = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double distance = (double)0.0F;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 20, false, false));
            }
         }

         int var10001;
         label163: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label163;
               }
            }

            var10001 = 0;
         }

         HP = (double)(10 + var10001 * 2);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         target = var10000 instanceof LivingEntity;
         if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
            label156: {
               label155: {
                  if (entity instanceof Player) {
                     if (entity.m_6144_()) {
                        break label155;
                     }
                  } else if (Math.random() < (double)0.0F) {
                     break label155;
                  }

                  entity.getPersistentData().m_128347_("cnt2", (double)2.0F);
                  break label156;
               }

               entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
            }
         }

         if (target) {
            entity.getPersistentData().m_128379_("PRESS_Z", false);
            if (GetDistanceProcedure.execute(entity) > (double)8.0F) {
               label169: {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                     label170: {
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
                              break label170;
                           }
                        }

                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                           break label169;
                        }
                     }
                  }

                  entity.getPersistentData().m_128379_("PRESS_Z", true);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)0.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               entity.getPersistentData().m_128347_("cnt1", (double)-1.0F);
               entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * (double)(1.0F + entity.m_20205_()) + (Math.random() - (double)0.5F) * 0.1;
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.FOX_FIRE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
                        LivingEntity _livingEntity44 = (LivingEntity)entityinstance;
                        if (_livingEntity44.m_21204_().m_22171_(Attributes.f_22276_)) {
                           _livingEntity44.m_21051_(Attributes.f_22276_).m_22100_(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.m_21153_((float)HP);
                     }

                     entityinstance.getPersistentData().m_128347_("move", (double)1.0F);
                     entityinstance.getPersistentData().m_128347_("cnt1", (double)14.0F);
                     entityinstance.getPersistentData().m_128347_("cnt6", (double)-0.5F);
                     entityinstance.getPersistentData().m_128347_("speed", (double)0.5F);
                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt3") > (double)6.0F) {
                  if (entity.getPersistentData().m_128471_("PRESS_Z") && entity.getPersistentData().m_128459_("cnt3") < (double)15.0F) {
                     if (entity instanceof Player) {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)5.0F;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.PlayerCursePowerChange = _setval;
                           capability.syncPlayerVariables(entity);
                        });
                        if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange <= (double)0.0F) {
                           entity.getPersistentData().m_128347_("skill", (double)0.0F);
                        }
                     }
                  } else {
                     entity.getPersistentData().m_128347_("skill", (double)0.0F);
                  }
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") <= (double)4.0F) {
            for(int index0 = 0; index0 < 2; ++index0) {
               x_pos = x + (Math.random() - (double)0.5F) * (double)8.0F;
               y_pos = y + Math.random() * (double)4.0F + (double)1.5F;
               z_pos = z + (Math.random() - (double)0.5F) * (double)8.0F;
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.FOX_FIRE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
                        LivingEntity _livingEntity69 = (LivingEntity)entityinstance;
                        if (_livingEntity69.m_21204_().m_22171_(Attributes.f_22276_)) {
                           _livingEntity69.m_21051_(Attributes.f_22276_).m_22100_(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.m_21153_((float)HP);
                     }

                     entityinstance.getPersistentData().m_128347_("speed", (double)-0.25F);
                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
