package net.mcreator.jujutsucraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class AIMahitoHand3Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean dis = false;
         Entity entity_a = null;
         double z_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double x_pos = (double)0.0F;
         double loop_num = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double speed = (double)0.0F;
         double entity_size = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         logic_a = false;
         if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
               logic_a = true;
               if (entity_a.getPersistentData().m_128459_("skill") <= (double)0.0F) {
                  logic_a = false;
               }

               if (!entity.m_6084_()) {
                  entity_a.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }

            if (!entity_a.m_6084_() && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
            }
         }

         entity.getPersistentData().m_128347_("Damage", (double)11.0F);
         entity.getPersistentData().m_128347_("Range", (double)6.5F * entity_size);
         entity.getPersistentData().m_128347_("knockback", (double)1.0F);
         entity.getPersistentData().m_128379_("attack", true);
         RangeAttackProcedure.execute(world, x, entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, z, entity);
         entity.getPersistentData().m_128347_("BlockRange", (double)1.5F * entity_size);
         entity.getPersistentData().m_128347_("BlockDamage", (double)4.0F);
         BlockDestroyAllDirectionProcedure.execute(world, x + (Math.random() - (double)0.5F) * entity_size * (double)2.0F, y + (double)1.0F * entity_size, z + (Math.random() - (double)0.5F) * entity_size * (double)2.0F, entity);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123796_, x, y, z, (int)((double)3.0F * entity_size), entity_size, (double)0.5F, entity_size, (double)0.25F);
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)((double)0.5F * entity_size), 0.7F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)((double)0.5F * entity_size), 0.7F, false);
            }
         }

         if (!logic_a && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
