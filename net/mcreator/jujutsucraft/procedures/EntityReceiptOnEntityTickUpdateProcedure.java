package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.BulletKitchenKnifeEntity;
import net.mcreator.jujutsucraft.entity.EntityReceiptEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityReceiptOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double damage = (double)0.0F;
         double HP = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double speed = (double)0.0F;
         Entity owner_entity = null;
         if (LogicOwnerExistProcedure.execute(world, entity)) {
            owner_entity = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
         }

         if (!(owner_entity instanceof LivingEntity)) {
            owner_entity = entity;
         }

         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         x_power = entity.m_20154_().f_82479_;
         y_power = entity.m_20154_().f_82480_;
         z_power = entity.m_20154_().f_82481_;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") < (double)10.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                  }
               }
            }

            if ((entity.getPersistentData().m_128459_("cnt1") == (double)1.0F || Math.random() < 0.2) && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, (double)0.0F);
            }
         } else {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123755_, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, (double)0.0F);
            }

            int var10000;
            if (entity instanceof EntityReceiptEntity) {
               EntityReceiptEntity _datEntI = (EntityReceiptEntity)entity;
               var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityReceiptEntity.DATA_mode);
            } else {
               var10000 = 0;
            }

            if (var10000 != 0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, 5, 0.1, 0.1, 0.1, (double)0.5F);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.pickup")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.pickup")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (entity instanceof EntityReceiptEntity) {
                  EntityReceiptEntity _datEntI = (EntityReceiptEntity)entity;
                  var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityReceiptEntity.DATA_mode);
               } else {
                  var10000 = 0;
               }

               if (var10000 == 1) {
                  entity.getPersistentData().m_128347_("Damage", 2.4);
                  DamageFixProcedure.execute(entity);
                  damage = entity.getPersistentData().m_128459_("Damage");
                  if (world instanceof ServerLevel) {
                     ServerLevel projectileLevel = (ServerLevel)world;
                     Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                           AbstractArrow entityToSpawn = new BulletKitchenKnifeEntity((EntityType)JujutsucraftModEntities.BULLET_KITCHEN_KNIFE.get(), level);
                           entityToSpawn.m_5602_(shooter);
                           entityToSpawn.m_36781_((double)damage);
                           entityToSpawn.m_36735_(knockback);
                           entityToSpawn.m_20225_(true);
                           entityToSpawn.m_36767_(piercing);
                           entityToSpawn.m_36762_(true);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, owner_entity, (float)damage, 0, (byte)1);
                     _entityToSpawn.m_6034_(x_pos, y_pos, z_pos);
                     _entityToSpawn.m_6686_(x_power, y_power, z_power, 5.0F, 0.0F);
                     projectileLevel.m_7967_(_entityToSpawn);
                  }
               } else {
                  if (entity instanceof EntityReceiptEntity) {
                     EntityReceiptEntity _datEntI = (EntityReceiptEntity)entity;
                     var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityReceiptEntity.DATA_mode);
                  } else {
                     var10000 = 0;
                  }

                  if (var10000 == 5) {
                     speed = (double)6.5F;
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.CAR.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           SetRangedAmmoProcedure.execute(owner_entity, entityinstance);
                           entityinstance.m_146922_(entity.m_146908_());
                           entityinstance.m_146926_(entity.m_146909_());
                           entityinstance.m_5618_(entityinstance.m_146908_());
                           entityinstance.m_5616_(entityinstance.m_146908_());
                           entityinstance.f_19859_ = entityinstance.m_146908_();
                           entityinstance.f_19860_ = entityinstance.m_146909_();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }

                           entityinstance.m_5997_(x_power * speed, y_power * speed, z_power * speed);
                           entityinstance.m_20256_(new Vec3(x_power * speed, y_power * speed, z_power * speed));
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50, 0, false, false));
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                              }
                           }

                           entityinstance.getPersistentData().m_128379_("Shikigami", true);
                           entityinstance.getPersistentData().m_128379_("canFly", true);
                           entityinstance.getPersistentData().m_128347_("skill", (double)1706.0F);
                           entityinstance.getPersistentData().m_128347_("cnt1", (double)6.0F);
                           entityinstance.getPersistentData().m_128347_("cnt6", (double)2.5F);
                           entityinstance.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
                           entityinstance.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
                           entityinstance.getPersistentData().m_128347_("x_power", x_power * speed * (double)0.5F);
                           entityinstance.getPersistentData().m_128347_("y_power", y_power * speed * (double)0.5F);
                           entityinstance.getPersistentData().m_128347_("z_power", z_power * speed * (double)0.5F);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SLAUGHTER_DEMON.get())).m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }

                           _serverLevel.m_7967_(entityinstance);
                        }
                     }
                  } else {
                     if (entity instanceof EntityReceiptEntity) {
                        EntityReceiptEntity _datEntI = (EntityReceiptEntity)entity;
                        var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityReceiptEntity.DATA_mode);
                     } else {
                        var10000 = 0;
                     }

                     if (var10000 == 6) {
                        speed = (double)6.5F;
                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.TRUCK.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                              SetRangedAmmoProcedure.execute(owner_entity, entityinstance);
                              entityinstance.m_146922_(entity.m_146908_());
                              entityinstance.m_146926_(entity.m_146909_());
                              entityinstance.m_5618_(entityinstance.m_146908_());
                              entityinstance.m_5616_(entityinstance.m_146908_());
                              entityinstance.f_19859_ = entityinstance.m_146908_();
                              entityinstance.f_19860_ = entityinstance.m_146909_();
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 _entity.f_20884_ = _entity.m_146908_();
                                 _entity.f_20886_ = _entity.m_146908_();
                              }

                              entityinstance.m_5997_(x_power * speed, y_power * speed, z_power * speed);
                              entityinstance.m_20256_(new Vec3(x_power * speed, y_power * speed, z_power * speed));
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50, 0, false, false));
                                 }
                              }

                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                                 }
                              }

                              entityinstance.getPersistentData().m_128379_("Shikigami", true);
                              entityinstance.getPersistentData().m_128379_("canFly", true);
                              entityinstance.getPersistentData().m_128347_("skill", (double)1706.0F);
                              entityinstance.getPersistentData().m_128347_("cnt1", (double)6.0F);
                              entityinstance.getPersistentData().m_128347_("cnt6", (double)5.0F);
                              entityinstance.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
                              entityinstance.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
                              entityinstance.getPersistentData().m_128347_("x_power", x_power * speed * (double)0.5F);
                              entityinstance.getPersistentData().m_128347_("y_power", y_power * speed * (double)0.5F);
                              entityinstance.getPersistentData().m_128347_("z_power", z_power * speed * (double)0.5F);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity103 = (LivingEntity)entityinstance;
                                 if (_livingEntity103.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                    _livingEntity103.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)1.5F);
                                 }
                              }

                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SLAUGHTER_DEMON.get())).m_41777_();
                                 _setstack.m_41764_(1);
                                 _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.m_150109_().m_6596_();
                                 }
                              }

                              _serverLevel.m_7967_(entityinstance);
                           }
                        }
                     } else {
                        if (entity instanceof EntityReceiptEntity) {
                           EntityReceiptEntity _datEntI = (EntityReceiptEntity)entity;
                           var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityReceiptEntity.DATA_mode);
                        } else {
                           var10000 = 0;
                        }

                        if (var10000 == 15 && world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_HOUSE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos") + (double)16.0F, entity.getPersistentData().m_128459_("z_pos")), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                              SetRangedAmmoProcedure.execute(owner_entity, entityinstance);
                              entityinstance.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
                              entityinstance.getPersistentData().m_128347_("COOLDOWN_TICKS", entity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.ITADORI_ARM.get())).m_41777_();
                                 _setstack.m_41764_(1);
                                 _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.m_150109_().m_6596_();
                                 }
                              }

                              _serverLevel.m_7967_(entityinstance);
                           }
                        }
                     }
                  }
               }
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
