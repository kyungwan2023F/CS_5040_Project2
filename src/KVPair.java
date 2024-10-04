public class KVPair<K extends Comparable<K>, E>
    implements Comparable<KVPair<K, E>> {

    // ~ Fields ................................................................
    K theKey;
    E theVal;

    // ~ Constructors ..........................................................
    KVPair(K k, E v) {
        theKey = k;
        theVal = v;
    }


    // ~Public Methods ........................................................
    public int compareTo(KVPair<K, E> it) {
        return theKey.compareTo(it.key());
    }


    public int compareTo(K key) {
        return theKey.compareTo(key);
    }


    public K key() {
        return theKey;
    }


    public E value() {
        return theVal;
    }
}
