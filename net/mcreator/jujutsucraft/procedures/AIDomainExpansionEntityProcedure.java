package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class AIDomainExpansionEntityProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         BlockState blockstate1 = Blocks.f_50016_.m_49966_();
         double x_dis = (double)0.0F;
         double cnt2 = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_dis = (double)0.0F;
         double z_pos = (double)0.0F;
         double dis = (double)0.0F;
         double loop_num = (double)0.0F;
         double y_floor = (double)0.0F;
         double y_pos = (double)0.0F;
         double y_dis = (double)0.0F;
         range = (double)Math.round(JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius + (double)1.0F);
         entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
         entity.m_6021_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"));
         if (entity instanceof ServerPlayer) {
            ServerPlayer _serverPlayer = (ServerPlayer)entity;
            _serverPlayer.f_8906_.m_9774_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19619_, 60, 0, false, false));
            }
         }

         if (!entity.getPersistentData().m_128471_("Break")) {
            label88: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     break label88;
                  }
               }

               entity.getPersistentData().m_128347_("cnt_life2", entity.getPersistentData().m_128459_("cnt_life2") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_life2") > Math.max((double)60.0F, range * (double)2.0F + (double)5.0F)) {
                  entity.getPersistentData().m_128379_("Break", true);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt12 = (LivingEntity)entity;
               if (_livEnt12.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                  entity.getPersistentData().m_128379_("Break", false);
                  entity.getPersistentData().m_128347_("cnt_life2", (double)0.0F);
               }
            }
         }

         if (entity.getPersistentData().m_128471_("Break")) {
            entity.getPersistentData().m_128347_("cnt_break", entity.getPersistentData().m_128459_("cnt_break") + (double)1.0F);
            loop_num = (double)Math.round(range * (double)2.0F + (double)1.0F);
            cnt2 = entity.getPersistentData().m_128459_("cnt_break");
            y_floor = (double)(Math.round(y) - 1L);
            x_pos = (double)Math.round(x) - range;

            for(int index0 = 0; index0 < (int)loop_num; ++index0) {
               x_dis = x_pos - (double)Math.round(x);
               x_dis *= x_dis;
               if (x_dis <= cnt2 * cnt2) {
                  y_pos = (double)Math.round(y) - range;

                  for(int index1 = 0; index1 < (int)loop_num; ++index1) {
                     y_dis = y_pos - (double)Math.round(y);
                     y_dis *= y_dis;
                     if (y_dis <= cnt2 * cnt2 && y_pos >= (double)-64.0F && y_pos <= (double)319.0F) {
                        z_pos = (double)Math.round(z) - range;

                        for(int index2 = 0; index2 < (int)loop_num; ++index2) {
                           z_dis = z_pos - (double)Math.round(z);
                           z_dis *= z_dis;
                           if (z_dis <= cnt2 * cnt2) {
                              dis = x_dis + z_dis + y_dis;
                              if (dis < (range + (double)1.0F) * (range + (double)1.0F) && dis <= cnt2 * cnt2 && dis >= (cnt2 - (double)1.0F) * (cnt2 - (double)1.0F)) {
                                 blockstate1 = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos));
                                 if (blockstate1.m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
                                    JujutsuBarrierUpdateTickProcedure.execute(world, x_pos, y_pos, z_pos);
                                 }
                              }
                           }

                           ++z_pos;
                        }
                     }

                     ++y_pos;
                  }
               }

               ++x_pos;
            }

            if (entity.getPersistentData().m_128459_("cnt_break") >= (double)Math.round(range * (double)2.0F + (double)2.0F) && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
