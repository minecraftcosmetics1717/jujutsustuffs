package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModBlocks;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ChimeraShadowGardenActiveProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos;
         double z_pos;
         double loop_num;
         double y_pos;
         boolean breakLoop;
         double range;
         double var10000;
         label260: {
            double distance = (double)0.0F;
            double ticks = (double)0.0F;
            double z_center = (double)0.0F;
            range = (double)0.0F;
            double rad1 = (double)0.0F;
            x_pos = (double)0.0F;
            z_pos = (double)0.0F;
            double y_center = (double)0.0F;
            double x_center = (double)0.0F;
            loop_num = (double)0.0F;
            y_pos = (double)0.0F;
            breakLoop = false;
            boolean logic_hit = false;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label260;
               }
            }

            var10000 = (double)0.0F;
         }

         double var39 = var10000;
         double var44 = entity.getPersistentData().m_128459_("x_pos_doma");
         double var43 = entity.getPersistentData().m_128459_("y_pos_doma");
         double var40 = entity.getPersistentData().m_128459_("z_pos_doma");
         if (entity.getPersistentData().m_128471_("Failed")) {
            if (entity.m_20096_() && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x, y, z, 20, (double)1.0F, (double)0.0F, (double)1.0F, 0.05);
            }
         } else {
            double var42 = Math.toRadians((double)90.0F * (var39 % (double)4.0F));
            double var38 = (double)4.0F * var39 % (range * (double)0.5F - (double)5.0F);

            for(int index0 = 0; index0 < 5; ++index0) {
               for(int index1 = 0; index1 < 72; ++index1) {
                  if (!(Math.random() < 0.7)) {
                     var42 += Math.toRadians((double)10.0F * Math.random());
                     x_pos = var44 + Math.cos(var42) * var38;
                     y_pos = var43 + (double)0.25F;
                     z_pos = var40 + Math.sin(var42) * var38;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 1, 0.2, (double)0.0F, 0.2, 0.05);
                     }
                  }
               }

               ++var38;
            }
         }

         if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
            entity.getPersistentData().m_128347_("friend_num", Math.random());
         }

         if (!entity.getPersistentData().m_128471_("Failed")) {
            boolean var45 = false;
            Vec3 _center = new Vec3(var44, var43, var40);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / (double)2.0F), (e) -> true)) {
               if (entity != entityiterator && LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 5, false, false));
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     _entity.m_21195_(MobEffects.f_19596_);
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     _entity.m_21195_(MobEffects.f_19603_);
                  }

                  if (world.m_8055_(BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_() - (double)0.0F, entityiterator.m_20189_())).m_60734_() == JujutsucraftModBlocks.BLOCK_UNIVERSE.get() || world.m_8055_(BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_() - (double)1.0F, entityiterator.m_20189_())).m_60734_() == JujutsucraftModBlocks.BLOCK_UNIVERSE.get() || world.m_8055_(BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_() - (double)2.0F, entityiterator.m_20189_())).m_60734_() == JujutsucraftModBlocks.BLOCK_UNIVERSE.get() || world.m_8055_(BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_() - (double)3.0F, entityiterator.m_20189_())).m_60734_() == JujutsucraftModBlocks.BLOCK_UNIVERSE.get()) {
                     entityiterator.m_20256_(new Vec3((double)0.0F, Math.min(entityiterator.m_20184_().m_7098_(), (double)0.0F), (double)0.0F));
                     if (!world.m_8055_(BlockPos.m_274561_(entityiterator.m_20185_(), entityiterator.m_20186_() - (double)0.5F, entityiterator.m_20189_())).m_60815_()) {
                        entityiterator.m_6021_(entityiterator.m_20185_(), entityiterator.m_20186_() - (double)0.5F, entityiterator.m_20189_());
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                           _serverPlayer.f_8906_.m_9774_(entityiterator.m_20185_(), entityiterator.m_20186_() - (double)0.5F, entityiterator.m_20189_(), entityiterator.m_146908_(), entityiterator.m_146909_());
                        }
                     }
                  }

                  if (!var45 || Math.random() < (double)0.5F) {
                     var45 = true;
                     var44 = entityiterator.m_20185_();
                     var43 = entityiterator.m_20186_();
                     var40 = entityiterator.m_20189_();
                  }
               }
            }

            if (var39 % (double)40.0F == (double)0.0F) {
               for(int index2 = 0; index2 < 2; ++index2) {
                  if (!var45) {
                     var44 = entity.getPersistentData().m_128459_("x_pos_doma") + (Math.random() - (double)0.5F) * range * (double)0.5F;
                     var43 = entity.getPersistentData().m_128459_("y_pos_doma") + Math.random() * 0.1;
                     var40 = entity.getPersistentData().m_128459_("z_pos_doma") + (Math.random() - (double)0.5F) * range * (double)0.5F;
                  }

                  for(int index3 = 0; index3 < 128; ++index3) {
                     x_pos = var44 + (Math.random() - (double)0.5F) * (double)8.0F;
                     y_pos = var43;
                     z_pos = var40 + (Math.random() - (double)0.5F) * (double)8.0F;
                     if (Math.sqrt(Math.pow(x_pos - entity.getPersistentData().m_128459_("x_pos_doma"), (double)2.0F) + Math.pow(var43 - entity.getPersistentData().m_128459_("y_pos_doma"), (double)2.0F) + Math.pow(z_pos - entity.getPersistentData().m_128459_("z_pos_doma"), (double)2.0F)) < range * (double)0.5F - (double)4.0F) {
                        break;
                     }
                  }

                  if (var39 % (double)160.0F == (double)0.0F) {
                     x_pos = var44;
                     z_pos = var40;

                     for(int index4 = 0; index4 < (int)(range / (double)2.0F); ++index4) {
                        ++y_pos;
                        if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + (double)1.0F, z_pos)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos + (double)0.0F, y_pos + (double)1.0F, z_pos + (double)1.0F)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos + (double)1.0F, y_pos + (double)1.0F, z_pos + (double)0.0F)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos + (double)0.0F, y_pos + (double)1.0F, z_pos + (double)-1.0F)).m_60815_() || world.m_8055_(BlockPos.m_274561_(x_pos + (double)-1.0F, y_pos + (double)1.0F, z_pos + (double)0.0F)).m_60815_()) {
                           break;
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.MAX_ELEPHANT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           ChimeraShadowGardenSetProcedure.execute(entity, entityinstance);
                           entityinstance.m_146922_((float)(Math.random() * (double)360.0F));
                           entityinstance.m_146926_(0.0F);
                           entityinstance.m_5618_(entityinstance.m_146908_());
                           entityinstance.m_5616_(entityinstance.m_146908_());
                           entityinstance.f_19859_ = entityinstance.m_146908_();
                           entityinstance.f_19860_ = entityinstance.m_146909_();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }

                           _serverLevel.m_7967_(entityinstance);
                        }
                     }

                     breakLoop = true;
                  } else if (var39 % (double)120.0F == (double)0.0F) {
                     for(int index5 = 0; index5 < 128 && !(Math.sqrt(Math.pow(x_pos - entity.getPersistentData().m_128459_("x_pos_doma"), (double)2.0F) + Math.pow(y_pos - entity.getPersistentData().m_128459_("y_pos_doma"), (double)2.0F) + Math.pow(z_pos - entity.getPersistentData().m_128459_("z_pos_doma"), (double)2.0F)) < range * (double)0.5F - (double)4.0F); ++index5) {
                        x_pos = var44 + (Math.random() - (double)0.5F) * (double)8.0F;
                        y_pos = var43;
                        z_pos = var40 + (Math.random() - (double)0.5F) * (double)8.0F;
                     }

                     if (loop_num == (double)0.0F) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.DIVINE_DOG_BLACK.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                              ChimeraShadowGardenSetProcedure.execute(entity, entityinstance);
                              entityinstance.m_146922_((float)(Math.random() * (double)360.0F));
                              entityinstance.m_146926_(0.0F);
                              entityinstance.m_5618_(entityinstance.m_146908_());
                              entityinstance.m_5616_(entityinstance.m_146908_());
                              entityinstance.f_19859_ = entityinstance.m_146908_();
                              entityinstance.f_19860_ = entityinstance.m_146909_();
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 _entity.f_20884_ = _entity.m_146908_();
                                 _entity.f_20886_ = _entity.m_146908_();
                              }

                              _serverLevel.m_7967_(entityinstance);
                           }
                        }
                     } else if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.DIVINE_DOG_WHITE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           ChimeraShadowGardenSetProcedure.execute(entity, entityinstance);
                           entityinstance.m_146922_((float)(Math.random() * (double)360.0F));
                           entityinstance.m_146926_(0.0F);
                           entityinstance.m_5618_(entityinstance.m_146908_());
                           entityinstance.m_5616_(entityinstance.m_146908_());
                           entityinstance.f_19859_ = entityinstance.m_146908_();
                           entityinstance.f_19860_ = entityinstance.m_146909_();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }

                           _serverLevel.m_7967_(entityinstance);
                        }
                     }
                  } else if (var39 % (double)80.0F != (double)0.0F) {
                     if (var39 % (double)40.0F == (double)0.0F) {
                        x_pos = var44;
                        z_pos = var40;
                        breakLoop = true;
                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.TOAD_2.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(var44, y_pos, var40), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                              ChimeraShadowGardenSetProcedure.execute(entity, entityinstance);
                              entityinstance.m_146922_((float)(Math.random() * (double)360.0F));
                              entityinstance.m_146926_(0.0F);
                              entityinstance.m_5618_(entityinstance.m_146908_());
                              entityinstance.m_5616_(entityinstance.m_146908_());
                              entityinstance.f_19859_ = entityinstance.m_146908_();
                              entityinstance.f_19860_ = entityinstance.m_146909_();
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 _entity.f_20884_ = _entity.m_146908_();
                                 _entity.f_20886_ = _entity.m_146908_();
                              }

                              _serverLevel.m_7967_(entityinstance);
                           }
                        }
                     }
                  } else {
                     y_pos += (double)4.0F;

                     for(int index6 = 0; index6 < 128 && !(Math.sqrt(Math.pow(x_pos - entity.getPersistentData().m_128459_("x_pos_doma"), (double)2.0F) + Math.pow(y_pos - entity.getPersistentData().m_128459_("y_pos_doma"), (double)2.0F) + Math.pow(z_pos - entity.getPersistentData().m_128459_("z_pos_doma"), (double)2.0F)) < range * (double)0.5F - (double)4.0F); ++index6) {
                        x_pos = var44 + (Math.random() - (double)0.5F) * (double)8.0F;
                        y_pos = var43;
                        z_pos = var40 + (Math.random() - (double)0.5F) * (double)8.0F;
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.NUE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           ChimeraShadowGardenSetProcedure.execute(entity, entityinstance);
                           entityinstance.m_146922_((float)(Math.random() * (double)360.0F));
                           entityinstance.m_146926_(0.0F);
                           entityinstance.m_5618_(entityinstance.m_146908_());
                           entityinstance.m_5616_(entityinstance.m_146908_());
                           entityinstance.f_19859_ = entityinstance.m_146908_();
                           entityinstance.f_19860_ = entityinstance.m_146909_();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }

                           _serverLevel.m_7967_(entityinstance);
                        }
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 20, (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                  }

                  ++loop_num;
                  if (breakLoop) {
                     break;
                  }
               }
            }
         }

      }
   }
}
