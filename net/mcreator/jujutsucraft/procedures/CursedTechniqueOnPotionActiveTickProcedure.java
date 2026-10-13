package net.mcreator.jujutsucraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

public class CursedTechniqueOnPotionActiveTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         double num1 = (double)0.0F;
         double skill = (double)0.0F;
         double power = (double)0.0F;
         if (entity.m_6084_()) {
            skill = (double)Math.round(entity.getPersistentData().m_128459_("skill"));
            if (skill == (double)0.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
               }
            } else {
               num1 = skill % (double)100.0F;
               if (num1 == (double)21.0F) {
                  entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
                  if (!entity.getPersistentData().m_128471_("PRESS_Z")) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        if (!_player.m_9236_().m_5776_()) {
                           _player.m_5661_(Component.m_237113_(""), true);
                        }
                     }

                     entity.getPersistentData().m_128347_("skill", (double)0.0F);
                  } else {
                     power = (double)Math.round(((double)20.0F - entity.getPersistentData().m_128459_("cnt3")) * (double)0.25F);
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

                     if (entity.getPersistentData().m_128459_("cnt3") >= (double)20.0F) {
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           if (!_player.m_9236_().m_5776_()) {
                              _player.m_5661_(Component.m_237113_(""), true);
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                        }

                        entity.getPersistentData().m_128347_("skill", (double)0.0F);
                        boolean _setval = true;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.noChangeTechnique = _setval;
                           capability.syncPlayerVariables(entity);
                        });
                        KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                     }
                  }
               } else if (skill >= (double)-100.0F && num1 >= (double)0.0F && num1 <= (double)2.0F) {
                  if (skill < (double)0.0F || skill >= (double)100.0F) {
                     if (num1 == (double)0.0F) {
                        AttackWeakProcedure.execute(world, x, y, z, entity);
                     } else if (num1 == (double)1.0F) {
                        AttackStrongProcedure.execute(world, x, y, z, entity);
                     } else if (num1 == (double)2.0F) {
                        AttackContinueProcedure.execute(world, x, y, z, entity);
                     }
                  }
               } else if (skill >= (double)500.0F) {
                  if (skill >= (double)1000.0F) {
                     CursedTechniqueOnPotionActivetick2Procedure.execute(world, x, y, z, entity);
                  } else if (skill >= (double)900.0F) {
                     CursedTechniqueTsukumoProcedure.execute(world, x, y, z, entity);
                  } else if (skill >= (double)800.0F) {
                     CursedTechniqueDagonProcedure.execute(world, x, y, z, entity);
                  } else if (skill >= (double)700.0F) {
                     CursedTechniqueKashimoProcedure.execute(world, x, y, z, entity);
                  } else if (skill >= (double)600.0F) {
                     CursedTechniqueFushiguroProcedure.execute(world, x, y, z, entity);
                  } else if (skill >= (double)500.0F) {
                     CursedTechniqueOkkotsuProcedure.execute(world, x, y, z, entity);
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                  }
               } else if (skill >= (double)400.0F) {
                  CursedTechniqueJogoProcedure.execute(world, x, y, z, entity);
               } else if (skill >= (double)300.0F) {
                  CursedTechniqueCursedSpeechProcedure.execute(world, x, y, z, entity);
               } else if (skill >= (double)200.0F) {
                  CursedTechniqueGojoProcedure.execute(world, x, y, z, entity);
               } else if (skill >= (double)100.0F) {
                  CursedTechniqueSukunaProcedure.execute(world, x, y, z, entity);
               } else if (skill >= (double)-100.0F) {
                  PhysicalGiftedProcedure.execute(world, x, y, z, entity);
               } else if (!(skill <= (double)-999.0F)) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                  }
               } else {
                  if (skill == (double)-999.0F) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        if (!_player.m_9236_().m_5776_()) {
                           _player.m_5661_(Component.m_237113_("§k12345678901234567890123456789012345678901234567890123"), false);
                        }
                     }

                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "particle minecraft:enchant ~ ~" + entity.m_20206_() + " ~ 0.25 0.25 0.25 1 250 force @s");
                     }

                     ItemStack var10000;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        if (var10000.m_41784_().m_128459_("domain2") >= (double)100.0F) {
                           label208: {
                              if (entity instanceof Player) {
                                 label205: {
                                    if (entity instanceof ServerPlayer) {
                                       ServerPlayer _plr23 = (ServerPlayer)entity;
                                       if (_plr23.m_9236_() instanceof ServerLevel && _plr23.m_8960_().m_135996_(_plr23.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_mahoraga"))).m_8193_() && entity.getPersistentData().m_128459_("TenShadowsTechnique14") >= (double)0.0F) {
                                          break label205;
                                       }
                                    }

                                    if (!(entity.getPersistentData().m_128459_("TenShadowsTechnique14") > (double)0.0F)) {
                                       break label208;
                                    }
                                 }

                                 if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != (double)6.0F && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != (double)6.0F) {
                                    break label208;
                                 }
                              } else if (!(entity.getPersistentData().m_128459_("TenShadowsTechnique14") > (double)0.0F)) {
                                 break label208;
                              }

                              ResetCounterProcedure.execute(entity);
                              SummonMahoragaProcedure.execute(world, x, y, z, entity);
                           }
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 5, 0, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 5, 1, false, false));
                     }
                  }

                  AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                  LazyOptional var40 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                  Objects.requireNonNull(_iitemhandlerref);
                  var40.ifPresent(_iitemhandlerref::set);
                  if (_iitemhandlerref.get() != null) {
                     for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                        ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                        if (entity instanceof Player) {
                           Player _plrCldCheck30 = (Player)entity;
                           if (_plrCldCheck30.m_36335_().m_41519_(itemstackiterator.m_41720_())) {
                              continue;
                           }
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_36335_().m_41524_(itemstackiterator.m_41720_(), 20);
                        }
                     }
                  }

                  entity.getPersistentData().m_128347_("cnt_x", Math.min(entity.getPersistentData().m_128459_("cnt_x"), (double)0.0F));
               }
            }

            if (entity.getPersistentData().m_128471_("betrayal") && entity.getPersistentData().m_128471_("PRESS_Z") && entity.getPersistentData().m_128459_("Damage") == (double)0.0F) {
               entity.getPersistentData().m_128379_("betrayal", false);
            }
         }

      }
   }
}
