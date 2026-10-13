package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.EntityWaterEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class Effect11Procedure {
   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         Entity entity_a = null;
         x_pos = entityiterator.m_20185_();
         y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
         z_pos = entityiterator.m_20189_();
         if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("minecraft:skeletons")))) {
            if (!(entity instanceof EntityWaterEntity)) {
               world.m_46796_(2001, BlockPos.m_274561_(x_pos, y_pos, z_pos), Block.m_49956_(Blocks.f_50453_.m_49966_()));
            }
         } else if (!entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
            if (!(entity instanceof EntityWaterEntity)) {
               Effect1Procedure.execute(world, entity, entityiterator);
            }

            if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == (double)10.0F || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == (double)10.0F || entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting"))) || entity.getPersistentData().m_128471_("death_painting") || entity.getPersistentData().m_128471_("CursedSpirit")) {
               int var10000;
               label44: {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entityiterator;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                        var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).m_19557_();
                        break label44;
                     }
                  }

                  var10000 = 0;
               }

               if (var10000 < 1200 && entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.m_9236_().m_5776_()) {
                     MobEffectInstance var10001;
                     MobEffect var10003;
                     int var10004;
                     label36: {
                        var10001 = new MobEffectInstance;
                        var10003 = (MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get();
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entityiterator;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                              var10004 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).m_19557_();
                              break label36;
                           }
                        }

                        var10004 = 0;
                     }

                     var10001.<init>(var10003, Math.min(var10004 + 400, 1200), 0);
                     _entity.m_7292_(var10001);
                  }
               }
            }
         }

      }
   }
}
