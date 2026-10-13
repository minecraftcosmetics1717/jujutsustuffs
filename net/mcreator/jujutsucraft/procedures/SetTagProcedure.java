package net.mcreator.jujutsucraft.procedures;

import java.util.ArrayList;
import net.mcreator.jujutsucraft.JujutsucraftMod;
import net.mcreator.jujutsucraft.entity.CarEntity;
import net.mcreator.jujutsucraft.entity.ChosoEntity;
import net.mcreator.jujutsucraft.entity.CurseUserEntity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade04Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade08Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade13Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade16Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade22Entity;
import net.mcreator.jujutsucraft.entity.DagonEntity;
import net.mcreator.jujutsucraft.entity.DhruvLakdawallaEntity;
import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.GetoSuguruCurseUserEntity;
import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.mcreator.jujutsucraft.entity.HabaEntity;
import net.mcreator.jujutsucraft.entity.HanamiEntity;
import net.mcreator.jujutsucraft.entity.HanyuEntity;
import net.mcreator.jujutsucraft.entity.HazenokiEntity;
import net.mcreator.jujutsucraft.entity.HigurumaHiromiEntity;
import net.mcreator.jujutsucraft.entity.IshigoriRyuEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShibuyaEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShinjukuEntity;
import net.mcreator.jujutsucraft.entity.JogoAshEntity;
import net.mcreator.jujutsucraft.entity.JogoEntity;
import net.mcreator.jujutsucraft.entity.JujutsuSorcererEntity;
import net.mcreator.jujutsucraft.entity.KashimoHajimeEntity;
import net.mcreator.jujutsucraft.entity.KenjakuEntity;
import net.mcreator.jujutsucraft.entity.LarueEntity;
import net.mcreator.jujutsucraft.entity.MahitoEntity;
import net.mcreator.jujutsucraft.entity.MiguelDancerEntity;
import net.mcreator.jujutsucraft.entity.MiguelEntity;
import net.mcreator.jujutsucraft.entity.NishimiyaMomoEntity;
import net.mcreator.jujutsucraft.entity.NobaraKugisakiEntity;
import net.mcreator.jujutsucraft.entity.PolymorphicSoulIsomerEntity;
import net.mcreator.jujutsucraft.entity.ReggieStarEntity;
import net.mcreator.jujutsucraft.entity.ShigemoHarutaEntity;
import net.mcreator.jujutsucraft.entity.ShikigamiPterosaurEntity;
import net.mcreator.jujutsucraft.entity.SukunaEntity;
import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.mcreator.jujutsucraft.entity.UroTakakoEntity;
import net.mcreator.jujutsucraft.entity.ZeninNaoyaCursedSpiritEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SetTagProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double NUM2 = (double)0.0F;
         double NUM1 = (double)0.0F;
         String registry_name = "";
         String place = "";
         String date = "";
         String guilt = "";
         float var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21233_();
         } else {
            var10000 = -1.0F;
         }

         if (!(var10000 >= 200.0F) && !(entity instanceof CursedSpiritGrade16Entity)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21233_();
            } else {
               var10000 = -1.0F;
            }

            if (!(var10000 >= 100.0F) && !(entity instanceof NishimiyaMomoEntity) && !(entity instanceof PolymorphicSoulIsomerEntity)) {
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {LeftHanded:0b,Attributes:[{Name:generic.follow_range,Base:24}]}");
               }
            } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {LeftHanded:0b,Attributes:[{Name:generic.follow_range,Base:48}]}");
            }
         } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {LeftHanded:0b,Attributes:[{Name:generic.follow_range,Base:96}]}");
         }

         entity.getPersistentData().m_128347_("cnt_target", (double)1.0F);
         entity.getPersistentData().m_128379_("jjkChara", true);
         entity.getPersistentData().m_128379_("UseCursedTechnique", true);
         if ((entity instanceof GojoSatoruEntity || entity instanceof SukunaEntity || entity instanceof SukunaFushiguroEntity || entity instanceof SukunaPerfectEntity || entity instanceof ZeninNaoyaCursedSpiritEntity || entity instanceof CursedSpiritGrade13Entity || entity instanceof ShikigamiPterosaurEntity) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {Attributes:[{Name:generic.follow_range,Base:200}]}");
         }

         if (!(entity instanceof GojoSatoruEntity) && !(entity instanceof SukunaEntity) && !(entity instanceof SukunaFushiguroEntity) && !(entity instanceof SukunaPerfectEntity)) {
            if (entity instanceof ItadoriYujiShinjukuEntity && entity instanceof LivingEntity) {
               LivingEntity _livingEntity25 = (LivingEntity)entity;
               if (_livingEntity25.m_21204_().m_22171_(Attributes.f_22285_)) {
                  _livingEntity25.m_21051_(Attributes.f_22285_).m_22100_((double)10.0F);
               }
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity23 = (LivingEntity)entity;
            if (_livingEntity23.m_21204_().m_22171_(Attributes.f_22285_)) {
               _livingEntity23.m_21051_(Attributes.f_22285_).m_22100_((double)20.0F);
            }
         }

         if (entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity && entity instanceof LivingEntity) {
            LivingEntity _livingEntity27 = (LivingEntity)entity;
            if (_livingEntity27.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
               _livingEntity27.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_((double)2.0F);
            }
         }

         if (entity instanceof CarEntity && entity instanceof CarEntity) {
            CarEntity animatable = (CarEntity)entity;
            RandomSource var10001 = RandomSource.m_216327_();
            animatable.setTexture("car" + Math.round((float)Mth.m_216271_(var10001, 1, 4)));
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 5, 9, false, false));
            }
         }

         for(Entity entityiterator : new ArrayList(world.m_6907_())) {
            if (entity instanceof HigurumaHiromiEntity) {
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _plr33 = (ServerPlayer)entityiterator;
                  if (_plr33.m_9236_() instanceof ServerLevel && _plr33.m_8960_().m_135996_(_plr33.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_hiromi_higuruma"))).m_8193_()) {
                     entity.getPersistentData().m_128379_("JujutsuSorcerer", true);
                     break;
                  }
               }
            } else if (entity instanceof KashimoHajimeEntity) {
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _plr36 = (ServerPlayer)entityiterator;
                  if (_plr36.m_9236_() instanceof ServerLevel && _plr36.m_8960_().m_135996_(_plr36.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_hajime_kashimo"))).m_8193_()) {
                     entity.getPersistentData().m_128379_("JujutsuSorcerer", true);
                     break;
                  }
               }
            } else if (entity instanceof IshigoriRyuEntity) {
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _plr39 = (ServerPlayer)entityiterator;
                  if (_plr39.m_9236_() instanceof ServerLevel && _plr39.m_8960_().m_135996_(_plr39.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_ryu_ishigori"))).m_8193_()) {
                     entity.getPersistentData().m_128379_("JujutsuSorcerer", true);
                     break;
                  }
               }
            } else if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting")))) {
               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _plr42 = (ServerPlayer)entityiterator;
                  if (_plr42.m_9236_() instanceof ServerLevel && _plr42.m_8960_().m_135996_(_plr42.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_choso"))).m_8193_()) {
                     entity.getPersistentData().m_128379_("JujutsuSorcerer", true);
                     break;
                  }
               }
            } else {
               if (!(entity instanceof MiguelEntity) && !(entity instanceof LarueEntity)) {
                  break;
               }

               if (entityiterator instanceof ServerPlayer) {
                  ServerPlayer _plr46 = (ServerPlayer)entityiterator;
                  if (_plr46.m_9236_() instanceof ServerLevel && _plr46.m_8960_().m_135996_(_plr46.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:battle_suguru_geto"))).m_8193_()) {
                     entity.getPersistentData().m_128379_("JujutsuSorcerer", true);
                     entity.getPersistentData().m_128379_("CurseUser", false);
                     break;
                  }
               }
            }
         }

         if (entity instanceof JujutsuSorcererEntity || entity instanceof CurseUserEntity) {
            NUM1 = (double)Math.round((double)10.0F * Math.random() * Math.random());
            if (entity instanceof JujutsuSorcererEntity) {
               if (entity instanceof JujutsuSorcererEntity) {
                  JujutsuSorcererEntity _datEntSetI = (JujutsuSorcererEntity)entity;
                  _datEntSetI.m_20088_().m_135381_(JujutsuSorcererEntity.DATA_power, (int)NUM1);
               }
            } else if (entity instanceof CurseUserEntity && entity instanceof CurseUserEntity) {
               CurseUserEntity _datEntSetI = (CurseUserEntity)entity;
               _datEntSetI.m_20088_().m_135381_(CurseUserEntity.DATA_power, (int)NUM1);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity56 = (LivingEntity)entity;
               if (_livingEntity56.m_21204_().m_22171_(Attributes.f_22276_)) {
                  _livingEntity56.m_21051_(Attributes.f_22276_).m_22100_((double)40.0F + NUM1 * (double)12.0F);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               float var169;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var169 = _livEnt.m_21233_();
               } else {
                  var169 = -1.0F;
               }

               _entity.m_21153_(var169);
            }

            if (Math.random() < (double)0.25F) {
               NUM2 = (double)Math.round(Math.random() * (double)10.0F);
               if (NUM2 == (double)0.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KIRARA_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KIRARA_HELMET.get()));
                  }
               } else if (NUM2 == (double)1.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_HELMET.get()));
                  }
               } else if (NUM2 == (double)2.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.HAIR_FUSHIGURO_MEGUMI_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.HAIR_FUSHIGURO_MEGUMI_HELMET.get()));
                  }
               } else if (NUM2 == (double)3.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_GETO_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_GETO_HELMET.get()));
                  }
               } else if (NUM2 == (double)4.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.SUNGLASSES_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.SUNGLASSES_HELMET.get()));
                  }
               } else if (NUM2 == (double)5.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_JOGO_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_JOGO_HELMET.get()));
                  }
               } else if (NUM2 == (double)6.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_NANAMI_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_NANAMI_HELMET.get()));
                  }
               } else if (NUM2 == (double)7.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_CHOSO_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_CHOSO_HELMET.get()));
                  }
               } else if (NUM2 == (double)8.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_HELMET.get()));
                  }
               } else if (NUM2 == (double)9.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.COSTUME_TAKABA_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.COSTUME_TAKABA_HELMET.get()));
                  }
               } else if (NUM2 == (double)10.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_HELMET.get()));
                  }
               }
            }

            if (Math.random() < (double)0.25F) {
               NUM2 = (double)Math.round(Math.random() * (double)10.0F);
               if (NUM2 == (double)0.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_KASHIMO_HAJIME_BOOTS.get()));
                  }
               } else if (NUM2 == (double)1.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.GLASSES_MAKI_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.GLASSES_MAKI_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.GLASSES_MAKI_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.GLASSES_MAKI_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  }
               } else if (NUM2 == (double)2.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  }
               } else if (NUM2 == (double)3.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  }
               } else if (NUM2 == (double)4.0F) {
                  if (Math.random() < (double)0.5F) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_CHESTPLATE.get()));
                        _player.m_150109_().m_6596_();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_CHESTPLATE.get()));
                     }

                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_LEGGINGS.get()));
                        _player.m_150109_().m_6596_();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_LEGGINGS.get()));
                     }
                  } else {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_2_CHESTPLATE.get()));
                        _player.m_150109_().m_6596_();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_2_CHESTPLATE.get()));
                     }

                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_2_LEGGINGS.get()));
                        _player.m_150109_().m_6596_();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_2_LEGGINGS.get()));
                     }
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                  }
               } else if (NUM2 == (double)5.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.MUSCULAR_BODY_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.MUSCULAR_BODY_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_TODO_AOI_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_TODO_AOI_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                  }
               } else if (NUM2 == (double)6.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ISHIGORI_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()));
                  }
               } else if (NUM2 == (double)7.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_MIGUEL_BOOTS.get()));
                  }
               } else if (NUM2 == (double)8.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_SUKUNA_FUSHIGURO_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_SUKUNA_FUSHIGURO_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
                  }
               } else if (NUM2 == (double)9.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()));
                  }
               } else if (NUM2 == (double)10.0F) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_LEGGINGS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_LEGGINGS.get()));
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_GOJO_BOOTS.get()));
                  }
               }
            }

            if (Math.random() < (double)0.5F) {
               NUM2 = (double)Math.round(Math.random() * (double)10.0F);
               if (NUM2 == (double)0.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SWORD_BLACK.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == (double)1.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SLAUGHTER_DEMON.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == (double)2.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.NAGINATA.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == (double)3.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.NYOI_STAFF.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == (double)4.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SICKLE.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SICKLE.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == (double)5.0F) {
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
               } else if (NUM2 == (double)6.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack(Items.f_42574_)).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack(Items.f_42574_)).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == (double)7.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack(Items.f_42383_)).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == (double)8.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack(Items.f_42386_)).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == (double)9.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack(Items.f_42385_)).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (NUM2 == (double)10.0F && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = (new ItemStack(Items.f_42387_)).m_41777_();
                  _setstack.m_41764_(1);
                  _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }
            }
         }

         if (!(entity instanceof ItadoriYujiShibuyaEntity) && !(entity instanceof ItadoriYujiShinjukuEntity) && !(entity instanceof SukunaEntity) && !(entity instanceof SukunaFushiguroEntity) && !(entity instanceof SukunaPerfectEntity) && !(entity instanceof JogoEntity) && !(entity instanceof JogoAshEntity) && !(entity instanceof MahitoEntity) && !(entity instanceof DagonEntity) && !(entity instanceof HanamiEntity) && !(entity instanceof ChosoEntity) && !(entity instanceof CursedSpiritGrade22Entity) && !(entity instanceof ShigemoHarutaEntity)) {
            if (entity instanceof HigurumaHiromiEntity) {
               place = Component.m_237115_("text.morioka").getString();
               date = Component.m_237115_("jujutsu.message.higuruma_date").getString().replace("yyyy", "2016").replace("MM", GetMonthProcedure.execute("03")).replace("dd", "■■");
               guilt = Component.m_237115_("jujutsu.message.higuruma14").getString().replace("[entity]", "■■■■, ■■■■");
               entity.getPersistentData().m_128347_("kill_count", (double)2.0F);
            } else if (!(entity instanceof ItadoriYujiEntity) && !(entity instanceof NobaraKugisakiEntity)) {
               if (entity instanceof GetoSuguruCurseUserEntity) {
                  place = Component.m_237115_("text.unknown_village1").getString();
                  date = Component.m_237115_("jujutsu.message.higuruma_date").getString().replace("yyyy", "2007").replace("MM", GetMonthProcedure.execute("09")).replace("dd", "9");
                  guilt = Component.m_237115_("jujutsu.message.higuruma15").getString();
                  entity.getPersistentData().m_128347_("kill_count", (double)112.0F);
               } else if (!(entity instanceof KenjakuEntity) && (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:group_3"))) && !(entity instanceof CursedSpiritGrade08Entity) || entity instanceof MiguelEntity || entity instanceof MiguelDancerEntity)) {
                  if (!(entity instanceof HigurumaHiromiEntity) && !(entity instanceof KashimoHajimeEntity) && !(entity instanceof ReggieStarEntity) && !(entity instanceof HazenokiEntity) && !(entity instanceof HabaEntity) && !(entity instanceof HanyuEntity)) {
                     if (!(entity instanceof IshigoriRyuEntity) && !(entity instanceof UroTakakoEntity) && !(entity instanceof DhruvLakdawallaEntity) && !(entity instanceof CursedSpiritGrade04Entity)) {
                        registry_name = ForgeRegistries.ENTITY_TYPES.getKey(entity.m_6095_()).toString();
                        if (registry_name.contains("cursed_spirit_grade_0")) {
                           entity.getPersistentData().m_128347_("kill_count", (double)Mth.m_216271_(RandomSource.m_216327_(), 10, 20));
                        } else if (registry_name.contains("cursed_spirit_grade_1")) {
                           entity.getPersistentData().m_128347_("kill_count", (double)Mth.m_216271_(RandomSource.m_216327_(), 5, 10));
                        } else if (registry_name.contains("cursed_spirit_grade_2")) {
                           entity.getPersistentData().m_128347_("kill_count", (double)Mth.m_216271_(RandomSource.m_216327_(), 0, 3));
                        } else if (registry_name.contains("cursed_spirit_grade_3")) {
                           entity.getPersistentData().m_128347_("kill_count", (double)Mth.m_216271_(RandomSource.m_216327_(), 0, 1));
                        } else if (entity.getPersistentData().m_128471_("CurseUser") || !entity.getPersistentData().m_128471_("JujutsuSorcerer")) {
                           entity.getPersistentData().m_128347_("kill_count", (double)Mth.m_216271_(RandomSource.m_216327_(), 0, 1));
                        }

                        if (entity.getPersistentData().m_128459_("kill_count") > (double)0.0F) {
                           place = "■■";
                           date = Component.m_237115_("jujutsu.message.higuruma_date").getString().replace("yyyy", "■■■■").replace("MM", "■■").replace("dd", "■■");
                           guilt = entity.getPersistentData().m_128459_("kill_count") >= (double)3.0F ? Component.m_237115_("jujutsu.message.higuruma15").getString() : Component.m_237115_("jujutsu.message.higuruma14").getString().replace("[entity]", "■■■■");
                        }
                     } else {
                        place = Component.m_237115_("text.miyagi").getString();
                        String var168 = Component.m_237115_("jujutsu.message.higuruma_date").getString().replace("yyyy", "2018").replace("MM", "11").replace("dd", "1");
                        date = var168 + "-" + Component.m_237115_("jujutsu.message.higuruma_date").getString().replace("yyyy", "2018").replace("MM", "11").replace("dd", "12");
                        guilt = Component.m_237115_("jujutsu.message.higuruma15").getString();
                        entity.getPersistentData().m_128347_("kill_count", (double)20.0F);
                     }
                  } else {
                     place = Component.m_237115_("text.tokyo").getString();
                     String var167 = Component.m_237115_("jujutsu.message.higuruma_date").getString().replace("yyyy", "2018").replace("MM", "11").replace("dd", "1");
                     date = var167 + "-" + Component.m_237115_("jujutsu.message.higuruma_date").getString().replace("yyyy", "2018").replace("MM", "11").replace("dd", "12");
                     guilt = Component.m_237115_("jujutsu.message.higuruma15").getString();
                     entity.getPersistentData().m_128347_("kill_count", (double)20.0F);
                  }
               } else {
                  if (entity instanceof CursedSpiritGrade08Entity) {
                     place = Component.m_237115_("text.kyoto").getString();
                  } else {
                     place = entity instanceof KenjakuEntity ? Component.m_237115_("text.shinjuku").getString() + ", " + Component.m_237115_("text.kyoto").getString() : Component.m_237115_("text.shinjuku").getString();
                  }

                  date = Component.m_237115_("jujutsu.message.higuruma_date").getString().replace("yyyy", "2017").replace("MM", GetMonthProcedure.execute("12")).replace("dd", "24");
                  guilt = Component.m_237115_("jujutsu.message.higuruma15").getString();
                  entity.getPersistentData().m_128347_("kill_count", (double)200.0F);
               }
            } else {
               place = Component.m_237115_("text.saitama").getString();
               date = Component.m_237115_("jujutsu.message.higuruma_date").getString().replace("yyyy", "2018").replace("MM", GetMonthProcedure.execute("06")).replace("dd", "9");
               String var166 = Component.m_237115_("jujutsu.message.higuruma14").getString();
               String var10002 = Component.m_237115_("entity.jujutsucraft.eso").getString();
               guilt = var166.replace("[entity]", var10002 + ", " + Component.m_237115_("entity.jujutsucraft.kechizu").getString());
               entity.getPersistentData().m_128347_("kill_count", (double)2.0F);
            }
         } else {
            place = Component.m_237115_("text.shibuya").getString();
            date = Component.m_237115_("jujutsu.message.higuruma_date").getString().replace("yyyy", "2018").replace("MM", GetMonthProcedure.execute("10")).replace("dd", "31");
            guilt = Component.m_237115_("jujutsu.message.higuruma15").getString();
            entity.getPersistentData().m_128347_("kill_count", (double)100.0F);
         }

         if (entity.getPersistentData().m_128459_("kill_count") > (double)0.0F) {
            entity.getPersistentData().m_128359_("crime1", Component.m_237115_("jujutsu.message.higuruma10").getString().replace("[guilt]", guilt).replace("[date]", date).replace("[place]", place));
         }

         JujutsucraftMod.queueServerWork(1, () -> {
            if (entity.getPersistentData().m_128459_("friend_num") != (double)0.0F) {
               entity.getPersistentData().m_128359_("crime1", "");
            }

         });
      }
   }
}
