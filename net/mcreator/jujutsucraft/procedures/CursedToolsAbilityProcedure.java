package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade010Entity;
import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class CursedToolsAbilityProcedure {
   public static void execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double NUM1 = (double)0.0F;
         boolean logic_a = false;
         boolean mahorage = false;
         String STR1 = "";
         Entity entity_a = null;
         ItemStack equipment_item = ItemStack.f_41583_;
         if (entityiterator instanceof LivingEntity) {
            JujutsucraftModVariables.PlayerVariables pVars = null;
            if (entity instanceof Player) {
               pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
            }

            if (entity.getPersistentData().m_128471_("attack")) {
               label190: {
                  ItemStack var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  equipment_item = var10000.m_41777_();
                  if (entity instanceof Player) {
                     Player _plrCldCheck3 = (Player)entity;
                     if (_plrCldCheck3.m_36335_().m_41519_(equipment_item.m_41720_())) {
                        break label190;
                     }
                  }

                  if (equipment_item.m_204117_(ItemTags.create(new ResourceLocation("forge:cursed_tool"))) && (equipment_item.m_41720_() == JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get() || equipment_item.m_41720_() == JujutsucraftModItems.BLACK_ROPE.get())) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get(), 1, 0));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 10, 0));
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                     }

                     if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var10001;
                           MobEffect var10003;
                           int var10005;
                           label165: {
                              var10001 = new MobEffectInstance;
                              var10003 = MobEffects.f_19613_;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label165;
                                 }
                              }

                              var10005 = 0;
                           }

                           var10001.<init>(var10003, 10, var10005, false, false);
                           _entity.m_7292_(var10001);
                        }
                     }
                  }
               }
            }

            ItemStack var31;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var31 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var31 = ItemStack.f_41583_;
            }

            equipment_item = var31.m_41777_();
            if (entity instanceof Player && entity instanceof Player) {
               Player _plrCldCheck15 = (Player)entity;
               if (_plrCldCheck15.m_36335_().m_41519_(equipment_item.m_41720_())) {
                  return;
               }
            }

            if (equipment_item.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || equipment_item.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
               mahorage = entity instanceof Player ? pVars.PlayerCurseTechnique == (double)16.0F || pVars.PlayerCurseTechnique2 == (double)16.0F : entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity || entity instanceof CursedSpiritGrade010Entity;
               NUM1 = (double)0.0F;
               STR1 = "";
               if (NUM1 == (double)0.0F && entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt21 = (LivingEntity)entityiterator;
                  if (_livEnt21.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()) && entity.getPersistentData().m_128471_("attack")) {
                     STR1 = "skill205";
                     if (equipment_item.m_41784_().m_128459_(STR1) == (double)0.0F) {
                        NUM1 = (double)1.0F;
                     } else if (equipment_item.m_41784_().m_128459_(STR1) >= (double)100.0F && mahorage) {
                        STR1 = "";
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get(), 1, 1));
                           }
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                        }
                     }
                  }
               }

               if (NUM1 == (double)0.0F && STR1.equals("") && mahorage) {
                  STR1 = "toLiving";
                  if (equipment_item.m_41784_().m_128459_(STR1) == (double)0.0F) {
                     NUM1 = (double)1.0F;
                  }
               }

               if (NUM1 > (double)0.0F) {
                  for(int index0 = 0; index0 < 800; ++index0) {
                     if (equipment_item.m_41784_().m_128461_("DATA" + Math.round(NUM1)).equals("") || equipment_item.m_41784_().m_128461_("DATA" + Math.round(NUM1)).equals(STR1)) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var31 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var31 = ItemStack.f_41583_;
                        }

                        var31.m_41784_().m_128359_("DATA" + Math.round(NUM1), STR1);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var31 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var31 = ItemStack.f_41583_;
                        }

                        var31.m_41784_().m_128347_(STR1, (double)1.0F);
                        break;
                     }

                     ++NUM1;
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.adaptation_start").getString()), false);
                     }
                  }
               }
            }
         }

      }
   }
}
