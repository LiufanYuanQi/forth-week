package person.liufan.bookstore.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class Rest extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public Rest() {
		put("code", 0);
		put("msg", "success");
	}
	
	public static Rest error(int code, String msg) {
		Rest Rest = new Rest();
		Rest.put("code", code);
		Rest.put("msg", msg);
		return Rest;
	}

	public static Rest ok(String msg) {
		Rest Rest = new Rest();
		Rest.put("msg", msg);
		return Rest;
	}
	
	public static Rest ok(Map<String, Object> map) {
		Rest Rest = new Rest();
		Rest.putAll(map);
		return Rest;
	}
	
	public static Rest ok() {
		return new Rest();
	}

	@Override
	public Rest put(String key, Object value) {
		super.put(key, value);
		return this;
	}
	public  Integer getCode() {

		return (Integer) this.get("code");
	}

}
