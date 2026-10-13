package net.mcreator.jujutsucraft.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.entity.CoffinEntity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade010Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade15Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade23Entity;
import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.GreatSerpentEntity;
import net.mcreator.jujutsucraft.entity.Killer1Entity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class WhenEntityAttacked1Procedure {
   @SubscribeEvent
   public static void onEntityAttacked(LivingAttackEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity().m_9236_(), event.getSource(), event.getEntity(), (double)event.getAmount());
      }

   }

   public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity, double amount) {
      execute((Event)null, world, damagesource, entity, amount);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity, double amount) {
      if (damagesource != null && entity != null) {
         ItemStack item_head = ItemStack.f_41583_;
         String damage_string = "";
         double damageAmount = (double)0.0F;
         if (!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:animation")))) {
            if (!damagesource.m_276093_(DamageTypes.f_286979_) && !damagesource.m_276093_(DamageTypes.f_268724_) && !damagesource.m_276093_(DamageTypes.f_286973_)) {
               label320: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt4 = (LivingEntity)entity;
                     if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                        if (!(entity instanceof LivingEntity)) {
                           break label320;
                        }

                        LivingEntity _livEnt5 = (LivingEntity)entity;
                        if (!_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                           break label320;
                        }
                     }
                  }

                  if (entity.m_9236_().m_46472_() == ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
                     if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                     }

                     return;
                  }

                  if (!damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:curse"))) && !damagesource.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:combat")))) {
                     if (damagesource.m_276093_(DamageTypes.f_268612_)) {
                        if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
                           if (event != null && event.isCancelable()) {
                              event.setCanceled(true);
                           }

                           return;
                        }

                        if (entity instanceof Killer1Entity || entity instanceof GreatSerpentEntity || entity instanceof CursedSpiritGrade15Entity || entity instanceof CursedSpiritGrade23Entity) {
                           if (event != null && event.isCancelable()) {
                              event.setCanceled(true);
                           }

                           return;
                        }

                        if (entity.getPersistentData().m_128471_("CursedSpirit")) {
                           int var10000;
                           label279: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label279;
                                 }
                              }

                              var10000 = 0;
                           }

                           if (var10000 <= 3) {
                              if (event != null && event.isCancelable()) {
                                 event.setCanceled(true);
                              }

                              return;
                           }
                        }

                        if (!world.m_6443_(CoffinEntity.class, AABB.m_165882_(new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), 0.1, 0.1, 0.1), (e) -> true).isEmpty()) {
                           if (event != null && event.isCancelable()) {
                              event.setCanceled(true);
                           }

                           return;
                        }
                     }

                     if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) || !damagesource.m_276093_(DamageTypes.f_268585_) && !damagesource.m_276093_(DamageTypes.f_268469_) && !damagesource.m_276093_(DamageTypes.f_268656_) && !damagesource.m_276093_(DamageTypes.f_268440_) && !damagesource.m_276093_(DamageTypes.f_268493_) && !damagesource.m_276093_(DamageTypes.f_268752_) && !damagesource.m_276093_(DamageTypes.f_268722_) && !damagesource.m_276093_(DamageTypes.f_268434_) && !damagesource.m_276093_(DamageTypes.f_268444_) && !damagesource.m_276093_(DamageTypes.f_268515_) && !damagesource.m_276093_(DamageTypes.f_268441_)) {
                        if (!damagesource.m_276093_(DamageTypes.f_268433_)) {
                           ItemStack var23;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var23 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var23 = ItemStack.f_41583_;
                           }

                           item_head = var23;
                           if (item_head.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || item_head.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                              if (entity instanceof Player && entity instanceof Player) {
                                 Player _plrCldCheck39 = (Player)entity;
                                 if (_plrCldCheck39.m_36335_().m_41519_(item_head.m_41720_())) {
                                    return;
                                 }
                              }

                              JujutsucraftModVariables.PlayerVariables pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
                              if (entity instanceof Player) {
                                 if (pVars.PlayerCurseTechnique != (double)16.0F && pVars.PlayerCurseTechnique2 != (double)16.0F) {
                                    return;
                                 }
                              } else if (!(entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) && !(entity instanceof CursedSpiritGrade010Entity)) {
                                 return;
                              }

                              damage_string = "" + String.valueOf(damagesource);
                              if (item_head.m_41784_().m_128459_(damage_string) <= (double)0.0F) {
                                 item_head.m_41784_().m_128347_(damage_string, Math.max(item_head.m_41784_().m_128459_(damage_string), (double)0.0F));
                                 if (entity instanceof Player) {
                                    Player _player = (Player)entity;
                                    if (!_player.m_9236_().m_5776_()) {
                                       String var10001 = Component.m_237115_("jujutsu.message.adaptation_start").getString();
                                       _player.m_5661_(Component.m_237113_(var10001 + " - " + damage_string), false);
                                    }
                                 }
                              } else if (item_head.m_41784_().m_128459_(damage_string) > (double)1.0F) {
                                 if (event != null && event.isCancelable()) {
                                    event.setCanceled(true);
                                 }

                                 if (item_head.m_41784_().m_128459_(damage_string) >= (double)10.0F) {
                                    if (damagesource.m_276093_(DamageTypes.f_268441_)) {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entity;
                                          _entity.m_21195_(MobEffects.f_19612_);
                                       }

                                       if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                          entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s saturation infinite 0 true");
                                       }
                                    } else if (damagesource.m_276093_(DamageTypes.f_268722_)) {
                                       if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                          entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s water_breathing infinite 0 true");
                                       }

                                       if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                          entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:dolphins_grace infinite 0 true");
                                       }
                                    } else if (!damagesource.m_276093_(DamageTypes.f_268631_) && !damagesource.m_276093_(DamageTypes.f_268468_) && !damagesource.m_276093_(DamageTypes.f_268684_) && !damagesource.m_276093_(DamageTypes.f_268556_) && !damagesource.m_276093_(DamageTypes.f_268546_) && !damagesource.m_276093_(DamageTypes.f_268434_)) {
                                       if (damagesource.m_276093_(DamageTypes.f_268444_)) {
                                          entity.m_146917_(0);
                                       }
                                    } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                       entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s fire_resistance infinite 0 true");
                                    }
                                 } else {
                                    damageAmount = amount / item_head.m_41784_().m_128459_(damage_string);
                                    entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_)), (float)damageAmount);
                                 }
                              }

                              if (item_head.m_41784_().m_128459_(damage_string) < (double)10.0F) {
                                 item_head.m_41784_().m_128347_(damage_string, Math.min(item_head.m_41784_().m_128459_(damage_string) + (double)2.0F, (double)10.0F));
                                 if (item_head.m_41784_().m_128459_(damage_string) >= (double)10.0F && entity instanceof Player) {
                                    Player _player = (Player)entity;
                                    if (!_player.m_9236_().m_5776_()) {
                                       String var24 = Component.m_237115_("jujutsu.message.adaptation_complete").getString();
                                       _player.m_5661_(Component.m_237113_(var24 + " - " + damage_string), false);
                                    }
                                 }

                                 if (!(entity instanceof CursedSpiritGrade010Entity) && world instanceof Level) {
                                    Level _level = (Level)world;
                                    if (!_level.m_5776_()) {
                                       _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gacon")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, (double)1.0F));
                                    } else {
                                       _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gacon")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, (double)1.0F), false);
                                    }
                                 }
                              }
                           }
                        }

                        return;
                     }

                     if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                     }

                     return;
                  }

                  return;
               }

               if (event != null && event.isCancelable()) {
                  event.setCanceled(true);
               }

            }
         }
      }
   }
}
