package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class BloodFlyingTickEventProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double power = (double)0.0F;
         double repeat_num = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double old_skill = (double)0.0F;
         double old_cooldown = (double)0.0F;
         double damage = (double)0.0F;
         double num = (double)0.0F;
         BulletDomainHitProcedure.execute(world, entity, immediatesourceentity);
         immediatesourceentity.getPersistentData().m_128347_("cnt_life", immediatesourceentity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") == (double)1.0F) {
            immediatesourceentity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
            immediatesourceentity.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
            immediatesourceentity.getPersistentData().m_128347_("COOLDOWN_TICKS", entity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
            immediatesourceentity.getPersistentData().m_128347_("old_x", x - immediatesourceentity.m_20184_().m_7096_());
            immediatesourceentity.getPersistentData().m_128347_("old_y", y - immediatesourceentity.m_20184_().m_7098_());
            immediatesourceentity.getPersistentData().m_128347_("old_z", z - immediatesourceentity.m_20184_().m_7094_());
            immediatesourceentity.getPersistentData().m_128347_("speed", Math.sqrt(immediatesourceentity.m_20184_().m_7096_() * immediatesourceentity.m_20184_().m_7096_() + immediatesourceentity.m_20184_().m_7098_() * immediatesourceentity.m_20184_().m_7098_() + immediatesourceentity.m_20184_().m_7094_() * immediatesourceentity.m_20184_().m_7094_()));
            immediatesourceentity.getPersistentData().m_128347_("Damage", (double)15.0F * ((double)1.0F + immediatesourceentity.getPersistentData().m_128459_("cnt6") * 0.1));
            immediatesourceentity.m_20242_(true);
         }

         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") < (double)20.0F) {
            if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") < (double)5.0F && immediatesourceentity.getPersistentData().m_128459_("skill") == (double)1018.0F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x, y, z, 5, 0.1, 0.1, 0.1, (double)0.5F);
            }

            x_power = entity.m_20185_() - x;
            y_power = entity.m_20186_() - y;
            z_power = entity.m_20189_() - z;
            dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
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

               Level var81 = ((Entity)var10000).m_9236_();
               ClipContext var10001 = new ClipContext;
               LivingEntity var10003;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10003 = _mobEnt.m_5448_();
               } else {
                  var10003 = null;
               }

               Vec3 var88 = ((Entity)var10003).m_20299_(1.0F);
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               Vec3 var93 = ((Entity)var10004).m_20299_(1.0F);
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               var93 = var93.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_((double)0.0F));
               ClipContext.Block var101 = Block.OUTLINE;
               ClipContext.Fluid var10006 = Fluid.NONE;
               LivingEntity var10007;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var10001.<init>(var88, var93, var101, var10006, var10007);
               x_power = (double)var81.m_45547_(var10001).m_82425_().m_123341_() - x;
               LivingEntity var82;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var82 = _mobEnt.m_5448_();
               } else {
                  var82 = null;
               }

               Level var83 = ((Entity)var82).m_9236_();
               var10001 = new ClipContext;
               LivingEntity var89;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var89 = _mobEnt.m_5448_();
               } else {
                  var89 = null;
               }

               Vec3 var90 = ((Entity)var89).m_20299_(1.0F);
               LivingEntity var95;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var95 = _mobEnt.m_5448_();
               } else {
                  var95 = null;
               }

               Vec3 var96 = ((Entity)var95).m_20299_(1.0F);
               LivingEntity var102;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var102 = _mobEnt.m_5448_();
               } else {
                  var102 = null;
               }

               var96 = var96.m_82549_(((Entity)var102).m_20252_(1.0F).m_82490_((double)0.0F));
               ClipContext.Block var103 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var10001.<init>(var90, var96, var103, var10006, var10007);
               y_power = (double)var83.m_45547_(var10001).m_82425_().m_123342_() - y;
               LivingEntity var84;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var84 = _mobEnt.m_5448_();
               } else {
                  var84 = null;
               }

               Level var85 = ((Entity)var84).m_9236_();
               var10001 = new ClipContext;
               LivingEntity var91;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var91 = _mobEnt.m_5448_();
               } else {
                  var91 = null;
               }

               Vec3 var92 = ((Entity)var91).m_20299_(1.0F);
               LivingEntity var98;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var98 = _mobEnt.m_5448_();
               } else {
                  var98 = null;
               }

               Vec3 var99 = ((Entity)var98).m_20299_(1.0F);
               LivingEntity var104;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var104 = _mobEnt.m_5448_();
               } else {
                  var104 = null;
               }

               var99 = var99.m_82549_(((Entity)var104).m_20252_(1.0F).m_82490_((double)0.0F));
               ClipContext.Block var105 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var10001.<init>(var92, var99, var105, var10006, var10007);
               z_power = (double)var85.m_45547_(var10001).m_82425_().m_123343_() - z;
            } else {
               x_power = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis * (double)1.5F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_() - x;
               y_power = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis * (double)1.5F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() - y;
               z_power = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis * (double)1.5F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_() - z;
            }

            dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
            if (dis != (double)0.0F) {
               x_power = x_power / dis * (double)3.0F;
               y_power = y_power / dis * (double)3.0F;
               z_power = z_power / dis * (double)3.0F;
               if (immediatesourceentity.m_20184_().m_7096_() > x_power) {
                  x_power = immediatesourceentity.m_20184_().m_7096_() - 0.15;
               } else {
                  x_power = immediatesourceentity.m_20184_().m_7096_() + 0.15;
               }

               if (immediatesourceentity.m_20184_().m_7098_() > y_power) {
                  y_power = immediatesourceentity.m_20184_().m_7098_() - 0.15;
               } else {
                  y_power = immediatesourceentity.m_20184_().m_7098_() + 0.15;
               }

               if (immediatesourceentity.m_20184_().m_7094_() > z_power) {
                  z_power = immediatesourceentity.m_20184_().m_7094_() - 0.15;
               } else {
                  z_power = immediatesourceentity.m_20184_().m_7094_() + 0.15;
               }

               immediatesourceentity.m_20256_(new Vec3(x_power, y_power, z_power));
            }
         }

         old_skill = entity.getPersistentData().m_128459_("skill");
         old_cooldown = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
         entity.getPersistentData().m_128347_("skill", immediatesourceentity.getPersistentData().m_128459_("skill"));
         entity.getPersistentData().m_128347_("COOLDOWN_TICKS", immediatesourceentity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
         x_pos = immediatesourceentity.getPersistentData().m_128459_("old_x");
         y_pos = immediatesourceentity.getPersistentData().m_128459_("old_y");
         z_pos = immediatesourceentity.getPersistentData().m_128459_("old_z");
         x_power = x - x_pos;
         y_power = y - y_pos;
         z_power = z - z_pos;
         dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
         if (dis > (double)0.0F) {
            x_power /= dis;
            y_power /= dis;
            z_power /= dis;
         }

         damage = immediatesourceentity.getPersistentData().m_128459_("Damage");
         repeat_num = (double)Math.round(Math.max(dis * (double)5.0F, (double)1.0F));

         for(int index0 = 0; index0 < (int)repeat_num; ++index0) {
            ++dis;
            if (immediatesourceentity.getPersistentData().m_128459_("skill") == (double)1018.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle dust 0.471 0.000 0.000 1 ~ ~ ~ 0 0 0 1 1 force");
               }
            } else if (immediatesourceentity.getPersistentData().m_128459_("skill") == (double)2307.0F) {
               if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") > (double)2.0F) {
                  ParticleGeneratorProcedure.execute(world, 0.1, (double)1.0F, (double)25.0F, (double)0.5F, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, Math.random() < (double)0.25F ? "minecraft:squid_ink" : "jujutsucraft:particle_cockroach");
               }
            } else if (immediatesourceentity.getPersistentData().m_128459_("skill") == (double)3912.0F && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle dust 0.000 0.000 0.000 1 ~ ~ ~ 0 0 0 1 1 force");
            }

            if (dis > (double)0.0F) {
               dis = (double)-5.0F;
               entity.getPersistentData().m_128347_("Damage", damage);
               entity.getPersistentData().m_128347_("knockback", (double)0.5F);
               if (immediatesourceentity.getPersistentData().m_128459_("skill") == (double)1018.0F) {
                  entity.getPersistentData().m_128347_("Range", (double)0.0F);
                  entity.getPersistentData().m_128347_("effect", (double)11.0F);
               } else if (immediatesourceentity.getPersistentData().m_128459_("skill") == (double)2307.0F) {
                  entity.getPersistentData().m_128347_("Range", (double)4.0F);
                  entity.getPersistentData().m_128347_("effect", (double)1.0F);
               } else {
                  entity.getPersistentData().m_128347_("Range", (double)0.0F);
                  entity.getPersistentData().m_128347_("effect", (double)0.0F);
               }

               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               AIBulletProcedure.execute();
            }

            x_pos += x_power * 0.2;
            y_pos += y_power * 0.2;
            z_pos += z_power * 0.2;
         }

         immediatesourceentity.getPersistentData().m_128347_("old_x", x);
         immediatesourceentity.getPersistentData().m_128347_("old_y", y);
         immediatesourceentity.getPersistentData().m_128347_("old_z", z);
         entity.getPersistentData().m_128347_("skill", old_skill);
         entity.getPersistentData().m_128347_("COOLDOWN_TICKS", old_cooldown);
         immediatesourceentity.getPersistentData().m_128347_("Damage", Math.max(immediatesourceentity.getPersistentData().m_128459_("Damage") * 0.99, (double)9.0F));
         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") > (double)80.0F && !immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}
