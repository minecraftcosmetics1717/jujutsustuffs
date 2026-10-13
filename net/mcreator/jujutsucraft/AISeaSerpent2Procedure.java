package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.SeaSerpentEntity;
import net.mcreator.jujutsucraft.entity.SeaSerpentMiniEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AISeaSerpent2Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double z_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pwoer = (double)0.0F;
         double y_power = (double)0.0F;
         double x_power = (double)0.0F;
         double dis = (double)0.0F;
         double z_power = (double)0.0F;
         double speed = (double)0.0F;
         double CNT6 = (double)0.0F;
         double strength = (double)0.0F;
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("old_x") == (double)0.0F) {
            entity.getPersistentData().m_128347_("old_x", entity.m_20185_() + entity.m_20154_().f_82479_ * (double)entity.m_20205_() * (double)0.25F);
            entity.getPersistentData().m_128347_("old_y", entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + entity.m_20154_().f_82480_ * (double)entity.m_20205_() * (double)0.25F);
            entity.getPersistentData().m_128347_("old_z", entity.m_20189_() + entity.m_20154_().f_82481_ * (double)entity.m_20205_() * (double)0.25F);
         }

         if (entity.m_6084_()) {
            if (entity.getPersistentData().m_128459_("cnt1") < (double)12.0F) {
               entity.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") * 0.6);
               entity.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") * 0.6);
               entity.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") * 0.6);
               x_power = entity.getPersistentData().m_128459_("x_power");
               y_power = entity.getPersistentData().m_128459_("y_power");
               z_pwoer = entity.getPersistentData().m_128459_("z_power");
               entity.getPersistentData().m_128347_("speed", Math.max((double)0.5F, entity.getPersistentData().m_128459_("speed")));
               if (entity instanceof SeaSerpentEntity) {
                  entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), (double)11.0F));
               }
            } else {
               if (entity.getPersistentData().m_128459_("cnt1") == (double)12.0F && entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
                  entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                  if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                     entity.getPersistentData().m_128347_("x_power", entity_a.m_20154_().f_82479_ * (double)3.0F);
                     entity.getPersistentData().m_128347_("y_power", entity_a.m_20154_().f_82480_ * (double)3.0F);
                     entity.getPersistentData().m_128347_("z_power", entity_a.m_20154_().f_82481_ * (double)3.0F);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") != (double)12.0F && !(entity instanceof SeaSerpentEntity)) {
                  x_power = entity.m_20184_().m_7096_() + (entity.m_20184_().m_7096_() > entity.getPersistentData().m_128459_("x_power") * entity.getPersistentData().m_128459_("speed") ? -0.1 : 0.1);
                  y_power = entity.m_20184_().m_7098_() + (entity.m_20184_().m_7098_() > entity.getPersistentData().m_128459_("y_power") * entity.getPersistentData().m_128459_("speed") ? -0.1 : 0.1);
                  z_pwoer = entity.m_20184_().m_7094_() + (entity.m_20184_().m_7094_() > entity.getPersistentData().m_128459_("z_power") * entity.getPersistentData().m_128459_("speed") ? -0.1 : 0.1);
                  speed = x_power * x_power + y_power * y_power + z_power * z_power;
                  if (speed < (double)1.5F * entity.getPersistentData().m_128459_("speed") * (double)1.5F * entity.getPersistentData().m_128459_("speed")) {
                     speed = (double)1.5F * entity.getPersistentData().m_128459_("speed") / Math.max(Math.sqrt(speed), 0.01);
                     x_power *= speed;
                     y_power *= speed;
                     double var10000 = z_power * speed;
                  }
               } else {
                  if (entity.getPersistentData().m_128459_("cnt1") == (double)12.0F) {
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fish.swim")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fish.swim")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                        }
                     }
                  }

                  x_power = entity.getPersistentData().m_128459_("x_power") * entity.getPersistentData().m_128459_("speed");
                  y_power = entity.getPersistentData().m_128459_("y_power") * entity.getPersistentData().m_128459_("speed");
                  z_pwoer = entity.getPersistentData().m_128459_("z_power") * entity.getPersistentData().m_128459_("speed");
                  entity.getPersistentData().m_128347_("movement", (double)0.0F);
                  entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
               }
            }

            if (entity.getPersistentData().m_128459_("skill") > (double)-999.0F) {
               entity.m_20256_(new Vec3(x_power, y_power, z_pwoer));
            }

            if (!entity.m_20160_() && entity.getPersistentData().m_128459_("skill") > (double)-999.0F) {
               y_power = entity.m_20185_() + entity.m_20154_().f_82479_ * (double)entity.m_20205_() * (double)0.25F - entity.getPersistentData().m_128459_("old_x");
               y_power = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + entity.m_20154_().f_82480_ * (double)entity.m_20205_() * (double)0.25F - entity.getPersistentData().m_128459_("old_y");
               z_power = entity.m_20189_() + entity.m_20154_().f_82481_ * (double)entity.m_20205_() * (double)0.25F - entity.getPersistentData().m_128459_("old_z");
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis > (double)1.0F) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               }

               x_pos = entity.getPersistentData().m_128459_("old_x");
               y_pos = entity.getPersistentData().m_128459_("old_y");
               z_pos = entity.getPersistentData().m_128459_("old_z");

               for(int index0 = 0; index0 < (int)Math.max(dis, (double)1.0F); ++index0) {
                  if (entity instanceof SeaSerpentMiniEntity) {
                     entity.getPersistentData().m_128347_("Damage", (double)12.0F * CNT6);
                     entity.getPersistentData().m_128347_("knockback", 0.1);
                  } else {
                     entity.getPersistentData().m_128347_("Damage", (double)14.0F * CNT6);
                     entity.getPersistentData().m_128347_("x_knockback", entity.m_20184_().m_7096_() * (double)1.25F);
                     entity.getPersistentData().m_128347_("y_knockback", entity.m_20184_().m_7098_() * (double)1.25F);
                     entity.getPersistentData().m_128347_("z_knockback", entity.m_20184_().m_7094_() * (double)1.25F);
                     entity.getPersistentData().m_128347_("knockback", (double)1.0F);
                  }

                  entity.getPersistentData().m_128347_("Range", (double)(2.0F + entity.m_20205_()));
                  entity.getPersistentData().m_128347_("effect", (double)1.0F);
                  entity.getPersistentData().m_128379_("swing", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }

               x_pos = entity.m_20185_() + entity.m_20154_().f_82479_ * (double)entity.m_20205_() * (double)0.25F;
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + entity.m_20154_().f_82480_ * (double)entity.m_20205_() * (double)0.25F;
               z_pos = entity.m_20189_() + entity.m_20154_().f_82481_ * (double)entity.m_20205_() * (double)0.25F;
               if (!(entity instanceof SeaSerpentMiniEntity)) {
                  entity.getPersistentData().m_128347_("Range", (double)(1.0F + entity.m_20205_()));
                  entity.getPersistentData().m_128347_("effect", (double)-1.0F);
                  entity.getPersistentData().m_128347_("knockback", (double)1.0F);
                  KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_() && entity.getPersistentData().m_128459_("cnt1") % (double)20.0F == (double)10.0F) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                     }

                     entity.getPersistentData().m_128347_("BlockRange", (double)(1.0F * entity.m_20205_()));
                     entity.getPersistentData().m_128347_("BlockDamage", (double)entity.m_20205_() * (double)0.25F * CNT6);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)(entity instanceof SeaSerpentMiniEntity ? 40 : 80) && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

         entity.getPersistentData().m_128347_("old_x", entity.m_20185_() + entity.m_20154_().f_82479_ * (double)entity.m_20205_() * (double)0.25F);
         entity.getPersistentData().m_128347_("old_y", entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F + entity.m_20154_().f_82480_ * (double)entity.m_20205_() * (double)0.25F);
         entity.getPersistentData().m_128347_("old_z", entity.m_20189_() + entity.m_20154_().f_82481_ * (double)entity.m_20205_() * (double)0.25F);
      }
   }
}
