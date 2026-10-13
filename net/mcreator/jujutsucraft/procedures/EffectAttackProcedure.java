package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CockroachLarvaEntity;
import net.mcreator.jujutsucraft.entity.KashimoHajimeEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectAttackProcedure {
   public static void execute(LevelAccessor world, Entity damaged_entity, Entity entity) {
      if (damaged_entity != null && entity != null) {
         Entity entity_a = null;
         ItemStack item_A = ItemStack.f_41583_;
         String STR1 = "";
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double NUM1 = (double)0.0F;
         double T1 = (double)0.0F;
         double T1source = (double)0.0F;
         double T2Source = (double)0.0F;
         double T2 = (double)0.0F;
         entity_a = damaged_entity;
         if (damaged_entity instanceof LivingEntity) {
            if (damaged_entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)damaged_entity;
               if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                  return;
               }
            }

            if (entity instanceof Player) {
               JujutsucraftModVariables.PlayerVariables pVars_source = null;
               pVars_source = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
               T1source = pVars_source.PlayerCurseTechnique;
               T2Source = pVars_source.PlayerCurseTechnique2;
            }

            label240: {
               x_pos = damaged_entity.m_20185_();
               y_pos = damaged_entity.m_20186_() + (double)damaged_entity.m_20206_() * (double)0.5F;
               z_pos = damaged_entity.m_20189_();
               if (entity instanceof Player) {
                  if (T1source != (double)7.0F && T2Source != (double)7.0F) {
                     break label240;
                  }
               } else if (!(entity instanceof KashimoHajimeEntity)) {
                  break label240;
               }

               NUM1 = damaged_entity.getPersistentData().m_128459_("Thunder");
               if (entity.getPersistentData().m_128459_("cnt5") != (double)0.0F && !(entity.getPersistentData().m_128459_("cnt5") >= (double)100.0F)) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, 1, (double)entity.m_20205_() * (double)0.25F, (double)entity.m_20206_() * (double)0.25F, (double)entity.m_20205_() * (double)0.25F, 0.1);
                  }

                  damaged_entity.getPersistentData().m_128347_("Thunder", damaged_entity.getPersistentData().m_128459_("Thunder") + 0.1);
               } else {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, 5, (double)entity.m_20205_() * (double)0.25F, (double)entity.m_20206_() * (double)0.25F, (double)entity.m_20205_() * (double)0.25F, 0.1);
                  }

                  damaged_entity.getPersistentData().m_128347_("Thunder", damaged_entity.getPersistentData().m_128459_("Thunder") + (double)1.0F);
               }

               if (NUM1 < (double)5.0F && damaged_entity.getPersistentData().m_128459_("Thunder") >= (double)5.0F || damaged_entity.getPersistentData().m_128459_("Thunder") >= (double)15.0F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, 10, (double)entity.m_20205_() * (double)0.25F, (double)entity.m_20206_() * (double)0.25F, (double)entity.m_20205_() * (double)0.25F, (double)0.25F);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                     }
                  }
               }
            }

            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            item_A = var10000.m_41777_();
            if (entity instanceof Player) {
               Player _plrCldCheck32 = (Player)entity;
               if (_plrCldCheck32.m_36335_().m_41519_(item_A.m_41720_())) {
                  return;
               }
            }

            if (item_A.m_41720_() == JujutsucraftModItems.EXECUTIONERS_SWORD.get() && (damaged_entity.getPersistentData().m_128459_("skill") == (double)0.0F || !damaged_entity.getPersistentData().m_128471_("attack"))) {
               label237: {
                  if (damaged_entity instanceof LivingEntity) {
                     LivingEntity _livEnt36 = (LivingEntity)damaged_entity;
                     if (_livEnt36.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                        break label237;
                     }
                  }

                  NUM1 = (double)0.0F;

                  for(int index0 = 0; index0 < 200; ++index0) {
                     ++NUM1;
                     STR1 = item_A.m_41784_().m_128461_("TARGET" + Math.round(NUM1));
                     if (STR1.isEmpty()) {
                        break;
                     }

                     if (STR1.equals(entity_a.m_20149_())) {
                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_a;
                           _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.ZONE.get());
                        }

                        if (!entity_a.m_9236_().m_5776_() && entity_a.m_20194_() != null) {
                           entity_a.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity_a.m_20182_(), entity_a.m_20155_(), entity_a.m_9236_() instanceof ServerLevel ? (ServerLevel)entity_a.m_9236_() : null, 4, entity_a.m_7755_().getString(), entity_a.m_5446_(), entity_a.m_9236_().m_7654_(), entity_a), "kill @s");
                        }
                        break;
                     }
                  }
               }
            }

            if (item_A.m_41720_() == JujutsucraftModItems.FESTER_LIFE_BLADE.get()) {
               label229: {
                  if (!(entity instanceof Player) && entity instanceof LivingEntity) {
                     LivingEntity _livEnt43 = (LivingEntity)entity;
                     if (_livEnt43.m_21023_(MobEffects.f_19590_)) {
                        break label229;
                     }
                  }

                  if (!(entity_a instanceof CockroachLarvaEntity) && !entity_a.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && (entity_a.getPersistentData().m_128459_("skill") == (double)0.0F || !entity_a.getPersistentData().m_128471_("attack"))) {
                     label238: {
                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _livEnt48 = (LivingEntity)entity_a;
                           if (_livEnt48.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                              break label238;
                           }
                        }

                        if (entity instanceof Player) {
                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              _player.m_36335_().m_41524_(item_A.m_41720_(), 200);
                           }
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19590_, 200, 0, false, false));
                           }
                        }

                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_a;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 60, 4, false, false));
                           }
                        }

                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_a;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 60, 9, false, false));
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.COCKROACH_LARVA.get()).m_262496_(_level, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.m_146922_((float)(Math.random() * (double)720.0F));
                              entityToSpawn.m_5618_((float)(Math.random() * (double)720.0F));
                              entityToSpawn.m_5616_((float)(Math.random() * (double)720.0F));
                              entityToSpawn.m_146926_(-90.0F);
                              entityToSpawn.m_20334_((Math.random() - (double)0.5F) * 0.1, (double)0.5F, (Math.random() - (double)0.5F) * 0.1);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.scream")), SoundSource.NEUTRAL, 1.0F, 1.25F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.scream")), SoundSource.NEUTRAL, 1.0F, 1.25F, false);
                           }
                        }

                        Effect1Procedure.execute(world, entity, entity_a);
                     }
                  }
               }
            }

            if (item_A.m_41720_() == JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get() || item_A.m_41720_() == JujutsucraftModItems.BLACK_ROPE.get()) {
               if (entity_a instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity_a;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get(), 1, 0, false, false));
                  }
               }

               if (entity_a instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity_a;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 10, 0, false, false));
                  }
               }
            }

         }
      }
   }
}
