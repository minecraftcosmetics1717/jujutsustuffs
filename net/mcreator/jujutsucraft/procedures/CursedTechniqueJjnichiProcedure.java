package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueJjnichiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = (double)0.0F;
         double skill = (double)0.0F;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - (double)2200.0F);
         if (skill == (double)4.0F) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)5.0F) {
            TechniqueFistSingleProcedure.execute(world, entity);
         } else if (skill == (double)6.0F) {
            FistGunProcedure.execute(world, entity);
         } else if (skill == (double)7.0F) {
            TechniqueFistProcedure.execute(world, entity);
         } else if (skill == (double)8.0F) {
            TechniqueFootProcedure.execute(world, entity);
         } else if (skill == (double)10.0F) {
            TechniqueFistMeteorProcedure.execute(world, entity);
         } else if (skill == (double)20.0F) {
            JinichiDomainProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Jinichi"), false);
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
