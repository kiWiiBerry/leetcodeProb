package com.yiyiwii.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AmzFetchItemsToDisplay {
    public static void main(String[] args) {

    }
    class Solution {
        public List<String> fetchItems(int sortCol, int sortOrder,
                                       int itemsPerPage, int pageInx,
                                       Map<String, int[]> results
                                       ) {
            List<String> ordered = new ArrayList<>(results.keySet());
            ordered.sort((a,b) -> {
                int res;
                if (sortCol != 0) {
                    res = results.get(a)[sortCol - 1] - results.get(b)[sortCol-1];
                } else {
                    res = a.compareTo(b);
                }
                return res * (sortOrder == 0 ? 1 : -1);
            });
            int startIdx = itemsPerPage * pageInx;
            return ordered.subList(startIdx, Math.min(startIdx + itemsPerPage, ordered.size()));
        }
    }
}
