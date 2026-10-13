package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
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
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TechniqueNeedleProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean SUCCESS = false;
         double NUM2 = (double)0.0F;
         double HP = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double dis = (double)0.0F;
         double NUM1 = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 4, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity5 = (LivingEntity)entity;
            if (_livingEntity5.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity5.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)207.0F);
            }
         }

         PlayAnimationProcedure.execute(world, entity);
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
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
               }
            }

            EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
            Vec3 var10002 = new Vec3;
            LivingEntity var10004;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10004 = _mobEnt.m_5448_();
            } else {
               var10004 = null;
            }

            double var60 = ((Entity)var10004).m_20185_();
            LivingEntity var10005;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10005 = _mobEnt.m_5448_();
            } else {
               var10005 = null;
            }

            double var61 = ((Entity)var10005).m_20186_();
            LivingEntity var10006;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10006 = _mobEnt.m_5448_();
            } else {
               var10006 = null;
            }

            var61 += (double)((Entity)var10006).m_20206_() * (double)0.5F;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10006 = _mobEnt.m_5448_();
            } else {
               var10006 = null;
            }

            var10002.<init>(var60, var61, ((Entity)var10006).m_20189_());
            entity.m_7618_(var10001, var10002);
         }

         dis = (double)6.0F;

         for(int index0 = 0; index0 < 10; ++index0) {
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

         NUM1 = Math.random() * (double)720.0F;
         NUM2 = Math.random() * (double)3.0F;
         x_pos += Math.sin(Math.toRadians(NUM1)) * NUM2;
         z_pos += Math.cos(Math.toRadians(NUM1)) * NUM2;

         for(int index1 = 0; index1 < 255 && !(y_pos < (double)-64.0F); ++index1) {
            if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_() && !world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
               --y_pos;
            } else {
               if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + (double)1.0F, z_pos)).m_60815_() && !world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + (double)1.0F, z_pos)).m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
                  break;
               }

               ++y_pos;
            }
         }

         int var58;
         label200: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var58 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label200;
               }
            }

            var58 = 0;
         }

         HP = (double)(20 + var58 * 2);
         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftModEntities.NEEDLE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
            if (entityinstance != null) {
               entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               SetRangedAmmoProcedure.execute(entity, entityinstance);
               if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                  entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b}");
               }

               entityinstance.m_146922_((float)(NUM1 + (double)90.0F));
               entityinstance.m_146926_((float)(Math.random() * (double)20.0F));
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
                  LivingEntity _livingEntity40 = (LivingEntity)entityinstance;
                  if (_livingEntity40.m_21204_().m_22171_(Attributes.f_22276_)) {
                     _livingEntity40.m_21051_(Attributes.f_22276_).m_22100_(HP);
                  }
               }

               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  _entity.m_21153_((float)HP);
               }

               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _livingEntity47 = (LivingEntity)entityinstance;
                  if (_livingEntity47.m_21204_().m_22171_(Attributes.f_22281_)) {
                     label184: {
                        var52 = _livingEntity47.m_21051_(Attributes.f_22281_);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity44 = (LivingEntity)entityinstance;
                           if (_livingEntity44.m_21204_().m_22171_(Attributes.f_22281_)) {
                              var59 = _livingEntity44.m_21051_(Attributes.f_22281_).m_22115_();
                              break label184;
                           }
                        }

                        var59 = (double)0.0F;
                     }

                     var52.m_22100_(var59 + entity.getPersistentData().m_128459_("cnt1") * 0.02);
                  }
               }

               _serverLevel.m_7967_(entityinstance);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)10.0F) {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128379_("PRESS_Z", false);
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) > (double)6.0F) {
                  label255: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().m_128459_("skill") != (double)0.0F) {
                        label248: {
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
                                 break label248;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().m_128459_("Damage") != (double)0.0F) {
                              break label255;
                           }
                        }
                     }

                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  }
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               if (entity instanceof Player) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)1.0F;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            } else {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }

            if (entity.getPersistentData().m_128459_("cnt2") > (double)60.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
