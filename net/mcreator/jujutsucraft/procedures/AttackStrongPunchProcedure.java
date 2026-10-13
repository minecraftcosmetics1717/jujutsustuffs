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
            double x_pos = 0.0D;
            double y_pos = 0.0D;
            double z_pos = 0.0D;
            double HP = 0.0D;
            double yaw = 0.0D;
            double pitch = 0.0D;
            double dis = 0.0D;
            double strength = 0.0D;
            double range = 0.0D;
            double loop_num = 0.0D;
            double CNT6 = 0.0D;
            double entity_size = 0.0D;
            double weapon_size = 0.0D;
            double attack_reach = 0.0D;
            double d = 0.0D;
            double effectConfirm = 0.0D;
            ItemStack item_a = ItemStack.EMPTY;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0D);
            var10001 = entity.getPersistentData().getDouble("cnt6");
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)entity;
               if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                  var10002 = 0.3;
                  break label160;
               }
            }

            var10002 = 0.2;
         }

         double var67;
         int var10000;
         label155: {
            var67 = 1.0D + var10001 * var10002;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
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
         if (entity.getPersistentData().getDouble("cnt1") < 8.0D) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 3, false, false));
               }
            }

            entity.getPersistentData().putDouble("Damage", 5.0D);
            DamageFixProcedure.execute(entity);
         } else {
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0D);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 2, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") == 1.0D) {
               double var55 = Math.toRadians((double)(entity.getYRot() + 90.0F));
               double var57 = Math.toRadians((double)entity.getXRot());
               double var59 = 2.5D * var62;
               double var46 = entity.getX() + Math.cos(var55) * Math.cos(var57) * var59;
               double var49 = entity.getY() + (double)entity.getBbHeight() * 0.75D + Math.sin(var57) * -1.0D * var59;
               double var52 = entity.getZ() + Math.sin(var55) * Math.cos(var57) * var59;
               ItemStack var89;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var89 = _livEnt.getMainHandItem();
               } else {
                  var89 = ItemStack.EMPTY;
               }

               ItemStack var73 = var89.copy();
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_ATTACK_STRIKE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(var46, var49, var52), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
                     }

                     entityinstance.setPos(var46, var49, var52);
                     if (entityinstance instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                        _serverPlayer.connection.teleport(var46, var49, var52, entityinstance.getYRot(), entityinstance.getXRot());
                     }

                     entityinstance.setYRot(entity.getYRot());
                     entityinstance.setXRot(entity.getXRot());
                     entityinstance.setYHeadRot(entityinstance.getYRot());
                     entityinstance.setYBodyRot(entityinstance.getYRot());
                     entityinstance.yRotO = entityinstance.getYRot();
                     entityinstance.xRotO = entityinstance.getXRot();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     entityinstance.getPersistentData().putString("color3", var73.getTag().getString("color3"));
                     if (entityinstance instanceof EntityAttackStrikeEntity) {
                        EntityAttackStrikeEntity animatable = (EntityAttackStrikeEntity)entityinstance;
                        animatable.setTexture(var73.getTag().getString("slash_color").isEmpty() ? "slash_white" : var73.getTag().getString("slash_color"));
                     }

                     if (entityinstance instanceof EntityAttackStrikeEntity) {
                        PlayAnimationEntity2Procedure.execute(entityinstance, "idle3");
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity38 = (LivingEntity)entityinstance;
                        if (_livingEntity38.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity38.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(2.0D * var62);
                        }
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               if (var73.is(ItemTags.create(new ResourceLocation("forge:spear")))) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(var62 * 1.0D), (float)(0.9 / (var68 + var73.getTag().getDouble("Power"))));
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(var62 * 1.0D), (float)(0.9 / (var68 + var73.getTag().getDouble("Power"))), false);
                     }
                  }
               } else if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)(var62 * 0.25D), (float)(0.9 / (var68 + var73.getTag().getDouble("Power"))));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)(var62 * 0.25D), (float)(0.9 / (var68 + var73.getTag().getDouble("Power"))), false);
                  }
               }

               double var90;
               label142: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity45 = (LivingEntity)entity;
                     if (_livingEntity45.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        var90 = _livingEntity45.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).getBaseValue();
                        break label142;
                     }
                  }

                  var90 = 0.0D;
               }

               if (var90 == 0.0D) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity46 = (LivingEntity)entity;
                     if (_livingEntity46.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity46.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-6.0D);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity47 = (LivingEntity)entity;
                     if (_livingEntity47.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity47.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0D);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
                  if (entity instanceof GeoEntity) {
                     if (GetEntityAnimationProcedure.execute(entity).equals("empty") && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                     }
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }
               }

               entity.getPersistentData().putDouble("x_pos", x);
               entity.getPersistentData().putDouble("y_pos", Math.max(y, entity.getY() + (double)entity.getBbHeight() * 0.75D));
               entity.getPersistentData().putDouble("z_pos", z);
               entity.getPersistentData().putDouble("x_power", entity.getDeltaMovement().x * 0.5D * var62);
               entity.getPersistentData().putDouble("y_power", entity.getDeltaMovement().y * 0.5D * var62);
               entity.getPersistentData().putDouble("z_power", entity.getDeltaMovement().z * 0.5D * var62);
               double var66 = Math.max(11.0D * var70, 1.0D);

               for(int index0 = 0; index0 < (int)var66; ++index0) {
                  entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos") + entity.getPersistentData().getDouble("x_power"));
                  entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + entity.getPersistentData().getDouble("y_power"));
                  entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos") + entity.getPersistentData().getDouble("z_power"));
                  var46 = entity.getPersistentData().getDouble("x_pos");
                  var49 = entity.getPersistentData().getDouble("y_pos");
                  var52 = entity.getPersistentData().getDouble("z_pos");
                  entity.getPersistentData().putDouble("Damage", 11.0D * var67);
                  entity.getPersistentData().putDouble("knockback", 1.5D * (1.0D + entity.getPersistentData().getDouble("cnt6") * 0.1));
                  entity.getPersistentData().putDouble("Range", 2.0D * var62);
                  entity.getPersistentData().putDouble("effect", 5.0D);
                  entity.getPersistentData().putDouble("projectile_type", 1.0D);
                  entity.getPersistentData().putBoolean("attack", true);
                  RangeAttackProcedure.execute(world, var46, var49, var52, entity);
               }

               var55 = Math.toRadians((double)(entity.getYRot() + 90.0F));
               var57 = Math.toRadians((double)entity.getXRot());
               var68 = GetWeaponSizeProcedure.execute(entity);
               var70 = GetReachProcedure.execute(entity);
               var62 = ReturnEntitySizeProcedure.execute(entity);
               var62 = var62 * var62 * Math.sqrt(var68 * var70);
               var59 = 2.5D * var62;
               if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(var59)), Block.COLLIDER, Fluid.NONE, entity)).getType() == Type.BLOCK) {
                  var46 = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(var59)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getX();
                  var49 = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(var59)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getY();
                  var52 = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(var59)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getZ();
                  double var72 = Math.sqrt(entity.getPersistentData().getDouble("Damage"));
                  entity.getPersistentData().putDouble("BlockDamage", (0.1 + var61 / 16.0D) * Math.max(var72 * 0.25D, 1.0D));
                  entity.getPersistentData().putDouble("BlockRange", Math.max(1.0D * var62, Math.max(var72 * 0.5D, 1.0D)));
                  BlockDestroyAllDirectionProcedure.execute(world, var46, var49, var52, entity);
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 17.0D) {
               entity.getPersistentData().putDouble("skill", 0.0D);
            }
         }

         entity.getPersistentData().putBoolean("attack", true);
      }
   }
}