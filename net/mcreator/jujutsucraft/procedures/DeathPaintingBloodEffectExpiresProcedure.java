package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class DeathPaintingBloodEffectExpiresProcedure {
   public static void execute(Entity entity, double amplifier) {
      if (entity != null) {
         double num_level = (double)0.0F;
         if (amplifier > (double)0.0F && (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == (double)10.0F || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == (double)10.0F || entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting")))) && entity instanceof LivingEntity) {
            LivingEntity _livingEntity2 = (LivingEntity)entity;
            if (_livingEntity2.m_21204_().m_22171_(Attributes.f_22281_)) {
               AttributeInstance var10000;
               double var10001;
               label22: {
                  var10000 = _livingEntity2.m_21051_(Attributes.f_22281_);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity1 = (LivingEntity)entity;
                     if (_livingEntity1.m_21204_().m_22171_(Attributes.f_22281_)) {
                        var10001 = _livingEntity1.m_21051_(Attributes.f_22281_).m_22115_();
                        break label22;
                     }
                  }

                  var10001 = (double)0.0F;
               }

               var10000.m_22100_(var10001 - amplifier * 0.6);
            }
         }

      }
   }
}
