package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueMythicalBeastAmberProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double power = (double)0.0F;
         double range = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         range = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ATTACKING.get(), 5, 0, false, false));
            }
         }

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

            if (((Entity)var10000).m_6084_()) {
               entity.getPersistentData().m_128379_("PRESS_Z", true);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= (double)20.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, (float)((double)1.0F * range), 0.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, (float)((double)1.0F * range), 0.5F, false);
               }
            }

            entity.getPersistentData().m_128347_("Damage", (double)6.0F);
            DamageFixProcedure.execute(entity);
            if (!entity.getPersistentData().m_128471_("PRESS_Z")) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(""), true);
                  }
               }

               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            } else {
               power = (double)Math.round(((double)20.0F - entity.getPersistentData().m_128459_("cnt1")) * (double)0.25F);
               STR1 = Component.m_237115_("jujutsu.message.long_press").getString();

               for(int index0 = 0; index0 < (int)power; ++index0) {
                  STR1 = "■" + STR1 + "■";
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(STR1), true);
                  }
               }
            }

            ParticleGeneratorCircleProcedure.execute(world, (double)4.0F * range, (double)90.0F, (double)0.5F * range, (double)0.75F * range, (double)1.0F * range, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random() * range, (double)0.0F, entity.m_20189_(), entity.m_20189_(), "jujutsucraft:particle_thunder_blue");
         } else {
            entity.getPersistentData().m_128347_("Damage", (double)15.0F);
            DamageFixProcedure.execute(entity);
            if (entity.getPersistentData().m_128459_("cnt1") <= (double)21.0F) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(""), true);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.5F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.75F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.75F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.75F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)((double)2.0F * range), 0.75F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     MobEffectInstance var10001;
                     MobEffect var10003;
                     int var10005;
                     label96: {
                        var10001 = new MobEffectInstance;
                        var10003 = (MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label96;
                           }
                        }

                        var10005 = 0;
                     }

                     var10001.<init>(var10003, Integer.MAX_VALUE, var10005, true, true);
                     _entity.m_7292_(var10001);
                  }
               }

               double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + (double)500.0F;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerCursePowerChange = _setval;
                  capability.syncPlayerVariables(entity);
               });
               boolean _setval = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.noChangeTechnique = _setval;
                  capability.syncPlayerVariables(entity);
               });
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }

            ParticleGeneratorCircleProcedure.execute(world, (double)8.0F * range, (double)90.0F, (double)0.5F * range, (double)0.75F * range, (double)4.0F * range, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random() * range, (double)0.0F, entity.m_20189_(), entity.m_20189_(), "jujutsucraft:particle_flame_purple");
            ParticleGeneratorCircleProcedure.execute(world, (double)8.0F * range, (double)90.0F, (double)0.0F * range, (double)8.0F * range, (double)4.0F * range, entity.m_20185_(), entity.m_20185_(), entity.m_20186_(), entity.m_20186_() + Math.random() * range, (double)0.0F, entity.m_20189_(), entity.m_20189_(), "jujutsucraft:particle_thunder_blue");
            if (entity.getPersistentData().m_128459_("cnt1") >= (double)35.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
