package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.KusakabeAtsuyaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TechniqueKusakabe1Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean logic_b = false;
         double dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double y_fix = (double)0.0F;
         double vx = (double)0.0F;
         double vy = (double)0.0F;
         double vz = (double)0.0F;
         double y_fix_height = (double)0.0F;
         double speed = (double)0.0F;
         double level_newShadowStyle = (double)0.0F;
         double num1 = (double)0.0F;
         double num2 = (double)0.0F;
         if (entity instanceof Player) {
            label510: {
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr1 = (ServerPlayer)entity;
                  if (_plr1.m_9236_() instanceof ServerLevel && _plr1.m_8960_().m_135996_(_plr1.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_new_shadow_style_lv_4"))).m_8193_()) {
                     level_newShadowStyle = (double)4.0F;
                     break label510;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr2 = (ServerPlayer)entity;
                  if (_plr2.m_9236_() instanceof ServerLevel && _plr2.m_8960_().m_135996_(_plr2.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_new_shadow_style_lv_3"))).m_8193_()) {
                     level_newShadowStyle = (double)3.0F;
                     break label510;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr3 = (ServerPlayer)entity;
                  if (_plr3.m_9236_() instanceof ServerLevel && _plr3.m_8960_().m_135996_(_plr3.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_new_shadow_style_lv_2"))).m_8193_()) {
                     level_newShadowStyle = (double)2.0F;
                     break label510;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr4 = (ServerPlayer)entity;
                  if (_plr4.m_9236_() instanceof ServerLevel && _plr4.m_8960_().m_135996_(_plr4.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_new_shadow_style_lv_1"))).m_8193_()) {
                     level_newShadowStyle = (double)1.0F;
                     break label510;
                  }
               }

               level_newShadowStyle = (double)1.0F;
            }
         } else if (entity instanceof KusakabeAtsuyaEntity) {
            level_newShadowStyle = (double)4.0F;
         } else {
            level_newShadowStyle = (double)1.0F;
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt7") == (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt8", entity.getPersistentData().m_128459_("cnt8") + (double)1.0F);
            if (level_newShadowStyle <= (double)1.0F || entity.getPersistentData().m_128459_("cnt8") == (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 60, 9, false, false));
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt8") == (double)1.0F) {
                  label535: {
                     if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_hollow_wicker_basket")))) {
                        label529: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt15 = (LivingEntity)entity;
                              if (_livEnt15.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label529;
                              }
                           }

                           if (!(entity instanceof Player) || num1 != (double)1.0F && num2 != (double)1.0F && num1 != (double)7.0F && num2 != (double)7.0F && num1 != (double)12.0F && num2 != (double)12.0F && num1 != (double)24.0F && num2 != (double)24.0F) {
                              num1 = (double)-16.0F;
                              break label535;
                           }
                        }
                     }

                     num1 = (double)-17.0F;
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity17 = (LivingEntity)entity;
                     if (_livingEntity17.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity17.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(num1);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }
            }

            entity.getPersistentData().m_128347_("Damage", (double)15.0F);
            entity.getPersistentData().m_128347_("Range", (double)1.5F);
            entity.getPersistentData().m_128347_("effect", (double)5.0F);
            entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
            entity.getPersistentData().m_128379_("swing", true);
            DamageFixProcedure.execute(entity);
            num1 = entity.getPersistentData().m_128459_("cnt8") - (double)1.0F;
            if (!(level_newShadowStyle < (double)4.0F) && !(entity.getPersistentData().m_128459_("cnt8") <= (double)40.0F)) {
               num1 = Math.max((num1 - (double)40.0F) * (double)50.0F, (double)1.0F);
               num1 = Math.min((double)160.0F + num1, (double)640.0F);
            } else {
               num1 = Math.max(num1 * (double)50.0F, (double)1.0F);
               num1 = Math.min(num1, (double)160.0F);
            }

            for(int index0 = 0; index0 < 5; ++index0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), (int)num1, 1, true, true));
                  }
               }

               num1 += (double)10.0F;
               if (num1 > (double)(!(level_newShadowStyle < (double)4.0F) && !(entity.getPersistentData().m_128459_("cnt8") <= (double)60.0F) ? 160 : 640)) {
                  break;
               }
            }

            double var10000;
            int var10002;
            label427: {
               var10000 = (double)entity.m_20205_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10002 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19557_();
                     break label427;
                  }
               }

               var10002 = 0;
            }

            dis = Math.min(var10000 + 0.025 * (double)var10002, level_newShadowStyle >= (double)4.0F ? (double)16.0F : (double)4.0F);
            if (entity.getPersistentData().m_128459_("cnt8") > (double)200.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
               }

               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            } else {
               entity.getPersistentData().m_128359_("TARGET", "");
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(dis * (double)2.0F / (double)2.0F), (e) -> true)) {
                  if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && entity.m_20186_() + (double)entity.m_20206_() >= entityiterator.m_20186_() && entity.m_20186_() <= entityiterator.m_20186_() + (double)entityiterator.m_20206_() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     entity.getPersistentData().m_128359_("TARGET1", entityiterator.m_20149_());
                     entity.getPersistentData().m_128347_("cnt1", (double)1.0F);
                     entity.getPersistentData().m_128347_("cnt5", Math.max(entity.getPersistentData().m_128459_("cnt5"), (double)1.0F));
                     entity.getPersistentData().m_128347_("cnt7", (double)1.0F);
                     entity.getPersistentData().m_128347_("cnt8", (double)0.0F);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_(MobEffects.f_19597_);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
                     }
                     break;
                  }
               }
            }
         }

         entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("TARGET1"));
         if (entity.getPersistentData().m_128459_("cnt7") == (double)1.0F) {
            if (entity_a instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt8", entity.getPersistentData().m_128459_("cnt8") + (double)1.0F);
               dis = Math.sqrt(Math.pow(Math.max(Math.abs(entity_a.m_20185_() - entity.m_20185_()) - (double)(entity_a.m_20205_() + entity.m_20205_()), (double)0.0F), (double)2.0F) + Math.pow(Math.max(Math.abs(entity_a.m_20186_() - entity.m_20186_()) - (double)(entity_a.m_20206_() + entity.m_20206_()), (double)0.0F), (double)2.0F) + Math.pow(Math.max(Math.abs(entity_a.m_20189_() - entity.m_20189_()) - (double)(entity_a.m_20205_() + entity.m_20205_()), (double)0.0F), (double)2.0F));
               RotateEntityProcedure.execute(entity_a.m_20185_(), entity_a.m_20186_() + (double)entity_a.m_20206_() * (double)0.5F, entity_a.m_20189_(), entity);
               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
               speed = Math.sqrt(Math.pow(entity.getPersistentData().m_128459_("x_power"), (double)2.0F) + Math.pow(entity.getPersistentData().m_128459_("y_power"), (double)2.0F) + Math.pow(entity.getPersistentData().m_128459_("z_power"), (double)2.0F));
               speed *= (double)4.0F;
               if (speed != (double)0.0F) {
                  vx = entity.getPersistentData().m_128459_("x_power") / speed;
                  vy = entity.getPersistentData().m_128459_("y_power") / speed;
                  vz = entity.getPersistentData().m_128459_("z_power") / speed;
                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_();
                  z_pos = entity.m_20189_();
                  logic_b = true;

                  for(int index1 = 0; index1 < (int)Math.round(speed * (double)4.5F); ++index1) {
                     dis = Math.sqrt(Math.pow(Math.max(Math.abs(entity_a.m_20185_() - entity.m_20185_()) - (double)(entity_a.m_20205_() + entity.m_20205_()), (double)0.0F), (double)2.0F) + Math.pow(Math.max(Math.abs(entity_a.m_20186_() - entity.m_20186_()) - (double)(entity_a.m_20206_() + entity.m_20206_()), (double)0.0F), (double)2.0F) + Math.pow(Math.max(Math.abs(entity_a.m_20189_() - entity.m_20189_()) - (double)(entity_a.m_20205_() + entity.m_20205_()), (double)0.0F), (double)2.0F));
                     if (dis < (double)2.5F) {
                        logic_b = false;
                        RotateEntityProcedure.execute(entity_a.m_20185_(), entity_a.m_20186_() + (double)entity_a.m_20206_() * (double)0.5F, entity_a.m_20189_(), entity);
                        entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                        entity.getPersistentData().m_128347_("cnt7", (double)2.0F);
                        break;
                     }

                     y_pos += vy;
                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                     }

                     if (entity.m_5830_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                        y_pos -= vy;
                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                        }
                     }

                     x_pos += vx;
                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                     }

                     if (entity.m_5830_()) {
                        x_pos -= vx;
                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                        }
                     }

                     z_pos += vz;
                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                     }

                     if (entity.m_5830_()) {
                        z_pos -= vz;
                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                        }
                     }
                  }

                  for(int index2 = 0; index2 < 8; ++index2) {
                     dis = Math.sqrt(Math.pow(Math.max(Math.abs(entity_a.m_20185_() - entity.m_20185_()) - (double)(entity_a.m_20205_() + entity.m_20205_()), (double)0.0F), (double)2.0F) + Math.pow(Math.max(Math.abs(entity_a.m_20186_() - entity.m_20186_()) - (double)(entity_a.m_20206_() + entity.m_20206_()), (double)0.0F), (double)2.0F) + Math.pow(Math.max(Math.abs(entity_a.m_20189_() - entity.m_20189_()) - (double)(entity_a.m_20205_() + entity.m_20205_()), (double)0.0F), (double)2.0F));
                     if (dis < (double)2.5F) {
                        logic_b = false;
                        RotateEntityProcedure.execute(entity_a.m_20185_(), entity_a.m_20186_() + (double)entity_a.m_20206_() * (double)0.5F, entity_a.m_20189_(), entity);
                        entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                        entity.getPersistentData().m_128347_("cnt7", (double)2.0F);
                        break;
                     }

                     logic_a = true;
                     y_fix_height = (double)0.0F;

                     for(int index3 = 0; index3 < (int)Math.ceil((double)(entity.m_20206_() + 0.0F)); ++index3) {
                        if (world.m_8055_(BlockPos.m_274561_(x_pos + vx, y_pos + vy + y_fix_height, z_pos + vz)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + vy + y_fix_height, z_pos)).m_60815_()) {
                           logic_a = false;
                           break;
                        }

                        ++y_fix_height;
                     }

                     if (logic_a) {
                        x_pos += vx;
                        y_pos += vy;
                        z_pos += vz;
                     } else {
                        y_fix = (double)0.0F;

                        for(int index4 = 0; index4 < (int)Math.round(Math.max(speed * (double)2.0F, (double)1.0F)); ++index4) {
                           if (world.m_8055_(BlockPos.m_274561_(x_pos + vx, y_pos + vy + y_fix, z_pos + vz)).m_60815_()) {
                              if (world.m_8055_(BlockPos.m_274561_(x_pos, Math.max(y_pos + vy, y_pos) + y_fix, z_pos)).m_60815_()) {
                                 logic_a = false;
                                 break;
                              }

                              y_fix += (double)0.5F;
                           } else {
                              logic_a = true;
                              y_fix_height = (double)0.0F;

                              for(int index5 = 0; index5 < (int)Math.ceil((double)entity.m_20206_()); ++index5) {
                                 if (world.m_8055_(BlockPos.m_274561_(x_pos + vx, y_pos + vy + y_fix + y_fix_height, z_pos + vz)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + y_fix + y_fix_height, z_pos + vz)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + vy + y_fix + y_fix_height, z_pos + vz)).m_60815_()) {
                                    logic_a = false;
                                    break;
                                 }

                                 ++y_fix_height;
                              }

                              if (logic_a) {
                                 break;
                              }

                              ++y_fix;
                           }
                        }

                        if (logic_a) {
                           y_pos = y_pos + vy + y_fix;
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                           }

                           if (entity.m_5830_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                              y_pos = y_pos - vy - y_fix;
                              if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                 entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                              }
                           }

                           x_pos += vx;
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                           }

                           if (entity.m_5830_()) {
                              x_pos -= vx;
                              if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                 entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                              }
                           }

                           z_pos += vz;
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                           }

                           if (entity.m_5830_()) {
                              z_pos -= vz;
                              if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                 entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                              }
                           }
                           continue;
                        }
                     }

                     if (!logic_a) {
                        break;
                     }

                     x_pos += vx;
                     y_pos = y_pos + vy + y_fix;
                     z_pos += vz;
                  }
               }
            } else {
               entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
               entity.getPersistentData().m_128347_("cnt7", (double)2.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt7") > (double)1.0F) {
            if (level_newShadowStyle >= (double)3.0F) {
               entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt5") <= (double)(level_newShadowStyle == (double)3.0F ? 25 : 50)) {
                  if (entity.getPersistentData().m_128459_("cnt2") > (double)0.0F) {
                     entity.getPersistentData().m_128347_("cnt1", (double)1.0F);
                     entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
                     entity.getPersistentData().m_128347_("cnt6", (double)2.5F + Math.min(entity.getPersistentData().m_128459_("cnt5") * 0.01, (double)0.5F));
                     entity.getPersistentData().m_128347_("cnt7", (double)1.0F);
                     entity.getPersistentData().m_128347_("cnt8", (double)18.0F);
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt6", (double)10.0F);
                  entity.getPersistentData().m_128347_("cnt5", (double)100.0F);
               }
            } else {
               entity.getPersistentData().m_128347_("cnt6", (double)10.0F);
               entity.getPersistentData().m_128347_("cnt5", (double)100.0F);
            }

            for(int index6 = 0; index6 < 5; ++index6) {
               AttackWeakProcedure.execute(world, x, y, z, entity);
               if (entity.getPersistentData().m_128459_("cnt5") >= (double)100.0F) {
                  break;
               }
            }

            if (entity.getPersistentData().m_128459_("cnt7") == (double)1.0F && entity_a instanceof LivingEntity && !entity_a.m_6084_()) {
               entity.getPersistentData().m_128347_("cnt7", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt8", (double)100.0F);
            }
         }

      }
   }
}
