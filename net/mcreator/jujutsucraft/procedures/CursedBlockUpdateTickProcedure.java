package net.mcreator.jujutsucraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CursedBlockUpdateTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double NUM1 = (double)0.0F;
      boolean logic_start = false;
      NUM1 = (double)Math.round(((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : (double)-1.0F;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "run_type"));
      if (NUM1 != (double)0.0F) {
         if (!world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), (double)64.0F, (double)64.0F, (double)64.0F), (e) -> true).isEmpty() && world.m_46791_() != Difficulty.PEACEFUL && world.m_6106_().m_5470_().m_46207_(GameRules.f_46134_)) {
            if (NUM1 <= (double)5.0F) {
               if (NUM1 == (double)1.0F) {
                  BuildReformatoryProcedure.execute(world, x, y, z);
               } else if (NUM1 == (double)2.0F) {
                  BuildTempleWoodenProcedure.execute(world, x, y, z);
               } else if (NUM1 == (double)3.0F) {
                  BuildGraveyardProcedure.execute(world, x, y, z);
               } else if (NUM1 == (double)4.0F) {
                  BuildGraveyard2Procedure.execute(world, x, y, z);
               } else if (NUM1 == (double)5.0F) {
                  BuildHospital1Procedure.execute(world, x, y, z);
               }
            } else if (NUM1 <= (double)10.0F) {
               if (NUM1 == (double)6.0F) {
                  BuildEatingHouse1Procedure.execute(world, x, y, z);
               } else if (NUM1 == (double)7.0F) {
                  BuildSchoolProcedure.execute(world, x, y, z);
               } else if (NUM1 == (double)8.0F) {
                  BuildShoppingStreetProcedure.execute(world, x, y, z);
               } else if (NUM1 == (double)9.0F) {
                  BuildGate1Procedure.execute(world, x, y, z);
               } else if (NUM1 == (double)10.0F) {
                  BuildApartmenthouse1Procedure.execute(world, x, y, z);
               }
            } else if (NUM1 <= (double)15.0F) {
               if (NUM1 == (double)11.0F) {
                  BuildHouseZeninProcedure.execute(world, x, y, z);
               } else if (NUM1 == (double)12.0F) {
                  BuildTowerTempleProcedure.execute(world, x, y, z);
               }
            }
         }

         if (NUM1 >= (double)29.0F) {
            BuildVillageProcedure.execute(world, x, y, z);
         }
      }

   }
}
