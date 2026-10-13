package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueCrystalProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = (double)0.0F;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - (double)4700.0F);
         if (skill == (double)4.0F) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)5.0F) {
            CrystalRollProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)6.0F) {
            Crystal1Procedure.execute(world, x, y, z, entity);
         } else if (skill == (double)7.0F) {
            Crystal2Procedure.execute(world, x, y, z, entity);
         } else if (skill == (double)8.0F) {
            if (entity.getPersistentData().m_128459_("cnt10") == (double)0.0F) {
               AttackOverheadProcedure.execute(world, x, y, z, entity);
               if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt1", (double)1.0F);
                  entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
                  entity.getPersistentData().m_128347_("cnt10", (double)1.0F);
                  entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
                  entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
                  entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
                  entity.getPersistentData().m_128347_("skill", (double)4708.0F);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt10") != (double)0.0F) {
               Crystal3Procedure.execute(world, entity);
            }
         } else if (skill == (double)9.0F) {
            if (entity.getPersistentData().m_128459_("cnt10") == (double)0.0F) {
               AttackOverheadProcedure.execute(world, x, y, z, entity);
               if (entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt1", (double)1.0F);
                  entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
                  entity.getPersistentData().m_128347_("cnt10", (double)1.0F);
                  entity.getPersistentData().m_128347_("skill", (double)4709.0F);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt10") != (double)0.0F) {
               CrystalExplosionProcedure.execute(world, entity);
            }
         } else if (skill == (double)10.0F) {
            CrystalBreathProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)15.0F) {
            CrystalSelfExplosionProcedure.execute(world, entity);
         } else if (skill == (double)20.0F) {
            OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Ranta Crystal"), false);
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
