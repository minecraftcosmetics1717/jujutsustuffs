package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import software.bernie.geckolib.animatable.GeoEntity;

public class PlayAnimationEntityGuardProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         boolean sword = false;
         String STR1 = "";
         double NUM1 = (double)0.0F;
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entityiterator;
            if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
               return;
            }
         }

         if (entityiterator.getPersistentData().m_128459_("skill") == (double)0.0F) {
            sword = LogicSwordProcedure.execute(entityiterator);
            if (sword && entity.getPersistentData().m_128459_("skill") != (double)0.0F && !entity.getPersistentData().m_128471_("attack")) {
               int var10000;
               label83: {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entityiterator;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                        var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                        break label83;
                     }
                  }

                  var10000 = 0;
               }

               if (var10000 > 10) {
                  sword = false;
               }
            }

            if (!(entityiterator instanceof Player) && !(entityiterator instanceof GeoEntity)) {
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }
            } else {
               if (entityiterator instanceof Player && entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (sword) {
                  if (entityiterator instanceof GeoEntity) {
                     STR1 = GetEntityAnimationProcedure.execute(entityiterator);
                     if (STR1.contains("_right")) {
                        NUM1 = (double)4.0F;
                     } else if (STR1.contains("_left")) {
                        NUM1 = (double)1.0F;
                     } else {
                        NUM1 = (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 6);
                     }
                  } else {
                     NUM1 = (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 6);
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity12 = (LivingEntity)entityiterator;
                     if (_livingEntity12.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity12.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)100.0F);
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity13 = (LivingEntity)entityiterator;
                     if (_livingEntity13.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity13.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(NUM1);
                     }
                  }
               } else {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity14 = (LivingEntity)entityiterator;
                     if (_livingEntity14.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity14.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-9.0F);
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity15 = (LivingEntity)entityiterator;
                     if (_livingEntity15.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity15.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                     }
                  }
               }

               PlayAnimationProcedure.execute(world, entityiterator);
            }
         }

      }
   }
}
