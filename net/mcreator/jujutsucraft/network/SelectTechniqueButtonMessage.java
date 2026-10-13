package net.mcreator.jujutsucraft.network;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import net.mcreator.jujutsucraft.JujutsucraftMod;
import net.mcreator.jujutsucraft.procedures.PageNextProcedure;
import net.mcreator.jujutsucraft.procedures.SelectAngelProcedure;
import net.mcreator.jujutsucraft.procedures.SelectChojuroProcedure;
import net.mcreator.jujutsucraft.procedures.SelectChosoProcedure;
import net.mcreator.jujutsucraft.procedures.SelectDagonProcedure;
import net.mcreator.jujutsucraft.procedures.SelectDhruvLakdawallaProcedure;
import net.mcreator.jujutsucraft.procedures.SelectFushiguroProcedure;
import net.mcreator.jujutsucraft.procedures.SelectGetoProcedure;
import net.mcreator.jujutsucraft.procedures.SelectGojoProcedure;
import net.mcreator.jujutsucraft.procedures.SelectHakariProcedure;
import net.mcreator.jujutsucraft.procedures.SelectHanamiProcedure;
import net.mcreator.jujutsucraft.procedures.SelectHazenokiProcedure;
import net.mcreator.jujutsucraft.procedures.SelectHigurumaProcedure;
import net.mcreator.jujutsucraft.procedures.SelectInoProcedure;
import net.mcreator.jujutsucraft.procedures.SelectInumakiProcedure;
import net.mcreator.jujutsucraft.procedures.SelectIshigoriProcedure;
import net.mcreator.jujutsucraft.procedures.SelectItadoriProcedure;
import net.mcreator.jujutsucraft.procedures.SelectJinichiProcedure;
import net.mcreator.jujutsucraft.procedures.SelectJogoProcedure;
import net.mcreator.jujutsucraft.procedures.SelectJunpeProcedure;
import net.mcreator.jujutsucraft.procedures.SelectKaoriProcedure;
import net.mcreator.jujutsucraft.procedures.SelectKashimoProcedure;
import net.mcreator.jujutsucraft.procedures.SelectKugisakiProcedure;
import net.mcreator.jujutsucraft.procedures.SelectKurourushiProcedure;
import net.mcreator.jujutsucraft.procedures.SelectKusakabeProcedure;
import net.mcreator.jujutsucraft.procedures.SelectMahitoProcedure;
import net.mcreator.jujutsucraft.procedures.SelectMahoragaProcedure;
import net.mcreator.jujutsucraft.procedures.SelectMakiProcedure;
import net.mcreator.jujutsucraft.procedures.SelectMeiMeiProcedure;
import net.mcreator.jujutsucraft.procedures.SelectMiguelProcedure;
import net.mcreator.jujutsucraft.procedures.SelectNanamiProcedure;
import net.mcreator.jujutsucraft.procedures.SelectNaoyaProcedure;
import net.mcreator.jujutsucraft.procedures.SelectNishimiyaProcedure;
import net.mcreator.jujutsucraft.procedures.SelectNonSorcererProcedure;
import net.mcreator.jujutsucraft.procedures.SelectOgiProcedure;
import net.mcreator.jujutsucraft.procedures.SelectOkkotsuProcedure;
import net.mcreator.jujutsucraft.procedures.SelectRandomProcedure;
import net.mcreator.jujutsucraft.procedures.SelectRantaProcedure;
import net.mcreator.jujutsucraft.procedures.SelectReggieStarProcedure;
import net.mcreator.jujutsucraft.procedures.SelectSukunaProcedure;
import net.mcreator.jujutsucraft.procedures.SelectTakabaProcedure;
import net.mcreator.jujutsucraft.procedures.SelectTakakoUroProcedure;
import net.mcreator.jujutsucraft.procedures.SelectTodoProcedure;
import net.mcreator.jujutsucraft.procedures.SelectTsukumoProcedure;
import net.mcreator.jujutsucraft.procedures.SelectUraumeProcedure;
import net.mcreator.jujutsucraft.procedures.SelectYagaProcedure;
import net.mcreator.jujutsucraft.procedures.SelectYorozuProcedure;
import net.mcreator.jujutsucraft.world.inventory.SelectTechniqueMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class SelectTechniqueButtonMessage {
   private final int buttonID;
   private final int x;
   private final int y;
   private final int z;
   private HashMap<String, String> textstate;

   public SelectTechniqueButtonMessage(FriendlyByteBuf buffer) {
      this.buttonID = buffer.readInt();
      this.x = buffer.readInt();
      this.y = buffer.readInt();
      this.z = buffer.readInt();
      this.textstate = readTextState(buffer);
   }

   public SelectTechniqueButtonMessage(int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
      this.buttonID = buttonID;
      this.x = x;
      this.y = y;
      this.z = z;
      this.textstate = textstate;
   }

   public static void buffer(SelectTechniqueButtonMessage message, FriendlyByteBuf buffer) {
      buffer.writeInt(message.buttonID);
      buffer.writeInt(message.x);
      buffer.writeInt(message.y);
      buffer.writeInt(message.z);
      writeTextState(message.textstate, buffer);
   }

   public static void handler(SelectTechniqueButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
      NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
      context.enqueueWork(() -> {
         Player entity = context.getSender();
         int buttonID = message.buttonID;
         int x = message.x;
         int y = message.y;
         int z = message.z;
         HashMap<String, String> textstate = message.textstate;
         handleButtonAction(entity, buttonID, x, y, z, textstate);
      });
      context.setPacketHandled(true);
   }

   public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
      Level world = entity.m_9236_();
      HashMap guistate = SelectTechniqueMenu.guistate;

      for(Map.Entry<String, String> entry : textstate.entrySet()) {
         String key = (String)entry.getKey();
         String value = (String)entry.getValue();
         guistate.put(key, value);
      }

      if (world.m_46805_(new BlockPos(x, y, z))) {
         if (buttonID == 0) {
            SelectRandomProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 1) {
            SelectGojoProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 2) {
            SelectFushiguroProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 3) {
            SelectMakiProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 4) {
            SelectSukunaProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 5) {
            SelectInumakiProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 6) {
            SelectOkkotsuProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 7) {
            SelectJogoProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 8) {
            SelectKashimoProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 9) {
            SelectDagonProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 10) {
            SelectTsukumoProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 11) {
            SelectChosoProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 12) {
            SelectMeiMeiProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 13) {
            SelectIshigoriProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 14) {
            SelectNanamiProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 15) {
            SelectHanamiProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 16) {
            SelectMahitoProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 17) {
            SelectMahoragaProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 18) {
            SelectNonSorcererProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 19) {
            SelectTakabaProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 20) {
            SelectGetoProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 21) {
            SelectNaoyaProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 22) {
            SelectTodoProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 23) {
            SelectItadoriProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 24) {
            SelectJinichiProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 25) {
            SelectKurourushiProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 26) {
            SelectUraumeProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 27) {
            SelectOgiProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 28) {
            SelectHigurumaProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 29) {
            SelectAngelProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 30) {
            SelectHakariProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 31) {
            SelectMiguelProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 32) {
            SelectKusakabeProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 33) {
            SelectChojuroProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 34) {
            SelectYagaProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 35) {
            SelectKugisakiProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 36) {
            SelectJunpeProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 37) {
            SelectNishimiyaProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 38) {
            SelectDhruvLakdawallaProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 39) {
            SelectYorozuProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 40) {
            SelectTakakoUroProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 41) {
            SelectInoProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 42) {
            SelectKaoriProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 43) {
            SelectReggieStarProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 44) {
            SelectHazenokiProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 45) {
            SelectRantaProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 46) {
            PageNextProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

      }
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      JujutsucraftMod.addNetworkMessage(SelectTechniqueButtonMessage.class, SelectTechniqueButtonMessage::buffer, SelectTechniqueButtonMessage::new, SelectTechniqueButtonMessage::handler);
   }

   public static void writeTextState(HashMap<String, String> map, FriendlyByteBuf buffer) {
      buffer.writeInt(map.size());

      for(Map.Entry<String, String> entry : map.entrySet()) {
         buffer.m_130083_(Component.m_237113_((String)entry.getKey()));
         buffer.m_130083_(Component.m_237113_((String)entry.getValue()));
      }

   }

   public static HashMap<String, String> readTextState(FriendlyByteBuf buffer) {
      int size = buffer.readInt();
      HashMap<String, String> map = new HashMap();

      for(int i = 0; i < size; ++i) {
         String key = buffer.m_130238_().getString();
         String value = buffer.m_130238_().getString();
         map.put(key, value);
      }

      return map;
   }
}
