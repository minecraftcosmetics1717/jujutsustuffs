package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.BulletBloodProjectileEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AILiquidArrowProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean SUCCESS = false;
         double z_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double x_pos = (double)0.0F;
         double loop_num = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double CNT6 = (double)0.0F;
         double damage = (double)0.0F;
         double picth = (double)0.0F;
         double yaw2 = (double)0.0F;
         double pitch2 = (double)0.0F;
         double dis = (double)0.0F;
         double num1 = (double)0.0F;
         double num2 = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         num1 = Math.toRadians(Math.random() * (double)360.0F);
         num2 = (double)1.5F;

         for(int index0 = 0; index0 < 72; ++index0) {
            x_pos = x + Math.sin(num1) * num2;
            y_pos = y;
            z_pos = z + Math.cos(num1) * num2;
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_liquid_metal ~ ~ ~ 0.1 0.1 0.1 0 0 force");
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle dust 0.000 0.000 0.000 1 ~ ~ ~ 0.1 0.1 0.1 1 1 force");
            }

            num1 += Math.toRadians(Math.random() * (double)10.0F);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)10.0F) {
            if (LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
               if (entity_a instanceof LivingEntity) {
                  LivingEntity var10000;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     x_pos = ((Entity)var10000).m_20185_();
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     double var74 = ((Entity)var10000).m_20186_();
                     LivingEntity var10001;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var74 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
                     LivingEntity var75;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var75 = _mobEnt.m_5448_();
                     } else {
                        var75 = null;
                     }

                     z_pos = ((Entity)var75).m_20189_();
                  } else {
                     dis = (double)6.0F;

                     for(int index1 = 0; index1 < 8; ++index1) {
                        x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                        y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                        z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                        Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                        for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)6.0F), (e) -> true)) {
                           if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                              SUCCESS = true;
                              x_pos = entityiterator.m_20185_();
                              y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_();
                              z_pos = entityiterator.m_20189_();
                              break;
                           }
                        }

                        if (SUCCESS) {
                           break;
                        }

                        dis += (double)6.0F;
                     }
                  }

                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") <= (double)20.0F) {
               entity.getPersistentData().m_128347_("Damage", (double)1.5F);
               DamageFixProcedure.execute(entity);
               damage = entity.getPersistentData().m_128459_("Damage");
               yaw = (double)entity.m_146908_();
               picth = (double)entity.m_146909_();
               yaw2 = yaw + Mth.m_216263_(RandomSource.m_216327_(), (double)-45.0F, (double)45.0F);
               pitch2 = (double)0.0F;
               entity.m_146922_((float)yaw2);
               entity.m_146926_((float)pitch2);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               Level projectileLevel = entity.m_9236_();
               if (!projectileLevel.m_5776_()) {
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new BulletBloodProjectileEntity((EntityType)JujutsucraftModEntities.BULLET_BLOOD_PROJECTILE.get(), level);
                        entityToSpawn.m_5602_(shooter);
                        entityToSpawn.m_36781_((double)damage);
                        entityToSpawn.m_36735_(knockback);
                        entityToSpawn.m_20225_(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, entity, (float)damage, 0);
                  _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1, entity.m_20189_());
                  _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, 1.5F, 0.0F);
                  projectileLevel.m_7967_(_entityToSpawn);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               entity.m_146922_((float)yaw);
               entity.m_146926_((float)picth);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)40.0F) {
               entity.getPersistentData().m_128347_("move", (double)0.0F);
            }
         }

      }
   }
}
