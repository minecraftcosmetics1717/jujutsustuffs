package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.BlueEntity;
import net.mcreator.jujutsucraft.entity.RedEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AIBlueRedProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double num1 = (double)0.0F;
         boolean logic_a = false;
         boolean logic_despawn = false;
         boolean logic_attack = false;
         Entity entity_a = null;
         if (LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            logic_a = false;
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") != (double)0.0F) {
               label104: {
                  label105: {
                     if (entity instanceof RedEntity) {
                        RedEntity _datEntL3 = (RedEntity)entity;
                        if ((Boolean)_datEntL3.m_20088_().m_135370_(RedEntity.DATA_flag_purple)) {
                           break label105;
                        }
                     }

                     if (entity instanceof BlueEntity) {
                        BlueEntity _datEntL4 = (BlueEntity)entity;
                        if ((Boolean)_datEntL4.m_20088_().m_135370_(BlueEntity.DATA_flag_purple)) {
                           break label105;
                        }
                     }

                     label106: {
                        label107: {
                           if (entity instanceof RedEntity) {
                              if (!(entity instanceof RedEntity)) {
                                 break label107;
                              }

                              RedEntity _datEntL19 = (RedEntity)entity;
                              if (!(Boolean)_datEntL19.m_20088_().m_135370_(RedEntity.DATA_flag_start)) {
                                 break label107;
                              }
                           }

                           if (!(entity instanceof BlueEntity)) {
                              break label106;
                           }

                           if (entity instanceof BlueEntity) {
                              BlueEntity _datEntL21 = (BlueEntity)entity;
                              if ((Boolean)_datEntL21.m_20088_().m_135370_(BlueEntity.DATA_flag_start)) {
                                 break label106;
                              }
                           }
                        }

                        if (entity.getPersistentData().m_128459_("NameRanged_ranged") != entity_a.getPersistentData().m_128459_("NameRanged")) {
                           break label104;
                        }

                        logic_a = true;
                        if (entity instanceof RedEntity) {
                           entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
                           entity.m_146922_(entity_a.m_146908_());
                           entity.m_146926_(entity_a.m_146909_());
                           entity.m_5618_(entity.m_146908_());
                           entity.m_5616_(entity.m_146908_());
                           entity.f_19859_ = entity.m_146908_();
                           entity.f_19860_ = entity.m_146909_();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }

                           if ((!entity.m_6084_() || entity_a.getPersistentData().m_128459_("skill") == (double)0.0F) && entity instanceof RedEntity) {
                              RedEntity _datEntSetL = (RedEntity)entity;
                              _datEntSetL.m_20088_().m_135381_(RedEntity.DATA_flag_start, true);
                           }
                        } else if (entity instanceof BlueEntity && entity instanceof BlueEntity) {
                           BlueEntity _datEntSetL = (BlueEntity)entity;
                           _datEntSetL.m_20088_().m_135381_(BlueEntity.DATA_flag_start, true);
                        }

                        entity.getPersistentData().m_128347_("x_power", entity_a.getPersistentData().m_128459_("x_power"));
                        entity.getPersistentData().m_128347_("y_power", entity_a.getPersistentData().m_128459_("y_power"));
                        entity.getPersistentData().m_128347_("z_power", entity_a.getPersistentData().m_128459_("z_power"));
                        break label104;
                     }

                     logic_a = true;
                     break label104;
                  }

                  if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                     logic_a = true;
                     entity.m_20256_(new Vec3(entity_a.m_20184_().m_7096_(), entity_a.m_20096_() ? (double)0.0F : entity_a.m_20184_().m_7098_(), entity_a.m_20184_().m_7094_()));
                     entity.m_146922_(entity_a.m_146908_());
                     entity.m_146926_(entity_a.m_146909_());
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     if ((entity_a.getPersistentData().m_128459_("cnt1") >= (double)18.0F || entity_a.getPersistentData().m_128459_("skill") == (double)0.0F) && !entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }
                  }
               }

               if (!logic_a && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         } else if (!entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
