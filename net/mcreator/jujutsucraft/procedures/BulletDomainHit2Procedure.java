package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BulletDomainHit2Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double range = (double)0.0F;
         double dis = (double)0.0F;
         Entity entity_a = null;
         entity.getPersistentData().m_128347_("cnt_bullet_hit", entity.getPersistentData().m_128459_("cnt_bullet_hit") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt_bullet_hit") > (double)1.0F) {
            entity.getPersistentData().m_128347_("cnt_bullet_hit", (double)-15.0F);
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged") && !entity_a.getPersistentData().m_128471_("Failed") && entity_a instanceof LivingEntity) {
                  LivingEntity _livEnt10 = (LivingEntity)entity_a;
                  if (_livEnt10.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     AABB var10002;
                     double var10003;
                     int var10004;
                     label46: {
                        Vec3 _center = new Vec3(entity_a.getPersistentData().m_128459_("x_pos_doma"), entity_a.getPersistentData().m_128459_("y_pos_doma"), entity_a.getPersistentData().m_128459_("z_pos_doma"));
                        var10002 = new AABB(_center, _center);
                        var10003 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity_a;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                              var10004 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                              break label46;
                           }
                        }

                        var10004 = 0;
                     }

                     for(Entity entityiterator : world.m_6443_(Entity.class, var10002.m_82400_(var10003 * (double)(var10004 > 0 ? 6 : 2) / (double)2.0F), (e) -> true)) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                           x_pos = entityiterator.m_20185_() + (double)entityiterator.m_20205_() * Mth.m_216263_(RandomSource.m_216327_(), (double)-0.5F, (double)0.5F);
                           y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)1.0F);
                           z_pos = entityiterator.m_20189_() + (double)entityiterator.m_20205_() * Mth.m_216263_(RandomSource.m_216327_(), (double)-0.5F, (double)0.5F);
                           entity.m_6021_(x_pos - entity.m_20184_().m_7096_(), y_pos - entity.m_20184_().m_7098_(), z_pos - entity.m_20184_().m_7094_());
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.f_8906_.m_9774_(x_pos - entity.m_20184_().m_7096_(), y_pos - entity.m_20184_().m_7098_(), z_pos - entity.m_20184_().m_7094_(), entity.m_146908_(), entity.m_146909_());
                           }

                           entity.m_7618_(Anchor.EYES, new Vec3(x_pos, y_pos, z_pos));
                           break;
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
