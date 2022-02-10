package com.qaprosoft.carina.webtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.gsmarena.GSMArenaHomePage;
import com.qaprosoft.carina.demo.gui.pages.gsmarena.GSMArenaPhonePage;
import com.qaprosoft.carina.demo.gui.pages.gsmarena.GSMArenaSony;

public class GSMArenaTest extends AbstractWebTest {

	@Test
	@MethodOwner(owner = "Bo Harris")
	public void sonyXperiaProOsTest() {
		GSMArenaHomePage gsmArenaHomePage = new GSMArenaHomePage(getDriver());
		gsmArenaHomePage.open();
		GSMArenaSony gsmArenaSony = gsmArenaHomePage.sonyNavigation();
		gsmArenaSony.getXperiaPro();
		GSMArenaPhonePage gsmArenaPhonePage = new GSMArenaPhonePage(getDriver());

		Assert.assertEquals(gsmArenaPhonePage.getMemoryInfo(),
				"MEMORY Card slot microSDXC (uses shared SIM slot)\n" + "Internal 512GB 12GB RAM\n" + "  UFS 3.X",
				"Error Memory Tables not equal !!!!");
		Assert.assertEquals(gsmArenaPhonePage.getSoundInfo(),
				"SOUND Loudspeaker Yes, with stereo speakers\n" + "3.5mm jack Yes\n" + "  24-bit/192kHz audio",
				"Error Sound information are not equal !!!!");
		Assert.assertEquals(gsmArenaPhonePage.getPlatformInfo(),
				"PLATFORM OS Android 10\n" + "Chipset Qualcomm SM8250 Snapdragon 865 5G (7 nm+)\n"
						+ "CPU Octa-core (1x2.84 GHz Kryo 585 & 3x2.42 GHz Kryo 585 & 4x1.8 GHz Kryo 585)\n"
						+ "GPU Adreno 650",
				"Error Sound information are not equal !!!!");

	}

	@Test
	@MethodOwner(owner = "Bo Harris")
	public void sonyXperiaOneOsTest() {
		GSMArenaHomePage gsmArenaHomePage = new GSMArenaHomePage(getDriver());
		gsmArenaHomePage.open();
		GSMArenaSony gsmArenaSony = gsmArenaHomePage.sonyNavigation();
		gsmArenaSony.getXperiaOne();
		GSMArenaPhonePage gsmArenaPhonePage = new GSMArenaPhonePage(getDriver());

		Assert.assertEquals(gsmArenaPhonePage.getMemoryInfo(),
				"MEMORY Card slot microSDXC (uses shared SIM slot) - dual SIM model only\n"
						+ "Internal 64GB 6GB RAM, 128GB 6GB RAM\n" + "  UFS 2.1",
				"Error Memory Tables not equal !!!!");
		Assert.assertEquals(
				gsmArenaPhonePage.getSoundInfo(), "SOUND Loudspeaker Yes, with stereo speakers\n" + "3.5mm jack No\n"
						+ "  24-bit/192kHz audio\n" + "Dynamic vibration system",
				"Error Sound information are not equal !!!!");
		Assert.assertEquals(gsmArenaPhonePage.getPlatformInfo(),
				"PLATFORM OS Android 9.0 (Pie), upgradable to Android 11\n"
						+ "Chipset Qualcomm SM8150 Snapdragon 855 (7 nm)\n"
						+ "CPU Octa-core (1x2.84 GHz Kryo 485 & 3x2.42 GHz Kryo 485 & 4x1.78 GHz Kryo 485)\n"
						+ "GPU Adreno 640",
				"Error Sound information are not equal !!!!");

	}

	@Test
	@MethodOwner(owner = "Bo Harris")
	public void sonyXperiaFiveTest() {
		GSMArenaHomePage gsmArenaHomePage = new GSMArenaHomePage(getDriver());
		gsmArenaHomePage.open();
		GSMArenaSony gsmArenaSony = gsmArenaHomePage.sonyNavigation();
		gsmArenaSony.getXperiaFive();
		GSMArenaPhonePage gsmArenaPhonePage = new GSMArenaPhonePage(getDriver());
		Assert.assertEquals(gsmArenaPhonePage.getMemoryInfo(),
				"MEMORY Card slot microSDXC (uses shared SIM slot)\n" + "Internal 128GB 6GB RAM\n" + "  UFS 2.1",
				"Error Sound information are not equal !!!!");
		Assert.assertEquals(
				gsmArenaPhonePage.getSoundInfo(), "SOUND Loudspeaker Yes, with stereo speakers\n" + "3.5mm jack No\n"
						+ "  24-bit/192kHz audio\n" + "Dynamic vibration system",
				"Error Sound information are not equal !!!!");
		Assert.assertEquals(gsmArenaPhonePage.getPlatformInfo(),
				"PLATFORM OS Android 9.0 (Pie), upgradable to Android 11\n"
						+ "Chipset Qualcomm SM8150 Snapdragon 855 (7 nm)\n"
						+ "CPU Octa-core (1x2.84 GHz Kryo 485 & 3x2.42 GHz Kryo 485 & 4x1.78 GHz Kryo 485)\n"
						+ "GPU Adreno 640",
				"Error Sound information are not equal !!!!");

	}

}
