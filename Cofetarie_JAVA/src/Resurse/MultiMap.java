package Resurse;

import Cofetarie.Produs;

import java.util.*;

public class MultiMap <K,V> {

        private Map<K, Collection<V>> map = new HashMap<>();

        //add the specified value with the specified key in this multimap
        public boolean put(K key, V value) {
                if (map.get(key) == null) {
                        map.put(key, new ArrayList<V>());
                        return true;
                }
                if (!map.get(key).contains(value)) {
                        map.get(key).add(value);
                        return true;
                }
                return false;
        }
        //Returns true if this multimap contains a mapping for the specified key.
        public boolean containsKey(Object key) {
                return map.containsKey(key);
        }

        //Removes the entry for the specified key only if it is currently mapped to the specified value and returns true if removed
        public boolean remove(K key, V value) {
                if (map.get(key) != null) // key exists
                        return map.get(key).remove(value);
                return false;
        }

        //the method returns the Collection of values to which the specified key is mapped, or null if this multimap contains no mapping for the key
        public Collection<V> get(Object key) {
                return map.get(key);
        }

        //the method returns a set view of the keys contained in this multimap
        public Set<K> keySet() {
                return map.keySet();
        }

}
