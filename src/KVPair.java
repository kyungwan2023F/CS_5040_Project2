/**
 * The KVPair class represents a key-value pair where the key is comparable, and
 * seminar the value. Uses comparable to allow comparison between two KVpair 
 * objects.
 * 
 * @author Kyungwan Do, Jaeyoung Shin
 * @version 10/18/2024
 * @param <K>
 *            e
 * @param <E>
 *            e
 */
public class KVPair<K extends Comparable<K>, E>
    implements Comparable<KVPair<K, E>> {

    /**
     * key
     */
    K theKey;
    /**
     * value
     */
    E theVal;

    // ----------------------------------------------------------
    /**
     * Create a new KVPair object.
     * 
     * @param k
     *            k
     * @param v
     *            e
     */
    KVPair(K k, E v) {
        theKey = k;
        theVal = v;
    }


    // ----------------------------------------------------------
    /**
     * Compares this kv pair with another pair based on the key.
     * 
     * @param it
     *            ke
     * @return comparedKey
     */
    public int compareTo(KVPair<K, E> it) {
        return theKey.compareTo(it.key());
    }


    // ----------------------------------------------------------
    /**
     * Compares this kv pair's key with another key.
     * 
     * @param key
     *            k
     * @return comparedKey
     */
    public int compareTo(K key) {
        return theKey.compareTo(key);
    }


    // ----------------------------------------------------------
    /**
     * Returns the key of this kv pair.
     * 
     * @return key
     */
    public K key() {
        return theKey;
    }


    // ----------------------------------------------------------
    /**
     * Returns the value of this kv pair.
     * 
     * @return value
     */
    public E value() {
        return theVal;
    }
}
