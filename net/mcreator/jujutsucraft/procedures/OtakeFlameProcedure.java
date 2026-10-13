package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class OtakeFlameProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double CNT6 = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         double distance1 = (double)0.0F;
         double distance_limit = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 5, false, false));
            }
         }

         range = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")), SoundSource.NEUTRAL, (float)(range * (double)2.0F), 1.0F);
            } else {
               _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")), SoundSource.NEUTRAL, (float)(range * (double)2.0F), 1.0F, false);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)5.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
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
               if (GetDistanceProcedure.execute(entity) > (double)12.0F) {
                  label143: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                        label144: {
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
                                 break label144;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                              break label143;
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
               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)4.0F));
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)4.0F) {
               if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)2.0F;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  if (entity.getPersistentData().m_128459_("cnt7") == (double)0.0F) {
                     entity.getPersistentData().m_128347_("cnt7", (double)1.0F);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               ChargeParticleProcedure.execute(world, entity, (double)10.0F);
            } else {
               ChargeParticleProcedure.execute(world, entity, (double)0.0F);
            }
         }

         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("cnt1") > (double)5.0F) {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt2") <= (double)2.0F + entity.getPersistentData().m_128459_("cnt6") * (double)0.5F && entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)(range * (double)2.0F), 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)(range * (double)2.0F), 1.0F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity47 = (LivingEntity)entity;
                  if (_livingEntity47.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity47.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               yaw = (double)entity.m_146908_();
               pitch = (double)entity.m_146909_();
               entity.m_146922_((float)yaw);
               entity.m_146926_(0.0F);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_);
               entity.m_146922_((float)yaw);
               entity.m_146926_((float)pitch);
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

            distance_limit = (double)24.0F * CNT6 * range;
            distance1 = Math.min(distance_limit, entity.getPersistentData().m_128459_("cnt2") * (double)6.0F * CNT6 * range);
            entity.getPersistentData().m_128347_("Damage", ((double)15.0F + entity.getPersistentData().m_128459_("cnt2") * 0.1) * CNT6);
            entity.getPersistentData().m_128347_("Range", distance1);
            entity.getPersistentData().m_128347_("knockback", 0.1 * CNT6);
            entity.getPersistentData().m_128347_("effect", (double)10.0F);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (entity.getPersistentData().m_128459_("cnt2") % (double)4.0F == (double)1.0F) {
               entity.getPersistentData().m_128347_("BlockRange", distance1 * (double)0.5F);
               entity.getPersistentData().m_128347_("BlockDamage", (double)2.0F * CNT6 * Math.max((double)1.0F - entity.getPersistentData().m_128459_("cnt2") / ((double)8.0F * CNT6), 0.05));
               entity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            ParticleGeneratorProcedure.execute(world, (double)1.0F * distance_limit, (double)60.0F * CNT6 * range, (double)5.0F, (double)2.0F, x_pos - entity.getPersistentData().m_128459_("x_power") * (double)0.5F * distance_limit, x_pos + entity.getPersistentData().m_128459_("x_power") * (double)0.5F * distance_limit, y_pos + (double)0.5F * distance_limit, y_pos - (double)0.5F * distance_limit, z_pos - entity.getPersistentData().m_128459_("z_power") * (double)0.5F * distance_limit, z_pos + entity.getPersistentData().m_128459_("z_power") * (double)0.5F * distance_limit, "minecraft:flame");
            if (entity.getPersistentData().m_128459_("cnt2") > (double)8.0F * CNT6) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
