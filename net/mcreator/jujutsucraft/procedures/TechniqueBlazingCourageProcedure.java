package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueBlazingCourageProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack getItem = ItemStack.f_41583_;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double distance = (double)0.0F;
         double rad1 = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity4 = (LivingEntity)entity;
               if (_livingEntity4.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity4.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)100.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 0.5F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 4, false, false));
               }
            }

            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            label88: {
               if (var10000.m_41720_() != ItemStack.f_41583_.m_41720_()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41720_() != JujutsucraftModItems.SWORD_OGI.get()) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.BLAZING_COURAGE.get())).m_41777_();
                        _setstack.m_41764_(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                     }
                     break label88;
                  }
               }

               getItem = (new ItemStack((ItemLike)JujutsucraftModItems.BLAZING_COURAGE.get())).m_41777_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               CompoundTag _nbtTag = var10000.m_41783_();
               if (_nbtTag != null) {
                  getItem.m_41751_(_nbtTag.m_6426_());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = getItem.m_41777_();
                  _setstack.m_41764_(1);
                  _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }
            }

            boolean _setval = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.noChangeTechnique = _setval;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         }

         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity.getPersistentData().m_128459_("cnt1") % (double)2.0F == (double)1.0F) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F, false);
               }
            }

            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F * Math.random();
            z_pos = entity.m_20189_();
            ParticleGeneratorCircleProcedure.execute(world, (double)36.0F * range, Mth.m_216263_(RandomSource.m_216327_(), (double)45.0F, (double)135.0F), (double)(entity.m_20205_() * 1.0F), (double)entity.m_20205_() * (double)0.5F + (double)1.5F, (double)3.0F, x_pos, x_pos, y_pos, y_pos, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F), z_pos, z_pos, "jujutsucraft:particle_curse_power_blue");
         }

         ParticleGeneratorCircleProcedure.execute(world, (double)8.0F * range, (double)90.0F, (double)0.5F * range, (double)0.75F * range, (double)12.0F * range, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random() * range, (double)0.0F, entity.m_20189_(), entity.m_20189_(), "jujutsucraft:particle_curse_power_blue");
         ParticleGeneratorCircleProcedure.execute(world, (double)8.0F * range, (double)90.0F, (double)0.0F * range, (double)8.0F * range, (double)12.0F * range, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random() * range, (double)0.0F, entity.m_20189_(), entity.m_20189_(), "jujutsucraft:particle_curse_power_blue");
         if (entity.getPersistentData().m_128459_("cnt1") > (double)10.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
