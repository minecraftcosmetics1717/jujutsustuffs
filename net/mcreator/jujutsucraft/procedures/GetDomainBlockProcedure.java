package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class GetDomainBlockProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         double domain_num;
         double var10000;
         label173: {
            boolean noBarrier = false;
            String outside = "";
            String inside = "";
            String floor = "";
            domain_num = (double)0.0F;
            double close_type = (double)0.0F;
            domain_num = entity.getPersistentData().m_128459_("select") > (double)0.0F ? entity.getPersistentData().m_128459_("select") : entity.getPersistentData().m_128459_("skill_domain");
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)entity;
               if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                        break label173;
                     }
                  }

                  var10000 = (double)0.0F;
                  break label173;
               }
            }

            var10000 = entity.getPersistentData().m_128459_("cnt2");
         }

         double var15 = var10000;
         String var11 = "jujutsucraft:jujutsu_barrier";
         String var12 = "jujutsucraft:block_universe";
         String var13 = "jujutsucraft:block_universe";
         if (domain_num <= (double)10.0F) {
            if (domain_num == (double)1.0F) {
               var12 = "jujutsucraft:domain_bone";
               var13 = "jujutsucraft:block_red";
            } else if (domain_num == (double)2.0F) {
               var12 = "jujutsucraft:block_universe";
               var13 = "jujutsucraft:block_universe";
            } else if (domain_num == (double)3.0F) {
               var12 = "jujutsucraft:domain_blue_sky";
            } else if (domain_num == (double)4.0F) {
               var12 = "jujutsucraft:coffinofthe_ironmountain_1";
               var13 = "jujutsucraft:coffinofthe_ironmountain_2";
            } else if (domain_num == (double)5.0F) {
               var13 = "jujutsucraft:block_gravel";
            } else if (domain_num == (double)6.0F) {
               var12 = "jujutsucraft:block_universe";
               var13 = "jujutsucraft:block_universe";
            } else if (domain_num == (double)7.0F) {
               var12 = "jujutsucraft:domain_cloud";
               var13 = "jujutsucraft:domain_cloud";
            } else if (domain_num == (double)8.0F) {
               var12 = "jujutsucraft:domain_blue_sky";
               var13 = "jujutsucraft:domain_sand";
            } else if (domain_num == (double)9.0F) {
               var13 = "jujutsucraft:domain_sand";
            } else if (domain_num == (double)10.0F) {
               var12 = "jujutsucraft:domain_blood";
               var13 = "jujutsucraft:domain_blood";
            }
         } else if (domain_num <= (double)20.0F) {
            if (domain_num == (double)11.0F) {
               var12 = "jujutsucraft:domain_cloud";
               var13 = "jujutsucraft:domain_podzol";
            } else if (domain_num == (double)12.0F) {
               var12 = "jujutsucraft:block_universe";
               var13 = "jujutsucraft:domain_sand_black";
            } else if (domain_num == (double)13.0F) {
               var13 = "jujutsucraft:domain_stone_bricks";
            } else if (domain_num == (double)14.0F) {
               var12 = "jujutsucraft:domain_blue_sky";
               var13 = "jujutsucraft:domain_flower";
            } else if (domain_num == (double)15.0F) {
               var12 = "jujutsucraft:domain_bone";
            } else if (domain_num == (double)16.0F) {
               var12 = "jujutsucraft:block_universe";
            } else if (domain_num == (double)18.0F) {
               var12 = "jujutsucraft:domain_blood";
               var13 = "jujutsucraft:block_red";
            } else if (domain_num == (double)20.0F) {
               var12 = "jujutsucraft:domain_flower";
               var13 = "jujutsucraft:domain_blue_sky";
            }
         } else if (domain_num <= (double)30.0F) {
            if (domain_num == (double)21.0F) {
               var12 = "jujutsucraft:domain_cloud";
               var13 = "jujutsucraft:domain_podzol";
            } else if (domain_num == (double)22.0F) {
               var13 = "jujutsucraft:block_universe";
            } else if (domain_num == (double)23.0F) {
               var12 = "jujutsucraft:domain_bone";
               var13 = "jujutsucraft:block_red";
            } else if (domain_num == (double)24.0F) {
               var12 = "jujutsucraft:domain_ice";
               var13 = "jujutsucraft:domain_ice";
            } else if (domain_num == (double)25.0F) {
               var13 = "jujutsucraft:block_gravel";
            } else if (domain_num == (double)26.0F) {
               var13 = "jujutsucraft:block_gravel";
            } else if (domain_num == (double)27.0F) {
               var13 = "jujutsucraft:domain_planks";
            } else if (domain_num == (double)28.0F) {
               var12 = "jujutsucraft:domain_blue_sky";
               var13 = "jujutsucraft:domain_cloud";
            } else if (domain_num == (double)29.0F) {
               var12 = "jujutsucraft:domain_white";
               var13 = "jujutsucraft:domain_white";
            }
         } else if (domain_num <= (double)40.0F) {
            if (domain_num == (double)32.0F) {
               var12 = "jujutsucraft:domain_sand";
               var13 = "jujutsucraft:domain_sand";
            } else if (domain_num == (double)33.0F) {
               var12 = "jujutsucraft:block_red";
               var13 = "jujutsucraft:domain_planks";
            } else if (domain_num == (double)34.0F) {
               var13 = "jujutsucraft:domain_podzol";
            } else if (domain_num == (double)35.0F) {
               var12 = "jujutsucraft:domain_blood";
               var13 = "jujutsucraft:domain_sand";
            } else if (domain_num == (double)36.0F) {
               var13 = "jujutsucraft:domain_cloud";
            } else if (domain_num == (double)37.0F) {
               var13 = "jujutsucraft:block_red";
            } else if (domain_num == (double)38.0F) {
               var12 = "jujutsucraft:block_universe";
               var13 = "jujutsucraft:block_universe";
            } else if (domain_num == (double)39.0F) {
               var12 = "jujutsucraft:domain_white";
               var13 = "jujutsucraft:domain_white";
            } else if (domain_num == (double)40.0F) {
               var13 = "jujutsucraft:domain_dark_stone";
            }
         } else if (domain_num <= (double)50.0F) {
            if (domain_num == (double)43.0F) {
               var13 = "jujutsucraft:domain_dark_stone";
               var12 = "jujutsucraft:domain_dark_stone";
            } else if (domain_num == (double)44.0F) {
               var13 = "jujutsucraft:domain_white";
               var12 = "jujutsucraft:domain_white";
            } else if (domain_num == (double)45.0F) {
               var13 = "jujutsucraft:block_red";
               var12 = "jujutsucraft:domain_blood";
            } else if (domain_num == (double)46.0F) {
               var12 = "jujutsucraft:domain_blood";
               var13 = "jujutsucraft:domain_blood";
            } else if (domain_num == (double)47.0F) {
               var12 = "jujutsucraft:domain_cloud";
               var13 = "jujutsucraft:coffinofthe_ironmountain_1";
            }
         }

         if (var15 > (double)0.0F) {
            if (!entity.getPersistentData().m_128471_("Failed")) {
               var11 = "minecraft:air";
               var12 = "minecraft:air";
               var13 = "minecraft:air";
            } else {
               var11 = "";
               var12 = "";
            }
         } else if (var15 < (double)0.0F && !entity.getPersistentData().m_128471_("Failed") && !entity.getPersistentData().m_128471_("Cover")) {
            var11 = "";
            var12 = "";
         }

         entity.getPersistentData().m_128359_("domain_outside", var11);
         entity.getPersistentData().m_128359_("domain_inside", var12);
         entity.getPersistentData().m_128359_("domain_floor", var13);
      }
   }
}
