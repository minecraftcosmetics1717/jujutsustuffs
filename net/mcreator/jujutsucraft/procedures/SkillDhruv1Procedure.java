package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.ShikigamiHeterocephalusGlaberEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;

public class SkillDhruv1Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double num1 = (double)0.0F;
         double range = (double)0.0F;
         double num2 = (double)0.0F;
         double pitch = (double)0.0F;
         double HP = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") > (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt1", (double)-6.0F);
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
               entity.getPersistentData().m_128347_("cnt3", ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            CompoundTag var10001 = entity.getPersistentData();
            CompoundTag var10002 = entity.getPersistentData();
            entity_a = GetEntityFromUUIDProcedure.execute(world, var10001.m_128461_("SHIKIGAMI_DHRUV1_" + Math.round(var10002.m_128459_("cnt2"))));
            if (entity_a instanceof ShikigamiHeterocephalusGlaberEntity && !entity_a.m_9236_().m_5776_()) {
               entity_a.m_146870_();
            }

            if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
               entity.getPersistentData().m_128347_("friend_num", Math.random());
            }

            yaw = (double)entity.m_146908_();
            pitch = (double)entity.m_146909_();
            x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)3.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
            y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)3.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
            z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)3.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.SHIKIGAMI_HETEROCEPHALUS_GLABER.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  entityinstance.m_146922_(entity.m_146908_());
                  entityinstance.m_146926_(entity.m_146909_());
                  entityinstance.m_5618_(entityinstance.m_146908_());
                  entityinstance.m_5616_(entityinstance.m_146908_());
                  entityinstance.f_19859_ = entityinstance.m_146908_();
                  entityinstance.f_19860_ = entityinstance.m_146909_();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                  entity.getPersistentData().m_128359_("SHIKIGAMI_DHRUV1_" + Math.round(entity.getPersistentData().m_128459_("cnt2")), entityinstance.m_20149_());
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity37 = (LivingEntity)entityinstance;
                     if (_livingEntity37.m_21204_().m_22171_(Attributes.f_22281_)) {
                        AttributeInstance var10000;
                        label94: {
                           var10000 = _livingEntity37.m_21051_(Attributes.f_22281_);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity33 = (LivingEntity)entityinstance;
                              if (_livingEntity33.m_21204_().m_22171_(Attributes.f_22281_)) {
                                 var38 = _livingEntity33.m_21051_(Attributes.f_22281_).m_22115_();
                                 break label94;
                              }
                           }

                           var38 = (double)0.0F;
                        }

                        label89: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity34 = (LivingEntity)entity;
                              if (_livingEntity34.m_21204_().m_22171_(Attributes.f_22281_)) {
                                 var40 = _livingEntity34.m_21051_(Attributes.f_22281_).m_22115_();
                                 break label89;
                              }
                           }

                           var40 = (double)0.0F;
                        }

                        int var10003;
                        label84: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label84;
                              }
                           }

                           var10003 = 0;
                        }

                        var10000.m_22100_(var38 + (var40 + (double)(var10003 * 3)) * (double)1.0F);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.m_9236_().m_5776_()) {
                        MobEffect var41;
                        int var10005;
                        label73: {
                           var39 = new MobEffectInstance;
                           var41 = MobEffects.f_19606_;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                 var10005 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                 break label73;
                              }
                           }

                           var10005 = 0;
                        }

                        var39.<init>(var41, Integer.MAX_VALUE, Math.max(var10005, 0), false, false);
                        _entity.m_7292_(var39);
                     }
                  }

                  entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                  entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                  entityinstance.getPersistentData().m_128379_("Shikigami", true);
                  entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
                  entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                  entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                  if (entity instanceof Player) {
                     entityinstance.getPersistentData().m_128347_("BaseCursePower", entity.getPersistentData().m_128459_("cnt3") * (double)0.5F);
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") > (double)1.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
