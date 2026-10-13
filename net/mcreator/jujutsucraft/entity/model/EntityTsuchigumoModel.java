package net.mcreator.jujutsucraft.entity.model;

import net.mcreator.jujutsucraft.entity.EntityTsuchigumoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityTsuchigumoModel extends GeoModel<EntityTsuchigumoEntity> {
   public ResourceLocation getAnimationResource(EntityTsuchigumoEntity entity) {
      if ((Integer)entity.m_20088_().m_135370_(EntityTsuchigumoEntity.DATA_model) == 1) {
         return new ResourceLocation("jujutsucraft", "animations/cursedspirit_tsuchigumo_mini_2.animation.json");
      } else if ((Integer)entity.m_20088_().m_135370_(EntityTsuchigumoEntity.DATA_model) == 2) {
         return new ResourceLocation("jujutsucraft", "animations/cursedspirit_tsuchigumo_mini_3.animation.json");
      } else {
         return (Integer)entity.m_20088_().m_135370_(EntityTsuchigumoEntity.DATA_model) == 3 ? new ResourceLocation("jujutsucraft", "animations/cursedspirit_tsuchigumo_mini_4.animation.json") : new ResourceLocation("jujutsucraft", "animations/cursedspirit_tsuchigumo_mini_1.animation.json");
      }
   }

   public ResourceLocation getModelResource(EntityTsuchigumoEntity entity) {
      if ((Integer)entity.m_20088_().m_135370_(EntityTsuchigumoEntity.DATA_model) == 1) {
         return new ResourceLocation("jujutsucraft", "geo/cursedspirit_tsuchigumo_mini_2.geo.json");
      } else if ((Integer)entity.m_20088_().m_135370_(EntityTsuchigumoEntity.DATA_model) == 2) {
         return new ResourceLocation("jujutsucraft", "geo/cursedspirit_tsuchigumo_mini_3.geo.json");
      } else {
         return (Integer)entity.m_20088_().m_135370_(EntityTsuchigumoEntity.DATA_model) == 3 ? new ResourceLocation("jujutsucraft", "geo/cursedspirit_tsuchigumo_mini_4.geo.json") : new ResourceLocation("jujutsucraft", "geo/cursedspirit_tsuchigumo_mini_1.geo.json");
      }
   }

   public ResourceLocation getTextureResource(EntityTsuchigumoEntity entity) {
      if ((Integer)entity.m_20088_().m_135370_(EntityTsuchigumoEntity.DATA_model) == 1) {
         return new ResourceLocation("jujutsucraft", "textures/entities/cursedspirit_tsuchigumo_mini_2.png");
      } else if ((Integer)entity.m_20088_().m_135370_(EntityTsuchigumoEntity.DATA_model) == 2) {
         return new ResourceLocation("jujutsucraft", "textures/entities/cursedspirit_tsuchigumo_mini_3.png");
      } else {
         return (Integer)entity.m_20088_().m_135370_(EntityTsuchigumoEntity.DATA_model) == 3 ? new ResourceLocation("jujutsucraft", "textures/entities/cursedspirit_tsuchigumo_mini_4.png") : new ResourceLocation("jujutsucraft", "textures/entities/cursedspirit_tsuchigumo_mini_1.png");
      }
   }
}
