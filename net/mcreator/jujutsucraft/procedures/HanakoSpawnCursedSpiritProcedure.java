package net.mcreator.jujutsucraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class HanakoSpawnCursedSpiritProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double amount = (double)0.0F;
         double strength = (double)0.0F;
         double kind = (double)0.0F;
         double grade = (double)0.0F;
         double x_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         boolean player = false;
         if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
            entity.getPersistentData().m_128347_("friend_num", Math.random());
         }

         double var10000;
         label184: {
            yaw = (double)entity.m_146908_();
            pitch = (double)entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label184;
               }
            }

            var10000 = (double)0.0F;
         }

         strength = var10000;
         player = entity instanceof Player || entity.getPersistentData().m_128471_("Player");
         grade = Math.random() < 0.2 ? (double)2.0F : (double)3.0F;
         if (grade == (double)3.0F) {
            int index0 = 0;

            while(index0 < 256) {
               kind = Math.ceil(Math.random() * (double)18.0F);
               if (kind != (double)1.0F && kind != (double)2.0F && kind != (double)3.0F && kind != (double)5.0F && kind != (double)16.0F) {
                  if (kind == (double)4.0F) {
                     amount = (double)4.0F;
                     break;
                  }

                  if (kind != (double)6.0F && kind != (double)14.0F && kind != (double)15.0F && kind != (double)17.0F) {
                     if (kind != (double)8.0F && kind != (double)10.0F && kind != (double)13.0F) {
                        if (kind != (double)11.0F && kind != (double)12.0F) {
                           if (kind != (double)9.0F && kind != (double)13.0F && kind != (double)18.0F) {
                              ++index0;
                              continue;
                           }

                           amount = (double)4.0F;
                           break;
                        }

                        amount = (double)1.0F;
                        break;
                     }

                     amount = (double)2.0F;
                     break;
                  }

                  amount = (double)4.0F;
                  break;
               }

               amount = (double)2.0F;
               break;
            }
         } else if (grade == (double)2.0F) {
            for(int index1 = 0; index1 < 256; ++index1) {
               kind = Math.ceil(Math.random() * (double)9.0F);
               if (kind == (double)1.0F || kind == (double)4.0F || kind == (double)5.0F || kind == (double)8.0F || kind == (double)9.0F) {
                  amount = (double)1.0F;
                  break;
               }
            }
         }

         for(int index2 = 0; index2 < (int)Math.round(amount); ++index2) {
            entity.m_146922_((float)(yaw + (Math.random() - (double)0.5F) * (double)360.0F));
            entity.m_146926_((float)Math.min(pitch, (double)0.0F));
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)1.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
            y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)0.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
            z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)1.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Commands var45 = _level.m_7654_().m_129892_();
               CommandSourceStack var10001 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
               long var10002 = Math.round(grade);
               var45.m_230957_(var10001, "summon jujutsucraft:cursed_spirit_grade_" + var10002 + Math.round(kind));
            }

            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)0.5F), (e) -> true)) {
               if (entityiterator instanceof LivingEntity && entityiterator.getPersistentData().m_128459_("friend_num") == (double)0.0F && entityiterator.getPersistentData().m_128471_("CursedSpirit")) {
                  entityiterator.getPersistentData().m_128359_("OWNER_UUID", entity.getPersistentData().m_128461_("OWNER_UUID"));
                  entityiterator.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                  entityiterator.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                  entityiterator.m_146922_((float)yaw);
                  entityiterator.m_146926_((float)pitch);
                  entityiterator.m_5618_(entityiterator.m_146908_());
                  entityiterator.m_5616_(entityiterator.m_146908_());
                  entityiterator.f_19859_ = entityiterator.m_146908_();
                  entityiterator.f_19860_ = entityiterator.m_146909_();
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 1, 9, false, false));
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity24 = (LivingEntity)entityiterator;
                     if (_livingEntity24.m_21204_().m_22171_(Attributes.f_22281_)) {
                        double var47;
                        label110: {
                           var46 = _livingEntity24.m_21051_(Attributes.f_22281_);
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livingEntity23 = (LivingEntity)entityiterator;
                              if (_livingEntity23.m_21204_().m_22171_(Attributes.f_22281_)) {
                                 var47 = _livingEntity23.m_21051_(Attributes.f_22281_).m_22115_();
                                 break label110;
                              }
                           }

                           var47 = (double)0.0F;
                        }

                        var46.m_22100_(var47 + strength * (double)3.0F * (double)0.5F);
                     }
                  }

                  entityiterator.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                  entityiterator.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                  entityiterator.getPersistentData().m_128379_("Player", player);
                  entityiterator.getPersistentData().m_128379_("Shikigami", true);
                  break;
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 25, (double)0.5F, (double)0.5F, (double)0.5F, (double)0.0F);
            }
         }

         entity.m_146922_((float)yaw);
         entity.m_146926_((float)pitch);
         entity.m_5618_(entity.m_146908_());
         entity.m_5616_(entity.m_146908_());
         entity.f_19859_ = entity.m_146908_();
         entity.f_19860_ = entity.m_146909_();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.f_20884_ = _entity.m_146908_();
            _entity.f_20886_ = _entity.m_146908_();
         }

      }
   }
}
