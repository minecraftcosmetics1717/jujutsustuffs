package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.EntityAttackStrikeEntity;
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

public class AttackStrongPunchProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double var10001;
         double var10002;
         label160: {
            boolean logic_a = false;
            double x_pos = (double)0.0F;
            double y_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double HP = (double)0.0F;
            double yaw = (double)0.0F;
            double pitch = (double)0.0F;
            double dis = (double)0.0F;
            double strength = (double)0.0F;
            double range = (double)0.0F;
            double loop_num = (double)0.0F;
            double CNT6 = (double)0.0F;
            double entity_size = (double)0.0F;
            double weapon_size = (double)0.0F;
            double attack_reach = (double)0.0F;
            double d = (double)0.0F;
            double effectConfirm = (double)0.0F;
            ItemStack item_a = ItemStack.f_41583_;
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            var10001 = entity.getPersistentData().m_128459_("cnt6");
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)entity;
               if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                  var10002 = 0.3;
                  break label160;
               }
            }

            var10002 = 0.2;
         }

         double var67;
         int var10000;
         label155: {
            var67 = (double)1.0F + var10001 * var10002;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label155;
               }
            }

            var10000 = 0;
         }

         double var61 = (double)Math.min(var10000, 50) * var67;
         double var68 = GetWeaponSizeProcedure.execute(entity);
         double var70 = GetReachProcedure.execute(entity);
         double var62 = ReturnEntitySizeProcedure.execute(entity);
         var62 = var62 * var62 * var68;
         if (entity.getPersistentData().m_128459_("cnt1") < (double)8.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 3, false, false));
               }
            }

            entity.getPersistentData().m_128347_("Damage", (double)5.0F);
            DamageFixProcedure.execute(entity);
         } else {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 2, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
               double var55 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               double var57 = Math.toRadians((double)entity.m_146909_());
               double var59 = (double)2.5F * var62;
               double var46 = entity.m_20185_() + Math.cos(var55) * Math.cos(var57) * var59;
               double var49 = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(var57) * (double)-1.0F * var59;
               double var52 = entity.m_20189_() + Math.sin(var55) * Math.cos(var57) * var59;
               ItemStack var89;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var89 = _livEnt.m_21205_();
               } else {
                  var89 = ItemStack.f_41583_;
               }

               ItemStack var73 = var89.m_41777_();
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_ATTACK_STRIKE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(var46, var49, var52), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
                     }

                     entityinstance.m_6021_(var46, var49, var52);
                     if (entityinstance instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                        _serverPlayer.f_8906_.m_9774_(var46, var49, var52, entityinstance.m_146908_(), entityinstance.m_146909_());
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

                     entityinstance.getPersistentData().m_128359_("color3", var73.m_41784_().m_128461_("color3"));
                     if (entityinstance instanceof EntityAttackStrikeEntity) {
                        EntityAttackStrikeEntity animatable = (EntityAttackStrikeEntity)entityinstance;
                        animatable.setTexture(var73.m_41784_().m_128461_("slash_color").isEmpty() ? "slash_white" : var73.m_41784_().m_128461_("slash_color"));
                     }

                     if (entityinstance instanceof EntityAttackStrikeEntity) {
                        PlayAnimationEntity2Procedure.execute(entityinstance, "idle3");
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity38 = (LivingEntity)entityinstance;
                        if (_livingEntity38.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity38.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)2.0F * var62);
                        }
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (var73.m_204117_(ItemTags.create(new ResourceLocation("forge:spear")))) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(var62 * (double)1.0F), (float)(0.9 / (var68 + var73.m_41784_().m_128459_("Power"))));
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(var62 * (double)1.0F), (float)(0.9 / (var68 + var73.m_41784_().m_128459_("Power"))), false);
                     }
                  }
               } else if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)(var62 * (double)0.25F), (float)(0.9 / (var68 + var73.m_41784_().m_128459_("Power"))));
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)(var62 * (double)0.25F), (float)(0.9 / (var68 + var73.m_41784_().m_128459_("Power"))), false);
                  }
               }

               label142: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity45 = (LivingEntity)entity;
                     if (_livingEntity45.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        var90 = _livingEntity45.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22115_();
                        break label142;
                     }
                  }

                  var90 = (double)0.0F;
               }

               if (var90 == (double)0.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity46 = (LivingEntity)entity;
                     if (_livingEntity46.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity46.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-6.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity47 = (LivingEntity)entity;
                     if (_livingEntity47.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity47.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
                  if (entity instanceof GeoEntity) {
                     if (GetEntityAnimationProcedure.execute(entity).equals("empty") && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                     }
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }
               }

               entity.getPersistentData().m_128347_("x_pos", x);
               entity.getPersistentData().m_128347_("y_pos", Math.max(y, entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F));
               entity.getPersistentData().m_128347_("z_pos", z);
               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)0.5F * var62);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)0.5F * var62);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)0.5F * var62);
               double var66 = Math.max((double)11.0F * var70, (double)1.0F);

               for(int index0 = 0; index0 < (int)var66; ++index0) {
                  entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") + entity.getPersistentData().m_128459_("x_power"));
                  entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + entity.getPersistentData().m_128459_("y_power"));
                  entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") + entity.getPersistentData().m_128459_("z_power"));
                  var46 = entity.getPersistentData().m_128459_("x_pos");
                  var49 = entity.getPersistentData().m_128459_("y_pos");
                  var52 = entity.getPersistentData().m_128459_("z_pos");
                  entity.getPersistentData().m_128347_("Damage", (double)11.0F * var67);
                  entity.getPersistentData().m_128347_("knockback", (double)1.5F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1));
                  entity.getPersistentData().m_128347_("Range", (double)2.0F * var62);
                  entity.getPersistentData().m_128347_("effect", (double)5.0F);
                  entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                  entity.getPersistentData().m_128379_("attack", true);
                  RangeAttackProcedure.execute(world, var46, var49, var52, entity);
               }

               var55 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               var57 = Math.toRadians((double)entity.m_146909_());
               var68 = GetWeaponSizeProcedure.execute(entity);
               var70 = GetReachProcedure.execute(entity);
               var62 = ReturnEntitySizeProcedure.execute(entity);
               var62 = var62 * var62 * Math.sqrt(var68 * var70);
               var59 = (double)2.5F * var62;
               if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(var59)), Block.COLLIDER, Fluid.NONE, entity)).m_6662_() == Type.BLOCK) {
                  var46 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(var59)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123341_();
                  var49 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(var59)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123342_();
                  var52 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(var59)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123343_();
                  double var72 = Math.sqrt(entity.getPersistentData().m_128459_("Damage"));
                  entity.getPersistentData().m_128347_("BlockDamage", (0.1 + var61 / (double)16.0F) * Math.max(var72 * (double)0.25F, (double)1.0F));
                  entity.getPersistentData().m_128347_("BlockRange", Math.max((double)1.0F * var62, Math.max(var72 * (double)0.5F, (double)1.0F)));
                  BlockDestroyAllDirectionProcedure.execute(world, var46, var49, var52, entity);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)17.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
