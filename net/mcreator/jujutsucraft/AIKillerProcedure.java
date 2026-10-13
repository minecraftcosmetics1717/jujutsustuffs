package net.mcreator.jujutsucraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AIKillerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         Entity entity_a = null;
         Entity owner_uuid = null;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
               Vec3 var10002 = new Vec3;
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               double var53 = ((Entity)var10004).m_20185_();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               double var56 = ((Entity)var10005).m_20186_();
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var56 += (double)((Entity)var10006).m_20206_() * (double)0.5F;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var10002.<init>(var53, var56, ((Entity)var10006).m_20189_());
               entity.m_7618_(var10001, var10002);
            }

            entity.getPersistentData().m_128347_("cnt_x2", entity.getPersistentData().m_128459_("cnt_x2") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt_x2") > (double)100.0F && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  ResetCounterProcedure.execute(entity);
                  CalculateAttackProcedure.execute(world, entity);
               }

               CompoundTag var45 = entity.getPersistentData();
               LivingEntity var49;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var49 = _mobEnt.m_5448_();
               } else {
                  var49 = null;
               }

               var45.m_128347_("x_pos", ((Entity)var49).m_20185_());
               var45 = entity.getPersistentData();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var49 = _mobEnt.m_5448_();
               } else {
                  var49 = null;
               }

               var45.m_128347_("y_pos", ((Entity)var49).m_20186_());
               var45 = entity.getPersistentData();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var49 = _mobEnt.m_5448_();
               } else {
                  var49 = null;
               }

               var45.m_128347_("z_pos", ((Entity)var49).m_20189_());
               x_pos = entity.getPersistentData().m_128459_("x_pos") - x;
               y_pos = entity.getPersistentData().m_128459_("y_pos") - y;
               z_pos = entity.getPersistentData().m_128459_("z_pos") - z;
               dis = Math.sqrt(Math.pow(x_pos, (double)2.0F) + Math.pow(y_pos, (double)2.0F) + Math.pow(z_pos, (double)2.0F));
               if (dis > (double)3.0F) {
                  x_pos = x_pos / dis * 0.2;
                  y_pos = y_pos / dis * 0.2;
                  z_pos = z_pos / dis * 0.2;
                  entity.m_6021_(entity.m_20185_() + x_pos, entity.m_20186_() + y_pos, entity.m_20189_() + z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_pos, entity.m_20186_() + y_pos, entity.m_20189_() + z_pos, entity.m_146908_(), entity.m_146909_());
                  }

                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  EntityAnchorArgument.Anchor var48 = Anchor.EYES;
                  Vec3 var52 = new Vec3;
                  LivingEntity var54;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var54 = _mobEnt.m_5448_();
                  } else {
                     var54 = null;
                  }

                  double var55 = ((Entity)var54).m_20185_();
                  LivingEntity var58;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var58 = _mobEnt.m_5448_();
                  } else {
                     var58 = null;
                  }

                  double var59 = ((Entity)var58).m_20186_();
                  LivingEntity var62;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var62 = _mobEnt.m_5448_();
                  } else {
                     var62 = null;
                  }

                  var59 += (double)((Entity)var62).m_20206_() * (double)0.5F;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var62 = _mobEnt.m_5448_();
                  } else {
                     var62 = null;
                  }

                  var52.<init>(var55, var59, ((Entity)var62).m_20189_());
                  entity.m_7618_(var48, var52);
               } else {
                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

         if (entity.getPersistentData().m_128471_("Shikigami")) {
            owner_uuid = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (owner_uuid instanceof LivingEntity) {
               if (!owner_uuid.m_6084_() && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
            }
         }

      }
   }
}
