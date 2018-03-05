package com.helloworld.translator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author TZVZCY
 */
public abstract class AbstractModelTranslator<T, K> implements ModelTranslator<T, K> {

    @Override
    public List<K> translate(Iterable<T> original) {
        return StreamSupport.stream(original.spliterator(), false).map(item -> translate(item)).collect(Collectors.toList());
    }

}
