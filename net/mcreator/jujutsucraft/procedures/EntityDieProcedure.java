package net.mcreator.jujutsucraft.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.entity.DomainExpansionEntityEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class EntityDieProcedure {
   @SubscribeEvent
   public static void onEntityDeath(LivingDeathEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity().m_9236_(), event.getEntity().m_20185_(), event.getEntity().m_20186_(), event.getEntity().m_20189_(), event.getSource(), event.getEntity());
      }

   }

   public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
      execute((Event)null, world, x, y, z, damagesource, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
      if (damagesource != null && entity != null) {
         ItemStack ITEM1 = ItemStack.f_41583_;
         String STR1 = "";
         String DimensionID = "";
         double NUM1 = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double NUM2 = (double)0.0F;
         if (JujutsucraftModVariables.MapVariables.get(world).BlastGame && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !damagesource.m_276093_(DamageTypes.f_286979_)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21153_((float)((double)0.5F + Math.random()));
            }

            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)entity;
               if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && entity.getPersistentData().m_128459_("skill_domain") > (double)0.0F && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
               }
            }

            if (entity instanceof DomainExpansionEntityEntity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  float var10001;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.m_21233_();
                  } else {
                     var10001 = -1.0F;
                  }

                  _entity.m_21153_(Math.max(var10001, 1.0F));
               }

               if (event != null && event.isCancelable()) {
                  event.setCanceled(true);
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                     label203: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                              double var58 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).m_19564_();
                              break label203;
                           }
                        }

                        double var57 = (double)0.0F;
                     }

                     label198: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                              double var60 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).m_19557_();
                              break label198;
                           }
                        }

                        double var59 = (double)0.0F;
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get());
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        float var62;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var62 = _livEnt.m_21233_();
                        } else {
                           var62 = -1.0F;
                        }

                        _entity.m_21153_((float)Math.max((double)var62 * (double)0.5F, (double)1.0F));
                     }

                     if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                     }

                     return;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt15 = (LivingEntity)entity;
                  if (_livEnt15.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get()) && entity.getPersistentData().m_128459_("Life") > (double)0.0F) {
                     entity.getPersistentData().m_128347_("Life", entity.getPersistentData().m_128459_("Life") - (double)1.0F);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21153_((float)((double)1.0F + Math.random() * 0.1));
                     }

                     if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                     }

                     return;
                  }
               }

               ItemStack var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               ITEM1 = var10000.m_41777_();
               if (ITEM1.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || ITEM1.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                  if (ITEM1.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                        _player.m_150109_().m_6596_();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                     }
                  } else if (ITEM1.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()));
                        _player.m_150109_().m_6596_();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()));
                     }
                  }

                  if (ITEM1.m_41784_().m_128441_("DistributionItem") && ITEM1.m_41784_().m_128471_("DistributionItem")) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     var10000.m_41784_().m_128379_("DistributionItem", true);
                  }
               }

               if (entity instanceof Player) {
                  x_pos = (double)0.0F;
                  z_pos = (double)0.0F;
                  if (world.m_6106_().m_5470_().m_46207_(GameRules.f_46133_)) {
                     double _setval = entity.getPersistentData().m_128459_("friend_num");
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.friend_num_keep = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "clear @s jujutsucraft:cursed_spirit_ball");
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     Commands var56 = entity.m_20194_().m_129892_();
                     CommandSourceStack var61 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                     long var10002 = Math.round(x_pos);
                     var56.m_230957_(var61, "execute in jujutsucraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
                  }

                  DimensionID = ("" + String.valueOf(entity.m_9236_().m_46472_())).replace("ResourceKey[minecraft:dimension / ", "").replace("]", "");
                  if (world instanceof ServerLevel) {
                     ServerLevel _origLevel = (ServerLevel)world;
                     LevelAccessor _worldorig = world;
                     LevelAccessor var32 = _origLevel.m_7654_().m_129880_(ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension")));
                     if (var32 != null) {
                        Vec3 _center = new Vec3((double)0.0F, (double)128.0F, (double)0.0F);

                        for(Entity entityiterator : var32.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)128.0F), (e) -> true)) {
                           if (!(entityiterator instanceof Player) && entityiterator.m_6084_() && entity.m_5446_().getString().equals(entityiterator.getPersistentData().m_128461_("owner_name_data"))) {
                              if (entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker") && entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
                                 if (!var32.m_6106_().m_5470_().m_46207_(GameRules.f_46133_) && entity.m_9236_().m_46472_() != ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension"))) {
                                    entityiterator.m_20256_(new Vec3((Math.random() - (double)0.5F) * (double)2.0F, Math.random() * (double)1.0F, (Math.random() - (double)0.5F) * (double)2.0F));
                                    entityiterator.getPersistentData().m_128347_("friend_num", (double)0.0F);
                                    entityiterator.getPersistentData().m_128347_("friend_num_worker", (double)0.0F);
                                    entityiterator.getPersistentData().m_128359_("OWNER_UUID", "");
                                    entityiterator.getPersistentData().m_128379_("JujutsuSorcerer", false);
                                    entityiterator.getPersistentData().m_128379_("CurseUser", false);
                                    entityiterator.getPersistentData().m_128379_("Player", false);
                                    if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                       entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "data merge entity @s {Invulnerable:0b,PersistenceRequired:0b,NoAI:0b}");
                                    }

                                    if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                       entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "execute in " + DimensionID + " run tp @s " + x + " " + y + " " + z);
                                    }
                                 }
                              } else {
                                 if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                    entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                                 }

                                 if (!entityiterator.m_9236_().m_5776_()) {
                                    entityiterator.m_146870_();
                                 }
                              }
                           }
                        }
                     }

                     world = _worldorig;
                  }
               }

               DespawnRangedAmmoProcedure.execute(world, x, y, z, entity);
               WhenEntityDieProcedure.execute(world, x, y, z, entity);
            }
         }

      }
   }
}
