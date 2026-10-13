package net.mcreator.jujutsucraft.procedures;

import java.util.Locale;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ParticleGeneratorColorProcedure {
   public static void execute(LevelAccessor world, double caliber_radius, double count, double inaccuracy, double speed, double x1, double x2, double y1, double y2, double z1, double z2, String id) {
      if (id != null) {
         double cosTheta = (double)0.0F;
         double dirZ = (double)0.0F;
         double dirY = (double)0.0F;
         double dirX = (double)0.0F;
         double dot = (double)0.0F;
         double spawnX = (double)0.0F;
         double spawnZ = (double)0.0F;
         double baseDist = (double)0.0F;
         double rad_inaccuracy = (double)0.0F;
         double spawnY = (double)0.0F;
         double maxCount = (double)0.0F;
         double dx = (double)0.0F;
         double dy = (double)0.0F;
         double dz = (double)0.0F;
         double cross2 = (double)0.0F;
         double cross3 = (double)0.0F;
         double cross1 = (double)0.0F;
         double rnd1 = (double)0.0F;
         double particle_velocity = (double)0.0F;
         double sinTheta = (double)0.0F;
         double rnd3 = (double)0.0F;
         double rDist = (double)0.0F;
         double rnd2 = (double)0.0F;
         double rIdx = (double)0.0F;
         double gIdx = (double)0.0F;
         double bIdx = (double)0.0F;
         String particleCmd = "";
         String particle_id = "";
         boolean isColorMode = false;
         particle_id = id;
         String[] colors = id.split(" ");
         if (colors.length >= 4) {
            particle_id = colors[0];
            rIdx = Double.parseDouble(colors[1]) * (double)100.0F * (double)1000.0F;
            gIdx = Double.parseDouble(colors[2]) * (double)100.0F * (double)1000.0F;
            bIdx = Double.parseDouble(colors[3]) * (double)100.0F * (double)1000.0F;
            isColorMode = true;
         }

         particle_velocity = speed;
         dx = x2 - x1;
         dy = y2 - y1;
         dz = z2 - z1;
         baseDist = Math.sqrt(dx * dx + dy * dy + dz * dz);
         if (baseDist != (double)0.0F) {
            dx /= baseDist;
            dy /= baseDist;
            dz /= baseDist;
         }

         rad_inaccuracy = Math.toRadians(inaccuracy * (double)0.5F);
         cosTheta = Math.cos(rad_inaccuracy);
         sinTheta = Math.sin(rad_inaccuracy);
         maxCount = Math.max(count, (double)1.0F);

         for(int index0 = 0; index0 < (int)maxCount; ++index0) {
            dirX = dx;
            dirY = dy;
            dirZ = dz;
            if (inaccuracy != (double)0.0F) {
               rnd1 = Math.random() - (double)0.5F;
               rnd2 = Math.random() - (double)0.5F;
               rnd3 = Math.random() - (double)0.5F;
               rDist = Math.sqrt(rnd1 * rnd1 + rnd2 * rnd2 + rnd3 * rnd3);
               if (rDist != (double)0.0F) {
                  rnd1 /= rDist;
                  rnd2 /= rDist;
                  rnd3 /= rDist;
               }

               cross1 = rnd2 * dz - rnd3 * dy;
               cross2 = rnd3 * dx - rnd1 * dz;
               cross3 = rnd1 * dy - rnd2 * dx;
               dot = rnd1 * dx + rnd2 * dy + rnd3 * dz;
               dirX = dx * cosTheta + cross1 * sinTheta + rnd1 * dot * ((double)1.0F - cosTheta);
               dirY = dy * cosTheta + cross2 * sinTheta + rnd2 * dot * ((double)1.0F - cosTheta);
               dirZ = dz * cosTheta + cross3 * sinTheta + rnd3 * dot * ((double)1.0F - cosTheta);
            }

            spawnX = x1 + caliber_radius * (Math.random() - (double)0.5F);
            spawnY = y1 + caliber_radius * (Math.random() - (double)0.5F);
            spawnZ = z1 + caliber_radius * (Math.random() - (double)0.5F);
            if (isColorMode) {
               dirX *= particle_velocity;
               dirY *= particle_velocity;
               dirZ *= particle_velocity;
               dirX += rIdx * (double)(dirX > (double)0.0F ? 1 : -1);
               dirY += gIdx * (double)(dirY > (double)0.0F ? 1 : -1);
               dirZ += bIdx * (double)(dirZ > (double)0.0F ? 1 : -1);
               particle_velocity = (double)1.0F;
            }

            particleCmd = String.format(Locale.US, "particle %s ~ ~ ~ %.4f %.4f %.4f %.4f 0 force", particle_id, dirX, dirY, dirZ, particle_velocity);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(spawnX, spawnY, spawnZ), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), particleCmd);
            }
         }

      }
   }
}
