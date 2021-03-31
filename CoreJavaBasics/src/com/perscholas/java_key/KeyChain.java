package com.perscholas.java_key;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class KeyChain {
	private Map<KeyShape, ArrayList<Key>> keys = new HashMap<KeyShape, ArrayList<Key>>();
	public KeyChain() {}
	
	public KeyChain(Collection<Key> keys) {
		for(Key k : keys) {
			addKey(k);
		}
	}
	public boolean addKey(Key key) {
		if(!keys.containsKey(key.shape())) {
			keys.put(key.shape(),new ArrayList<Key>());
		}
		keys.get(key.shape()).add(key);
		return true;
	}
	public boolean removeKey(Key key) {
		if(keys.containsKey(key.shape())) {
			return keys.get(key.shape()).remove(key);
		}
		return false;
	}
	public int keyCount() {
		int keyCount = 0;
		for(KeyShape keyshape : keys.keySet()) {
			keyCount += keys.get(keyshape).size();
		}
		return keyCount;
	}
	public boolean lock(Door door) {
		if(door.isLocked()) return true;
		if(!door.hasKey()) return false;
		if(!keys.containsKey(door.getKey().shape())) return false;
		for( Key k : keys.get(door.getKey().shape())) {
			if(door.lock(k)) return true;
		}
		return false;
	}
	public boolean unlock(Door door) {
		if(!door.isLocked()) return true;
		if(!door.hasKey()) return true;
		if(!keys.containsKey(door.getKey().shape())) return false;
		for( Key k : keys.get(door.getKey().shape())) {
			if(door.unlock(k)) return true;
		}
		return false;
	}

}
