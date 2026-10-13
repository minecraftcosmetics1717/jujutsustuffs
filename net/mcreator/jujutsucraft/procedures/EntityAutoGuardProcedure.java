package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import software.bernie.geckolib.animatable.GeoEntity;

public class EntityAutoGuardProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         double distance = (double)0.0F;
         double attacker_lv = (double)0.0F;
         double defender_lv = (double)0.0F;
         double guard_chance = (double)0.0F;
         if (!(entity instanceof Player)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)entity;
               if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                  return;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt2 = (LivingEntity)entity;
               if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.STUN.get())) {
                  return;
               }
            }

            if (entity.getPersistentData().m_128471_("jjkChara") && entity instanceof GeoEntity && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:no_guard"))) && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  label71: {
                     if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEnt9 = (LivingEntity)sourceentity;
                        if (_livEnt9.m_21023_(MobEffects.f_19600_)) {
                           label67: {
                              if (sourceentity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)sourceentity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var25 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label67;
                                 }
                              }

                              var25 = 0;
                           }

                           ++var25;
                           break label71;
                        }
                     }

                     var25 = 0;
                  }

                  label61: {
                     attacker_lv = (double)var25;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt11 = (LivingEntity)entity;
                        if (_livEnt11.m_21023_(MobEffects.f_19600_)) {
                           label57: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var27 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label57;
                                 }
                              }

                              var27 = 0;
                           }

                           ++var27;
                           break label61;
                        }
                     }

                     var27 = 0;
                  }

                  defender_lv = (double)var27;
                  guard_chance = Math.max((defender_lv - attacker_lv) * (double)10.0F, (double)0.0F);
                  distance = GetDistanceIteratorProcedure.execute(entity, sourceentity);
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 == sourceentity) {
                     guard_chance += distance * (double)3.0F;
                  } else {
                     guard_chance += Math.max((double)100.0F - distance * (double)3.0F, (double)0.0F);
                  }

                  if (guard_chance > (double)0.0F && guard_chance > Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)100.0F)) {
                     StartGuardProcedure.execute(world, entity);
                  }
               }
            }
         }

      }
   }
}
