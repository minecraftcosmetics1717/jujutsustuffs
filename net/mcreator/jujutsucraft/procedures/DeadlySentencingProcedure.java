package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.EntityGuillotineEntity;
import net.mcreator.jujutsucraft.entity.JudgemanEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DeadlySentencingProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_mainHand = ItemStack.f_41583_;
         Entity entity_a = null;
         double x_center = (double)0.0F;
         double z_center = (double)0.0F;
         double num1 = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_center = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double dis = (double)0.0F;
         double tick = (double)0.0F;
         double num3 = (double)0.0F;
         double num2 = (double)0.0F;
         entity.getPersistentData().m_128347_("select", (double)27.0F);
         DomainExpansionCreateBarrierProcedure.execute(world, x, y, z, entity);
         if (entity.getPersistentData().m_128459_("cnt1") > (double)0.0F) {
            if (entity.getPersistentData().m_128459_("cnt1") % (double)10.0F != (double)1.0F) {
               if (entity.getPersistentData().m_128459_("cnt1") % (double)10.0F == (double)5.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity14 = (LivingEntity)entity;
                     if (_livingEntity14.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity14.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-49.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity15 = (LivingEntity)entity;
                     if (_livingEntity15.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity15.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }
            } else {
               GetGavelProcedure.execute(world, x, y, z, entity);

               for(int index0 = 0; index0 < 5; ++index0) {
                  ItemStack var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  item_mainHand = var10000.m_41777_();
                  if (item_mainHand.m_41720_() == JujutsucraftModItems.GAVEL.get()) {
                     break;
                  }

                  GavelRightClicked2Procedure.execute(world, x, y, z, entity);
               }

               ItemStack var77;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var77 = _livEnt.m_21205_();
               } else {
                  var77 = ItemStack.f_41583_;
               }

               if (var77.m_41720_() == JujutsucraftModItems.GAVEL.get()) {
                  if (entity instanceof Player && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gavel")), SoundSource.NEUTRAL, 1.5F, 1.25F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gavel")), SoundSource.NEUTRAL, 1.5F, 1.25F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gavel")), SoundSource.NEUTRAL, 1.5F, 1.25F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:gavel")), SoundSource.NEUTRAL, 1.5F, 1.25F, false);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity11 = (LivingEntity)entity;
                     if (_livingEntity11.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity11.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)4.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity12 = (LivingEntity)entity;
                     if (_livingEntity12.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity12.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)4.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)34.0F) {
               entity.getPersistentData().m_128347_("x_power", (double)-1.0F);
               if (entity.getPersistentData().m_128459_("NameRanged") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("NameRanged", Math.random());
               }

               dis = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
               yaw = (double)0.0F;
               x_center = entity.getPersistentData().m_128459_("x_pos_doma");
               y_center = entity.getPersistentData().m_128459_("y_pos_doma");
               z_center = entity.getPersistentData().m_128459_("z_pos_doma");

               for(int index1 = 0; index1 < 20; ++index1) {
                  x_pos = x_center + Math.cos(Math.toRadians(yaw)) * (dis - (double)7.5F);
                  y_pos = y_center - (double)1.0F;
                  z_pos = z_center + Math.sin(Math.toRadians(yaw)) * (dis - (double)7.5F);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_GUILLOTINE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        entityinstance.m_6021_(x_pos, y_pos, z_pos);
                        if (entityinstance instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                           _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entityinstance.m_146908_(), entityinstance.m_146909_());
                        }

                        if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                           entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                        }

                        entityinstance.m_146922_((float)(yaw + (double)90.0F));
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

                        entityinstance.getPersistentData().m_128347_("NameRanged_ranged", entity.getPersistentData().m_128459_("NameRanged"));
                        entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                        if (entityinstance instanceof EntityGuillotineEntity) {
                           RandomSource var10001 = RandomSource.m_216327_();
                           PlayAnimationEntity2Procedure.execute(entityinstance, "idle" + Math.round((float)Mth.m_216271_(var10001, 1, 6)));
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity38 = (LivingEntity)entity;
                           if (_livingEntity38.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity38.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(dis / (double)17.0F);
                           }
                        }

                        _serverLevel.m_7967_(entityinstance);
                     }
                  }

                  yaw += (double)18.0F;
                  ++num1;
               }
            }
         }

         entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("takada_UUID"));
         if (!(entity_a instanceof JudgemanEntity)) {
            num1 = Math.toRadians((double)(entity.m_146908_() + 90.0F + 180.0F));
            x_pos = entity.m_20185_() + Math.cos(num1) * (double)(5.0F + entity.m_20205_());
            y_pos = entity.m_20186_();
            z_pos = entity.m_20189_() + Math.sin(num1) * (double)(5.0F + entity.m_20205_());
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.JUDGEMAN.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  entityinstance.m_146922_(entity.m_146908_());
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

                  entity.getPersistentData().m_128359_("takada_UUID", entityinstance.m_20149_());
                  entityinstance.getPersistentData().m_128379_("domain_entity", true);
                  if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                     entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b}");
                  }

                  entity_a = entityinstance;
                  _serverLevel.m_7967_(entityinstance);
               }
            }
         }

         if (entity_a instanceof JudgemanEntity) {
            num1 = (double)(entity_a.m_146908_() % 360.0F);
            entity_a.m_146922_(entity.m_146908_() % 360.0F);
            entity_a.m_146926_(entity.m_146909_());
            entity_a.m_5618_(entity_a.m_146908_());
            entity_a.m_5616_(entity_a.m_146908_());
            entity_a.f_19859_ = entity_a.m_146908_();
            entity_a.f_19860_ = entity_a.m_146909_();
            if (entity_a instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity_a;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            num2 = num1 - (double)entity.m_146908_();
            if (Math.abs(num2) > (double)180.0F) {
               entity_a.m_146922_((float)(num1 + Math.min((double)8.0F, Math.abs(num2)) * (double)(num2 < (double)0.0F ? -1 : 1)));
               entity_a.m_146926_(entity.m_146909_());
               entity_a.m_5618_(entity_a.m_146908_());
               entity_a.m_5616_(entity_a.m_146908_());
               entity_a.f_19859_ = entity_a.m_146908_();
               entity_a.f_19860_ = entity_a.m_146909_();
               if (entity_a instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity_a;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }
            } else {
               entity_a.m_146922_((float)(num1 + Math.min((double)8.0F, Math.abs(num2)) * (double)(num2 > (double)0.0F ? -1 : 1)));
               entity_a.m_146926_(entity.m_146909_());
               entity_a.m_5618_(entity_a.m_146908_());
               entity_a.m_5616_(entity_a.m_146908_());
               entity_a.f_19859_ = entity_a.m_146908_();
               entity_a.f_19860_ = entity_a.m_146909_();
               if (entity_a instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity_a;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }
            }

            num1 = Math.toRadians((double)(entity_a.m_146908_() + 90.0F + 180.0F));
            x_pos = entity.m_20185_() + Math.cos(num1) * (double)(5.0F + entity.m_20205_());
            y_pos = entity.m_20186_();
            z_pos = entity.m_20189_() + Math.sin(num1) * (double)(5.0F + entity.m_20205_());
            entity_a.m_6021_(entity_a.m_20185_() + Math.min((double)0.5F, Math.abs(x_pos - entity_a.m_20185_())) * (double)(x_pos > entity_a.m_20185_() ? 1 : -1), entity_a.m_20186_() + Math.min((double)0.5F, Math.abs(y_pos - entity_a.m_20186_())) * (double)(y_pos > entity_a.m_20186_() ? 1 : -1), entity_a.m_20189_() + Math.min((double)0.5F, Math.abs(z_pos - entity_a.m_20189_())) * (double)(z_pos > entity_a.m_20189_() ? 1 : -1));
            if (entity_a instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity_a;
               _serverPlayer.f_8906_.m_9774_(entity_a.m_20185_() + Math.min((double)0.5F, Math.abs(x_pos - entity_a.m_20185_())) * (double)(x_pos > entity_a.m_20185_() ? 1 : -1), entity_a.m_20186_() + Math.min((double)0.5F, Math.abs(y_pos - entity_a.m_20186_())) * (double)(y_pos > entity_a.m_20186_() ? 1 : -1), entity_a.m_20189_() + Math.min((double)0.5F, Math.abs(z_pos - entity_a.m_20189_())) * (double)(z_pos > entity_a.m_20189_() ? 1 : -1), entity_a.m_146908_(), entity_a.m_146909_());
            }

            entity_a.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
            if (!entity.m_6084_() && !entity_a.m_9236_().m_5776_() && entity_a.m_20194_() != null) {
               entity_a.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity_a.m_20182_(), entity_a.m_20155_(), entity_a.m_9236_() instanceof ServerLevel ? (ServerLevel)entity_a.m_9236_() : null, 4, entity_a.m_7755_().getString(), entity_a.m_5446_(), entity_a.m_9236_().m_7654_(), entity_a), "kill @s");
            }
         }

      }
   }
}
