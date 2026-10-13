package net.mcreator.jujutsucraft.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AttackBeastProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double HP = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double level_jump = (double)0.0F;
         double level = (double)0.0F;
         double level_speed = (double)0.0F;
         double dis = (double)0.0F;
         double distance = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") % (double)20.0F == (double)5.0F && GetDistanceProcedure.execute(entity) > (double)6.0F) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               x_pos = ((Entity)var10000).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               double var50 = ((Entity)var10000).m_20186_();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               y_pos = var50 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
               LivingEntity var51;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var51 = _mobEnt.m_5448_();
               } else {
                  var51 = null;
               }

               z_pos = ((Entity)var51).m_20189_();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            } else if (!(entity instanceof Player)) {
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)16.0F), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     rotate = true;
                     x_pos = entityiterator.m_20185_();
                     y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
                     z_pos = entityiterator.m_20189_();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     break;
                  }
               }
            }

            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
            GetPowerFixProcedure.execute(entity);
            entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)0.75F, entity.getPersistentData().m_128459_("y_power") * (double)0.75F + (double)0.25F, entity.getPersistentData().m_128459_("z_power") * (double)0.75F));
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 5, 0.1, (double)0.0F, 0.1, (double)0.25F);
            }
         }

         entity.getPersistentData().m_128347_("Damage", (double)9.0F);
         entity.getPersistentData().m_128347_("Range", (double)(2.0F + entity.m_20206_()));
         entity.getPersistentData().m_128347_("knockback", Math.random() * (double)1.25F);
         entity.getPersistentData().m_128347_("effect", (double)8.0F);
         entity.getPersistentData().m_128379_("swing", true);
         entity.getPersistentData().m_128379_("attack", true);
         RangeAttackProcedure.execute(world, x, y + (double)entity.m_20206_() * (double)0.5F, z, entity);
         if (entity.getPersistentData().m_128459_("cnt1") > (double)40.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
