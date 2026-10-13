package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.NueEntity;
import net.mcreator.jujutsucraft.entity.RabbitEscapeEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class FollowEntityProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double NUM1 = (double)0.0F;
         double distance_cap = (double)0.0F;
         boolean logic_a = false;
         boolean despawn_flag = false;
         Entity entity_a = null;
         if (entity.getPersistentData().m_128471_("Ambush")) {
            if (!(entity instanceof RabbitEscapeEntity)) {
               entity.getPersistentData().m_128347_("cnt_follow", entity.getPersistentData().m_128459_("cnt_follow") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_follow") > (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt_follow", (double)-25.0F);
                  if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
                     logic_a = false;
                     if (LogicOwnerExistProcedure.execute(world, entity)) {
                        entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
                        if (entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
                           logic_a = true;
                           if (!entity.getPersistentData().m_128471_("domain_entity")) {
                              NUM1 = Math.sqrt(Math.pow(entity_a.m_20185_() - entity.m_20185_(), (double)2.0F) + Math.pow(entity_a.m_20186_() - entity.m_20186_(), (double)2.0F) + Math.pow(entity_a.m_20189_() - entity.m_20189_(), (double)2.0F));
                              distance_cap = (double)16.0F;
                              if (!(entity instanceof NueEntity) && !entity.m_20096_()) {
                                 distance_cap = (double)48.0F;
                              }

                              LivingEntity var10000;
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (var10000 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
                                 distance_cap = (double)64.0F;
                              }

                              if (NUM1 > distance_cap) {
                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_8767_(ParticleTypes.f_123765_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)(10.0F * entity.m_20206_() * entity.m_20205_() * entity.m_20205_()), 0.2 * (double)entity.m_20205_(), 0.2 * (double)entity.m_20206_(), 0.2 * (double)entity.m_20205_(), (double)0.0F);
                                 }

                                 if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                    Commands var20 = entity.m_20194_().m_129892_();
                                    CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                                    double var10002 = entity_a.m_20185_();
                                    var20.m_230957_(var10001, "spreadplayers " + var10002 + " " + entity_a.m_20189_() + " 4 8 false @s");
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_8767_(ParticleTypes.f_123765_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)(10.0F * entity.m_20206_() * entity.m_20205_() * entity.m_20205_()), 0.2 * (double)entity.m_20205_(), 0.2 * (double)entity.m_20206_(), 0.2 * (double)entity.m_20205_(), (double)0.0F);
                                 }
                              }
                           } else {
                              label141: {
                                 if (entity_a instanceof LivingEntity) {
                                    LivingEntity _livEnt48 = (LivingEntity)entity_a;
                                    if (_livEnt48.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       break label141;
                                    }
                                 }

                                 despawn_flag = true;
                              }
                           }
                        }
                     } else {
                        entity.getPersistentData().m_128379_("flag_despawn", true);
                     }

                     if (entity.getPersistentData().m_128471_("domain_entity") && (!logic_a || despawn_flag)) {
                        entity.getPersistentData().m_128379_("flag_despawn", true);
                     }
                  }
               }
            } else if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F && !LogicOwnerExistProcedure.execute(world, entity)) {
               entity.getPersistentData().m_128379_("flag_despawn", true);
            }
         } else {
            LivingEntity var21;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var21 = _mobEnt.m_5448_();
            } else {
               var21 = null;
            }

            if (var21 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > (double)200.0F) {
               double var22 = entity.getPersistentData().m_128459_("friend_num2");
               LivingEntity var23;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var23 = _mobEnt.m_5448_();
               } else {
                  var23 = null;
               }

               if (var22 != ((Entity)var23).getPersistentData().m_128459_("friend_num")) {
                  entity.getPersistentData().m_128379_("failed_adjustment", true);
               }
            }
         }

         if (!entity.getPersistentData().m_128471_("Ambush")) {
            if (entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
               entity.getPersistentData().m_128347_("cnt_noTarget", (double)0.0F);
            } else {
               entity.getPersistentData().m_128347_("cnt_noTarget", entity.getPersistentData().m_128459_("cnt_noTarget") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_noTarget") > (double)220.0F) {
                  entity.getPersistentData().m_128379_("flag_despawn", true);
                  entity.getPersistentData().m_128347_("Ambush_Number", (double)0.0F);
               }
            }
         } else if (!LogicOwnerExistProcedure.execute(world, entity)) {
            entity.getPersistentData().m_128379_("flag_despawn", true);
         } else if (!GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID")).m_6084_()) {
            entity.getPersistentData().m_128379_("flag_despawn", true);
         }

         if (entity.getPersistentData().m_128471_("flag_despawn")) {
            if (entity.getPersistentData().m_128471_("Ambush")) {
               entity.getPersistentData().m_128379_("Ambush", false);
               entity.getPersistentData().m_128347_("Ambush_Number", (double)1.0F);
            }

            entity.getPersistentData().m_128379_("Despawn", true);
            DieTenShadowsTechniqueProcedure.execute(world, entity);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)(10.0F * entity.m_20206_() * entity.m_20205_() * entity.m_20205_()), 0.2 * (double)entity.m_20205_(), 0.2 * (double)entity.m_20206_(), 0.2 * (double)entity.m_20205_(), (double)0.0F);
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
