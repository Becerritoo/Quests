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

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BiomeLookupModeTest {

    @Test
    public void parsesSupportedConfigValuesIgnoringCase() {
        assertEquals(BiomeLookupMode.AUTO, BiomeLookupMode.fromConfig("AUTO"));
        assertEquals(BiomeLookupMode.THREE_DIMENSIONAL, BiomeLookupMode.fromConfig("3d"));
        assertEquals(BiomeLookupMode.TWO_DIMENSIONAL, BiomeLookupMode.fromConfig("2D"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectsUnsupportedConfigValue() {
        BiomeLookupMode.fromConfig("vertical");
    }
}
