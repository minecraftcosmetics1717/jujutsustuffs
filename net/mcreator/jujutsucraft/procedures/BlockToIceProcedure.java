package net.mcreator.jujutsucraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class BlockToIceProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         BlockState block_a = Blocks.f_50016_.m_49966_();
         boolean logic_a = false;
         String destroy_type = "";
         double x_dis = (double)0.0F;
         double distance = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_dis = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double y_dis = (double)0.0F;
         double RANGE = (double)0.0F;
         if (world.m_6106_().m_5470_().m_46207_(GameRules.f_46132_)) {
            if (world.m_6106_().m_5470_().m_46207_(GameRules.f_46136_)) {
               logic_a = true;
               ((GameRules.BooleanValue)world.m_6106_().m_5470_().m_46170_(GameRules.f_46136_)).m_46246_(false, world.m_7654_());
            }

            destroy_type = "replace";
            RANGE = entity.getPersistentData().m_128459_("BlockRange");
            if (RANGE >= (double)1.0F) {
               RANGE = (double)Math.round(RANGE * (double)2.0F);
            } else {
               RANGE = (double)1.0F;
            }

            x_pos = (double)Math.round(x - RANGE * (double)0.5F);

            for(int index0 = 0; index0 < (int)RANGE; ++index0) {
               x_dis = x_pos - x;
               x_dis *= x_dis;
               y_pos = (double)Math.round(y - RANGE * (double)0.5F);

               for(int index1 = 0; index1 < (int)RANGE; ++index1) {
                  y_dis = y_pos - y;
                  y_dis *= y_dis;
                  z_pos = (double)Math.round(z - RANGE * (double)0.5F);

                  for(int index2 = 0; index2 < (int)RANGE; ++index2) {
                     block_a = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos));
                     if (!block_a.m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
                        label76: {
                           if (!(block_a.m_60734_() instanceof LiquidBlock)) {
                              Property var31 = block_a.m_60734_().m_49965_().m_61081_("waterlogged");
                              if (!(var31 instanceof BooleanProperty)) {
                                 break label76;
                              }

                              BooleanProperty _getbp7 = (BooleanProperty)var31;
                              if (!(Boolean)block_a.m_61143_(_getbp7)) {
                                 break label76;
                              }
                           }

                           z_dis = z_pos - z;
                           z_dis *= z_dis;
                           distance = x_dis + y_dis + z_dis;
                           if (distance <= Math.max(RANGE * (double)0.5F, (double)1.0F) * Math.max(RANGE * (double)0.5F, (double)1.0F)) {
                              label69: {
                                 label68: {
                                    if (block_a.m_60734_() != Blocks.f_49990_) {
                                       Property var32 = block_a.m_60734_().m_49965_().m_61081_("waterlogged");
                                       if (!(var32 instanceof BooleanProperty)) {
                                          break label68;
                                       }

                                       BooleanProperty _getbp9 = (BooleanProperty)var32;
                                       if (!(Boolean)block_a.m_61143_(_getbp9)) {
                                          break label68;
                                       }
                                    }

                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ packed_ice replace");
                                    }
                                    break label69;
                                 }

                                 if (block_a.m_60734_() == Blocks.f_49991_) {
                                    if (world instanceof ServerLevel) {
                                       ServerLevel _level = (ServerLevel)world;
                                       _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ stone replace");
                                    }
                                 } else if (block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:leaves"))) && world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ packed_ice replace");
                                 }
                              }
                           }
                        }
                     }

                     ++z_pos;
                  }

                  ++y_pos;
               }

               ++x_pos;
            }

            if (logic_a) {
               ((GameRules.BooleanValue)world.m_6106_().m_5470_().m_46170_(GameRules.f_46136_)).m_46246_(true, world.m_7654_());
            }
         }

         entity.getPersistentData().m_128347_("BlockRange", (double)0.0F);
         entity.getPersistentData().m_128347_("BlockDamage", (double)0.0F);
      }
   }
}
