package net.mcreator.jujutsucraft.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class BulletCursePowerWhileBulletFlyingTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double old_skill = (double)0.0F;
         double num = (double)0.0F;
         double x_power = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double dis = (double)0.0F;
         double range = (double)0.0F;
         double old_cooldown = (double)0.0F;
         double energy_color = (double)0.0F;
         String str = "";
         String str2 = "";
         BulletDomainHitProcedure.execute(world, entity, immediatesourceentity);
         immediatesourceentity.getPersistentData().m_128347_("cnt_life", immediatesourceentity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") == (double)1.0F) {
            immediatesourceentity.m_20242_(true);
            immediatesourceentity.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
            immediatesourceentity.getPersistentData().m_128347_("COOLDOWN_TICKS", entity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
            if (immediatesourceentity.getPersistentData().m_128459_("skill") == (double)1415.0F) {
               immediatesourceentity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("cnt7"));
               immediatesourceentity.getPersistentData().m_128347_("cnt6", (double)1.0F + entity.getPersistentData().m_128459_("cnt7") * 0.03);
            } else {
               immediatesourceentity.getPersistentData().m_128347_("Damage", (double)13.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1));
               immediatesourceentity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
            }

            immediatesourceentity.getPersistentData().m_128347_("bullet_power", entity.getPersistentData().m_128459_("Damage"));
            immediatesourceentity.getPersistentData().m_128347_("old_x", immediatesourceentity.m_20185_() - immediatesourceentity.m_20184_().m_7096_());
            immediatesourceentity.getPersistentData().m_128347_("old_y", immediatesourceentity.m_20186_() - immediatesourceentity.m_20184_().m_7098_());
            immediatesourceentity.getPersistentData().m_128347_("old_z", immediatesourceentity.m_20189_() - immediatesourceentity.m_20184_().m_7094_());
            immediatesourceentity.getPersistentData().m_128347_("x_power", immediatesourceentity.m_20184_().m_7096_());
            immediatesourceentity.getPersistentData().m_128347_("y_power", immediatesourceentity.m_20184_().m_7098_());
            immediatesourceentity.getPersistentData().m_128347_("z_power", immediatesourceentity.m_20184_().m_7094_());
            if (immediatesourceentity.getPersistentData().m_128459_("skill") == (double)154.0F) {
               str = "minecraft:soul_fire_flame";
            } else {
               energy_color = ReturnEnergyColorProcedure.execute(entity);
               if (energy_color == (double)3.0F) {
                  str = "jujutsucraft:particle_curse_power_red";
               } else if (energy_color != (double)2.0F && immediatesourceentity.getPersistentData().m_128459_("skill") != (double)1415.0F) {
                  str = "jujutsucraft:particle_curse_power_blue";
               } else {
                  str = "jujutsucraft:particle_curse_power_orange";
               }
            }

            immediatesourceentity.getPersistentData().m_128359_("particle_id", str);
         }

         if (!immediatesourceentity.getPersistentData().m_128471_("Stop")) {
            x_power = immediatesourceentity.getPersistentData().m_128459_("x_power") - immediatesourceentity.m_20184_().m_7096_();
            y_power = immediatesourceentity.getPersistentData().m_128459_("y_power") - immediatesourceentity.m_20184_().m_7098_();
            z_power = immediatesourceentity.getPersistentData().m_128459_("z_power") - immediatesourceentity.m_20184_().m_7094_();
            x_power = immediatesourceentity.m_20184_().m_7096_() + Math.min(Math.abs(x_power), 0.2) * (double)(x_power > (double)0.0F ? 1 : -1);
            y_power = immediatesourceentity.m_20184_().m_7098_() + Math.min(Math.abs(y_power), 0.2) * (double)(y_power > (double)0.0F ? 1 : -1);
            z_power = immediatesourceentity.m_20184_().m_7094_() + Math.min(Math.abs(z_power), 0.2) * (double)(z_power > (double)0.0F ? 1 : -1);
            immediatesourceentity.m_20256_(new Vec3(x_power, y_power, z_power));
         } else {
            immediatesourceentity.getPersistentData().m_128379_("Stop", false);
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
         if (dis > (double)1.0F) {
            x_power /= dis;
            y_power /= dis;
            z_power /= dis;
         }

         str = immediatesourceentity.getPersistentData().m_128461_("particle_id");

         for(int index0 = 0; index0 < (int)Math.round(Math.max(dis * (double)4.0F, (double)1.0F)); ++index0) {
            ++num;
            if (num > (double)0.0F) {
               num = (double)-4.0F;
               entity.getPersistentData().m_128347_("Damage", immediatesourceentity.getPersistentData().m_128459_("Damage"));
               entity.getPersistentData().m_128347_("Range", (double)3.0F);
               entity.getPersistentData().m_128347_("knockback", (double)0.25F);
               if (immediatesourceentity.getPersistentData().m_128459_("skill") == (double)154.0F) {
                  entity.getPersistentData().m_128347_("effect", (double)10.0F);
               }

               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               AIBulletProcedure.execute();
            }

            ParticleGeneratorColorProcedure.execute(world, (double)1.0F, (double)1.0F, (double)5.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, Math.min((double)1.0F, dis)) * (double)2.0F, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, str);
            x_pos += x_power * (double)0.25F;
            y_pos += y_power * (double)0.25F;
            z_pos += z_power * (double)0.25F;
         }

         immediatesourceentity.getPersistentData().m_128347_("old_x", x);
         immediatesourceentity.getPersistentData().m_128347_("old_y", y);
         immediatesourceentity.getPersistentData().m_128347_("old_z", z);
         entity.getPersistentData().m_128347_("skill", old_skill);
         entity.getPersistentData().m_128347_("COOLDOWN_TICKS", old_cooldown);
         immediatesourceentity.getPersistentData().m_128347_("Damage", Math.max(immediatesourceentity.getPersistentData().m_128459_("Damage") * 0.99, (double)9.0F));
         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") > (double)20.0F && !immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}
