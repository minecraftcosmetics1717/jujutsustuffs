package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.KashimoHajimeEntity;
import net.mcreator.jujutsucraft.entity.KurusuHanaEntity;
import net.mcreator.jujutsucraft.entity.MahitoEntity;
import net.mcreator.jujutsucraft.entity.MergedBeastAgitoEntity;
import net.mcreator.jujutsucraft.entity.NueEntity;
import net.mcreator.jujutsucraft.entity.PurpleEntity;
import net.mcreator.jujutsucraft.entity.TakabaFumihikoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;

public class ChangeDamage1Procedure {
   public static double execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double damage = (double)0.0F;
         double player_ct1 = (double)0.0F;
         double player_ct2 = (double)0.0F;
         double skill = (double)0.0F;
         boolean PhysicalGifted = false;
         boolean Thunder = false;
         boolean Sukuna = false;
         boolean Mahito = false;
         damage = (double)1.0F;
         if (entityiterator instanceof Player) {
            JujutsucraftModVariables.PlayerVariables pVars = null;
            pVars = (JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
            player_ct1 = pVars.PlayerCurseTechnique;
            player_ct2 = pVars.PlayerCurseTechnique2;
         }

         int var10000;
         label325: {
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entityiterator;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_();
                  break label325;
               }
            }

            var10000 = 0;
         }

         label343: {
            PhysicalGifted = var10000 > 0;
            if (ReturnInsideItemProcedure.execute(entityiterator).m_41720_() != JujutsucraftModItems.SUKUNA_FINGER.get()) {
               label341: {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt3 = (LivingEntity)entityiterator;
                     if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        break label341;
                     }
                  }

                  var10000 = 0;
                  break label343;
               }
            }

            var10000 = 1;
         }

         label310: {
            label309: {
               label333: {
                  Sukuna = (boolean)var10000;
                  if (entityiterator instanceof Player) {
                     if (player_ct1 != (double)15.0F && player_ct2 != (double)15.0F) {
                        break label333;
                     }
                  } else if (!(entityiterator instanceof MahitoEntity)) {
                     break label333;
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt6 = (LivingEntity)entityiterator;
                     if (_livEnt6.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label333;
                     }
                  }

                  if (!(entityiterator instanceof LivingEntity)) {
                     break label309;
                  }

                  LivingEntity _livEnt7 = (LivingEntity)entityiterator;
                  if (!_livEnt7.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                     break label309;
                  }
               }

               var10000 = 0;
               break label310;
            }

            var10000 = 1;
         }

         Mahito = (boolean)var10000;
         Thunder = entityiterator instanceof Player ? player_ct1 == (double)7.0F || player_ct2 == (double)7.0F : entityiterator instanceof NueEntity || entityiterator instanceof MergedBeastAgitoEntity || entityiterator instanceof KashimoHajimeEntity;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == (double)705.0F && Thunder) {
            damage *= 0.1;
         }

         if (skill == (double)1505.0F) {
            if (Sukuna) {
               DamageSource var10001 = new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat"))));
               float var10002;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10002 = _livEnt.m_21233_();
               } else {
                  var10002 = -1.0F;
               }

               entity.m_6469_(var10001, Math.max(var10002, 50.0F));
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.ZONE.get());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 100, 9, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19613_, 100, 9, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 100, 9, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 100, 9, false, false));
                  }
               }

               Effect1Procedure.execute(world, entityiterator, entity);
               return (double)0.0F;
            }

            if (!PhysicalGifted && !Mahito) {
               label275: {
                  if (entityiterator instanceof Player) {
                     if (entityiterator instanceof ServerPlayer) {
                        ServerPlayer _plr24 = (ServerPlayer)entityiterator;
                        if (_plr24.m_9236_() instanceof ServerLevel && _plr24.m_8960_().m_135996_(_plr24.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:observation_of_the_soul"))).m_8193_()) {
                           break label275;
                        }
                     }
                  } else if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:soul_perception")))) {
                     break label275;
                  }

                  damage *= (double)1.25F;
               }
            } else {
               damage *= 0.1;
            }
         }

         if (skill == (double)2815.0F) {
            if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
               damage *= (double)5.0F;
            } else if (!entityiterator.getPersistentData().m_128471_("CursedSpirit") && !entityiterator.getPersistentData().m_128471_("CurseUser")) {
               label262: {
                  if (entityiterator instanceof Player) {
                     if (player_ct1 != (double)28.0F && player_ct2 != (double)28.0F) {
                        break label262;
                     }
                  } else if (!(entityiterator instanceof KurusuHanaEntity)) {
                     break label262;
                  }

                  damage *= 0.1;
               }

               if (entityiterator.getPersistentData().m_128471_("JujutsuSorcerer")) {
                  damage *= (double)0.5F;
               }
            }
         }

         label255: {
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entityiterator;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).m_19564_();
                  break label255;
               }
            }

            var10000 = 0;
         }

         label344: {
            if (var10000 > 0) {
               label342: {
                  if (entityiterator instanceof Player) {
                     if (player_ct1 != (double)17.0F && player_ct2 != (double)17.0F) {
                        break label342;
                     }
                  } else if (!(entityiterator instanceof TakabaFumihikoEntity)) {
                     break label342;
                  }

                  if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo_no_move")))) {
                     ItemStack var51;
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entityiterator;
                        var51 = _livEnt.m_21205_();
                     } else {
                        var51 = ItemStack.f_41583_;
                     }

                     if (var51.m_41720_() == JujutsucraftModItems.HARISEN.get()) {
                        if (!(entityiterator instanceof Player)) {
                           break label344;
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt40 = (LivingEntity)entityiterator;
                           if (_livEnt40.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                              break label344;
                           }
                        }

                        if (entityiterator.getPersistentData().m_128471_("attack")) {
                           break label344;
                        }
                     }
                  }
               }
            }

            label228: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get()).m_19564_();
                     break label228;
                  }
               }

               var10000 = 0;
            }

            if (var10000 > 0) {
               label222: {
                  if (entity instanceof Player) {
                     if (player_ct1 != (double)17.0F && player_ct2 != (double)17.0F) {
                        break label222;
                     }
                  } else if (!(entity instanceof TakabaFumihikoEntity)) {
                     break label222;
                  }

                  if (entityiterator.getPersistentData().m_128471_("CursedSpirit")) {
                     damage *= (double)2.0F;
                  }
               }
            }

            if (entity instanceof PurpleEntity && entity.getPersistentData().m_128459_("NameRanged_ranged") == entityiterator.getPersistentData().m_128459_("NameRanged")) {
               damage *= (double)0.5F;
            }

            if (!entity.getPersistentData().m_128471_("attack")) {
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt82 = (LivingEntity)entityiterator;
                  if (_livEnt82.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                     damage *= (double)0.75F;
                  }
               }

               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt83 = (LivingEntity)entityiterator;
                  if (_livEnt83.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     damage *= 0.9;
                  }
               }
            }

            return damage;
         }

         if (entityiterator.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
            entityiterator.getPersistentData().m_128347_("friend_num", Math.random());
         }

         if (entityiterator.getPersistentData().m_128459_("NameRanged") == (double)0.0F) {
            entityiterator.getPersistentData().m_128347_("NameRanged", Math.random());
         }

         entity.getPersistentData().m_128359_("OWNER_UUID", entityiterator.m_20149_());
         entity.getPersistentData().m_128347_("friend_num", entityiterator.getPersistentData().m_128459_("friend_num"));
         entity.getPersistentData().m_128347_("NameRanged_ranged", entityiterator.getPersistentData().m_128459_("NameRanged"));
         entity.getPersistentData().m_128347_("x_power", entityiterator.m_20154_().f_82479_ * (double)6.0F);
         entity.getPersistentData().m_128347_("y_power", entityiterator.m_20154_().f_82480_ * (double)6.0F);
         entity.getPersistentData().m_128347_("z_power", entityiterator.m_20154_().f_82481_ * (double)6.0F);
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 10, 9, false, false));
            }
         }

         entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power"), entity.getPersistentData().m_128459_("y_power"), entity.getPersistentData().m_128459_("z_power")));
         entity.m_146922_(entityiterator.m_146908_());
         entity.m_146926_(entityiterator.m_146909_());
         entity.m_5618_(entity.m_146908_());
         entity.m_5616_(entity.m_146908_());
         entity.f_19859_ = entity.m_146908_();
         entity.f_19860_ = entity.m_146909_();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.f_20884_ = _entity.m_146908_();
            _entity.f_20886_ = _entity.m_146908_();
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:critical")), SoundSource.NEUTRAL, 2.0F, 1.0F);
            } else {
               _level.m_7785_(entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:critical")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
            }
         }

         if (!(entityiterator instanceof GeoEntity) && entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            _entity.m_21011_(InteractionHand.MAIN_HAND, true);
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _livingEntity72 = (LivingEntity)entityiterator;
            if (_livingEntity72.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity72.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-5.0F);
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _livingEntity73 = (LivingEntity)entityiterator;
            if (_livingEntity73.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
               _livingEntity73.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
            }
         }

         PlayAnimationProcedure.execute(world, entityiterator);
         return (double)0.0F;
      } else {
         return (double)0.0F;
      }
   }
}
