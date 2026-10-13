package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.ProjectileSlashEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIProjectileSlashProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a;
         double num1;
         double var10000;
         label245: {
            logic_a = false;
            boolean vertical = false;
            Entity entity_a = null;
            double distance = (double)0.0F;
            double d = (double)0.0F;
            double range2 = (double)0.0F;
            double z_center = (double)0.0F;
            double range = (double)0.0F;
            double x_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double y_center = (double)0.0F;
            double speed = (double)0.0F;
            double yaw = (double)0.0F;
            double CNT6 = (double)0.0F;
            double y_power = (double)0.0F;
            double z_power = (double)0.0F;
            double x_center = (double)0.0F;
            double x_power = (double)0.0F;
            num1 = (double)0.0F;
            double y_pos = (double)0.0F;
            double pitch = (double)0.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity0 = (LivingEntity)entity;
               if (_livingEntity0.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  var10000 = _livingEntity0.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                  break label245;
               }
            }

            var10000 = (double)0.0F;
         }

         if (var10000 < entity.getPersistentData().m_128459_("size") && entity instanceof LivingEntity) {
            LivingEntity _livingEntity4 = (LivingEntity)entity;
            if (_livingEntity4.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
               double var10001;
               label236: {
                  var85 = _livingEntity4.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get());
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity2 = (LivingEntity)entity;
                     if (_livingEntity2.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        var10001 = _livingEntity2.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                        break label236;
                     }
                  }

                  var10001 = (double)0.0F;
               }

               var85.m_22100_(Math.min(var10001 + (double)0.5F, entity.getPersistentData().m_128459_("size")));
            }
         }

         boolean var47;
         double var50;
         double var53;
         double var54;
         double var55;
         double var58;
         double var61;
         double var67;
         label231: {
            var54 = entity.m_20185_();
            var67 = entity.m_20186_();
            var55 = entity.m_20189_();
            var61 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            var53 = ReturnEntitySizeProcedure.execute(entity);
            var50 = Math.max((double)1.0F, Math.sqrt(var53));
            GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            var47 = GetEntityAnimationProcedure.execute(entity).contains("vertical");
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity.getPersistentData().m_128471_("Stop")) {
               int var86;
               if (entity instanceof ProjectileSlashEntity) {
                  ProjectileSlashEntity _datEntI = (ProjectileSlashEntity)entity;
                  var86 = (Integer)_datEntI.m_20088_().m_135370_(ProjectileSlashEntity.DATA_mode);
               } else {
                  var86 = 0;
               }

               if (var86 != 1) {
                  entity.getPersistentData().m_128379_("Stop", false);
                  logic_a = true;
                  var58 = (double)0.0F;
                  break label231;
               }
            }

            var58 = (double)2.0F;
         }

         double var66 = entity.getPersistentData().m_128459_("x_power") * var58;
         double var62 = entity.getPersistentData().m_128459_("y_power") * var58;
         double var63 = entity.getPersistentData().m_128459_("z_power") * var58;
         entity.m_20256_(new Vec3(var66, var62, var63));
         double var48 = Math.sqrt(var66 * var66 + var62 * var62 + var63 * var63);
         if (var48 > (double)1.0F) {
            var66 /= var48;
            var62 /= var48;
            var63 /= var48;
         }

         for(int index0 = 0; index0 < (int)Math.max(var48, (double)1.0F); ++index0) {
            var54 = entity.m_20185_();
            var67 = entity.m_20186_();
            var55 = entity.m_20189_();
            ++num1;
            if (num1 > (double)0.0F) {
               num1 = (double)-1.5F * var53 + (double)1.0F;
               double var59;
               double var68;
               if (var47) {
                  var59 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  var68 = Math.toRadians((double)(entity.m_146909_() + 90.0F));
               } else {
                  var59 = Math.toRadians((double)(entity.m_146908_() + 0.0F));
                  var68 = Math.toRadians((double)0.0F);
               }

               var48 = (double)-3.0F * var53;

               for(int index1 = 0; index1 < 5; ++index1) {
                  double var64 = var54 + Math.cos(var59) * Math.cos(var68) * var48;
                  double var56 = var67 + Math.sin(var68) * (double)-1.0F * var48;
                  double var51 = var55 + Math.sin(var59) * Math.cos(var68) * var48;
                  entity.getPersistentData().m_128347_("Damage", (double)15.0F * var61);
                  entity.getPersistentData().m_128347_("Range", (double)3.0F * var53);
                  entity.getPersistentData().m_128347_("effect", (double)4.0F);
                  int var87;
                  if (entity instanceof ProjectileSlashEntity) {
                     ProjectileSlashEntity _datEntI = (ProjectileSlashEntity)entity;
                     var87 = (Integer)_datEntI.m_20088_().m_135370_(ProjectileSlashEntity.DATA_mode);
                  } else {
                     var87 = 0;
                  }

                  if (var87 == 1) {
                     entity.getPersistentData().m_128379_("ignore", true);
                     entity.getPersistentData().m_128347_("effectConfirm", (double)3.0F);
                     entity.getPersistentData().m_128347_("knockback", (double)0.5F);
                  } else {
                     entity.getPersistentData().m_128347_("knockback", (double)1.0F * var61 * Math.pow(0.95, entity.getPersistentData().m_128459_("cnt_life")));
                  }

                  RangeAttackProcedure.execute(world, var64, var56, var51, entity);
                  if (!logic_a) {
                     Vec3 _center = new Vec3(var64, var56, var51);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / (double)2.0F), (e) -> true)) {
                        if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_a = true;
                           break;
                        }
                     }
                  }

                  var48 += (double)1.5F * var53;
               }
            }

            entity.m_6021_(entity.m_20185_() + var66 * (double)1.0F, entity.m_20186_(), entity.m_20189_());
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + var66 * (double)1.0F, entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
            }

            if (entity.m_5830_() && ProjectileSlashInsideWallProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, var47)) {
               logic_a = true;
            }

            entity.m_6021_(entity.m_20185_(), entity.m_20186_() + var62 * (double)1.0F, entity.m_20189_());
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + var62 * (double)1.0F, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
            }

            if (entity.m_5830_() && ProjectileSlashInsideWallProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, var47)) {
               entity.m_6021_(entity.m_20185_(), entity.m_20186_() - var62 * (double)1.0F, entity.m_20189_());
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() - var62 * (double)1.0F, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
               }

               logic_a = true;
            }

            entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + var63 * (double)1.0F);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + var63 * (double)1.0F, entity.m_146908_(), entity.m_146909_());
            }

            if (entity.m_5830_() && ProjectileSlashInsideWallProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, var47)) {
               logic_a = true;
            }

            if (logic_a || ProjectileSlashInsideWallProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, var47)) {
               double var49 = Math.sqrt(entity.getPersistentData().m_128459_("Damage"));
               double var60;
               double var69;
               if (var47) {
                  var60 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  var69 = Math.toRadians((double)(entity.m_146909_() + 90.0F));
               } else {
                  var60 = Math.toRadians((double)(entity.m_146908_() + 0.0F));
                  var69 = Math.toRadians((double)0.0F);
               }

               var48 = (double)Math.round(Math.max((double)4.0F * var50, (double)1.0F) * (double)-2.0F);

               for(int index2 = 0; index2 < (int)Math.round(Math.max((double)4.0F * var50, (double)1.0F) * (double)4.0F + (double)1.0F); ++index2) {
                  double var65 = var54 + Math.cos(var60) * Math.cos(var69) * var48;
                  double var57 = var67 + Math.sin(var69) * (double)-1.0F * var48;
                  double var52 = var55 + Math.sin(var60) * Math.cos(var69) * var48;

                  for(int index3 = 0; index3 < (int)Math.max(Math.round(entity.getPersistentData().m_128459_("cnt6") + (double)1.0F), 1L); ++index3) {
                     entity.getPersistentData().m_128347_("BlockRange", Math.max((double)1.0F * var50, (double)1.0F));
                     entity.getPersistentData().m_128347_("BlockDamage", (double)1.0F + var49 * (double)0.5F);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     entity.getPersistentData().m_128379_("ExtinctionBlock", true);
                     BlockDestroyAllDirectionProcedure.execute(world, var65, var57, var52, entity);
                     entity.getPersistentData().m_128379_("noEffect", true);
                  }

                  ++var48;
               }
            }

            if (entity.m_5830_() && ProjectileSlashInsideWallProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, var47)) {
               logic_a = true;
               int var88;
               if (entity instanceof ProjectileSlashEntity) {
                  ProjectileSlashEntity _datEntI = (ProjectileSlashEntity)entity;
                  var88 = (Integer)_datEntI.m_20088_().m_135370_(ProjectileSlashEntity.DATA_mode);
               } else {
                  var88 = 0;
               }

               if (var88 != 1) {
                  break;
               }
            } else {
               logic_a = false;
            }
         }

         entity.getPersistentData().m_128379_("noEffect", false);
         if (logic_a || !entity.m_6084_() || var58 == (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") - (double)1.0F);
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var67, var55), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)((double)1.0F * var53), (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8, (double)1.0F));
               } else {
                  _level.m_7785_(var54, var67, var55, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)((double)1.0F * var53), (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8, (double)1.0F), false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(var54, var67, var55), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, (float)((double)0.5F * var53), (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.1));
               } else {
                  _level.m_7785_(var54, var67, var55, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, (float)((double)0.5F * var53), (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.1), false);
               }
            }

            for(int index4 = 0; index4 < (int)((double)8.0F * var53); ++index4) {
               ParticleGeneratorSweepingEffectProcedure.execute(world, (double)1.0F, var47 ? (double)0.0F : (double)180.0F, (double)entity.m_146909_() + (var47 ? (double)180.0F * Mth.m_216263_(RandomSource.m_216327_(), (double)-0.5F, (double)0.5F) : (double)0.0F), (double)0.5F * var53, (double)2.0F * var53, (double)0.0F, (double)4.0F, var54, var54, var67, var67, (double)entity.m_146908_(), var55, var55, "minecraft:crit");
            }
         }

         if ((entity.getPersistentData().m_128459_("cnt1") > (double)10.0F + Math.min(Math.max(entity.getPersistentData().m_128459_("cnt6"), (double)0.0F), (double)5.0F) || entity.getPersistentData().m_128459_("cnt2") > Math.max(Math.min(entity.getPersistentData().m_128459_("cnt6") + (double)5.0F, (double)15.0F), (double)1.0F)) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
         }

         entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
      }
   }
}
