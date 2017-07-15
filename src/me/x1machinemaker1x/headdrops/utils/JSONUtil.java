package me.x1machinemaker1x.headdrops.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.bukkit.plugin.Plugin;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import me.x1machinemaker1x.headdrops.CustomSkullType;

public class JSONUtil {
	
	private static List<String> urls;
	private static String pluginFolder;
	
	public static void setup(Plugin p) {
		pluginFolder = p.getDataFolder().getAbsolutePath();
		urls = new ArrayList<String>();
		urls.add("http://textures.minecraft.net/texture/9e99deef919db66ac2bd28d6302756ccd57c7f8b12b9dca8f41c3e0a04ac1cc");
		urls.add("http://textures.minecraft.net/texture/b78ef2e4cf2c41a2d14bfde9caff10219f5b1bf5b35a49eb51c6467882cb5f0");
		urls.add("http://textures.minecraft.net/texture/41645dfd77d09923107b3496e94eeb5c30329f97efc96ed76e226e98224");
		urls.add("http://textures.minecraft.net/texture/1638469a599ceef7207537603248a9ab11ff591fd378bea4735b346a7fae893");
		urls.add("http://textures.minecraft.net/texture/5d6c6eda942f7f5f71c3161c7306f4aed307d82895f9d2b07ab4525718edc5");
		urls.add("http://textures.minecraft.net/texture/e92089618435a0ef63e95ee95a92b83073f8c33fa77dc5365199bad33b6256");
		urls.add("http://textures.minecraft.net/texture/7a59bb0a7a32965b3d90d8eafa899d1835f424509eadd4e6b709ada50b9cf");
		urls.add("http://textures.minecraft.net/texture/5a1a0831aa03afb4212adcbb24e5dfaa7f476a1173fce259ef75a85855");
		urls.add("http://textures.minecraft.net/texture/6deaec344ab095b48cead7527f7dee61b063ff791f76a8fa76642c8676e2173");
		urls.add("http://textures.minecraft.net/texture/8b6a72138d69fbbd2fea3fa251cabd87152e4f1c97e5f986bf685571db3cc0");
		urls.add("http://textures.minecraft.net/texture/a0bf34a71e7715b6ba52d5dd1bae5cb85f773dc9b0d457b4bfc5f9dd3cc7c94");
		urls.add("http://textures.minecraft.net/texture/d674c63c8db5f4ca628d69a3b1f8a36e29d8fd775e1a6bdb6cabb4be4db121");
		urls.add("http://textures.minecraft.net/texture/89091d79ea0f59ef7ef94d7bba6e5f17f2f7d4572c44f90f76c4819a714");
		urls.add("http://textures.minecraft.net/texture/818cd457fbaf327fa39f10b5b36166fd018264036865164c02d9e5ff53f45");
		urls.add("http://textures.minecraft.net/texture/38957d5023c937c4c41aa2412d43410bda23cf79a9f6ab36b76fef2d7c429");
		urls.add("http://textures.minecraft.net/texture/d0bc61b9757a7b83e03cd2507a2157913c2cf016e7c096a4d6cf1fe1b8db");
		urls.add("http://textures.minecraft.net/texture/5657cd5c2989ff97570fec4ddcdc6926a68a3393250c1be1f0b114a1db1");
		urls.add("http://textures.minecraft.net/texture/707dab2cbebea539b64d5ad246f9ccc1fcda7aa94b88e59fc2829852f46071");
		urls.add("http://textures.minecraft.net/texture/621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4");
		urls.add("http://textures.minecraft.net/texture/74e9c6e98582ffd8ff8feb3322cd1849c43fb16b158abb11ca7b42eda7743eb");
		urls.add("http://textures.minecraft.net/texture/d46d23f04846369fa2a3702c10f759101af7bfe8419966429533cd81a11d2b");
		urls.add("http://textures.minecraft.net/texture/ffecc6b5e6ea5ced74c46e7627be3f0826327fba26386c6cc7863372e9bc");
		urls.add("http://textures.minecraft.net/texture/f31f9ccc6b3e32ecf13b8a11ac29cd33d18c95fc73db8a66c5d657ccb8be70");
		urls.add("http://textures.minecraft.net/texture/b1d3534d21fe8499262de87affbeac4d25ffde35c8bdca069e61e1787ff2f");
		urls.add("http://textures.minecraft.net/texture/da91dab8391af5fda54acd2c0b18fbd819b865e1a8f1d623813fa761e924540");
		urls.add("http://textures.minecraft.net/texture/b0cc3597f25d62b7f5748cec22e2fbed236040f1c27047afea1f50f768a8");
		urls.add("http://textures.minecraft.net/texture/cd541541daaff50896cd258bdbdd4cf80c3ba816735726078bfe393927e57f1");
		urls.add("http://textures.minecraft.net/texture/01433be242366af126da434b8735df1eb5b3cb2cede39145974e9c483607bac");
		urls.add("http://textures.minecraft.net/texture/78ddf76e555dd5c4aa8a0a5fc584520cd63d489c253de969f7f22f85a9a2d56");
		urls.add("http://textures.minecraft.net/texture/c2ec5a516617ff1573cd2f9d5f3969f56d5575c4ff4efefabd2a18dc7ab98cd");
		urls.add("http://textures.minecraft.net/texture/822d8e751c8f2fd4c8942c44bdb2f5ca4d8ae8e575ed3eb34c18a86e93b");
		urls.add("http://textures.minecraft.net/texture/4f6fb89d1c631bd7e79fe185ba1a6705425f5c31a5ff626521e395d4a6f7e2");
		urls.add("http://textures.minecraft.net/texture/20e13d18474fc94ed55aeb7069566e4687d773dac16f4c3f8722fc95bf9f2dfa");
		urls.add("http://textures.minecraft.net/texture/cdf74e323ed41436965f5c57ddf2815d5332fe999e68fbb9d6cf5c8bd4139f");
		urls.add("http://textures.minecraft.net/texture/1d83731d77f54f5d4f93ddd99b9476e4f1fe5b7e1318f1e1626f7d3fa3aa847");
		urls.add("http://textures.minecraft.net/texture/e5e08a8776c1764c3fe6a6ddd412dfcb87f41331dad479ac96c21df4bf3ac89c");
		//Don't spawn naturally
		urls.add("http://textures.minecraft.net/texture/63b098967340daac529293c24e04910509b208e7b94563c3ef31dec7b3750");
		urls.add("http://textures.minecraft.net/texture/98b7ca3c7d314a61abed8fc18d797fc30b6efc8445425c4e250997e52e6cb");
		urls.add("http://textures.minecraft.net/texture/1c678c9f4c6dd4d991930f82e6e7d8b89b2891f35cba48a4b18539bbe7ec927");
		urls.add("http://textures.minecraft.net/texture/eb7af9e4411217c7de9c60acbd3c3fd6519783332a1b3bc56fbfce90721ef35");
		try {
			File file = new File(pluginFolder + File.separator + "head-uuids.json");
			if (!file.exists()) {
				file.createNewFile();
				firstSetup();
			}
			else {
				Iterator<String> it = urls.iterator();
				for (CustomSkullType cst : CustomSkullType.values()) {
					if (it.hasNext()) {
						cst.setSkull(CSkull.getCustomSkull(it.next(), cst.getDisplayName()));
					}
				}
			}
		}
		catch (Exception e) { }
	}
	
	private static void firstSetup() {
		
		Iterator<String> it = urls.iterator();
		UUID uuid = null;
		JSONObject main = new JSONObject();
		for (CustomSkullType cst : CustomSkullType.values()) {
			if (it.hasNext()) {
				uuid = UUID.randomUUID();
				main.put(cst.getDisplayName(), uuid.toString());
				cst.setSkull(CSkull.getCustomSkull(it.next(), cst.getDisplayName(), uuid));
			}
		}
		writeJSON("head-uuids", main);
	}
	
	public static void writeJSON(String fileName, JSONObject main) {
		try {
			File file = new File(pluginFolder + File.separator + fileName + ".json");
			if (!file.exists()) {
				throw new IllegalArgumentException("That is not a valid JSON filename!");
			}
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(main.toJSONString());
			fileWriter.flush();
			fileWriter.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static JSONObject getJSONObject(String filename) {
		JSONObject jsonObject = null;
		try {
			JSONParser parser = new JSONParser();
			File file = new File(pluginFolder + File.separator + filename + ".json");
			Object obj = parser.parse(new FileReader(file));
			jsonObject = (JSONObject) obj;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	public static String readJSON(String filename, String object) {
		String var = null;
		try {
			JSONParser parser = new JSONParser();
			File file = new File(pluginFolder + File.separator + filename + ".json");
			Object obj = parser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) obj;
			var = (String) jsonObject.get(object);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return var;
	}

}
