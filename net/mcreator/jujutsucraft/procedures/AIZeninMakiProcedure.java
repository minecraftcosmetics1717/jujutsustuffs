package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.ZeninMakiCullingGameEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class AIZeninMakiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean awaked = false;
         double rnd = (double)0.0F;
         double level_strength = (double)0.0F;
         double level_resistance = (double)0.0F;
         double level_physical_gifted = (double)0.0F;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            awaked = entity instanceof ZeninMakiCullingGameEntity;
            if (awaked) {
               level_strength = (double)24.0F;
               level_resistance = (double)3.0F;
               level_physical_gifted = (double)4.0F;
            } else {
               level_strength = (double)8.0F;
               level_resistance = (double)2.0F;
               level_physical_gifted = (double)0.0F;
               if (!entity.getPersistentData().m_128471_("flag_start")) {
                  entity.getPersistentData().m_128379_("flag_start", true);
                  entity.getPersistentData().m_128379_("HasWeapon1", false);
                  entity.getPersistentData().m_128379_("HasWeapon2", true);
                  entity.getPersistentData().m_128379_("HasWeapon3", true);
               }
            }

            label173: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.m_21023_(MobEffects.f_19600_)) {
                     break label173;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)level_strength, false, false));
                  }
               }
            }

            label168: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.m_21023_(MobEffects.f_19606_)) {
                     break label168;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, (int)level_resistance, false, false));
                  }
               }
            }

            label163: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt11 = (LivingEntity)entity;
                  if (_livEnt11.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                     break label163;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get(), Integer.MAX_VALUE, (int)level_physical_gifted, false, false));
                  }
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
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  ResetCounterProcedure.execute(entity);
                  CalculateAttackProcedure.execute(world, entity);
                  if (!awaked) {
                     boolean var55;
                     label153: {
                        var50 = entity.getPersistentData();
                        if (!entity.getPersistentData().m_128471_("HasWeapon1")) {
                           ItemStack var10002;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.m_21205_();
                           } else {
                              var10002 = ItemStack.f_41583_;
                           }

                           if (var10002.m_41720_() != JujutsucraftModItems.NAGINATA.get()) {
                              var55 = false;
                              break label153;
                           }
                        }

                        var55 = true;
                     }

                     label147: {
                        var50.m_128379_("HasWeapon1", var55);
                        var51 = entity.getPersistentData();
                        if (!entity.getPersistentData().m_128471_("HasWeapon2")) {
                           ItemStack var56;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var56 = _livEnt.m_21205_();
                           } else {
                              var56 = ItemStack.f_41583_;
                           }

                           if (var56.m_41720_() != JujutsucraftModItems.SLAUGHTER_DEMON.get()) {
                              var55 = false;
                              break label147;
                           }
                        }

                        var55 = true;
                     }

                     label141: {
                        var51.m_128379_("HasWeapon2", var55);
                        var52 = entity.getPersistentData();
                        if (!entity.getPersistentData().m_128471_("HasWeapon3")) {
                           ItemStack var58;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var58 = _livEnt.m_21205_();
                           } else {
                              var58 = ItemStack.f_41583_;
                           }

                           if (var58.m_41720_() != JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
                              var55 = false;
                              break label141;
                           }
                        }

                        var55 = true;
                     }

                     var52.m_128379_("HasWeapon3", var55);
                     float var53;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var53 = _livEnt.m_21223_();
                     } else {
                        var53 = -1.0F;
                     }

                     double var54 = (double)var53;
                     float var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21233_();
                     } else {
                        var10001 = -1.0F;
                     }

                     if (var54 <= (double)var10001 * (double)0.5F) {
                        if (entity.getPersistentData().m_128471_("HasWeapon3")) {
                           entity.getPersistentData().m_128379_("HasWeapon3", false);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.PLAYFUL_CLOUD.get())).m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }
                        } else if (entity.getPersistentData().m_128471_("HasWeapon1")) {
                           entity.getPersistentData().m_128379_("HasWeapon1", false);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.NAGINATA.get())).m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }
                        } else if (entity.getPersistentData().m_128471_("HasWeapon2")) {
                           entity.getPersistentData().m_128379_("HasWeapon2", false);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SLAUGHTER_DEMON.get())).m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }
                        }
                     } else if (Math.random() > (double)0.5F) {
                        for(int index0 = 0; index0 < 5; ++index0) {
                           rnd = (double)Math.round(Math.ceil(Math.random() * (double)2.0F));
                           if (rnd == (double)1.0F) {
                              if (entity.getPersistentData().m_128471_("HasWeapon1")) {
                                 entity.getPersistentData().m_128379_("HasWeapon1", false);
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.NAGINATA.get())).m_41777_();
                                    _setstack.m_41764_(1);
                                    _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                                    if (_entity instanceof Player) {
                                       Player _player = (Player)_entity;
                                       _player.m_150109_().m_6596_();
                                    }
                                 }
                                 break;
                              }
                           } else if (rnd == (double)2.0F && entity.getPersistentData().m_128471_("HasWeapon2")) {
                              entity.getPersistentData().m_128379_("HasWeapon2", false);
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SLAUGHTER_DEMON.get())).m_41777_();
                                 _setstack.m_41764_(1);
                                 _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.m_150109_().m_6596_();
                                 }
                              }
                              break;
                           }
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

      }
   }
}
