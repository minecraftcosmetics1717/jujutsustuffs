package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class NanamiDomainExpansionActiveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double range = (double)0.0F;
         double dis = (double)0.0F;
         range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123809_, entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"), 2, dis * (double)0.25F, dis * (double)0.25F, dis * (double)0.25F, (double)0.0F);
         }

         int var10000;
         label56: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label56;
               }
            }

            var10000 = 0;
         }

         if (var10000 % 5 == 0) {
            Vec3 _center = new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"));

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / (double)2.0F), (e) -> true)) {
               if (entity != entityiterator && entityiterator instanceof LivingEntity && LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SPECIAL.get(), 10, 0, false, false));
                     }
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     Commands var15 = entity.m_20194_().m_129892_();
                     CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                     double var10002 = entityiterator.m_20185_();
                     var15.m_230957_(var10001, "particle jujutsucraft:particle_nanami_1 " + var10002 + " " + (entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F) + " " + entityiterator.m_20189_() + " " + (double)entityiterator.m_20205_() * (double)0.5F + " " + (double)entityiterator.m_20206_() * (double)0.5F + " " + (double)entityiterator.m_20205_() * (double)0.5F + " 0 " + Math.round(Math.sqrt((double)(entityiterator.m_20205_() + entityiterator.m_20206_()))) + " force @s");
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SPECIAL.get(), 10, 1, false, false));
               }
            }
         }

      }
   }
}
