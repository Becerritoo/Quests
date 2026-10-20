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
import org.bukkit.block.Biome;

public final class BukkitBiomeUtil {

    private BukkitBiomeUtil() {
    }

    public static Biome getBiome(final Location location, final BiomeLookupMode mode) {
        if (mode == BiomeLookupMode.TWO_DIMENSIONAL) {
            return location.getWorld().getBiome(location.getBlockX(), location.getBlockZ());
        }
        // Block#getBiome remains compatible with legacy Bukkit while honoring Y on modern servers.
        return location.getBlock().getBiome();
    }
}
