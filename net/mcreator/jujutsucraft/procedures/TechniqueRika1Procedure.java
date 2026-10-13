package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaCullingGameEntity;
import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;

public class TechniqueRika1Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean pitch = false;
         boolean summon = false;
         boolean noControl = false;
         Entity entity_rika = null;
         double dis = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double picth = (double)0.0F;
         double yaw2 = (double)0.0F;
         double pitch2 = (double)0.0F;
         double HP = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double range = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         boolean var10000;
         if (entity instanceof Player) {
            label400: {
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr3 = (ServerPlayer)entity;
                  if (_plr3.m_9236_() instanceof ServerLevel && _plr3.m_8960_().m_135996_(_plr3.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_rika_control"))).m_8193_()) {
                     var10000 = 0;
                     break label400;
                  }
               }

               var10000 = 1;
            }
         } else {
            label395: {
               if (!(entity instanceof Player)) {
                  label392: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label392;
                        }
                     }

                     var10000 = 0;
                  }

                  if (var10000 < 10) {
                     var10000 = 1;
                     break label395;
                  }
               }

               var10000 = 0;
            }
         }

         noControl = (boolean)var10000;
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            label383: {
               if (entity instanceof Player) {
                  if (!(entity instanceof ServerPlayer)) {
                     break label383;
                  }

                  ServerPlayer _plr8 = (ServerPlayer)entity;
                  if (!(_plr8.m_9236_() instanceof ServerLevel) || !_plr8.m_8960_().m_135996_(_plr8.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_curseis_lifted"))).m_8193_()) {
                     break label383;
                  }
               } else if (!(entity instanceof OkkotsuYutaCullingGameEntity)) {
                  break label383;
               }

               entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
            }

            if (LocateRikaProcedure.execute(world, entity)) {
               entity.getPersistentData().m_128347_("cnt4", (double)1.0F);
            } else {
               entity.getPersistentData().m_128347_("cnt4", (double)0.0F);
               entity.getPersistentData().m_128347_("cnt2", (double)1.0F);
               LivingEntity var94;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var94 = _mobEnt.m_5448_();
               } else {
                  var94 = null;
               }

               if (var94 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var94 = _mobEnt.m_5448_();
                  } else {
                     var94 = null;
                  }

                  label366: {
                     LivingEntity var37 = var94;
                     if (var37 instanceof LivingEntity) {
                        LivingEntity _livEnt = var37;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var96 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label366;
                        }
                     }

                     var96 = 0;
                  }

                  int var10001;
                  label361: {
                     var97 = (double)var96;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label361;
                        }
                     }

                     var10001 = 0;
                  }

                  if (var97 <= (double)var10001 * (double)0.5F) {
                     entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
                  }
               }

               if (noControl || entity.m_6144_()) {
                  entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
               }
            }

            LivingEntity var98;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var98 = _mobEnt.m_5448_();
            } else {
               var98 = null;
            }

            if (var98 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var98 = _mobEnt.m_5448_();
               } else {
                  var98 = null;
               }

               Level var100 = ((Entity)var98).m_9236_();
               ClipContext var107 = new ClipContext;
               LivingEntity var10003;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10003 = _mobEnt.m_5448_();
               } else {
                  var10003 = null;
               }

               Vec3 var112 = ((Entity)var10003).m_20299_(1.0F);
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               Vec3 var119 = ((Entity)var10004).m_20299_(1.0F);
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               var119 = var119.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_((double)-5.0F));
               ClipContext.Block var127 = Block.OUTLINE;
               ClipContext.Fluid var10006 = Fluid.NONE;
               LivingEntity var10007;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var107.<init>(var112, var119, var127, var10006, var10007);
               x_pos = (double)var100.m_45547_(var107).m_82425_().m_123341_();
               LivingEntity var101;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var101 = _mobEnt.m_5448_();
               } else {
                  var101 = null;
               }

               Level var102 = ((Entity)var101).m_9236_();
               var107 = new ClipContext;
               LivingEntity var113;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var113 = _mobEnt.m_5448_();
               } else {
                  var113 = null;
               }

               Vec3 var114 = ((Entity)var113).m_20299_(1.0F);
               LivingEntity var121;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var121 = _mobEnt.m_5448_();
               } else {
                  var121 = null;
               }

               Vec3 var122 = ((Entity)var121).m_20299_(1.0F);
               LivingEntity var128;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var128 = _mobEnt.m_5448_();
               } else {
                  var128 = null;
               }

               var122 = var122.m_82549_(((Entity)var128).m_20252_(1.0F).m_82490_((double)-5.0F));
               ClipContext.Block var129 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var107.<init>(var114, var122, var129, var10006, var10007);
               y_pos = (double)var102.m_45547_(var107).m_82425_().m_123342_();
               LivingEntity var103;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var103 = _mobEnt.m_5448_();
               } else {
                  var103 = null;
               }

               Level var104 = ((Entity)var103).m_9236_();
               var107 = new ClipContext;
               LivingEntity var115;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var115 = _mobEnt.m_5448_();
               } else {
                  var115 = null;
               }

               Vec3 var116 = ((Entity)var115).m_20299_(1.0F);
               LivingEntity var124;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var124 = _mobEnt.m_5448_();
               } else {
                  var124 = null;
               }

               Vec3 var125 = ((Entity)var124).m_20299_(1.0F);
               LivingEntity var130;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var130 = _mobEnt.m_5448_();
               } else {
                  var130 = null;
               }

               var125 = var125.m_82549_(((Entity)var130).m_20252_(1.0F).m_82490_((double)-5.0F));
               ClipContext.Block var131 = Block.OUTLINE;
               var10006 = Fluid.NONE;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var107.<init>(var116, var125, var131, var10006, var10007);
               z_pos = (double)var104.m_45547_(var107).m_82425_().m_123343_();
               LivingEntity var105;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var105 = _mobEnt.m_5448_();
               } else {
                  var105 = null;
               }

               yaw = (double)((Entity)var105).m_146908_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var105 = _mobEnt.m_5448_();
               } else {
                  var105 = null;
               }

               picth = (double)((Entity)var105).m_146909_();
            } else {
               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)32.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
               yaw = (double)(entity.m_146908_() + 180.0F);
               picth = (double)(entity.m_146909_() * -1.0F);
            }

            entity.getPersistentData().m_128347_("x_pos", x_pos);
            entity.getPersistentData().m_128347_("y_pos", y_pos);
            entity.getPersistentData().m_128347_("z_pos", z_pos);
            entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
            entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
         }

         summon = entity.getPersistentData().m_128459_("cnt2") == (double)1.0F;
         if (entity.getPersistentData().m_128459_("cnt4") == (double)1.0F) {
            if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
               entity_rika = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("RIKA_UUID"));
               if ((entity_rika instanceof RikaEntity || entity_rika instanceof Rika2Entity) && entity.getPersistentData().m_128459_("friend_num") == entity_rika.getPersistentData().m_128459_("friend_num")) {
                  label411: {
                     if (entity instanceof Player) {
                        if (!entity.m_6144_()) {
                           break label411;
                        }
                     } else if (!(Math.random() < (double)0.5F)) {
                        break label411;
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123765_, entity_rika.m_20185_(), entity_rika.m_20186_(), entity_rika.m_20189_(), 50, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.0F);
                     }

                     entity_rika.m_146922_((float)yaw);
                     entity_rika.m_146926_((float)picth);
                     entity_rika.m_5618_(entity_rika.m_146908_());
                     entity_rika.m_5616_(entity_rika.m_146908_());
                     entity_rika.f_19859_ = entity_rika.m_146908_();
                     entity_rika.f_19860_ = entity_rika.m_146909_();
                     if (entity_rika instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity_rika;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     entity_rika.m_6021_(x_pos, y_pos, z_pos);
                     if (entity_rika instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity_rika;
                        _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity_rika.m_146908_(), entity_rika.m_146909_());
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 50, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.25F);
                     }
                  }

                  entity_rika.getPersistentData().m_128379_("flag_attack", true);
               }
            }

            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         } else {
            if (summon) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.technique.rika1").getString()), true);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
                  entity.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_());
                  entity.getPersistentData().m_128347_("y_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() + Math.random() * 0.1);
                  entity.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)-6.0F)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());
                  entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
                  entity.getPersistentData().m_128347_("pitch", (double)0.0F);
                  if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity79 = (LivingEntity)entity;
                        if (_livingEntity79.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity79.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity80 = (LivingEntity)entity;
                        if (_livingEntity80.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity80.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)4.0F);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }
               }
            } else {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(noControl ? Component.m_237115_("jujutsu.technique.rika4").getString() : Component.m_237115_("jujutsu.technique.rika3").getString()), true);
                  }
               }

               entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), (double)5.0F));
            }

            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
            yaw = entity.getPersistentData().m_128459_("yaw");
            picth = entity.getPersistentData().m_128459_("pitch");
            if (entity.getPersistentData().m_128459_("cnt1") < (double)5.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 25, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.25F);
               }
            } else if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F) {
               if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("friend_num", Math.random());
               }

               if (entity.getPersistentData().m_128459_("cnt3") > (double)0.0F) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.RIKA_2.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        entityinstance.m_146922_((float)yaw);
                        entityinstance.m_146926_((float)picth);
                        entityinstance.m_5618_(entityinstance.m_146908_());
                        entityinstance.m_5616_(entityinstance.m_146908_());
                        entityinstance.f_19859_ = entityinstance.m_146908_();
                        entityinstance.f_19860_ = entityinstance.m_146909_();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        entity.getPersistentData().m_128359_("RIKA_UUID", entityinstance.m_20149_());
                        entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                        entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                        entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (!_entity.m_9236_().m_5776_()) {
                              MobEffectInstance var111;
                              MobEffect var118;
                              int var133;
                              label307: {
                                 var111 = new MobEffectInstance;
                                 var118 = MobEffects.f_19600_;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var133 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label307;
                                    }
                                 }

                                 var133 = 0;
                              }

                              var111.<init>(var118, Integer.MAX_VALUE, Math.max(var133, entityinstance instanceof RikaEntity ? 20 : 16), false, false);
                              _entity.m_7292_(var111);
                           }
                        }

                        entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                        entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                        entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player);
                        if (!summon) {
                           entityinstance.getPersistentData().m_128347_("skill", (double)11.0F);
                           dis = noControl ? (double)3.0F : (double)2.0F;
                           entityinstance.getPersistentData().m_128347_("despawn_flag", dis);
                        }

                        _serverLevel.m_7967_(entityinstance);
                     }
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.RIKA.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     entityinstance.m_146922_((float)yaw);
                     entityinstance.m_146926_((float)picth);
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     entity.getPersistentData().m_128359_("RIKA_UUID", entityinstance.m_20149_());
                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var110;
                           MobEffect var117;
                           int var132;
                           label316: {
                              var110 = new MobEffectInstance;
                              var117 = MobEffects.f_19600_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var132 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label316;
                                 }
                              }

                              var132 = 0;
                           }

                           var110.<init>(var117, Integer.MAX_VALUE, Math.max(var132, entityinstance instanceof RikaEntity ? 20 : 16), false, false);
                           _entity.m_7292_(var110);
                        }
                     }

                     entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                     entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                     entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player);
                     if (!summon) {
                        entityinstance.getPersistentData().m_128347_("skill", (double)11.0F);
                        dis = noControl ? (double)3.0F : (double)2.0F;
                        entityinstance.getPersistentData().m_128347_("despawn_flag", dis);
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 25, (double)1.0F, (double)1.0F, (double)1.0F, (double)0.75F);
               }
            } else if (entity.getPersistentData().m_128459_("cnt1") < (double)20.0F) {
               if (summon) {
                  x_pos = entity.getPersistentData().m_128459_("x_pos");
                  y_pos = entity.getPersistentData().m_128459_("y_pos");
                  z_pos = entity.getPersistentData().m_128459_("z_pos");

                  for(int index0 = 0; index0 < 36; ++index0) {
                     ParticleGeneratorCircleProcedure.execute(world, (double)1.0F, (double)90.0F, (double)0.0F, (double)1.0F, Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)2.0F), x_pos, x_pos, y_pos, y_pos + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)0.25F), (double)0.0F, z_pos, z_pos, "minecraft:squid_ink");
                  }
               } else {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            } else {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
