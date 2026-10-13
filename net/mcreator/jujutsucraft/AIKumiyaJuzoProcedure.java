package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.entity.AwasakaJiroEntity;
import net.mcreator.jujutsucraft.entity.KumiyaJuzoEntity;
import net.mcreator.jujutsucraft.entity.NegiToshihisaEntity;
import net.mcreator.jujutsucraft.entity.SudaManamiEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class AIKumiyaJuzoProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double level_st = (double)0.0F;
         double level_df = (double)0.0F;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (!(entity instanceof KumiyaJuzoEntity) && !(entity instanceof AwasakaJiroEntity)) {
               if (entity instanceof SudaManamiEntity) {
                  level_st = (double)5.0F;
                  level_df = (double)1.0F;
               } else if (entity instanceof NegiToshihisaEntity) {
                  level_st = (double)4.0F;
                  level_df = (double)1.0F;
               } else {
                  level_st = (double)2.0F;
                  level_df = (double)1.0F;
               }
            } else {
               level_st = (double)8.0F;
               level_df = (double)2.0F;
            }

            label82: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.m_21023_(MobEffects.f_19600_)) {
                     break label82;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, (int)level_st, false, false));
                  }
               }
            }

            label77: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.m_21023_(MobEffects.f_19606_)) {
                     break label77;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, (int)level_df, false, false));
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  ResetCounterProcedure.execute(entity);
                  CalculateAttackProcedure.execute(world, entity);
                  if (entity instanceof AwasakaJiroEntity) {
                     ItemStack var27;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var27 = _livEnt.m_21205_();
                     } else {
                        var27 = ItemStack.f_41583_;
                     }

                     if (var27.m_41720_() == ItemStack.f_41583_.m_41720_() && !entity.getPersistentData().m_128471_("flag1")) {
                        float var28;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var28 = _livEnt.m_21223_();
                        } else {
                           var28 = -1.0F;
                        }

                        double var29 = (double)var28;
                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21233_();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (var29 < (double)var10001 * (double)0.75F) {
                           entity.getPersistentData().m_128379_("flag1", true);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.KNIFE.get())).m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

      }
   }
}
