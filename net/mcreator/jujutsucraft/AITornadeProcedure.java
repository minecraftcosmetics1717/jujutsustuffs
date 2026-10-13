package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.EntityTornadoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AITornadeProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         ItemStack old_health = ItemStack.f_41583_;
         boolean logic_b = false;
         boolean logic_a = false;
         boolean player = false;
         double x_knockback = (double)0.0F;
         double CNT6 = (double)0.0F;
         double z_knockback = (double)0.0F;
         double z_pos = (double)0.0F;
         double power_attenuation = (double)0.0F;
         double y_knockback = (double)0.0F;
         double num2 = (double)0.0F;
         double distance = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double height = (double)0.0F;
         if (entity instanceof EntityTornadoEntity) {
            EntityTornadoEntity _datEntSetL = (EntityTornadoEntity)entity;
            _datEntSetL.m_20088_().m_135381_(EntityTornadoEntity.DATA_blue, entity.getPersistentData().m_128459_("skill") >= (double)3600.0F && entity.getPersistentData().m_128459_("skill") < (double)3700.0F);
         }

         label265: {
            CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            if (entity instanceof EntityTornadoEntity) {
               EntityTornadoEntity _datEntL4 = (EntityTornadoEntity)entity;
               if ((Boolean)_datEntL4.m_20088_().m_135370_(EntityTornadoEntity.DATA_blue)) {
                  if (entity instanceof EntityTornadoEntity) {
                     EntityTornadoEntity animatable = (EntityTornadoEntity)entity;
                     animatable.setTexture("tornado_blue");
                  }

                  entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("cnt2") > (double)60.0F && !entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }

                  double var10000;
                  label230: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity10 = (LivingEntity)entity;
                        if (_livingEntity10.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10000 = _livingEntity10.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                           break label230;
                        }
                     }

                     var10000 = (double)0.0F;
                  }

                  if (var10000 < (double)6.0F + entity.getPersistentData().m_128459_("cnt6") && entity instanceof LivingEntity) {
                     LivingEntity _livingEntity14 = (LivingEntity)entity;
                     if (_livingEntity14.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        double var10001;
                        label223: {
                           var84 = _livingEntity14.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get());
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity12 = (LivingEntity)entity;
                              if (_livingEntity12.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                 var10001 = _livingEntity12.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                                 break label223;
                              }
                           }

                           var10001 = (double)0.0F;
                        }

                        var84.m_22100_(Math.min(var10001 + 0.2 * CNT6, (double)6.0F + entity.getPersistentData().m_128459_("cnt6")));
                     }
                  }

                  entity.getPersistentData().m_128347_("BlockRange", (double)(2.0F + 2.0F * entity.m_20205_()) * (double)0.5F);
                  entity.getPersistentData().m_128347_("BlockDamage", 0.2 * CNT6);
                  BlockDestroyAllDirectionProcedure.execute(world, x, entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, z, entity);
                  BulletDomainHit2Procedure.execute(world, entity);
                  power_attenuation = (double)1.0F;
                  logic_b = false;

                  for(int index0 = 0; index0 < 5; ++index0) {
                     entity.getPersistentData().m_128347_("Range", Math.min((double)30.0F * power_attenuation * CNT6, (double)50.0F));
                     entity.getPersistentData().m_128347_("knockback", Math.max((double)-2.5F * (1.2 - power_attenuation) * CNT6, (double)-5.0F));
                     Vec3 _center = new Vec3(x, entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, z);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / (double)2.0F), (e) -> true)) {
                        if (entity != entityiterator) {
                           label254: {
                              logic_a = true;
                              if (entityiterator instanceof Player) {
                                 if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != (double)16.0F && ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != (double)16.0F) {
                                    break label254;
                                 }
                              } else if (!(entityiterator instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity)) {
                                 break label254;
                              }

                              ItemStack var85;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                                 var85 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                              } else {
                                 var85 = ItemStack.f_41583_;
                              }

                              old_health = var85.m_41777_();
                              if (entityiterator instanceof Player) {
                                 Player _plrCldCheck29 = (Player)entityiterator;
                                 if (_plrCldCheck29.m_36335_().m_41519_(old_health.m_41720_())) {
                                    break label254;
                                 }
                              }

                              if (old_health.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || old_health.m_41720_() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                                 CompoundTag var86 = old_health.m_41784_();
                                 CompoundTag var87 = entity.getPersistentData();
                                 if (var86.m_128459_("skill" + Math.round(var87.m_128459_("skill"))) >= (double)100.0F) {
                                    logic_a = false;
                                 }
                              }
                           }

                           if (logic_a) {
                              player = entityiterator instanceof Player;
                              x_knockback = entityiterator.m_20185_() - entity.m_20185_();
                              y_knockback = entityiterator.m_20186_() - entity.m_20186_();
                              z_knockback = entityiterator.m_20189_() - entity.m_20189_();
                              num2 = Math.sqrt(Math.pow(x_knockback, (double)2.0F) + Math.pow(y_knockback, (double)2.0F) + Math.pow(z_knockback, (double)2.0F));
                              if (!(num2 < (double)Math.max(entity.m_20205_(), 1.0F)) || entity.getPersistentData().m_128459_("NameRanged_ranged") == entityiterator.getPersistentData().m_128459_("NameRanged")) {
                                 x_knockback = x_knockback / num2 * entity.getPersistentData().m_128459_("knockback");
                                 y_knockback = y_knockback / num2 * entity.getPersistentData().m_128459_("knockback");
                                 z_knockback = z_knockback / num2 * entity.getPersistentData().m_128459_("knockback");
                                 if (!(x_knockback * 1.1 < entityiterator.m_20184_().m_7096_()) && !(x_knockback * 0.9 > entityiterator.m_20184_().m_7096_())) {
                                    x_knockback = entityiterator.m_20184_().m_7096_();
                                 } else {
                                    x_knockback = entityiterator.m_20184_().m_7096_() + x_knockback * 0.05;
                                 }

                                 if (!(y_knockback * 1.1 < entityiterator.m_20184_().m_7098_()) && !(y_knockback * 0.9 > entityiterator.m_20184_().m_7098_())) {
                                    y_knockback = entityiterator.m_20184_().m_7098_();
                                 } else {
                                    y_knockback = entityiterator.m_20184_().m_7098_() + y_knockback * 0.05;
                                 }

                                 if (!(z_knockback * 1.1 < entityiterator.m_20184_().m_7094_()) && !(z_knockback * 0.9 > entityiterator.m_20184_().m_7094_())) {
                                    z_knockback = entityiterator.m_20184_().m_7094_();
                                 } else {
                                    z_knockback = entityiterator.m_20184_().m_7094_() + z_knockback * 0.05;
                                 }

                                 if (entityiterator.m_20096_()) {
                                    y_knockback = Math.max(y_knockback, (double)0.5F * (1.2 - power_attenuation) * CNT6);
                                 }

                                 entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                                 if (player) {
                                    if (entity_a == entityiterator || !world.m_6106_().m_5470_().m_46207_(JujutsucraftModGameRules.JUJUTSUPVP)) {
                                       continue;
                                    }

                                    if (entityiterator instanceof Player) {
                                       Player _plr = (Player)entityiterator;
                                       if (_plr.m_150110_().f_35937_) {
                                          continue;
                                       }
                                    }

                                    if (((<undefinedtype>)(new Object() {
                                       public boolean checkGamemode(Entity _ent) {
                                          if (_ent instanceof ServerPlayer _serverPlayer) {
                                             return _serverPlayer.f_8941_.m_9290_() == GameType.SPECTATOR;
                                          } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                                             return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SPECTATOR;
                                          } else {
                                             return false;
                                          }
                                       }
                                    })).checkGamemode(entityiterator)) {
                                       continue;
                                    }
                                 } else if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entityiterator.getPersistentData().m_128459_("NameRanged")) {
                                    continue;
                                 }

                                 EntityVectorProcedure.execute(entityiterator, x_knockback, Math.min(y_knockback, (double)1.5F), z_knockback);
                              }
                           }
                        }
                     }

                     entity.getPersistentData().m_128347_("knockback", (double)0.0F);
                     power_attenuation *= (double)0.75F;
                  }

                  entity.getPersistentData().m_128347_("Damage", (double)11.0F * CNT6);
                  entity.getPersistentData().m_128347_("knockback", (double)1.0F);
                  entity.getPersistentData().m_128347_("y_knockback", (double)1.0F * CNT6);
                  break label265;
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
               if (LogicOwnerExistProcedure.execute(world, entity) && entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F) {
                  entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                  if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                     entity.m_6021_(entity_a.m_20185_(), entity_a.m_20186_() - (double)entity.m_20206_(), entity_a.m_20189_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity_a.m_20185_(), entity_a.m_20186_() - (double)entity.m_20206_(), entity_a.m_20189_(), entity.m_146908_(), entity.m_146909_());
                     }

                     entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
                     if (entity_a.getPersistentData().m_128459_("skill") <= (double)0.0F) {
                        entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
                     }

                     if (!entity.m_6084_()) {
                        entity_a.getPersistentData().m_128347_("skill", (double)0.0F);
                     }
                  } else {
                     entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
                  }

                  if (!entity_a.m_6084_() && !entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
               }
            } else {
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt2") > (double)25.0F && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }

               BulletDomainHit2Procedure.execute(world, entity);
            }

            entity.getPersistentData().m_128347_("Damage", (double)11.0F * CNT6);
            entity.getPersistentData().m_128347_("knockback", (double)1.0F);
            entity.getPersistentData().m_128347_("y_knockback", 0.15 * CNT6);
         }

         entity.getPersistentData().m_128347_("Range", (double)(2.0F + 2.0F * entity.m_20205_()));
         RangeAttackProcedure.execute(world, x, entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, z, entity);
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)((double)0.5F * CNT6), 0.7F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)((double)0.5F * CNT6), 0.7F, false);
            }
         }

         for(int index1 = 0; index1 < (int)(4.0F * entity.m_20206_()); ++index1) {
            double var88;
            double var10006;
            double var10008;
            double var10010;
            String var10011;
            label140: {
               yaw = Math.toRadians(Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               distance = Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.0F);
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance * (double)entity.m_20205_();
               double var70 = entity.m_20186_() + Math.sin(pitch) * (double)-1.0F * distance * (double)entity.m_20205_();
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance * (double)entity.m_20205_();
               y_pos = var70 + (distance - (double)0.5F) * (double)2.0F * (double)entity.m_20206_();
               var88 = (double)entity.m_20205_() * (double)0.25F;
               var10006 = x_pos + Math.cos(yaw + Math.toRadians((double)90.0F)) * Math.cos(pitch) * distance * (double)entity.m_20205_();
               var10008 = y_pos + Math.sin(pitch) * (double)-1.0F * distance * (double)entity.m_20205_();
               var10010 = z_pos + Math.sin(yaw + Math.toRadians((double)90.0F)) * Math.cos(pitch) * distance * (double)entity.m_20205_();
               if (entity instanceof EntityTornadoEntity) {
                  EntityTornadoEntity _datEntL123 = (EntityTornadoEntity)entity;
                  if ((Boolean)_datEntL123.m_20088_().m_135370_(EntityTornadoEntity.DATA_blue)) {
                     var10011 = "minecraft:cloud";
                     break label140;
                  }
               }

               var10011 = "minecraft:squid_ink";
            }

            ParticleGeneratorProcedure.execute(world, var88, (double)1.0F, (double)0.0F, (double)1.0F, x_pos, var10006, y_pos, var10008, z_pos, var10010, var10011);
         }

      }
   }
}
