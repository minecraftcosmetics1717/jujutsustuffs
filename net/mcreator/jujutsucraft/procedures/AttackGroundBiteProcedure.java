package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;

public class AttackGroundBiteProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double entity_height = (double)0.0F;
         double z_power = (double)0.0F;
         entity.f_19789_ = 0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity_height = (double)(entity.m_20206_() * 5.0F + 1.0F);
         if (entity.getPersistentData().m_128459_("cnt2") <= (double)2.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ATTACKING.get(), 2, 9, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
               if (entity.m_20096_()) {
                  entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
                  entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
                  entity.getPersistentData().m_128347_("y_pos", y);
               } else if (entity.getPersistentData().m_128459_("cnt1") > (double)200.0F) {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            } else if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
               entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
               entity.getPersistentData().m_128347_("cnt2", (double)2.0F);
            } else {
               entity.m_6021_(x, y - (double)0.5F, z);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(x, y - (double)0.5F, z, entity.m_146908_(), entity.m_146909_());
               }

               y_pos = y - (double)1.0F;

               for(int index0 = 0; index0 < (int)Math.round(entity_height) && !(y_pos > entity.getPersistentData().m_128459_("y_pos")); ++index0) {
                  if (world.m_8055_(BlockPos.m_274561_(x, y_pos, z)).m_60815_() && !world.m_8055_(BlockPos.m_274561_(x, y_pos + (double)1.0F, z)).m_60815_()) {
                     world.m_46796_(2001, BlockPos.m_274561_(x, y_pos + (double)0.5F, z), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x, y_pos, z))));
                     break;
                  }

                  ++y_pos;
               }

               if (y < entity.getPersistentData().m_128459_("y_pos") - entity_height) {
                  LivingEntity var10000;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     x_pos = ((Entity)var10000).m_20185_();
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     y_pos = ((Entity)var10000).m_20186_();
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     z_pos = ((Entity)var10000).m_20189_();
                  } else {
                     x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)16.0F)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
                     y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)16.0F)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
                     z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)16.0F)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
                  }

                  for(int index1 = 0; index1 < 255; ++index1) {
                     if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                        entity.getPersistentData().m_128347_("y_pos", y_pos);
                        y_pos -= entity_height;
                        break;
                     }

                     --y_pos;
                  }

                  entity.m_6021_(x_pos, y_pos, z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                  }

                  entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
                  entity.getPersistentData().m_128347_("cnt2", (double)3.0F);
               }
            }

            entity.getPersistentData().m_128347_("Damage", (double)6.0F);
            DamageFixProcedure.execute(entity);
         } else if (entity.getPersistentData().m_128459_("cnt2") == (double)3.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity43 = (LivingEntity)entity;
               if (_livingEntity43.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity43.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-3.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity44 = (LivingEntity)entity;
               if (_livingEntity44.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity44.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
            entity.m_6021_(x, y + (double)1.5F, z);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(x, y + (double)1.5F, z, entity.m_146908_(), entity.m_146909_());
            }

            y_pos = y;

            for(int index2 = 0; index2 < 6 && world.m_8055_(BlockPos.m_274561_(x, y_pos, z)).m_60815_(); ++index2) {
               if (!world.m_8055_(BlockPos.m_274561_(x, y_pos + (double)1.0F, z)).m_60815_() && world.m_8055_(BlockPos.m_274561_(x, y_pos, z)).m_60815_()) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x, y_pos, z, 5, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123813_, x, y_pos, z, 5, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.5F);
                  }

                  world.m_46796_(2001, BlockPos.m_274561_(x, y_pos + (double)0.5F, z), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x, y_pos, z))));
                  break;
               }

               --y_pos;
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.ATTACKING.get());
            }

            entity.getPersistentData().m_128347_("Damage", (double)14.0F);
            entity.getPersistentData().m_128347_("knockback", (double)1.5F);
            entity.getPersistentData().m_128347_("Range", (double)4.0F * ReturnEntitySizeProcedure.execute(entity));
            entity.getPersistentData().m_128347_("effect", (double)1.0F);
            entity.getPersistentData().m_128379_("attack", true);
            RangeAttackProcedure.execute(world, x, y + (double)1.5F, z, entity);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ATTACKING.get(), 2, 9, false, false));
               }
            }

            if (y > entity.getPersistentData().m_128459_("y_pos") + (double)2.0F) {
               entity.getPersistentData().m_128347_("cnt2", (double)4.0F);
            }
         } else {
            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt3") > (double)20.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

         entity.getPersistentData().m_128347_("Damage", (double)0.0F);
      }
   }
}
