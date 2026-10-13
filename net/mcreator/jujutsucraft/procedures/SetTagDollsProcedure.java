package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.Doll1Entity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class SetTagDollsProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double size = (double)0.0F;
         double skin = (double)0.0F;
         if (entity instanceof Doll1Entity) {
            size = (double)1.0F + Math.random() * Math.random();
            if (Math.random() < 0.975) {
               skin = Math.ceil(Math.random() * (double)14.0F);
            } else {
               skin = (double)20.0F + Math.floor(Math.random() * (double)4.0F);
            }

            if (entity instanceof Doll1Entity) {
               Doll1Entity animatable = (Doll1Entity)entity;
               animatable.setTexture("doll" + Math.round(skin));
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity2 = (LivingEntity)entity;
               if (_livingEntity2.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  _livingEntity2.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(size);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity4 = (LivingEntity)entity;
               if (_livingEntity4.m_21204_().m_22171_(Attributes.f_22279_)) {
                  AttributeInstance var10000;
                  double var10001;
                  label45: {
                     var10000 = _livingEntity4.m_21051_(Attributes.f_22279_);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity3 = (LivingEntity)entity;
                        if (_livingEntity3.m_21204_().m_22171_(Attributes.f_22279_)) {
                           var10001 = _livingEntity3.m_21051_(Attributes.f_22279_).m_22115_();
                           break label45;
                        }
                     }

                     var10001 = (double)0.0F;
                  }

                  var10000.m_22100_(var10001 / (size - Math.max(size - (double)1.0F, (double)0.0F) * (double)0.5F));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity5 = (LivingEntity)entity;
               if (_livingEntity5.m_21204_().m_22171_(Attributes.f_22282_)) {
                  _livingEntity5.m_21051_(Attributes.f_22282_).m_22100_(size / (double)2.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity6 = (LivingEntity)entity;
               if (_livingEntity6.m_21204_().m_22171_(Attributes.f_22278_)) {
                  _livingEntity6.m_21051_(Attributes.f_22278_).m_22100_(size * (double)1.25F - (double)1.0F);
               }
            }
         }

         SetTagProcedure.execute(world, entity);
      }
   }
}
