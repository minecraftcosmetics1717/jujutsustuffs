package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueDagonProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = (double)0.0F;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == (double)805.0F) {
            DagonWaterSkillProcedure.execute(world, entity);
         } else if (skill == (double)806.0F) {
            DagonFish1Procedure.execute(world, x, y, z, entity);
         } else if (skill == (double)807.0F) {
            DagonFish2Procedure.execute(world, entity);
         } else if (skill == (double)809.0F) {
            DeathSwarmProcedure.execute(world, entity);
         } else if (skill == (double)810.0F) {
            SummonBathynomusProcedure.execute(world, entity);
         } else if (skill == (double)820.0F) {
            HorizonOfTheCaptivatingSkandhaProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Dagon"), false);
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
