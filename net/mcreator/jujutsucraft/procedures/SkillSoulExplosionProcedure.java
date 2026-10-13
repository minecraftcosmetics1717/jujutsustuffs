package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
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
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillSoulExplosionProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         String targetUUID = "";
         Entity entity_a = null;
         boolean SUCCESS = false;
         boolean player = false;
         boolean GRAVESTONE = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double dis = (double)0.0F;
         double old_skill = (double)0.0F;
         double HP = (double)0.0F;
         double range = (double)0.0F;
         double tick = (double)0.0F;
         double MAX_ST = (double)0.0F;
         double damage = (double)0.0F;
         double CNT6 = (double)0.0F;
         double picth = (double)0.0F;
         double yaw = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            picth = Math.toRadians((double)entity.m_146909_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(picth) * (double)(1.0F + entity.m_20205_());
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.6 + Math.sin(picth) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(picth) * (double)(1.0F + entity.m_20205_());
            CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               ChargeParticleProcedure.execute(world, entity, (double)1.0F);
            } else {
               ChargeParticleProcedure.execute(world, entity, (double)0.0F);
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 9, false, false));
                  }
               }

               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) > (double)6.0F) {
                  label245: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                        label246: {
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
                                 break label246;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                              break label245;
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
               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)0.0F));
               if (entity.getPersistentData().m_128459_("cnt6") > (double)5.0F) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
               } else if (entity.getPersistentData().m_128459_("cnt6") == (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
               } else {
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                  if (entity.getPersistentData().m_128459_("cnt6") == (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.01);
                  }

                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)2.0F;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 9, false, false));
               }
            }

            LivingEntity var79;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var79 = _mobEnt.m_5448_();
            } else {
               var79 = null;
            }

            if (var79 instanceof LivingEntity) {
               EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
               Vec3 var10002 = new Vec3;
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               double var80 = ((Entity)var10004).m_20185_();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               double var81 = ((Entity)var10005).m_20186_();
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var81 += (double)((Entity)var10006).m_20206_() * (double)0.5F;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var10002.<init>(var80, var81, ((Entity)var10006).m_20189_());
               entity.m_7618_(var10001, var10002);
            }

            dis = (double)6.0F;

            for(int index0 = 0; index0 < 8; ++index0) {
               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_();
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)6.0F), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                     SUCCESS = true;
                     x_pos = entityiterator.m_20185_();
                     y_pos = entityiterator.m_20186_();
                     z_pos = entityiterator.m_20189_();
                     break;
                  }
               }

               if (SUCCESS) {
                  break;
               }

               dis += (double)6.0F;
            }

            for(int index1 = 0; index1 < 255 && !world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_() && !world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier"))); ++index1) {
               ++y_pos;
            }

            for(int index2 = 0; index2 < 255 && !world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_() && !world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier"))); ++index2) {
               --y_pos;
            }

            entity.getPersistentData().m_128347_("x_pos", x_pos);
            entity.getPersistentData().m_128347_("y_pos", y_pos);
            entity.getPersistentData().m_128347_("z_pos", z_pos);
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity77 = (LivingEntity)entity;
               if (_livingEntity77.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity77.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         x_pos = entity.getPersistentData().m_128459_("x_pos");
         y_pos = entity.getPersistentData().m_128459_("y_pos");
         z_pos = entity.getPersistentData().m_128459_("z_pos");
         dis = (double)6.0F * CNT6;
         if (entity.getPersistentData().m_128459_("cnt1") > (double)1.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)10.0F) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_portal.spawn")), SoundSource.NEUTRAL, 2.0F, 0.9F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_portal.spawn")), SoundSource.NEUTRAL, 2.0F, 0.9F, false);
               }
            }

            ParticleGeneratorCircleProcedure.execute(world, (double)10.0F, (double)90.0F, dis, dis, (double)0.25F, x_pos, x_pos, y_pos, y_pos + (double)1.0F, (double)0.0F, z_pos, z_pos, "minecraft:sculk_soul");
            ParticleGeneratorCircleProcedure.execute(world, (double)10.0F, (double)90.0F, dis, dis, (double)0.25F, x_pos, x_pos, y_pos, y_pos + (double)1.0F, (double)0.0F, z_pos, z_pos, "minecraft:squid_ink");
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)10.0F && entity.getPersistentData().m_128459_("cnt1") < (double)20.0F) {
            entity.getPersistentData().m_128347_("y_knockback", 0.26);
            entity.getPersistentData().m_128347_("Damage", (double)14.0F * CNT6);
            entity.getPersistentData().m_128347_("knockback", 0.1);
            entity.getPersistentData().m_128347_("Range", (double)2.0F * dis);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            entity.getPersistentData().m_128347_("BlockRange", (double)1.0F * dis);
            entity.getPersistentData().m_128347_("BlockDamage", 0.2 * CNT6);
            BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            entity.getPersistentData().m_128347_("y_knockback", (double)0.0F);
            ParticleGeneratorCircleProcedure.execute(world, (double)10.0F, (double)90.0F, dis, dis, (double)0.5F, x_pos, x_pos, y_pos, y_pos + (double)1.0F, (double)0.0F, z_pos, z_pos, "minecraft:sculk_soul");
            ParticleGeneratorCircleProcedure.execute(world, (double)10.0F, (double)90.0F, dis, dis, (double)1.5F, x_pos, x_pos, y_pos, y_pos + (double)1.0F, (double)0.0F, z_pos, z_pos, "minecraft:squid_ink");

            for(int index3 = 0; index3 < 10; ++index3) {
               dis = Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)6.0F);
               ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, dis, dis, (double)0.5F, x_pos, x_pos, y_pos, y_pos + (double)1.0F, (double)0.0F, z_pos, z_pos, "minecraft:soul");
               dis = Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)6.0F);
               ParticleGeneratorCircleProcedure.execute(world, (double)2.0F, (double)90.0F, dis, dis, (double)1.5F, x_pos, x_pos, y_pos, y_pos + (double)1.0F, (double)0.0F, z_pos, z_pos, "minecraft:squid_ink");
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)30.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
