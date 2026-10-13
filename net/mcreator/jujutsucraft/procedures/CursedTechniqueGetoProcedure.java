package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueGetoProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = (double)0.0F;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == (double)1805.0F) {
            entity.getPersistentData().m_128347_("skill", (double)4110.0F);
         } else if (skill == (double)1810.0F) {
            GetoCancelTechniqueProcedure.execute(world, x, y, z, entity);
         } else if (skill >= (double)1811.0F && skill <= (double)1813.0F) {
            if (entity instanceof Player) {
               Test2Procedure.execute(world, x, y, z, entity);
            } else {
               GetoSpawnCurseRandomProcedure.execute(world, x, y, z, entity);
            }
         } else if (skill == (double)1815.0F) {
            SkillUzumakiProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1816.0F) {
            SkillUzumakiMiniProcedure.execute(world, x, y, z, entity);
         } else if (skill >= (double)1817.0F && skill <= (double)1819.0F) {
            GetoHappySetProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1820.0F) {
            WombProfusionProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Geto"), false);
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
