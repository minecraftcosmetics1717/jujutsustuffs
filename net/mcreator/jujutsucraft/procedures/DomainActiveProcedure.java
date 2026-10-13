package net.mcreator.jujutsucraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class DomainActiveProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill_domain = (double)0.0F;
         skill_domain = entity.getPersistentData().m_128459_("skill_domain");
         if (skill_domain <= (double)10.0F) {
            if (skill_domain == (double)1.0F) {
               MalevolentShrineActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)2.0F) {
               UnlimitedVoidActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)4.0F) {
               CoffinoftheIronMountainActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)5.0F) {
               AuthenticMutualLoveActiveProcedure.execute(world, x, y, z, entity);
            } else if (skill_domain == (double)6.0F) {
               ChimeraShadowGardenActiveProcedure.execute(world, x, y, z, entity);
            } else if (skill_domain == (double)7.0F) {
               KashimoDomainActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)8.0F) {
               HorizonOfTheCaptivatingSkandhaActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)9.0F) {
               TsukumoDomainExpansionActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)10.0F) {
               ChosoDomainActiveProcedure.execute(world, entity);
            }
         } else if (skill_domain <= (double)20.0F) {
            if (skill_domain == (double)11.0F) {
               MeimeiDomainActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)12.0F) {
               IshigoriDomainExpansionActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)13.0F) {
               NanamiDomainExpansionActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)14.0F) {
               CeremonialSeaofLightActiveProcedure.execute(world, x, y, z, entity);
            } else if (skill_domain == (double)15.0F) {
               SelfEmbodimentOfPerfectionActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)18.0F) {
               WombProfusionActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)19.0F) {
               TimeCellMoonPalaceActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)20.0F) {
               DomainExpansionTodoActiveProcedure.execute(world, entity);
            }
         } else if (skill_domain <= (double)30.0F) {
            if (skill_domain == (double)21.0F) {
               ItadoriDomainActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)23.0F) {
               KurourushiDomainExpansionActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)24.0F) {
               UraumeDomainActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)25.0F) {
               GraveyardDomainActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)26.0F) {
               OgiDomainActiveProcedure.execute(world, x, y, z, entity);
            } else if (skill_domain == (double)27.0F) {
               DeadlySentencingActiveProcedure.execute(world, x, y, z, entity);
            } else if (skill_domain == (double)29.0F) {
               IdleDeathGambleActiveProcedure.execute(world, entity);
            }
         } else if (skill_domain <= (double)40.0F) {
            if (skill_domain == (double)35.0F) {
               JunpeiDomainExpansionActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)36.0F) {
               NishimiyaDomainExpansionActiveProcedure.execute(world, entity);
            } else if (skill_domain == (double)40.0F) {
               TakumaInoDomainExpansionActiveProcedure.execute(world, entity);
            }
         } else if (skill_domain <= (double)50.0F && skill_domain == (double)43.0F) {
            RozetsuDomainExpansionActiveProcedure.execute(world, entity);
         }

      }
   }
}
