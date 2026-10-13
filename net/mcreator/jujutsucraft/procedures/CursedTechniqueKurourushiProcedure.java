package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueKurourushiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = (double)0.0F;
         double skill = (double)0.0F;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - (double)2300.0F);
         if (skill == (double)4.0F) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)5.0F) {
            Cockroach1Procedure.execute(world, x, y, z, entity);
         } else if (skill == (double)6.0F) {
            Cockroach2Procedure.execute(world, entity);
         } else if (skill == (double)7.0F) {
            Cockroach3Procedure.execute(world, x, y, z, entity);
         } else if (skill == (double)8.0F) {
            TechniqueEarthenInsectTranceProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)20.0F) {
            KurourushiDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)30.0F) {
            SummonRatProcedure.execute(world, entity);
         } else if (skill == (double)31.0F) {
            RatExplodeProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Kurourushi"), false);
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
