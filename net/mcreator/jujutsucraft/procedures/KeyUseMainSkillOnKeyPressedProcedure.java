package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class KeyUseMainSkillOnKeyPressedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double p_skill1 = (double)0.0F;
         double old_select = (double)0.0F;
         double select = (double)0.0F;
         p_skill1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).SecondTechnique ? ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 : ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
         if (p_skill1 == (double)-1.0F) {
            int var10000;
            label189: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_();
                     break label189;
                  }
               }

               var10000 = 0;
            }

            select = (double)(var10000 > 0 ? 7 : 1);
         }

         if (p_skill1 == (double)1.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)2.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)3.0F) {
            select = (double)8.0F;
         } else if (p_skill1 == (double)4.0F) {
            select = (double)6.0F;
         } else if (p_skill1 == (double)5.0F) {
            select = (double)10.0F;
         }

         if (p_skill1 == (double)6.0F) {
            select = (double)4.0F;
         } else if (p_skill1 == (double)7.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)8.0F) {
            select = (double)7.0F;
         } else if (p_skill1 == (double)9.0F) {
            select = (double)10.0F;
         } else if (p_skill1 == (double)10.0F) {
            select = (double)6.0F;
         }

         if (p_skill1 == (double)11.0F) {
            select = (double)15.0F;
         } else if (p_skill1 == (double)12.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)13.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)14.0F) {
            select = (double)6.0F;
         } else if (p_skill1 == (double)15.0F) {
            select = (double)5.0F;
         }

         if (p_skill1 == (double)16.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)17.0F) {
            select = (double)6.0F;
         } else if (p_skill1 == (double)18.0F) {
            select = (double)10.0F;
         } else if (p_skill1 == (double)19.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)20.0F) {
            select = (double)5.0F;
         }

         if (p_skill1 == (double)21.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)22.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)23.0F) {
            select = (double)6.0F;
         } else if (p_skill1 == (double)24.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)25.0F) {
            select = (double)5.0F;
         }

         if (p_skill1 == (double)26.0F) {
            select = (double)11.0F;
         } else if (p_skill1 == (double)27.0F) {
            select = (double)20.0F;
         } else if (p_skill1 == (double)28.0F) {
            select = (double)15.0F;
         } else if (p_skill1 == (double)29.0F) {
            select = (double)6.0F;
         } else if (p_skill1 == (double)30.0F) {
            select = (double)5.0F;
         }

         if (p_skill1 == (double)31.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)32.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)33.0F) {
            select = (double)20.0F;
         } else if (p_skill1 == (double)34.0F) {
            select = (double)6.0F;
         } else if (p_skill1 == (double)35.0F) {
            select = (double)5.0F;
         }

         if (p_skill1 == (double)36.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)37.0F) {
            select = (double)10.0F;
         } else if (p_skill1 == (double)38.0F) {
            select = (double)10.0F;
         } else if (p_skill1 == (double)39.0F) {
            select = (double)8.0F;
         } else if (p_skill1 == (double)40.0F) {
            select = (double)5.0F;
         }

         if (p_skill1 == (double)41.0F) {
            select = (double)10.0F;
         } else if (p_skill1 == (double)42.0F) {
            select = (double)0.0F;
         } else if (p_skill1 == (double)43.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)44.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)45.0F) {
            select = (double)5.0F;
         }

         if (p_skill1 == (double)46.0F) {
            select = (double)10.0F;
         } else if (p_skill1 == (double)47.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)48.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)49.0F) {
            select = (double)5.0F;
         } else if (p_skill1 == (double)50.0F) {
            select = (double)5.0F;
         }

         boolean _setval = true;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.use_mainSkill = _setval;
            capability.syncPlayerVariables(entity);
         });
         old_select = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerSelectCurseTechnique = select;
            capability.syncPlayerVariables(entity);
         });
         _setval = true;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.noChangeTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == select) {
            KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         }

         _setval = false;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.use_mainSkill = _setval;
            capability.syncPlayerVariables(entity);
         });
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerSelectCurseTechnique = old_select;
            capability.syncPlayerVariables(entity);
         });
         _setval = true;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.noChangeTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
      }
   }
}
