package com.drew.metadata.exif.makernotes;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.drew.metadata.TagDescriptor;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.facebook.imageutils.JfifUtil;
import com.nimbusds.jose.shaded.ow2asm.Opcodes;
import java.text.DecimalFormat;
import java.util.HashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.math.Primes;

public class CanonMakernoteDescriptor extends TagDescriptor<CanonMakernoteDirectory> {
    private static final HashMap<Integer, String> _lensTypeById;

    private double decodeCanonEv(int i) {
        int i2;
        if (i < 0) {
            i = -i;
            i2 = -1;
        } else {
            i2 = 1;
        }
        int i3 = i & 31;
        int i4 = i - i3;
        if (i3 == 12) {
            i3 = 10;
        } else if (i3 == 20) {
            i3 = 21;
        }
        return ((double) (i2 * (i4 + i3))) / 32.0d;
    }

    public CanonMakernoteDescriptor(CanonMakernoteDirectory canonMakernoteDirectory) {
        super(canonMakernoteDirectory);
    }

    public String getDescription(int i) {
        switch (i) {
            case 12:
                return getSerialNumberDescription();
            case CanonMakernoteDirectory.CameraSettings.TAG_FOCUS_MODE_1 /*49415*/:
                return getFocusMode1Description();
            case CanonMakernoteDirectory.CameraSettings.TAG_COLOR_TONE /*49449*/:
                return getColorToneDescription();
            case CanonMakernoteDirectory.CameraSettings.TAG_SRAW_QUALITY /*49453*/:
                return getSRawQualityDescription();
            case CanonMakernoteDirectory.FocalLength.TAG_WHITE_BALANCE /*49671*/:
                return getWhiteBalanceDescription();
            case CanonMakernoteDirectory.AFInfo.TAG_AF_POINTS_IN_FOCUS /*53770*/:
                return getTagAfPointsInFocus();
            default:
                switch (i) {
                    case CanonMakernoteDirectory.CameraSettings.TAG_MACRO_MODE /*49409*/:
                        return getMacroModeDescription();
                    case CanonMakernoteDirectory.CameraSettings.TAG_SELF_TIMER_DELAY /*49410*/:
                        return getSelfTimerDelayDescription();
                    case CanonMakernoteDirectory.CameraSettings.TAG_QUALITY /*49411*/:
                        return getQualityDescription();
                    case CanonMakernoteDirectory.CameraSettings.TAG_FLASH_MODE /*49412*/:
                        return getFlashModeDescription();
                    case CanonMakernoteDirectory.CameraSettings.TAG_CONTINUOUS_DRIVE_MODE /*49413*/:
                        return getContinuousDriveModeDescription();
                    default:
                        switch (i) {
                            case CanonMakernoteDirectory.CameraSettings.TAG_RECORD_MODE /*49417*/:
                                return getRecordModeDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_IMAGE_SIZE /*49418*/:
                                return getImageSizeDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_EASY_SHOOTING_MODE /*49419*/:
                                return getEasyShootingModeDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_DIGITAL_ZOOM /*49420*/:
                                return getDigitalZoomDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_CONTRAST /*49421*/:
                                return getContrastDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_SATURATION /*49422*/:
                                return getSaturationDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_SHARPNESS /*49423*/:
                                return getSharpnessDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_ISO /*49424*/:
                                return getIsoDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_METERING_MODE /*49425*/:
                                return getMeteringModeDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_FOCUS_TYPE /*49426*/:
                                return getFocusTypeDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_AF_POINT_SELECTED /*49427*/:
                                return getAfPointSelectedDescription();
                            case CanonMakernoteDirectory.CameraSettings.TAG_EXPOSURE_MODE /*49428*/:
                                return getExposureModeDescription();
                            default:
                                switch (i) {
                                    case CanonMakernoteDirectory.CameraSettings.TAG_LENS_TYPE /*49430*/:
                                        return getLensTypeDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_LONG_FOCAL_LENGTH /*49431*/:
                                        return getLongFocalLengthDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_SHORT_FOCAL_LENGTH /*49432*/:
                                        return getShortFocalLengthDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_FOCAL_UNITS_PER_MM /*49433*/:
                                        return getFocalUnitsPerMillimetreDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_MAX_APERTURE /*49434*/:
                                        return getMaxApertureDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_MIN_APERTURE /*49435*/:
                                        return getMinApertureDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_FLASH_ACTIVITY /*49436*/:
                                        return getFlashActivityDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_FLASH_DETAILS /*49437*/:
                                        return getFlashDetailsDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_FOCUS_CONTINUOUS /*49438*/:
                                        return getFocusContinuousDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_AE_SETTING /*49439*/:
                                        return getAESettingDescription();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_FOCUS_MODE_2 /*49440*/:
                                        return getFocusMode2Description();
                                    case CanonMakernoteDirectory.CameraSettings.TAG_DISPLAY_APERTURE /*49441*/:
                                        return getDisplayApertureDescription();
                                    default:
                                        switch (i) {
                                            case CanonMakernoteDirectory.CameraSettings.TAG_SPOT_METERING_MODE /*49445*/:
                                                return getSpotMeteringModeDescription();
                                            case CanonMakernoteDirectory.CameraSettings.TAG_PHOTO_EFFECT /*49446*/:
                                                return getPhotoEffectDescription();
                                            case CanonMakernoteDirectory.CameraSettings.TAG_MANUAL_FLASH_OUTPUT /*49447*/:
                                                return getManualFlashOutputDescription();
                                            default:
                                                switch (i) {
                                                    case CanonMakernoteDirectory.FocalLength.TAG_AF_POINT_USED /*49678*/:
                                                        return getAfPointUsedDescription();
                                                    case CanonMakernoteDirectory.FocalLength.TAG_FLASH_BIAS /*49679*/:
                                                        return getFlashBiasDescription();
                                                    default:
                                                        return super.getDescription(i);
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public String getSerialNumberDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(12);
        if (integer == null) {
            return null;
        }
        return String.format("%04X%05d", new Object[]{Integer.valueOf((integer.intValue() >> 8) & 255), Integer.valueOf(integer.intValue() & 255)});
    }

    public String getFlashBiasDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.FocalLength.TAG_FLASH_BIAS);
        if (integer == null) {
            return null;
        }
        boolean z = false;
        if (integer.intValue() > 61440) {
            integer = Integer.valueOf(Integer.valueOf(65535 - integer.intValue()).intValue() + 1);
            z = true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "-" : "");
        sb.append(Float.toString(((float) integer.intValue()) / 32.0f));
        sb.append(" EV");
        return sb.toString();
    }

    public String getAfPointUsedDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.FocalLength.TAG_AF_POINT_USED);
        if (integer == null) {
            return null;
        }
        if ((integer.intValue() & 7) == 0) {
            return "Right";
        }
        if ((integer.intValue() & 7) == 1) {
            return "Centre";
        }
        if ((integer.intValue() & 7) == 2) {
            return "Left";
        }
        return "Unknown (" + integer + ")";
    }

    public String getTagAfPointsInFocus() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.AFInfo.TAG_AF_POINTS_IN_FOCUS);
        if (integer == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            if ((integer.intValue() & (1 << i)) != 0) {
                if (sb.length() != 0) {
                    sb.append(AbstractJsonLexerKt.COMMA);
                }
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "None" : sb.toString();
    }

    public String getWhiteBalanceDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.FocalLength.TAG_WHITE_BALANCE, "Auto", "Sunny", "Cloudy", "Tungsten", "Florescent", ExifInterface.TAG_FLASH, TypedValues.Custom.NAME);
    }

    public String getFocusMode2Description() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_FOCUS_MODE_2, "Single", "Continuous");
    }

    public String getFlashDetailsDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_FLASH_DETAILS);
        if (integer == null) {
            return null;
        }
        if (((integer.intValue() >> 14) & 1) != 0) {
            return "External E-TTL";
        }
        if (((integer.intValue() >> 13) & 1) != 0) {
            return "Internal flash";
        }
        if (((integer.intValue() >> 11) & 1) != 0) {
            return "FP sync used";
        }
        if (((integer.intValue() >> 4) & 1) != 0) {
            return "FP sync enabled";
        }
        return "Unknown (" + integer + ")";
    }

    public String getFocalUnitsPerMillimetreDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_FOCAL_UNITS_PER_MM);
        if (integer == null) {
            return null;
        }
        return integer.intValue() != 0 ? Integer.toString(integer.intValue()) : "";
    }

    public String getShortFocalLengthDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_SHORT_FOCAL_LENGTH);
        if (integer == null) {
            return null;
        }
        String focalUnitsPerMillimetreDescription = getFocalUnitsPerMillimetreDescription();
        return Integer.toString(integer.intValue()) + StringUtils.SPACE + focalUnitsPerMillimetreDescription;
    }

    public String getLongFocalLengthDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_LONG_FOCAL_LENGTH);
        if (integer == null) {
            return null;
        }
        String focalUnitsPerMillimetreDescription = getFocalUnitsPerMillimetreDescription();
        return Integer.toString(integer.intValue()) + StringUtils.SPACE + focalUnitsPerMillimetreDescription;
    }

    public String getExposureModeDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_EXPOSURE_MODE, "Easy shooting", "Program", "Tv-priority", "Av-priority", "Manual", "A-DEP");
    }

    public String getLensTypeDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_LENS_TYPE);
        if (integer == null) {
            return null;
        }
        HashMap<Integer, String> hashMap = _lensTypeById;
        if (hashMap.containsKey(integer)) {
            return hashMap.get(integer);
        }
        return String.format("Unknown (%d)", new Object[]{integer});
    }

    public String getMaxApertureDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_MAX_APERTURE);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() <= 512) {
            return getFStopDescription(Math.exp((decodeCanonEv(integer.intValue()) * Math.log(2.0d)) / 2.0d));
        }
        return String.format("Unknown (%d)", new Object[]{integer});
    }

    public String getMinApertureDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_MIN_APERTURE);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() <= 512) {
            return getFStopDescription(Math.exp((decodeCanonEv(integer.intValue()) * Math.log(2.0d)) / 2.0d));
        }
        return String.format("Unknown (%d)", new Object[]{integer});
    }

    public String getAfPointSelectedDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_AF_POINT_SELECTED, 12288, "None (MF)", "Auto selected", "Right", "Centre", "Left");
    }

    public String getMeteringModeDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_METERING_MODE, 3, "Evaluative", "Partial", "Centre weighted");
    }

    public String getIsoDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_ISO);
        if (integer == null) {
            return null;
        }
        if ((integer.intValue() & 16384) != 0) {
            return "" + (integer.intValue() & -16385);
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Not specified (see ISOSpeedRatings tag)";
        }
        switch (intValue) {
            case 15:
                return "Auto";
            case 16:
                return "50";
            case 17:
                return "100";
            case 18:
                return "200";
            case 19:
                return "400";
            default:
                return "Unknown (" + integer + ")";
        }
    }

    public String getSharpnessDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_SHARPNESS);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Normal";
        }
        if (intValue == 1) {
            return "High";
        }
        if (intValue == 65535) {
            return "Low";
        }
        return "Unknown (" + integer + ")";
    }

    public String getSaturationDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_SATURATION);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Normal";
        }
        if (intValue == 1) {
            return "High";
        }
        if (intValue == 65535) {
            return "Low";
        }
        return "Unknown (" + integer + ")";
    }

    public String getContrastDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_CONTRAST);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Normal";
        }
        if (intValue == 1) {
            return "High";
        }
        if (intValue == 65535) {
            return "Low";
        }
        return "Unknown (" + integer + ")";
    }

    public String getEasyShootingModeDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_EASY_SHOOTING_MODE, "Full auto", "Manual", "Landscape", "Fast shutter", "Slow shutter", "Night", "B&W", "Sepia", "Portrait", "Sports", "Macro / Closeup", "Pan focus");
    }

    public String getImageSizeDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_IMAGE_SIZE, "Large", "Medium", "Small");
    }

    public String getFocusMode1Description() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_FOCUS_MODE_1, "One-shot", "AI Servo", "AI Focus", "Manual Focus", "Single", "Continuous", "Manual Focus");
    }

    public String getContinuousDriveModeDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_CONTINUOUS_DRIVE_MODE);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            Integer integer2 = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_SELF_TIMER_DELAY);
            if (integer2 != null) {
                return integer2.intValue() == 0 ? "Single shot" : "Single shot with self-timer";
            }
            return "Continuous";
        } else if (intValue == 1) {
            return "Continuous";
        } else {
            return "Unknown (" + integer + ")";
        }
    }

    public String getFlashModeDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_FLASH_MODE);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 16) {
            return "External flash";
        }
        switch (intValue) {
            case 0:
                return "No flash fired";
            case 1:
                return "Auto";
            case 2:
                return "On";
            case 3:
                return "Red-eye reduction";
            case 4:
                return "Slow-synchro";
            case 5:
                return "Auto and red-eye reduction";
            case 6:
                return "On and red-eye reduction";
            default:
                return "Unknown (" + integer + ")";
        }
    }

    public String getSelfTimerDelayDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_SELF_TIMER_DELAY);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() == 0) {
            return "Self timer not used";
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        return decimalFormat.format(((double) integer.intValue()) * 0.1d) + " sec";
    }

    public String getMacroModeDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_MACRO_MODE, 1, "Macro", "Normal");
    }

    public String getQualityDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_QUALITY, 2, "Normal", "Fine", null, "Superfine");
    }

    public String getDigitalZoomDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_DIGITAL_ZOOM, "No digital zoom", "2x", "4x");
    }

    public String getRecordModeDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_RECORD_MODE, 1, "JPEG", "CRW+THM", "AVI+THM", "TIF", "TIF+JPEG", "CR2", "CR2+JPEG", null, "MOV", "MP4");
    }

    public String getFocusTypeDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_FOCUS_TYPE);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Manual";
        }
        if (intValue == 1) {
            return "Auto";
        }
        if (intValue == 3) {
            return "Close-up (Macro)";
        }
        if (intValue == 8) {
            return "Locked (Pan Mode)";
        }
        return "Unknown (" + integer + ")";
    }

    public String getFlashActivityDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_FLASH_ACTIVITY, "Flash did not fire", "Flash fired");
    }

    public String getFocusContinuousDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_FOCUS_CONTINUOUS, 0, "Single", "Continuous", null, null, null, null, null, null, "Manual");
    }

    public String getAESettingDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_AE_SETTING, 0, "Normal AE", "Exposure Compensation", "AE Lock", "AE Lock + Exposure Comp.", "No AE");
    }

    public String getDisplayApertureDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_DISPLAY_APERTURE);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() == 65535) {
            return integer.toString();
        }
        return getFStopDescription((double) (((float) integer.intValue()) / 10.0f));
    }

    public String getSpotMeteringModeDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_SPOT_METERING_MODE, 0, "Center", "AF Point");
    }

    public String getPhotoEffectDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_PHOTO_EFFECT);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 100) {
            return "My Color Data";
        }
        switch (intValue) {
            case 0:
                return "Off";
            case 1:
                return "Vivid";
            case 2:
                return "Neutral";
            case 3:
                return "Smooth";
            case 4:
                return "Sepia";
            case 5:
                return "B&W";
            case 6:
                return TypedValues.Custom.NAME;
            default:
                return "Unknown (" + integer + ")";
        }
    }

    public String getManualFlashOutputDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_MANUAL_FLASH_OUTPUT);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "n/a";
        }
        if (intValue == 1280) {
            return "Full";
        }
        if (intValue == 1282) {
            return "Medium";
        }
        if (intValue == 1284) {
            return "Low";
        }
        if (intValue == 32767) {
            return "n/a";
        }
        return "Unknown (" + integer + ")";
    }

    public String getColorToneDescription() {
        Integer integer = ((CanonMakernoteDirectory) this._directory).getInteger(CanonMakernoteDirectory.CameraSettings.TAG_COLOR_TONE);
        if (integer == null) {
            return null;
        }
        return integer.intValue() == 32767 ? "n/a" : integer.toString();
    }

    public String getSRawQualityDescription() {
        return getIndexedDescription(CanonMakernoteDirectory.CameraSettings.TAG_SRAW_QUALITY, 0, "n/a", "sRAW1 (mRAW)", "sRAW2 (sRAW)");
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        _lensTypeById = hashMap;
        hashMap.put(1, "Canon EF 50mm f/1.8");
        hashMap.put(2, "Canon EF 28mm f/2.8");
        hashMap.put(3, "Canon EF 135mm f/2.8 Soft");
        hashMap.put(4, "Canon EF 35-105mm f/3.5-4.5 or Sigma Lens");
        hashMap.put(5, "Canon EF 35-70mm f/3.5-4.5");
        hashMap.put(6, "Canon EF 28-70mm f/3.5-4.5 or Sigma or Tokina Lens");
        hashMap.put(7, "Canon EF 100-300mm f/5.6L");
        hashMap.put(8, "Canon EF 100-300mm f/5.6 or Sigma or Tokina Lens");
        hashMap.put(9, "Canon EF 70-210mm f/4");
        hashMap.put(10, "Canon EF 50mm f/2.5 Macro or Sigma Lens");
        hashMap.put(11, "Canon EF 35mm f/2");
        hashMap.put(13, "Canon EF 15mm f/2.8 Fisheye");
        hashMap.put(14, "Canon EF 50-200mm f/3.5-4.5L");
        hashMap.put(15, "Canon EF 50-200mm f/3.5-4.5");
        hashMap.put(16, "Canon EF 35-135mm f/3.5-4.5");
        hashMap.put(17, "Canon EF 35-70mm f/3.5-4.5A");
        hashMap.put(18, "Canon EF 28-70mm f/3.5-4.5");
        hashMap.put(20, "Canon EF 100-200mm f/4.5A");
        hashMap.put(21, "Canon EF 80-200mm f/2.8L");
        hashMap.put(22, "Canon EF 20-35mm f/2.8L or Tokina Lens");
        hashMap.put(23, "Canon EF 35-105mm f/3.5-4.5");
        hashMap.put(24, "Canon EF 35-80mm f/4-5.6 Power Zoom");
        hashMap.put(25, "Canon EF 35-80mm f/4-5.6 Power Zoom");
        hashMap.put(26, "Canon EF 100mm f/2.8 Macro or Other Lens");
        hashMap.put(27, "Canon EF 35-80mm f/4-5.6");
        hashMap.put(28, "Canon EF 80-200mm f/4.5-5.6 or Tamron Lens");
        hashMap.put(29, "Canon EF 50mm f/1.8 II");
        hashMap.put(30, "Canon EF 35-105mm f/4.5-5.6");
        hashMap.put(31, "Canon EF 75-300mm f/4-5.6 or Tamron Lens");
        hashMap.put(32, "Canon EF 24mm f/2.8 or Sigma Lens");
        hashMap.put(33, "Voigtlander or Carl Zeiss Lens");
        hashMap.put(35, "Canon EF 35-80mm f/4-5.6");
        hashMap.put(36, "Canon EF 38-76mm f/4.5-5.6");
        hashMap.put(37, "Canon EF 35-80mm f/4-5.6 or Tamron Lens");
        hashMap.put(38, "Canon EF 80-200mm f/4.5-5.6");
        hashMap.put(39, "Canon EF 75-300mm f/4-5.6");
        hashMap.put(40, "Canon EF 28-80mm f/3.5-5.6");
        hashMap.put(41, "Canon EF 28-90mm f/4-5.6");
        hashMap.put(42, "Canon EF 28-200mm f/3.5-5.6 or Tamron Lens");
        hashMap.put(43, "Canon EF 28-105mm f/4-5.6");
        hashMap.put(44, "Canon EF 90-300mm f/4.5-5.6");
        hashMap.put(45, "Canon EF-S 18-55mm f/3.5-5.6 [II]");
        hashMap.put(46, "Canon EF 28-90mm f/4-5.6");
        hashMap.put(47, "Zeiss Milvus 35mm f/2 or 50mm f/2");
        hashMap.put(48, "Canon EF-S 18-55mm f/3.5-5.6 IS");
        hashMap.put(49, "Canon EF-S 55-250mm f/4-5.6 IS");
        hashMap.put(50, "Canon EF-S 18-200mm f/3.5-5.6 IS");
        hashMap.put(51, "Canon EF-S 18-135mm f/3.5-5.6 IS");
        hashMap.put(52, "Canon EF-S 18-55mm f/3.5-5.6 IS II");
        hashMap.put(53, "Canon EF-S 18-55mm f/3.5-5.6 III");
        hashMap.put(54, "Canon EF-S 55-250mm f/4-5.6 IS II");
        hashMap.put(94, "Canon TS-E 17mm f/4L");
        hashMap.put(95, "Canon TS-E 24.0mm f/3.5 L II");
        hashMap.put(124, "Canon MP-E 65mm f/2.8 1-5x Macro Photo");
        hashMap.put(125, "Canon TS-E 24mm f/3.5L");
        hashMap.put(126, "Canon TS-E 45mm f/2.8");
        hashMap.put(127, "Canon TS-E 90mm f/2.8");
        hashMap.put(129, "Canon EF 300mm f/2.8L");
        hashMap.put(130, "Canon EF 50mm f/1.0L");
        hashMap.put(131, "Canon EF 28-80mm f/2.8-4L or Sigma Lens");
        hashMap.put(132, "Canon EF 1200mm f/5.6L");
        hashMap.put(134, "Canon EF 600mm f/4L IS");
        hashMap.put(135, "Canon EF 200mm f/1.8L");
        hashMap.put(136, "Canon EF 300mm f/2.8L");
        hashMap.put(137, "Canon EF 85mm f/1.2L or Sigma or Tamron Lens");
        hashMap.put(138, "Canon EF 28-80mm f/2.8-4L");
        hashMap.put(139, "Canon EF 400mm f/2.8L");
        hashMap.put(140, "Canon EF 500mm f/4.5L");
        hashMap.put(141, "Canon EF 500mm f/4.5L");
        hashMap.put(142, "Canon EF 300mm f/2.8L IS");
        hashMap.put(143, "Canon EF 500mm f/4L IS or Sigma Lens");
        hashMap.put(144, "Canon EF 35-135mm f/4-5.6 USM");
        hashMap.put(145, "Canon EF 100-300mm f/4.5-5.6 USM");
        hashMap.put(146, "Canon EF 70-210mm f/3.5-4.5 USM");
        hashMap.put(147, "Canon EF 35-135mm f/4-5.6 USM");
        hashMap.put(148, "Canon EF 28-80mm f/3.5-5.6 USM");
        hashMap.put(149, "Canon EF 100mm f/2 USM");
        hashMap.put(150, "Canon EF 14mm f/2.8L or Sigma Lens");
        hashMap.put(151, "Canon EF 200mm f/2.8L");
        hashMap.put(152, "Canon EF 300mm f/4L IS or Sigma Lens");
        hashMap.put(153, "Canon EF 35-350mm f/3.5-5.6L or Sigma or Tamron Lens");
        hashMap.put(154, "Canon EF 20mm f/2.8 USM or Zeiss Lens");
        hashMap.put(155, "Canon EF 85mm f/1.8 USM");
        hashMap.put(156, "Canon EF 28-105mm f/3.5-4.5 USM or Tamron Lens");
        hashMap.put(160, "Canon EF 20-35mm f/3.5-4.5 USM or Tamron or Tokina Lens");
        hashMap.put(161, "Canon EF 28-70mm f/2.8L or Sigma or Tamron Lens");
        hashMap.put(162, "Canon EF 200mm f/2.8L");
        hashMap.put(163, "Canon EF 300mm f/4L");
        hashMap.put(164, "Canon EF 400mm f/5.6L");
        hashMap.put(165, "Canon EF 70-200mm f/2.8 L");
        hashMap.put(166, "Canon EF 70-200mm f/2.8 L + 1.4x");
        hashMap.put(167, "Canon EF 70-200mm f/2.8 L + 2x");
        hashMap.put(168, "Canon EF 28mm f/1.8 USM or Sigma Lens");
        hashMap.put(169, "Canon EF 17-35mm f/2.8L or Sigma Lens");
        hashMap.put(170, "Canon EF 200mm f/2.8L II");
        hashMap.put(171, "Canon EF 300mm f/4L");
        hashMap.put(172, "Canon EF 400mm f/5.6L or Sigma Lens");
        hashMap.put(173, "Canon EF 180mm Macro f/3.5L or Sigma Lens");
        hashMap.put(174, "Canon EF 135mm f/2L or Other Lens");
        hashMap.put(175, "Canon EF 400mm f/2.8L");
        hashMap.put(176, "Canon EF 24-85mm f/3.5-4.5 USM");
        hashMap.put(177, "Canon EF 300mm f/4L IS");
        hashMap.put(178, "Canon EF 28-135mm f/3.5-5.6 IS");
        hashMap.put(179, "Canon EF 24mm f/1.4L");
        hashMap.put(180, "Canon EF 35mm f/1.4L or Other Lens");
        hashMap.put(181, "Canon EF 100-400mm f/4.5-5.6L IS + 1.4x or Sigma Lens");
        hashMap.put(182, "Canon EF 100-400mm f/4.5-5.6L IS + 2x or Sigma Lens");
        hashMap.put(183, "Canon EF 100-400mm f/4.5-5.6L IS or Sigma Lens");
        hashMap.put(184, "Canon EF 400mm f/2.8L + 2x");
        hashMap.put(185, "Canon EF 600mm f/4L IS");
        hashMap.put(Integer.valueOf(Opcodes.INVOKEDYNAMIC), "Canon EF 70-200mm f/4L");
        hashMap.put(187, "Canon EF 70-200mm f/4L + 1.4x");
        hashMap.put(188, "Canon EF 70-200mm f/4L + 2x");
        hashMap.put(189, "Canon EF 70-200mm f/4L + 2.8x");
        hashMap.put(Integer.valueOf(Opcodes.ARRAYLENGTH), "Canon EF 100mm f/2.8 Macro USM");
        hashMap.put(Integer.valueOf(Opcodes.ATHROW), "Canon EF 400mm f/4 DO IS");
        hashMap.put(Integer.valueOf(Opcodes.INSTANCEOF), "Canon EF 35-80mm f/4-5.6 USM");
        hashMap.put(Integer.valueOf(Opcodes.MONITORENTER), "Canon EF 80-200mm f/4.5-5.6 USM");
        hashMap.put(Integer.valueOf(Opcodes.MONITOREXIT), "Canon EF 35-105mm f/4.5-5.6 USM");
        hashMap.put(196, "Canon EF 75-300mm f/4-5.6 USM");
        hashMap.put(Integer.valueOf(Opcodes.MULTIANEWARRAY), "Canon EF 75-300mm f/4-5.6 IS USM");
        hashMap.put(Integer.valueOf(Opcodes.IFNULL), "Canon EF 50mm f/1.4 USM or Zeiss Lens");
        hashMap.put(Integer.valueOf(Opcodes.IFNONNULL), "Canon EF 28-80mm f/3.5-5.6 USM");
        hashMap.put(200, "Canon EF 75-300mm f/4-5.6 USM");
        hashMap.put(201, "Canon EF 28-80mm f/3.5-5.6 USM");
        hashMap.put(202, "Canon EF 28-80mm f/3.5-5.6 USM IV");
        hashMap.put(208, "Canon EF 22-55mm f/4-5.6 USM");
        hashMap.put(209, "Canon EF 55-200mm f/4.5-5.6");
        hashMap.put(210, "Canon EF 28-90mm f/4-5.6 USM");
        hashMap.put(Integer.valueOf(Primes.SMALL_FACTOR_LIMIT), "Canon EF 28-200mm f/3.5-5.6 USM");
        hashMap.put(212, "Canon EF 28-105mm f/4-5.6 USM");
        hashMap.put(213, "Canon EF 90-300mm f/4.5-5.6 USM or Tamron Lens");
        hashMap.put(214, "Canon EF-S 18-55mm f/3.5-5.6 USM");
        hashMap.put(Integer.valueOf(JfifUtil.MARKER_RST7), "Canon EF 55-200mm f/4.5-5.6 II USM");
        hashMap.put(Integer.valueOf(JfifUtil.MARKER_EOI), "Tamron AF 18-270mm f/3.5-6.3 Di II VC PZD");
        hashMap.put(Integer.valueOf(CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY), "Canon EF 70-200mm f/2.8L IS");
        hashMap.put(Integer.valueOf(JfifUtil.MARKER_APP1), "Canon EF 70-200mm f/2.8L IS + 1.4x");
        hashMap.put(226, "Canon EF 70-200mm f/2.8L IS + 2x");
        hashMap.put(227, "Canon EF 70-200mm f/2.8L IS + 2.8x");
        hashMap.put(228, "Canon EF 28-105mm f/3.5-4.5 USM");
        hashMap.put(229, "Canon EF 16-35mm f/2.8L");
        hashMap.put(230, "Canon EF 24-70mm f/2.8L");
        hashMap.put(231, "Canon EF 17-40mm f/4L");
        hashMap.put(232, "Canon EF 70-300mm f/4.5-5.6 DO IS USM");
        hashMap.put(233, "Canon EF 28-300mm f/3.5-5.6L IS");
        hashMap.put(234, "Canon EF-S 17-85mm f/4-5.6 IS USM or Tokina Lens");
        hashMap.put(235, "Canon EF-S 10-22mm f/3.5-4.5 USM");
        hashMap.put(236, "Canon EF-S 60mm f/2.8 Macro USM");
        hashMap.put(237, "Canon EF 24-105mm f/4L IS");
        hashMap.put(238, "Canon EF 70-300mm f/4-5.6 IS USM");
        hashMap.put(239, "Canon EF 85mm f/1.2L II");
        hashMap.put(240, "Canon EF-S 17-55mm f/2.8 IS USM");
        hashMap.put(241, "Canon EF 50mm f/1.2L");
        hashMap.put(242, "Canon EF 70-200mm f/4L IS");
        hashMap.put(243, "Canon EF 70-200mm f/4L IS + 1.4x");
        hashMap.put(244, "Canon EF 70-200mm f/4L IS + 2x");
        hashMap.put(245, "Canon EF 70-200mm f/4L IS + 2.8x");
        hashMap.put(246, "Canon EF 16-35mm f/2.8L II");
        hashMap.put(247, "Canon EF 14mm f/2.8L II USM");
        hashMap.put(248, "Canon EF 200mm f/2L IS or Sigma Lens");
        hashMap.put(249, "Canon EF 800mm f/5.6L IS");
        hashMap.put(Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION), "Canon EF 24mm f/1.4L II or Sigma Lens");
        hashMap.put(251, "Canon EF 70-200mm f/2.8L IS II USM");
        hashMap.put(252, "Canon EF 70-200mm f/2.8L IS II USM + 1.4x");
        hashMap.put(253, "Canon EF 70-200mm f/2.8L IS II USM + 2x");
        hashMap.put(Integer.valueOf(ExifDirectoryBase.TAG_NEW_SUBFILE_TYPE), "Canon EF 100mm f/2.8L Macro IS USM");
        hashMap.put(255, "Sigma 24-105mm f/4 DG OS HSM | A or Other Sigma Lens");
        hashMap.put(488, "Canon EF-S 15-85mm f/3.5-5.6 IS USM");
        hashMap.put(489, "Canon EF 70-300mm f/4-5.6L IS USM");
        hashMap.put(490, "Canon EF 8-15mm f/4L Fisheye USM");
        hashMap.put(491, "Canon EF 300mm f/2.8L IS II USM");
        hashMap.put(492, "Canon EF 400mm f/2.8L IS II USM");
        hashMap.put(493, "Canon EF 500mm f/4L IS II USM or EF 24-105mm f4L IS USM");
        hashMap.put(494, "Canon EF 600mm f/4.0L IS II USM");
        hashMap.put(495, "Canon EF 24-70mm f/2.8L II USM");
        hashMap.put(496, "Canon EF 200-400mm f/4L IS USM");
        hashMap.put(499, "Canon EF 200-400mm f/4L IS USM + 1.4x");
        hashMap.put(Integer.valueOf(TypedValues.PositionType.TYPE_DRAWPATH), "Canon EF 28mm f/2.8 IS USM");
        hashMap.put(Integer.valueOf(TypedValues.PositionType.TYPE_PERCENT_WIDTH), "Canon EF 24mm f/2.8 IS USM");
        hashMap.put(Integer.valueOf(TypedValues.PositionType.TYPE_PERCENT_HEIGHT), "Canon EF 24-70mm f/4L IS USM");
        hashMap.put(Integer.valueOf(TypedValues.PositionType.TYPE_SIZE_PERCENT), "Canon EF 35mm f/2 IS USM");
        hashMap.put(Integer.valueOf(TypedValues.PositionType.TYPE_PERCENT_X), "Canon EF 400mm f/4 DO IS II USM");
        hashMap.put(Integer.valueOf(TypedValues.PositionType.TYPE_PERCENT_Y), "Canon EF 16-35mm f/4L IS USM");
        hashMap.put(Integer.valueOf(TypedValues.PositionType.TYPE_CURVE_FIT), "Canon EF 11-24mm f/4L USM");
        hashMap.put(747, "Canon EF 100-400mm f/4.5-5.6L IS II USM");
        hashMap.put(750, "Canon EF 35mm f/1.4L II USM");
        hashMap.put(Integer.valueOf(OlympusMakernoteDirectory.TAG_OLYMPUS_IMAGE_WIDTH), "Canon EF-S 18-135mm f/3.5-5.6 IS STM");
        hashMap.put(Integer.valueOf(OlympusMakernoteDirectory.TAG_OLYMPUS_IMAGE_HEIGHT), "Canon EF-M 18-55mm f/3.5-5.6 IS STM or Tamron Lens");
        hashMap.put(4144, "Canon EF 40mm f/2.8 STM");
        hashMap.put(4145, "Canon EF-M 22mm f/2 STM");
        hashMap.put(4146, "Canon EF-S 18-55mm f/3.5-5.6 IS STM");
        hashMap.put(4147, "Canon EF-M 11-22mm f/4-5.6 IS STM");
        hashMap.put(4148, "Canon EF-S 55-250mm f/4-5.6 IS STM");
        hashMap.put(Integer.valueOf(OlympusMakernoteDirectory.TAG_PREVIEW_IMAGE_VALID), "Canon EF-M 55-200mm f/4.5-6.3 IS STM");
        hashMap.put(Integer.valueOf(OlympusMakernoteDirectory.TAG_PREVIEW_IMAGE_START), "Canon EF-S 10-18mm f/4.5-5.6 IS STM");
        hashMap.put(Integer.valueOf(OlympusMakernoteDirectory.TAG_AF_RESULT), "Canon EF 24-105mm f/3.5-5.6 IS STM");
        hashMap.put(Integer.valueOf(OlympusMakernoteDirectory.TAG_CCD_SCAN_MODE), "Canon EF-M 15-45mm f/3.5-6.3 IS STM");
        hashMap.put(Integer.valueOf(OlympusMakernoteDirectory.TAG_NOISE_REDUCTION), "Canon EF-S 24mm f/2.8 STM");
        hashMap.put(Integer.valueOf(OlympusMakernoteDirectory.TAG_NEAR_LENS_STEP), "Canon EF 50mm f/1.8 STM");
        hashMap.put(36912, "Canon EF-S 18-135mm f/3.5-5.6 IS USM");
        hashMap.put(65535, "N/A");
    }
}
