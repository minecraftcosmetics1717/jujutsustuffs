package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Demotion1RightclickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         boolean consume = false;
         double num1 = (double)0.0F;
         double difficulty = (double)0.0F;
         consume = true;
         difficulty = (double)world.m_6106_().m_5470_().m_46215_(JujutsucraftModGameRules.JUJUTSUUPGRADEDIFFICULTY);
         if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange != (double)-1.0F) {
            double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + (double)1.0F;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.PlayerCursePowerChange = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

         label394: {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr1 = (ServerPlayer)entity;
               if (_plr1.m_9236_() instanceof ServerLevel && _plr1.m_8960_().m_135996_(_plr1.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_special"))).m_8193_()) {
                  double _setval = Math.min(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame, (double)2750.0F * difficulty);
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerFame = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s from jujutsucraft:fame_special");
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s from jujutsucraft:sorcerer_grade_1");
                  }

                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity;
                     Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1"));
                     AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                     if (!_ap.m_8193_()) {
                        for(String criteria : _ap.m_8219_()) {
                           _player.m_8960_().m_135988_(_adv, criteria);
                        }
                     }
                  }
                  break label394;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr5 = (ServerPlayer)entity;
               if (_plr5.m_9236_() instanceof ServerLevel && _plr5.m_8960_().m_135996_(_plr5.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1"))).m_8193_()) {
                  double _setval = Math.min(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame, (double)1750.0F * difficulty);
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerFame = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s from jujutsucraft:fame_1");
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s from jujutsucraft:sorcerer_grade_1_semi");
                  }

                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity;
                     Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1_semi"));
                     AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                     if (!_ap.m_8193_()) {
                        for(String criteria : _ap.m_8219_()) {
                           _player.m_8960_().m_135988_(_adv, criteria);
                        }
                     }
                  }
                  break label394;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr9 = (ServerPlayer)entity;
               if (_plr9.m_9236_() instanceof ServerLevel && _plr9.m_8960_().m_135996_(_plr9.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_1_semi"))).m_8193_()) {
                  double _setval = Math.min(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame, (double)1000.0F * difficulty);
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerFame = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s from jujutsucraft:fame_1");
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s from jujutsucraft:sorcerer_grade_2");
                  }

                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity;
                     Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2"));
                     AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                     if (!_ap.m_8193_()) {
                        for(String criteria : _ap.m_8219_()) {
                           _player.m_8960_().m_135988_(_adv, criteria);
                        }
                     }
                  }
                  break label394;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr13 = (ServerPlayer)entity;
               if (_plr13.m_9236_() instanceof ServerLevel && _plr13.m_8960_().m_135996_(_plr13.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2"))).m_8193_()) {
                  double _setval = Math.min(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame, (double)500.0F * difficulty);
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerFame = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s from jujutsucraft:fame_2");
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s from jujutsucraft:sorcerer_grade_2_semi");
                  }

                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity;
                     Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2_semi"));
                     AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                     if (!_ap.m_8193_()) {
                        for(String criteria : _ap.m_8219_()) {
                           _player.m_8960_().m_135988_(_adv, criteria);
                        }
                     }
                  }
                  break label394;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr17 = (ServerPlayer)entity;
               if (_plr17.m_9236_() instanceof ServerLevel && _plr17.m_8960_().m_135996_(_plr17.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_2_semi"))).m_8193_()) {
                  double _setval = Math.min(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame, (double)200.0F * difficulty);
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerFame = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s from jujutsucraft:fame_2");
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s from jujutsucraft:sorcerer_grade_3");
                  }

                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity;
                     Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_3"));
                     AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                     if (!_ap.m_8193_()) {
                        for(String criteria : _ap.m_8219_()) {
                           _player.m_8960_().m_135988_(_adv, criteria);
                        }
                     }
                  }
                  break label394;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr21 = (ServerPlayer)entity;
               if (_plr21.m_9236_() instanceof ServerLevel && _plr21.m_8960_().m_135996_(_plr21.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_3"))).m_8193_()) {
                  double _setval = Math.min(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame, (double)50.0F * difficulty);
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerFame = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s from jujutsucraft:fame_3");
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s from jujutsucraft:sorcerer_grade_4");
                  }

                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity;
                     Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_4"));
                     AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                     if (!_ap.m_8193_()) {
                        for(String criteria : _ap.m_8219_()) {
                           _player.m_8960_().m_135988_(_adv, criteria);
                        }
                     }
                  }
                  break label394;
               }
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _plr25 = (ServerPlayer)entity;
               if (_plr25.m_9236_() instanceof ServerLevel && _plr25.m_8960_().m_135996_(_plr25.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:sorcerer_grade_4"))).m_8193_()) {
                  double _setval = Math.min(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerFame, (double)0.0F);
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerFame = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s from jujutsucraft:fame_4");
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s from jujutsucraft:sorcerer_grade_4");
                  }

                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)entity;
                     Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:update"));
                     AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                     if (!_ap.m_8193_()) {
                        for(String criteria : _ap.m_8219_()) {
                           _player.m_8960_().m_135988_(_adv, criteria);
                        }
                     }
                  }
                  break label394;
               }
            }

            consume = false;
         }

         num1 = (double)-200.0F - Math.random() * (double)20.0F;
         if (consume && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            Entity entityToSpawn = EntityType.f_20549_.m_262496_(_level, BlockPos.m_274561_(entity.m_20185_(), num1, entity.m_20189_()), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
            }
         }

         consume = false;
         Vec3 _center = new Vec3(entity.m_20185_(), num1, entity.m_20189_());

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)0.5F), (e) -> true)) {
            if (entityiterator instanceof Bat && entityiterator.m_6084_()) {
               consume = true;
               if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                  entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
               }

               if (!entityiterator.m_9236_().m_5776_()) {
                  entityiterator.m_146870_();
               }
               break;
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.m_36335_().m_41524_(itemstack.m_41720_(), 5);
         }

         if (consume) {
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect clear @s");
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity42 = (LivingEntity)entity;
               if (_livingEntity42.m_21204_().m_22171_(Attributes.f_22284_)) {
                  _livingEntity42.m_21051_(Attributes.f_22284_).m_22100_((double)0.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity43 = (LivingEntity)entity;
               if (_livingEntity43.m_21204_().m_22171_(Attributes.f_22285_)) {
                  _livingEntity43.m_21051_(Attributes.f_22285_).m_22100_((double)0.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            itemstack.m_41774_(1);
            WhenRespawnProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.dont_use").getString()), false);
            }
         }

      }
   }
}
