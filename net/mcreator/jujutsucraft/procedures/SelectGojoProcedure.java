package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class SelectGojoProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_a = ItemStack.f_41583_;
         double rnd1 = (double)0.0F;
         if (entity instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entity;
            Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_gojo"));
            AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
            if (!_ap.m_8193_()) {
               for(String criteria : _ap.m_8219_()) {
                  _player.m_8960_().m_135988_(_adv, criteria);
               }
            }
         }

         double _setval = (double)2.0F;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerCurseTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         rnd1 = (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 3);
         if (rnd1 == (double)1.0F) {
            item_a = (new ItemStack((ItemLike)JujutsucraftModItems.SUNGLASSES_HELMET.get())).m_41777_();
         } else if (rnd1 == (double)2.0F) {
            item_a = (new ItemStack((ItemLike)JujutsucraftModItems.BLINDFOLD_BANDAGE_HELMET.get())).m_41777_();
         } else if (rnd1 == (double)3.0F) {
            item_a = (new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_HELMET.get())).m_41777_();
         }

         SelectedProcedure.execute(world, x, y, z, entity);
         SelectedArmorEquipProcedure.execute(entity, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_CHESTPLATE.get()), new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()), item_a, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_LEGGINGS.get()), ItemStack.f_41583_, ItemStack.f_41583_, ItemStack.f_41583_, ItemStack.f_41583_);
      }
   }
}
