package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class EffectCursedSpeech1Procedure {
   public static void execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         String message = "";
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double effect = (double)0.0F;
         x_pos = entityiterator.m_20185_();
         y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F;
         z_pos = entityiterator.m_20189_();
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

         entity.getPersistentData().m_128379_("attack", false);
         entityiterator.getPersistentData().m_128347_("Damage", (double)0.0F);
         entityiterator.getPersistentData().m_128347_("skill", (double)-1000.0F);
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 20, 0, false, false));
            }
         }

         entityiterator.getPersistentData().m_128347_("skill", (double)-1000.0F);
         if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
            entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "playsound jujutsucraft:tinnitus master @s");
         }

         if (entityiterator instanceof Player) {
            message = "NULL";
            effect = entity.getPersistentData().m_128459_("effect");
            if (effect == (double)305.0F) {
               message = Component.m_237115_("jujutsu.technique.explode").getString();
            } else if (effect == (double)306.0F) {
               message = Component.m_237115_("jujutsu.technique.get_crushed").getString();
            } else if (effect == (double)307.0F) {
               message = Component.m_237115_("jujutsu.technique.crumble_away").getString();
            } else if (effect == (double)308.0F) {
               message = Component.m_237115_("jujutsu.technique.dont_move").getString();
            } else if (effect == (double)309.0F) {
               message = Component.m_237115_("jujutsu.technique.blast_away").getString();
            }

            if (!message.equals("NULL") && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               Commands var10000 = entity.m_20194_().m_129892_();
               CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
               String var10002 = entityiterator.m_5446_().getString();
               var10000.m_230957_(var10001, "tell " + var10002 + " " + message);
            }
         }

      }
   }
}
