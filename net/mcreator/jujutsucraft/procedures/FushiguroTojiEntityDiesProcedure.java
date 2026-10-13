package net.mcreator.jujutsucraft.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade37Entity;
import net.mcreator.jujutsucraft.entity.FushiguroTojiEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class FushiguroTojiEntityDiesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         if (world.m_6106_().m_5470_().m_46207_(GameRules.f_46135_)) {
            if (entity instanceof FushiguroTojiEntity) {
               rnd = Math.ceil(Math.random() * (double)3.0F);
               if (rnd == (double)1.0F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)JujutsucraftModItems.SPLIT_SOUL_KATANA.get()));
                     entityToSpawn.m_32010_(10);
                     _level.m_7967_(entityToSpawn);
                  }
               } else if (rnd == (double)2.0F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get()));
                     entityToSpawn.m_32010_(10);
                     _level.m_7967_(entityToSpawn);
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)JujutsucraftModItems.PLAYFUL_CLOUD.get()));
                  entityToSpawn.m_32010_(10);
                  _level.m_7967_(entityToSpawn);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)JujutsucraftModItems.PLAYFUL_CLOUD.get()));
               entityToSpawn.m_32010_(10);
               _level.m_7967_(entityToSpawn);
            }
         }

         if (entity instanceof FushiguroTojiEntity) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.CURSED_SPIRIT_GRADE_37.get()).m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               }
            }

            if (!world.m_6443_(CursedSpiritGrade37Entity.class, AABB.m_165882_(new Vec3(x, y, z), (double)4.0F, (double)4.0F, (double)4.0F), (e) -> true).isEmpty()) {
               Entity var22 = (Entity)world.m_6443_(CursedSpiritGrade37Entity.class, AABB.m_165882_(new Vec3(x, y, z), (double)4.0F, (double)4.0F, (double)4.0F), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                  Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                     return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                  }
               })).compareDistOf(x, y, z)).findFirst().orElse((Object)null);
               if (var22 instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)var22;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 5, 9, false, false));
                  }
               }
            }
         }

      }
   }
}
