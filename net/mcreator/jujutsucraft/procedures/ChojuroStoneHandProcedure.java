package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.JogoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ChojuroStoneHandProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean SUCCESS = false;
         Entity target = null;
         double picth = (double)0.0F;
         double HP = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double dis = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity var23 = var10000;
         if (var23 instanceof LivingEntity) {
            entity.m_7618_(Anchor.EYES, new Vec3(((Entity)var23).m_20185_(), ((Entity)var23).m_20186_() + (double)((Entity)var23).m_20206_() * (double)0.5F, ((Entity)var23).m_20189_()));
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)30.0F) {
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            picth = Math.toRadians((double)entity.m_146909_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(picth) * ((double)1.5F + (double)entity.m_20205_());
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.6 + Math.sin(picth) * (double)-1.0F * ((double)1.5F + (double)entity.m_20205_());
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(picth) * ((double)1.5F + (double)entity.m_20205_());
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 5, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               ChargeParticleProcedure.execute(world, entity, (double)1.0F);
            } else {
               entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }
               } else {
                  ChargeParticleProcedure.execute(world, entity, (double)0.0F);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)29.0F) {
               if (var23 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (GetDistanceNearestEnemyProcedure.execute(world, entity) > (double)8.0F && (((Entity)var23).getPersistentData().m_128459_("skill") == (double)0.0F || ((Entity)var23).getPersistentData().m_128459_("skill") != (double)0.0F && ((Entity)var23).getPersistentData().m_128471_("attack") || ((Entity)var23).getPersistentData().m_128459_("Damage") == (double)0.0F)) {
                     entity.getPersistentData().m_128379_("PRESS_Z", true);
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     entity.getPersistentData().m_128379_("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), (double)29.0F));
                  entity.getPersistentData().m_128347_("cnt2", Math.min(entity.getPersistentData().m_128459_("cnt2"), (double)0.0F));
               }
            } else {
               entity.getPersistentData().m_128347_("cnt2", Math.min(entity.getPersistentData().m_128459_("cnt2"), (double)0.0F));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") > (double)0.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 9, false, false));
               }
            }

            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt3") == (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof JogoEntity) {
                  PlayAnimationEntity2Procedure.execute(entity, "animation2");
               }

               dis = (double)6.0F;

               for(int index0 = 0; index0 < 5; ++index0) {
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

               if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
                  for(int index1 = 0; index1 < 255 && (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))); ++index1) {
                     ++y_pos;
                  }
               }

               for(int index2 = 0; index2 < 255; ++index2) {
                  if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
                     y_pos -= (double)12.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.05);
                     break;
                  }

                  --y_pos;
               }

               entity.getPersistentData().m_128347_("x_pos", x_pos);
               entity.getPersistentData().m_128347_("y_pos", y_pos);
               entity.getPersistentData().m_128347_("z_pos", z_pos);
               x_pos = entity.getPersistentData().m_128459_("x_pos");
               y_pos = entity.getPersistentData().m_128459_("y_pos");
               z_pos = entity.getPersistentData().m_128459_("z_pos");
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.NEUTRAL, 4.0F, 0.5F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.NEUTRAL, 4.0F, 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:stone_crash")), SoundSource.NEUTRAL, 4.0F, 0.5F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:stone_crash")), SoundSource.NEUTRAL, 4.0F, 0.5F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), x_pos, y_pos, z_pos, 10, (double)3.0F, (double)0.5F, (double)3.0F, (double)0.5F);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_HAND.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b}");
                     }

                     entityinstance.m_146922_(entity.m_146908_());
                     entityinstance.m_146926_(-90.0F);
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     label170: {
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity89 = (LivingEntity)entityinstance;
                           if (_livingEntity89.m_21204_().m_22171_(Attributes.f_22276_)) {
                              var51 = _livingEntity89.m_21051_(Attributes.f_22276_).m_22115_();
                              break label170;
                           }
                        }

                        var51 = (double)0.0F;
                     }

                     HP = var51 * (double)5.0F;
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity91 = (LivingEntity)entityinstance;
                        if (_livingEntity91.m_21204_().m_22171_(Attributes.f_22276_)) {
                           _livingEntity91.m_21051_(Attributes.f_22276_).m_22100_(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.m_21153_((float)HP);
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity96 = (LivingEntity)entityinstance;
                        if (_livingEntity96.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity96.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)1.25F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.05));
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var10001;
                           MobEffect var10003;
                           int var10005;
                           label158: {
                              var10001 = new MobEffectInstance;
                              var10003 = MobEffects.f_19606_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                    var10005 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                    break label158;
                                 }
                              }

                              var10005 = 0;
                           }

                           var10001.<init>(var10003, Integer.MAX_VALUE, var10005, false, false);
                           _entity.m_7292_(var10001);
                        }
                     }

                     entityinstance.getPersistentData().m_128347_("cnt6", (double)5.0F + entity.getPersistentData().m_128459_("cnt6"));
                     entityinstance.getPersistentData().m_128347_("x_power", (double)0.0F);
                     entityinstance.getPersistentData().m_128347_("y_power", (double)1.0F);
                     entityinstance.getPersistentData().m_128347_("z_power", (double)0.0F);
                     entityinstance.getPersistentData().m_128347_("move", (double)0.0F);
                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt3") > (double)30.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
