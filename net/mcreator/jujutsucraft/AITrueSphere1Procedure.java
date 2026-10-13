package net.mcreator.jujutsucraft.procedures;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AITrueSphere1Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean attack = false;
         Entity entity_a = null;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_target = (double)0.0F;
         double y_target = (double)0.0F;
         double z_target = (double)0.0F;
         double yaw_cal = (double)0.0F;
         double pitch_cal = (double)0.0F;
         double move_power = (double)0.0F;
         double dis = (double)0.0F;
         double tick = (double)0.0F;
         double z_fix = (double)0.0F;
         double num1 = (double)0.0F;
         double x_fix = (double)0.0F;
         double y_fix = (double)0.0F;
         double old_distance = (double)0.0F;
         double distance = (double)0.0F;
         double num2 = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         dis = (double)(entity.m_20205_() * 1.0F);
         if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
            entity.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_());
            entity.getPersistentData().m_128347_("y_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_());
            entity.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());
            entity.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_pos") + entity.m_20154_().f_82479_);
            entity.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_pos") + entity.m_20154_().f_82480_);
            entity.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_pos") + entity.m_20154_().f_82481_);
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
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

                     double var102 = ((Entity)var10000).m_20186_();
                     LivingEntity var10001;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var102 + (double)((Entity)var10001).m_20206_() * (double)0.5F;
                     LivingEntity var103;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var103 = _mobEnt.m_5448_();
                     } else {
                        var103 = null;
                     }

                     z_pos = ((Entity)var103).m_20189_();
                  } else {
                     x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                     y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                     z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                  }

                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128347_("x_pos", x_pos);
                  entity.getPersistentData().m_128347_("y_pos", y_pos);
                  entity.getPersistentData().m_128347_("z_pos", z_pos);
                  entity.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_pos") + entity.m_20154_().f_82479_);
                  entity.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_pos") + entity.m_20154_().f_82480_);
                  entity.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_pos") + entity.m_20154_().f_82481_);
               }
            }

            logic_a = false;
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
            z_pos = entity.m_20189_();
            x_power = entity.m_20154_().f_82479_ * (double)4.0F;
            y_power = entity.m_20154_().f_82480_ * (double)4.0F;
            z_power = entity.m_20154_().f_82481_ * (double)4.0F;

            for(int index0 = 0; index0 < 10; ++index0) {
               x_pos += x_power;
               y_pos += y_power;
               z_pos += z_power;
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)5.0F), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     logic_a = true;
                     entity.getPersistentData().m_128347_("x_pos", entityiterator.m_20185_());
                     entity.getPersistentData().m_128347_("y_pos", entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F);
                     entity.getPersistentData().m_128347_("z_pos", entityiterator.m_20189_());
                     entity.getPersistentData().m_128347_("x_power", entityiterator.m_20185_());
                     entity.getPersistentData().m_128347_("y_power", entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F);
                     entity.getPersistentData().m_128347_("z_power", entityiterator.m_20189_());
                     break;
                  }
               }

               if (logic_a) {
                  break;
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            x_power = entity.m_20154_().f_82479_ * (double)1.0F;
            y_power = entity.m_20154_().f_82480_ * (double)1.0F;
            z_power = entity.m_20154_().f_82481_ * (double)1.0F;
            old_distance = (double)9999.0F;

            for(int index1 = 0; index1 < 2; ++index1) {
               distance = Math.sqrt(Math.pow(entity.m_20185_() - x_pos, (double)2.0F) + Math.pow(entity.m_20186_() - y_pos, (double)2.0F) + Math.pow(entity.m_20189_() - z_pos, (double)2.0F));
               if (distance > old_distance || distance < dis) {
                  entity.getPersistentData().m_128347_("cnt2", (double)2.0F);
                  entity.getPersistentData().m_128347_("cnt_bullet_hit", (double)15.0F);
                  BulletDomainHit2Procedure.execute(world, entity);
                  break;
               }

               logic_a = entity.m_5830_();
               entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_(), entity.m_20189_());
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
               }

               if (entity.m_5830_() && !logic_a) {
                  entity.m_6021_(entity.m_20185_() - x_power, entity.m_20186_(), entity.m_20189_());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_() - x_power, entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                  }
               }

               entity.m_6021_(entity.m_20185_(), entity.m_20186_() + y_power, entity.m_20189_());
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + y_power, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
               }

               if (entity.m_5830_() && !logic_a) {
                  entity.m_6021_(entity.m_20185_(), entity.m_20186_() - y_power, entity.m_20189_());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() - y_power, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                  }
               }

               entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + z_power);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
               }

               if (entity.m_5830_() && !logic_a) {
                  entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - z_power);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - z_power, entity.m_146908_(), entity.m_146909_());
                  }
               }

               old_distance = distance;
            }

            entity.getPersistentData().m_128347_("x_power", x_power);
            entity.getPersistentData().m_128347_("y_power", y_power);
            entity.getPersistentData().m_128347_("z_power", z_power);
         }

         if (entity.getPersistentData().m_128459_("cnt2") > (double)1.0F) {
            x_power = entity.getPersistentData().m_128459_("x_power") * (double)1.0F;
            y_power = entity.getPersistentData().m_128459_("y_power") * (double)1.0F;
            z_power = entity.getPersistentData().m_128459_("z_power") * (double)1.0F;

            for(int index2 = 0; index2 < 2; ++index2) {
               logic_a = entity.m_5830_();
               entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_(), entity.m_20189_());
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
               }

               if (entity.m_5830_() && !logic_a) {
                  entity.m_6021_(entity.m_20185_() - x_power, entity.m_20186_(), entity.m_20189_());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_() - x_power, entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                  }
               }

               entity.m_6021_(entity.m_20185_(), entity.m_20186_() + y_power, entity.m_20189_());
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + y_power, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
               }

               if (entity.m_5830_() && !logic_a) {
                  entity.m_6021_(entity.m_20185_(), entity.m_20186_() - y_power, entity.m_20189_());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() - y_power, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                  }
               }

               entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + z_power);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
               }

               if (entity.m_5830_() && !logic_a) {
                  entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - z_power);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - z_power, entity.m_146908_(), entity.m_146909_());
                  }
               }
            }

            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt2") > (double)10.0F) {
               entity.getPersistentData().m_128347_("move", (double)0.0F);
            }

            entity.getPersistentData().m_128347_("cnt_bullet_hit", (double)15.0F);
            BulletDomainHit2Procedure.execute(world, entity);
         }

      }
   }
}
