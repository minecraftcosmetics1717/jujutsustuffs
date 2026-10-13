package net.mcreator.jujutsucraft.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.entity.CrowEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenRespawnProcedure {
   @SubscribeEvent
   public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
      execute(event, event.getEntity().m_9236_(), event.getEntity().m_20185_(), event.getEntity().m_20186_(), event.getEntity().m_20189_(), event.getEntity());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute((Event)null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         double sukuna_level = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double NUM1 = (double)0.0F;
         double T1 = (double)0.0F;
         double T2 = (double)0.0F;
         JujutsucraftModVariables.PlayerVariables pVars = null;
         if (entity instanceof Player) {
            pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((Object)null);
         }

         T1 = pVars.PlayerCurseTechnique;
         T2 = pVars.PlayerCurseTechnique2;
         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s only jujutsucraft:update");
         }

         if (entity instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entity;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:update"));
            AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
            if (!_ap.m_8193_()) {
               for(String criteria : _ap.m_8219_()) {
                  _player.m_8960_().m_135988_(_adv, criteria);
               }
            }
         }

         if (pVars.friend_num_keep != (double)0.0F) {
            entity.getPersistentData().m_128347_("friend_num", pVars.friend_num_keep);
            x_pos = (double)0.0F;
            z_pos = (double)0.0F;
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               Commands var10000 = entity.m_20194_().m_129892_();
               CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
               long var10002 = Math.round(x_pos);
               var10000.m_230957_(var10001, "execute in jujutsucraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos));
            }

            if (world instanceof ServerLevel) {
               ServerLevel _origLevel = (ServerLevel)world;
               LevelAccessor var30 = _origLevel.m_7654_().m_129880_(ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension")));
               if (var30 != null) {
                  Vec3 _center = new Vec3(x_pos, (double)128.0F, z_pos);

                  for(Entity entityiterator : var30.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)128.0F), (e) -> true)) {
                     if (entity != entityiterator && entityiterator.m_6084_() && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num_worker")) {
                        NUM1 = (double)0.0F;

                        for(int index0 = 0; index0 < 10000; ++index0) {
                           ++NUM1;
                           STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                           if (entity.getPersistentData().m_128459_(STR1) == (double)0.0F || entity.getPersistentData().m_128459_(STR1) == entityiterator.m_20186_() || entity.getPersistentData().m_128461_(STR1 + "_name").equals(entityiterator.m_5446_().getString())) {
                              entity.getPersistentData().m_128347_(STR1, entityiterator.m_20186_());
                              entity.getPersistentData().m_128359_(STR1 + "_name", entityiterator.m_5446_().getString());
                              entity.getPersistentData().m_128347_(STR1 + "_num", entity.getPersistentData().m_128459_(STR1 + "_num") + (double)1.0F);
                              break;
                           }
                        }

                        entityiterator.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                        entityiterator.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                     }
                  }
               }

               world = world;
            }

            pVars.friend_num_keep = (double)0.0F;
         }

         if ((T1 == (double)11.0F || T2 == (double)11.0F) && world.m_6443_(CrowEntity.class, AABB.m_165882_(new Vec3(x, y, z), (double)32.0F, (double)32.0F, (double)32.0F), (e) -> true).isEmpty()) {
            SummonCrowProcedure.execute(world, x, y, z, entity);
         }

         if (pVars.PlayerFlag_A) {
            pVars.PlayerFlag_A = false;
            pVars.FlagSixEyes = false;
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity26 = (LivingEntity)entity;
               if (_livingEntity26.m_21204_().m_22171_(Attributes.f_22284_)) {
                  _livingEntity26.m_21051_(Attributes.f_22284_).m_22100_((double)0.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity27 = (LivingEntity)entity;
               if (_livingEntity27.m_21204_().m_22171_(Attributes.f_22285_)) {
                  _livingEntity27.m_21051_(Attributes.f_22285_).m_22100_((double)0.0F);
               }
            }

            if (T1 == (double)-99.0F) {
               pVars.PlayerCurseTechnique = (double)0.0F;
               pVars.PlayerCursePowerFormer = (double)5.0F;
            } else {
               if (T1 == (double)0.0F) {
                  do {
                     pVars.PlayerCurseTechnique = (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 47);
                  } while(pVars.PlayerCurseTechnique == (double)42.0F);
               }

               if (pVars.PlayerCurseTechnique <= (double)0.0F) {
                  pVars.PlayerCurseTechnique = (double)-1.0F;
                  pVars.PlayerCursePowerFormer = (double)Mth.m_216271_(RandomSource.m_216327_(), 0, 5);
                  if (pVars.PlayerCursePowerFormer == (double)0.0F) {
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:completely_physically_gifted"));
                        AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }

                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _player = (ServerPlayer)entity;
                        Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:observation_of_the_soul"));
                        AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }
                  }
               } else {
                  pVars.PlayerCursePowerFormer = pVars.PlayerCurseTechnique == (double)5.0F ? (double)400.0F : (double)200.0F;
               }

               if (pVars.PlayerProfession >= (double)0.0F && Math.random() < 0.01) {
                  pVars.FlagSixEyes = true;
               }
            }

            pVars.PlayerCurseTechnique = pVars.PlayerCurseTechnique;
            pVars.BodyItem = ItemStack.f_41583_;
            pVars.flag_sukuna = false;
            pVars.noChangeTechnique = true;
            pVars.SecondTechnique = false;
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         }

         pVars.PlayerCursePowerMAX = pVars.PlayerCursePowerFormer * (double)Math.round(((double)2.0F + pVars.PlayerLevel) / 1.1);
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt30 = (LivingEntity)entity;
            if (_livEnt30.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
               int var67;
               label168: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        var67 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).m_19564_();
                        break label168;
                     }
                  }

                  var67 = 0;
               }

               sukuna_level = (double)Math.min(var67 + 1, 20);
               pVars.PlayerCursePowerMAX = Math.max(pVars.PlayerCursePowerMAX, sukuna_level <= (double)9.0F ? (double)3000.0F + (sukuna_level - (double)1.0F) * (double)300.0F : (double)8000.0F + (sukuna_level - (double)10.0F) * (double)1000.0F);
            }
         }

         if (!pVars.PlayerFlag_B) {
            pVars.PlayerFlag_B = true;
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19601_, 10, 10, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity33 = (LivingEntity)entity;
               if (_livingEntity33.m_21204_().m_22171_(Attributes.f_22284_)) {
                  _livingEntity33.m_21051_(Attributes.f_22284_).m_22100_((double)0.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity34 = (LivingEntity)entity;
               if (_livingEntity34.m_21204_().m_22171_(Attributes.f_22285_)) {
                  _livingEntity34.m_21051_(Attributes.f_22285_).m_22100_((double)0.0F);
               }
            }

            pVars.PlayerCursePower = pVars.PlayerCursePowerMAX;
            pVars.PlayerSelectCurseTechnique = (double)0.0F;
            entity.getPersistentData().m_128379_("infinity", false);
            entity.getPersistentData().m_128347_("brokenBrain", (double)0.0F);
            pVars.noChangeTechnique = true;
            pVars.SecondTechnique = false;
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            PlayerSetProfessionProcedure.execute(entity);
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement revoke @s only jujutsucraft:update");
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:update"));
               AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
               if (!_ap.m_8193_()) {
                  for(String criteria : _ap.m_8219_()) {
                     _player.m_8960_().m_135988_(_adv, criteria);
                  }
               }
            }
         }

         if (JujutsucraftModVariables.MapVariables.get(world).BlastGame) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _player = (ServerPlayer)entity;
               _player.m_143403_(GameType.SPECTATOR);
            }

            entity.m_6021_(JujutsucraftModVariables.MapVariables.get(world).BlastGameXCenter, JujutsucraftModVariables.MapVariables.get(world).BlastGameYCenter, JujutsucraftModVariables.MapVariables.get(world).BlastGameZCenter);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(JujutsucraftModVariables.MapVariables.get(world).BlastGameXCenter, JujutsucraftModVariables.MapVariables.get(world).BlastGameYCenter, JujutsucraftModVariables.MapVariables.get(world).BlastGameZCenter, entity.m_146908_(), entity.m_146909_());
            }
         }

         pVars.syncPlayerVariables(entity);
      }
   }
}
