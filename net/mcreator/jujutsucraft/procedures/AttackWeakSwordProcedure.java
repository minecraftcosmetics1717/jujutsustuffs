package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.EntityAttackSlashEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;

public class AttackWeakSwordProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean combo = false;
         ItemStack item_a = ItemStack.f_41583_;
         double strength = (double)0.0F;
         double d = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double dis = (double)0.0F;
         double CNT6 = (double)0.0F;
         double old_cnt6 = (double)0.0F;
         double weapon_size = (double)0.0F;
         double attack_reach = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         String STR1 = "";
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") < (double)2.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 3, false, false));
               }
            }

            entity.getPersistentData().m_128347_("Damage", (double)4.0F);
            DamageFixProcedure.execute(entity);
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 2, false, false));
               }
            }

            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt6") < (double)0.0F) {
               CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            } else {
               double var10001;
               double var10002;
               label254: {
                  var10001 = entity.getPersistentData().m_128459_("cnt6");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt11 = (LivingEntity)entity;
                     if (_livEnt11.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                        var10002 = 0.3;
                        break label254;
                     }
                  }

                  var10002 = 0.2;
               }

               CNT6 = (double)1.0F + var10001 * var10002;
            }

            int var10000;
            label247: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label247;
                  }
               }

               var10000 = 0;
            }

            strength = (double)Math.min(var10000, 50) * CNT6;
            weapon_size = GetWeaponSizeProcedure.execute(entity);
            attack_reach = GetReachProcedure.execute(entity);
            range = ReturnEntitySizeProcedure.execute(entity);
            range = range * range * Math.sqrt(weapon_size * attack_reach);
            combo = entity.getPersistentData().m_128459_("cnt5") > (double)0.0F && entity.getPersistentData().m_128459_("cnt5") < (double)100.0F;
            if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
               if (entity instanceof GeoEntity) {
                  STR1 = GetEntityAnimationProcedure.execute(entity);
                  if (STR1.contains("_right")) {
                     if (combo) {
                        entity.getPersistentData().m_128347_("cnt4", (double)5.0F);
                     } else {
                        entity.getPersistentData().m_128347_("cnt4", (double)Mth.m_216271_(RandomSource.m_216327_(), 4, 6));
                     }
                  } else if (STR1.contains("_left")) {
                     if (combo) {
                        entity.getPersistentData().m_128347_("cnt4", (double)1.0F);
                     } else {
                        entity.getPersistentData().m_128347_("cnt4", (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 3));
                     }
                  } else if (combo) {
                     entity.getPersistentData().m_128347_("cnt4", (double)(Math.random() < (double)0.5F ? 1 : 5));
                  } else {
                     entity.getPersistentData().m_128347_("cnt4", (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 6));
                  }
               } else if (combo) {
                  entity.getPersistentData().m_128347_("cnt4", (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 6));
               } else {
                  entity.getPersistentData().m_128347_("cnt4", (double)(Math.random() < (double)0.5F ? 1 : 5));
               }

               label235: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity29 = (LivingEntity)entity;
                     if (_livingEntity29.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        var78 = _livingEntity29.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22115_();
                        break label235;
                     }
                  }

                  var78 = (double)0.0F;
               }

               if (var78 == (double)0.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity30 = (LivingEntity)entity;
                     if (_livingEntity30.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity30.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)100.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity32 = (LivingEntity)entity;
                     if (_livingEntity32.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity32.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(entity.getPersistentData().m_128459_("cnt4"));
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
                  if (entity instanceof GeoEntity) {
                     if (STR1.equals("empty") && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                     }
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }
               }

               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               dis = (double)2.5F * range;
               entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * dis);
               entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * dis);
               entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * dis);
               x_pos = entity.getPersistentData().m_128459_("x_pos");
               y_pos = entity.getPersistentData().m_128459_("y_pos");
               z_pos = entity.getPersistentData().m_128459_("z_pos");
               ItemStack var79;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var79 = _livEnt.m_21205_();
               } else {
                  var79 = ItemStack.f_41583_;
               }

               item_a = var79.m_41777_();
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_ATTACK_SLASH.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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

                     entityinstance.m_6021_(x_pos, y_pos, z_pos);
                     if (entityinstance instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                        _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entityinstance.m_146908_(), entityinstance.m_146909_());
                     }

                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
                     }

                     entityinstance.getPersistentData().m_128359_("color3", item_a.m_41784_().m_128461_("color3"));
                     if (entityinstance instanceof EntityAttackSlashEntity) {
                        EntityAttackSlashEntity animatable = (EntityAttackSlashEntity)entityinstance;
                        animatable.setTexture(item_a.m_41784_().m_128461_("slash_color").isEmpty() ? "slash_white" : item_a.m_41784_().m_128461_("slash_color"));
                     }

                     if (item_a.m_204117_(ItemTags.create(new ResourceLocation("forge:whip")))) {
                        if (entityinstance instanceof EntityAttackSlashEntity) {
                           CompoundTag var80 = entity.getPersistentData();
                           PlayAnimationEntity2Procedure.execute(entityinstance, "idle" + Math.round(var80.m_128459_("cnt4")) + "_whip");
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity71 = (LivingEntity)entityinstance;
                           if (_livingEntity71.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity71.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(Mth.m_216263_(RandomSource.m_216327_(), (double)2.0F, (double)4.0F) * range);
                           }
                        }

                        if (combo) {
                           entityinstance.m_146922_((float)((double)entity.m_146908_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-45.0F, (double)45.0F)));
                           entityinstance.m_146926_((float)((double)entity.m_146909_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-45.0F, (double)45.0F)));
                           entityinstance.m_5618_(entityinstance.m_146908_());
                           entityinstance.m_5616_(entityinstance.m_146908_());
                           entityinstance.f_19859_ = entityinstance.m_146908_();
                           entityinstance.f_19860_ = entityinstance.m_146909_();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }
                        }
                     } else {
                        if (entityinstance instanceof EntityAttackSlashEntity) {
                           CompoundTag var81 = entity.getPersistentData();
                           PlayAnimationEntity2Procedure.execute(entityinstance, "idle" + Math.round(var81.m_128459_("cnt4")));
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity82 = (LivingEntity)entityinstance;
                           if (_livingEntity82.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity82.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)3.0F * range);
                           }
                        }

                        if (combo) {
                           entityinstance.m_146922_((float)((double)entity.m_146908_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-22.5F, (double)22.5F)));
                           entityinstance.m_146926_((float)((double)entity.m_146909_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-22.5F, (double)22.5F)));
                           entityinstance.m_5618_(entityinstance.m_146908_());
                           entityinstance.m_5616_(entityinstance.m_146908_());
                           entityinstance.f_19859_ = entityinstance.m_146908_();
                           entityinstance.f_19860_ = entityinstance.m_146909_();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }
                        }
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * (double)1.0F), (float)((double)1.0F / (weapon_size + item_a.m_41784_().m_128459_("Power"))));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * (double)1.0F), (float)((double)1.0F / (weapon_size + item_a.m_41784_().m_128459_("Power"))), false);
                  }
               }

               if (item_a.m_204117_(ItemTags.create(new ResourceLocation("minecraft:swords"))) && !item_a.m_204117_(ItemTags.create(new ResourceLocation("minecraft:pickaxes"))) && (entity.getPersistentData().m_128459_("cnt5") >= (double)100.0F || entity.getPersistentData().m_128459_("cnt5") == (double)0.0F && entity.getPersistentData().m_128459_("cnt6") >= (double)2.5F) && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(range * (double)0.5F), (float)((double)1.0F / (weapon_size + item_a.m_41784_().m_128459_("Power"))));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(range * (double)0.5F), (float)((double)1.0F / (weapon_size + item_a.m_41784_().m_128459_("Power"))), false);
                  }
               }

               if ((item_a.m_204117_(ItemTags.create(new ResourceLocation("forge:metallic"))) || item_a.m_204117_(ItemTags.create(new ResourceLocation("forge:whip")))) && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * (double)1.0F), (float)((double)1.0F / (weapon_size + item_a.m_41784_().m_128459_("Power"))));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * (double)1.0F), (float)((double)1.0F / (weapon_size + item_a.m_41784_().m_128459_("Power"))), false);
                  }
               }

               entity.getPersistentData().m_128347_("Damage", (double)9.0F * CNT6);
               entity.getPersistentData().m_128347_("knockback", !combo ? (double)0.25F * ((double)1.0F + Math.max(entity.getPersistentData().m_128459_("cnt6"), (double)0.0F) * (double)0.5F) : 0.01);
               entity.getPersistentData().m_128347_("Range", (double)6.0F * range);
               entity.getPersistentData().m_128347_("effect", (double)5.0F);
               entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
               entity.getPersistentData().m_128379_("attack", true);
               old_cnt6 = entity.getPersistentData().m_128459_("cnt6");
               if (combo) {
                  entity.getPersistentData().m_128347_("cnt6", (double)-1.0F);
               }

               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("cnt6", old_cnt6);
               if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity)).m_6662_() == Type.BLOCK) {
                  x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123341_();
                  y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123342_();
                  z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123343_();
                  d = Math.sqrt(entity.getPersistentData().m_128459_("Damage"));
                  entity.getPersistentData().m_128347_("BlockDamage", (0.1 + strength / (double)16.0F) * Math.max(d * (double)0.25F, (double)1.0F));
                  entity.getPersistentData().m_128347_("BlockRange", Math.max((double)1.0F * range, Math.max(d * (double)0.5F, (double)1.0F)));
                  entity.getPersistentData().m_128347_("knockback", (double)0.25F * ((double)1.0F + Math.max(entity.getPersistentData().m_128459_("cnt6"), (double)0.0F) * (double)0.5F));
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") >= (double)10.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }

            entity.getPersistentData().m_128379_("attack", true);
         }

      }
   }
}
