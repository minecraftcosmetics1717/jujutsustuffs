package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class WeaponNanamiRightClickedInAirProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean success = false;
         Vec3 _center = new Vec3((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)6.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)6.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)6.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)6.0F), (e) -> true)) {
            if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
               success = true;
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SPECIAL.get(), 60, 0, false, false));
                  }
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  Commands var10000 = entity.m_20194_().m_129892_();
                  CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                  double var10002 = entityiterator.m_20185_();
                  var10000.m_230957_(var10001, "particle jujutsucraft:particle_nanami_1 " + var10002 + " " + (entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F) + " " + entityiterator.m_20189_() + " " + (double)entityiterator.m_20205_() * (double)0.5F + " " + (double)entityiterator.m_20206_() * (double)0.5F + " " + (double)entityiterator.m_20205_() * (double)0.5F + " 0 " + Math.round(Math.sqrt((double)(entityiterator.m_20205_() + entityiterator.m_20206_()))) + " force @s");
               }
            }
         }

         if (success && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SPECIAL.get(), 60, 1, false, false));
            }
         }

      }
   }
}
