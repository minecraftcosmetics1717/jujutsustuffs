package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.BulletEyeEntity;
import net.mcreator.jujutsucraft.entity.BulletToothEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;

public class HazenokiEyeProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21011_(InteractionHand.MAIN_HAND, true);
         }

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

            double var20 = ((Entity)var10000).m_20186_();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.m_5448_();
            } else {
               var10001 = null;
            }

            y_pos = var20 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
            LivingEntity var21;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var21 = _mobEnt.m_5448_();
            } else {
               var21 = null;
            }

            z_pos = ((Entity)var21).m_20189_();
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
         }

         Level projectileLevel = entity.m_9236_();
         if (!projectileLevel.m_5776_()) {
            Projectile _entityToSpawn = entity.getPersistentData().m_128459_("skill") == (double)4510.0F ? ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new BulletEyeEntity((EntityType)JujutsucraftModEntities.BULLET_EYE.get(), level);
                  entityToSpawn.m_5602_(shooter);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  entityToSpawn.m_36762_(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, entity, 0.0F, 0) : ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new BulletToothEntity((EntityType)JujutsucraftModEntities.BULLET_TOOTH.get(), level);
                  entityToSpawn.m_5602_(shooter);
                  entityToSpawn.m_36781_((double)damage);
                  entityToSpawn.m_36735_(knockback);
                  entityToSpawn.m_20225_(true);
                  entityToSpawn.m_36762_(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, entity, 0.0F, 0);
            _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1, entity.m_20189_());
            _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 3.0F, 0.0F);
            projectileLevel.m_7967_(_entityToSpawn);
         }

         entity.getPersistentData().m_128347_("skill", (double)0.0F);
      }
   }
}
