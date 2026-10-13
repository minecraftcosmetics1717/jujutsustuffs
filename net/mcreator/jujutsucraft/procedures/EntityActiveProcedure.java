package net.mcreator.jujutsucraft.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade010Entity;
import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class EntityActiveProcedure {
   @SubscribeEvent
   public static void onEntityTick(LivingEvent.LivingTickEvent event) {
      execute(event, event.getEntity().m_9236_(), event.getEntity().m_20185_(), event.getEntity().m_20186_(), event.getEntity().m_20189_(), event.getEntity());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute((Event)null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         Entity entity_a = null;
         Entity target = null;
         double old_num = (double)0.0F;
         double NUM2 = (double)0.0F;
         double NUM3 = (double)0.0F;
         double NUM1 = (double)0.0F;
         boolean logic_adaptation = false;
         boolean logic_adaptation_start = false;
         boolean target_reset = false;
         boolean mahorage = false;
         boolean slow_adaptation = false;
         boolean isValidGamemode = false;
         ItemStack equipment_item_orgin = ItemStack.f_41583_;
         if (entity instanceof LivingEntity && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            Entity var37 = var10000;
            if (var37 instanceof LivingEntity) {
               NUM1 = entity.getPersistentData().m_128459_("cnt_target") + (double)1.0F;
               entity.getPersistentData().m_128347_("cnt_target", NUM1);
               if (NUM1 == (double)7.0F && !LogicAttackProcedure.execute(world, entity, var37)) {
                  target_reset = true;
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_target", (double)0.0F);
            }

            if (entity.f_19797_ % 11 == 0) {
               if (JujutsucraftModVariables.MapVariables.get(world).BlastGame) {
                  isValidGamemode = true;
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer sp = (ServerPlayer)entity;
                     isValidGamemode = sp.f_8941_.m_9290_() == GameType.SURVIVAL || sp.f_8941_.m_9290_() == GameType.ADVENTURE;
                  }

                  if (isValidGamemode && entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
                     NUM1 = JujutsucraftModVariables.MapVariables.get(world).BlastGameDistance * (double)0.5F;
                     if (Math.abs(entity.m_20185_() - JujutsucraftModVariables.MapVariables.get(world).BlastGameXCenter) + (double)entity.m_20205_() * (double)0.5F > NUM1 || Math.abs(entity.m_20186_() - JujutsucraftModVariables.MapVariables.get(world).BlastGameYCenter) > NUM1 || Math.abs(entity.m_20189_() - JujutsucraftModVariables.MapVariables.get(world).BlastGameZCenter) + (double)entity.m_20205_() * (double)0.5F > NUM1) {
                        entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), Math.max(entity.m_20184_().m_7098_(), (double)8.0F), entity.m_20184_().m_7094_()));
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_254849_((Entity)null, x, y, z, 4.0F, ExplosionInteraction.MOB);
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 99.0F, 1.0F);
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 99.0F, 1.0F);
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 99.0F, 1.0F);
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 99.0F, 1.0F);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           CommandSourceStack source = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                           _level.m_7654_().m_129892_().m_230957_(source, "particle jujutsucraft:particle_thunder_blue ~ ~ ~ 1 1 1 4 50 force");
                           _level.m_7654_().m_129892_().m_230957_(source, "particle jujutsucraft:particle_broken_glass ~ ~ ~ 1 1 1 4 100 force");
                           _level.m_7654_().m_129892_().m_230957_(source, "particle flash ~ ~ ~ 2 2 2 4 100 force");
                        }

                        entity.m_6074_();
                     }
                  }
               }

               if (!(entity instanceof Player) && entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
                  if (entity.getPersistentData().m_128459_("friend_num_worker") != (double)0.0F) {
                     entity.getPersistentData().m_128347_("cnt_settarget", entity.getPersistentData().m_128459_("cnt_settarget") + (double)1.0F);
                     if (entity.getPersistentData().m_128459_("cnt_settarget") > (double)0.0F) {
                        entity.getPersistentData().m_128347_("cnt_settarget", (double)-3.0F);
                        if (entity.getPersistentData().m_128459_("cnt_target") < (double)6.0F && !entity.getPersistentData().m_128461_("OWNER_UUID").isEmpty()) {
                           entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                           if (entity_a instanceof LivingEntity) {
                              if (GetDistanceIteratorProcedure.execute(entity, entity_a) > (double)5.0F && entity instanceof Mob) {
                                 Mob _entity = (Mob)entity;
                                 _entity.m_21573_().m_26519_(entity_a.m_20185_(), entity_a.m_20186_(), entity_a.m_20189_(), (double)1.25F);
                              }
                           } else {
                              entity.getPersistentData().m_128359_("OWNER_UUID", "");
                           }
                        }

                        SetTargetProcedure.execute(world, x, y, z, entity);
                     }
                  }

                  if (!entity.getPersistentData().m_128461_("TARGET_UUID").isEmpty()) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("TARGET_UUID"));
                     if (entity_a == null) {
                        target_reset = true;
                     } else if (entity_a instanceof LivingEntity && entity_a.m_6084_()) {
                        isValidGamemode = true;
                        if (entity_a instanceof ServerPlayer) {
                           ServerPlayer sp = (ServerPlayer)entity_a;
                           isValidGamemode = sp.f_8941_.m_9290_() == GameType.SURVIVAL || sp.f_8941_.m_9290_() == GameType.ADVENTURE;
                        }

                        if (isValidGamemode) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (var10000 != entity_a) {
                              if (entity instanceof Mob) {
                                 Mob _entity = (Mob)entity;
                                 _entity.m_21573_().m_26573_();
                              }

                              entity.getPersistentData().m_128347_("cnt_target", Math.max(entity.getPersistentData().m_128459_("cnt_target"), (double)20.0F));
                              if (entity instanceof Mob) {
                                 Mob _entity = (Mob)entity;
                                 if (entity_a instanceof LivingEntity) {
                                    LivingEntity _ent = (LivingEntity)entity_a;
                                    _entity.m_6710_(_ent);
                                 }
                              }

                              if (entity instanceof PathfinderMob) {
                                 PathfinderMob _pathfinderMob = (PathfinderMob)entity;
                                 _pathfinderMob.f_21346_.m_25352_(1, new HurtByTargetGoal(_pathfinderMob, new Class[0]));
                              }

                              if (!LogicAttackProcedure.execute(world, entity, entity_a)) {
                                 target_reset = true;
                              }
                           }
                        } else {
                           target_reset = true;
                        }
                     } else {
                        target_reset = true;
                     }
                  }
               }

               if (target_reset) {
                  entity.getPersistentData().m_128359_("TARGET_UUID", "");
                  entity.getPersistentData().m_128347_("cnt_target", (double)0.0F);
                  if (entity instanceof Mob) {
                     Mob _entity = (Mob)entity;
                     _entity.m_6710_((LivingEntity)null);
                     if (entity instanceof PathfinderMob) {
                        PathfinderMob _pathfinderMob = (PathfinderMob)entity;
                        _pathfinderMob.f_21346_.m_25352_(1, new HurtByTargetGoal(_pathfinderMob, new Class[0]));
                     }
                  }
               }
            }

            if (entity.m_6084_() && entity.f_19797_ % 20 == 0) {
               ItemStack var77;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var77 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
               } else {
                  var77 = ItemStack.f_41583_;
               }

               equipment_item_orgin = var77;
               if (equipment_item_orgin.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || equipment_item_orgin.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                  if (entity instanceof Player && entity instanceof Player) {
                     Player _plrCldCheck56 = (Player)entity;
                     if (_plrCldCheck56.m_36335_().m_41519_(equipment_item_orgin.m_41720_())) {
                        return;
                     }
                  }

                  equipment_item_orgin.m_41784_().m_128347_("cnt_adaptation", equipment_item_orgin.m_41784_().m_128459_("cnt_adaptation") + (double)1.0F);
                  JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
                  mahorage = entity instanceof Player ? playerVars.PlayerCurseTechnique == (double)16.0F || playerVars.PlayerCurseTechnique2 == (double)16.0F : entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity || entity instanceof CursedSpiritGrade010Entity;
                  logic_adaptation = false;
                  logic_adaptation_start = false;
                  NUM1 = (double)1.0F;
                  NUM2 = (double)0.0F;
                  NUM3 = (double)0.0F;
                  if (equipment_item_orgin.m_41784_().m_128459_("cnt_adaptation") >= (double)6.0F) {
                     equipment_item_orgin.m_41784_().m_128347_("cnt_adaptation", (double)0.0F);
                     logic_adaptation_start = true;
                     if (mahorage) {
                        float var78;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var78 = _livEnt.m_21223_();
                        } else {
                           var78 = -1.0F;
                        }

                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21233_();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (var78 < var10001) {
                           equipment_item_orgin.m_41784_().m_128347_("cnt_heal", equipment_item_orgin.m_41784_().m_128459_("cnt_heal") + (double)1.0F);
                           if (equipment_item_orgin.m_41784_().m_128459_("cnt_heal") >= (double)2.0F) {
                              equipment_item_orgin.m_41784_().m_128347_("cnt_heal", (double)0.0F);
                              NUM3 = Math.max(NUM3, entity instanceof Player ? 0.2 : 0.1);
                              logic_adaptation = true;
                           }
                        } else {
                           equipment_item_orgin.m_41784_().m_128347_("cnt_heal", (double)0.0F);
                        }
                     }
                  }

                  for(int index0 = 0; index0 < 800; ++index0) {
                     STR1 = equipment_item_orgin.m_41784_().m_128461_("DATA" + Math.round(NUM1));
                     if (STR1.equals("")) {
                        break;
                     }

                     if (equipment_item_orgin.m_41784_().m_128459_(STR1) > (double)0.0F && equipment_item_orgin.m_41784_().m_128459_(STR1) < (double)1000.0F) {
                        slow_adaptation = ((<undefinedtype>)(new Object() {
                           double convert(String s) {
                              try {
                                 return Double.parseDouble(s.trim());
                              } catch (Exception var3) {
                                 return (double)0.0F;
                              }
                           }
                        })).convert(STR1.replace("skill", "")) >= (double)205.0F && ((<undefinedtype>)(new Object() {
                           double convert(String s) {
                              try {
                                 return Double.parseDouble(s.trim());
                              } catch (Exception var3) {
                                 return (double)0.0F;
                              }
                           }
                        })).convert(STR1.replace("skill", "")) <= (double)220.0F;
                        old_num = equipment_item_orgin.m_41784_().m_128459_(STR1);
                        NUM2 = !slow_adaptation && !STR1.contains("domain") ? (double)20.0F : (double)4.0F;
                        if (equipment_item_orgin.m_41784_().m_128459_(STR1) >= (double)100.0F) {
                           NUM2 = (double)Math.round(NUM2 * (double)0.5F);
                        }

                        equipment_item_orgin.m_41784_().m_128347_(STR1, (double)Math.round(equipment_item_orgin.m_41784_().m_128459_(STR1) + NUM2));
                        if (old_num < (double)100.0F && equipment_item_orgin.m_41784_().m_128459_(STR1) >= (double)100.0F) {
                           if (logic_adaptation_start) {
                              if (entity instanceof Player) {
                                 Player _player = (Player)entity;
                                 if (!_player.m_9236_().m_5776_()) {
                                    _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.adaptation_complete").getString()), false);
                                 }
                              }

                              NUM3 = Math.max(NUM3, 0.2);
                              logic_adaptation = true;
                           } else {
                              equipment_item_orgin.m_41784_().m_128347_(STR1, (double)Math.round(99.0F));
                           }
                        } else if (equipment_item_orgin.m_41784_().m_128459_(STR1) >= (double)1000.0F) {
                           if (logic_adaptation_start) {
                              equipment_item_orgin.m_41784_().m_128347_(STR1, (double)Math.round(1000.0F));
                              logic_adaptation = true;
                           } else {
                              equipment_item_orgin.m_41784_().m_128347_(STR1, (double)Math.round(999.0F));
                           }
                        } else if (Math.floor(equipment_item_orgin.m_41784_().m_128459_(STR1) / (double)100.0F) > Math.floor(old_num / (double)100.0F)) {
                           if (logic_adaptation_start) {
                              logic_adaptation = true;
                           } else {
                              equipment_item_orgin.m_41784_().m_128347_(STR1, old_num);
                           }
                        } else if (slow_adaptation) {
                           logic_adaptation = (equipment_item_orgin.m_41784_().m_128459_(STR1) - (double)1.0F) % (double)20.0F == (double)0.0F;
                        }
                     }

                     ++NUM1;
                  }

                  if (logic_adaptation) {
                     if (!(entity instanceof CursedSpiritGrade010Entity) && world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gacon")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gacon")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                        }
                     }

                     if (mahorage && logic_adaptation_start && NUM3 > (double)0.0F) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           float var79;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var79 = _livEnt.m_21223_();
                           } else {
                              var79 = -1.0F;
                           }

                           double var80 = (double)var79;
                           float var10002;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.m_21233_();
                           } else {
                              var10002 = -1.0F;
                           }

                           _entity.m_21153_((float)(var80 + (double)var10002 * NUM3));
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.m_21195_(MobEffects.f_19597_);
                        }

                        if (equipment_item_orgin.m_41784_().m_128459_("skill205") >= (double)1000.0F && entity instanceof ServerPlayer) {
                           ServerPlayer _player = (ServerPlayer)entity;
                           Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_dismantle_cut_the_world"));
                           AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                           if (!_ap.m_8193_()) {
                              for(String criteria : _ap.m_8219_()) {
                                 _player.m_8960_().m_135988_(_adv, criteria);
                              }
                           }
                        }
                     }
                  }
               }
            }

         }
      }
   }
}
