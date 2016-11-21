package com.vkmusic.entity.vk;

import java.io.Serializable;

/**
 * Created by Vadym_Vlasenko on 5/18/2016.
 */
public class AudioSearchBean implements Serializable {

    private String searchText;
    private boolean autocomplete;
    private boolean performerOnly;
    private boolean searchOwn;
    private int sort;
    private int offset;
    private int count;

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public boolean isAutocomplete() {
        return autocomplete;
    }

    public void setAutocomplete(boolean autocomplete) {
        this.autocomplete = autocomplete;
    }

    public boolean isPerformerOnly() {
        return performerOnly;
    }

    public void setPerformerOnly(boolean performerOnly) {
        this.performerOnly = performerOnly;
    }

    public boolean isSearchOwn() {
        return searchOwn;
    }

    public void setSearchOwn(boolean searchOwn) {
        this.searchOwn = searchOwn;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "AudioSearchBean{" +
                "searchText='" + searchText + '\'' +
                ", autocomplete=" + autocomplete +
                ", performerOnly=" + performerOnly +
                ", searchOwn=" + searchOwn +
                ", sort=" + sort +
                ", offset=" + offset +
                ", count=" + count +
                '}';
    }
}
