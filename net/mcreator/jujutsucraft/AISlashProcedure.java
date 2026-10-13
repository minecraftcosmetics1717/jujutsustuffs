package net.mcreator.jujutsucraft.procedures;

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

public class AISlashProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a;
         double num1;
         double var10000;
         label226: {
            Entity entity_a = null;
            boolean logic_attack = false;
            boolean skull = false;
            boolean flame = false;
            boolean granite = false;
            boolean energy_wave = false;
            logic_a = false;
            boolean vertical = false;
            double x_pos = (double)0.0F;
            double y_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double dis = (double)0.0F;
            double z_power = (double)0.0F;
            double y_power = (double)0.0F;
            double x_power = (double)0.0F;
            double speed = (double)0.0F;
            double CNT6 = (double)0.0F;
            double speed2 = (double)0.0F;
            double range_fix = (double)0.0F;
            double distance = (double)0.0F;
            double d = (double)0.0F;
            double range2 = (double)0.0F;
            double z_center = (double)0.0F;
            double range = (double)0.0F;
            double y_center = (double)0.0F;
            double yaw = (double)0.0F;
            double x_center = (double)0.0F;
            num1 = (double)0.0F;
            double pitch = (double)0.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity0 = (LivingEntity)entity;
               if (_livingEntity0.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  var10000 = _livingEntity0.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                  break label226;
               }
            }

            var10000 = (double)0.0F;
         }

         if (var10000 < entity.getPersistentData().m_128459_("size") && entity instanceof LivingEntity) {
            LivingEntity _livingEntity4 = (LivingEntity)entity;
            if (_livingEntity4.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
               double var10001;
               label217: {
                  var93 = _livingEntity4.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get());
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity2 = (LivingEntity)entity;
                     if (_livingEntity2.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        var10001 = _livingEntity2.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                        break label217;
                     }
                  }

                  var10001 = (double)0.0F;
               }

               var93.m_22100_(Math.min(var10001 + (double)0.5F, entity.getPersistentData().m_128459_("size")));
            }
         }

         double var59 = entity.m_20185_();
         double var60 = entity.m_20186_();
         double var61 = entity.m_20189_();
         double var66 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         double var72 = ReturnEntitySizeProcedure.execute(entity);
         double var69 = Math.max((double)1.0F, Math.sqrt(var72));
         GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
         boolean var58 = GetEntityAnimationProcedure.execute(entity).contains("vertical");
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         double var65;
         if (entity.getPersistentData().m_128471_("Stop")) {
            entity.getPersistentData().m_128379_("Stop", false);
            logic_a = true;
            var65 = (double)0.0F;
         } else {
            var65 = (double)2.0F;
         }

         for(int index0 = 0; index0 < (int)((double)6.0F * var72); ++index0) {
            ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)entity.m_146909_(), (double)0.0F * var72, Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.0F) * var72, (double)4.0F, entity.m_20185_() + entity.getPersistentData().m_128459_("x_power") * var72, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + entity.getPersistentData().m_128459_("y_power") * var72, entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, (double)entity.m_146908_(), entity.m_20189_() + entity.getPersistentData().m_128459_("z_power") * var72, entity.m_20189_(), "crit");
         }

         double var64 = entity.getPersistentData().m_128459_("x_power") * var65;
         double var63 = entity.getPersistentData().m_128459_("y_power") * var65;
         double var62 = entity.getPersistentData().m_128459_("z_power") * var65;
         entity.m_20256_(new Vec3(var64, var63, var62));
         double var67 = Math.sqrt(var64 * var64 + var63 * var63 + var62 * var62);
         if (var67 > (double)1.0F) {
            var64 /= var67;
            var63 /= var67;
            var62 /= var67;
         }

         for(int index1 = 0; index1 < (int)Math.max(var67, (double)1.0F); ++index1) {
            var59 = entity.m_20185_();
            var60 = entity.m_20186_();
            var61 = entity.m_20189_();
            ++num1;
            if (num1 > (double)0.0F) {
               num1 = (double)-1.5F * var72 + (double)1.0F;
               double var75;
               double var79;
               if (var58) {
                  var75 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  var79 = Math.toRadians((double)(entity.m_146909_() + 90.0F));
               } else {
                  var75 = Math.toRadians((double)(entity.m_146908_() + 0.0F));
                  var79 = Math.toRadians((double)0.0F);
               }

               var67 = (double)-1.5F * var72;

               for(int index2 = 0; index2 < 3; ++index2) {
                  double var77 = var59 + Math.cos(var75) * Math.cos(var79) * var67;
                  double var73 = var60 + Math.sin(var79) * (double)-1.0F * var67;
                  double var70 = var61 + Math.sin(var75) * Math.cos(var79) * var67;
                  entity.getPersistentData().m_128347_("Damage", (double)12.0F * var66);
                  entity.getPersistentData().m_128347_("Range", (double)4.0F * var72);
                  entity.getPersistentData().m_128347_("knockback", (double)0.5F);
                  entity.getPersistentData().m_128347_("effect", (double)1.0F);
                  RangeAttackProcedure.execute(world, var77, var73, var70, entity);
                  if (!logic_a) {
                     Vec3 _center = new Vec3(var77, var73, var70);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / (double)2.0F), (e) -> true)) {
                        if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_a = true;
                           break;
                        }
                     }
                  }

                  var67 += (double)1.5F * var72;
               }
            }

            entity.m_6021_(entity.m_20185_() + var64 * (double)1.0F, entity.m_20186_(), entity.m_20189_());
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + var64 * (double)1.0F, entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
            }

            if (entity.m_5830_() && ProjectileSlashInsideWallProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, var58)) {
               logic_a = true;
            }

            entity.m_6021_(entity.m_20185_(), entity.m_20186_() + var63 * (double)1.0F, entity.m_20189_());
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + var63 * (double)1.0F, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
            }

            if (entity.m_5830_() && ProjectileSlashInsideWallProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, var58)) {
               entity.m_6021_(entity.m_20185_(), entity.m_20186_() - var63 * (double)1.0F, entity.m_20189_());
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() - var63 * (double)1.0F, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
               }

               logic_a = true;
            }

            entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + var62 * (double)1.0F);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + var62 * (double)1.0F, entity.m_146908_(), entity.m_146909_());
            }

            if (entity.m_5830_() && ProjectileSlashInsideWallProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, var58)) {
               logic_a = true;
            }

            if (logic_a || ProjectileSlashInsideWallProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, var58)) {
               double var68 = Math.sqrt(entity.getPersistentData().m_128459_("Damage"));
               double var76;
               double var80;
               if (var58) {
                  var76 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  var80 = Math.toRadians((double)(entity.m_146909_() + 90.0F));
               } else {
                  var76 = Math.toRadians((double)(entity.m_146908_() + 0.0F));
                  var80 = Math.toRadians((double)0.0F);
               }

               var67 = (double)Math.round(Math.max((double)2.0F * var69, (double)1.0F) * (double)-1.0F);

               for(int index3 = 0; index3 < (int)Math.round(Math.max((double)2.0F * var69, (double)1.0F) * (double)2.0F + (double)1.0F); ++index3) {
                  double var78 = var59 + Math.cos(var76) * Math.cos(var80) * var67;
                  double var74 = var60 + Math.sin(var80) * (double)-1.0F * var67;
                  double var71 = var61 + Math.sin(var76) * Math.cos(var80) * var67;

                  for(int index4 = 0; index4 < (int)Math.max(Math.round(entity.getPersistentData().m_128459_("cnt6") + (double)1.0F), 1L); ++index4) {
                     entity.getPersistentData().m_128347_("BlockRange", Math.max((double)1.0F * var69, (double)1.0F));
                     entity.getPersistentData().m_128347_("BlockDamage", (double)1.0F + var68 * (double)0.5F);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     entity.getPersistentData().m_128379_("ExtinctionBlock", true);
                     BlockDestroyAllDirectionProcedure.execute(world, var78, var74, var71, entity);
                     entity.getPersistentData().m_128379_("noEffect", true);
                  }

                  ++var67;
               }
            }

            if (entity.m_5830_() && ProjectileSlashInsideWallProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, var58)) {
               logic_a = true;
            } else {
               logic_a = false;
            }
         }

         entity.getPersistentData().m_128379_("noEffect", false);
         if (logic_a || !entity.m_6084_() || var65 == (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") - (double)1.0F);
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(var59, var60, var61), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)((double)1.0F * var72), (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8, (double)1.0F));
               } else {
                  _level.m_7785_(var59, var60, var61, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)((double)1.0F * var72), (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8, (double)1.0F), false);
               }
            }

            for(int index5 = 0; index5 < (int)((double)8.0F * var72); ++index5) {
               ParticleGeneratorSweepingEffectProcedure.execute(world, (double)1.0F, var58 ? (double)0.0F : (double)180.0F, (double)entity.m_146909_() + (var58 ? (double)180.0F * Mth.m_216263_(RandomSource.m_216327_(), (double)-0.5F, (double)0.5F) : (double)0.0F), (double)0.5F * var72, (double)2.0F * var72, (double)0.0F, (double)4.0F, var59, var59, var60, var60, (double)entity.m_146908_(), var61, var61, "minecraft:crit");
            }
         }

         if ((entity.getPersistentData().m_128459_("cnt1") > (double)10.0F + Math.min(Math.max(entity.getPersistentData().m_128459_("cnt6"), (double)0.0F), (double)5.0F) || entity.getPersistentData().m_128459_("cnt2") > Math.max(Math.min(entity.getPersistentData().m_128459_("cnt6") + (double)5.0F, (double)15.0F), (double)1.0F)) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
         }

      }
   }
}
