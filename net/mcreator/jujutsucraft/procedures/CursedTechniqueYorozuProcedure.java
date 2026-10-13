package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueYorozuProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = (double)0.0F;
         double skill = (double)0.0F;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - (double)3900.0F);
         if (skill == (double)5.0F) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)6.0F) {
            AttackSpeedProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)7.0F) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)8.0F) {
            TechniqueLiquidArrowProcedure.execute(world, entity);
         } else if (skill == (double)9.0F) {
            TechniqueNeedleProcedure.execute(world, entity);
         } else if (skill == (double)12.0F) {
            TechniqueLiquidMetalProcedure.execute(world, entity);
         } else if (skill == (double)14.0F) {
            TechniqueInsectArmorProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)15.0F) {
            TechniqueTrueSphereProcedure.execute(world, entity);
         } else if (skill == (double)20.0F) {
            ThreefoldAfflictionProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

         if (entity.getPersistentData().m_128459_("skill") == (double)0.0F && entity instanceof Player) {
            boolean _setval = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.noChangeTechnique = _setval;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
