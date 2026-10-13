package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueHigurumaProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = (double)0.0F;
         double skill = (double)0.0F;
         boolean have_gavel = false;
         ItemStack item_mainHand = ItemStack.f_41583_;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - (double)2700.0F);
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         item_mainHand = var10000.m_41777_();
         have_gavel = item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL.get() || item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL_LONG.get() || item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL_BIG.get();
         if (skill == (double)5.0F) {
            GetGavelProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         } else if (skill != (double)6.0F && skill != (double)7.0F) {
            if (skill != (double)8.0F && skill != (double)9.0F) {
               if (skill != (double)10.0F && skill != (double)11.0F) {
                  if (skill == (double)19.0F) {
                     SkillJudgementProcedure.execute(world, x, y, z, entity);
                  } else if (skill == (double)20.0F) {
                     DeadlySentencingProcedure.execute(world, x, y, z, entity);
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                  }
               } else {
                  if (!have_gavel) {
                     GetGavelProcedure.execute(world, x, y, z, entity);
                  }

                  for(int index2 = 0; index2 < 5; ++index2) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     item_mainHand = var10000.m_41777_();
                     if (item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL_BIG.get()) {
                        break;
                     }

                     GavelRightClicked2Procedure.execute(world, x, y, z, entity);
                  }

                  if (item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL_BIG.get()) {
                     if (skill == (double)10.0F) {
                        AttackStrongMahitoProcedure.execute(world, x, y, z, entity);
                     } else {
                        AttackOverheadHigurumaProcedure.execute(world, x, y, z, entity);
                     }
                  } else {
                     entity.getPersistentData().m_128347_("skill", (double)0.0F);
                  }
               }
            } else {
               if (!have_gavel) {
                  GetGavelProcedure.execute(world, x, y, z, entity);
               }

               for(int index1 = 0; index1 < 5; ++index1) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  item_mainHand = var10000.m_41777_();
                  if (item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL_LONG.get()) {
                     break;
                  }

                  GavelRightClicked2Procedure.execute(world, x, y, z, entity);
               }

               if (item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL_LONG.get()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41784_().m_128347_("Reach", (double)0.75F + entity.getPersistentData().m_128459_("cnt1") * 0.2);
                  if (skill == (double)8.0F) {
                     AttackContinueHigurumaProcedure.execute(world, entity);
                  } else {
                     AttackContinueHigurumaProcedure.execute(world, entity);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  SetAttributeMainhandProcedure.execute(var10000);
               } else {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            }
         } else if (skill == (double)6.0F) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)0.0F) {
               if (!have_gavel) {
                  GetGavelProcedure.execute(world, x, y, z, entity);
               }

               for(int index0 = 0; index0 < 5; ++index0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  item_mainHand = var10000.m_41777_();
                  if (item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL.get()) {
                     break;
                  }

                  GavelRightClicked2Procedure.execute(world, x, y, z, entity);
               }
            }

            GavelThrowingProcedure.execute(world, entity);
         }

      }
   }
}
