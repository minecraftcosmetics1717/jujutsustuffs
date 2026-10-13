package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class SelectChosoProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entity;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_blood_manipulation"));
            AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
            if (!_ap.m_8193_()) {
               for(String criteria : _ap.m_8219_()) {
                  _player.m_8960_().m_135988_(_adv, criteria);
               }
            }
         }

         double _setval = (double)10.0F;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerCurseTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         SelectedProcedure.execute(world, x, y, z, entity);
         SelectedArmorEquipProcedure.execute(entity, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_CHOSO_CHESTPLATE.get()), new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()), new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_CHOSO_HELMET.get()), new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()), ItemStack.f_41583_, ItemStack.f_41583_, ItemStack.f_41583_, ItemStack.f_41583_);
      }
   }
}
