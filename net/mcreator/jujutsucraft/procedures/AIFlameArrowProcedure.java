package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.FlameArrowEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIFlameArrowProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a;
         double DUST_AMOUNT;
         double var10000;
         label289: {
            entity_a = null;
            boolean logic_attack = false;
            double strength = (double)0.0F;
            double range = (double)0.0F;
            double x_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double CNT6 = (double)0.0F;
            double y_power = (double)0.0F;
            double z_power = (double)0.0F;
            DUST_AMOUNT = (double)0.0F;
            double x_power = (double)0.0F;
            double num1 = (double)0.0F;
            double y_pos = (double)0.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label289;
               }
            }

            var10000 = (double)0.0F;
         }

         label293: {
            double var40 = var10000;
            double var45 = (double)1.0F;
            if (entity instanceof FlameArrowEntity) {
               FlameArrowEntity _datEntL1 = (FlameArrowEntity)entity;
               if ((Boolean)_datEntL1.m_20088_().m_135370_(FlameArrowEntity.DATA_sync)) {
                  label310: {
                     entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
                     double var49 = x - entity.getPersistentData().m_128459_("old_x");
                     double var47 = y - entity.getPersistentData().m_128459_("old_y");
                     double var48 = z - entity.getPersistentData().m_128459_("old_z");
                     if (entity instanceof FlameArrowEntity) {
                        FlameArrowEntity _datEntL33 = (FlameArrowEntity)entity;
                        if ((Boolean)_datEntL33.m_20088_().m_135370_(FlameArrowEntity.DATA_sync2)) {
                           if (LogicOwnerExistProcedure.execute(world, entity)) {
                              entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                              if (entity_a instanceof LivingEntity) {
                                 label242: {
                                    if (entity_a instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity_a;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          var77 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                          break label242;
                                       }
                                    }

                                    var77 = 0;
                                 }

                                 if (var77 > 0 && !entity_a.getPersistentData().m_128471_("Failed")) {
                                    entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), entity_a.getPersistentData().m_128459_("dust_amount")));
                                    entity_a.getPersistentData().m_128347_("dust_amount", (double)0.0F);
                                 }
                              }
                           }

                           entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                           DUST_AMOUNT = (double)0.25F + entity.getPersistentData().m_128459_("cnt6") / (double)75.0F;
                           var45 = (double)1.0F + DUST_AMOUNT * 0.1;
                           entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
                           double var41 = (double)16.0F * var45;
                           double var43 = entity.getPersistentData().m_128459_("x_pos");
                           double var44 = entity.getPersistentData().m_128459_("z_pos");
                           double var51 = entity.getPersistentData().m_128459_("y_pos");

                           for(int index1 = 0; (long)index1 < Math.round((double)20.0F * DUST_AMOUNT + (double)20.0F); ++index1) {
                              double var50 = 8.399999999999999 * var45 * (DUST_AMOUNT + (double)0.25F) * Math.random() * Math.random();
                              ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, var50 * (double)1.0F, var50 * (double)1.25F, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)12.0F) * ((double)1.0F + DUST_AMOUNT), var43, var43, var51 - var50, var51 + var50, (double)0.0F, var44, var44, "jujutsucraft:particle_flame");
                           }

                           for(int index2 = 0; (long)index2 < Math.round((double)36.0F * ((double)1.0F + DUST_AMOUNT)); ++index2) {
                              ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)4.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)2.0F, (double)2.0F) * ((double)1.0F + DUST_AMOUNT), var43, var43, var51, var51 + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)1.0F), (double)0.0F, var44, var44, Math.random() < (double)0.5F ? "cloud" : "flame");
                              if (DUST_AMOUNT > (double)1.0F && entity.getPersistentData().m_128459_("cnt2") < (var40 - (double)5.0F) * (double)2.0F * var45 * DUST_AMOUNT) {
                                 ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)4.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)4.0F, (double)4.0F) * ((double)1.0F + DUST_AMOUNT), var43, var43, var51, var51 + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)1.0F), (double)0.0F, var44, var44, "jujutsucraft:particle_flame");
                              }
                           }

                           if (DUST_AMOUNT > (double)1.0F && world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var43, var51, var44), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_flame ~ ~ ~ " + (double)5.0F * DUST_AMOUNT + " " + (double)5.0F * DUST_AMOUNT + " " + (double)5.0F * DUST_AMOUNT + " " + (double)2.0F * DUST_AMOUNT + " " + Math.round((double)10.0F * DUST_AMOUNT) + " force");
                           }

                           if (!(entity.getPersistentData().m_128459_("cnt2") < (double)15.0F * var45 * DUST_AMOUNT + (double)3.0F)) {
                              break label310;
                           }

                           entity.getPersistentData().m_128347_("Damage", (double)46.0F);
                           entity.getPersistentData().m_128347_("Range", (double)24.0F * var45 * (DUST_AMOUNT + (double)0.25F));
                           entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                           entity.getPersistentData().m_128347_("knockback", (double)0.5F);
                           entity.getPersistentData().m_128347_("effect", (double)3.0F);
                           entity.getPersistentData().m_128379_("ExtinctionBlock", true);
                           RangeAttackProcedure.execute(world, var43, var51, var44, entity);
                           entity.getPersistentData().m_128379_("ExtinctionBlock", false);
                           if (entity.getPersistentData().m_128459_("cnt2") < (double)3.0F * var45 * DUST_AMOUNT + (double)3.0F) {
                              if (entity.getPersistentData().m_128459_("cnt5") <= Math.min(DUST_AMOUNT, (double)2.0F)) {
                                 entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
                                 entity.getPersistentData().m_128347_("BlockRange", Math.min((double)18.0F * var45 * (DUST_AMOUNT + (double)0.25F), (double)36.0F));
                                 entity.getPersistentData().m_128347_("BlockDamage", (double)24.0F * var45);
                                 entity.getPersistentData().m_128347_("effect", (double)3.0F);
                                 entity.getPersistentData().m_128379_("noParticle", true);
                                 entity.getPersistentData().m_128379_("noEffect", true);
                                 entity.getPersistentData().m_128379_("ExtinctionBlock", true);
                                 BlockDestroyAllDirectionProcedure.execute(world, var43, var51, var44, entity);
                              }

                              if (entity_a instanceof LivingEntity) {
                                 label219: {
                                    if (entity_a instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity_a;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          var78 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                          break label219;
                                       }
                                    }

                                    var78 = 0;
                                 }

                                 if (var78 > 0 && !entity_a.getPersistentData().m_128471_("Failed")) {
                                    entity.getPersistentData().m_128347_("Damage", (double)46.0F);
                                    entity.getPersistentData().m_128347_("Range", (double)6.0F * JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius);
                                    entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
                                    entity.getPersistentData().m_128347_("knockback", (double)0.5F);
                                    entity.getPersistentData().m_128347_("effect", (double)3.0F);
                                    RangeAttackProcedure.execute(world, entity_a.getPersistentData().m_128459_("x_pos_doma"), entity_a.getPersistentData().m_128459_("y_pos_doma"), entity_a.getPersistentData().m_128459_("z_pos_doma"), entity);
                                 }
                              }

                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.m_5776_()) {
                                    _level.m_5594_((Player)null, BlockPos.m_274561_(var43, var51, var44), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)((double)4.0F * (DUST_AMOUNT + (double)0.5F)), 1.0F);
                                 } else {
                                    _level.m_7785_(var43, var51, var44, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)((double)4.0F * (DUST_AMOUNT + (double)0.5F)), 1.0F, false);
                                 }
                              }

                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.m_5776_()) {
                                    _level.m_5594_((Player)null, BlockPos.m_274561_(var43, var51, var44), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)((double)4.0F * (DUST_AMOUNT + (double)0.5F)), 0.75F);
                                 } else {
                                    _level.m_7785_(var43, var51, var44, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)((double)4.0F * (DUST_AMOUNT + (double)0.5F)), 0.75F, false);
                                 }
                              }

                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.m_5776_()) {
                                    _level.m_5594_((Player)null, BlockPos.m_274561_(var43, var51, var44), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)((double)4.0F * (DUST_AMOUNT + (double)0.5F)), 0.5F);
                                 } else {
                                    _level.m_7785_(var43, var51, var44, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)((double)4.0F * (DUST_AMOUNT + (double)0.5F)), 0.5F, false);
                                 }
                              }
                           }

                           var51 = entity.getPersistentData().m_128459_("y_pos") + (entity.getPersistentData().m_128459_("cnt2") - (double)2.0F) * (double)2.0F;
                           var41 = (double)5.0F * var45;
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(var43, var51, var44), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)4.0F * (DUST_AMOUNT + (double)0.5F)), 1.0F);
                              } else {
                                 _level.m_7785_(var43, var51, var44, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)4.0F * (DUST_AMOUNT + (double)0.5F)), 1.0F, false);
                              }
                           }

                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(var43, var51, var44), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)4.0F * (DUST_AMOUNT + (double)0.5F)), 0.75F);
                              } else {
                                 _level.m_7785_(var43, var51, var44, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)4.0F * (DUST_AMOUNT + (double)0.5F)), 0.75F, false);
                              }
                           }

                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(var43, var51, var44), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)4.0F * (DUST_AMOUNT + (double)0.5F)), 0.5F);
                              } else {
                                 _level.m_7785_(var43, var51, var44, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)4.0F * (DUST_AMOUNT + (double)0.5F)), 0.5F, false);
                              }
                           }
                           break label310;
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123744_, x, y, z, 50, 0.3, 0.3, 0.3, (double)0.5F);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 50, 0.3, 0.3, 0.3, (double)0.5F);
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 5.0F, 0.75F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 5.0F, 0.75F, false);
                           }
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123744_, x, y, z, 3, 0.2, 0.2, 0.2, 0.1);
                     }

                     if (Math.random() < 0.05 && world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123745_, x, y, z, 1, 0.2, 0.2, 0.2, 0.1);
                     }

                     entity.getPersistentData().m_128347_("Damage", (double)35.0F);
                     entity.getPersistentData().m_128347_("Range", (double)5.0F);
                     entity.getPersistentData().m_128347_("knockback", (double)0.5F);
                     entity.getPersistentData().m_128347_("effect", (double)3.0F);
                     entity.getPersistentData().m_128347_("effectConfirm", (double)2.0F);
                     entity.getPersistentData().m_128379_("ExtinctionBlock", true);
                     RangeAttackProcedure.execute(world, x, y, z, entity);
                     entity.getPersistentData().m_128379_("ExtinctionBlock", false);
                     if ((var49 * var49 + var47 * var47 + var48 * var48 < (double)1.0F || entity.m_5830_()) && entity.getPersistentData().m_128459_("cnt1") > (double)5.0F || entity.getPersistentData().m_128459_("cnt1") > (double)60.0F || !entity.m_6084_()) {
                        entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
                     }

                     if (entity.getPersistentData().m_128459_("cnt2") > (double)0.0F) {
                        if (entity instanceof FlameArrowEntity) {
                           FlameArrowEntity _datEntSetL = (FlameArrowEntity)entity;
                           _datEntSetL.m_20088_().m_135381_(FlameArrowEntity.DATA_sync2, true);
                        }

                        entity.getPersistentData().m_128347_("x_pos", x);
                        entity.getPersistentData().m_128347_("y_pos", y);
                        entity.getPersistentData().m_128347_("z_pos", z);
                     }

                     if (entity.getPersistentData().m_128471_("Stop")) {
                        entity.getPersistentData().m_128379_("Stop", true);
                     } else {
                        for(int index0 = 0; index0 < 3; ++index0) {
                           entity.m_6021_(entity.m_20185_() + entity.getPersistentData().m_128459_("x_power") * 0.2, entity.m_20186_() + entity.getPersistentData().m_128459_("y_power") * 0.2, entity.m_20189_() + entity.getPersistentData().m_128459_("z_power") * 0.2);
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + entity.getPersistentData().m_128459_("x_power") * 0.2, entity.m_20186_() + entity.getPersistentData().m_128459_("y_power") * 0.2, entity.m_20189_() + entity.getPersistentData().m_128459_("z_power") * 0.2, entity.m_146908_(), entity.m_146909_());
                           }

                           if (world.m_8055_(BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_())).m_60815_()) {
                              entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
                              entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
                              entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
                              entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
                              break;
                           }
                        }

                        entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)1.0F, entity.getPersistentData().m_128459_("y_power") * (double)1.0F, entity.getPersistentData().m_128459_("z_power") * (double)1.0F));
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt2") >= ((double)15.0F + var40 * (double)1.0F) * (DUST_AMOUNT + (double)0.5F)) {
                     if (!entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }

                     if (LogicOwnerExistProcedure.execute(world, entity)) {
                        entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                        if (entity_a instanceof LivingEntity) {
                           label202: {
                              if (entity_a instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity_a;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    var79 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                    break label202;
                                 }
                              }

                              var79 = 0;
                           }

                           if (var79 > 0 && !entity_a.getPersistentData().m_128471_("Failed") && entity_a instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity_a;
                              _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                           }
                        }
                     }
                  }
                  break label293;
               }
            }

            entity.getPersistentData().m_128379_("Stop", false);
            entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
            entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
            boolean var39 = false;
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged") && entity_a.getPersistentData().m_128459_("skill") > (double)0.0F && entity_a.getPersistentData().m_128459_("cnt1") <= (double)30.0F) {
                  var39 = true;
                  entity.getPersistentData().m_128347_("x_power", entity_a.getPersistentData().m_128459_("x_power"));
                  entity.getPersistentData().m_128347_("y_power", entity_a.getPersistentData().m_128459_("y_power"));
                  entity.getPersistentData().m_128347_("z_power", entity_a.getPersistentData().m_128459_("z_power"));
                  entity.m_146922_(entity_a.m_146908_());
                  entity.m_146926_(entity_a.m_146909_());
                  entity.m_5618_(entity.m_146908_());
                  entity.m_5616_(entity.m_146908_());
                  entity.f_19859_ = entity.m_146908_();
                  entity.f_19860_ = entity.m_146909_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  entity.m_6021_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
                  }
               }
            }

            if (!var39 || !entity.m_6084_()) {
               if (entity instanceof FlameArrowEntity) {
                  FlameArrowEntity _datEntSetL = (FlameArrowEntity)entity;
                  _datEntSetL.m_20088_().m_135381_(FlameArrowEntity.DATA_sync, true);
               }

               entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
            }
         }

         entity.getPersistentData().m_128347_("old_x", x);
         entity.getPersistentData().m_128347_("old_y", y);
         entity.getPersistentData().m_128347_("old_z", z);
      }
   }
}
