package net.mcreator.jujutsucraft.init;

import net.mcreator.jujutsucraft.item.BlackRopeItem;
import net.mcreator.jujutsucraft.item.DeathPaintingItem;
import net.mcreator.jujutsucraft.item.ExecutionersSwordItem;
import net.mcreator.jujutsucraft.item.GavelBigItem;
import net.mcreator.jujutsucraft.item.GavelItem;
import net.mcreator.jujutsucraft.item.GavelLongItem;
import net.mcreator.jujutsucraft.item.MahitoHand1Item;
import net.mcreator.jujutsucraft.item.PlayfulCloudItem;
import net.mcreator.jujutsucraft.item.SwordOptionItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import software.bernie.geckolib.animatable.GeoItem;

@EventBusSubscriber
public class ItemAnimationFactory {
   @SubscribeEvent
   public static void animatedItems(TickEvent.PlayerTickEvent event) {
      String animation = "";
      ItemStack mainhandItem = event.player.m_21205_().m_41777_();
      ItemStack offhandItem = event.player.m_21206_().m_41777_();
      if (event.phase == Phase.START && (mainhandItem.m_41720_() instanceof GeoItem || offhandItem.m_41720_() instanceof GeoItem)) {
         Item var5 = mainhandItem.m_41720_();
         if (var5 instanceof GavelItem) {
            GavelItem animatable = (GavelItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((GavelItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof GavelItem) {
            GavelItem animatable = (GavelItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((GavelItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         if (var5 instanceof ExecutionersSwordItem) {
            ExecutionersSwordItem animatable = (ExecutionersSwordItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((ExecutionersSwordItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof ExecutionersSwordItem) {
            ExecutionersSwordItem animatable = (ExecutionersSwordItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((ExecutionersSwordItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         if (var5 instanceof SwordOptionItem) {
            SwordOptionItem animatable = (SwordOptionItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((SwordOptionItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof SwordOptionItem) {
            SwordOptionItem animatable = (SwordOptionItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((SwordOptionItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         if (var5 instanceof PlayfulCloudItem) {
            PlayfulCloudItem animatable = (PlayfulCloudItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((PlayfulCloudItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof PlayfulCloudItem) {
            PlayfulCloudItem animatable = (PlayfulCloudItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((PlayfulCloudItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         if (var5 instanceof BlackRopeItem) {
            BlackRopeItem animatable = (BlackRopeItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((BlackRopeItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof BlackRopeItem) {
            BlackRopeItem animatable = (BlackRopeItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((BlackRopeItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         if (var5 instanceof MahitoHand1Item) {
            MahitoHand1Item animatable = (MahitoHand1Item)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((MahitoHand1Item)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof MahitoHand1Item) {
            MahitoHand1Item animatable = (MahitoHand1Item)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((MahitoHand1Item)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         if (var5 instanceof DeathPaintingItem) {
            DeathPaintingItem animatable = (DeathPaintingItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((DeathPaintingItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof DeathPaintingItem) {
            DeathPaintingItem animatable = (DeathPaintingItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((DeathPaintingItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         if (var5 instanceof GavelLongItem) {
            GavelLongItem animatable = (GavelLongItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((GavelLongItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof GavelLongItem) {
            GavelLongItem animatable = (GavelLongItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((GavelLongItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         if (var5 instanceof GavelBigItem) {
            GavelBigItem animatable = (GavelBigItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((GavelBigItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof GavelBigItem) {
            GavelBigItem animatable = (GavelBigItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((GavelBigItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }
      }

   }
}
