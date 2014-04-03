package com.github.rosjava.android_remocons.common_tools;

import org.ros.internal.message.DefaultMessageFactory;
import org.ros.internal.message.definition.MessageDefinitionReflectionProvider;

import rocon_std_msgs.PlatformInfo;
import rocon_std_msgs.Strings;

/**
 * General rocon android app constants and topic/parameter/service names
 *
 * @author jorge@yujinrobot.com (Jorge Santos Simon)
 */
public class RoconConstants {
    public static final int NFC_SSID_FIELD_LENGTH           =  16;
    public static final int NFC_PASSWORD_FIELD_LENGTH       =  16;
    public static final int NFC_MASTER_HOST_FIELD_LENGTH    =  16;
    public static final int NFC_MASTER_PORT_FIELD_LENGTH    =   2;
    public static final int NFC_APP_HASH_FIELD_LENGTH       =   4;
    public static final int NFC_EXTRA_DATA_FIELD_LENGTH     =   2;
    public static final int NFC_APP_RECORD_FIELD_LENGTH     =  56;
    public static final int NFC_PAYLOAD_LENGTH              =  56; // 16 + 16 + 16 + 2 + 4 + 2
    public static final int NFC_ULTRALIGHT_C_MAX_LENGTH     = 137;

//    public static final String CONCERT_NAME_PARAM      = "/concert/name";
//    public static final String CONCERT_INFO_TOPIC      = "/concert/info";
//    public static final String CONCERT_ROLES_TOPIC     = "/concert/interactions/roles";
//
//    public static final String GET_APP_INFO_SRV        = "/concert/interactions/get_app";
//    public static final String GET_ROLES_AND_APPS_SRV  = "/concert/interactions/get_roles_and_apps";
//    public static final String REQUEST_INTERACTION_SRV = "/concert/interactions/request_interaction";

    public static final rocon_std_msgs.PlatformInfo ANDROID_PLATFORM_INFO = makePlatformInfo();

    /**
     * Generate platform information, most specifically, the rocon uri string that is needed.
     *
     * @todo : this doesn't introspect the android phone...
     *
     * @return rocon_std_msgs.PlatformInfo : filled out platform information
     */
    private static PlatformInfo makePlatformInfo() {
        MessageDefinitionReflectionProvider messageDefinitionProvider = new MessageDefinitionReflectionProvider();
        DefaultMessageFactory messageFactory = new DefaultMessageFactory(messageDefinitionProvider);
        PlatformInfo platformInfo = messageFactory.newFromType(PlatformInfo._TYPE);
        platformInfo.setUri("rocon:/"
                        + Strings.URI_WILDCARD + "/"
                        + Strings.APPLICATION_FRAMEWORK_HYDRO + "|" + Strings.APPLICATION_FRAMEWORK_IGLOO
                        + Strings.OS_ICE_CREAM_SANDWICH + "|" + Strings.OS_JELLYBEAN
        );
        platformInfo.setVersion(Strings.ROCON_VERSION);
        /* Not yet implemented */
        /* platformInfo.setIcon() */

        return platformInfo;
    }
}