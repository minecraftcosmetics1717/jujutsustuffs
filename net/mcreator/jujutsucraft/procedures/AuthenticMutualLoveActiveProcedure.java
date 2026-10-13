package net.mcreator.jujutsucraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EquipmentSlot.Type;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

public class AuthenticMutualLoveActiveProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double HP;
         double num1;
         double range;
         double var10000;
         label180: {
            String STR1 = "";
            ItemStack item_a = ItemStack.f_41583_;
            boolean failed = false;
            boolean logic_attack = false;
            double old_skill = (double)0.0F;
            HP = (double)0.0F;
            range = (double)0.0F;
            double old_cooldown = (double)0.0F;
            double x_pos = (double)0.0F;
            double tick = (double)0.0F;
            double z_pos = (double)0.0F;
            num1 = (double)0.0F;
            double y_pos = (double)0.0F;
            double old_skill_domain = (double)0.0F;
            double num3 = (double)0.0F;
            double num2 = (double)0.0F;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * (double)2.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                  break label180;
               }
            }

            var10000 = (double)0.0F;
         }

         double var50 = var10000;
         if (!entity.getPersistentData().m_128471_("Failed")) {
            double var46 = entity.getPersistentData().m_128459_("skill");
            double var48 = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
            String var42 = "";
            boolean var45 = false;
            if (entity instanceof Player) {
               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
               LazyOptional var78 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
               Objects.requireNonNull(_iitemhandlerref);
               var78.ifPresent(_iitemhandlerref::set);
               if (_iitemhandlerref.get() != null) {
                  for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                     ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                     if (itemstackiterator.m_41720_() == JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get() && itemstackiterator.m_41784_().m_128459_("skill") > (double)0.0F) {
                        var45 = true;
                        entity.getPersistentData().m_128347_("skill", itemstackiterator.m_41784_().m_128459_("skill"));
                        entity.getPersistentData().m_128347_("effect", itemstackiterator.m_41784_().m_128459_("effect"));
                        entity.getPersistentData().m_128347_("COOLDOWN_TICKS", itemstackiterator.m_41784_().m_128459_("COOLDOWN_TICKS"));
                        num1 = itemstackiterator.m_41784_().m_128459_("COOLDOWN_TICKS");
                        var42 = itemstackiterator.m_41784_().m_128461_("SHIKIGAMI_NAME");
                        HP = itemstackiterator.m_41784_().m_128459_("SHIKIGAMI_HP");
                        break;
                     }
                  }
               }
            } else {
               num1 = (double)0.0F;

               for(int index0 = 0; index0 < 4; ++index0) {
                  ItemStack var73;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var73 = _entGetArmor.m_6844_(EquipmentSlot.m_20744_(Type.ARMOR, (int)num1));
                  } else {
                     var73 = ItemStack.f_41583_;
                  }

                  ItemStack var43 = var73.m_41777_();
                  if (var43.m_41784_().m_128459_("skill") > (double)0.0F) {
                     var45 = true;
                     entity.getPersistentData().m_128347_("skill", var43.m_41784_().m_128459_("skill"));
                     entity.getPersistentData().m_128347_("effect", var43.m_41784_().m_128459_("effect"));
                     entity.getPersistentData().m_128347_("COOLDOWN_TICKS", var43.m_41784_().m_128459_("COOLDOWN_TICKS"));
                     num1 = var43.m_41784_().m_128459_("COOLDOWN_TICKS");
                     var42 = var43.m_41784_().m_128461_("SHIKIGAMI_NAME");
                     HP = var43.m_41784_().m_128459_("SHIKIGAMI_HP");
                     break;
                  }

                  ++num1;
                  if (num1 > (double)3.0F) {
                     break;
                  }
               }

               LivingEntity var74;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var74 = _mobEnt.m_5448_();
               } else {
                  var74 = null;
               }

               if (var74 instanceof LivingEntity) {
                  label197: {
                     if (var45) {
                        label189: {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var74 = _mobEnt.m_5448_();
                           } else {
                              var74 = null;
                           }

                           LivingEntity var41 = var74;
                           if (var41 instanceof LivingEntity) {
                              LivingEntity _livEnt39 = var41;
                              if (_livEnt39.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label189;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var74 = _mobEnt.m_5448_();
                           } else {
                              var74 = null;
                           }

                           if (!((Entity)var74).getPersistentData().m_128471_("CursedSpirit")) {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var74 = _mobEnt.m_5448_();
                              } else {
                                 var74 = null;
                              }

                              if (!((Entity)var74).getPersistentData().m_128471_("CurseUser")) {
                                 break label197;
                              }
                           }
                        }
                     }

                     var45 = true;
                     entity.getPersistentData().m_128347_("skill", (double)2815.0F);
                     entity.getPersistentData().m_128347_("effect", (double)0.0F);
                     entity.getPersistentData().m_128347_("COOLDOWN_TICKS", (double)350.0F);
                     num1 = (double)350.0F;
                     var42 = "jujutsucraft:entity_jacobs_ladder_circle";
                     HP = (double)200.0F;
                  }
               }
            }

            if (var45) {
               if (var42.isEmpty()) {
                  if (entity.getPersistentData().m_128459_("skill") % (double)100.0F <= (double)20.0F && entity.getPersistentData().m_128459_("skill") >= (double)100.0F && (!(entity.getPersistentData().m_128459_("skill") >= (double)500.0F) || !(entity.getPersistentData().m_128459_("skill") < (double)600.0F))) {
                     double var54 = entity.getPersistentData().m_128459_("skill_domain");
                     entity.getPersistentData().m_128347_("skill_domain", Math.floor(entity.getPersistentData().m_128459_("skill") / (double)100.0F));
                     DomainActiveProcedure.execute(world, x, y, z, entity);
                     entity.getPersistentData().m_128347_("skill_domain", var54);
                  }
               } else if (var50 % (double)Math.round(Math.max(Math.ceil(num1 / (double)75.0F), (double)1.0F) * (double)40.0F) == (double)0.0F || entity.getPersistentData().m_128471_("StartDomainAttack")) {
                  double var56 = Math.ceil(Math.max((double)250.0F - num1, (double)75.0F) / (double)75.0F);
                  boolean var44 = true;
                  Vec3 _center = new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"));

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / (double)2.0F), (e) -> true)) {
                     if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && LogicAttackDomainProcedure.execute(world, entity, entityiterator) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        var44 = false;
                     }
                  }

                  if (var44) {
                     entity.getPersistentData().m_128379_("StartDomainAttack", true);
                  } else {
                     entity.getPersistentData().m_128379_("StartDomainAttack", false);
                     double var55 = (double)0.0F;

                     for(int index1 = 0; index1 < (int)Math.round(var56); ++index1) {
                        ++var55;
                        if (Math.random() < (double)0.5F || var55 <= (double)1.0F) {
                           num1 = Math.toRadians(Math.random() * (double)360.0F);
                           double var49 = entity.getPersistentData().m_128459_("x_pos_doma") + Math.sin(num1) * (range / (double)2.0F - (double)4.0F) + Math.random() * (double)0.5F;
                           double var53 = entity.getPersistentData().m_128459_("y_pos_doma") + Math.random() * (double)0.5F;
                           double var51 = entity.getPersistentData().m_128459_("z_pos_doma") + Math.cos(num1) * (range / (double)2.0F - (double)4.0F) + Math.random() * (double)0.5F;
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var49, var53, var51), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "summon " + var42 + " ~ ~ ~ {Health:" + Math.round(HP) + "f,Attributes:[{Name:generic.max_health,Base:" + Math.round(HP) + "}],Rotation:[" + Math.toDegrees(num1) + "F,0F]}");
                           }

                           Vec3 _center = new Vec3(var49, var53, var51);

                           for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)0.5F), (e) -> true)) {
                              if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && entityiterator.getPersistentData().m_128459_("NameRanged_ranged") == (double)0.0F) {
                                 SetRangedAmmoProcedure.execute(entity, entityiterator);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            entity.getPersistentData().m_128347_("skill", var46);
            entity.getPersistentData().m_128347_("COOLDOWN_TICKS", var48);
         }

      }
   }
}
