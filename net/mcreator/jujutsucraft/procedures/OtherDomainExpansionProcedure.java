package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class OtherDomainExpansionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128347_("select", Math.floor(entity.getPersistentData().m_128459_("skill") / (double)100.0F));
         DomainExpansionCreateBarrierProcedure.execute(world, x, y, z, entity);
         PlayAnimationProcedure.execute(world, entity);
      }
   }
}
