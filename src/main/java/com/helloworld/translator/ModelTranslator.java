package com.helloworld.translator;

import java.util.List;

/**
 * @author TZVZCY
 */
public interface ModelTranslator<T, K> {

    public K translate(T original);

    public List<K> translate(Iterable<T> original);
}
