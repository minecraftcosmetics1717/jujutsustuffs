package net.mcreator.jujutsucraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

public class CursedSpeechProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double rad_now = (double)0.0F;
         double Knockback = (double)0.0F;
         double Effect = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double Damage = (double)0.0F;
         double dis = (double)0.0F;
         double power = (double)0.0F;
         double old2 = (double)0.0F;
         double old1 = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         Effect = entity.getPersistentData().m_128459_("skill");
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)5.0F) {
            if (entity instanceof Player) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 4, false, false));
                  }
               }
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 9, false, false));
               }
            }

            if (Effect == (double)305.0F) {
               Damage = (double)42.0F;
            } else if (Effect == (double)306.0F) {
               Damage = (double)33.0F;
            } else if (Effect == (double)307.0F) {
               Damage = (double)50.0F;
            } else if (Effect == (double)308.0F) {
               Damage = (double)1.0F;
            } else if (Effect == (double)309.0F) {
               Damage = (double)27.0F;
               Knockback = (double)4.0F;
            }

            if (Damage >= (double)10.0F && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ATTACKING.get(), 1, 1, false, false));
               }
            }

            AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
            LazyOptional var10000 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
            Objects.requireNonNull(_iitemhandlerref);
            var10000.ifPresent(_iitemhandlerref::set);
            if (_iitemhandlerref.get() != null) {
               for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                  ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                  if (itemstackiterator.m_41720_() == JujutsucraftModItems.LOUDSPEAKER.get() && itemstackiterator.m_41784_().m_128471_("Used")) {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                     Damage *= (double)0.75F;
                     break;
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
               entity.getPersistentData().m_128347_("yaw", (double)(entity.m_146908_() + 90.0F));
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
               entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
               entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * 0.7);
               entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
               LivingEntity var64;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var64 = _mobEnt.m_5448_();
               } else {
                  var64 = null;
               }

               if (var64 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var64 = _mobEnt.m_5448_();
                  } else {
                     var64 = null;
                  }

                  x_pos = ((Entity)var64).m_20185_();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var64 = _mobEnt.m_5448_();
                  } else {
                     var64 = null;
                  }

                  double var67 = ((Entity)var64).m_20186_();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.m_5448_();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var67 + (double)((Entity)var10001).m_20206_() * 0.7;
                  LivingEntity var68;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var68 = _mobEnt.m_5448_();
                  } else {
                     var68 = null;
                  }

                  z_pos = ((Entity)var68).m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)2.0F);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)2.0F);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)2.0F);
            }

            rad_now = Math.toRadians(entity.getPersistentData().m_128459_("yaw") + (double)90.0F);

            for(int index0 = 0; index0 < 2; ++index0) {
               entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
               dis = (entity.getPersistentData().m_128459_("cnt3") - (double)0.0F) * 0.8 * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2);
               entity.getPersistentData().m_128347_("Damage", Damage);
               entity.getPersistentData().m_128347_("Range", dis * (double)2.0F);
               entity.getPersistentData().m_128347_("effect", Effect);
               entity.getPersistentData().m_128347_("effectConfirm", (double)2.0F);
               entity.getPersistentData().m_128347_("knockback", Knockback);
               entity.getPersistentData().m_128379_("onlyLiving", true);
               RangeAttackProcedure.execute(world, entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
               if (Effect == (double)309.0F) {
                  entity.getPersistentData().m_128347_("effect", (double)0.0F);
                  entity.getPersistentData().m_128347_("knockback", Knockback);
                  KnockbackProcedure.execute(world, entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
               }

               entity.getPersistentData().m_128379_("onlyLiving", false);
               entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") + entity.getPersistentData().m_128459_("x_power") * (double)1.0F);
               entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + entity.getPersistentData().m_128459_("y_power") * (double)1.0F);
               entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") + entity.getPersistentData().m_128459_("z_power") * (double)1.0F);
            }

            entity.getPersistentData().m_128347_("Damage", (double)0.0F);
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.8;
            z_pos = entity.m_20189_();
            ParticleGeneratorCircleProcedure.execute(world, (double)36.0F, entity.getPersistentData().m_128459_("pitch"), (double)0.0F, (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2, (double)8.0F, x_pos, x_pos + entity.getPersistentData().m_128459_("x_power"), y_pos, y_pos + entity.getPersistentData().m_128459_("y_power"), entity.getPersistentData().m_128459_("yaw") - (double)90.0F, z_pos, z_pos + entity.getPersistentData().m_128459_("z_power"), "minecraft:enchanted_hit");
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)10.0F) {
            label214: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt83 = (LivingEntity)entity;
                  if (_livEnt83.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed")) {
                     break label214;
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt6") == (double)0.0F) {
                  if (!(entity.getPersistentData().m_128459_("cnt10") >= (double)1.0F)) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + entity.getPersistentData().m_128459_("used_technique_cost");
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get());
                     }

                     entity.getPersistentData().m_128347_("skill", (double)0.0F);
                  } else {
                     double var69;
                     int var72;
                     label205: {
                        var69 = entity.getPersistentData().m_128459_("cnt10");
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var72 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label205;
                           }
                        }

                        var72 = 0;
                     }

                     power = var69 - (double)var72;
                     if (power >= (double)0.0F) {
                        label199: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                 var69 = (double)_livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                 break label199;
                              }
                           }

                           var69 = (double)0.0F;
                        }

                        label194: {
                           old1 = var69;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                 var69 = (double)_livEnt.m_21124_(MobEffects.f_19606_).m_19557_();
                                 break label194;
                              }
                           }

                           var69 = (double)0.0F;
                        }

                        old2 = var69;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.m_21195_(MobEffects.f_19606_);
                        }

                        entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_curse")))), (float)(((double)2.5F + power * (double)1.25F) * (double)(entity instanceof Player ? 1 : 5)));
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, (int)old2, (int)old1, false, false));
                           }
                        }

                        for(int index1 = 0; index1 < (int)Math.min(power + (double)1.0F, (double)10.0F); ++index1) {
                           Effect1Procedure.execute(world, entity, entity);
                           if (!entity.m_6084_()) {
                              break;
                           }
                        }

                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "playsound jujutsucraft:tinnitus master @s");
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19610_, 20, 0, false, false));
                           }
                        }

                        power = Math.min(Math.max(entity.getPersistentData().m_128459_("COOLDOWN_TICKS") * ((double)1.0F + Math.max(power, (double)0.0F) * 0.1), (double)1.0F), (double)1200.0F);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)power, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity = (LivingEntity)entity;
                           _livingEntity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)power, 0, false, false));
                        }
                     }
                  }

                  if (Effect == (double)308.0F) {
                     power = entity.getPersistentData().m_128459_("COOLDOWN_TICKS") * (double)2.0F;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)power, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity = (LivingEntity)entity;
                        _livingEntity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)power, 0, false, false));
                     }
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)15.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
