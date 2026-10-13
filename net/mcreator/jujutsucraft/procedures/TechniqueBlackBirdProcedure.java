package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.CrowEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TechniqueBlackBirdProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double loop_num = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") > (double)0.0F) {
               entity.getPersistentData().m_128347_("cnt1", (double)-20.0F);
               entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("friend_num", Math.random());
               }

               if (entity.getPersistentData().m_128459_("NameRanged") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("NameRanged", Math.random());
               }

               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)32.0F), (e) -> true)) {
                  if (entity != entityiterator && entityiterator instanceof CrowEntity && entityiterator.m_6084_() && entityiterator.getPersistentData().m_128459_("NameRanged_ranged") == (double)0.0F) {
                     logic_a = true;
                     entityiterator.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     entityiterator.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                     entityiterator.getPersistentData().m_128347_("NameRanged_ranged", entity.getPersistentData().m_128459_("NameRanged"));
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var10001;
                           MobEffect var10003;
                           int var10005;
                           label76: {
                              var10001 = new MobEffectInstance;
                              var10003 = MobEffects.f_19600_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label76;
                                 }
                              }

                              var10005 = 0;
                           }

                           var10001.<init>(var10003, Integer.MAX_VALUE, var10005, false, false);
                           _entity.m_7292_(var10001);
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 5, false, false));
                        }
                     }
                     break;
                  }
               }

               if (logic_a) {
                  entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
                  entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
                  entity.getPersistentData().m_128347_("cnt3", (double)0.0F);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 1, false, false));
                     }
                  }
               } else {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.crow2").getString()), false);
                     }
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "playsound ui.button.click master @s");
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer * (double)1.0F), 0, false, false));
                     }
                  }

                  SummonCrowProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }
         } else {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
