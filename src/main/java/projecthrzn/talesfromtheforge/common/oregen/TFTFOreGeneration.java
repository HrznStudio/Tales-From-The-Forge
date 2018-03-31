package projecthrzn.talesfromtheforge.common.oregen;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import projecthrzn.talesfromtheforge.common.blocks.TFTFBlocks;
import projecthrzn.talesfromtheforge.util.TFTFConfigs.TFTFConfig.OreGen;

import java.util.Random;

public class TFTFOreGeneration implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == 0) {
            Overworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
    }

    private void Overworld(Random random, int chunkX, int chunkY, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (OreGen.Calcopyrite.shouldGenerate) {
            generateOre(TFTFBlocks.oreChalcopyrite, world, random, chunkX * 16, chunkY * 16, OreGen.Calcopyrite.minY, OreGen.Calcopyrite.maxY, OreGen.Calcopyrite.veinSize, OreGen.Calcopyrite.Chance);
        }
        if (OreGen.Cassiterite.shouldGenerate) {
            generateOre(TFTFBlocks.oreCassiterite, world, random, chunkX * 16, chunkY * 16, OreGen.Cassiterite.minY, OreGen.Cassiterite.maxY, OreGen.Cassiterite.veinSize, OreGen.Cassiterite.Chance);
        }
        if (OreGen.Digenite.shouldGenerate) {
            generateOre(TFTFBlocks.oreDigenite, world, random, chunkX * 16, chunkY * 16, OreGen.Digenite.minY, OreGen.Digenite.maxY, OreGen.Digenite.veinSize, OreGen.Digenite.Chance);
        }
        if (OreGen.Galena.shouldGenerate) {
            generateOre(TFTFBlocks.oreGalena, world, random, chunkX * 16, chunkY * 16, OreGen.Galena.minY, OreGen.Galena.maxY, OreGen.Galena.veinSize, OreGen.Galena.Chance);
        }
        if (OreGen.Sphalerite.shouldGenerate) {
            generateOre(TFTFBlocks.oreSphalerite, world, random, chunkX * 16, chunkY * 16, OreGen.Sphalerite.minY, OreGen.Sphalerite.maxY, OreGen.Sphalerite.veinSize, OreGen.Sphalerite.Chance);
        }

    }

    private void generateOre(Block block, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) {
        int deltaY = maxY - minY;
        for (int i = 0; i < chances; i++) {
            BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
            WorldGenMinable generator = new WorldGenMinable(block.getDefaultState(), size);
            generator.generate(world, random, pos);
        }
    }
}
