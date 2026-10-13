package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueMahoragaProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = (double)0.0F;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == (double)1604.0F) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1605.0F) {
            AttackSpeedProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1606.0F) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1607.0F) {
            TechniqueExplodeProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1608.0F) {
            StoneThrowingProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1609.0F) {
            MahoragaSwimmingProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1615.0F) {
            AttackOverheadSuperProcedure.execute(world, entity);
         } else if (skill == (double)1619.0F) {
            MahoragaCutTheWorldProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1620.0F) {
            OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Mahoraga"), false);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         }

      }
   }
}
