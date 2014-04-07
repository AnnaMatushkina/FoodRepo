package com.epam.feel.client.ui.util.pagination;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class, providing helper methods used by some of Dao's to provide sorting.
 * 
 * @author Michael_Silvanovich
 */
public class CollectionUtils {

    /**
     * Returns serializable map containing one-column order list, that can be serialized/deserialized by GWT serializer
     * NOTE: result of {@link Collections#singletonMap(Object, Object)} is not in white list for GWT serializer and
     * can't be serialized/deserialized
     * 
     * @param column
     *            column name
     * @param ascending
     *            true if order is ascending
     * @return one-column order list
     */
    public static <K extends Serializable, V extends Serializable> Map<K, V> getOrderList(K column, V ascending) {
        HashMap<K, V> map = new HashMap<K, V>();
        map.put(column, ascending);
        return map;
    }

}
