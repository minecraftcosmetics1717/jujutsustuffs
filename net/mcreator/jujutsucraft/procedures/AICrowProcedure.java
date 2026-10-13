package net.mcreator.jujutsucraft.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.entity.CrowEntity;
import net.mcreator.jujutsucraft.entity.MeiMeiEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AICrowProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         boolean logic_a = false;
         Entity entity_a = null;
         if (entity.m_6084_()) {
            if (entity instanceof CrowEntity) {
               CrowEntity _datEntL1 = (CrowEntity)entity;
               if ((Boolean)_datEntL1.m_20088_().m_135370_(CrowEntity.DATA_object)) {
                  label289: {
                     entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
                     if (entity.getPersistentData().m_128459_("cnt_life") > (double)160.0F && !entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt6 = (LivingEntity)entity;
                        if (_livEnt6.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                           break label289;
                        }
                     }

                     entity.getPersistentData().m_128347_("cnt_life2", entity.getPersistentData().m_128459_("cnt_life2") + (double)1.0F);
                     if (entity.getPersistentData().m_128459_("cnt_life2") > (double)40.0F && !entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("NameRanged_ranged") == (double)0.0F) {
               AICursedSpirit3FishProcedure.execute(world, x, y, z, entity);
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)20.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  logic_a = false;
                  if (!entity.getPersistentData().m_128461_("OWNER_UUID").isEmpty()) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                     if (entity_a instanceof LivingEntity) {
                        entity.getPersistentData().m_128359_("FOLLOW_ID", entity.getPersistentData().m_128461_("OWNER_UUID"));
                        if (Math.random() < (double)0.25F) {
                           if (entity_a.getPersistentData().m_128459_("NameRanged") == (double)0.0F) {
                              entity.getPersistentData().m_128347_("NameRanged", Math.random());
                           }

                           entity.getPersistentData().m_128347_("NameRanged_ranged", entity_a.getPersistentData().m_128459_("NameRanged"));
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 MobEffectInstance var10001;
                                 MobEffect var10003;
                                 int var10005;
                                 label221: {
                                    var10001 = new MobEffectInstance;
                                    var10003 = MobEffects.f_19600_;
                                    if (entity_a instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity_a;
                                       if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                          var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                          break label221;
                                       }
                                    }

                                    var10005 = 0;
                                 }

                                 var10001.<init>(var10003, Integer.MAX_VALUE, var10005, false, false);
                                 _entity.m_7292_(var10001);
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 5, false, false));
                              }
                           }
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128461_("FOLLOW_ID").isEmpty()) {
                     label207: {
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           if (_tamEnt.m_21824_()) {
                              LivingEntity var10000;
                              if (entity instanceof TamableAnimal) {
                                 TamableAnimal _tamEnt = (TamableAnimal)entity;
                                 var10000 = _tamEnt.m_269323_();
                              } else {
                                 var10000 = null;
                              }

                              if (var10000 instanceof LivingEntity) {
                                 CompoundTag var84 = entity.getPersistentData();
                                 LivingEntity var10002;
                                 if (entity instanceof TamableAnimal) {
                                    TamableAnimal _tamEnt = (TamableAnimal)entity;
                                    var10002 = _tamEnt.m_269323_();
                                 } else {
                                    var10002 = null;
                                 }

                                 var84.m_128359_("FOLLOW_ID", ((Entity)var10002).m_20149_());
                                 break label207;
                              }
                           }
                        }

                        if (!world.m_6443_(MeiMeiEntity.class, AABB.m_165882_(new Vec3(x, y, z), (double)64.0F, (double)64.0F, (double)64.0F), (e) -> true).isEmpty()) {
                           entity.getPersistentData().m_128359_("FOLLOW_ID", ((Entity)world.m_6443_(MeiMeiEntity.class, AABB.m_165882_(new Vec3(x, y, z), (double)64.0F, (double)64.0F, (double)64.0F), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                              }
                           })).compareDistOf(x, y, z)).findFirst().orElse((Object)null)).m_20149_());
                        } else {
                           entity.getPersistentData().m_128347_("cnt_x", (double)-80.0F);
                        }
                     }
                  } else {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("FOLLOW_ID"));
                     if (entity_a instanceof LivingEntity) {
                        logic_a = true;
                        x_pos = entity_a.m_20185_();
                        y_pos = entity_a.m_20186_();
                        z_pos = entity_a.m_20189_();
                     } else {
                        entity.getPersistentData().m_128359_("FOLLOW_ID", "");
                     }
                  }

                  if (logic_a) {
                     dis = Math.sqrt(Math.pow(entity.m_20185_() - x_pos, (double)2.0F) + Math.pow(entity.m_20186_() - y_pos, (double)2.0F) + Math.pow(entity.m_20189_() - z_pos, (double)2.0F));
                     if (dis < (double)24.0F) {
                        if (entity instanceof Mob) {
                           Mob _entity = (Mob)entity;
                           _entity.m_21573_().m_26519_(x_pos + (Math.random() - (double)0.5F) * (double)16.0F, y_pos + (double)8.0F + Math.random() * (double)8.0F, z_pos + (Math.random() - (double)0.5F) * (double)16.0F, (double)1.0F);
                        }
                     } else {
                        entity.getPersistentData().m_128379_("canFly", true);
                        GetPowerForwardProcedure.execute(x_pos + (Math.random() - (double)0.5F) * (double)16.0F, y_pos + (double)8.0F + Math.random() * (double)8.0F, z_pos + (Math.random() - (double)0.5F) * (double)16.0F, entity);
                        entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (double)0.25F, entity.getPersistentData().m_128459_("y_power") * (double)0.25F, entity.getPersistentData().m_128459_("z_power") * (double)0.25F));
                        RotateEntityProcedure.execute((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_() + entity.m_20184_().m_7096_() * (double)10.0F, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() + entity.m_20184_().m_7098_() * (double)10.0F, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_() + entity.m_20184_().m_7094_() * (double)10.0F, entity);
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("skill", (double)1.0F);
               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
               logic_a = false;
               if (entity.getPersistentData().m_128459_("cnt1") < (double)3.0F) {
                  if (LogicOwnerExistProcedure.execute(world, entity)) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                     if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                        logic_a = true;
                        LivingEntity var85;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var85 = _mobEnt.m_5448_();
                        } else {
                           var85 = null;
                        }

                        if (var85 instanceof LivingEntity) {
                           CompoundTag var86 = entity.getPersistentData();
                           LivingEntity var89;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var89 = _mobEnt.m_5448_();
                           } else {
                              var89 = null;
                           }

                           Level var90 = ((Entity)var89).m_9236_();
                           ClipContext var95 = new ClipContext;
                           LivingEntity var98;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var98 = _mobEnt.m_5448_();
                           } else {
                              var98 = null;
                           }

                           Vec3 var99 = ((Entity)var98).m_20299_(1.0F);
                           LivingEntity var10006;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10006 = _mobEnt.m_5448_();
                           } else {
                              var10006 = null;
                           }

                           Vec3 var102 = ((Entity)var10006).m_20299_(1.0F);
                           LivingEntity var10007;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10007 = _mobEnt.m_5448_();
                           } else {
                              var10007 = null;
                           }

                           var102 = var102.m_82549_(((Entity)var10007).m_20252_(1.0F).m_82490_((double)0.0F));
                           ClipContext.Block var107 = Block.OUTLINE;
                           ClipContext.Fluid var10008 = Fluid.NONE;
                           LivingEntity var10009;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10009 = _mobEnt.m_5448_();
                           } else {
                              var10009 = null;
                           }

                           var95.<init>(var99, var102, var107, var10008, var10009);
                           var86.m_128347_("x_pos", (double)var90.m_45547_(var95).m_82425_().m_123341_());
                           var86 = entity.getPersistentData();
                           LivingEntity var91;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var91 = _mobEnt.m_5448_();
                           } else {
                              var91 = null;
                           }

                           double var92 = ((Entity)var91).m_20186_();
                           LivingEntity var96;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var96 = _mobEnt.m_5448_();
                           } else {
                              var96 = null;
                           }

                           var86.m_128347_("y_pos", var92 + (double)((Entity)var96).m_20206_() * (double)0.5F);
                           var86 = entity.getPersistentData();
                           LivingEntity var93;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var93 = _mobEnt.m_5448_();
                           } else {
                              var93 = null;
                           }

                           Level var94 = ((Entity)var93).m_9236_();
                           ClipContext var97 = new ClipContext;
                           LivingEntity var100;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var100 = _mobEnt.m_5448_();
                           } else {
                              var100 = null;
                           }

                           Vec3 var101 = ((Entity)var100).m_20299_(1.0F);
                           LivingEntity var104;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var104 = _mobEnt.m_5448_();
                           } else {
                              var104 = null;
                           }

                           Vec3 var105 = ((Entity)var104).m_20299_(1.0F);
                           LivingEntity var108;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var108 = _mobEnt.m_5448_();
                           } else {
                              var108 = null;
                           }

                           var105 = var105.m_82549_(((Entity)var108).m_20252_(1.0F).m_82490_((double)0.0F));
                           ClipContext.Block var109 = Block.OUTLINE;
                           var10008 = Fluid.NONE;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10009 = _mobEnt.m_5448_();
                           } else {
                              var10009 = null;
                           }

                           var97.<init>(var101, var105, var109, var10008, var10009);
                           var86.m_128347_("z_pos", (double)var94.m_45547_(var97).m_82425_().m_123343_());
                        } else {
                           x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)64.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                           y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)64.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                           z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_((double)64.0F)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                           entity.getPersistentData().m_128347_("x_pos", x_pos);
                           entity.getPersistentData().m_128347_("y_pos", y_pos);
                           entity.getPersistentData().m_128347_("z_pos", z_pos);
                           dis = (double)8.0F;
                           logic_a = false;

                           for(int index0 = 0; index0 < 8; ++index0) {
                              Vec3 _center = new Vec3((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_());

                              for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)8.0F), (e) -> true)) {
                                 if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                                    logic_a = true;
                                    entity.getPersistentData().m_128347_("x_pos", entityiterator.m_20185_());
                                    entity.getPersistentData().m_128347_("y_pos", entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F);
                                    entity.getPersistentData().m_128347_("z_pos", entityiterator.m_20189_());
                                    break;
                                 }
                              }

                              dis += (double)8.0F;
                              if (logic_a) {
                                 break;
                              }
                           }
                        }
                     }
                  }

                  x_pos = entity.getPersistentData().m_128459_("x_pos");
                  y_pos = entity.getPersistentData().m_128459_("y_pos");
                  z_pos = entity.getPersistentData().m_128459_("z_pos");
                  entity.getPersistentData().m_128379_("canFly", true);
                  GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
                  x_power = entity.getPersistentData().m_128459_("x_power") * (double)2.0F;
                  y_power = entity.getPersistentData().m_128459_("y_power") * (double)2.0F;
                  z_power = entity.getPersistentData().m_128459_("z_power") * (double)2.0F;
                  entity.getPersistentData().m_128347_("old_x", x);
                  entity.getPersistentData().m_128347_("old_y", y);
                  entity.getPersistentData().m_128347_("old_z", z);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 5, 0.1, 0.1, 0.1, 0.4);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.takeoff")), SoundSource.NEUTRAL, 3.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.takeoff")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
                     }
                  }
               } else {
                  if (entity.m_20184_().m_7096_() > entity.getPersistentData().m_128459_("x_power") * (double)2.0F) {
                     x_power = entity.m_20184_().m_7096_() - 0.15;
                  } else {
                     x_power = entity.m_20184_().m_7096_() + 0.15;
                  }

                  if (entity.m_20184_().m_7098_() > entity.getPersistentData().m_128459_("y_power") * (double)2.0F) {
                     y_power = entity.m_20184_().m_7098_() - 0.15;
                  } else {
                     y_power = entity.m_20184_().m_7098_() + 0.15;
                  }

                  if (entity.m_20184_().m_7094_() > entity.getPersistentData().m_128459_("z_power") * (double)2.0F) {
                     z_power = entity.m_20184_().m_7094_() - 0.15;
                  } else {
                     z_power = entity.m_20184_().m_7094_() + 0.15;
                  }
               }

               if (!entity.getPersistentData().m_128471_("Stop")) {
                  entity.m_20256_(new Vec3(x_power, y_power, z_power));
                  RotateEntityProcedure.execute((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_() + entity.m_20184_().m_7096_() * (double)10.0F, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() + entity.m_20184_().m_7098_() * (double)10.0F, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_() + entity.m_20184_().m_7094_() * (double)10.0F, entity);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 1, 0.1, 0.1, 0.1, 0.1);
                  }
               } else {
                  entity.getPersistentData().m_128379_("Stop", false);
               }

               x_pos = entity.getPersistentData().m_128459_("old_x");
               y_pos = entity.getPersistentData().m_128459_("old_y");
               z_pos = entity.getPersistentData().m_128459_("old_z");
               x_power = x_pos - x;
               y_power = y_pos - y;
               z_power = z_pos - z;
               dis = Math.sqrt(Math.pow(x_power, (double)2.0F) + Math.pow(y_power, (double)2.0F) + Math.pow(z_power, (double)2.0F));
               if (dis > (double)0.0F) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;

                  for(int index1 = 0; index1 < (int)Math.ceil(dis * (double)2.0F); ++index1) {
                     entity.getPersistentData().m_128347_("Damage", (double)24.0F);
                     entity.getPersistentData().m_128347_("Range", (double)3.0F);
                     entity.getPersistentData().m_128347_("knockback", (double)0.25F);
                     entity.getPersistentData().m_128347_("effect", (double)1.0F);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     x_pos += x_power * (double)0.5F;
                     y_pos += y_power * (double)0.5F;
                     z_pos += z_power * (double)0.5F;
                  }
               }

               entity.getPersistentData().m_128347_("old_x", x);
               entity.getPersistentData().m_128347_("old_y", y);
               entity.getPersistentData().m_128347_("old_z", z);
               entity.getPersistentData().m_128347_("BlockRange", (double)1.0F);
               entity.getPersistentData().m_128347_("BlockDamage", (double)1.0F);
               BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
               if (entity.getPersistentData().m_128459_("cnt1") > (double)15.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21153_(0.0F);
                  }

                  entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat")))), 9999.0F);
               }
            }
         }

      }
   }
}
