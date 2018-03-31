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

    private void Overworld(Random random, int chunkX, int chunkY, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider){
        if (OreGen.Calcopyrite){
            generateOre(TFTFBlocks.oreChalcopyrite, world, random, chunkX * 16, chunkY * 16, OreGen.calcopyriteMinY, OreGen.calcopyriteMaxY, OreGen.calcopyriteVeinSize, OreGen.calcopyriteChances);
        }
        if (OreGen.Cassiterite){
            generateOre(TFTFBlocks.oreCassiterite, world, random, chunkX * 16, chunkY * 16, OreGen.cassiteriteMinY, OreGen.cassiteriteMaxY, OreGen.cassiteriteVeinSize, OreGen.cassiteriteChances);
        }
        if (OreGen.Digenite){
            generateOre(TFTFBlocks.oreDigenite, world, random, chunkX * 16, chunkY * 16, OreGen.digeniteMinY, OreGen.digeniteMaxY, OreGen.digeniteVeinSize, OreGen.digeniteChances);
        }
        if (OreGen.Galena){
            generateOre(TFTFBlocks.oreGalena, world, random, chunkX * 16, chunkY * 16, OreGen.galenaMinY, OreGen.galenaMaxY, OreGen.galenaVeinSize, OreGen.galenaChances);
        }
        if (OreGen.Sphalerite){
            generateOre(TFTFBlocks.oreSphalerite, world, random, chunkX * 16, chunkY * 16, OreGen.sphaleriteMinY, OreGen.sphaleriteMaxY, OreGen.sphaleriteVeinSize, OreGen.sphaleriteChances);
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
