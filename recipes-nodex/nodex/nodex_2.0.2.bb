inherit cargo_bin

DEPENDS += " zlib"
do_compile[network] = "1"

SRC_URI += "git://git@github.com/nodecross/nodex.git;protocol=https;nobranch=1"
SRCREV = "7d6cfbac3aba77e1c7a706cac543048e4e6fb30b"
S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""

SRC_URI += " \
    file://0001-Migrate-aes-gcm-siv.patch \
"

LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327 \
"

SUMMARY = "Automate device security provisioning with edge intelligence."
HOMEPAGE = "https://nodecross.io"
LICENSE = "Apache-2.0"

INSANE_SKIP:${PN} += "already-stripped"

# TODO: Get rid of this workaround.
# This process fixes a bug when cargo compiles libgit2 to clone dependencies.
# It cannot find the host header files due to the cross compile wrapper.
# Only when libgit2 is compiled will the target header files be removed so that it can be compiled.
SRC_URI += "file://mycc"
export BUILD_CC = "${WORKDIR}/mycc"
