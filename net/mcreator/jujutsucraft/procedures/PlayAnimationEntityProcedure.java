package net.mcreator.jujutsucraft.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import software.bernie.geckolib.animatable.GeoEntity;

@EventBusSubscriber
public class PlayAnimationEntityProcedure {
   @SubscribeEvent
   public static void onEntityAttacked(LivingAttackEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getSource(), event.getEntity());
      }

   }

   public static void execute(DamageSource damagesource, Entity entity) {
      execute((Event)null, damagesource, entity);
   }

   private static void execute(@Nullable Event event, DamageSource damagesource, Entity entity) {
      if (damagesource != null && entity != null) {
         boolean sword = false;
         double NUM2 = (double)0.0F;
         double NUM3 = (double)0.0F;
         double NUM1 = (double)0.0F;
         double rnd = (double)0.0F;
         String ANIME_NAME = "";
         String STR1 = "";
         if (damagesource.m_276093_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:start_animation"))) && entity instanceof GeoEntity && entity instanceof LivingEntity) {
            LivingEntity _livingEntity2 = (LivingEntity)entity;
            if (_livingEntity2.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               double var10000;
               label341: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity3 = (LivingEntity)entity;
                     if (_livingEntity3.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        var10000 = _livingEntity3.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22115_();
                        break label341;
                     }
                  }

                  var10000 = (double)0.0F;
               }

               label336: {
                  NUM1 = var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity4 = (LivingEntity)entity;
                     if (_livingEntity4.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        var10000 = _livingEntity4.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22115_();
                        break label336;
                     }
                  }

                  var10000 = (double)0.0F;
               }

               NUM2 = var10000;
               NUM1 += (double)(NUM1 <= (double)-50.0F && NUM1 >= (double)-100.0F ? 100 : 0);
               NUM3 = NUM1 >= (double)0.0F ? NUM1 % (double)100.0F : (double)100.0F;
               sword = LogicSwordProcedure.execute(entity);
               STR1 = GetEntityAnimationProcedure.execute(entity);
               if (STR1.contains("_right")) {
                  STR1 = "left";
               } else if (STR1.contains("_left")) {
                  STR1 = "right";
               } else {
                  STR1 = Math.random() > (double)0.5F ? "right" : "left";
               }

               if (NUM3 >= (double)0.0F && NUM3 <= (double)4.0F) {
                  if (sword && NUM2 > (double)0.0F) {
                     if (NUM2 != (double)1.0F && NUM2 != (double)2.0F && NUM2 != (double)3.0F) {
                        if (NUM2 == (double)4.0F || NUM2 == (double)5.0F || NUM2 == (double)6.0F) {
                           STR1 = "left";
                        }
                     } else {
                        STR1 = "right";
                     }
                  }

                  if (NUM3 != (double)0.0F && NUM3 != (double)2.0F && NUM3 != (double)3.0F) {
                     if (NUM3 == (double)1.0F) {
                        if (sword) {
                           ANIME_NAME = "sword_to_right";
                        } else {
                           String var28 = Math.random() < (double)0.25F ? "punch_" : "kick_";
                           ANIME_NAME = var28 + STR1;
                        }
                     } else if (NUM3 == (double)4.0F) {
                        if (NUM2 == (double)0.0F) {
                           ANIME_NAME = sword ? "sword_overhead" : "punch_overhead";
                        } else if (NUM2 == (double)1.0F) {
                           ANIME_NAME = sword ? "sword_overhead2" : "punch_overhead2";
                        } else if (NUM2 == (double)2.0F) {
                           ANIME_NAME = "punch_overhead";
                        } else if (NUM2 == (double)3.0F) {
                           ANIME_NAME = "punch_overhead2";
                        } else if (NUM2 == (double)4.0F) {
                           ANIME_NAME = "sword_overhead";
                        } else if (NUM2 == (double)5.0F) {
                           ANIME_NAME = "sword_overhead2";
                        }
                     }
                  } else if (sword) {
                     ANIME_NAME = "sword_to_" + STR1;
                  } else {
                     String var27 = !(Math.random() < (double)0.25F) && (!(NUM2 > (double)0.0F) || !(NUM2 < (double)100.0F)) ? "kick_" : "punch_";
                     ANIME_NAME = var27 + STR1;
                  }
               } else if (NUM3 == (double)20.0F) {
                  if (NUM1 == (double)220.0F) {
                     ANIME_NAME = "red";
                  } else {
                     ANIME_NAME = "domain_expansion1";
                  }
               } else if (NUM1 < (double)0.0F) {
                  if (NUM1 >= (double)-10.0F) {
                     if (NUM1 == (double)-1.0F) {
                        ANIME_NAME = "backstep";
                     } else if (NUM1 == (double)-2.0F) {
                        ANIME_NAME = "death";
                     } else if (NUM1 == (double)-3.0F) {
                        ANIME_NAME = "right_arm_up";
                     } else if (NUM1 == (double)-4.0F) {
                        ANIME_NAME = "both_arm_front";
                     } else if (NUM1 == (double)-5.0F) {
                        if (NUM2 == (double)0.0F) {
                           ANIME_NAME = "sword_to_right";
                        } else if (NUM2 == (double)1.0F) {
                           ANIME_NAME = "sword_to_left";
                        }
                     }

                     if (NUM1 == (double)-6.0F) {
                        if (NUM2 == (double)0.0F) {
                           ANIME_NAME = "kick_" + STR1;
                        } else if (NUM2 == (double)1.0F) {
                           ANIME_NAME = "kashimo_kick";
                        } else if (NUM2 == (double)2.0F) {
                           ANIME_NAME = "kick_right";
                        } else if (NUM2 == (double)3.0F) {
                           ANIME_NAME = "kick_left";
                        } else if (NUM2 == (double)4.0F) {
                           ANIME_NAME = "kick_rotate4";
                        }
                     } else if (NUM1 == (double)-7.0F) {
                        if (NUM2 == (double)0.0F) {
                           ANIME_NAME = "punch_" + STR1;
                        } else if (NUM2 == (double)1.0F) {
                           ANIME_NAME = "combo1";
                        } else if (NUM2 == (double)2.0F) {
                           ANIME_NAME = "combo2";
                        } else if (NUM2 == (double)3.0F) {
                           ANIME_NAME = "combo3";
                        }
                     } else if (NUM1 == (double)-8.0F) {
                        if (NUM2 == (double)0.0F) {
                           ANIME_NAME = "rotation";
                        } else if (NUM2 == (double)1.0F) {
                           ANIME_NAME = "rotation2";
                        } else if (NUM2 == (double)2.0F) {
                           ANIME_NAME = "ragnaraku2";
                        }
                     } else if (NUM1 == (double)-9.0F) {
                        ANIME_NAME = "guard";
                     } else if (NUM1 == (double)-10.0F) {
                        ANIME_NAME = "fall1";
                     }
                  } else if (NUM1 >= (double)-15.0F) {
                     ANIME_NAME = "dance" + Math.round(NUM1 + (double)16.0F);
                  } else if (NUM1 >= (double)-20.0F) {
                     if (NUM1 == (double)-16.0F) {
                        ANIME_NAME = NUM2 == (double)0.0F ? "simple_domain1" : "simple_domain2";
                     } else if (NUM1 == (double)-17.0F) {
                        ANIME_NAME = "clap";
                     } else if (NUM1 == (double)-18.0F) {
                        ANIME_NAME = "fly";
                     } else if (NUM1 == (double)-19.0F) {
                        if (NUM2 == (double)0.0F) {
                           ANIME_NAME = "breath1";
                        } else if (NUM2 == (double)1.0F) {
                           ANIME_NAME = "breath2";
                        }
                     } else if (NUM1 == (double)-20.0F) {
                        if (NUM2 == (double)0.0F) {
                           ANIME_NAME = "step_back";
                        } else if (NUM2 == (double)1.0F) {
                           ANIME_NAME = "step_right";
                        } else if (NUM2 == (double)2.0F) {
                           ANIME_NAME = "step_left";
                        } else if (NUM2 == (double)3.0F) {
                           ANIME_NAME = "step_front";
                        }
                     }
                  } else if (NUM1 >= (double)-25.0F) {
                     if (NUM1 == (double)-21.0F) {
                        ANIME_NAME = "invisibility";
                     } else if (NUM1 == (double)-22.0F && NUM2 == (double)1.0F) {
                        ANIME_NAME = "swim_butterfly";
                     }
                  }

                  if (NUM1 == (double)-49.0F) {
                     ANIME_NAME = "empty";
                  }
               } else {
                  if (NUM1 == (double)107.0F) {
                     ANIME_NAME = "open";
                  } else if (NUM1 == (double)207.0F) {
                     ANIME_NAME = "red";
                  } else if (NUM1 == (double)215.0F) {
                     if (NUM2 == (double)0.0F) {
                        ANIME_NAME = "charge1";
                     } else if (NUM2 == (double)1.0F) {
                        ANIME_NAME = "charge2";
                     }
                  } else if (NUM1 == (double)618.0F) {
                     ANIME_NAME = "ten_shadows_technique_mahoraga";
                  }

                  if (NUM1 == (double)406.0F) {
                     ANIME_NAME = "burn_out";
                  } else if (NUM1 == (double)415.0F) {
                     ANIME_NAME = "meteor";
                  }

                  if (NUM1 == (double)1706.0F) {
                     ANIME_NAME = "kick_flying";
                  } else if (NUM1 == (double)1715.0F) {
                     ANIME_NAME = "wifi";
                  } else if (NUM1 == (double)2015.0F) {
                     ANIME_NAME = "plus_ultra";
                  }
               }

               if (!ANIME_NAME.isEmpty()) {
                  PlayAnimationEntity2Procedure.execute(entity, ANIME_NAME);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity5 = (LivingEntity)entity;
                  if (_livingEntity5.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity5.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)0.0F);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity6 = (LivingEntity)entity;
                  if (_livingEntity6.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity6.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                  }
               }

               if (event != null && event.isCancelable()) {
                  event.setCanceled(true);
               }
            }
         }

      }
   }
}
