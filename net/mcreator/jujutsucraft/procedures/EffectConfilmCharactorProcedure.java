package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade010Entity;
import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.PurpleEntity;
import net.mcreator.jujutsucraft.entity.TruckEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectConfilmCharactorProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         Entity entity_a = null;
         Entity entity_b = null;
         String STR1 = "";
         double strength_lv_iterator = (double)0.0F;
         double old_skill = (double)0.0F;
         double old_health = (double)0.0F;
         double NUM2 = (double)0.0F;
         double NUM3 = (double)0.0F;
         double old_damage = (double)0.0F;
         double NUM1 = (double)0.0F;
         double strength_lv = (double)0.0F;
         double T1 = (double)0.0F;
         double T2 = (double)0.0F;
         ItemStack equipment_item = ItemStack.f_41583_;
         if (entityiterator instanceof LivingEntity) {
            if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && !entityiterator.getPersistentData().m_128471_("Ambush") && entity.getPersistentData().m_128459_("friend_num") != entityiterator.getPersistentData().m_128459_("friend_num2")) {
               label334: {
                  if (entity instanceof Player) {
                     if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower == (double)0.0F) {
                        break label334;
                     }
                  } else if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
                     break label334;
                  }

                  entityiterator.getPersistentData().m_128379_("failed_adjustment", true);
               }
            }

            label344: {
               label345: {
                  entity_b = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt10 = (LivingEntity)entity;
                     if (_livEnt10.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                        break label345;
                     }
                  }

                  if (!(entity_b instanceof LivingEntity) || !(entity_b instanceof LivingEntity)) {
                     break label344;
                  }

                  LivingEntity _livEnt12 = (LivingEntity)entity_b;
                  if (!_livEnt12.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                     break label344;
                  }
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
               }

               entity.getPersistentData().m_128379_("ignore", true);
               if (entity instanceof TruckEntity && (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) || entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) && !entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                  entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
               }
            }

            if (entity instanceof PurpleEntity && entity.getPersistentData().m_128471_("explode") && entityiterator instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entityiterator;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
            }

            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt22 = (LivingEntity)entityiterator;
               if (_livEnt22.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                  if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) || entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F) {
                     entity.getPersistentData().m_128379_("Stop", true);
                     entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt27 = (LivingEntity)entity;
                     if (_livEnt27.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get()) && entity.getPersistentData().m_128471_("attack")) {
                        double var10000;
                        label298: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                                 var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get()).m_19564_();
                                 break label298;
                              }
                           }

                           var10000 = (double)0.0F;
                        }

                        label293: {
                           NUM1 = var10000;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                 var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()).m_19564_();
                                 break label293;
                              }
                           }

                           var10000 = (double)0.0F;
                        }

                        label288: {
                           NUM2 = var10000;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                 var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()).m_19557_();
                                 break label288;
                              }
                           }

                           var10000 = (double)0.0F;
                        }

                        NUM3 = var10000;
                        NUM2 = (double)Math.round(NUM2 - Math.ceil((NUM1 + (double)8.0F) / (double)8.0F));
                        NUM1 = (double)Math.round(NUM1 - Math.ceil((NUM1 + (double)8.0F) / (double)8.0F));
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                        }

                        if (NUM2 >= (double)0.0F && entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get(), (int)NUM3, (int)NUM2));
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123808_, x, y, z, 10, (double)0.5F, (double)0.5F, (double)0.5F, (double)1.0F);
                        }
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") > (double)100.0F) {
               ItemStack var81;
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                  var81 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
               } else {
                  var81 = ItemStack.f_41583_;
               }

               equipment_item = var81.m_41777_();
               if (equipment_item.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || equipment_item.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                  label366: {
                     if (entity instanceof Player) {
                        Player _plrCldCheck39 = (Player)entity;
                        if (_plrCldCheck39.m_36335_().m_41519_(equipment_item.m_41720_())) {
                           break label366;
                        }
                     }

                     if (entityiterator instanceof Player) {
                        JujutsucraftModVariables.PlayerVariables pVars = (JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
                        if (pVars != null) {
                           T1 = pVars.PlayerCurseTechnique;
                           T2 = pVars.PlayerCurseTechnique2;
                        }
                     }

                     if (entityiterator instanceof Player) {
                        if (T1 != (double)16.0F && T2 != (double)16.0F) {
                           break label366;
                        }
                     } else if (!(entityiterator instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) && !(entityiterator instanceof CursedSpiritGrade010Entity)) {
                        break label366;
                     }

                     CompoundTag var82 = entity.getPersistentData();
                     STR1 = "skill" + Math.round(var82.m_128459_("skill"));
                     if (equipment_item.m_41784_().m_128459_(STR1) >= (double)100.0F) {
                        old_skill = entityiterator.getPersistentData().m_128459_("skill");
                        old_damage = entityiterator.getPersistentData().m_128459_("Damage");
                        entityiterator.getPersistentData().m_128347_("skill", (double)0.0F);
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 1, (int)Math.round(Math.floor(equipment_item.m_41784_().m_128459_(STR1) / (double)100.0F)), false, false));
                           }
                        }

                        entityiterator.getPersistentData().m_128347_("skill", old_skill);
                        entityiterator.getPersistentData().m_128347_("Damage", Math.max(entityiterator.getPersistentData().m_128459_("Damage"), old_damage));
                        double var83;
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entityiterator;
                           var83 = (double)_livEnt.m_21223_();
                        } else {
                           var83 = (double)-1.0F;
                        }

                        old_health = var83;
                        entityiterator.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat")))), 0.01F);
                        float var10001;
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entityiterator;
                           var10001 = _livEnt.m_21223_();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (old_health != (double)var10001) {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                           }

                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:guard_just")), SoundSource.NEUTRAL, 0.3F, 1.0F);
                              } else {
                                 _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:guard_just")), SoundSource.NEUTRAL, 0.3F, 1.0F, false);
                              }
                           }
                        }
                     }
                  }
               }
            }

            int var84;
            label264: {
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entityiterator;
                  if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                     var84 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                     break label264;
                  }
               }

               var84 = 0;
            }

            if (var84 <= 3 && !(entityiterator instanceof Player)) {
               label256: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var85 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label256;
                     }
                  }

                  var85 = (double)0.0F;
               }

               label251: {
                  strength_lv = var85;
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entityiterator;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var86 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label251;
                     }
                  }

                  var86 = (double)0.0F;
               }

               strength_lv_iterator = var86;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity64 = (LivingEntity)entity;
                  if (_livingEntity64.m_21204_().m_22171_(Attributes.f_22281_)) {
                     double var88;
                     label244: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity65 = (LivingEntity)entity;
                           if (_livingEntity65.m_21204_().m_22171_(Attributes.f_22281_)) {
                              var88 = _livingEntity65.m_21051_(Attributes.f_22281_).m_22115_();
                              break label244;
                           }
                        }

                        var88 = (double)0.0F;
                     }

                     strength_lv += var88 * 0.333;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity66 = (LivingEntity)entity;
                  if (_livingEntity66.m_21204_().m_22171_(Attributes.f_22281_)) {
                     double var89;
                     label233: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livingEntity67 = (LivingEntity)entityiterator;
                           if (_livingEntity67.m_21204_().m_22171_(Attributes.f_22281_)) {
                              var89 = _livingEntity67.m_21051_(Attributes.f_22281_).m_22115_();
                              break label233;
                           }
                        }

                        var89 = (double)0.0F;
                     }

                     strength_lv_iterator += var89 * 0.333;
                  }
               }

               if (strength_lv >= strength_lv_iterator + (double)2.0F) {
                  if (!entity.getPersistentData().m_128471_("ignore")) {
                     double var87 = strength_lv_iterator + (double)1.0F;
                     int var90;
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entityiterator;
                        var90 = _livEnt.m_21230_();
                     } else {
                        var90 = 0;
                     }

                     strength_lv_iterator = var87 + (double)(var90 / 60);
                  }

                  label222: {
                     label353: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt70 = (LivingEntity)entityiterator;
                           if (_livEnt70.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                              break label353;
                           }
                        }

                        if (!entityiterator.getPersistentData().m_128471_("attack") || !(entityiterator.getPersistentData().m_128459_("Damage") > (double)0.0F)) {
                           NUM1 = (double)3.0F;
                           break label222;
                        }
                     }

                     NUM1 = (double)6.0F;
                  }

                  NUM1 *= (double)1.0F + strength_lv_iterator * 0.33;
                  if (entity.getPersistentData().m_128459_("Damage") >= NUM1 * (double)10.0F) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.m_21195_(MobEffects.f_19606_);
                     }

                     if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                        entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                     }
                  }

                  if (strength_lv >= strength_lv_iterator * (double)2.0F && strength_lv >= strength_lv_iterator + (double)10.0F) {
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.m_21195_(MobEffects.f_19606_);
                     }

                     if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                        entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                     }
                  }
               }
            }

         }
      }
   }
}
