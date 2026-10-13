package net.mcreator.jujutsucraft.procedures;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade22Entity;
import net.mcreator.jujutsucraft.entity.EntityWitnessStandEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShibuyaEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShinjukuEntity;
import net.mcreator.jujutsucraft.entity.JudgemanEntity;
import net.mcreator.jujutsucraft.entity.RozetsuEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.registries.ForgeRegistries;

public class DeadlySentencingActiveProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean startJudgeman;
         boolean update;
         boolean logic_judgeTarget;
         String guilt_str;
         double guilt_karma;
         Entity entity_target;
         Entity entity_targetJudge;
         double range;
         double var10000;
         label1015: {
            ItemStack itemMainhand = ItemStack.f_41583_;
            ItemStack itemOffhand = ItemStack.f_41583_;
            ItemStack replace_item = ItemStack.f_41583_;
            ItemStack executioners_sword = ItemStack.f_41583_;
            boolean logic_a = false;
            startJudgeman = false;
            update = false;
            boolean logic_hitDomain = false;
            boolean logic_noFriend = false;
            logic_judgeTarget = false;
            guilt_str = "";
            String dd = "";
            String MM = "";
            String pattern = "";
            String yyyy = "";
            String tellrawCommand = "";
            double x_dis = (double)0.0F;
            double distance = (double)0.0F;
            range = (double)0.0F;
            double x_pos = (double)0.0F;
            double z_dis = (double)0.0F;
            double tick = (double)0.0F;
            double z_pos = (double)0.0F;
            double num1 = (double)0.0F;
            double y_pos = (double)0.0F;
            double y_dis = (double)0.0F;
            double num3 = (double)0.0F;
            double num2 = (double)0.0F;
            double yaw = (double)0.0F;
            double pitch = (double)0.0F;
            double num4 = (double)0.0F;
            guilt_karma = (double)0.0F;
            double num_guilt = (double)0.0F;
            double radius = (double)0.0F;
            double skill = (double)0.0F;
            double strength_max = (double)0.0F;
            Entity entity_first = null;
            Entity entity_setStand = null;
            Entity entity_judgeman = null;
            entity_target = null;
            entity_targetJudge = null;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label1015;
               }
            }

            var10000 = (double)0.0F;
         }

         double var106 = var10000;
         double var131 = entity.getPersistentData().m_128459_("skill");
         if (entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F) {
            LivingEntity var206;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var206 = _mobEnt.m_5448_();
            } else {
               var206 = null;
            }

            entity_target = var206;
         }

         Entity _ent = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("takada_UUID"));
         if (!(_ent instanceof JudgemanEntity) && var106 % (double)20.0F == (double)10.0F) {
            double var122 = (double)entity.m_146908_();
            double var120 = (double)entity.m_146909_();
            RotateEntityProcedure.execute(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"), entity);
            double var110 = Math.toRadians((double)(entity.m_146908_() + 90.0F + 180.0F));
            double var100 = entity.m_20185_() + Math.cos(var110) * (double)(5.0F + entity.m_20205_());
            double var114 = entity.m_20186_();
            double var107 = entity.m_20189_() + Math.sin(var110) * (double)(5.0F + entity.m_20205_());
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.JUDGEMAN.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(var100, var114, var107), MobSpawnType.MOB_SUMMONED, false, false);
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

                  _ent = entityinstance;
                  _serverLevel.m_7967_(entityinstance);
               }
            }

            entity.m_146922_((float)var122);
            entity.m_146926_((float)var120);
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

         if (_ent instanceof JudgemanEntity) {
            if (var131 != (double)2719.0F) {
               label1003: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        var207 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19564_();
                        break label1003;
                     }
                  }

                  var207 = 0;
               }

               if (var207 > 0) {
                  _ent.m_7618_(Anchor.EYES, new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma")));
               } else {
                  double var111 = (double)(_ent.m_146908_() % 360.0F);
                  _ent.m_146922_(entity.m_146908_() % 360.0F);
                  _ent.m_146926_(entity.m_146909_());
                  _ent.m_5618_(_ent.m_146908_());
                  _ent.m_5616_(_ent.m_146908_());
                  _ent.f_19859_ = _ent.m_146908_();
                  _ent.f_19860_ = _ent.m_146909_();
                  if (_ent instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)_ent;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  double var123 = var111 - (double)entity.m_146908_();
                  if (Math.abs(var123) > (double)180.0F) {
                     _ent.m_146922_((float)(var111 + Math.min((double)8.0F, Math.abs(var123)) * (double)(var123 < (double)0.0F ? -1 : 1)));
                     _ent.m_146926_(entity.m_146909_());
                     _ent.m_5618_(_ent.m_146908_());
                     _ent.m_5616_(_ent.m_146908_());
                     _ent.f_19859_ = _ent.m_146908_();
                     _ent.f_19860_ = _ent.m_146909_();
                     if (_ent instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)_ent;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }
                  } else {
                     _ent.m_146922_((float)(var111 + Math.min((double)8.0F, Math.abs(var123)) * (double)(var123 > (double)0.0F ? -1 : 1)));
                     _ent.m_146926_(entity.m_146909_());
                     _ent.m_5618_(_ent.m_146908_());
                     _ent.m_5616_(_ent.m_146908_());
                     _ent.f_19859_ = _ent.m_146908_();
                     _ent.f_19860_ = _ent.m_146909_();
                     if (_ent instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)_ent;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }
                  }
               }

               double var112 = Math.toRadians((double)(_ent.m_146908_() + 90.0F + 180.0F));
               double var101 = entity.m_20185_() + Math.cos(var112) * (double)(5.0F + entity.m_20205_());
               double var115 = entity.m_20186_();
               double var108 = entity.m_20189_() + Math.sin(var112) * (double)(5.0F + entity.m_20205_());
               _ent.m_6021_(_ent.m_20185_() + Math.min((double)0.5F, Math.abs(var101 - _ent.m_20185_())) * (double)(var101 > _ent.m_20185_() ? 1 : -1), _ent.m_20186_() + Math.min((double)0.5F, Math.abs(var115 - _ent.m_20186_())) * (double)(var115 > _ent.m_20186_() ? 1 : -1), _ent.m_20189_() + Math.min((double)0.5F, Math.abs(var108 - _ent.m_20189_())) * (double)(var108 > _ent.m_20189_() ? 1 : -1));
               if (_ent instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)_ent;
                  _serverPlayer.f_8906_.m_9774_(_ent.m_20185_() + Math.min((double)0.5F, Math.abs(var101 - _ent.m_20185_())) * (double)(var101 > _ent.m_20185_() ? 1 : -1), _ent.m_20186_() + Math.min((double)0.5F, Math.abs(var115 - _ent.m_20186_())) * (double)(var115 > _ent.m_20186_() ? 1 : -1), _ent.m_20189_() + Math.min((double)0.5F, Math.abs(var108 - _ent.m_20189_())) * (double)(var108 > _ent.m_20189_() ? 1 : -1), _ent.m_146908_(), _ent.m_146909_());
               }

               if (var131 == (double)0.0F && !entity.getPersistentData().m_128471_("Failed")) {
                  label997: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           var208 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                           break label997;
                        }
                     }

                     var208 = 0;
                  }

                  if (var208 < 200) {
                     ResetCounterProcedure.execute(entity);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                        }
                     }

                     entity.getPersistentData().m_128347_("skill", (double)2719.0F);
                     entity.getPersistentData().m_128347_("cnt3", (double)20.0F);
                  }
               }
            }

            _ent.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
            if (!entity.m_6084_() && !_ent.m_9236_().m_5776_() && _ent.m_20194_() != null) {
               _ent.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, _ent.m_20182_(), _ent.m_20155_(), _ent.m_9236_() instanceof ServerLevel ? (ServerLevel)_ent.m_9236_() : null, 4, _ent.m_7755_().getString(), _ent.m_5446_(), _ent.m_9236_().m_7654_(), _ent), "kill @s");
            }
         }

         var131 = entity.getPersistentData().m_128459_("skill");
         if (!entity.getPersistentData().m_128471_("Failed") || var131 == (double)2719.0F) {
            entity.getPersistentData().m_128379_("DomainAttack", false);
            if (var106 % (double)20.0F == (double)10.0F) {
               if (var131 == (double)2719.0F && entity.getPersistentData().m_128459_("cnt3") >= (double)20.0F) {
                  update = true;
                  entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
                     if (entity.getPersistentData().m_128459_("x_power") > (double)100.0F) {
                        if (entity.getPersistentData().m_128459_("x_power") - (double)100.0F > Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)100.0F)) {
                           entity.getPersistentData().m_128347_("cnt2", (double)2.0F);
                        } else {
                           entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
                        }
                     } else if (entity.getPersistentData().m_128459_("x_power") <= (double)0.0F) {
                        entity.getPersistentData().m_128347_("cnt2", (double)-1.0F);
                     } else if (entity.getPersistentData().m_128459_("x_power") > Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)100.0F)) {
                        entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
                     } else {
                        entity.getPersistentData().m_128347_("cnt2", (double)-1.0F);
                     }
                  }
               }

               double var113 = (double)0.0F;
               double var124 = (double)0.0F;
               double var121 = (double)0.0F;
               double var133 = (double)-1.0F;
               ItemStack var81 = (new ItemStack((ItemLike)JujutsucraftModItems.EXECUTIONERS_SWORD.get())).m_41777_();
               Vec3 _center = new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"));

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / (double)2.0F), (e) -> true)) {
                  if (entityiterator instanceof EntityWitnessStandEntity || entityiterator instanceof LivingEntity && entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
                     double var93 = entity.getPersistentData().m_128459_("x_pos_doma") - entityiterator.m_20185_();
                     double var117 = entity.getPersistentData().m_128459_("y_pos_doma") - (entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F);
                     double var103 = entity.getPersistentData().m_128459_("z_pos_doma") - entityiterator.m_20189_();
                     double var96 = var93 * var93 + var117 * var117 + var103 * var103;
                     if (var96 < range * (double)0.5F * range * (double)0.5F) {
                        if (entityiterator instanceof EntityWitnessStandEntity) {
                           ++var124;
                        } else if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                           if (!entityiterator.m_9236_().m_5776_()) {
                              entityiterator.m_146870_();
                           }
                        } else {
                           boolean var83 = LogicAttackDomainProcedure.execute(world, entity, entityiterator);
                           boolean var84 = LogicAttackProcedure.execute(world, entity, entityiterator);
                           if (update) {
                              if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
                                 if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                    Commands var209 = entityiterator.m_20194_().m_129892_();
                                    CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator);
                                    double var10002 = entity.getPersistentData().m_128459_("cnt2");
                                    var209.m_230957_(var10001, "title @s title {\"text\":\"" + Component.m_237115_(var10002 == (double)-1.0F ? "jujutsu.message.higuruma0" : "jujutsu.message.higuruma1").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                 }
                              } else if (entity.getPersistentData().m_128459_("cnt1") == (double)2.0F) {
                                 if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                    entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "title @s title {\"text\":\"" + Component.m_237115_("jujutsu.message.higuruma2").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                 }
                              } else if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F) {
                                 if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                    entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "title @s title {\"text\":\"" + Component.m_237115_("jujutsu.message.higuruma3").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                 }
                              } else if (entity.getPersistentData().m_128459_("cnt1") >= (double)5.0F && entity.getPersistentData().m_128459_("cnt2") >= (double)0.0F && var83 && var84 && entity != entityiterator) {
                                 if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F || entity.getPersistentData().m_128459_("cnt2") == (double)2.0F) {
                                    boolean var82 = false;
                                    if (!var82) {
                                       AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                                       LazyOptional var210 = entityiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                                       Objects.requireNonNull(_iitemhandlerref);
                                       var210.ifPresent(_iitemhandlerref::set);
                                       if (_iitemhandlerref.get() != null) {
                                          for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                                             ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                                             if ((itemstackiterator.m_204117_(ItemTags.create(new ResourceLocation("forge:cursed_tool"))) || itemstackiterator.m_41784_().m_128459_("CursePower") != (double)0.0F) && (itemstackiterator.m_204117_(ItemTags.create(new ResourceLocation("forge:whip"))) || itemstackiterator.m_204117_(ItemTags.create(new ResourceLocation("forge:sword"))) || itemstackiterator.m_204117_(ItemTags.create(new ResourceLocation("forge:spear"))) || itemstackiterator.m_204117_(ItemTags.create(new ResourceLocation("forge:rifle"))) || itemstackiterator.m_41720_() instanceof SwordItem || itemstackiterator.m_41720_() instanceof AxeItem || itemstackiterator.m_41720_() instanceof PickaxeItem || itemstackiterator.m_41720_() instanceof ShovelItem || itemstackiterator.m_41720_() instanceof TridentItem || itemstackiterator.m_41720_() instanceof HoeItem || itemstackiterator.m_41720_() instanceof BowItem || itemstackiterator.m_41720_() instanceof CrossbowItem)) {
                                                var82 = true;
                                                ItemStack var80;
                                                if (entityiterator instanceof Player) {
                                                   var80 = (new ItemStack((ItemLike)JujutsucraftModItems.CONFISCATION.get())).m_41777_();
                                                   CompoundTag _nbtTag = itemstackiterator.m_41783_();
                                                   if (_nbtTag != null) {
                                                      var80.m_41751_(_nbtTag.m_6426_());
                                                   }

                                                   var80.m_41784_().m_128359_("confiscation_item", ForgeRegistries.ITEMS.getKey(itemstackiterator.m_41720_()).toString());
                                                   var80.m_41784_().m_128347_("CursePower_", itemstackiterator.m_41784_().m_128459_("CursePower"));
                                                   var80.m_41784_().m_128347_("Power_", itemstackiterator.m_41784_().m_128459_("Power"));
                                                   var80.m_41784_().m_128347_("Reach_", itemstackiterator.m_41784_().m_128459_("Reach"));
                                                   var80.m_41784_().m_128347_("Range_", itemstackiterator.m_41784_().m_128459_("Range"));
                                                   var80.m_41784_().m_128347_("Knockback_", itemstackiterator.m_41784_().m_128459_("Knockback"));
                                                   var80.m_41784_().m_128347_("CursePower", (double)0.0F);
                                                   var80.m_41784_().m_128347_("Power", (double)0.0F);
                                                   var80.m_41784_().m_128347_("Reach", (double)0.0F);
                                                   var80.m_41784_().m_128347_("Range", (double)0.0F);
                                                   var80.m_41784_().m_128347_("Knockback", (double)0.0F);
                                                } else {
                                                   var80 = ItemStack.f_41583_.m_41777_();
                                                }

                                                ItemStack _setstack = var80.m_41777_();
                                                _setstack.m_41764_(itemstackiterator.m_41613_());
                                                entityiterator.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                                                   if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot) {
                                                      _modHandlerEntSetSlot.setStackInSlot(_idx, _setstack);
                                                   }

                                                });
                                             }
                                          }
                                       }
                                    }

                                    if (entityiterator instanceof Player) {
                                       Player _player = (Player)entityiterator;
                                       _player.m_36335_().m_41524_((Item)JujutsucraftModItems.CONFISCATION.get(), 900);
                                    }

                                    if (!var82) {
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiterator;
                                          if (!_entity.m_9236_().m_5776_()) {
                                             _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 900, 0, false, false));
                                          }
                                       }

                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiterator;
                                          if (!_entity.m_9236_().m_5776_()) {
                                             _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 900, 0, false, false));
                                          }
                                       }

                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiterator;
                                          if (!_entity.m_9236_().m_5776_()) {
                                             MobEffectInstance var221;
                                             MobEffect var10003;
                                             int var10006;
                                             label931: {
                                                var221 = new MobEffectInstance;
                                                var10003 = MobEffects.f_19613_;
                                                if (entityiterator instanceof LivingEntity) {
                                                   LivingEntity _livEnt = (LivingEntity)entityiterator;
                                                   if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                                      var10006 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                                      break label931;
                                                   }
                                                }

                                                var10006 = 0;
                                             }

                                             var221.<init>(var10003, 900, (int)((double)2.0F + (double)var10006 * 0.2), false, false);
                                             _entity.m_7292_(var221);
                                          }
                                       }
                                    }
                                 }

                                 if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F || entity.getPersistentData().m_128459_("cnt2") == (double)2.0F) {
                                    var113 = (double)0.0F;

                                    for(int index0 = 0; index0 < 200; ++index0) {
                                       ++var113;
                                       if (var81.m_41784_().m_128461_("TARGET" + Math.round(var113)).isEmpty()) {
                                          var81.m_41784_().m_128359_("TARGET" + Math.round(var113), entityiterator.m_20149_());
                                          break;
                                       }
                                    }
                                 }
                              }
                           }

                           if (entity != entityiterator) {
                              if (!var83) {
                                 continue;
                              }

                              if (!var84) {
                                 label902: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                          var211 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19564_();
                                          break label902;
                                       }
                                    }

                                    var211 = 0;
                                 }

                                 if (var211 < 1) {
                                    continue;
                                 }
                              }
                           }

                           if (entity != entityiterator) {
                              if (entity_target instanceof LivingEntity) {
                                 if (entity_target == entityiterator) {
                                    logic_judgeTarget = true;
                                 }
                              } else if (!(GetEntityFromUUIDProcedure.execute(world, entityiterator.getPersistentData().m_128461_("OWNER_UUID")) instanceof LivingEntity)) {
                                 int var222;
                                 label893: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                          var222 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                          break label893;
                                       }
                                    }

                                    var222 = 0;
                                 }

                                 if (var133 < (double)var222) {
                                    label887: {
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entityiterator;
                                          if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                             var10000 = (double)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                             break label887;
                                          }
                                       }

                                       var10000 = (double)0.0F;
                                    }

                                    var133 = var10000;
                                    entity_target = entityiterator;
                                    logic_judgeTarget = true;
                                 }
                              }
                           }

                           label882: {
                              ++var121;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                    var213 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19564_();
                                    break label882;
                                 }
                              }

                              var213 = 0;
                           }

                           if (var213 < 1) {
                              ++var113;
                           }

                           if (var131 != (double)2719.0F && var106 % (double)60.0F == (double)50.0F) {
                              if (entityiterator instanceof Player) {
                                 if (!(entityiterator instanceof LivingEntity)) {
                                    continue;
                                 }

                                 LivingEntity _livEnt203 = (LivingEntity)entityiterator;
                                 if (!_livEnt203.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    continue;
                                 }
                              }

                              if (entityiterator.getPersistentData().m_128471_("CursedSpirit") && !(entityiterator instanceof CursedSpiritGrade22Entity) && !(entityiterator instanceof RozetsuEntity)) {
                                 label872: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                          var214 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                          break label872;
                                       }
                                    }

                                    var214 = 0;
                                 }

                                 if (var214 < 13) {
                                    continue;
                                 }
                              }

                              if (!entityiterator.getPersistentData().m_128461_("JUDGE_ENTITY").isEmpty() && GetEntityFromUUIDProcedure.execute(world, entityiterator.getPersistentData().m_128461_("JUDGE_ENTITY")) == entity) {
                                 label1048: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt212 = (LivingEntity)entityiterator;
                                       if (_livEnt212.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                          break label1048;
                                       }
                                    }

                                    if (!(entity.getPersistentData().m_128459_("x_power") > (double)100.0F) || !(entityiterator instanceof ItadoriYujiEntity) && !(entityiterator instanceof ItadoriYujiShibuyaEntity) && !(entityiterator instanceof ItadoriYujiShinjukuEntity)) {
                                       if (Math.random() < (double)0.75F) {
                                          if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                             entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "judgeman_answer plea_deny");
                                          }
                                       } else if (Math.random() < (double)0.5F) {
                                          if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                             entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "judgeman_answer plea_silent");
                                          }
                                       } else if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                          entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "judgeman_answer plea_confess");
                                       }
                                       continue;
                                    }
                                 }

                                 if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                    entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "judgeman_answer plea_confess");
                                 }
                              }
                           }
                        }
                     }
                  }
               }

               if (update) {
                  if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
                     if (entity.getPersistentData().m_128459_("cnt2") == (double)-1.0F || entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
                        entity.getPersistentData().m_128347_("cnt1", (double)3.0F);
                     }
                  } else if (entity.getPersistentData().m_128459_("cnt1") == (double)2.0F) {
                     if (entity.getPersistentData().m_128459_("cnt2") == (double)0.0F) {
                        entity.getPersistentData().m_128347_("cnt1", (double)3.0F);
                     }
                  } else if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F) {
                     entity.getPersistentData().m_128347_("cnt1", (double)3.0F);
                  } else if (entity.getPersistentData().m_128459_("cnt1") >= (double)5.0F) {
                     if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F || entity.getPersistentData().m_128459_("cnt2") == (double)2.0F) {
                        var81.m_41784_().m_128359_("OWNER_UUID", entity.m_20149_());
                        if (!(entity instanceof Player)) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = var81.m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }
                        } else {
                           ItemStack var218;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var218 = _livEnt.m_21205_();
                           } else {
                              var218 = ItemStack.f_41583_;
                           }

                           ItemStack var78 = var218.m_41777_();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var218 = _livEnt.m_21206_();
                           } else {
                              var218 = ItemStack.f_41583_;
                           }

                           ItemStack var79 = var218.m_41777_();
                           if (var78.m_41720_() != JujutsucraftModItems.GAVEL.get() && var78.m_41720_() != JujutsucraftModItems.GAVEL_LONG.get() && var78.m_41720_() != JujutsucraftModItems.GAVEL_BIG.get() && var78.m_41720_() != JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                              if (var79.m_41720_() != JujutsucraftModItems.GAVEL.get() && var79.m_41720_() != JujutsucraftModItems.GAVEL_LONG.get() && var79.m_41720_() != JujutsucraftModItems.GAVEL_BIG.get() && var79.m_41720_() != JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                                 AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                                 LazyOptional var220 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                                 Objects.requireNonNull(_iitemhandlerref);
                                 var220.ifPresent(_iitemhandlerref::set);
                                 if (_iitemhandlerref.get() != null) {
                                    for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                                       ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                                       if (itemstackiterator.m_41720_() == JujutsucraftModItems.GAVEL.get() || itemstackiterator.m_41720_() == JujutsucraftModItems.GAVEL_LONG.get() || itemstackiterator.m_41720_() == JujutsucraftModItems.GAVEL_BIG.get() || itemstackiterator.m_41720_() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                                          ItemStack _setstack = var81.m_41777_();
                                          _setstack.m_41764_(1);
                                          entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                                             if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot) {
                                                _modHandlerEntSetSlot.setStackInSlot(_idx, _setstack);
                                             }

                                          });
                                          break;
                                       }
                                    }
                                 }
                              } else if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 ItemStack _setstack = var81.m_41777_();
                                 _setstack.m_41764_(1);
                                 _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.m_150109_().m_6596_();
                                 }
                              }
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = var81.m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y + (double)entity.m_20206_() * (double)0.5F, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 2.0F, 1.5F);
                           } else {
                              _level.m_7785_(x, y + (double)entity.m_20206_() * (double)0.5F, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 2.0F, 1.5F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y + (double)entity.m_20206_() * (double)0.5F, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                           } else {
                              _level.m_7785_(x, y + (double)entity.m_20206_() * (double)0.5F, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123747_, x, y + (double)entity.m_20206_() * (double)0.5F, z, 0, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123810_, x, y + (double)entity.m_20206_() * (double)0.5F, z, 5, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.25F);
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_36335_().m_41524_((Item)JujutsucraftModItems.EXECUTIONERS_SWORD.get(), 0);
                        }
                     }

                     entity.getPersistentData().m_128347_("skill", (double)0.0F);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                     }

                     KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                     boolean _setval = true;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.noChangeTechnique = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     return;
                  }
               }

               if (var131 != (double)2719.0F) {
                  if ((var113 >= (double)2.0F || var113 >= (double)1.0F && var121 >= (double)2.0F) && var124 < var121) {
                     startJudgeman = true;
                     double var125 = (double)entity.m_146908_();
                     double var126 = (double)entity.m_146909_();
                     RotateEntityProcedure.execute(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"), entity);
                     double var127 = (double)entity.m_146908_();
                     double var130 = Math.min((double)4.0F + var121 * 0.3, range * (double)0.5F * (double)0.5F);
                     double var116 = entity.getPersistentData().m_128459_("y_pos_doma");
                     Entity var134 = null;
                     _center = new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"));

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / (double)2.0F), (e) -> true)) {
                        if (entityiterator instanceof EntityWitnessStandEntity || entityiterator instanceof LivingEntity && entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
                           double var94 = entity.getPersistentData().m_128459_("x_pos_doma") - entityiterator.m_20185_();
                           double var118 = entity.getPersistentData().m_128459_("y_pos_doma") - (entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F);
                           double var104 = entity.getPersistentData().m_128459_("z_pos_doma") - entityiterator.m_20189_();
                           double var97 = var94 * var94 + var118 * var118 + var104 * var104;
                           if (var97 < range * (double)0.5F * range * (double)0.5F) {
                              if (entityiterator instanceof EntityWitnessStandEntity) {
                                 if (!entityiterator.m_9236_().m_5776_()) {
                                    entityiterator.m_146870_();
                                 }
                              } else {
                                 if (entity != entityiterator) {
                                    if (!LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                                       continue;
                                    }

                                    if (!LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                       label790: {
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)entity;
                                             if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                                var215 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19564_();
                                                break label790;
                                             }
                                          }

                                          var215 = 0;
                                       }

                                       if (var215 < 1) {
                                          continue;
                                       }
                                    }
                                 }

                                 double var102 = entity.getPersistentData().m_128459_("x_pos_doma") + Math.cos(Math.toRadians(var127 + (double)90.0F)) * var130 * (double)-1.0F;
                                 double var109 = entity.getPersistentData().m_128459_("z_pos_doma") + Math.sin(Math.toRadians(var127 + (double)90.0F)) * var130 * (double)-1.0F;
                                 Entity _ent;
                                 if (var134 == null) {
                                    _ent = entity;
                                    var134 = entityiterator;
                                 } else {
                                    if (entity == entityiterator) {
                                       _ent = var134;
                                    } else {
                                       _ent = entityiterator;
                                    }

                                    if (guilt_str.isEmpty() && (!logic_judgeTarget || entity_target == _ent)) {
                                       entity_targetJudge = _ent;
                                       String var91 = (new SimpleDateFormat("yyyy")).format(Calendar.getInstance().getTime());
                                       String var88 = (new SimpleDateFormat("MM")).format(Calendar.getInstance().getTime());
                                       String var87 = (new SimpleDateFormat("dd")).format(Calendar.getInstance().getTime());
                                       String var89 = Component.m_237115_("jujutsu.message.higuruma_date").getString();
                                       var89 = var89.replace("yyyy", "■■■■").replace("MM", "■■").replace("dd", "■■");

                                       while(true) {
                                          double var128 = (double)Mth.m_216271_(RandomSource.m_216327_(), 24, 29);
                                          if (var128 != (double)24.0F) {
                                             guilt_str = Component.m_237115_("jujutsu.message.higuruma10").getString().replace("[guilt]", Component.m_237115_("jujutsu.message.higuruma" + Math.round(var128)).getString()).replace("[date]", var89);
                                             guilt_karma = (double)90.0F;
                                             break;
                                          }

                                          if (!_ent.getPersistentData().m_128461_("crime3").isEmpty()) {
                                             guilt_str = _ent.getPersistentData().m_128461_("crime3");
                                             guilt_karma = (double)90.0F;
                                             break;
                                          }
                                       }

                                       if (_ent instanceof Player && Math.random() < 0.8 || guilt_str.isEmpty()) {
                                          double var129 = (double)Mth.m_216271_(RandomSource.m_216327_(), 16, 24);
                                          guilt_str = Component.m_237115_("jujutsu.message.higuruma10").getString().replace("[guilt]", Component.m_237115_("jujutsu.message.higuruma" + Math.round(var129)).getString()).replace("[date]", var89);
                                          if (var129 != (double)24.0F && var129 != (double)16.0F) {
                                             guilt_karma = (double)90.0F;
                                          } else {
                                             guilt_karma = (double)200.0F;
                                          }
                                       }

                                       if (_ent.getPersistentData().m_128461_("crime4").isEmpty()) {
                                          ItemStack var223;
                                          if (_ent instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)_ent;
                                             var223 = _livEnt.m_21205_();
                                          } else {
                                             var223 = ItemStack.f_41583_;
                                          }

                                          WhenItemPicksUpProcedure.execute(_ent, var223);
                                       }

                                       if (_ent.getPersistentData().m_128461_("crime4").isEmpty()) {
                                          ItemStack var224;
                                          if (_ent instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)_ent;
                                             var224 = _livEnt.m_21206_();
                                          } else {
                                             var224 = ItemStack.f_41583_;
                                          }

                                          WhenItemPicksUpProcedure.execute(_ent, var224);
                                       }

                                       if (_ent.getPersistentData().m_128461_("crime4").isEmpty()) {
                                          AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                                          LazyOptional var216 = _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                                          Objects.requireNonNull(_iitemhandlerref);
                                          var216.ifPresent(_iitemhandlerref::set);
                                          if (_iitemhandlerref.get() != null) {
                                             for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                                                ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                                                if (itemstackiterator.m_41720_() != ItemStack.f_41583_.m_41720_()) {
                                                   WhenItemPicksUpProcedure.execute(_ent, itemstackiterator);
                                                   if (!_ent.getPersistentData().m_128461_("crime4").isEmpty()) {
                                                      break;
                                                   }
                                                }
                                             }
                                          }
                                       }

                                       do {
                                          if (Math.random() < (_ent instanceof Player ? 0.33 : 0.33) && !_ent.getPersistentData().m_128461_("crime1").isEmpty()) {
                                             guilt_str = _ent.getPersistentData().m_128461_("crime1");
                                             guilt_karma = (double)100.0F + _ent.getPersistentData().m_128459_("kill_count") * (double)35.0F;
                                             break;
                                          }

                                          if (Math.random() < (_ent instanceof Player ? 0.15 : (double)0.25F) && !_ent.getPersistentData().m_128461_("crime4").isEmpty()) {
                                             guilt_str = _ent.getPersistentData().m_128461_("crime4");
                                             if (guilt_str.contains("§4")) {
                                                guilt_karma = (double)125.0F;
                                             } else {
                                                guilt_karma = (double)90.0F;
                                             }
                                             break;
                                          }

                                          if (Math.random() < (_ent instanceof Player ? 0.15 : (double)0.25F) && !_ent.getPersistentData().m_128461_("crime2").isEmpty()) {
                                             guilt_str = _ent.getPersistentData().m_128461_("crime2");
                                             guilt_karma = (double)90.0F;
                                             break;
                                          }
                                       } while(!(Math.random() < (double)0.5F));

                                       guilt_str = guilt_str.replace("[name]", _ent.m_5446_().getString());
                                       guilt_str = guilt_str.replace("[place]", Component.m_237115_("text.minecraft").getString());
                                    }
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _serverLevel = (ServerLevel)world;
                                    Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_WITNESS_STAND.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(var102, var116, var109), MobSpawnType.MOB_SUMMONED, false, false);
                                    if (entityinstance != null) {
                                       entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                                       SetRangedAmmoProcedure.execute(entity, entityinstance);
                                       if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                                          entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
                                       }

                                       entityinstance.m_146922_((float)var127);
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

                                       entityinstance.m_6021_(var102, var116, var109);
                                       if (entityinstance instanceof ServerPlayer) {
                                          ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                                          _serverPlayer.f_8906_.m_9774_(var102, var116, var109, entityinstance.m_146908_(), entityinstance.m_146909_());
                                       }

                                       entityinstance.getPersistentData().m_128359_("TARGET", _ent.m_20149_());
                                       _ent.m_146922_(entityinstance.m_146908_());
                                       _ent.m_146926_(0.0F);
                                       _ent.m_5618_(_ent.m_146908_());
                                       _ent.m_5616_(_ent.m_146908_());
                                       _ent.f_19859_ = _ent.m_146908_();
                                       _ent.f_19860_ = _ent.m_146909_();
                                       if (_ent instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)_ent;
                                          _entity.f_20884_ = _entity.m_146908_();
                                          _entity.f_20886_ = _entity.m_146908_();
                                       }

                                       _serverLevel.m_7967_(entityinstance);
                                    }
                                 }

                                 var127 += (double)360.0F / Math.max(var121, (double)1.0F);
                              }
                           }
                        }
                     }

                     entity.m_146922_((float)var125);
                     entity.m_146926_((float)var126);
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

                  if (startJudgeman && !guilt_str.isEmpty()) {
                     entity.getPersistentData().m_128347_("x_power", guilt_karma);
                     String var217 = Component.m_237115_("jujutsu.message.higuruma_answer1").getString();
                     String var92 = "tellraw @s [{\"text\":\"[" + var217 + "] \",\"color\":\"gray\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"" + Component.m_237115_("jujutsu.message.higuruma_answer1_").getString() + "\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/judgeman_answer plea_silent\"}},{\"text\":\"[" + Component.m_237115_("jujutsu.message.higuruma_answer2").getString() + "] \",\"color\":\"white\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"" + Component.m_237115_("jujutsu.message.higuruma_answer2_").getString() + "\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/judgeman_answer plea_confess\"}},{\"text\":\"[" + Component.m_237115_("jujutsu.message.higuruma_answer3").getString() + "] \",\"color\":\"red\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"" + Component.m_237115_("jujutsu.message.higuruma_answer3_").getString() + "\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/judgeman_answer plea_deny\"}}]";
                     _center = new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"));

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / (double)2.0F), (e) -> true)) {
                        double var95 = entity.getPersistentData().m_128459_("x_pos_doma") - entityiterator.m_20185_();
                        double var119 = entity.getPersistentData().m_128459_("y_pos_doma") - (entityiterator.m_20186_() + (double)entityiterator.m_20206_() * (double)0.5F);
                        double var105 = entity.getPersistentData().m_128459_("z_pos_doma") - entityiterator.m_20189_();
                        double var98 = var95 * var95 + var119 * var119 + var105 * var105;
                        if (var98 < range * (double)0.5F * range * (double)0.5F) {
                           if (entityiterator instanceof Player) {
                              if (entityiterator instanceof Player) {
                                 Player _player = (Player)entityiterator;
                                 if (!_player.m_9236_().m_5776_()) {
                                    _player.m_5661_(Component.m_237113_(guilt_str), false);
                                 }
                              }

                              if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                 entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "playsound entity.wither.spawn master @s");
                              }

                              if (entityiterator == entity_targetJudge && !entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                 entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), var92);
                              }
                           }

                           if (entityiterator == entity_targetJudge) {
                              entityiterator.getPersistentData().m_128359_("JUDGE_ENTITY", entity.m_20149_());
                           } else {
                              entityiterator.getPersistentData().m_128473_("JUDGE_ENTITY");
                           }
                        }
                     }
                  }
               }
            }

            entity.getPersistentData().m_128379_("DomainAttack", false);
         }

      }
   }
}
