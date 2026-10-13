package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemHandlerHelper;

public class SukunaFingerFoodEatenProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double num1 = (double)0.0F;
         double cursed_technique = (double)0.0F;
         double num2 = (double)0.0F;
         double level_control = (double)0.0F;
         double tick = (double)0.0F;
         double cursed_technique2 = (double)0.0F;
         boolean success = false;
         boolean sukuna = false;
         boolean logic_unluck = false;
         if (entity.getPersistentData().m_128471_("CursedSpirit")) {
            success = true;
         } else {
            cursed_technique = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
            cursed_technique2 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
            if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer == (double)0.0F) {
               success = true;
               level_control = (double)2.0F;
            } else if (cursed_technique != (double)21.0F && cursed_technique2 != (double)21.0F) {
               label314: {
                  label313: {
                     if (entity instanceof Player) {
                        Player _plr = (Player)entity;
                        if (_plr.m_150110_().f_35937_) {
                           break label313;
                        }
                     }

                     if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.m_41720_() != JujutsucraftModItems.SUKUNA_FINGER.get() && cursed_technique != (double)1.0F && cursed_technique2 != (double)1.0F && cursed_technique != (double)6.0F && cursed_technique2 != (double)6.0F) {
                        success = false;
                        level_control = (double)0.0F;
                        break label314;
                     }
                  }

                  success = true;
                  level_control = (double)0.0F;
               }
            } else {
               success = true;
               level_control = (double)1.0F;
            }

            if (!success) {
               label300: {
                  if (entity instanceof Player) {
                     Player _plr = (Player)entity;
                     if (_plr.m_150110_().f_35937_) {
                        break label300;
                     }
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SUKUNA_FINGER.get())).m_41777_();
                     _setstack.m_41764_(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.ZONE.get());
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            }
         }

         if (entity.m_6084_()) {
            if (level_control < (double)2.0F) {
               if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.m_41720_() == JujutsucraftModItems.DEATH_PAINTING.get() && entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.death_painting").getString()), false);
                  }
               }

               if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.m_41720_() == JujutsucraftModItems.SUKUNA_FINGER.get()) {
                  ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.m_41764_(Math.min(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.m_41613_() + 1, 20));
               } else {
                  ItemStack _setval = new ItemStack((ItemLike)JujutsucraftModItems.SUKUNA_FINGER.get());
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.BodyItem = _setval.m_41777_();
                     capability.syncPlayerVariables(entity);
                  });
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     String var10001 = Component.m_237115_("item.jujutsucraft.sukuna_finger").getString();
                     _player.m_5661_(Component.m_237113_(var10001 + ": " + Math.round((float)((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.m_41613_())), false);
                  }
               }

               num1 = (double)((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.m_41613_();
            }

            if (num1 > (double)0.0F) {
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s only jujutsucraft:update");
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

               if (entity.getPersistentData().m_128471_("CursedSpirit")) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + (double)1000.0F;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               } else {
                  label329: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt22 = (LivingEntity)entity;
                        if (_livEnt22.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label329;
                        }
                     }

                     int var70;
                     label276: {
                        logic_unluck = true;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt23 = (LivingEntity)entity;
                           if (_livEnt23.m_21023_(MobEffects.f_19590_)) {
                              label272: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19590_)) {
                                       var70 = _livEnt.m_21124_(MobEffects.f_19590_).m_19564_();
                                       break label272;
                                    }
                                 }

                                 var70 = 0;
                              }

                              ++var70;
                              break label276;
                           }
                        }

                        var70 = 0;
                     }

                     num2 = (double)var70;
                     num2 = Math.min(num2, (double)9.0F);
                  }

                  if (level_control == (double)2.0F) {
                     sukuna = false;
                     tick = (double)300.0F;
                  } else if (level_control != (double)1.0F) {
                     if (level_control == (double)0.0F) {
                        sukuna = true;
                        tick = (double)1000000.0F;
                     }
                  } else {
                     label337: {
                        label263: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt25 = (LivingEntity)entity;
                              if (_livEnt25.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label263;
                              }
                           }

                           if (num1 != (double)1.0F && !(num2 >= (double)9.0F)) {
                              break label337;
                           }
                        }

                        sukuna = true;
                        tick = (double)300.0F;
                     }
                  }
               }
            }

            num1 = (double)-300.0F - Math.random();
            if (sukuna && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = EntityType.f_20510_.m_262496_(_level, BlockPos.m_274561_(entity.m_20185_(), num1, entity.m_20189_()), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               }
            }

            sukuna = false;
            Vec3 _center = new Vec3(entity.m_20185_(), num1, entity.m_20189_());

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)0.5F), (e) -> true)) {
               if (entityiterator instanceof Pig && entityiterator.m_6084_()) {
                  sukuna = true;
                  if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                     entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                  }

                  if (!entityiterator.m_9236_().m_5776_()) {
                     entityiterator.m_146870_();
                  }
                  break;
               }
            }

            if (sukuna) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_(MobEffects.f_19590_);
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  Commands var71 = entity.m_20194_().m_129892_();
                  CommandSourceStack var72 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                  Object var10002;
                  if (tick > (double)10000.0F) {
                     var10002 = "infinite";
                  } else {
                     int var10003;
                     label239: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              var10003 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).m_19564_();
                              break label239;
                           }
                        }

                        var10003 = 0;
                     }

                     var10002 = Math.round(Math.max(tick, (double)Math.round(Math.floor((double)(var10003 / 20)))));
                  }

                  String var73 = String.valueOf(var10002);
                  var71.m_230957_(var72, "effect give @s jujutsucraft:sukuna_effect " + var73 + " " + Math.round(Math.min(Math.max(GetSukunaLevelProcedure.execute(entity), (double)1.0F), (double)20.0F) - (double)1.0F) + " true");
               }
            }

            if (logic_unluck && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = EntityType.f_20557_.m_262496_(_level, BlockPos.m_274561_(entity.m_20185_(), num1, entity.m_20189_()), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
               }
            }

            logic_unluck = false;
            _center = new Vec3(entity.m_20185_(), num1, entity.m_20189_());

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)0.5F), (e) -> true)) {
               if (entityiterator instanceof Cow && entityiterator.m_6084_()) {
                  logic_unluck = true;
                  if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                     entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                  }

                  if (!entityiterator.m_9236_().m_5776_()) {
                     entityiterator.m_146870_();
                  }
                  break;
               }
            }

            if (logic_unluck && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:unluck 180 " + Math.round(num2) + " true");
            }

            if (!entity.getPersistentData().m_128471_("CursedSpirit")) {
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity;
                  Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:observation_of_the_soul"));
                  AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                  if (!_ap.m_8193_()) {
                     for(String criteria : _ap.m_8219_()) {
                        _player.m_8960_().m_135988_(_adv, criteria);
                     }
                  }
               }

               if (level_control == (double)0.0F) {
                  boolean _setval = true;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.flag_sukuna = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            }

            WhenRespawnProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
