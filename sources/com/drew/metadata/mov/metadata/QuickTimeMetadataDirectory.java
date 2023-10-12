package com.drew.metadata.mov.metadata;

import androidx.exifinterface.media.ExifInterface;
import com.brentvatne.react.ReactVideoViewManager;
import com.drew.metadata.exif.makernotes.LeicaType5MakernoteDirectory;
import com.drew.metadata.exif.makernotes.OlympusCameraSettingsMakernoteDirectory;
import com.drew.metadata.exif.makernotes.SonyType6MakernoteDirectory;
import com.drew.metadata.mov.QuickTimeDirectory;
import com.drew.metadata.photoshop.PhotoshopDirectory;
import java.util.HashMap;

public class QuickTimeMetadataDirectory extends QuickTimeDirectory {
    protected static final HashMap<String, Integer> _tagIntegerMap;
    protected static final HashMap<Integer, String> _tagNameMap;

    public String getName() {
        return "QuickTime Metadata";
    }

    public QuickTimeMetadataDirectory() {
        setDescriptor(new QuickTimeMetadataDescriptor(this));
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _tagNameMap = hashMap;
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        _tagIntegerMap = hashMap2;
        Integer valueOf = Integer.valueOf(OlympusCameraSettingsMakernoteDirectory.TagWhiteBalance2);
        hashMap2.put("com.apple.quicktime.album", valueOf);
        Integer valueOf2 = Integer.valueOf(OlympusCameraSettingsMakernoteDirectory.TagWhiteBalanceTemperature);
        hashMap2.put("com.apple.quicktime.artist", valueOf2);
        Integer valueOf3 = Integer.valueOf(OlympusCameraSettingsMakernoteDirectory.TagWhiteBalanceBracket);
        hashMap2.put("com.apple.quicktime.artwork", valueOf3);
        Integer valueOf4 = Integer.valueOf(OlympusCameraSettingsMakernoteDirectory.TagCustomSaturation);
        hashMap2.put("com.apple.quicktime.author", valueOf4);
        Integer valueOf5 = Integer.valueOf(OlympusCameraSettingsMakernoteDirectory.TagModifiedSaturation);
        hashMap2.put("com.apple.quicktime.comment", valueOf5);
        Integer valueOf6 = Integer.valueOf(OlympusCameraSettingsMakernoteDirectory.TagContrastSetting);
        hashMap2.put("com.apple.quicktime.copyright", valueOf6);
        Integer valueOf7 = Integer.valueOf(OlympusCameraSettingsMakernoteDirectory.TagSharpnessSetting);
        hashMap2.put("com.apple.quicktime.creationdate", valueOf7);
        Integer valueOf8 = Integer.valueOf(OlympusCameraSettingsMakernoteDirectory.TagColorSpace);
        hashMap2.put("com.apple.quicktime.description", valueOf8);
        hashMap2.put("com.apple.quicktime.director", 1288);
        Integer valueOf9 = Integer.valueOf(OlympusCameraSettingsMakernoteDirectory.TagSceneMode);
        hashMap2.put("com.apple.quicktime.title", valueOf9);
        Integer valueOf10 = Integer.valueOf(OlympusCameraSettingsMakernoteDirectory.TagNoiseReduction);
        hashMap2.put("com.apple.quicktime.genre", valueOf10);
        Integer valueOf11 = Integer.valueOf(OlympusCameraSettingsMakernoteDirectory.TagDistortionCorrection);
        hashMap2.put("com.apple.quicktime.information", valueOf11);
        Integer valueOf12 = Integer.valueOf(OlympusCameraSettingsMakernoteDirectory.TagShadingCompensation);
        hashMap2.put("com.apple.quicktime.keywords", valueOf12);
        Integer valueOf13 = Integer.valueOf(OlympusCameraSettingsMakernoteDirectory.TagCompressionFactor);
        hashMap2.put("com.apple.quicktime.location.ISO6709", valueOf13);
        hashMap2.put("com.apple.quicktime.producer", 1294);
        hashMap2.put("com.apple.quicktime.publisher", Integer.valueOf(OlympusCameraSettingsMakernoteDirectory.TagGradation));
        hashMap2.put("com.apple.quicktime.software", 1296);
        hashMap2.put("com.apple.quicktime.year", 1297);
        hashMap2.put("com.apple.quicktime.collection.user", 1298);
        hashMap2.put("com.apple.quicktime.rating.user", Integer.valueOf(SonyType6MakernoteDirectory.TAG_MAKERNOTE_THUMB_OFFSET));
        hashMap2.put("com.apple.quicktime.location.name", Integer.valueOf(SonyType6MakernoteDirectory.TAG_MAKERNOTE_THUMB_LENGTH));
        hashMap2.put("com.apple.quicktime.location.body", 1301);
        hashMap2.put("com.apple.quicktime.location.note", 1302);
        hashMap2.put("com.apple.quicktime.location.role", 1303);
        hashMap2.put("com.apple.quicktime.location.date", 1304);
        hashMap2.put("com.apple.quicktime.direction.facing", 1305);
        hashMap2.put("com.apple.quicktime.direction.motion", 1306);
        hashMap2.put("com.apple.quicktime.displayname", 1307);
        hashMap2.put("com.apple.quicktime.content.identifier", 1308);
        hashMap2.put("com.apple.quicktime.make", 1309);
        hashMap2.put("com.apple.quicktime.model", 1310);
        hashMap2.put("com.apple.photos.originating.signature", 1311);
        hashMap2.put("----", 1024);
        hashMap2.put("@PST", 1025);
        hashMap2.put("@ppi", Integer.valueOf(PhotoshopDirectory.TAG_LAYERS_GROUP_INFORMATION));
        hashMap2.put("@pti", 1027);
        hashMap2.put("@sti", 1028);
        hashMap2.put("AACR", 1029);
        hashMap2.put("CDEK", 1030);
        hashMap2.put("CDET", Integer.valueOf(LeicaType5MakernoteDirectory.TagOriginalFileName));
        hashMap2.put("GUID", 1032);
        hashMap2.put("VERS", Integer.valueOf(PhotoshopDirectory.TAG_THUMBNAIL_OLD));
        hashMap2.put("aART", Integer.valueOf(PhotoshopDirectory.TAG_COPYRIGHT));
        hashMap2.put("akID", Integer.valueOf(PhotoshopDirectory.TAG_URL));
        hashMap2.put("albm", Integer.valueOf(PhotoshopDirectory.TAG_THUMBNAIL));
        hashMap2.put("apID", 1037);
        hashMap2.put("atID", 1038);
        hashMap2.put("auth", Integer.valueOf(PhotoshopDirectory.TAG_ICC_PROFILE_BYTES));
        hashMap2.put("catg", 1040);
        hashMap2.put("cnID", Integer.valueOf(PhotoshopDirectory.TAG_ICC_UNTAGGED_PROFILE));
        hashMap2.put("covr", 1042);
        hashMap2.put("cpil", 1043);
        hashMap2.put("cprt", Integer.valueOf(PhotoshopDirectory.TAG_SEED_NUMBER));
        hashMap2.put("desc", Integer.valueOf(PhotoshopDirectory.TAG_UNICODE_ALPHA_NAMES));
        hashMap2.put("disk", Integer.valueOf(PhotoshopDirectory.TAG_INDEXED_COLOR_TABLE_COUNT));
        hashMap2.put("dscp", Integer.valueOf(PhotoshopDirectory.TAG_TRANSPARENCY_INDEX));
        hashMap2.put("egid", 1048);
        hashMap2.put("geID", Integer.valueOf(PhotoshopDirectory.TAG_GLOBAL_ALTITUDE));
        hashMap2.put("gnre", Integer.valueOf(PhotoshopDirectory.TAG_SLICES));
        hashMap2.put("grup", Integer.valueOf(PhotoshopDirectory.TAG_WORKFLOW_URL));
        hashMap2.put("gshh", Integer.valueOf(PhotoshopDirectory.TAG_JUMP_TO_XPEP));
        hashMap2.put("gspm", Integer.valueOf(PhotoshopDirectory.TAG_ALPHA_IDENTIFIERS));
        hashMap2.put("gspu", Integer.valueOf(PhotoshopDirectory.TAG_URL_LIST));
        hashMap2.put("gssd", 1055);
        hashMap2.put("gsst", 1056);
        hashMap2.put("gstd", Integer.valueOf(PhotoshopDirectory.TAG_VERSION));
        hashMap2.put("hdvd", Integer.valueOf(PhotoshopDirectory.TAG_EXIF_DATA_1));
        hashMap2.put("itnu", Integer.valueOf(PhotoshopDirectory.TAG_EXIF_DATA_3));
        hashMap2.put("keyw", Integer.valueOf(PhotoshopDirectory.TAG_XMP_DATA));
        hashMap2.put("ldes", Integer.valueOf(PhotoshopDirectory.TAG_CAPTION_DIGEST));
        hashMap2.put("pcst", Integer.valueOf(PhotoshopDirectory.TAG_PRINT_SCALE));
        hashMap2.put("perf", 1063);
        hashMap2.put("pgap", Integer.valueOf(PhotoshopDirectory.TAG_PIXEL_ASPECT_RATIO));
        hashMap2.put("plID", Integer.valueOf(PhotoshopDirectory.TAG_LAYER_COMPS));
        hashMap2.put("prID", Integer.valueOf(PhotoshopDirectory.TAG_ALTERNATE_DUOTONE_COLORS));
        hashMap2.put("purd", Integer.valueOf(PhotoshopDirectory.TAG_ALTERNATE_SPOT_COLORS));
        hashMap2.put("purl", 1068);
        hashMap2.put(ReactVideoViewManager.PROP_RATE, Integer.valueOf(PhotoshopDirectory.TAG_LAYER_SELECTION_IDS));
        hashMap2.put("rldt", Integer.valueOf(PhotoshopDirectory.TAG_HDR_TONING_INFO));
        hashMap2.put("rtng", Integer.valueOf(PhotoshopDirectory.TAG_PRINT_INFO));
        hashMap2.put("sfID", Integer.valueOf(PhotoshopDirectory.TAG_LAYER_GROUPS_ENABLED_ID));
        hashMap2.put("soaa", Integer.valueOf(PhotoshopDirectory.TAG_COLOR_SAMPLERS));
        hashMap2.put("soal", Integer.valueOf(PhotoshopDirectory.TAG_MEASUREMENT_SCALE));
        hashMap2.put("soar", Integer.valueOf(PhotoshopDirectory.TAG_TIMELINE_INFORMATION));
        hashMap2.put("soco", Integer.valueOf(PhotoshopDirectory.TAG_SHEET_DISCLOSURE));
        hashMap2.put("sonm", Integer.valueOf(PhotoshopDirectory.TAG_DISPLAY_INFO));
        hashMap2.put("sosn", Integer.valueOf(PhotoshopDirectory.TAG_ONION_SKINS));
        hashMap2.put("stik", 1079);
        hashMap2.put("titl", Integer.valueOf(PhotoshopDirectory.TAG_COUNT_INFORMATION));
        hashMap2.put("tmpo", 1081);
        hashMap2.put("trkn", Integer.valueOf(PhotoshopDirectory.TAG_PRINT_INFO_2));
        hashMap2.put("tven", Integer.valueOf(PhotoshopDirectory.TAG_PRINT_STYLE));
        hashMap2.put("tves", Integer.valueOf(PhotoshopDirectory.TAG_MAC_NSPRINTINFO));
        hashMap2.put("tvnn", Integer.valueOf(PhotoshopDirectory.TAG_WIN_DEVMODE));
        hashMap2.put("tvsh", Integer.valueOf(PhotoshopDirectory.TAG_AUTO_SAVE_FILE_PATH));
        hashMap2.put("tvsn", Integer.valueOf(PhotoshopDirectory.TAG_AUTO_SAVE_FORMAT));
        hashMap2.put("yrrc", Integer.valueOf(PhotoshopDirectory.TAG_PATH_SELECTION_STATE));
        hashMap2.put("�ART", 1089);
        hashMap2.put("�alb", 1090);
        hashMap2.put("�cmt", 1091);
        hashMap2.put("�com", 1092);
        hashMap2.put("�cpy", 1093);
        hashMap2.put("�day", 1094);
        hashMap2.put("�des", 1095);
        hashMap2.put("�enc", 1096);
        hashMap2.put("�gen", 1097);
        hashMap2.put("�grp", 1098);
        hashMap2.put("�lyr", 1099);
        hashMap2.put("�nam", 1100);
        hashMap2.put("�nrt", 1101);
        hashMap2.put("�pub", 1102);
        hashMap2.put("�too", 1103);
        hashMap2.put("�trk", 1104);
        hashMap2.put("�wrt", 1105);
        hashMap.put(valueOf, "Album");
        hashMap.put(valueOf2, ExifInterface.TAG_ARTIST);
        hashMap.put(valueOf3, "Artwork");
        hashMap.put(valueOf4, "Author");
        hashMap.put(valueOf5, "Comment");
        hashMap.put(valueOf6, ExifInterface.TAG_COPYRIGHT);
        hashMap.put(valueOf7, "Creation Date");
        hashMap.put(valueOf8, "Description");
        hashMap.put(1288, "Director");
        hashMap.put(valueOf9, "Title");
        hashMap.put(valueOf10, "Genre");
        hashMap.put(valueOf11, "Information");
        hashMap.put(valueOf12, "Keywords");
        hashMap.put(valueOf13, "ISO 6709");
        hashMap.put(1294, "Producer");
        hashMap.put(Integer.valueOf(OlympusCameraSettingsMakernoteDirectory.TagGradation), "Publisher");
        hashMap.put(1296, ExifInterface.TAG_SOFTWARE);
        hashMap.put(1297, "Year");
        hashMap.put(1298, "Collection User");
        hashMap.put(Integer.valueOf(SonyType6MakernoteDirectory.TAG_MAKERNOTE_THUMB_OFFSET), "Rating User");
        hashMap.put(Integer.valueOf(SonyType6MakernoteDirectory.TAG_MAKERNOTE_THUMB_LENGTH), "Location Name");
        hashMap.put(1301, "Location Body");
        hashMap.put(1302, "Location Note");
        hashMap.put(1303, "Location Role");
        hashMap.put(1304, "Location Date");
        hashMap.put(1305, "Direction Facing");
        hashMap.put(1306, "Direction Motion");
        hashMap.put(1307, "Display Name");
        hashMap.put(1308, "Content Identifier");
        hashMap.put(1309, ExifInterface.TAG_MAKE);
        hashMap.put(1310, ExifInterface.TAG_MODEL);
        hashMap.put(1311, "Originating Signature");
        hashMap.put(1024, "iTunes Info");
        hashMap.put(1025, "Parent Short Title");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_LAYERS_GROUP_INFORMATION), "Parent Product ID");
        hashMap.put(1027, "Parent Title");
        hashMap.put(1028, "Short Title");
        hashMap.put(1029, "Unknown_AACR?");
        hashMap.put(1030, "Unknown_CDEK?");
        hashMap.put(Integer.valueOf(LeicaType5MakernoteDirectory.TagOriginalFileName), "Unknown_CDET?");
        hashMap.put(1032, "GUID");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_THUMBNAIL_OLD), "Product Version");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_COPYRIGHT), "Album Artist");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_URL), "Apple Store Account Type");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_THUMBNAIL), "Album");
        hashMap.put(1037, "Apple Store Account");
        hashMap.put(1038, "Album Title ID");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_ICC_PROFILE_BYTES), "Author");
        hashMap.put(1040, "Category");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_ICC_UNTAGGED_PROFILE), "Apple Store Catalog ID");
        hashMap.put(1042, "Cover Art");
        hashMap.put(1043, "Compilation");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_SEED_NUMBER), ExifInterface.TAG_COPYRIGHT);
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_UNICODE_ALPHA_NAMES), "Description");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_INDEXED_COLOR_TABLE_COUNT), "Disk Number");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_TRANSPARENCY_INDEX), "Description");
        hashMap.put(1048, "Episode Global Unique ID");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_GLOBAL_ALTITUDE), "Genre ID");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_SLICES), "Genre");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_WORKFLOW_URL), "Grouping");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_JUMP_TO_XPEP), "Google Host Header");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_ALPHA_IDENTIFIERS), "Google Ping Message");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_URL_LIST), "Google Ping URL");
        hashMap.put(1055, "Google Source Data");
        hashMap.put(1056, "Google Start Time");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_VERSION), "Google Track Duration");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_EXIF_DATA_1), "HD Video");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_EXIF_DATA_3), "iTunes U");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_XMP_DATA), "Keyword");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_CAPTION_DIGEST), "Long Description");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_PRINT_SCALE), "Podcast");
        hashMap.put(1063, "Performer");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_PIXEL_ASPECT_RATIO), "Play Gap");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_LAYER_COMPS), "Play List ID");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_ALTERNATE_DUOTONE_COLORS), "Product ID");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_ALTERNATE_SPOT_COLORS), "Purchase Date");
        hashMap.put(1068, "Podcast URL");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_LAYER_SELECTION_IDS), "Rating Percent");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_HDR_TONING_INFO), "Release Date");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_PRINT_INFO), "Rating");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_LAYER_GROUPS_ENABLED_ID), "Apple Store Country");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_COLOR_SAMPLERS), "Sort Album Artist");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_MEASUREMENT_SCALE), "Sort Album");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_TIMELINE_INFORMATION), "Sort Artist");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_SHEET_DISCLOSURE), "Sort Composer");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_DISPLAY_INFO), "Sort Name");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_ONION_SKINS), "Sort Show");
        hashMap.put(1079, "Media Type");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_COUNT_INFORMATION), "Title");
        hashMap.put(1081, "Beats Per Minute");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_PRINT_INFO_2), "Track Number");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_PRINT_STYLE), "TV Episode ID");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_MAC_NSPRINTINFO), "TV Episode");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_WIN_DEVMODE), "TV Network Name");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_AUTO_SAVE_FILE_PATH), "TV Show");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_AUTO_SAVE_FORMAT), "TV Season");
        hashMap.put(Integer.valueOf(PhotoshopDirectory.TAG_PATH_SELECTION_STATE), "Year");
        hashMap.put(1089, ExifInterface.TAG_ARTIST);
        hashMap.put(1090, "Album");
        hashMap.put(1091, "Comment");
        hashMap.put(1092, "Composer");
        hashMap.put(1093, ExifInterface.TAG_COPYRIGHT);
        hashMap.put(1094, "Content Create Date");
        hashMap.put(1095, "Description");
        hashMap.put(1096, "Encoded By");
        hashMap.put(1097, "Genre");
        hashMap.put(1098, "Grouping");
        hashMap.put(1099, "Lyrics");
        hashMap.put(1100, "Title");
        hashMap.put(1101, "Narrator");
        hashMap.put(1102, "Publisher");
        hashMap.put(1103, "Encoder");
        hashMap.put(1104, "Track");
        hashMap.put(1105, "Composer");
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
