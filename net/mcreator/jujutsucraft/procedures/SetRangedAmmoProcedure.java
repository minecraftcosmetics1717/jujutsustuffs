package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class SetRangedAmmoProcedure {
   public static void execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double str_level = (double)0.0F;
         if (entityiterator instanceof LivingEntity) {
            if (entity.getPersistentData().m_128459_("NameRanged") == (double)0.0F) {
               entity.getPersistentData().m_128347_("NameRanged", Math.random());
            }

            if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
               entity.getPersistentData().m_128347_("friend_num", Math.random());
            }

            entityiterator.getPersistentData().m_128347_("NameRanged_ranged", entity.getPersistentData().m_128459_("NameRanged"));
            entityiterator.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
            entityiterator.getPersistentData().m_128379_("jjkChara", true);
            if (entity instanceof Player || entity.getPersistentData().m_128471_("Player")) {
               entityiterator.getPersistentData().m_128379_("Player", true);
               entityiterator.getPersistentData().m_128359_("PlayerName", entity.m_5446_().getString());
            }

            if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
               entityiterator.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
               entityiterator.getPersistentData().m_128347_("COOLDOWN_TICKS", entity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt20 = (LivingEntity)entity;
               if (_livEnt20.m_21023_(MobEffects.f_19600_)) {
                  double var10000;
                  label87: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var10000 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label87;
                        }
                     }

                     var10000 = (double)0.0F;
                  }

                  str_level = var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt22 = (LivingEntity)entity;
                     if (_livEnt22.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                        int var10001;
                        label79: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                 var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.ZONE.get()).m_19564_();
                                 break label79;
                              }
                           }

                           var10001 = 0;
                        }

                        str_level = str_level + (double)var10001 + (double)1.0F;
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)str_level, false, false));
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt25 = (LivingEntity)entity;
               if (_livEnt25.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()) && entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.m_9236_().m_5776_()) {
                     MobEffectInstance var14;
                     MobEffect var10003;
                     int var10004;
                     label68: {
                        var14 = new MobEffectInstance;
                        var10003 = (MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              var10004 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19557_();
                              break label68;
                           }
                        }

                        var10004 = 0;
                     }

                     int var10005;
                     label63: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              var10005 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                              break label63;
                           }
                        }

                        var10005 = 0;
                     }

                     var14.<init>(var10003, var10004, var10005, false, false);
                     _entity.m_7292_(var14);
                  }
               }
            }

            entityiterator.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
         }

      }
   }
}
