SRC_URI += "file://nodex"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

do_install:append() {
    install -d 644 ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/nodex ${D}${sysconfdir}/init.d/nodex
    install -d 644 ${D}${sysconfdir}/rc3.d/
    ln -sf ../init.d/nodex ${D}${sysconfdir}/rc5.d/S99nodex
    ln -sf ../init.d/nodex ${D}${sysconfdir}/rc5.d/K99nodex
}

FILES_${PN} = "${sysconfdir}/init.d"
