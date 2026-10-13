package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueMahitoProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = (double)0.0F;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == (double)1503.0F) {
            AttackSpeedProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1504.0F) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1505.0F) {
            IdleTransfigurationProcedure.execute(world, entity);
         } else if (skill == (double)1506.0F) {
            TechniqueMahitoHand3Procedure.execute(world, entity);
         } else if (skill == (double)1507.0F) {
            MahitoGunProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1508.0F) {
            TechniqueBodyRepelSingleProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1509.0F) {
            TechniqueBodyRepelProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1510.0F) {
            TechniquePolymorphicSoulIsomerProcedure.execute(world, entity);
         } else if (skill == (double)1515.0F) {
            InstantSpiritBodyofDistortedKillingProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1516.0F) {
            AttackStrongMahitoProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1520.0F) {
            SelfEmbodimentOfPerfectionProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Mahito"), false);
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
