package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.ItadoriYujiEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShibuyaEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShinjukuEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedPoisonOnEffectActiveTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean damage = false;
         double level = (double)0.0F;
         double tick = (double)0.0F;
         double playerTechnique1 = (double)0.0F;
         double playerTechnique2 = (double)0.0F;
         if (entity.m_6084_()) {
            double var10000;
            label78: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get())) {
                     var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get()).m_19564_();
                     break label78;
                  }
               }

               var10000 = (double)0.0F;
            }

            label73: {
               level = var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get())) {
                     var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.CURSED_POISON.get()).m_19557_();
                     break label73;
                  }
               }

               var10000 = (double)0.0F;
            }

            tick = var10000;
            if (tick % (double)10.0F == (double)0.0F) {
               damage = true;
               if (!(entity instanceof Player)) {
                  if (entity instanceof ItadoriYujiEntity || entity instanceof ItadoriYujiShibuyaEntity || entity instanceof ItadoriYujiShinjukuEntity) {
                     damage = false;
                  }
               } else {
                  JujutsucraftModVariables.PlayerVariables cap = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
                  playerTechnique1 = cap.PlayerCurseTechnique;
                  playerTechnique2 = cap.PlayerCurseTechnique2;
                  if (playerTechnique1 == (double)21.0F || playerTechnique2 == (double)21.0F) {
                     damage = false;
                  }

                  if (cap.PlayerCursePowerFormer == (double)0.0F) {
                     damage = false;
                  }
               }

               if (damage && entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
                  damage = false;
               }

               if (damage) {
                  if (tick % (double)200.0F == (double)0.0F) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 80, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 1, false, false));
                        }
                     }

                     entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat")))), (float)((double)9.0F * ((double)1.0F + level)));
                  }
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get());
               }
            }
         }

      }
   }
}
