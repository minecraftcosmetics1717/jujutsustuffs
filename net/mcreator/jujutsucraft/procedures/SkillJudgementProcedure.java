package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillJudgementProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         Entity entity_b = null;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double num1 = (double)0.0F;
         double range = (double)0.0F;
         double pitch = (double)0.0F;
         double tick = (double)0.0F;
         double num2 = (double)0.0F;
         double num3 = (double)0.0F;
         boolean logic_a = false;
         boolean logic_b = false;
         boolean failed = false;
         ItemStack item_mainHand = ItemStack.f_41583_;
         entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt3") == (double)4.0F || entity.getPersistentData().m_128459_("cnt3") == (double)9.0F || entity.getPersistentData().m_128459_("cnt3") == (double)14.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity5 = (LivingEntity)entity;
               if (_livingEntity5.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity5.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-49.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity6 = (LivingEntity)entity;
               if (_livingEntity6.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity6.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt3") == (double)5.0F || entity.getPersistentData().m_128459_("cnt3") == (double)10.0F) {
            GetGavelProcedure.execute(world, x, y, z, entity);

            for(int index0 = 0; index0 < 5; ++index0) {
               ItemStack var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               item_mainHand = var10000.m_41777_();
               if (item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL.get()) {
                  break;
               }

               GavelRightClicked2Procedure.execute(world, x, y, z, entity);
            }

            ItemStack var47;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var47 = _livEnt.m_21205_();
            } else {
               var47 = ItemStack.f_41583_;
            }

            if (var47.m_41720_() == JujutsucraftModItems.GAVEL.get()) {
               if (entity instanceof Player && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gavel")), SoundSource.NEUTRAL, 1.5F, 1.25F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gavel")), SoundSource.NEUTRAL, 1.5F, 1.25F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity16 = (LivingEntity)entity;
                  if (_livingEntity16.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity16.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity17 = (LivingEntity)entity;
                  if (_livingEntity17.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity17.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)4.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }
         }

         int var48;
         label92: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var48 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label92;
               }
            }

            var48 = 0;
         }

         if (var48 < 200 && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               MobEffectInstance var10001;
               MobEffect var10003;
               int var10004;
               label83: {
                  var10001 = new MobEffectInstance;
                  var10003 = (MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var10004 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                        break label83;
                     }
                  }

                  var10004 = 0;
               }

               var10001.<init>(var10003, var10004 + 200, 0, false, false);
               _entity.m_7292_(var10001);
            }
         }

      }
   }
}
