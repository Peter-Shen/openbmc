SUMMARY = "Open POWER DBus Interfaces"
DESCRIPTION = "Generated bindings, using sdbus++, for the openpower YAML"
PR = "r1"

S = "${WORKDIR}/git"

inherit autotools pkgconfig
inherit obmc-phosphor-license
inherit pythonnative

DEPENDS += "autoconf-archive-native"
DEPENDS += "sdbus++-native"

PACKAGE_BEFORE_PN = "${PN}-yaml"

FILES_${PN}-yaml = "${datadir}/${PN}/yaml"

SRC_URI += "git://github.com/openbmc/openpower-dbus-interfaces"
SRCREV = "569bd13127416a766d89b5dc102ef2b80293daa4"

DEPENDS_remove_class-native = "sdbus++-native"
DEPENDS_remove_class-nativesdk = "sdbus++-native"

PACKAGECONFIG ??= "libopenpower_dbus"
PACKAGECONFIG[libopenpower_dbus] = " \
        --enable-libopenpower_dbus, \
        --disable-libopenpower_dbus, \
        systemd sdbusplus, \
        libsystemd sdbusplus \
        "

PACKAGECONFIG_remove_class-native = "libopenpower_dbus"
PACKAGECONFIG_remove_class-nativesdk = "libopenpower_dbus"

BBCLASSEXTEND += "native nativesdk"
