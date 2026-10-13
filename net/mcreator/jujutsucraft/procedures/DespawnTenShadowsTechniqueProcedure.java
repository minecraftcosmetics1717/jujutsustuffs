package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.FushiguroMegumiEntity;
import net.mcreator.jujutsucraft.entity.MaxElephantEntity;
import net.mcreator.jujutsucraft.entity.RabbitEscapeEntity;
import net.mcreator.jujutsucraft.entity.RozetsuShikigamiVessel2Entity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class DespawnTenShadowsTechniqueProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM1 = (double)0.0F;
         double NUM_SUM = (double)0.0F;
         double NUM_SUM_TRUE = (double)0.0F;
         if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
            if (entity.getPersistentData().m_128459_("skill") != (double)0.0F) {
               if (entity.getPersistentData().m_128459_("cnt4") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt4", (double)1.0F);
               }

               if (entity instanceof RozetsuShikigamiVessel2Entity) {
                  entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") - (double)8.0F);
               }

               NUM_SUM = entity.getPersistentData().m_128459_("cnt4");
            }

            NUM_SUM_TRUE = NUM_SUM;
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)128.0F), (e) -> true)) {
               if (entity != entityiterator && entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && !entityiterator.getPersistentData().m_128471_("domain_entity") && entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num") && entityiterator.getPersistentData().m_128471_("Ambush")) {
                  if (entity instanceof FushiguroMegumiEntity && entityiterator instanceof MaxElephantEntity) {
                     NUM1 = (double)2.0F;
                  } else if (entityiterator instanceof RabbitEscapeEntity) {
                     NUM1 = 0.025;
                  } else {
                     NUM1 = (double)1.0F;
                  }

                  if (NUM_SUM + NUM1 > (double)2.0F && entity.getPersistentData().m_128459_("skill") != (double)0.0F) {
                     entityiterator.getPersistentData().m_128379_("flag_despawn", true);
                  } else {
                     NUM_SUM_TRUE += NUM1;
                  }

                  NUM_SUM += NUM1;
               }
            }
         }

         entity.getPersistentData().m_128347_("cnt4", (double)0.0F);
         if (!(entity instanceof Player)) {
            if (NUM_SUM_TRUE > (double)2.0F) {
               entity.getPersistentData().m_128347_("NUM_TenShadowsTechnique", (double)0.0F);
            } else {
               entity.getPersistentData().m_128347_("NUM_TenShadowsTechnique", NUM_SUM_TRUE);
            }
         }

      }
   }
}
