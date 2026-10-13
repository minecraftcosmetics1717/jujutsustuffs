package net.mcreator.jujutsucraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ZonbaFallProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean SUCCESS;
         double distance;
         double dis;
         int var10000;
         label149: {
            SUCCESS = false;
            boolean logic_b = false;
            Entity entity_a = null;
            double strength = (double)0.0F;
            distance = (double)0.0F;
            double d = (double)0.0F;
            double range = (double)0.0F;
            double x_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double yaw = (double)0.0F;
            dis = (double)0.0F;
            double CNT6 = (double)0.0F;
            double y_power = (double)0.0F;
            double z_power = (double)0.0F;
            double x_power = (double)0.0F;
            double y_pos = (double)0.0F;
            double pitch = (double)0.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label149;
               }
            }

            var10000 = 0;
         }

         double var40 = (double)Math.min(var10000, 50);
         double var42 = ReturnEntitySizeProcedure.execute(entity);
         double var51 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         double var45 = entity.getPersistentData().m_128459_("x_pos");
         double var55 = entity.getPersistentData().m_128459_("y_pos");
         double var47 = entity.getPersistentData().m_128459_("z_pos");
         if (entity.getPersistentData().m_128459_("cnt1") < (double)15.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)10.0F) {
               LivingEntity var71;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var71 = _mobEnt.m_5448_();
               } else {
                  var71 = null;
               }

               Entity var39 = var71;
               if (var39 instanceof LivingEntity) {
                  entity.getPersistentData().m_128347_("x_pos", ((Entity)var39).m_20185_());
                  entity.getPersistentData().m_128347_("y_pos", ((Entity)var39).m_20186_() + (double)((Entity)var39).m_20206_());
                  entity.getPersistentData().m_128347_("z_pos", ((Entity)var39).m_20189_());
               } else {
                  dis = (double)6.0F;
                  double var49 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  double var57 = Math.toRadians((double)entity.m_146909_());

                  for(int index0 = 0; index0 < 8; ++index0) {
                     var45 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_();
                     var55 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_();
                     var47 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_();
                     Vec3 _center = new Vec3(var45, var55, var47);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)6.0F), (e) -> true)) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                           SUCCESS = true;
                           var45 = entityiterator.m_20185_();
                           var55 = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
                           var47 = entityiterator.m_20189_();
                           break;
                        }
                     }

                     if (SUCCESS) {
                        break;
                     }

                     dis += (double)6.0F;
                  }

                  entity.getPersistentData().m_128347_("x_pos", var45);
                  entity.getPersistentData().m_128347_("y_pos", var55);
                  entity.getPersistentData().m_128347_("z_pos", var47);
               }

               entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + (double)24.0F);
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var45, var55 - (double)8.0F, var47), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:flash ~ ~ ~ " + var42 * (double)1.0F + " 4 " + var42 * (double)1.0F + " 0 " + Math.round((double)10.0F * var42) + " force");
            }
         } else {
            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt1") <= (double)15.0F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(var45, var55, var47), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 4.0F, 1.0F);
                  } else {
                     _level.m_7785_(var45, var55, var47, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(var45, var55, var47), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, 4.0F, 0.5F);
                  } else {
                     _level.m_7785_(var45, var55, var47, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, 4.0F, 0.5F, false);
                  }
               }

               entity.getPersistentData().m_128347_("x_power", (double)0.0F);
               entity.getPersistentData().m_128347_("y_power", (double)-1.0F);
               entity.getPersistentData().m_128347_("z_power", (double)0.0F);
            }

            if (entity.getPersistentData().m_128459_("cnt1") < (double)20.0F) {
               var45 = entity.getPersistentData().m_128459_("x_pos");
               var55 = entity.getPersistentData().m_128459_("y_pos");
               var47 = entity.getPersistentData().m_128459_("z_pos");
               double var54 = entity.getPersistentData().m_128459_("x_power");
               double var52 = entity.getPersistentData().m_128459_("y_power");
               double var53 = entity.getPersistentData().m_128459_("z_power");
               var42 = ReturnEntitySizeProcedure.execute(entity) * var51 * var51 * var51;

               for(int index1 = 0; index1 < (int)(var42 * (double)12.0F); ++index1) {
                  ParticleGeneratorProcedure.execute(world, var42 * (double)1.0F, (double)5.0F, (double)1.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)6.0F), var45, var45 + var54, var55, var55 + var52, var47, var47 + var53, "end_rod");
               }

               var42 = ReturnEntitySizeProcedure.execute(entity) * (double)0.5F;

               for(int index2 = 0; index2 < (int)Math.min(entity.getPersistentData().m_128459_("cnt3") * (double)12.0F, (double)48.0F); ++index2) {
                  if (distance > (double)0.0F) {
                     distance = (double)2.0F * var42 * (double)-0.5F;
                     entity.getPersistentData().m_128347_("Damage", (double)15.0F * var51);
                     entity.getPersistentData().m_128347_("Range", (double)4.0F * var42);
                     entity.getPersistentData().m_128347_("knockback", (double)0.5F);
                     RangeAttackProcedure.execute(world, var45, var55, var47, entity);
                     Vec3 _center = new Vec3(var45, var55, var47);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / (double)2.0F), (e) -> true)) {
                        if (entity != entityiterator && entityiterator.m_6084_() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           boolean var38 = true;
                           break;
                        }
                     }
                  }

                  if (InsideSolidCalculateProcedure.execute(world, var45, var55, var47, (double)10.0F * var42, (double)10.0F * var42)) {
                     if (!InsideSolidCalculateProcedure.execute(world, var45 - var54, var55 - var52, var47 - var53, (double)10.0F * var42, (double)10.0F * var42)) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var45, var55, var47), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_big_smoke ~ ~ ~ " + var42 * (double)0.25F + " " + var42 * (double)0.25F + " " + var42 * (double)0.25F + " 1 " + Math.round((double)4.0F * var42) + " force");
                        }

                        ParticleGeneratorCircleProcedure.execute(world, (double)4.0F * var42, (double)90.0F, (double)0.0F * var42, (double)2.0F * var42, (double)2.0F, var45, var45, var55, var55 + var42 * (double)0.5F * Math.random(), (double)0.0F, var47, var47, "jujutsucraft:particle_big_smoke");
                     }

                     if (dis > (double)0.0F) {
                        dis = (double)2.0F * var42 * (double)-0.5F;
                        double var41 = Math.sqrt(entity.getPersistentData().m_128459_("Damage"));
                        entity.getPersistentData().m_128347_("BlockDamage", (double)8.0F * var51);
                        entity.getPersistentData().m_128347_("BlockRange", (double)4.0F * var42);
                        entity.getPersistentData().m_128379_("noParticle", true);
                        entity.getPersistentData().m_128379_("noEffect", true);
                        BlockDestroyAllDirectionProcedure.execute(world, var45, var55, var47, entity);
                     }
                  } else if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var45, var55, var47), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle flash ~ ~ ~ " + var42 * (double)0.25F + " " + var42 * (double)0.25F + " " + var42 * (double)0.25F + " 0 " + Math.round((double)4.0F * var42) + " force");
                  }

                  var45 += var54;
                  var55 += var52;
                  var47 += var53;
                  ++dis;
                  ++distance;
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F) {
            entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt5") > (double)2.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            } else {
               entity.getPersistentData().m_128347_("cnt1", (double)9.0F);
               entity.getPersistentData().m_128347_("cnt3", (double)0.0F);
            }
         }

      }
   }
}
