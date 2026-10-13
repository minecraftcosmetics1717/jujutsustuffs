package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.SukunaEntity;
import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class SukunaEntityDiesProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         boolean dieOnlySukuna = false;
         if (!entity.m_6084_()) {
            ItemStack var10000;
            if (sourceentity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)sourceentity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == JujutsucraftModItems.EXECUTIONERS_SWORD.get() && (!(sourceentity.getPersistentData().m_128459_("skill") > (double)0.0F) || sourceentity.getPersistentData().m_128471_("attack"))) {
               dieOnlySukuna = true;
            }

            if (sourceentity.getPersistentData().m_128459_("skill") >= (double)2800.0F && sourceentity.getPersistentData().m_128459_("skill") < (double)2850.0F) {
               dieOnlySukuna = true;
            }

            if (dieOnlySukuna) {
               if (entity instanceof SukunaEntity) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ITADORI_YUJI_SHIBUYA.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STUN.get(), 60, 1, false, false));
                           }
                        }

                        entityinstance.m_20256_(new Vec3(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_(), entity.m_20184_().m_7094_()));
                        entityinstance.m_146922_(entity.m_146908_());
                        entityinstance.m_146926_(entity.m_146909_());
                        entityinstance.m_5618_(entityinstance.m_146908_());
                        entityinstance.m_5616_(entityinstance.m_146908_());
                        entityinstance.f_19859_ = entityinstance.m_146908_();
                        entityinstance.f_19860_ = entityinstance.m_146909_();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           NonNullList var65 = _player.m_150109_().f_35975_;
                           ItemStack var10002;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var10002 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var10002 = ItemStack.f_41583_;
                           }

                           var65.set(3, var10002);
                           _player.m_150109_().m_6596_();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           EquipmentSlot var10001 = EquipmentSlot.HEAD;
                           ItemStack var84;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var84 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var84 = ItemStack.f_41583_;
                           }

                           _living.m_8061_(var10001, var84);
                        }

                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           NonNullList var66 = _player.m_150109_().f_35975_;
                           ItemStack var85;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var85 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                           } else {
                              var85 = ItemStack.f_41583_;
                           }

                           if (var85.m_41720_() == JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get()) {
                              var85 = ItemStack.f_41583_;
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var85 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                           } else {
                              var85 = ItemStack.f_41583_;
                           }

                           var66.set(2, var85);
                           _player.m_150109_().m_6596_();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           EquipmentSlot var77 = EquipmentSlot.CHEST;
                           ItemStack var87;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var87 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                           } else {
                              var87 = ItemStack.f_41583_;
                           }

                           if (var87.m_41720_() == JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get()) {
                              var87 = ItemStack.f_41583_;
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var87 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                           } else {
                              var87 = ItemStack.f_41583_;
                           }

                           _living.m_8061_(var77, var87);
                        }

                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           NonNullList var67 = _player.m_150109_().f_35975_;
                           ItemStack var89;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var89 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
                           } else {
                              var89 = ItemStack.f_41583_;
                           }

                           var67.set(1, var89);
                           _player.m_150109_().m_6596_();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           EquipmentSlot var78 = EquipmentSlot.LEGS;
                           ItemStack var90;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var90 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
                           } else {
                              var90 = ItemStack.f_41583_;
                           }

                           _living.m_8061_(var78, var90);
                        }

                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           NonNullList var68 = _player.m_150109_().f_35975_;
                           ItemStack var91;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var91 = _entGetArmor.m_6844_(EquipmentSlot.FEET);
                           } else {
                              var91 = ItemStack.f_41583_;
                           }

                           var68.set(0, var91);
                           _player.m_150109_().m_6596_();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           EquipmentSlot var79 = EquipmentSlot.FEET;
                           ItemStack var92;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var92 = _entGetArmor.m_6844_(EquipmentSlot.FEET);
                           } else {
                              var92 = ItemStack.f_41583_;
                           }

                           _living.m_8061_(var79, var92);
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           ItemStack _setstack = var10000.m_41777_();
                           _setstack.m_41764_(1);
                           _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                           if (_entity instanceof Player) {
                              Player _player = (Player)_entity;
                              _player.m_150109_().m_6596_();
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21206_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           ItemStack _setstack = var10000.m_41777_();
                           _setstack.m_41764_(1);
                           _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                           if (_entity instanceof Player) {
                              Player _player = (Player)_entity;
                              _player.m_150109_().m_6596_();
                           }
                        }

                        _serverLevel.m_7967_(entityinstance);
                     }
                  }

                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               } else if (entity instanceof SukunaFushiguroEntity || entity instanceof SukunaPerfectEntity) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.FUSHIGURO_MEGUMI_SHIBUYA.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STUN.get(), 60, 1, false, false));
                           }
                        }

                        entityinstance.m_20256_(new Vec3(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_(), entity.m_20184_().m_7094_()));
                        entityinstance.m_146922_(entity.m_146908_());
                        entityinstance.m_146926_(entity.m_146909_());
                        entityinstance.m_5618_(entityinstance.m_146908_());
                        entityinstance.m_5616_(entityinstance.m_146908_());
                        entityinstance.f_19859_ = entityinstance.m_146908_();
                        entityinstance.f_19860_ = entityinstance.m_146909_();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           NonNullList var71 = _player.m_150109_().f_35975_;
                           ItemStack var93;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var93 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var93 = ItemStack.f_41583_;
                           }

                           var71.set(3, var93);
                           _player.m_150109_().m_6596_();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           EquipmentSlot var80 = EquipmentSlot.HEAD;
                           ItemStack var94;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var94 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var94 = ItemStack.f_41583_;
                           }

                           _living.m_8061_(var80, var94);
                        }

                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           NonNullList var72 = _player.m_150109_().f_35975_;
                           ItemStack var95;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var95 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                           } else {
                              var95 = ItemStack.f_41583_;
                           }

                           if (var95.m_41720_() == JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get()) {
                              var95 = ItemStack.f_41583_;
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var95 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                           } else {
                              var95 = ItemStack.f_41583_;
                           }

                           var72.set(2, var95);
                           _player.m_150109_().m_6596_();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           EquipmentSlot var81 = EquipmentSlot.CHEST;
                           ItemStack var97;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var97 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                           } else {
                              var97 = ItemStack.f_41583_;
                           }

                           if (var97.m_41720_() == JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get()) {
                              var97 = ItemStack.f_41583_;
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var97 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                           } else {
                              var97 = ItemStack.f_41583_;
                           }

                           _living.m_8061_(var81, var97);
                        }

                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           NonNullList var73 = _player.m_150109_().f_35975_;
                           ItemStack var99;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var99 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
                           } else {
                              var99 = ItemStack.f_41583_;
                           }

                           var73.set(1, var99);
                           _player.m_150109_().m_6596_();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           EquipmentSlot var82 = EquipmentSlot.LEGS;
                           ItemStack var100;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var100 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
                           } else {
                              var100 = ItemStack.f_41583_;
                           }

                           _living.m_8061_(var82, var100);
                        }

                        if (entityinstance instanceof Player) {
                           Player _player = (Player)entityinstance;
                           NonNullList var74 = _player.m_150109_().f_35975_;
                           ItemStack var101;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var101 = _entGetArmor.m_6844_(EquipmentSlot.FEET);
                           } else {
                              var101 = ItemStack.f_41583_;
                           }

                           var74.set(0, var101);
                           _player.m_150109_().m_6596_();
                        } else if (entityinstance instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entityinstance;
                           EquipmentSlot var83 = EquipmentSlot.FEET;
                           ItemStack var102;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var102 = _entGetArmor.m_6844_(EquipmentSlot.FEET);
                           } else {
                              var102 = ItemStack.f_41583_;
                           }

                           _living.m_8061_(var83, var102);
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21205_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           ItemStack _setstack = var10000.m_41777_();
                           _setstack.m_41764_(1);
                           _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                           if (_entity instanceof Player) {
                              Player _player = (Player)_entity;
                              _player.m_150109_().m_6596_();
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21206_();
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           ItemStack _setstack = var10000.m_41777_();
                           _setstack.m_41764_(1);
                           _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                           if (_entity instanceof Player) {
                              Player _player = (Player)_entity;
                              _player.m_150109_().m_6596_();
                           }
                        }

                        _serverLevel.m_7967_(entityinstance);
                     }
                  }

                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               }
            }
         }

      }
   }
}
