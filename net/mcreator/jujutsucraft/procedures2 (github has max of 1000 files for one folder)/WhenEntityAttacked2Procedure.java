package net.mcreator.jujutsucraft.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.entity.BulletBallProjectileEntity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade010Entity;
import net.mcreator.jujutsucraft.entity.DomainExpansionEntityEntity;
import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.MahitoEntity;
import net.mcreator.jujutsucraft.entity.UroTakakoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class WhenEntityAttacked2Procedure {
   @SubscribeEvent
   public static void onEntityAttacked(LivingAttackEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity().m_9236_(), event.getSource(), event.getEntity(), event.getSource().m_7640_(), event.getSource().m_7639_(), (double)event.getAmount());
      }

   }

   public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
      execute((Event)null, world, damagesource, entity, immediatesourceentity, sourceentity, amount);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
      if (damagesource != null && entity != null && immediatesourceentity != null && sourceentity != null) {
         Entity entity_a = null;
         double old_health = (double)0.0F;
         double NUM2 = (double)0.0F;
         double old_cooldown = (double)0.0F;
         double NUM1 = (double)0.0F;
         double Damage_amount = (double)0.0F;
         boolean cancel = false;
         boolean changeDamage = false;
         boolean logic_a = false;
         boolean guard = false;
         boolean critical_nanami = false;
         boolean use_curse = false;
         boolean critical_ice = false;
         ItemStack mainHandItem = ItemStack.f_41583_;
         ItemStack item_head = ItemStack.f_41583_;
         if (!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:animation")))) {
            JujutsucraftModVariables.PlayerVariables pVars = null;
            if (entity instanceof Player) {
               pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
            }

            if (sourceentity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !sourceentity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo_no_move"))) && LogicStartPassiveProcedure.execute(entity)) {
               label933: {
                  if (entity instanceof Player) {
                     NUM1 = pVars.PlayerCurseTechnique;
                     NUM2 = pVars.PlayerCurseTechnique2;
                  }

                  if (NUM1 == (double)38.0F || NUM2 == (double)38.0F || entity instanceof UroTakakoEntity) {
                     label924: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt5 = (LivingEntity)entity;
                           if (_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              break label924;
                           }
                        }

                        if (sourceentity.m_20205_() + sourceentity.m_20206_() <= (entity.m_20205_() + entity.m_20206_()) * 4.0F && entity instanceof LivingEntity) {
                           LivingEntity _livEnt10 = (LivingEntity)entity;
                           if (_livEnt10.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                              cancel = true;
                           }
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt11 = (LivingEntity)entity;
                     if (_livEnt11.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                        break label933;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt12 = (LivingEntity)entity;
                     if (_livEnt12.m_21023_((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                        int var10000;
                        label856: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                 var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                                 break label856;
                              }
                           }

                           var10000 = 0;
                        }

                        if (var10000 > 0) {
                           cancel = true;
                        }
                     }
                  }
               }
            }

            if (cancel) {
               if (event != null && event.isCancelable()) {
                  event.setCanceled(true);
               }

            } else {
               if (!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:curse"))) && !damagesource.m_276093_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat")))) {
                  cancel = false;
                  LivingEntity var123;
                  if (sourceentity instanceof Mob) {
                     Mob _mobEnt = (Mob)sourceentity;
                     var123 = _mobEnt.m_5448_();
                  } else {
                     var123 = null;
                  }

                  if (var123 instanceof LivingEntity) {
                     if (sourceentity instanceof Mob) {
                        Mob _mobEnt = (Mob)sourceentity;
                        var123 = _mobEnt.m_5448_();
                     } else {
                        var123 = null;
                     }

                     LivingEntity var10001;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     if (var123 == var10001) {
                        cancel = true;
                     }
                  }

                  if (!cancel) {
                     label911: {
                        label892: {
                           if (entity instanceof TamableAnimal) {
                              TamableAnimal _tamEnt = (TamableAnimal)entity;
                              if (_tamEnt.m_21824_()) {
                                 break label892;
                              }
                           }

                           if (!(sourceentity instanceof TamableAnimal)) {
                              break label911;
                           }

                           TamableAnimal _tamEnt = (TamableAnimal)sourceentity;
                           if (!_tamEnt.m_21824_()) {
                              break label911;
                           }
                        }

                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           var123 = _tamEnt.m_269323_();
                        } else {
                           var123 = null;
                        }

                        if (var123 != sourceentity) {
                           if (sourceentity instanceof TamableAnimal) {
                              TamableAnimal _tamEnt = (TamableAnimal)sourceentity;
                              var123 = _tamEnt.m_269323_();
                           } else {
                              var123 = null;
                           }

                           if (var123 != entity) {
                              if (entity instanceof TamableAnimal) {
                                 TamableAnimal _tamEnt = (TamableAnimal)entity;
                                 var123 = _tamEnt.m_269323_();
                              } else {
                                 var123 = null;
                              }

                              LivingEntity var146;
                              if (sourceentity instanceof TamableAnimal) {
                                 TamableAnimal _tamEnt = (TamableAnimal)sourceentity;
                                 var146 = _tamEnt.m_269323_();
                              } else {
                                 var146 = null;
                              }

                              if (var123 != var146) {
                                 break label911;
                              }
                           }
                        }

                        cancel = true;
                     }
                  }

                  if (!world.m_6106_().m_5470_().m_46207_(JujutsucraftModGameRules.JUJUTSUPVP) && (sourceentity instanceof Player || sourceentity.getPersistentData().m_128471_("Player")) && (entity instanceof Player || entity.getPersistentData().m_128471_("Player"))) {
                     label937: {
                        label895: {
                           cancel = true;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt35 = (LivingEntity)entity;
                              if (_livEnt35.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label895;
                              }
                           }

                           if (!(sourceentity instanceof LivingEntity)) {
                              break label937;
                           }

                           LivingEntity _livEnt36 = (LivingEntity)sourceentity;
                           if (!_livEnt36.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              break label937;
                           }
                        }

                        cancel = false;
                     }
                  }

                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var123 = _mobEnt.m_5448_();
                  } else {
                     var123 = null;
                  }

                  label940: {
                     if (var123 != sourceentity || !(entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F)) {
                        if (sourceentity instanceof Mob) {
                           Mob _mobEnt = (Mob)sourceentity;
                           var123 = _mobEnt.m_5448_();
                        } else {
                           var123 = null;
                        }

                        if (var123 != entity || !(sourceentity.getPersistentData().m_128459_("cnt_target") > (double)6.0F)) {
                           break label940;
                        }
                     }

                     cancel = false;
                  }

                  if (!cancel) {
                     if (sourceentity.getPersistentData().m_128459_("friend_num") != (double)0.0F && sourceentity.getPersistentData().m_128459_("friend_num") == entity.getPersistentData().m_128459_("friend_num")) {
                        cancel = true;
                     }

                     if (damagesource.m_276093_(DamageTypes.f_268566_) || damagesource.m_276093_(DamageTypes.f_268464_)) {
                        label925: {
                           label899: {
                              if (sourceentity instanceof LivingEntity) {
                                 LivingEntity _livEnt48 = (LivingEntity)sourceentity;
                                 if (_livEnt48.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()) && sourceentity instanceof LivingEntity) {
                                    LivingEntity _livEnt49 = (LivingEntity)sourceentity;
                                    if (_livEnt49.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                       break label899;
                                    }
                                 }
                              }

                              label783: {
                                 if (sourceentity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)sourceentity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                       var130 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19564_();
                                       break label783;
                                    }
                                 }

                                 var130 = 0;
                              }

                              if (var130 <= 0 && !(sourceentity.getPersistentData().m_128459_("skill") <= (double)-999.0F)) {
                                 break label925;
                              }
                           }

                           cancel = true;
                        }
                     }

                     label775: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt52 = (LivingEntity)entity;
                           if (_livEnt52.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              break label775;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt53 = (LivingEntity)entity;
                           if (_livEnt53.m_21023_((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                              label768: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                       var131 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                                       break label768;
                                    }
                                 }

                                 var131 = 0;
                              }

                              if (var131 > 0) {
                                 cancel = true;
                              }
                           }
                        }
                     }

                     if (immediatesourceentity instanceof BulletBallProjectileEntity) {
                        cancel = true;
                     }

                     if (entity instanceof DomainExpansionEntityEntity) {
                        cancel = true;
                     }
                  }

                  if (cancel) {
                     if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                     }
                  } else if (!(immediatesourceentity instanceof Projectile)) {
                     logic_a = sourceentity.getPersistentData().m_128471_("attack");
                     sourceentity.getPersistentData().m_128379_("attack", true);
                     CursedToolsAbilityProcedure.execute(sourceentity, entity);
                     sourceentity.getPersistentData().m_128379_("attack", logic_a);
                  }
               }

               if (ModList.get().isLoaded("minepiece") && damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:curse")))) {
                  cancel = true;
               }

               if (!cancel) {
                  if (!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:animation"))) && !damagesource.m_276093_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat")))) {
                     JujutsucraftModVariables.PlayerVariables pVarsSource = null;
                     if (sourceentity instanceof Player) {
                        pVarsSource = (JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
                     }

                     Damage_amount = amount;
                     ItemStack var132;
                     if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)sourceentity;
                        var132 = _livEnt.m_21205_();
                     } else {
                        var132 = ItemStack.f_41583_;
                     }

                     mainHandItem = var132.m_41777_();
                     if (!sourceentity.getPersistentData().m_128461_("OWNER_UUID").isEmpty() && (sourceentity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) || sourceentity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F)) {
                        entity_a = GetEntityFromUUIDProcedure.execute(world, sourceentity.getPersistentData().m_128461_("OWNER_UUID"));
                     }

                     if (!(entity_a instanceof LivingEntity)) {
                        entity_a = sourceentity;
                     }

                     EntityAutoGuardProcedure.execute(world, entity, entity_a);
                     CounterProcedure.execute(entity);
                     if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)sourceentity;
                        var132 = _livEnt.m_21205_();
                     } else {
                        var132 = ItemStack.f_41583_;
                     }

                     SetAttributeMainhandProcedure.execute(var132);
                     if ((damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:curse"))) || damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:combat")))) && !sourceentity.getPersistentData().m_128471_("attack")) {
                        if (mainHandItem.m_41720_() != ItemStack.f_41583_.m_41720_() && mainHandItem.m_41784_().m_128441_("CursePower") && mainHandItem.m_41784_().m_128459_("CursePower") != (double)0.0F) {
                           use_curse = true;
                        }
                     } else if (!(immediatesourceentity instanceof Projectile)) {
                        label733: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt77 = (LivingEntity)entity;
                              if (_livEnt77.m_21023_((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                                 break label733;
                              }
                           }

                           CursedToolsAbilityProcedure.execute(sourceentity, entity);
                           EffectAttackProcedure.execute(world, entity, sourceentity);
                        }

                        if (mainHandItem.m_204117_(ItemTags.create(new ResourceLocation("forge:cursed_tool")))) {
                           if (mainHandItem.m_41720_() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                              Damage_amount = (double)1.0F;
                              changeDamage = true;
                           }

                           if (mainHandItem.m_41720_() == JujutsucraftModItems.FESTER_LIFE_BLADE.get()) {
                              changeDamage = true;
                           }
                        }

                        if (sourceentity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)sourceentity;
                           var132 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var132 = ItemStack.f_41583_;
                        }

                        label902: {
                           item_head = var132.m_41777_();
                           NUM1 = (double)0.0F;
                           if (sourceentity instanceof Player && sourceentity instanceof Player) {
                              Player _plrCldCheck83 = (Player)sourceentity;
                              if (_plrCldCheck83.m_36335_().m_41519_(item_head.m_41720_())) {
                                 break label902;
                              }
                           }

                           if (item_head.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || item_head.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                              label939: {
                                 if (sourceentity instanceof Player) {
                                    if (pVarsSource.PlayerCurseTechnique != (double)16.0F && pVarsSource.PlayerCurseTechnique2 != (double)16.0F) {
                                       break label939;
                                    }
                                 } else if (!(sourceentity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) && !(sourceentity instanceof CursedSpiritGrade010Entity)) {
                                    break label939;
                                 }

                                 if (item_head.m_41784_().m_128459_("toLiving") >= (double)100.0F) {
                                    NUM1 = (double)Math.round(Math.floor(item_head.m_41784_().m_128459_("toLiving") / (double)100.0F) * (double)2.5F);
                                    NUM1 = entity.getPersistentData().m_128471_("CursedSpirit") ? NUM1 * (double)-1.0F : NUM1;
                                 }
                              }
                           }
                        }

                        if ((mainHandItem.m_41720_() != ItemStack.f_41583_.m_41720_() || NUM1 != (double)0.0F) && (mainHandItem.m_41784_().m_128441_("CursePower") || NUM1 != (double)0.0F)) {
                           if (mainHandItem.m_41720_() != ItemStack.f_41583_.m_41720_()) {
                              if (NUM1 > (double)0.0F) {
                                 NUM1 += Math.max(mainHandItem.m_41784_().m_128459_("CursePower"), (double)0.0F);
                              } else if (NUM1 < (double)0.0F) {
                                 NUM1 += Math.min(mainHandItem.m_41784_().m_128459_("CursePower"), (double)0.0F);
                              } else {
                                 NUM1 = mainHandItem.m_41784_().m_128459_("CursePower");
                              }
                           }

                           if (NUM1 > (double)0.0F) {
                              Damage_amount *= (double)1.0F + NUM1 * 0.02;
                              changeDamage = true;
                              use_curse = true;
                           } else if (NUM1 < (double)0.0F && entity.getPersistentData().m_128471_("CursedSpirit")) {
                              Damage_amount *= (double)1.0F + Math.abs(NUM1) * 0.2;
                              changeDamage = true;
                              use_curse = true;
                           }
                        }

                        label702: {
                           if (sourceentity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)sourceentity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SPECIAL.get())) {
                                 var135 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SPECIAL.get()).m_19564_();
                                 break label702;
                              }
                           }

                           var135 = 0;
                        }

                        if (var135 >= 1 && entity instanceof LivingEntity) {
                           LivingEntity _livEnt102 = (LivingEntity)entity;
                           if (_livEnt102.m_21023_((MobEffect)JujutsucraftModMobEffects.SPECIAL.get())) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SPECIAL.get());
                              }

                              Damage_amount *= (double)1.5F;
                              critical_nanami = true;
                              changeDamage = true;
                           }
                        }

                        if (entity.m_146889_() * 100.0F >= 5.0F) {
                           entity.m_146917_(0);
                           Damage_amount *= (double)1.5F;
                           critical_ice = true;
                           changeDamage = true;
                        }
                     }

                     if (!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:combat"))) && LogicGuardSuccessProcedure.execute(entity, sourceentity)) {
                        Damage_amount = Math.max(Damage_amount - entity.getPersistentData().m_128459_("Damage"), 0.01);
                        changeDamage = true;
                        guard = true;
                     }

                     if (entity_a instanceof LivingEntity) {
                        LivingEntity _livEnt112 = (LivingEntity)entity_a;
                        if (_livEnt112.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && entity instanceof LivingEntity) {
                           LivingEntity _livEnt113 = (LivingEntity)entity;
                           if (_livEnt113.m_21023_((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                              label691: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                       var136 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                                       break label691;
                                    }
                                 }

                                 var136 = 0;
                              }

                              if (var136 > 0) {
                                 int var10002;
                                 label685: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                          var10002 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                          break label685;
                                       }
                                    }

                                    var10002 = 0;
                                 }

                                 NUM1 = (double)15.0F * ((double)1.0F + (double)var10002 * 0.33);
                                 if (sourceentity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) || sourceentity.getPersistentData().m_128471_("DomainAttack")) {
                                    Damage_amount = Math.max(Damage_amount - NUM1, (double)0.0F);
                                 }

                                 if (sourceentity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                                    sourceentity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_curse"))), entity), (float)NUM1);
                                 }
                              }
                           }
                        }
                     }

                     if (entity.getPersistentData().m_128471_("CursedSpirit") && !use_curse) {
                        label673: {
                           if (sourceentity instanceof Player) {
                              if (!(pVarsSource.PlayerCursePowerFormer < (double)100.0F) || LogicUseMinePieceProcedure.execute(sourceentity)) {
                                 break label673;
                              }
                           } else if (!sourceentity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
                              break label673;
                           }

                           Damage_amount = 0.01;
                           changeDamage = true;
                        }
                     }

                     label905: {
                        if (entity instanceof Player) {
                           if (pVars.PlayerCurseTechnique != (double)15.0F && pVars.PlayerCurseTechnique2 != (double)15.0F) {
                              break label905;
                           }
                        } else if (!(entity instanceof MahitoEntity)) {
                           break label905;
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt126 = (LivingEntity)entity;
                           if (_livEnt126.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                              break label905;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt127 = (LivingEntity)entity;
                           if (_livEnt127.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                              break label905;
                           }
                        }

                        if (entity_a instanceof Player) {
                           if (entity_a instanceof ServerPlayer) {
                              ServerPlayer _plr129 = (ServerPlayer)entity_a;
                              if (_plr129.m_9236_() instanceof ServerLevel && _plr129.m_8960_().m_135996_(_plr129.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:observation_of_the_soul"))).m_8193_()) {
                                 break label905;
                              }
                           }
                        } else if (entity_a.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:soul_perception")))) {
                           break label905;
                        }

                        if (!sourceentity.getPersistentData().m_128471_("ignore")) {
                           Damage_amount *= (double)0.5F;
                           changeDamage = true;
                        }
                     }

                     if (sourceentity.getPersistentData().m_128471_("ignore")) {
                        changeDamage = true;
                     }

                     if (!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:combat"))) && entity instanceof Player && (entity_a.getPersistentData().m_128471_("jjkChara") || entity_a instanceof Player)) {
                        Damage_amount *= GetDifficultyLevelProcedure.execute(world);
                        changeDamage = true;
                     }

                     if (sourceentity.getPersistentData().m_128471_("ignore") && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.IGNORE_GUARD.get(), 1, 0, false, false));
                        }
                     }

                     double var137;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var137 = (double)_livEnt.m_21223_();
                     } else {
                        var137 = (double)-1.0F;
                     }

                     old_health = var137;
                     if (Damage_amount > (double)0.0F) {
                        if (immediatesourceentity instanceof Projectile) {
                           entity_a = immediatesourceentity;
                        }

                        if (ModList.get().isLoaded("minepiece")) {
                           entity.m_6469_(damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:combat"))) ? new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat"))), entity_a) : new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_curse"))), entity_a), (float)Damage_amount);
                        } else {
                           entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat"))), entity_a), (float)Damage_amount);
                        }
                     }

                     old_cooldown = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
                     float var138;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var138 = _livEnt.m_21223_();
                     } else {
                        var138 = -1.0F;
                     }

                     if ((double)var138 != old_health) {
                        float var147;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var147 = _livEnt.m_21223_();
                        } else {
                           var147 = -1.0F;
                        }

                        double var139 = old_health - (double)var147;
                        double var148;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var148 = (double)_livEnt.m_21233_();
                        } else {
                           var148 = (double)-1.0F;
                        }

                        label626: {
                           NUM1 = var139 / Math.max(var148, 0.1) * (entity instanceof Player ? (double)0.5F : (double)1.0F);
                           if (sourceentity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)sourceentity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.ATTACKING.get())) {
                                 var140 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.ATTACKING.get()).m_19564_();
                                 break label626;
                              }
                           }

                           var140 = 0;
                        }

                        if (var140 >= 1) {
                           NUM1 += 0.2;
                        }

                        label907: {
                           label619: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt154 = (LivingEntity)entity;
                                 if (_livEnt154.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                    break label619;
                                 }
                              }

                              if (!guard) {
                                 break label907;
                              }
                           }

                           label614: {
                              NUM1 *= (double)0.5F;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                    var141 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19564_();
                                    break label614;
                                 }
                              }

                              var141 = 0;
                           }

                           if (var141 <= 0) {
                              label607: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.ATTACKING.get())) {
                                       var142 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.ATTACKING.get()).m_19564_();
                                       break label607;
                                    }
                                 }

                                 var142 = 0;
                              }

                              if (var142 <= 0) {
                                 break label907;
                              }
                           }

                           NUM1 *= (double)0.5F;
                        }

                        if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                           label917: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt159 = (LivingEntity)entity;
                                 if (_livEnt159.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                                    break label917;
                                 }
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt160 = (LivingEntity)entity;
                                 if (_livEnt160.m_21023_((MobEffect)JujutsucraftModMobEffects.EFFECT_KIRIN.get())) {
                                    break label917;
                                 }
                              }

                              label594: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.ATTACKING.get())) {
                                       var143 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.ATTACKING.get()).m_19564_();
                                       break label594;
                                    }
                                 }

                                 var143 = 0;
                              }

                              if (var143 < 9) {
                                 if (damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:curse"))) || damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:combat")))) {
                                    if (sourceentity.getPersistentData().m_128471_("attack")) {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          if (!_entity.m_9236_().m_5776_()) {
                                             _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 4, 0, false, false));
                                          }
                                       }
                                    } else if (entity instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entity;
                                       if (!_entity.m_9236_().m_5776_()) {
                                          _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 4, 0, false, false));
                                       }
                                    }
                                 }

                                 if (NUM1 >= 0.05) {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entity;
                                       if (!_entity.m_9236_().m_5776_()) {
                                          _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STUN.get(), 10, 0, false, false));
                                       }
                                    }

                                    if (NUM1 >= 0.1) {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          if (!_entity.m_9236_().m_5776_()) {
                                             _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, (int)Math.round(Math.min(NUM1 * (double)75.0F, (double)60.0F)), (int)Math.round(NUM1 * (double)5.0F), false, false));
                                          }
                                       }

                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          if (!_entity.m_9236_().m_5776_()) {
                                             _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)Math.round(Math.min(NUM1 * (double)75.0F, (double)60.0F)), 0, false, false));
                                          }
                                       }

                                       if (NUM1 >= 0.2) {
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _entity = (LivingEntity)entity;
                                             if (!_entity.m_9236_().m_5776_()) {
                                                _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STUN.get(), (int)Math.round(Math.min(NUM1 * (double)75.0F, (double)60.0F)), 1, false, false));
                                             }
                                          }

                                          label579: {
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                   var139 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                                                   break label579;
                                                }
                                             }

                                             var139 = (double)0.0F;
                                          }

                                          Damage_amount = var139;
                                          if (Damage_amount > (double)0.0F && Damage_amount <= (double)600.0F && entity instanceof LivingEntity) {
                                             LivingEntity _entity = (LivingEntity)entity;
                                             _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        if (critical_nanami) {
                           critical_nanami = false;
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                              } else {
                                 _level.m_7785_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                              }
                           }

                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_NANAMI_2.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), 1, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.25F);
                           }

                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_8767_(ParticleTypes.f_123797_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), 25, (double)0.25F, (double)0.25F, (double)0.25F, (double)0.5F);
                           }
                        }

                        if (critical_ice) {
                           critical_ice = false;
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.2F);
                              } else {
                                 _level.m_7785_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.2F, false);
                              }
                           }

                           world.m_46796_(2001, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_()), Block.m_49956_(Blocks.f_50126_.m_49966_()));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var138 = _livEnt.m_21223_();
                     } else {
                        var138 = -1.0F;
                     }

                     label910: {
                        if ((double)var138 == old_health && entity instanceof LivingEntity) {
                           LivingEntity _livEnt199 = (LivingEntity)entity;
                           if (_livEnt199.m_21023_((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                              break label910;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt200 = (LivingEntity)entity;
                           if (_livEnt200.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                              if (!(entity instanceof LivingEntity)) {
                                 break label910;
                              }

                              LivingEntity _livEnt201 = (LivingEntity)entity;
                              if (!_livEnt201.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                 break label910;
                              }
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get(), 3, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_GUARD.get(), 10, 0, false, false));
                           }
                        }

                        if (!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:combat")))) {
                           if (guard) {
                              GuardEffectProcedureProcedure.execute(world, entity.m_20185_() + (double)entity.m_20205_() * (Math.random() - (double)0.5F), entity.m_20186_() + (double)entity.m_20206_() * Math.random(), entity.m_20189_() + (double)entity.m_20205_() * (Math.random() - (double)0.5F), sourceentity, entity);
                           }

                           if (!(immediatesourceentity instanceof Projectile) && (!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:curse"))) && !damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:combat"))) || sourceentity.getPersistentData().m_128471_("attack"))) {
                              DamageEffectProcedureProcedure.execute(world, sourceentity, entity, amount);
                           }
                        }
                     }

                     if (immediatesourceentity instanceof Projectile && !immediatesourceentity.m_9236_().m_5776_()) {
                        immediatesourceentity.m_146870_();
                     }

                     entity.getPersistentData().m_128347_("COOLDOWN_TICKS", old_cooldown);
                     if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                     }

                  }
               }
            }
         }
      }
   }
}
