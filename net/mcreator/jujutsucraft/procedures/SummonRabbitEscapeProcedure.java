package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.HoshiKiraraEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SummonRabbitEscapeProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double NUM_SUM = (double)0.0F;
         double dis = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (!(entity instanceof Player) && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            entity.getPersistentData().m_128347_("cnt4", 0.025);
            DespawnTenShadowsTechniqueProcedure.execute(world, x, y, z, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") < (double)15.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity7 = (LivingEntity)entity;
               if (_livingEntity7.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity7.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)20.0F);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)5.0F && entity.getPersistentData().m_128459_("cnt1") < (double)26.0F) {
            yaw = (double)entity.m_146908_();
            picth = (double)entity.m_146909_();
            if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
               entity.getPersistentData().m_128347_("friend_num", Math.random());
            }

            for(int index0 = 0; index0 < 2; ++index0) {
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
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 10, (double)0.25F, (double)0.25F, (double)0.25F, (double)0.0F);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.pickup")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.pickup")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.RABBIT_ESCAPE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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

                     label106: {
                        label137: {
                           entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                           entityinstance.getPersistentData().m_128347_("friend_num2", entity.getPersistentData().m_128459_("friend_num"));
                           if (entity.getPersistentData().m_128459_("TenShadowsTechnique8") != (double)1.0F) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label137;
                              }

                              ServerPlayer _plr31 = (ServerPlayer)entity;
                              if (!(_plr31.m_9236_() instanceof ServerLevel) || !_plr31.m_8960_().m_135996_(_plr31.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_rabbit_escape"))).m_8193_()) {
                                 break label137;
                              }
                           }

                           entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                           entityinstance.getPersistentData().m_128379_("Ambush", true);
                           entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
                           entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                           entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                           break label106;
                        }

                        entityinstance.getPersistentData().m_128359_("TARGET_UUID", entity.m_20149_());
                        entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                     }

                     if (entity instanceof Player) {
                        entityinstance.getPersistentData().m_128347_("BaseCursePower", Math.max(Math.floor(entity.getPersistentData().m_128459_("cnt10") / (double)40.0F), (double)1.0F));
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }

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

            if (entity.getPersistentData().m_128459_("cnt1") >= (double)25.0F) {
               entity.getPersistentData().m_128347_("TenShadowsTechnique8", (double)-1.0F);
               boolean _setval = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.noChangeTechnique = _setval;
                  capability.syncPlayerVariables(entity);
               });
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)35.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)16.0F), (e) -> true)) {
               if (entityiterator instanceof HoshiKiraraEntity) {
                  entityiterator.m_7618_(Anchor.EYES, new Vec3(x, y, z));
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123750_, entityiterator.m_20185_(), entityiterator.m_20186_() + (double)entityiterator.m_20206_(), entityiterator.m_20189_(), 1, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F);
                  }
               }
            }
         }

      }
   }
}
