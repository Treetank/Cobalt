package org.laser.cobalt.helpers.types;

import org.laser.cobalt.helpers.types.SerializingData.ConsumableResourceData;

import com.badlogic.gdx.utils.Json;

public class ConsumableResource {

	private int current, max;

	public ConsumableResource() {
	}

	public ConsumableResource(int max) {
		this.current = max;
		this.max = max;
	}

	public ConsumableResource(int current, int max) {
		this.current = current;
		this.max = max;
	}

	public int getCurrent() {
		return current;
	}

	public int getMax() {
		return max;
	}

	public void useResource(int adjustValue) {
		current -= adjustValue;
		if (current < 0)
			current = 0;
	}

	public void fillResource(int adjustValue) {
		current += adjustValue;
	}

	public void fill() {
		current = max;
	}

	public void setMax(int newMax) {
		max = newMax;
	}

	public String save() {
		ConsumableResourceData data = new ConsumableResourceData();
		data.setCurrent(this.current);
		data.setMax(this.max);
		Json json = new Json();
		return json.toJson(data);
	}

	public void load(String loadString) {
		if (loadString != null & loadString != "") {
			Json json = new Json();
			ConsumableResourceData data = json.fromJson(ConsumableResourceData.class, loadString);
			this.current = data.getCurrent();
			this.max = data.getMax();
		} else
			loadNew();
	}

	public void loadNew() {
		current = 0;
		max = 0;
	}

	public String toString() {
		return current + " / " + max;
	}
}
