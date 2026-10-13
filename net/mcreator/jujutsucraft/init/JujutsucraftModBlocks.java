package net.mcreator.jujutsucraft.init;

import net.mcreator.jujutsucraft.block.BlockGravelBlock;
import net.mcreator.jujutsucraft.block.BlockRedBlock;
import net.mcreator.jujutsucraft.block.BlockUniverseBlock;
import net.mcreator.jujutsucraft.block.CoffinoftheIronmountain1Block;
import net.mcreator.jujutsucraft.block.CoffinoftheIronmountain2Block;
import net.mcreator.jujutsucraft.block.CursedBlockBlock;
import net.mcreator.jujutsucraft.block.DomainBlock;
import net.mcreator.jujutsucraft.block.DomainBloodBlock;
import net.mcreator.jujutsucraft.block.DomainBlueSkyBlock;
import net.mcreator.jujutsucraft.block.DomainBoneBlock;
import net.mcreator.jujutsucraft.block.DomainCloudBlock;
import net.mcreator.jujutsucraft.block.DomainDarkStoneBlock;
import net.mcreator.jujutsucraft.block.DomainFenceBlock;
import net.mcreator.jujutsucraft.block.DomainFlowerBlock;
import net.mcreator.jujutsucraft.block.DomainGrassBlock;
import net.mcreator.jujutsucraft.block.DomainHoleBlock;
import net.mcreator.jujutsucraft.block.DomainIceBlock;
import net.mcreator.jujutsucraft.block.DomainPlanksBlock;
import net.mcreator.jujutsucraft.block.DomainPodzolBlock;
import net.mcreator.jujutsucraft.block.DomainSandBlackBlock;
import net.mcreator.jujutsucraft.block.DomainSandBlock;
import net.mcreator.jujutsucraft.block.DomainStoneBricksBlock;
import net.mcreator.jujutsucraft.block.DomainWaterBlock;
import net.mcreator.jujutsucraft.block.DomainWhiteBlock;
import net.mcreator.jujutsucraft.block.InBarrierBlock;
import net.mcreator.jujutsucraft.block.JujutsuBarrierBlock;
import net.mcreator.jujutsucraft.block.SchoolBellBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JujutsucraftModBlocks {
   public static final DeferredRegister<Block> REGISTRY;
   public static final RegistryObject<Block> JUJUTSU_BARRIER;
   public static final RegistryObject<Block> COFFINOFTHE_IRONMOUNTAIN_1;
   public static final RegistryObject<Block> COFFINOFTHE_IRONMOUNTAIN_2;
   public static final RegistryObject<Block> BLOCK_GRAVEL;
   public static final RegistryObject<Block> BLOCK_UNIVERSE;
   public static final RegistryObject<Block> IN_BARRIER;
   public static final RegistryObject<Block> BLOCK_RED;
   public static final RegistryObject<Block> DOMAIN_GRASS;
   public static final RegistryObject<Block> DOMAIN_SAND;
   public static final RegistryObject<Block> DOMAIN_WATER;
   public static final RegistryObject<Block> DOMAIN_BONE;
   public static final RegistryObject<Block> SCHOOL_BELL;
   public static final RegistryObject<Block> DOMAIN_FLOWER;
   public static final RegistryObject<Block> DOMAIN_BLUE_SKY;
   public static final RegistryObject<Block> DOMAIN_CLOUD;
   public static final RegistryObject<Block> DOMAIN_STONE_BRICKS;
   public static final RegistryObject<Block> CURSED_BLOCK;
   public static final RegistryObject<Block> DOMAIN_ICE;
   public static final RegistryObject<Block> DOMAIN_BLOOD;
   public static final RegistryObject<Block> DOMAIN_PLANKS;
   public static final RegistryObject<Block> DOMAIN_PODZOL;
   public static final RegistryObject<Block> DOMAIN_WHITE;
   public static final RegistryObject<Block> DOMAIN;
   public static final RegistryObject<Block> DOMAIN_DARK_STONE;
   public static final RegistryObject<Block> DOMAIN_FENCE;
   public static final RegistryObject<Block> DOMAIN_HOLE;
   public static final RegistryObject<Block> DOMAIN_SAND_BLACK;

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, "jujutsucraft");
      JUJUTSU_BARRIER = REGISTRY.register("jujutsu_barrier", () -> new JujutsuBarrierBlock());
      COFFINOFTHE_IRONMOUNTAIN_1 = REGISTRY.register("coffinofthe_ironmountain_1", () -> new CoffinoftheIronmountain1Block());
      COFFINOFTHE_IRONMOUNTAIN_2 = REGISTRY.register("coffinofthe_ironmountain_2", () -> new CoffinoftheIronmountain2Block());
      BLOCK_GRAVEL = REGISTRY.register("block_gravel", () -> new BlockGravelBlock());
      BLOCK_UNIVERSE = REGISTRY.register("block_universe", () -> new BlockUniverseBlock());
      IN_BARRIER = REGISTRY.register("in_barrier", () -> new InBarrierBlock());
      BLOCK_RED = REGISTRY.register("block_red", () -> new BlockRedBlock());
      DOMAIN_GRASS = REGISTRY.register("domain_grass", () -> new DomainGrassBlock());
      DOMAIN_SAND = REGISTRY.register("domain_sand", () -> new DomainSandBlock());
      DOMAIN_WATER = REGISTRY.register("domain_water", () -> new DomainWaterBlock());
      DOMAIN_BONE = REGISTRY.register("domain_bone", () -> new DomainBoneBlock());
      SCHOOL_BELL = REGISTRY.register("school_bell", () -> new SchoolBellBlock());
      DOMAIN_FLOWER = REGISTRY.register("domain_flower", () -> new DomainFlowerBlock());
      DOMAIN_BLUE_SKY = REGISTRY.register("domain_blue_sky", () -> new DomainBlueSkyBlock());
      DOMAIN_CLOUD = REGISTRY.register("domain_cloud", () -> new DomainCloudBlock());
      DOMAIN_STONE_BRICKS = REGISTRY.register("domain_stone_bricks", () -> new DomainStoneBricksBlock());
      CURSED_BLOCK = REGISTRY.register("cursed_block", () -> new CursedBlockBlock());
      DOMAIN_ICE = REGISTRY.register("domain_ice", () -> new DomainIceBlock());
      DOMAIN_BLOOD = REGISTRY.register("domain_blood", () -> new DomainBloodBlock());
      DOMAIN_PLANKS = REGISTRY.register("domain_planks", () -> new DomainPlanksBlock());
      DOMAIN_PODZOL = REGISTRY.register("domain_podzol", () -> new DomainPodzolBlock());
      DOMAIN_WHITE = REGISTRY.register("domain_white", () -> new DomainWhiteBlock());
      DOMAIN = REGISTRY.register("domain", () -> new DomainBlock());
      DOMAIN_DARK_STONE = REGISTRY.register("domain_dark_stone", () -> new DomainDarkStoneBlock());
      DOMAIN_FENCE = REGISTRY.register("domain_fence", () -> new DomainFenceBlock());
      DOMAIN_HOLE = REGISTRY.register("domain_hole", () -> new DomainHoleBlock());
      DOMAIN_SAND_BLACK = REGISTRY.register("domain_sand_black", () -> new DomainSandBlackBlock());
   }

   @EventBusSubscriber(
      bus = Bus.MOD,
      value = {Dist.CLIENT}
   )
   public static class BlocksClientSideHandler {
      @SubscribeEvent
      public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
         DomainGrassBlock.blockColorLoad(event);
         DomainPodzolBlock.blockColorLoad(event);
      }

      @SubscribeEvent
      public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
         DomainGrassBlock.itemColorLoad(event);
         DomainPodzolBlock.itemColorLoad(event);
      }
   }
}
