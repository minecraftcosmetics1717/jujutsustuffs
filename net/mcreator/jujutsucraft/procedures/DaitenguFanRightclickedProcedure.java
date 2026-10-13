package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class DaitenguFanRightclickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_a = ItemStack.f_41583_;
         double old_skill = (double)0.0F;
         double distance = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double dis = (double)0.0F;
         double CNT6 = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double entity_size = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == JujutsucraftModItems.DAITENGU_FAN.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            item_a = var10000.m_41777_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == JujutsucraftModItems.DAITENGU_FAN.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               item_a = var10000.m_41777_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.OFF_HAND, true);
               }
            }
         }

         if (item_a.m_41720_() == JujutsucraftModItems.DAITENGU_FAN.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity9 = (LivingEntity)entity;
               if (_livingEntity9.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity9.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-5.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity11 = (LivingEntity)entity;
               if (_livingEntity11.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity11.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)Mth.m_216271_(RandomSource.m_216327_(), 0, 1));
               }
            }

            label120: {
               PlayAnimationProcedure.execute(world, entity);
               if (entity instanceof Player) {
                  Player _plr = (Player)entity;
                  if (_plr.m_150110_().f_35937_) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_36335_().m_41524_(item_a.m_41720_(), 20);
                     }
                     break label120;
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_36335_().m_41524_(item_a.m_41720_(), 200);
               }
            }

            old_skill = entity.getPersistentData().m_128459_("skill");
            entity.getPersistentData().m_128347_("skill", (double)1.0F);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.75F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.5F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }

            entity_size = ReturnEntitySizeProcedure.execute(entity);
            CNT6 = (double)1.0F;
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            distance = (double)(1.0F + entity.m_20205_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
            x_power = entity.m_20154_().f_82479_;
            y_power = entity.m_20154_().f_82480_;
            z_power = entity.m_20154_().f_82481_;

            for(int index0 = 0; index0 < 16; ++index0) {
               x_pos += x_power;
               y_pos += y_power;
               z_pos += z_power;
               entity.getPersistentData().m_128347_("Damage", (double)15.0F);
               if (dis > (double)0.0F) {
                  for(int index1 = 0; index1 < (int)dis; ++index1) {
                     entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * 0.9);
                     if (entity.getPersistentData().m_128459_("Damage") < (double)10.0F) {
                        entity.getPersistentData().m_128347_("Damage", (double)10.0F);
                        break;
                     }
                  }
               }

               entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * CNT6);
               entity.getPersistentData().m_128347_("Range", (double)10.0F * CNT6 * entity_size);
               entity.getPersistentData().m_128347_("knockback", (double)1.0F * CNT6);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("BlockRange", (double)4.0F * CNT6 * entity_size);
               entity.getPersistentData().m_128347_("BlockDamage", (double)4.0F * CNT6);
               entity.getPersistentData().m_128379_("noEffect", true);
               entity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               ++dis;
            }

            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            distance = (double)(1.0F + entity.m_20205_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * distance;
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
            entity.getPersistentData().m_128347_("Damage", (double)18.0F * CNT6);
            entity.getPersistentData().m_128347_("Range", (double)16.0F * CNT6 * entity_size);
            entity.getPersistentData().m_128347_("knockback", (double)1.0F * CNT6);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            entity.getPersistentData().m_128347_("Range", (double)16.0F * CNT6 * entity_size);
            entity.getPersistentData().m_128347_("knockback", (double)1.0F * CNT6);
            KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)((double)10.0F * CNT6 * entity_size), (double)4.0F * entity_size, (double)4.0F * entity_size, (double)4.0F * entity_size, (double)1.0F);
            }

            for(int index2 = 0; index2 < (int)((double)36.0F * CNT6 * entity_size); ++index2) {
               ParticleGeneratorProcedure.execute(world, entity_size * 0.1, (double)1.0F, (double)35.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)4.0F, (double)8.0F), x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "minecraft:cloud");
            }

            entity.getPersistentData().m_128347_("skill", old_skill);
         }

      }
   }
}
