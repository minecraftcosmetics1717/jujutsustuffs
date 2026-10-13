package net.mcreator.jujutsucraft.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.EntityItemEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class AuthenticMutualLoveProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_center = (double)0.0F;
         double z_center = (double)0.0F;
         double num1 = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_center = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double yaw = (double)0.0F;
         double dis = (double)0.0F;
         double num2 = (double)0.0F;
         entity.getPersistentData().m_128347_("select", (double)5.0F);
         DomainExpansionCreateBarrierProcedure.execute(world, x, y, z, entity);
         if (entity.getPersistentData().m_128459_("cnt1") > (double)0.0F && entity.getPersistentData().m_128459_("cnt1") == (double)34.0F) {
            if (entity.getPersistentData().m_128459_("NameRanged") == (double)0.0F) {
               entity.getPersistentData().m_128347_("NameRanged", Math.random());
            }

            dis = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
            yaw = (double)0.0F;
            x_center = entity.getPersistentData().m_128459_("x_pos_doma");
            y_center = entity.getPersistentData().m_128459_("y_pos_doma");
            z_center = entity.getPersistentData().m_128459_("z_pos_doma");
            y_pos = y_center + (double)2.0F;

            for(int index0 = 0; index0 < 8; ++index0) {
               x_pos = x_center + Math.cos(Math.toRadians(yaw)) * (dis - (double)4.5F);
               z_pos = z_center + Math.sin(Math.toRadians(yaw)) * (dis - (double)4.5F);
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_AWAJI_KNOT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                     }

                     entityinstance.m_146922_((float)(yaw + (double)(num1 % (double)2.0F == (double)1.0F ? 90 : -90)));
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
                     entityinstance.m_6021_(x_pos, y_pos, z_pos);
                     if (entityinstance instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                        _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entityinstance.m_146908_(), entityinstance.m_146909_());
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               yaw += (double)45.0F;
               ++num1;
            }

            for(int index1 = 0; index1 < 12; ++index1) {
               num1 = Math.toRadians(Math.random() * (double)720.0F);

               for(int index2 = 0; index2 < 32; ++index2) {
                  num2 = Math.random();
                  if (num2 > 0.45 && num2 < 0.9) {
                     num2 *= dis - (double)3.0F;
                     break;
                  }
               }

               x_pos = entity.getPersistentData().m_128459_("x_pos_doma") + Math.sin(num1) * num2;
               y_pos = entity.getPersistentData().m_128459_("y_pos_doma") - (Math.random() + (double)1.0F);
               z_pos = entity.getPersistentData().m_128459_("z_pos_doma") + Math.cos(num1) * num2;
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.GRAVESTONE_4.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                     }

                     entityinstance.m_146922_((float)(Math.random() * (double)360.0F));
                     entityinstance.m_146926_((float)((Math.random() - (double)0.5F) * (double)70.0F));
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
                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }

            for(int index3 = 0; index3 < 20; ++index3) {
               num1 = Math.toRadians(Math.random() * (double)720.0F);

               for(int index4 = 0; index4 < 32; ++index4) {
                  num2 = Math.random();
                  if (num2 < 0.9) {
                     num2 *= dis - (double)3.0F;
                     break;
                  }
               }

               pitch = (Math.random() - (double)0.5F) * (double)30.0F;
               x_pos = entity.getPersistentData().m_128459_("x_pos_doma") + Math.sin(num1) * num2;
               y_pos = entity.getPersistentData().m_128459_("y_pos_doma") - ((double)0.0F + Math.sin(Math.toRadians(Math.abs(pitch * (double)3.0F))));
               z_pos = entity.getPersistentData().m_128459_("z_pos_doma") + Math.cos(num1) * num2;
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_ITEM.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                     }

                     entityinstance.m_146922_((float)(Math.random() * (double)360.0F));
                     entityinstance.m_146926_((float)pitch);
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
                     if (entityinstance instanceof EntityItemEntity) {
                        EntityItemEntity _datEntSetL = (EntityItemEntity)entityinstance;
                        _datEntSetL.m_20088_().m_135381_(EntityItemEntity.DATA_domain_decoration, true);
                     }

                     if (entityinstance instanceof Player) {
                        Player _player = (Player)entityinstance;
                        _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()));
                        _player.m_150109_().m_6596_();
                     } else if (entityinstance instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entityinstance;
                        _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()));
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }
         }

         PlayAnimationProcedure.execute(world, entity);
      }
   }
}
