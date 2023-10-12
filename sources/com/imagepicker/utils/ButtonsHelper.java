package com.imagepicker.utils;

import com.braintreepayments.api.PayPalTwoFactorAuth;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.LinkedList;
import java.util.List;
import org.bouncycastle.i18n.MessageBundle;

public class ButtonsHelper {
    public final Item btnCamera;
    public final Item btnCancel;
    public final Item btnLibrary;
    public final List<Item> customButtons;

    public static class Item {
        public final String action;
        public final String title;

        public Item(String str, String str2) {
            this.title = str;
            this.action = str2;
        }
    }

    public ButtonsHelper(Item item, Item item2, Item item3, LinkedList<Item> linkedList) {
        this.btnCamera = item;
        this.btnLibrary = item2;
        this.btnCancel = item3;
        this.customButtons = linkedList;
    }

    public List<String> getTitles() {
        LinkedList linkedList = new LinkedList();
        Item item = this.btnCamera;
        if (item != null) {
            linkedList.add(item.title);
        }
        Item item2 = this.btnLibrary;
        if (item2 != null) {
            linkedList.add(item2.title);
        }
        for (int i = 0; i < this.customButtons.size(); i++) {
            linkedList.add(this.customButtons.get(i).title);
        }
        return linkedList;
    }

    public List<String> getActions() {
        LinkedList linkedList = new LinkedList();
        Item item = this.btnCamera;
        if (item != null) {
            linkedList.add(item.action);
        }
        Item item2 = this.btnLibrary;
        if (item2 != null) {
            linkedList.add(item2.action);
        }
        for (int i = 0; i < this.customButtons.size(); i++) {
            linkedList.add(this.customButtons.get(i).action);
        }
        return linkedList;
    }

    public static ButtonsHelper newInstance(ReadableMap readableMap) {
        return new ButtonsHelper(getItemFromOption(readableMap, "takePhotoButtonTitle", "photo"), getItemFromOption(readableMap, "chooseFromLibraryButtonTitle", "library"), getItemFromOption(readableMap, "cancelButtonTitle", PayPalTwoFactorAuth.CANCEL_PATH), getCustomButtons(readableMap));
    }

    private static Item getItemFromOption(ReadableMap readableMap, String str, String str2) {
        if (!ReadableMapUtils.hasAndNotEmptyString(readableMap, str)) {
            return null;
        }
        return new Item(readableMap.getString(str), str2);
    }

    private static LinkedList<Item> getCustomButtons(ReadableMap readableMap) {
        LinkedList<Item> linkedList = new LinkedList<>();
        if (!readableMap.hasKey("customButtons")) {
            return linkedList;
        }
        ReadableArray array = readableMap.getArray("customButtons");
        for (int i = 0; i < array.size(); i++) {
            ReadableMap map = array.getMap(i);
            linkedList.add(new Item(map.getString(MessageBundle.TITLE_ENTRY), map.getString("name")));
        }
        return linkedList;
    }
}
