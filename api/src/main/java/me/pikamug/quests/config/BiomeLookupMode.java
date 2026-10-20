/*
 * Copyright (c) PikaMug and contributors
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package me.pikamug.quests.config;

public enum BiomeLookupMode {
    AUTO("auto"),
    THREE_DIMENSIONAL("3d"),
    TWO_DIMENSIONAL("2d");

    private final String configValue;

    BiomeLookupMode(final String configValue) {
        this.configValue = configValue;
    }

    public String getConfigValue() {
        return configValue;
    }

    public static BiomeLookupMode fromConfig(final String value) {
        for (final BiomeLookupMode mode : values()) {
            if (mode.configValue.equalsIgnoreCase(value)) {
                return mode;
            }
        }
        throw new IllegalArgumentException("Unknown biome lookup mode: " + value);
    }
}
