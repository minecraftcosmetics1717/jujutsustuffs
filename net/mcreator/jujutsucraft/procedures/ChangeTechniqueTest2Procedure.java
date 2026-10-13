package net.mcreator.jujutsucraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

public class ChangeTechniqueTest2Procedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, double playerCT, double playerSelect) {
      if (entity == null) {
         return false;
      } else {
         boolean reChange = false;
         double NUM1 = (double)0.0F;
         double NUM2 = (double)0.0F;
         double cost = (double)0.0F;
         double NUM3 = (double)0.0F;
         ItemStack item_mainHand = ItemStack.f_41583_;
         if (!(entity instanceof ServerPlayer)) {
            return false;
         } else {
            NUM1 = playerCT;
            NUM2 = playerSelect;
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            label304: {
               label303: {
                  item_mainHand = var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt1 = (LivingEntity)entity;
                     if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        if (playerSelect != (double)20.0F) {
                           break label304;
                        }
                        break label303;
                     }
                  }

                  if (playerSelect != (double)21.0F) {
                     break label304;
                  }
               }

               reChange = true;
            }

            if ((playerSelect <= (double)2.0F || playerSelect >= (double)20.0F) && item_mainHand.m_41720_() == JujutsucraftModItems.LOUDSPEAKER.get() && (!item_mainHand.m_41784_().m_128441_("Used") || !item_mainHand.m_41784_().m_128471_("Used"))) {
               reChange = true;
            }

            if (playerCT == (double)-1.0F && playerSelect > (double)2.0F) {
               label282: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                        var47 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_();
                        break label282;
                     }
                  }

                  var47 = 0;
               }

               if (var47 <= 0) {
                  reChange = true;
               }
            }

            if (playerCT == (double)1.0F && playerSelect >= (double)11.0F && playerSelect <= (double)13.0F) {
               label274: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt6 = (LivingEntity)entity;
                     if (_livEnt6.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        break label274;
                     }
                  }

                  reChange = true;
               }
            }

            if (playerCT == (double)5.0F) {
               if (playerSelect != (double)5.0F && playerSelect != (double)6.0F && playerSelect != (double)7.0F) {
                  if ((playerSelect == (double)15.0F || playerSelect == (double)19.0F) && !LocateRikaProcedure.execute(world, entity)) {
                     reChange = true;
                  }
               } else if (!LocateRikaProcedure.execute(world, entity)) {
                  label262: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt7 = (LivingEntity)entity;
                        if (_livEnt7.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed")) {
                           break label262;
                        }
                     }

                     reChange = true;
                  }
               }
            } else if (playerCT == (double)7.0F) {
               label252: {
                  label311: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt9 = (LivingEntity)entity;
                        if (_livEnt9.m_21023_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                           if (playerSelect != (double)15.0F) {
                              break label252;
                           }
                           break label311;
                        }
                     }

                     if (!(playerSelect > (double)15.0F) || !(playerSelect < (double)20.0F)) {
                        break label252;
                     }
                  }

                  reChange = true;
               }
            } else if (playerCT == (double)10.0F && playerSelect == (double)8.0F && !LocateBloodBallProcedure.execute(world, x, y, z, entity)) {
               reChange = true;
            }

            if (playerCT == (double)18.0F && (playerSelect >= (double)11.0F && playerSelect <= (double)13.0F || playerSelect == (double)15.0F) && entity.getPersistentData().m_128459_("data_cursed_spirit_manipulation1") == (double)0.0F) {
               reChange = true;
            }

            if (playerCT == (double)21.0F) {
               if (playerSelect >= (double)3.0F && playerSelect <= (double)20.0F && entity instanceof LivingEntity) {
                  LivingEntity _livEnt11 = (LivingEntity)entity;
                  if (_livEnt11.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                     reChange = true;
                  }
               }

               if (playerSelect == (double)18.0F && entity instanceof LivingEntity) {
                  LivingEntity _livEnt12 = (LivingEntity)entity;
                  if (_livEnt12.m_21023_((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get())) {
                     reChange = true;
                  }
               }

               if (playerSelect == (double)19.0F && GetSukunaLevelProcedure.execute(entity) == (double)0.0F) {
                  reChange = true;
               }
            } else if (playerCT == (double)27.0F) {
               if (playerSelect == (double)5.0F) {
                  AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                  LazyOptional var48 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                  Objects.requireNonNull(_iitemhandlerref);
                  var48.ifPresent(_iitemhandlerref::set);
                  if (_iitemhandlerref.get() != null) {
                     for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                        ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                        if (itemstackiterator.m_41720_() == JujutsucraftModItems.GAVEL.get() || itemstackiterator.m_41720_() == JujutsucraftModItems.GAVEL_BIG.get() || itemstackiterator.m_41720_() == JujutsucraftModItems.EXECUTIONERS_SWORD.get() || itemstackiterator.m_41720_() == JujutsucraftModItems.GAVEL_LONG.get()) {
                           reChange = true;
                           break;
                        }
                     }
                  }
               } else if (playerSelect == (double)19.0F) {
                  label212: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt22 = (LivingEntity)entity;
                        if (_livEnt22.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed")) {
                           break label212;
                        }
                     }

                     reChange = true;
                  }
               }
            } else if (playerCT == (double)29.0F) {
               if (playerSelect == (double)5.0F) {
                  NUM3 = (double)0.0F;
                  AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                  LazyOptional var49 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                  Objects.requireNonNull(_iitemhandlerref);
                  var49.ifPresent(_iitemhandlerref::set);
                  if (_iitemhandlerref.get() != null) {
                     for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                        ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                        if (itemstackiterator.m_41720_() == JujutsucraftModItems.BULLET_BALL.get()) {
                           NUM3 += (double)itemstackiterator.m_41613_();
                           if (NUM3 > (double)3.0F) {
                              reChange = true;
                              break;
                           }
                        }
                     }
                  }
               } else if (playerSelect == (double)7.0F) {
                  label324: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt29 = (LivingEntity)entity;
                        if (_livEnt29.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed") && entity.getPersistentData().m_128459_("mode_hakari") == (double)2.0F) {
                           break label324;
                        }
                     }

                     reChange = true;
                  }
               }

               if ((playerSelect == (double)5.0F || playerSelect == (double)6.0F || playerSelect == (double)20.0F) && entity instanceof LivingEntity) {
                  LivingEntity _livEnt32 = (LivingEntity)entity;
                  if (_livEnt32.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                     reChange = true;
                  }
               }
            }

            if (playerCT == (double)39.0F && (playerSelect == (double)8.0F || playerSelect == (double)9.0F) && !LocateLiquidMetalProcedure.execute(world, entity)) {
               reChange = true;
            }

            if (!((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).use_mainSkill) {
               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
               LazyOptional var50 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
               Objects.requireNonNull(_iitemhandlerref);
               var50.ifPresent(_iitemhandlerref::set);
               if (_iitemhandlerref.get() != null) {
                  for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                     ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                     if (itemstackiterator.m_41720_() == JujutsucraftModItems.CURSED_TECHNIQUE_STARTER.get()) {
                        if (entity instanceof Player) {
                           Player _plrCldCheck36 = (Player)entity;
                           if (_plrCldCheck36.m_36335_().m_41519_(itemstackiterator.m_41720_())) {
                              continue;
                           }
                        }

                        if (NUM1 == itemstackiterator.m_41784_().m_128459_("TechniqueNumber1") && NUM2 == itemstackiterator.m_41784_().m_128459_("TechniqueNumber2")) {
                           reChange = true;
                           break;
                        }
                     }
                  }
               }
            }

            return reChange;
         }
      }
   }
}
