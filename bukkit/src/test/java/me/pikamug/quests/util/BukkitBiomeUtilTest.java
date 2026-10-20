/*
 * Copyright (c) PikaMug and contributors
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package me.pikamug.quests.util;

import me.pikamug.quests.config.BiomeLookupMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BukkitBiomeUtilTest {

    @Test
    public void usesBiomeAtCurrentHeightForAutoAndThreeDimensionalModes() {
        final Location surfaceLocation = mock(Location.class);
        final Location caveLocation = mock(Location.class);
        final Block surfaceBlock = mock(Block.class);
        final Block caveBlock = mock(Block.class);
        when(surfaceLocation.getBlock()).thenReturn(surfaceBlock);
        when(caveLocation.getBlock()).thenReturn(caveBlock);
        when(surfaceBlock.getBiome()).thenReturn(Biome.SUNFLOWER_PLAINS);
        when(caveBlock.getBiome()).thenReturn(Biome.DRIPSTONE_CAVES);

        assertEquals(Biome.SUNFLOWER_PLAINS,
                BukkitBiomeUtil.getBiome(surfaceLocation, BiomeLookupMode.AUTO));
        assertEquals(Biome.DRIPSTONE_CAVES,
                BukkitBiomeUtil.getBiome(caveLocation, BiomeLookupMode.THREE_DIMENSIONAL));
    }

    @Test
    public void usesLegacyColumnLookupForTwoDimensionalMode() {
        final Location location = mock(Location.class);
        final World world = mock(World.class);
        when(location.getWorld()).thenReturn(world);
        when(location.getBlockX()).thenReturn(12);
        when(location.getBlockZ()).thenReturn(34);
        when(world.getBiome(12, 34)).thenReturn(Biome.PLAINS);

        assertEquals(Biome.PLAINS, BukkitBiomeUtil.getBiome(location, BiomeLookupMode.TWO_DIMENSIONAL));
    }
}
