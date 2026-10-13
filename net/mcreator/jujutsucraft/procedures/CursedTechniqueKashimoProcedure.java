package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueKashimoProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = (double)0.0F;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == (double)703.0F) {
            KashimoRotateKickProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)704.0F) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)705.0F) {
            LightningStrikeProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)706.0F) {
            KashimoRotateKickProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)707.0F) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)710.0F) {
            TurnUpTheVolumeProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)715.0F) {
            TechniqueMythicalBeastAmberProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)716.0F) {
            TechniqueAhProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)717.0F) {
            TechniqueEnergyWave1Procedure.execute(world, x, y, z, entity);
         } else if (skill == (double)719.0F) {
            SkillKashimoKickProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)720.0F) {
            KashimoDomainProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)730.0F) {
            OtakeThunderProcedure.execute(world, entity);
         } else if (skill == (double)731.0F) {
            OtakeFlameProcedure.execute(world, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Kashimo"), false);
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
