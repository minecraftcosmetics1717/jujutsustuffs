package net.mcreator.jujutsucraft.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ThrowingItemOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         ItemStack item_a = ItemStack.f_41583_;
         Entity owner_entity = null;
         double strength = (double)0.0F;
         double d = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double speed = (double)0.0F;
         double dis = (double)0.0F;
         double CNT6 = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double weapon_size = (double)0.0F;
         double x_power = (double)0.0F;
         double attack_reach = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double vx = (double)0.0F;
         double vy = (double)0.0F;
         double vz = (double)0.0F;
         boolean logic_a = false;
         boolean logic_b = false;
         entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + (double)1.0F);
         if (!entity.getPersistentData().m_128461_("OWNER_UUID").isEmpty()) {
            owner_entity = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (!(owner_entity instanceof LivingEntity)) {
               entity.getPersistentData().m_128359_("OWNER_UUID", "");
               owner_entity = null;
            }
         }

         int var10000;
         label216: {
            CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label216;
               }
            }

            var10000 = 0;
         }

         strength = (double)Math.min(var10000, 50) * CNT6;
         weapon_size = GetWeaponSizeProcedure.execute(entity);
         attack_reach = GetReachProcedure.execute(entity);
         range = ReturnEntitySizeProcedure.execute(entity);
         range = range * range * Math.sqrt(weapon_size * attack_reach);
         ItemStack var100;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var100 = _livEnt.m_21205_();
         } else {
            var100 = ItemStack.f_41583_;
         }

         item_a = var100.m_41777_();
         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F) + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)90.0F) * (entity.getPersistentData().m_128459_("cnt_life") % (double)16.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         dis = (double)2.5F * range;
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * dis;
         y_pos = entity.m_20186_() + Math.sin(pitch) * (double)-1.0F * dis;
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * dis;
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * (double)1.0F), (float)((double)1.0F / (weapon_size + item_a.m_41784_().m_128459_("Power"))));
            } else {
               _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * (double)1.0F), (float)((double)1.0F / (weapon_size + item_a.m_41784_().m_128459_("Power"))), false);
            }
         }

         ParticleGeneratorProcedure.execute(world, range * 0.1, (double)1.0F, (double)5.0F, (double)8.0F, entity.m_20185_(), x_pos, entity.m_20186_(), y_pos, entity.m_20189_(), z_pos, "minecraft:crit");
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_();
         z_pos = entity.m_20189_();
         if (owner_entity instanceof LivingEntity && item_a.m_41720_() == JujutsucraftModItems.DRAGON_BONE.get()) {
            x_power = owner_entity.m_20185_() - entity.m_20185_();
            y_power = owner_entity.m_20186_() + (double)owner_entity.m_20206_() * (double)0.75F - entity.m_20186_();
            z_power = owner_entity.m_20189_() - entity.m_20189_();
            dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
            speed = (double)3.0F;
            if (dis != (double)0.0F) {
               x_power = x_power / dis * speed;
               y_power = y_power / dis * speed;
               z_power = z_power / dis * speed;
            }

            vx = Math.abs(x_power - entity.getPersistentData().m_128459_("x_power")) * (double)(x_power > entity.getPersistentData().m_128459_("x_power") ? 1 : -1);
            vy = Math.abs(y_power - entity.getPersistentData().m_128459_("y_power")) * (double)(y_power > entity.getPersistentData().m_128459_("y_power") ? 1 : -1);
            vz = Math.abs(z_power - entity.getPersistentData().m_128459_("z_power")) * (double)(z_power > entity.getPersistentData().m_128459_("z_power") ? 1 : -1);
            dis = Math.sqrt(vx * vx + vy * vy + vz * vz);
            speed = 0.2;
            if (dis != (double)0.0F) {
               vx = vx / dis * speed;
               vy = vy / dis * speed;
               vz = vz / dis * speed;
            }

            entity.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") + vx);
            entity.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") + vy);
            entity.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") + vz);
         }

         x_power = entity.getPersistentData().m_128459_("x_power");
         y_power = entity.getPersistentData().m_128459_("y_power");
         z_power = entity.getPersistentData().m_128459_("z_power");
         entity.m_20256_(new Vec3(x_power, y_power, z_power));
         dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
         if (dis != (double)0.0F) {
            x_power /= dis;
            y_power /= dis;
            z_power /= dis;
         }

         for(int index0 = 0; index0 < (int)Math.max(dis, (double)1.0F); ++index0) {
            if (!logic_a) {
               entity.getPersistentData().m_128347_("Damage", (double)9.0F * CNT6);
               entity.getPersistentData().m_128347_("knockback", (double)0.25F * ((double)1.0F + Math.max(entity.getPersistentData().m_128459_("cnt6"), (double)0.0F) * 0.1));
               entity.getPersistentData().m_128347_("Range", (double)6.0F * range);
               entity.getPersistentData().m_128347_("effect", (double)5.0F);
               entity.getPersistentData().m_128347_("projectile_type", (double)1.0F);
               entity.getPersistentData().m_128379_("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               if (InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + (double)entity.m_20206_() * (double)0.25F, z_pos, (double)entity.m_20206_() * (double)0.5F, (double)(entity.m_20205_() * 2.0F))) {
                  d = Math.sqrt(entity.getPersistentData().m_128459_("Damage"));
                  entity.getPersistentData().m_128347_("BlockDamage", (0.1 + strength / (double)16.0F) * Math.max(d * (double)0.25F, (double)1.0F));
                  entity.getPersistentData().m_128347_("BlockRange", Math.max((double)0.5F * range, Math.max(d * (double)0.25F, (double)1.0F)));
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128379_("noEffect", true);
                  if (InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + (double)entity.m_20206_() * (double)0.25F, z_pos, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F)) {
                     logic_a = true;
                  }
               }

               if (item_a.m_41720_() == JujutsucraftModItems.DRAGON_BONE.get() && entity.getPersistentData().m_128459_("cnt_life") > (double)20.0F && !logic_b && owner_entity instanceof LivingEntity) {
                  Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / (double)2.0F), (e) -> true)) {
                     if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && entity.getPersistentData().m_128461_("OWNER_UUID").equals(entityiterator.m_20149_())) {
                        logic_b = true;
                        entity.getPersistentData().m_128347_("cnt_return", Math.max(entity.getPersistentData().m_128459_("cnt_return"), (double)1.0F));
                        break;
                     }
                  }
               }
            }

            if (logic_a) {
               break;
            }

            x_pos += x_power;
            y_pos += y_power;
            z_pos += z_power;
         }

         entity.getPersistentData().m_128379_("noEffect", false);
         if (item_a.m_41720_() == JujutsucraftModItems.DRAGON_BONE.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var100 = _livEnt.m_21205_();
            } else {
               var100 = ItemStack.f_41583_;
            }

            var100.m_41784_().m_128347_("power_energy", (double)0.0F);
         }

         if (item_a.m_41720_() == JujutsucraftModItems.GAVEL.get() && entity.getPersistentData().m_128459_("cnt_life") > (double)6.0F) {
            entity.getPersistentData().m_128347_("cnt_return", Math.max(entity.getPersistentData().m_128459_("cnt_return"), (double)1.0F));
         }

         if (entity.getPersistentData().m_128459_("cnt_return") > (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt_return", entity.getPersistentData().m_128459_("cnt_return") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("cnt_return") > (double)2.0F && owner_entity instanceof LivingEntity) {
               if (owner_entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)owner_entity;
                  var100 = _livEnt.m_21205_();
               } else {
                  var100 = ItemStack.f_41583_;
               }

               if (var100.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                  if (owner_entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)owner_entity;
                     ItemStack _setstack = item_a.m_41777_().m_41777_();
                     _setstack.m_41764_(item_a.m_41613_());
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else {
                  if (owner_entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)owner_entity;
                     var100 = _livEnt.m_21206_();
                  } else {
                     var100 = ItemStack.f_41583_;
                  }

                  if (var100.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                     if (owner_entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)owner_entity;
                        ItemStack _setstack = item_a.m_41777_().m_41777_();
                        _setstack.m_41764_(item_a.m_41613_());
                        _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.m_150109_().m_6596_();
                        }
                     }
                  } else if (owner_entity instanceof Player) {
                     Player _player = (Player)owner_entity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var100 = _livEnt.m_21205_();
                     } else {
                        var100 = ItemStack.f_41583_;
                     }

                     ItemStack _setstack = var100.m_41777_().m_41777_();
                     ItemStack var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21205_();
                     } else {
                        var10001 = ItemStack.f_41583_;
                     }

                     _setstack.m_41764_(var10001.m_41613_());
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }
               }

               if (owner_entity instanceof Player) {
                  Player _player = (Player)owner_entity;
                  _player.m_36335_().m_41524_(item_a.m_41720_(), ((<undefinedtype>)(new Object() {
                     public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                           return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                        } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                           return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                        } else {
                           return false;
                        }
                     }
                  })).checkGamemode(owner_entity) ? 10 : 10);
               }

               if (!owner_entity.m_9236_().m_5776_() && owner_entity.m_20194_() != null) {
                  owner_entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, owner_entity.m_20182_(), owner_entity.m_20155_(), owner_entity.m_9236_() instanceof ServerLevel ? (ServerLevel)owner_entity.m_9236_() : null, 4, owner_entity.m_7755_().getString(), owner_entity.m_5446_(), owner_entity.m_9236_().m_7654_(), owner_entity), "playsound minecraft:entity.item.pickup player @s");
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                  _setstack.m_41764_(1);
                  _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt_life") > (double)100.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
         }

      }
   }
}
