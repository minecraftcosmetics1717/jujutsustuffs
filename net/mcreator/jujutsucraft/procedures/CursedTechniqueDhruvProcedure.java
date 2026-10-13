package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.ShikigamiHeterocephalusGlaberEntity;
import net.mcreator.jujutsucraft.entity.ShikigamiPterosaurEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CursedTechniqueDhruvProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = (double)0.0F;
         double skill = (double)0.0F;
         double NUM_SUM = (double)0.0F;
         double NUM_SUM_TRUE = (double)0.0F;
         double NUM1 = (double)0.0F;
         boolean old_sneak = false;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - (double)3700.0F);
         if (skill == (double)5.0F) {
            SkillDhruv1Procedure.execute(world, entity);
         } else if (skill == (double)6.0F) {
            SkillDhruv2Procedure.execute(world, entity);
         } else if (skill == (double)10.0F) {
            old_sneak = entity.m_6144_();
            entity.m_20260_(true);
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)128.0F), (e) -> true)) {
               if (entity != entityiterator && (entityiterator instanceof ShikigamiHeterocephalusGlaberEntity || entityiterator instanceof ShikigamiPterosaurEntity) && entity.m_20149_().equals(entityiterator.getPersistentData().m_128461_("OWNER_UUID"))) {
                  ShikigamiRightClickedOnEntityProcedure.execute(world, entityiterator, entity);
               }
            }

            entity.m_20260_(old_sneak);
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         } else if (skill == (double)20.0F) {
            OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

      }
   }
}
