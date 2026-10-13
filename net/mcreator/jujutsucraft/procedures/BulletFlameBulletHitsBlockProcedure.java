package net.mcreator.jujutsucraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class BulletFlameBulletHitsBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double old_skill = (double)0.0F;
         double CNT6 = (double)0.0F;
         double range = (double)0.0F;
         CNT6 = (double)1.0F + immediatesourceentity.getPersistentData().m_128459_("cnt6") * 0.1;
         range = (double)1.0F + ReturnEntitySizeProcedure.execute(immediatesourceentity);
         old_skill = entity.getPersistentData().m_128459_("skill");
         entity.getPersistentData().m_128347_("skill", immediatesourceentity.getPersistentData().m_128459_("skill"));
         entity.getPersistentData().m_128347_("BlockDamage", (double)4.0F * CNT6);
         entity.getPersistentData().m_128347_("BlockRange", (double)2.0F * range);
         entity.getPersistentData().m_128347_("effect", (double)3.0F);
         entity.getPersistentData().m_128379_("noParticle", true);
         BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
         entity.getPersistentData().m_128347_("Damage", immediatesourceentity.getPersistentData().m_128459_("Damage"));
         entity.getPersistentData().m_128347_("knockback", (double)0.25F * CNT6);
         entity.getPersistentData().m_128347_("Range", (double)4.0F * range);
         entity.getPersistentData().m_128347_("effect", (double)10.0F);
         entity.getPersistentData().m_128379_("attack", false);
         RangeAttackProcedure.execute(world, x, y, z, entity);
         entity.getPersistentData().m_128347_("skill", old_skill);
         if (world.m_6106_().m_5470_().m_46207_(GameRules.f_46132_) && Math.random() < 0.1 && !world.m_8055_(BlockPos.m_274561_(x, y, z)).m_60815_() && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            FallingBlockEntity.m_201971_(_level, BlockPos.m_274561_(x, y, z), Blocks.f_50083_.m_49966_());
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)1.5F * CNT6), 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)((double)1.5F * CNT6), 1.0F, false);
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:explosion ~ ~ ~ " + range * (double)2.0F + " " + range * (double)2.0F + " " + range * (double)2.0F + " " + (double)0.25F * CNT6 + " " + Math.round((double)2.0F * CNT6 * range) + " force");
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:cloud ~ ~ ~ " + range * (double)1.0F + " " + range * (double)1.0F + " " + range * (double)1.0F + " " + (double)0.25F * CNT6 + " " + Math.round((double)4.0F * CNT6 * range) + " force");
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:flame ~ ~ ~ " + range * (double)1.0F + " " + range * (double)1.0F + " " + range * (double)1.0F + " " + (double)0.25F * CNT6 + " " + Math.round((double)8.0F * CNT6 * range) + " force");
         }

         if (!immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}
