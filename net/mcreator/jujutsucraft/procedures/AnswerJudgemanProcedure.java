package net.mcreator.jujutsucraft.procedures;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.mcreator.jujutsucraft.entity.HigurumaHiromiEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AnswerJudgemanProcedure {
   public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
      if (entity != null) {
         double x_dis = (double)0.0F;
         double distance = (double)0.0F;
         double range = (double)0.0F;
         double z_dis = (double)0.0F;
         double y_dis = (double)0.0F;
         boolean answered = false;
         Entity to_entity = null;
         String str_answer = "";
         to_entity = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("JUDGE_ENTITY"));
         if (to_entity instanceof LivingEntity) {
            entity.getPersistentData().m_128359_("JUDGE_ENTITY", "");
            entity.getPersistentData().m_128473_("JUDGE_ENTITY");
            if (!(to_entity instanceof LivingEntity)) {
               return;
            }

            LivingEntity _livEnt5 = (LivingEntity)to_entity;
            if (!_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
               return;
            }

            if (to_entity.getPersistentData().m_128471_("Failed")) {
               return;
            }

            if (to_entity.getPersistentData().m_128459_("skill") == (double)2719.0F) {
               return;
            }

            answered = true;
            if (StringArgumentType.getString(arguments, "answer").equals("plea_silent")) {
               str_answer = Component.m_237115_("jujutsu.message.higuruma_answer1").getString();
            } else if (StringArgumentType.getString(arguments, "answer").equals("plea_confess")) {
               str_answer = Component.m_237115_("jujutsu.message.higuruma_answer2").getString();
               ResetCounterProcedure.execute(to_entity);
               if (to_entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)to_entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                  }
               }

               to_entity.getPersistentData().m_128347_("skill", (double)2719.0F);
               to_entity.getPersistentData().m_128347_("cnt3", (double)20.0F);
               if (to_entity.getPersistentData().m_128459_("x_power") <= (double)100.0F) {
                  to_entity.getPersistentData().m_128347_("x_power", (double)100.0F);
               } else {
                  to_entity.getPersistentData().m_128347_("x_power", Math.max(to_entity.getPersistentData().m_128459_("x_power") - (double)15.0F, (double)15.0F));
               }
            } else if (StringArgumentType.getString(arguments, "answer").equals("plea_deny")) {
               str_answer = Component.m_237115_("jujutsu.message.higuruma_answer3").getString();
               if (to_entity.getPersistentData().m_128459_("x_power") <= (double)100.0F) {
                  if (Math.random() < 0.2) {
                     to_entity.getPersistentData().m_128347_("x_power", (double)0.0F);
                  } else {
                     to_entity.getPersistentData().m_128347_("x_power", (double)100.0F);
                  }
               } else if (Math.random() < 0.1) {
                  to_entity.getPersistentData().m_128347_("x_power", (double)0.0F);
               } else {
                  to_entity.getPersistentData().m_128347_("x_power", to_entity.getPersistentData().m_128459_("x_power") + (double)30.0F);
               }
            } else {
               answered = false;
            }

            if (answered) {
               if (to_entity instanceof HigurumaHiromiEntity) {
                  to_entity.getPersistentData().m_128347_("cnt_x3", (double)140.0F);
               }

               range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F;
               Vec3 _center = new Vec3(to_entity.getPersistentData().m_128459_("x_pos_doma"), to_entity.getPersistentData().m_128459_("y_pos_doma"), to_entity.getPersistentData().m_128459_("z_pos_doma"));

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / (double)2.0F), (e) -> true)) {
                  if (entityiterator instanceof Player) {
                     x_dis = to_entity.getPersistentData().m_128459_("x_pos_doma") - entityiterator.m_20185_();
                     y_dis = to_entity.getPersistentData().m_128459_("y_pos_doma") - (entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F);
                     z_dis = to_entity.getPersistentData().m_128459_("z_pos_doma") - entityiterator.m_20189_();
                     distance = x_dis * x_dis + y_dis * y_dis + z_dis * z_dis;
                     if (distance < range * (double)0.5F * range * (double)0.5F && entityiterator instanceof Player) {
                        Player _player = (Player)entityiterator;
                        if (!_player.m_9236_().m_5776_()) {
                           String var10001 = entity.m_5446_().getString();
                           _player.m_5661_(Component.m_237113_(var10001 + " -> §l\"" + str_answer + "\""), false);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
