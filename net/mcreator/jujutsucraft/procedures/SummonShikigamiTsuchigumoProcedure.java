package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.EntityTsuchigumoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

public class SummonShikigamiTsuchigumoProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         String str1 = "";
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double NUM_SUM = (double)0.0F;
         double dis = (double)0.0F;
         double HP = (double)0.0F;
         double distance = (double)0.0F;
         double pitch = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") < (double)4.0F) {
            CompoundTag var10000 = entity.getPersistentData();
            str1 = "SHIKIGAMI_TSUCHIGUMO_UUID" + Math.round(var10000.m_128459_("cnt2"));
            if (GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_(str1)) instanceof EntityTsuchigumoEntity && !GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_(str1)).m_9236_().m_5776_()) {
               GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_(str1)).m_146870_();
            }

            yaw = (double)entity.m_146908_();
            picth = (double)entity.m_146909_();
            if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
               entity.getPersistentData().m_128347_("friend_num", Math.random());
            }

            entity.m_146922_((float)(yaw + Math.random() * (double)180.0F - (double)90.0F));
            entity.m_146926_((float)(Math.random() * (double)22.5F - (double)11.25F));
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            dis = (double)1.0F + Math.random() * (double)5.0F;
            x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_() + Math.random() - (double)0.5F;
            y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() + Math.random() - (double)0.5F;
            z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_() + Math.random() - (double)0.5F;
            entity.m_146922_((float)yaw);
            entity.m_146926_((float)picth);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 10, (double)0.25F, (double)0.25F, (double)0.25F, (double)0.0F);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.ambient")), SoundSource.NEUTRAL, 0.5F, 0.5F);
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.ambient")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
               }
            }

            if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
               entity.getPersistentData().m_128347_("friend_num", Math.random());
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_TSUCHIGUMO.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity28 = (LivingEntity)entityinstance;
                     if (_livingEntity28.m_21204_().m_22171_(Attributes.f_22281_)) {
                        double var10001;
                        label108: {
                           var46 = _livingEntity28.m_21051_(Attributes.f_22281_);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity24 = (LivingEntity)entityinstance;
                              if (_livingEntity24.m_21204_().m_22171_(Attributes.f_22281_)) {
                                 var10001 = _livingEntity24.m_21051_(Attributes.f_22281_).m_22115_();
                                 break label108;
                              }
                           }

                           var10001 = (double)0.0F;
                        }

                        double var10002;
                        label103: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity25 = (LivingEntity)entity;
                              if (_livingEntity25.m_21204_().m_22171_(Attributes.f_22281_)) {
                                 var10002 = _livingEntity25.m_21051_(Attributes.f_22281_).m_22115_();
                                 break label103;
                              }
                           }

                           var10002 = (double)0.0F;
                        }

                        int var10003;
                        label98: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label98;
                              }
                           }

                           var10003 = 0;
                        }

                        var46.m_22100_(var10001 + (var10002 + (double)(var10003 * 3)) * (double)0.5F);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.m_9236_().m_5776_()) {
                        MobEffectInstance var47;
                        MobEffect var48;
                        int var10005;
                        label90: {
                           var47 = new MobEffectInstance;
                           var48 = MobEffects.f_19606_;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                 var10005 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                 break label90;
                              }
                           }

                           var10005 = 0;
                        }

                        var47.<init>(var48, Integer.MAX_VALUE, Math.max(var10005, 0), false, false);
                        _entity.m_7292_(var47);
                     }
                  }

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
                  entity.getPersistentData().m_128359_(str1, entityinstance.m_20149_());
                  entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                  entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                  entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
                  entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                  entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                  entityinstance.getPersistentData().m_128379_("CursedSpirit", true);
                  entityinstance.getPersistentData().m_128379_("Shikigami", true);
                  if (entity instanceof Player) {
                     entityinstance.getPersistentData().m_128347_("BaseCursePower", Math.floor(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost * (double)0.25F));
                  }

                  if (entityinstance instanceof EntityTsuchigumoEntity) {
                     EntityTsuchigumoEntity _datEntSetI = (EntityTsuchigumoEntity)entityinstance;
                     _datEntSetI.m_20088_().m_135381_(EntityTsuchigumoEntity.DATA_model, (int)(entity.getPersistentData().m_128459_("cnt2") % (double)4.0F));
                  }

                  _serverLevel.m_7967_(entityinstance);
               }
            }

            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)12.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
