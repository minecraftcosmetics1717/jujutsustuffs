package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.EntityDomainIshigoriEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class IshigoriDomainExpansionActiveProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double range;
         double var10000;
         label62: {
            double x_center = (double)0.0F;
            double distance = (double)0.0F;
            double ticks = (double)0.0F;
            double z_center = (double)0.0F;
            range = (double)0.0F;
            double x_pos = (double)0.0F;
            double y_center = (double)0.0F;
            double pitch = (double)0.0F;
            double y_pos = (double)0.0F;
            double z_pos = (double)0.0F;
            double yaw = (double)0.0F;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)1.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label62;
               }
            }

            var10000 = (double)0.0F;
         }

         double var30 = var10000;
         double var28 = entity.getPersistentData().m_128459_("x_pos_doma");
         double var34 = entity.getPersistentData().m_128459_("y_pos_doma");
         double var31 = entity.getPersistentData().m_128459_("z_pos_doma");
         if (var30 % (double)10.0F == (double)0.0F && Math.random() < (double)0.5F) {
            for(int index0 = 0; index0 < 3; ++index0) {
               double var29 = range - Mth.m_216263_(RandomSource.m_216327_(), (double)4.0F, (double)6.0F);
               double var38 = Math.toRadians(Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F));
               double var35 = Math.toRadians(Mth.m_216263_(RandomSource.m_216327_(), (double)-30.0F, (double)-5.0F));
               double var33 = var28 + Math.cos(var38) * Math.cos(var35) * var29;
               double var36 = var34 + Math.sin(var35) * (double)-1.0F * var29;
               double var37 = var31 + Math.sin(var38) * Math.cos(var35) * var29;
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_DOMAIN_ISHIGORI.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(var33, var36, var37), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
                     }

                     entityinstance.getPersistentData().m_128347_("NameRanged_ranged", entity.getPersistentData().m_128459_("NameRanged"));
                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity17 = (LivingEntity)entityinstance;
                        if (_livingEntity17.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity17.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(Mth.m_216263_(RandomSource.m_216327_(), (double)3.0F, (double)4.0F));
                        }
                     }

                     if (entityinstance instanceof EntityDomainIshigoriEntity) {
                        RandomSource var10001 = RandomSource.m_216327_();
                        PlayAnimationEntity2Procedure.execute(entityinstance, "idle" + Math.round((float)Mth.m_216271_(var10001, 1, 4)));
                     }

                     entityinstance.m_7618_(Anchor.EYES, new Vec3(var28, var34, var31));
                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(var28, var34, var31), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 3.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.1));
               } else {
                  _level.m_7785_(var28, var34, var31, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 3.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.1), false);
               }
            }
         }

      }
   }
}
