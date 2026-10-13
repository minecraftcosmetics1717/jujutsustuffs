package net.mcreator.jujutsucraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.jujutsucraft.entity.BloodBallEntity;
import net.mcreator.jujutsucraft.entity.ChosoEntity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade010Entity;
import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.EntityWater2Entity;
import net.mcreator.jujutsucraft.entity.EntityWaterEntity;
import net.mcreator.jujutsucraft.entity.EsoEntity;
import net.mcreator.jujutsucraft.entity.KamoNoritoshiEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaCullingGameEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaEntity;
import net.mcreator.jujutsucraft.entity.SlicingExorcismEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot.Type;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectCharactorProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         String STR1 = "";
         Entity entity_a = null;
         Entity entity_b = null;
         boolean logic_start = false;
         boolean logic_a = false;
         boolean cursed_technique = false;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double NUM1 = (double)0.0F;
         double old_cool = (double)0.0F;
         double y_pos = (double)0.0F;
         double T1 = (double)0.0F;
         double T2 = (double)0.0F;
         ItemStack item_A = ItemStack.f_41583_;
         ItemStack equipment_item_offhand = ItemStack.f_41583_;
         ItemStack equipment_item = ItemStack.f_41583_;
         entity_a = entityiterator;
         if (entityiterator instanceof LivingEntity) {
            cursed_technique = entity.getPersistentData().m_128459_("skill") > (double)100.0F && !entity.getPersistentData().m_128471_("attack");
            x_pos = entityiterator.m_20185_();
            y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
            z_pos = entityiterator.m_20189_();
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            equipment_item = var10000.m_41777_();
            if (equipment_item.m_41720_() == JujutsucraftModItems.DRAGON_BONE.get() && entity.getPersistentData().m_128471_("attack")) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               var10000.m_41784_().m_128347_("power_energy", Math.min(equipment_item.m_41784_().m_128459_("power_energy") + Math.min(Math.max(entity.getPersistentData().m_128459_("cnt6"), 0.1), (double)5.0F), (double)10.0F));
            }

            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entityiterator;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            equipment_item = var10000.m_41777_();
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entityiterator;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            equipment_item_offhand = var10000.m_41777_();
            if (equipment_item.m_41720_() == JujutsucraftModItems.DRAGON_BONE.get() || equipment_item_offhand.m_41720_() == JujutsucraftModItems.DRAGON_BONE.get()) {
               label514: {
                  if (!entityiterator.getPersistentData().m_128471_("attack")) {
                     label461: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt19 = (LivingEntity)entityiterator;
                           if (_livEnt19.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                              break label461;
                           }
                        }

                        if (!entityiterator.getPersistentData().m_128471_("guard")) {
                           break label514;
                        }
                     }
                  }

                  if (equipment_item.m_41720_() == JujutsucraftModItems.DRAGON_BONE.get()) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entityiterator;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     var10000.m_41784_().m_128347_("power_energy", Math.min(equipment_item.m_41784_().m_128459_("power_energy") + Math.min(Math.max(entity.getPersistentData().m_128459_("cnt6"), 0.1), (double)5.0F), (double)10.0F));
                  }

                  if (equipment_item_offhand.m_41720_() == JujutsucraftModItems.DRAGON_BONE.get()) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entityiterator;
                        var10000 = _livEnt.m_21206_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     var10000.m_41784_().m_128347_("power_energy", Math.min(equipment_item_offhand.m_41784_().m_128459_("power_energy") + Math.min(Math.max(entity.getPersistentData().m_128459_("cnt6"), 0.1), (double)5.0F), (double)10.0F));
                  }
               }
            }

            if (entityiterator instanceof Player) {
               JujutsucraftModVariables.PlayerVariables pVars = (JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
               T1 = pVars.PlayerCurseTechnique;
               T2 = pVars.PlayerCurseTechnique2;
            }

            label484: {
               label452: {
                  if (entity instanceof EntityWaterEntity) {
                     int var96;
                     if (entity instanceof EntityWaterEntity) {
                        EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
                        var96 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
                     } else {
                        var96 = 0;
                     }

                     if (var96 == 0) {
                        break label452;
                     }
                  }

                  if (!(entity instanceof EntityWater2Entity)) {
                     break label484;
                  }
               }

               label485: {
                  if (entityiterator instanceof Player) {
                     if (T1 == (double)10.0F || T2 == (double)10.0F) {
                        break label485;
                     }
                  } else if (entityiterator instanceof ChosoEntity || entityiterator instanceof EsoEntity || entityiterator instanceof KamoNoritoshiEntity) {
                     break label485;
                  }

                  label431: {
                     if (entityiterator instanceof EntityWaterEntity) {
                        int var97;
                        if (entityiterator instanceof EntityWaterEntity) {
                           EntityWaterEntity _datEntI = (EntityWaterEntity)entityiterator;
                           var97 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
                        } else {
                           var97 = 0;
                        }

                        if (var97 == 2) {
                           break label431;
                        }
                     }

                     if (!(entityiterator instanceof BloodBallEntity) && !(entityiterator instanceof SlicingExorcismEntity)) {
                        break label484;
                     }
                  }

                  if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                     entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                  }

                  if (!entityiterator.m_9236_().m_5776_()) {
                     entityiterator.m_146870_();
                  }
                  break label484;
               }

               old_cool = entityiterator.getPersistentData().m_128459_("COOLDOWN_TICKS");
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 60, 0, false, false));
                  }
               }

               entityiterator.getPersistentData().m_128347_("COOLDOWN_TICKS", old_cool);
            }

            if (entity.getPersistentData().m_128471_("attack")) {
               EffectAttackProcedure.execute(world, entityiterator, entity);
            }

            if (cursed_technique && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_cursed_technique"))) && entity.getPersistentData().m_128459_("skill") != (double)705.0F) {
               label418: {
                  if (entityiterator instanceof Player) {
                     if (T1 != (double)5.0F && T2 != (double)5.0F) {
                        break label418;
                     }
                  } else if (!(entityiterator instanceof OkkotsuYutaEntity) && !(entityiterator instanceof OkkotsuYutaCullingGameEntity)) {
                     break label418;
                  }

                  if (LocateRikaProcedure.execute(world, entityiterator)) {
                     if (entity.getPersistentData().m_128459_("skill") >= (double)305.0F && entity.getPersistentData().m_128459_("skill") < (double)320.0F) {
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_copy_cursed_speech"));
                           AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                           if (!_ap.m_8193_()) {
                              for(String criteria : _ap.m_8219_()) {
                                 _player.m_8960_().m_135988_(_adv, criteria);
                              }
                           }
                        }
                     } else if (entity.getPersistentData().m_128459_("skill") == (double)3810.0F && (entityiterator instanceof Player || entityiterator instanceof OkkotsuYutaCullingGameEntity)) {
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entityiterator;
                           Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_copy_takako_uro"));
                           AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                           if (!_ap.m_8193_()) {
                              for(String criteria : _ap.m_8219_()) {
                                 _player.m_8960_().m_135988_(_adv, criteria);
                              }
                           }
                        }
                     } else {
                        if (entityiterator instanceof Player) {
                           logic_a = true;
                           AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                           LazyOptional var100 = entityiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                           Objects.requireNonNull(_iitemhandlerref);
                           var100.ifPresent(_iitemhandlerref::set);
                           if (_iitemhandlerref.get() != null) {
                              for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                                 ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                                 if (itemstackiterator.m_41720_() == JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get() && itemstackiterator.m_41784_().m_128459_("skill") == entity.getPersistentData().m_128459_("skill")) {
                                    if (itemstackiterator.m_41613_() < 10 && entityiterator instanceof Player) {
                                       Player _player = (Player)entityiterator;
                                       ItemStack _setstack = itemstackiterator.m_41777_();
                                       _setstack.m_41764_(1);
                                       ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                                    }

                                    logic_a = false;
                                    break;
                                 }
                              }
                           }

                           item_A = (new ItemStack((ItemLike)JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get())).m_41777_();
                           item_A.m_41721_(item_A.m_41776_() - 1);
                        } else {
                           logic_a = false;
                           NUM1 = (double)0.0F;

                           for(int index0 = 0; index0 < 4; ++index0) {
                              if (entity_a instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entity_a;
                                 var10000 = _entGetArmor.m_6844_(EquipmentSlot.m_20744_(Type.ARMOR, (int)NUM1));
                              } else {
                                 var10000 = ItemStack.f_41583_;
                              }

                              item_A = var10000;
                              if (item_A.m_41784_().m_128459_("skill") == (double)0.0F || item_A.m_41784_().m_128459_("skill") == entity.getPersistentData().m_128459_("skill")) {
                                 logic_a = true;
                                 break;
                              }

                              ++NUM1;
                              if (NUM1 > (double)3.0F) {
                                 NUM1 = (double)0.0F;
                              }
                           }

                           if (!logic_a) {
                              logic_a = true;
                              NUM1 = Math.floor(Math.random() * (double)4.0F);
                              if (entity_a instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entity_a;
                                 var10000 = _entGetArmor.m_6844_(EquipmentSlot.m_20744_(Type.ARMOR, (int)NUM1));
                              } else {
                                 var10000 = ItemStack.f_41583_;
                              }

                              item_A = var10000;
                           }
                        }

                        if (logic_a) {
                           double var10002;
                           label357: {
                              entity_b = entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) ? GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID")) : entity;
                              entity_b = entity_b instanceof LivingEntity ? entity_b : entity;
                              item_A.m_41784_().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
                              item_A.m_41784_().m_128347_("effect", entity.getPersistentData().m_128459_("effect"));
                              var101 = item_A.m_41784_();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                    var10002 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).m_19557_();
                                    break label357;
                                 }
                              }

                              var10002 = (double)0.0F;
                           }

                           var101.m_128347_("COOLDOWN_TICKS", (double)Math.round(Math.max(Math.max(var10002, entity.getPersistentData().m_128459_("COOLDOWN_TICKS")) * (double)2.0F, (double)50.0F)));
                           if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                              item_A.m_41784_().m_128359_("SHIKIGAMI_NAME", ForgeRegistries.ENTITY_TYPES.getKey(entity.m_6095_()).toString());
                              CompoundTag var102 = item_A.m_41784_();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var10002 = (double)_livEnt.m_21233_();
                              } else {
                                 var10002 = (double)-1.0F;
                              }

                              var102.m_128347_("SHIKIGAMI_HP", var10002);
                           }

                           if (entity_a instanceof Player) {
                              String var10001 = entity_b.m_5446_().getString();
                              item_A.m_41714_(Component.m_237113_(var10001 + Component.m_237115_("jujutsu.message.cursed_technique").getString() + " (" + Component.m_237115_("jujutsu.overlay.cost").getString() + ": " + Math.round(item_A.m_41784_().m_128459_("COOLDOWN_TICKS")) + ")"));
                              if (entity_a instanceof Player) {
                                 Player _player = (Player)entity_a;
                                 ItemStack _setstack = item_A.m_41777_();
                                 _setstack.m_41764_(1);
                                 ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                              }
                           }
                        }
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == (double)2815.0F && entity_a.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entity_a.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_cursed_technique"))) && !entity_a.m_6084_() && !entity_a.m_9236_().m_5776_()) {
               entity_a.m_146870_();
            }

            if (entity_a instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity_a;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.f_41583_;
            }

            equipment_item = var10000.m_41777_();
            if (equipment_item.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || equipment_item.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
               label519: {
                  if (entity_a instanceof Player) {
                     Player _plrCldCheck108 = (Player)entity_a;
                     if (_plrCldCheck108.m_36335_().m_41519_(equipment_item.m_41720_())) {
                        break label519;
                     }
                  }

                  logic_start = false;
                  if (cursed_technique) {
                     CompoundTag var104 = entity.getPersistentData();
                     STR1 = "skill" + Math.round(var104.m_128459_("skill"));
                     logic_start = true;
                  } else if (entity.getPersistentData().m_128459_("skill_domain") != (double)0.0F) {
                     CompoundTag var105 = entity.getPersistentData();
                     STR1 = "domain" + Math.round(var105.m_128459_("skill_domain"));
                     logic_start = true;
                  }

                  if (logic_start && equipment_item.m_41784_().m_128459_(STR1) == (double)0.0F) {
                     NUM1 = (double)1.0F;

                     for(int index1 = 0; index1 < 800; ++index1) {
                        if (equipment_item.m_41784_().m_128461_("DATA" + Math.round(NUM1)).equals("") || equipment_item.m_41784_().m_128461_("DATA" + Math.round(NUM1)).equals(STR1)) {
                           if (entity_a instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity_a;
                              var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41784_().m_128359_("DATA" + Math.round(NUM1), STR1);
                           if (entity_a instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity_a;
                              var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           var10000.m_41784_().m_128347_(STR1, (double)1.0F);
                           if (entity_a instanceof Player) {
                              Player _player = (Player)entity_a;
                              if (!_player.m_9236_().m_5776_()) {
                                 _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.adaptation_start").getString()), false);
                              }
                           }
                           break;
                        }

                        ++NUM1;
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.f_41583_;
            }

            equipment_item = var10000.m_41777_();
            if (equipment_item.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || equipment_item.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
               label520: {
                  if (entity instanceof Player) {
                     Player _plrCldCheck124 = (Player)entity;
                     if (_plrCldCheck124.m_36335_().m_41519_(equipment_item.m_41720_())) {
                        break label520;
                     }
                  }

                  if (entity_a.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                     label497: {
                        if (entity instanceof Player) {
                           JujutsucraftModVariables.PlayerVariables pVars_target = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
                           T1 = pVars_target.PlayerCurseTechnique;
                           T2 = pVars_target.PlayerCurseTechnique2;
                        }

                        if (entity instanceof Player) {
                           if (T1 != (double)16.0F && T2 != (double)16.0F) {
                              break label497;
                           }
                        } else if (!(entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) && !(entity instanceof CursedSpiritGrade010Entity)) {
                           break label497;
                        }

                        CompoundTag var109 = equipment_item.m_41784_();
                        CompoundTag var110 = entity_a.getPersistentData();
                        if (var109.m_128459_("skill" + Math.round(var110.m_128459_("skill"))) >= (double)100.0F && !entity_a.m_9236_().m_5776_() && entity_a.m_20194_() != null) {
                           entity_a.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity_a.m_20182_(), entity_a.m_20155_(), entity_a.m_9236_() instanceof ServerLevel ? (ServerLevel)entity_a.m_9236_() : null, 4, entity_a.m_7755_().getString(), entity_a.m_5446_(), entity_a.m_9236_().m_7654_(), entity_a), "kill @s");
                        }
                     }
                  }
               }
            }

            if (!entity_a.m_6084_() && entity_a instanceof Player && !(entity instanceof Player)) {
               entity_b = entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) ? GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID")) : entity;
               entity_b = entity_b instanceof LivingEntity ? entity_b : entity;
               if (!(entity_b instanceof Player)) {
                  NUM1 = (double)1.0F;

                  for(int index2 = 0; index2 < 128; ++index2) {
                     STR1 = "pName" + Math.round(NUM1);
                     if (entity_b.getPersistentData().m_128461_(STR1).equals("")) {
                        entity_b.getPersistentData().m_128359_(STR1, entity_a.m_5446_().getString());
                        break;
                     }

                     ++NUM1;
                  }
               }
            }

         }
      }
   }
}
