package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.EntityImpactWaveEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIImpactWaveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double CNT6 = (double)0.0F;
         double size = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double life = (double)0.0F;
         size = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
         range = (double)(entity.m_20206_() + entity.m_20205_()) * (double)0.75F + (double)4.0F;
         int var10000;
         if (entity instanceof EntityImpactWaveEntity) {
            EntityImpactWaveEntity _datEntI = (EntityImpactWaveEntity)entity;
            var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityImpactWaveEntity.DATA_mode);
         } else {
            var10000 = 0;
         }

         if (var10000 == 2) {
            life = (double)12.0F;
            size = (double)6.0F;
         } else {
            if (entity instanceof EntityImpactWaveEntity) {
               EntityImpactWaveEntity _datEntI = (EntityImpactWaveEntity)entity;
               var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityImpactWaveEntity.DATA_mode);
            } else {
               var10000 = 0;
            }

            if (var10000 == 1) {
               life = (double)10.0F;
               size = (double)6.0F + entity.getPersistentData().m_128459_("cnt6");
            } else {
               life = (double)15.0F;
               size = (double)12.0F;
            }
         }

         label109: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity13 = (LivingEntity)entity;
               if (_livingEntity13.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  var36 = _livingEntity13.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                  break label109;
               }
            }

            var36 = (double)0.0F;
         }

         if (var36 < size) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity15 = (LivingEntity)entity;
               if (_livingEntity15.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  double var10001;
                  label100: {
                     var37 = _livingEntity15.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get());
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity14 = (LivingEntity)entity;
                        if (_livingEntity14.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10001 = _livingEntity14.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                           break label100;
                        }
                     }

                     var10001 = (double)0.0F;
                  }

                  var37.m_22100_(var10001 + Math.max(life / size, (double)1.5F));
               }
            }

            entity.m_6021_(entity.m_20185_(), entity.m_20186_() - Math.max(life / size, (double)1.5F) * (double)0.5F, entity.m_20189_());
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() - Math.max(life / size, (double)1.5F) * (double)0.5F, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               BlockPos var10002;
               SoundEvent var10003;
               SoundSource var10004;
               double var10005;
               label88: {
                  var10002 = BlockPos.m_274561_(x_pos, y_pos, z_pos);
                  var10003 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode"));
                  var10004 = SoundSource.NEUTRAL;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity20 = (LivingEntity)entity;
                     if (_livingEntity20.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        var10005 = _livingEntity20.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                        break label88;
                     }
                  }

                  var10005 = (double)0.0F;
               }

               _level.m_5594_((Player)null, var10002, var10003, var10004, (float)(var10005 * 0.1 + (double)1.0F), 0.5F);
            } else {
               SoundEvent var38;
               SoundSource var39;
               double var10006;
               label83: {
                  var38 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode"));
                  var39 = SoundSource.NEUTRAL;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity20 = (LivingEntity)entity;
                     if (_livingEntity20.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        var10006 = _livingEntity20.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                        break label83;
                     }
                  }

                  var10006 = (double)0.0F;
               }

               _level.m_7785_(x_pos, y_pos, z_pos, var38, var39, (float)(var10006 * 0.1 + (double)1.0F), 0.5F, false);
            }
         }

         entity.getPersistentData().m_128347_("Damage", (double)(entity.getPersistentData().m_128459_("cnt1") > life - (double)6.0F ? 18 : 16) * CNT6 + entity.getPersistentData().m_128459_("cnt1") * 0.001);
         entity.getPersistentData().m_128347_("Range", (double)1.5F * range);
         entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("cnt1") > life - (double)6.0F ? Math.min((double)0.5F * CNT6, (double)2.0F) : 0.1);
         entity.getPersistentData().m_128347_("effect", (double)0.0F);
         RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         if (entity.getPersistentData().m_128459_("cnt1") % (double)6.0F == (double)1.0F) {
            entity.getPersistentData().m_128347_("BlockRange", (double)0.5F * range);
            entity.getPersistentData().m_128347_("BlockDamage", (double)8.0F);
            entity.getPersistentData().m_128379_("noParticle", true);
            BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         }

         entity.getPersistentData().m_128347_("Range", (double)1.5F * range);
         entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("cnt1") > life - (double)6.0F ? Math.min((double)0.5F * CNT6, (double)2.0F) : 0.1);
         KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:cloud ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " 4 " + Math.round((double)2.0F * range) + " force");
         }

         if (entity.getPersistentData().m_128459_("cnt1") > life && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
