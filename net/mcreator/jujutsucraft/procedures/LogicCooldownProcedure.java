package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;

public class LogicCooldownProcedure {
   public static boolean execute(Entity entity) {
      return entity == null ? false : LogicCooldownMagicOnlyProcedure.execute(entity);
   }
}
