package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.JujutsuSorcererEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class BuildVillageProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean boss_flag = false;
      boolean SUCCESS = false;
      double x_pos = (double)0.0F;
      double y_pos = (double)0.0F;
      double z_pos = (double)0.0F;
      double grade = (double)0.0F;
      double kind = (double)0.0F;
      double entity_height = (double)0.0F;
      double entity_width = (double)0.0F;
      double sx = (double)0.0F;
      double sy = (double)0.0F;
      double sz = (double)0.0F;

      for(int index0 = 0; index0 < 1; ++index0) {
         if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.JUJUTSU_SORCERER.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
            }
         }
      }

      for(int index1 = 0; index1 < 2; ++index1) {
         if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = EntityType.f_20492_.m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
            }
         }
      }

      Vec3 _center = new Vec3(x, y, z);

      for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)0.5F), (e) -> true)) {
         if (entityiterator instanceof JujutsuSorcererEntity && !entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
            entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "data merge entity @s {PersistenceRequired:1b}");
         }
      }

      if (world instanceof ServerLevel _level) {
         _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "spreadplayers ~ ~ 4 24 under " + Math.round(y + (double)8.0F) + " false @e[type=minecraft:villager,distance=..1]");
      }

      if (world instanceof ServerLevel _level) {
         _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "spreadplayers ~ ~ 4 24 under " + Math.round(y + (double)8.0F) + " false @e[type=jujutsucraft:jujutsu_sorcerer,distance=..1]");
      }

      if (world instanceof ServerLevel _level) {
         _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ air");
      }

   }
}
