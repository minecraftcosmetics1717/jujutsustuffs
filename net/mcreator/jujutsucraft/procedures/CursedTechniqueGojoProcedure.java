package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueGojoProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = (double)0.0F;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == (double)205.0F) {
            InfinityProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)206.0F) {
            TechniqueBlueProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)207.0F) {
            TechniqueRedProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)208.0F) {
            TechniqueBluePunchProcedure.execute(world, entity);
         } else if (skill == (double)215.0F) {
            HollowPurpleProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)220.0F) {
            UnlimitedVoidProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Limitless"), false);
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
