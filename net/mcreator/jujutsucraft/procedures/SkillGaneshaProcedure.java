package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillGaneshaProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double CNT6 = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double range = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         range = (double)entity.m_20206_() * 0.4;
         x_pos = entity.m_20185_() + entity.m_20154_().f_82479_ * (double)4.0F * range;
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + entity.m_20154_().f_82480_ * (double)4.0F * range;
         z_pos = entity.m_20189_() + entity.m_20154_().f_82481_ * (double)4.0F * range;
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)5.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 5, false, false));
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
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) > (double)12.0F) {
                  label253: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                        label254: {
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
                                 break label254;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                              break label253;
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

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)4.0F && entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
               entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
               if (entity instanceof Player) {
                  ChangeCurseEnergyProcedure.execute(entity, (double)-2.0F);
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                  }
               }
            }

            for(int index0 = 0; index0 < (int)((double)8.0F * range); ++index0) {
               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  ParticleGeneratorProcedure.execute(world, (double)0.0F, (double)1.0F, (double)0.0F, (double)4.0F, x_pos + (Math.random() - (double)0.5F) * (double)12.0F * range, x_pos, y_pos + (Math.random() - (double)0.5F) * (double)12.0F * range, y_pos, z_pos + (Math.random() - (double)0.5F) * (double)12.0F * range, z_pos, "minecraft:enchanted_hit");
               } else {
                  ParticleGeneratorProcedure.execute(world, (double)0.0F, (double)1.0F, (double)0.0F, (double)4.0F, x_pos + (Math.random() - (double)0.5F) * (double)12.0F * range, x_pos, y_pos + (Math.random() - (double)0.5F) * (double)12.0F * range, y_pos, z_pos + (Math.random() - (double)0.5F) * (double)12.0F * range, z_pos, "minecraft:crit");
               }
            }

            entity.getPersistentData().m_128347_("x_pos", x_pos);
            entity.getPersistentData().m_128347_("y_pos", y_pos);
            entity.getPersistentData().m_128347_("z_pos", z_pos);
         }

         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         x_pos = entity.getPersistentData().m_128459_("x_pos");
         y_pos = entity.getPersistentData().m_128459_("y_pos");
         z_pos = entity.getPersistentData().m_128459_("z_pos");
         if (entity.getPersistentData().m_128459_("cnt1") > (double)5.0F) {
            entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt2") <= (double)15.0F) {
               if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
                  entity.m_20095_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity53 = (LivingEntity)entity;
                     if (_livingEntity53.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity53.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity54 = (LivingEntity)entity;
                     if (_livingEntity54.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity54.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:wind_chime")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 1.25F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:wind_chime")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 1.25F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:wind_chime")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:wind_chime")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:wind_chime")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.75F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:wind_chime")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.75F, false);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get());
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get());
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19614_);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19615_);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19613_);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19604_);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19597_);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19590_);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19610_);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_216964_);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19594_);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19612_);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19602_);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19599_);
                  }

                  entity.m_146917_(0);
                  entity.m_20254_(0);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 100, 1, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19618_, 100, 0, false, false));
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
                  }
               }

               for(int index1 = 0; index1 < (int)((double)16.0F * range); ++index1) {
                  ParticleGeneratorProcedure.execute(world, (double)0.0F, (double)1.0F, (double)0.0F, (double)12.0F, x_pos, x_pos + (Math.random() - (double)0.5F) * (double)24.0F * range, y_pos, y_pos + (Math.random() - (double)0.5F) * (double)24.0F * range, z_pos, z_pos + (Math.random() - (double)0.5F) * (double)24.0F * range, "minecraft:enchanted_hit");
               }

               for(int index2 = 0; index2 < (int)((double)8.0F * range); ++index2) {
                  ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)4.0F, (double)8.0F, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)1.0F), (double)0.0F, entity.m_20189_(), entity.m_20189_(), "minecraft:enchanted_hit");
               }

               entity.getPersistentData().m_128347_("Damage", ((double)6.0F + entity.getPersistentData().m_128459_("cnt2") * 0.1) * CNT6);
               entity.getPersistentData().m_128347_("Range", (double)16.0F * range);
               entity.getPersistentData().m_128347_("effect", (double)17.0F);
               entity.getPersistentData().m_128347_("effectConfirm", (double)4.0F);
               entity.getPersistentData().m_128379_("ignore", true);
               if (entity.getPersistentData().m_128459_("cnt2") < (double)12.0F) {
                  entity.getPersistentData().m_128347_("y_knockback", (double)-2.0F);
                  entity.getPersistentData().m_128347_("knockback", 0.1);
               } else {
                  entity.getPersistentData().m_128347_("y_knockback", (double)0.25F);
                  entity.getPersistentData().m_128347_("knockback", (double)0.5F * CNT6);
               }

               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
               entity.getPersistentData().m_128347_("Damage", (double)15.0F * CNT6);
               DamageFixProcedure.execute(entity);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") > (double)20.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
