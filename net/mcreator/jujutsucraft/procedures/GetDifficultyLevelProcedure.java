package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.Difficulty;
import net.minecraft.world.level.LevelAccessor;

public class GetDifficultyLevelProcedure {
   public static double execute(LevelAccessor world) {
      double num1 = (double)0.0F;
      if (world.m_46791_() == Difficulty.HARD) {
         num1 = 0.325;
      } else if (world.m_46791_() == Difficulty.NORMAL) {
         num1 = 0.3;
      } else {
         num1 = 0.275;
      }

      return num1;
   }
}
