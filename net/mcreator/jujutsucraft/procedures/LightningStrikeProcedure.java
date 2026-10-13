package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.EntityItemEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class LightningStrikeProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_attack = false;
         double dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double power = (double)0.0F;
         double repeat_num = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double max_power = (double)0.0F;
         double energy = (double)0.0F;
         double repeat_num_now = (double)0.0F;
         double x_target = (double)0.0F;
         double y_target = (double)0.0F;
         double z_target = (double)0.0F;
         double x_pos_test = (double)0.0F;
         double y_pos_test = (double)0.0F;
         double z_pos_test = (double)0.0F;
         double CNT6 = (double)0.0F;
         if ((entity.getPersistentData().m_128459_("cnt1") != (double)0.0F || !entity.m_20069_()) && !(entity.getPersistentData().m_128459_("cnt2") > (double)180.0F)) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)8.0F * ReturnEntitySizeProcedure.execute(entity)), (double)0.25F * (double)entity.m_20205_(), (double)0.25F * (double)entity.m_20206_(), (double)0.25F * (double)entity.m_20205_(), 0.1);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                  }
               }

               for(int index0 = 0; index0 < 100; ++index0) {
                  logic_attack = false;
                  Vec3 _center = new Vec3(x, y, z);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)128.0F), (e) -> true)) {
                     if (entity != entityiterator) {
                        if (!LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           if (!(entityiterator instanceof EntityItemEntity)) {
                              continue;
                           }

                           ItemStack var10000;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                              var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           if (var10000.m_41720_() != JujutsucraftModItems.NYOI_STAFF.get() || !entity.m_20149_().equals(entityiterator.getPersistentData().m_128461_("OWNER_UUID"))) {
                              continue;
                           }
                        }

                        if (entityiterator.getPersistentData().m_128459_("Thunder") >= (double)5.0F) {
                           logic_a = true;
                           logic_attack = true;
                           power = Math.min(entityiterator.getPersistentData().m_128459_("Thunder"), (double)15.0F) - (double)5.0F;
                           dis = GetDistanceIteratorProcedure.execute(entity, entityiterator);
                           x_target = entityiterator.m_20185_();
                           y_target = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F + (double)entityiterator.m_20206_() * (double)0.5F * Math.random();
                           z_target = entityiterator.m_20189_();
                           entityiterator.getPersistentData().m_128347_("Thunder", (double)0.0F);
                           break;
                        }
                     }
                  }

                  if (!logic_attack) {
                     entity.getPersistentData().m_128347_("Damage", max_power);
                     break;
                  }

                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
                  z_pos = entity.m_20189_();
                  energy = (double)1.0F + power * 0.05;
                  repeat_num = (double)Math.round(dis * (double)4.0F + (double)4.0F);
                  repeat_num_now = (double)0.0F;

                  for(int index1 = 0; index1 < (int)repeat_num; ++index1) {
                     repeat_num_now = (double)Math.round(repeat_num_now + (double)1.0F);
                     x_power = x_target - x_pos;
                     y_power = y_target - y_pos;
                     z_power = z_target - z_pos;
                     dis = Math.sqrt(Math.pow(x_power, (double)2.0F) + Math.pow(y_power, (double)2.0F) + Math.pow(z_power, (double)2.0F));
                     if (dis != (double)0.0F) {
                        x_power /= dis * (double)4.0F;
                        y_power /= dis * (double)4.0F;
                        z_power /= dis * (double)4.0F;
                        if (repeat_num_now < repeat_num) {
                           if (repeat_num_now % (double)4.0F == (double)1.0F || world.m_8055_(BlockPos.m_274561_(x_pos + x_power * (double)2.0F, y_pos + y_power * (double)2.0F, z_pos + z_power * (double)2.0F)).m_60815_()) {
                              for(int index2 = 0; index2 < 32; ++index2) {
                                 x_power = (Math.random() - (double)0.5F) * dis * (double)3.0F;
                                 y_power = (Math.random() - (double)0.5F) * dis * (double)3.0F;
                                 z_power = (Math.random() - (double)0.5F) * dis * (double)3.0F;
                                 x_power = x_target + x_power;
                                 y_power = y_target + y_power;
                                 z_power = z_target + z_power;
                                 entity.getPersistentData().m_128347_("x_power", x_power - x_pos);
                                 entity.getPersistentData().m_128347_("y_power", y_power - y_pos);
                                 entity.getPersistentData().m_128347_("z_power", z_power - z_pos);
                                 entity.getPersistentData().m_128347_("cnt2", Math.sqrt(Math.pow(entity.getPersistentData().m_128459_("x_power"), (double)2.0F) + Math.pow(entity.getPersistentData().m_128459_("y_power"), (double)2.0F) + Math.pow(entity.getPersistentData().m_128459_("z_power"), (double)2.0F)));
                                 if (entity.getPersistentData().m_128459_("cnt2") != (double)0.0F) {
                                    entity.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") / (entity.getPersistentData().m_128459_("cnt2") * (double)4.0F));
                                    entity.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") / (entity.getPersistentData().m_128459_("cnt2") * (double)4.0F));
                                    entity.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") / (entity.getPersistentData().m_128459_("cnt2") * (double)4.0F));
                                 }

                                 x_power = entity.getPersistentData().m_128459_("x_power");
                                 y_power = entity.getPersistentData().m_128459_("y_power");
                                 z_power = entity.getPersistentData().m_128459_("z_power");
                                 x_pos_test = x_pos;
                                 y_pos_test = y_pos;
                                 z_pos_test = z_pos;
                                 logic_attack = true;

                                 for(int index3 = 0; index3 < 2; ++index3) {
                                    if (world.m_8055_(BlockPos.m_274561_(x_pos_test, y_pos_test, z_pos_test)).m_60815_()) {
                                       logic_attack = false;
                                       break;
                                    }

                                    x_pos_test += x_power;
                                    y_pos_test += y_power;
                                    z_pos_test += z_power;
                                 }

                                 if (logic_attack) {
                                    break;
                                 }
                              }
                           }

                           x_power = entity.getPersistentData().m_128459_("x_power");
                           y_power = entity.getPersistentData().m_128459_("y_power");
                           z_power = entity.getPersistentData().m_128459_("z_power");
                        }
                     }

                     if (repeat_num_now % (double)2.0F == (double)0.0F) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, (double)0.0F);
                        }

                        if (repeat_num_now % (double)4.0F == (double)0.0F) {
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_8767_(ParticleTypes.f_123747_, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, (double)0.0F);
                           }

                           entity.getPersistentData().m_128347_("Damage", (double)30.0F * energy);
                           entity.getPersistentData().m_128347_("Range", (double)5.0F);
                           entity.getPersistentData().m_128347_("knockback", 0.1);
                           entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                           entity.getPersistentData().m_128347_("effect", (double)1.0F);
                           entity.getPersistentData().m_128347_("effectConfirm", (double)2.0F);
                           RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                           if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, (int)((double)20.0F * energy), (double)0.25F, (double)0.25F, (double)0.25F, (double)0.5F * energy);
                              }

                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)((double)4.0F * energy), (double)0.25F, (double)0.25F, (double)0.25F, (double)0.5F * energy);
                              }

                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)((double)4.0F * energy), (double)0.25F, (double)0.25F, (double)0.25F, (double)0.5F * energy);
                              }

                              entity.getPersistentData().m_128347_("BlockRange", (double)1.0F * energy);
                              entity.getPersistentData().m_128347_("BlockDamage", (double)4.0F * energy);
                              entity.getPersistentData().m_128379_("noEffect", true);
                              BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                           }
                        }
                     }

                     if (repeat_num_now + (double)1.0F >= repeat_num) {
                        if (dis > (double)1.5F) {
                           repeat_num = (double)Math.round(repeat_num + (double)1.0F);
                        } else if (repeat_num_now >= repeat_num) {
                           if (dis < 0.3) {
                              break;
                           }

                           repeat_num = (double)Math.round(repeat_num + (double)1.0F);
                        }
                     }

                     x_pos += x_power;
                     y_pos += y_power;
                     z_pos += z_power;
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)energy, 1.5F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)energy, 1.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)energy, 1.5F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)energy, 1.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)energy, 1.5F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)energy, 1.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, (float)energy, 1.5F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, (float)energy, 1.5F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, (int)((double)25.0F * energy), (double)0.5F, (double)0.5F, (double)0.5F, (double)1.0F * energy);
                  }

                  max_power = Math.max(max_power, entity.getPersistentData().m_128459_("Damage"));
               }

               if (logic_a) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s slowness 1 4 true");
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > (double)10.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }

            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
            z_pos = entity.m_20189_();
            power = entity.getPersistentData().m_128459_("Damage");
            entity.getPersistentData().m_128347_("Damage", (double)10.0F);
            entity.getPersistentData().m_128347_("Range", (double)(2.0F + entity.m_20205_()));
            entity.getPersistentData().m_128347_("knockback", 0.1);
            entity.getPersistentData().m_128347_("effect", (double)9.0F);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            entity.getPersistentData().m_128347_("Damage", Math.max(power, entity.getPersistentData().m_128459_("Damage")));
         } else {
            LightningStrike2Procedure.execute(world, x, y, z, entity);
         }

      }
   }
}
